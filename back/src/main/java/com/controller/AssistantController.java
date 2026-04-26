package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.HouseRepairEntity;
import com.entity.HouseListingEntity;
import com.entity.RentalContractEntity;
import com.entity.RepairHandlingEntity;
import com.entity.TenantEntity;
import com.entity.ViewingAppointmentEntity;
import com.entity.LandlordEntity;
import com.service.HouseRepairService;
import com.service.HouseListingService;
import com.service.RentalContractService;
import com.service.RepairHandlingService;
import com.service.TenantService;
import com.service.ViewingAppointmentService;
import com.service.LandlordService;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 角色感知的租赁业务小助手。
 * 不依赖外部大模型，直接基于系统现有业务数据给出推荐和待办摘要。
 */
@RestController
@RequestMapping("/assistant")
public class AssistantController {

    @Autowired
    private HouseListingService houseListingService;

    @Autowired
    private ViewingAppointmentService viewingAppointmentService;

    @Autowired
    private RentalContractService rentalContractService;

    @Autowired
    private HouseRepairService houseRepairService;

    @Autowired
    private RepairHandlingService repairHandlingService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private LandlordService landlordService;

    @RequestMapping("/chat")
    public R chat(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        Object tableNameObj = request.getSession().getAttribute("tableName");
        Object usernameObj = request.getSession().getAttribute("username");
        Object roleObj = request.getSession().getAttribute("role");
        if (tableNameObj == null || usernameObj == null || roleObj == null) {
            return R.error(401, "请先登录");
        }

        String tableName = String.valueOf(tableNameObj);
        String username = String.valueOf(usernameObj);
        String role = String.valueOf(roleObj);
        String message = payload == null ? "" : StringUtils.defaultString(payload.get("message")).trim();

        Map<String, Object> data;
        if ("tenant".equals(tableName)) {
            data = tenantReply(message, username, role);
        } else if ("landlord".equals(tableName)) {
            data = landlordReply(message, username, role);
        } else {
            data = adminReply(message, role);
        }

        return R.ok().put("data", data);
    }

    private Map<String, Object> tenantReply(String message, String username, String role) {
        if (isHelp(message)) {
            return buildResponse(
                    role,
                    "租客助手",
                    "我可以帮你推荐房源，也可以汇总你的预约、合同和报修情况。你可以直接问我“推荐预算5000以内的房子”或“看看我的合同”。",
                    buildQuickCards(new String[][]{
                            {"看房推荐", "推荐预算5000以内的房源"},
                            {"预约情况", "帮我看看我的预约情况"},
                            {"租后服务", "帮我看看我的合同和报修"}
                    })
            );
        }

        if (containsAny(message, "预约")) {
            return buildTenantAppointmentReply(username, role);
        }
        if (containsAny(message, "合同")) {
            return buildTenantContractReply(username, role);
        }
        if (containsAny(message, "报修", "维修")) {
            return buildTenantRepairReply(username, role);
        }
        return buildTenantHouseReply(message, username, role);
    }

    private Map<String, Object> landlordReply(String message, String username, String role) {
        if (isHelp(message)) {
            return buildResponse(
                    role,
                    "房东助手",
                    "我可以帮你查看待审核预约、待跟进合同、房源数量和报修处理进度。你可以直接问我“看看我的待办”或“汇总我的报修”。",
                    buildQuickCards(new String[][]{
                            {"今日待办", "看看我的待办"},
                            {"预约审核", "汇总我的预约审核"},
                            {"报修处理", "汇总我的报修情况"}
                    })
            );
        }

        if (containsAny(message, "房源")) {
            return buildLandlordHouseReply(username, role);
        }
        if (containsAny(message, "预约")) {
            return buildLandlordAppointmentReply(username, role);
        }
        if (containsAny(message, "合同", "支付")) {
            return buildLandlordContractReply(username, role);
        }
        if (containsAny(message, "报修", "维修")) {
            return buildLandlordRepairReply(username, role);
        }
        return buildLandlordTodoReply(username, role);
    }

