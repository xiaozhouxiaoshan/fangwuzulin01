package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.RentalContractEntity;
import com.entity.view.RentalContractView;

import com.service.RentalContractService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 合同信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@RestController
@RequestMapping("/rentalContract")
public class RentalContractController {
    @Autowired
    private RentalContractService rentalContractService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RentalContractEntity rentalContract, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tenant")) {
			rentalContract.setTenantming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("landlord")) {
			rentalContract.setLandlordzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RentalContractEntity> ew = new EntityWrapper<RentalContractEntity>();
		PageUtils page = rentalContractService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rentalContract), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RentalContractEntity rentalContract, HttpServletRequest request){
        EntityWrapper<RentalContractEntity> ew = new EntityWrapper<RentalContractEntity>();
		PageUtils page = rentalContractService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rentalContract), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RentalContractEntity rentalContract){
       	EntityWrapper<RentalContractEntity> ew = new EntityWrapper<RentalContractEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rentalContract, "rentalContract")); 
        return R.ok().put("data", rentalContractService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RentalContractEntity rentalContract){
        EntityWrapper< RentalContractEntity> ew = new EntityWrapper< RentalContractEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rentalContract, "rentalContract")); 
		RentalContractView rentalContractView =  rentalContractService.selectView(ew);
		return R.ok("查询合同信息成功").put("data", rentalContractView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RentalContractEntity rentalContract = rentalContractService.selectById(id);
        return R.ok().put("data", rentalContract);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RentalContractEntity rentalContract = rentalContractService.selectById(id);
        return R.ok().put("data", rentalContract);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RentalContractEntity rentalContract, HttpServletRequest request){
    	rentalContract.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rentalContract);
        rentalContractService.insert(rentalContract);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RentalContractEntity rentalContract, HttpServletRequest request){
    	rentalContract.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rentalContract);
        rentalContractService.insert(rentalContract);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RentalContractEntity rentalContract, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rentalContract);
        rentalContractService.updateById(rentalContract);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        rentalContractService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<RentalContractEntity> wrapper = new EntityWrapper<RentalContractEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("tenant")) {
			wrapper.eq("tenantming", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("landlord")) {
			wrapper.eq("landlordzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = rentalContractService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