    private Map<String, Object> adminReply(String message, String role) {
        if (isHelp(message)) {
            return buildResponse(
                    role,
                    "管理助手",
                    "我可以帮你查看系统概览、待审核业务和报修进度。你可以直接问我“查看系统概览”或“统计待审核预约和合同”。",
                    buildQuickCards(new String[][]{
                            {"系统概览", "查看系统概览"},
                            {"待审核业务", "统计待审核预约和合同"},
                            {"报修统计", "汇总报修情况"}
                    })
            );
        }

        if (containsAny(message, "报修", "维修")) {
            return buildAdminRepairReply(role);
        }
        if (containsAny(message, "审核", "合同", "预约")) {
            return buildAdminPendingReply(role);
        }
        return buildAdminOverviewReply(role);
    }

    private Map<String, Object> buildTenantHouseReply(String message, String username, String role) {
        List<HouseListingEntity> houses = houseListingService.selectList(
                new EntityWrapper<HouseListingEntity>().eq("fangwuzhuangtai", "可租")
        );

        String houseType = detectHouseType(message);
        String xiaoqu = detectXiaoqu(message, houses);
        Integer budget = detectBudget(message);

        List<HouseListingEntity> filtered = new ArrayList<HouseListingEntity>();
        for (HouseListingEntity house : houses) {
            boolean matched = true;
            if (StringUtils.isNotBlank(houseType) && !houseType.equals(house.getHouseType())) {
                matched = false;
            }
            if (StringUtils.isNotBlank(xiaoqu) && !xiaoqu.equals(house.getXiaoqu())) {
                matched = false;
            }
            if (budget != null && containsAny(message, "预算", "以内", "以下", "不超过") && house.getYuezujiage() != null
                    && house.getYuezujiage() > budget) {
                matched = false;
            }
            if (matched) {
                filtered.add(house);
            }
        }

        if (filtered.isEmpty()) {
            filtered = houses;
        }

        final Integer finalBudget = budget;
        Collections.sort(filtered, new Comparator<HouseListingEntity>() {
            @Override
            public int compare(HouseListingEntity o1, HouseListingEntity o2) {
                int p1 = o1.getYuezujiage() == null ? Integer.MAX_VALUE : o1.getYuezujiage();
                int p2 = o2.getYuezujiage() == null ? Integer.MAX_VALUE : o2.getYuezujiage();
                if (finalBudget == null) {
                    return p1 - p2;
                }
                return Math.abs(p1 - finalBudget) - Math.abs(p2 - finalBudget);
            }
        });

        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(filtered.size(), 3);
        for (int i = 0; i < size; i++) {
            HouseListingEntity house = filtered.get(i);
            cards.add(buildCard(
                    house.getFangwumingcheng(),
                    house.getXiaoqu() + " | " + house.getHouseType() + " | " + safePrice(house.getYuezujiage()) + "元/月",
                    StringUtils.defaultIfBlank(house.getFangwusheshi(), "配套待补充")
            ));
        }

        long appointmentCount = viewingAppointmentService.selectCount(
                new EntityWrapper<ViewingAppointmentEntity>().eq("tenantming", username)
        );
        long contractCount = rentalContractService.selectCount(
                new EntityWrapper<RentalContractEntity>().eq("tenantming", username)
        );

        StringBuilder reply = new StringBuilder("我先按你的租房场景做了一轮筛选。");
        if (budget != null) {
            reply.append("当前识别到你的预算大约是").append(budget).append("元/月。");
        }
        if (StringUtils.isNotBlank(houseType)) {
            reply.append("你更关注").append(houseType).append("。");
        }
        if (StringUtils.isNotBlank(xiaoqu)) {
            reply.append("你提到了").append(xiaoqu).append("。");
        }
        reply.append("另外，你当前共有").append(appointmentCount).append("条预约记录，")
                .append(contractCount).append("条合同记录。");

        return buildResponse(role, "看房推荐", reply.toString(), cards);
    }

    private Map<String, Object> buildTenantAppointmentReply(String username, String role) {
        List<ViewingAppointmentEntity> appointments = viewingAppointmentService.selectList(
                new EntityWrapper<ViewingAppointmentEntity>().eq("tenantming", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(appointments.size(), 3);
        for (int i = 0; i < size; i++) {
            ViewingAppointmentEntity item = appointments.get(i);
            cards.add(buildCard(
                    item.getFangwumingcheng(),
                    "预约时间：" + formatDateTime(item.getYuyueshijian()),
                    "审核状态：" + defaultValue(item.getSfsh())
            ));
        }
        return buildResponse(role, "我的预约", "你当前共有" + appointments.size() + "条预约记录，下面是最近的预约情况。", cards);
    }

    private Map<String, Object> buildTenantContractReply(String username, String role) {
        List<RentalContractEntity> contracts = rentalContractService.selectList(
                new EntityWrapper<RentalContractEntity>().eq("tenantming", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(contracts.size(), 3);
        for (int i = 0; i < size; i++) {
            RentalContractEntity item = contracts.get(i);
            cards.add(buildCard(
                    defaultValue(item.getHetongbianhao()),
                    item.getFangwumingcheng() + " | 合同金额：" + defaultValue(item.getHetongjine()),
                    "审核：" + defaultValue(item.getSfsh()) + " | 支付：" + defaultValue(item.getIspay())
            ));
        }
        return buildResponse(role, "我的合同", "你当前共有" + contracts.size() + "条合同记录，下面是最近的合同信息。", cards);
    }

    private Map<String, Object> buildTenantRepairReply(String username, String role) {
        List<HouseRepairEntity> repairs = houseRepairService.selectList(
                new EntityWrapper<HouseRepairEntity>().eq("tenantming", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(repairs.size(), 3);
        for (int i = 0; i < size; i++) {
            HouseRepairEntity item = repairs.get(i);
            cards.add(buildCard(
                    defaultValue(item.getBaoxiumingcheng()),
                    item.getFangwumingcheng() + " | 报修日期：" + formatDate(item.getBaoxiuriqi()),
                    "审核状态：" + defaultValue(item.getSfsh())
            ));
        }
        return buildResponse(role, "我的报修", "你当前共有" + repairs.size() + "条报修记录，下面是最近的处理情况。", cards);
    }

    private Map<String, Object> buildLandlordTodoReply(String username, String role) {
        long houseCount = houseListingService.selectCount(
                new EntityWrapper<HouseListingEntity>().eq("landlordzhanghao", username)
        );
        long pendingAppointments = viewingAppointmentService.selectCount(
                new EntityWrapper<ViewingAppointmentEntity>().eq("landlordzhanghao", username).eq("sfsh", "否")
        );
        long pendingContracts = rentalContractService.selectCount(
                new EntityWrapper<RentalContractEntity>().eq("landlordzhanghao", username).eq("sfsh", "否")
        );
        long unpaidContracts = rentalContractService.selectCount(
                new EntityWrapper<RentalContractEntity>().eq("landlordzhanghao", username).eq("ispay", "未支付")
        );
        long unfinishedRepairs = repairHandlingService.selectCount(
                new EntityWrapper<RepairHandlingEntity>().eq("landlordzhanghao", username).ne("weixiujindu", "已完成")
        );

        List<Map<String, String>> cards = buildQuickCards(new String[][]{
                {"房源总数", String.valueOf(houseCount)},
                {"待审核预约", String.valueOf(pendingAppointments)},
                {"待审核合同", String.valueOf(pendingContracts)},
                {"待支付合同", String.valueOf(unpaidContracts)},
                {"未完成维修", String.valueOf(unfinishedRepairs)}
        });

        String reply = "你当前最需要关注的是预约审核、合同支付和维修进度。我已经帮你汇总了主要待办。";
        return buildResponse(role, "房东待办", reply, cards);
    }

    private Map<String, Object> buildLandlordHouseReply(String username, String role) {
        List<HouseListingEntity> houses = houseListingService.selectList(
                new EntityWrapper<HouseListingEntity>().eq("landlordzhanghao", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(houses.size(), 3);
        for (int i = 0; i < size; i++) {
            HouseListingEntity item = houses.get(i);
            cards.add(buildCard(
                    item.getFangwumingcheng(),
                    item.getXiaoqu() + " | " + item.getHouseType(),
                    "状态：" + defaultValue(item.getFangwuzhuangtai()) + " | 月租：" + safePrice(item.getYuezujiage()) + "元"
            ));
        }
        return buildResponse(role, "我的房源", "你当前共发布了" + houses.size() + "套房源，下面是最近的房源信息。", cards);
    }

    private Map<String, Object> buildLandlordAppointmentReply(String username, String role) {
        List<ViewingAppointmentEntity> appointments = viewingAppointmentService.selectList(
                new EntityWrapper<ViewingAppointmentEntity>().eq("landlordzhanghao", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(appointments.size(), 3);
        for (int i = 0; i < size; i++) {
            ViewingAppointmentEntity item = appointments.get(i);
            cards.add(buildCard(
                    item.getFangwumingcheng(),
                    "租客：" + defaultValue(item.getXingming()) + " | 预约时间：" + formatDateTime(item.getYuyueshijian()),
                    "审核状态：" + defaultValue(item.getSfsh())
            ));
        }
        return buildResponse(role, "预约审核", "你当前共有" + appointments.size() + "条预约记录，下面是最近的预约情况。", cards);
    }

    private Map<String, Object> buildLandlordContractReply(String username, String role) {
        List<RentalContractEntity> contracts = rentalContractService.selectList(
                new EntityWrapper<RentalContractEntity>().eq("landlordzhanghao", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(contracts.size(), 3);
        for (int i = 0; i < size; i++) {
            RentalContractEntity item = contracts.get(i);
            cards.add(buildCard(
                    defaultValue(item.getHetongbianhao()),
                    item.getFangwumingcheng() + " | 租客：" + defaultValue(item.getTenantming()),
                    "审核：" + defaultValue(item.getSfsh()) + " | 支付：" + defaultValue(item.getIspay())
            ));
        }
        return buildResponse(role, "合同跟进", "你当前共有" + contracts.size() + "条合同记录，下面是最近的合同进度。", cards);
    }

    private Map<String, Object> buildLandlordRepairReply(String username, String role) {
        List<RepairHandlingEntity> repairs = repairHandlingService.selectList(
                new EntityWrapper<RepairHandlingEntity>().eq("landlordzhanghao", username)
        );
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        int size = Math.min(repairs.size(), 3);
        for (int i = 0; i < size; i++) {
            RepairHandlingEntity item = repairs.get(i);
            cards.add(buildCard(
                    defaultValue(item.getBaoxiumingcheng()),
                    item.getFangwumingcheng() + " | 更新日期：" + formatDate(item.getGengxinriqi()),
                    "维修进度：" + defaultValue(item.getWeixiujindu())
            ));
        }
        return buildResponse(role, "报修处理", "你当前共有" + repairs.size() + "条维修处理记录，下面是最近的报修进度。", cards);
    }

    private Map<String, Object> buildAdminOverviewReply(String role) {
        long userCount = tenantService.selectCount(new EntityWrapper<TenantEntity>());
        long landlordCount = landlordService.selectCount(new EntityWrapper<LandlordEntity>());
        long houseCount = houseListingService.selectCount(new EntityWrapper<HouseListingEntity>());
        long appointmentCount = viewingAppointmentService.selectCount(new EntityWrapper<ViewingAppointmentEntity>());
        long contractCount = rentalContractService.selectCount(new EntityWrapper<RentalContractEntity>());
        long repairCount = houseRepairService.selectCount(new EntityWrapper<HouseRepairEntity>());

        List<Map<String, String>> cards = buildQuickCards(new String[][]{
                {"租客总数", String.valueOf(userCount)},
                {"房东总数", String.valueOf(landlordCount)},
                {"房源总数", String.valueOf(houseCount)},
                {"预约总数", String.valueOf(appointmentCount)},
                {"合同总数", String.valueOf(contractCount)},
                {"报修总数", String.valueOf(repairCount)}
        });
        return buildResponse(role, "系统概览", "我已按当前业务数据汇总了系统核心指标，便于你快速查看平台运行情况。", cards);
    }

    private Map<String, Object> buildAdminPendingReply(String role) {
        long pendingAppointments = viewingAppointmentService.selectCount(
                new EntityWrapper<ViewingAppointmentEntity>().eq("sfsh", "否")
        );
        long pendingContracts = rentalContractService.selectCount(
                new EntityWrapper<RentalContractEntity>().eq("sfsh", "否")
        );
        long unpaidContracts = rentalContractService.selectCount(
                new EntityWrapper<RentalContractEntity>().eq("ispay", "未支付")
        );
        List<Map<String, String>> cards = buildQuickCards(new String[][]{
                {"待审核预约", String.valueOf(pendingAppointments)},
                {"待审核合同", String.valueOf(pendingContracts)},
                {"未支付合同", String.valueOf(unpaidContracts)}
        });
        return buildResponse(role, "待审核业务", "我帮你把当前待审核和待支付的业务集中列出来了。", cards);
    }

    private Map<String, Object> buildAdminRepairReply(String role) {
        long repairApplyCount = houseRepairService.selectCount(new EntityWrapper<HouseRepairEntity>());
        long unfinishedRepair = repairHandlingService.selectCount(
                new EntityWrapper<RepairHandlingEntity>().ne("weixiujindu", "已完成")
        );
        long finishedRepair = repairHandlingService.selectCount(
                new EntityWrapper<RepairHandlingEntity>().eq("weixiujindu", "已完成")
        );
        List<Map<String, String>> cards = buildQuickCards(new String[][]{
                {"报修申请", String.valueOf(repairApplyCount)},
                {"处理中维修", String.valueOf(unfinishedRepair)},
                {"已完成维修", String.valueOf(finishedRepair)}
        });
        return buildResponse(role, "报修统计", "这里是当前报修与维修处理的整体情况，你可以据此安排后续管理工作。", cards);
    }

    private Map<String, Object> buildResponse(String role, String title, String reply, List<Map<String, String>> cards) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("role", role);
        data.put("title", title);
        data.put("reply", reply);
        data.put("cards", cards);
        data.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        return data;
    }

    private List<Map<String, String>> buildQuickCards(String[][] rows) {
        List<Map<String, String>> cards = new ArrayList<Map<String, String>>();
        for (String[] row : rows) {
            cards.add(buildCard(row[0], row[1], ""));
        }
        return cards;
    }

    private Map<String, String> buildCard(String title, String subtitle, String tag) {
        Map<String, String> card = new HashMap<String, String>();
        card.put("title", defaultValue(title));
        card.put("subtitle", defaultValue(subtitle));
        card.put("tag", defaultValue(tag));
        return card;
    }

    private boolean isHelp(String message) {
        return StringUtils.isBlank(message) || containsAny(message, "帮助", "你能做什么", "怎么用", "你好");
    }

    private boolean containsAny(String text, String... words) {
        if (StringUtils.isBlank(text)) {
            return false;
        }
        for (String word : words) {
            if (text.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private Integer detectBudget(String message) {
        if (StringUtils.isBlank(message)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d{3,6})").matcher(message);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return null;
    }

    private String detectHouseType(String message) {
        String[] types = {"一室一厅", "两室一厅", "两室两厅", "三室一厅", "三室两厅", "四室两厅", "3房1厅"};
        for (String type : types) {
            if (StringUtils.contains(message, type)) {
                return type;
            }
        }
        return "";
    }

    private String detectXiaoqu(String message, List<HouseListingEntity> houses) {
        for (HouseListingEntity house : houses) {
            if (StringUtils.isNotBlank(house.getXiaoqu()) && StringUtils.contains(message, house.getXiaoqu())) {
                return house.getXiaoqu();
            }
        }
        return "";
    }

    private String formatDate(Date date) {
        if (date == null) {
            return "未填写";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    private String formatDateTime(Date date) {
        if (date == null) {
            return "未填写";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    private String defaultValue(String value) {
        return StringUtils.defaultIfBlank(value, "暂无");
    }

    private String safePrice(Integer value) {
        return value == null ? "0" : String.valueOf(value);
    }
}
