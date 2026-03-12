/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `zhihuifangwuzulin`;
CREATE DATABASE IF NOT EXISTS `zhihuifangwuzulin` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zhihuifangwuzulin`;

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

DELETE FROM `config`;
INSERT INTO `config` (`id`, `name`, `value`) VALUES
	(1, 'picture1', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855528584.jpg'),
	(2, 'picture2', 'http://localhost:8080/zhihuifangwuzulin/upload/picture2.jpg'),
	(3, 'picture3', 'http://localhost:8080/zhihuifangwuzulin/upload/picture3.jpg'),
	(6, 'homepage', NULL);

DROP TABLE IF EXISTS `discussfangwuxinxi`;
CREATE TABLE IF NOT EXISTS `discussfangwuxinxi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb3 COMMENT='房屋信息评论表';

DELETE FROM `discussfangwuxinxi`;
INSERT INTO `discussfangwuxinxi` (`id`, `addtime`, `refid`, `userid`, `content`, `reply`) VALUES
	(141, '2026-03-09 10:46:53', 41, 11, '房间采光不错，周边地铁方便。', '感谢反馈，欢迎随时预约看房。'),
	(142, '2026-03-09 10:46:53', 42, 12, '小区环境安静，适合长期居住。', '谢谢认可，合同可按年签。'),
	(143, '2026-03-09 10:46:53', 43, 13, '户型方正，实际面积和描述一致。', '已核实，欢迎再次带家人看房。'),
	(144, '2026-03-09 10:46:53', 44, 14, '中介带看很准时，体验不错。', '已收到，后续问题可直接联系我。'),
	(145, '2026-03-09 10:46:53', 45, 15, '厨房和卫生间都比较新。', '感谢建议，近期会再做保洁。'),
	(146, '2026-03-09 10:46:53', 46, 16, '楼层高视野好，价格也合理。', '谢谢支持，可协商入住时间。');

DROP TABLE IF EXISTS `discusswoyaodangfangzhu`;
CREATE TABLE IF NOT EXISTS `discusswoyaodangfangzhu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3 COMMENT='我要当房主评论表';

DELETE FROM `discusswoyaodangfangzhu`;
INSERT INTO `discusswoyaodangfangzhu` (`id`, `addtime`, `refid`, `userid`, `content`, `reply`) VALUES
	(151, '2026-03-09 10:46:53', 101, 11, '房间采光不错，周边地铁方便。', '感谢反馈，欢迎随时预约看房。'),
	(152, '2026-03-09 10:46:53', 102, 12, '小区环境安静，适合长期居住。', '谢谢认可，合同可按年签。'),
	(153, '2026-03-09 10:46:53', 103, 13, '户型方正，实际面积和描述一致。', '已核实，欢迎再次带家人看房。'),
	(154, '2026-03-09 10:46:53', 104, 14, '中介带看很准时，体验不错。', '已收到，后续问题可直接联系我。'),
	(155, '2026-03-09 10:46:53', 105, 15, '厨房和卫生间都比较新。', '感谢建议，近期会再做保洁。'),
	(156, '2026-03-09 10:46:53', 106, 16, '楼层高视野好，价格也合理。', '谢谢支持，可协商入住时间。');

DROP TABLE IF EXISTS `fangwubaoxiu`;
CREATE TABLE IF NOT EXISTS `fangwubaoxiu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hetongbianhao` varchar(200) DEFAULT NULL COMMENT '合同编号',
  `fangwumingcheng` varchar(200) DEFAULT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `baoxiumingcheng` varchar(200) DEFAULT NULL COMMENT '报修名称',
  `leixing` varchar(200) DEFAULT NULL COMMENT '类型',
  `baoxiuneirong` varchar(200) DEFAULT NULL COMMENT '报修内容',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `baoxiuriqi` date DEFAULT NULL COMMENT '报修日期',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `fangzhuxingming` varchar(200) DEFAULT NULL COMMENT '房主姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614856006266 DEFAULT CHARSET=utf8mb3 COMMENT='房屋报修';

DELETE FROM `fangwubaoxiu`;
INSERT INTO `fangwubaoxiu` (`id`, `addtime`, `hetongbianhao`, `fangwumingcheng`, `fangwuleixing`, `xiaoqu`, `baoxiumingcheng`, `leixing`, `baoxiuneirong`, `tupian`, `baoxiuriqi`, `fangzhuzhanghao`, `fangzhuxingming`, `yonghuming`, `lianxidianhua`, `sfsh`, `shhf`) VALUES
	(71, '2026-03-01 10:46:53', 'HT2026-0001', '湖景雅苑1栋1201', '一室一厅', '湖景雅苑', '卫生间漏水', '水工', '洗手台下方渗水，地面潮湿', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian1.jpg', '2026-03-01', 'landlord_zhang', '张明', 'tenant_lin', '13900010001', '是', ''),
	(72, '2026-03-02 10:46:53', 'HT2026-0002', '星河湾2期8栋502', '两室一厅', '星河湾二期', '厨房水龙头松动', '水工', '水龙头接口渗水，需更换密封圈', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian2.jpg', '2026-03-02', 'landlord_li', '李娜', 'tenant_zhou', '13900010002', '是', ''),
	(73, '2026-03-03 10:46:53', 'HT2026-0003', '金域蓝湾3栋1802', '两室两厅', '金域蓝湾', '卧室灯具不亮', '电工', '主卧吸顶灯无法开启', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian3.jpg', '2026-03-03', 'landlord_wang', '王强', 'tenant_he', '13900010003', '是', ''),
	(74, '2026-03-04 10:46:53', 'HT2026-0004', '华都花园B座1003', '三室一厅', '华都花园', '空调制冷不足', '电工', '客厅空调运行但不制冷', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian4.jpg', '2026-03-04', 'landlord_zhao', '赵敏', 'tenant_wu', '13900010004', '是', ''),
	(75, '2026-03-05 10:46:53', 'HT2026-0005', '城市春天5栋902', '三室两厅', '城市春天', '阳台门轨道卡顿', '木工', '推拉门滑动困难并有异响', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian5.jpg', '2026-03-05', 'landlord_chen', '陈凯', 'tenant_ma', '13900010005', '是', ''),
	(76, '2026-03-06 10:46:53', 'HT2026-0006', '云顶公馆6栋1501', '四室两厅', '云顶公馆', '热水器点火异常', '电工', '热水器偶发无法点火', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwubaoxiu_tupian6.jpg', '2026-03-06', 'landlord_sun', '孙悦', 'tenant_qian', '13900010006', '是', ''),
	(1614856006265, '2026-03-07 11:06:46', 'HT2026-0007', '新记家园605房', '3房1厅', '新记家园', '下水管堵塞', '水工', '浴室下水管堵了', 'http://localhost:8080/zhihuifangwuzulin/upload/1614856003509.jpg', '2026-03-07', 'landlord_zhang_old', '张明', 'tenant_chenyi', '12312312312', '是', '已安排当晚18:30上门维修');

DROP TABLE IF EXISTS `fangwuleixing`;
CREATE TABLE IF NOT EXISTS `fangwuleixing` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fangwuleixing` (`fangwuleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855386784 DEFAULT CHARSET=utf8mb3 COMMENT='房屋类型';

DELETE FROM `fangwuleixing`;
INSERT INTO `fangwuleixing` (`id`, `addtime`, `fangwuleixing`) VALUES
	(31, '2021-03-04 10:46:53', '一室一厅'),
	(32, '2021-03-04 10:46:53', '两室一厅'),
	(33, '2021-03-04 10:46:53', '两室两厅'),
	(34, '2021-03-04 10:46:53', '三室一厅'),
	(35, '2021-03-04 10:46:53', '三室两厅'),
	(36, '2021-03-04 10:46:53', '四室两厅'),
	(1614855386783, '2021-03-04 10:56:25', '3房1厅');

DROP TABLE IF EXISTS `fangwupingjia`;
CREATE TABLE IF NOT EXISTS `fangwupingjia` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hetongbianhao` varchar(200) DEFAULT NULL COMMENT '合同编号',
  `fangwumingcheng` varchar(200) DEFAULT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `pingfen` varchar(200) DEFAULT NULL COMMENT '评分',
  `pingjianeirong` longtext COMMENT '评价内容',
  `pingjiariqi` date DEFAULT NULL COMMENT '评价日期',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614856023366 DEFAULT CHARSET=utf8mb3 COMMENT='房屋评价';

DELETE FROM `fangwupingjia`;
INSERT INTO `fangwupingjia` (`id`, `addtime`, `hetongbianhao`, `fangwumingcheng`, `fangwuleixing`, `xiaoqu`, `pingfen`, `pingjianeirong`, `pingjiariqi`, `fangzhuzhanghao`, `yonghuming`, `lianxidianhua`, `sfsh`, `shhf`) VALUES
	(91, '2026-03-04 10:46:53', 'HT2026-0001', '湖景雅苑1栋1201', '一室一厅', '湖景雅苑', '5', '房屋整洁，沟通顺畅，推荐。', '2026-03-04', 'landlord_zhang', 'tenant_lin', '13900010001', '是', ''),
	(92, '2026-03-04 10:46:53', 'HT2026-0002', '星河湾2期8栋502', '两室一厅', '星河湾二期', '4', '交通便利，入住体验好。', '2026-03-04', 'landlord_li', 'tenant_zhou', '13900010002', '是', ''),
	(93, '2026-03-04 10:46:53', 'HT2026-0003', '金域蓝湾3栋1802', '两室两厅', '金域蓝湾', '5', '配套齐全，性价比高。', '2026-03-04', 'landlord_wang', 'tenant_he', '13900010003', '是', ''),
	(94, '2026-03-04 10:46:53', 'HT2026-0004', '华都花园B座1003', '三室一厅', '华都花园', '4', '房东响应及时，处理问题快。', '2026-03-04', 'landlord_zhao', 'tenant_wu', '13900010004', '是', ''),
	(95, '2026-03-04 10:46:53', 'HT2026-0005', '城市春天5栋902', '三室两厅', '城市春天', '5', '采光好，居住舒适。', '2026-03-04', 'landlord_chen', 'tenant_ma', '13900010005', '是', ''),
	(96, '2026-03-04 10:46:53', 'HT2026-0006', '云顶公馆6栋1501', '四室两厅', '云顶公馆', '5', '整体满意，后续会续租。', '2026-03-04', 'landlord_sun', 'tenant_qian', '13900010006', '是', ''),
	(1614856023365, '2026-03-04 11:07:03', 'HT2026-0007', '新记家园605房', '3房1厅', '新记家园', '5', '采光和通风都不错，入住体验较好。', '2026-03-04', 'landlord_zhang_old', 'tenant_chenyi', '12312312312', '是', '感谢反馈，欢迎继续入住。');

DROP TABLE IF EXISTS `fangwuxinxi`;
CREATE TABLE IF NOT EXISTS `fangwuxinxi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  `tupian` varchar(200) NOT NULL COMMENT '图片',
  `zulinfangshi` varchar(200) DEFAULT NULL COMMENT '租赁方式',
  `chaoxianglouceng` varchar(200) DEFAULT NULL COMMENT '朝向楼层',
  `mianji` varchar(200) DEFAULT NULL COMMENT '面积',
  `fangwuzhuangtai` varchar(200) DEFAULT NULL COMMENT '房屋状态',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `xiangxidizhi` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `yuezujiage` int DEFAULT NULL COMMENT '月租价格',
  `yajin` int DEFAULT NULL COMMENT '押金',
  `fangwusheshi` varchar(200) DEFAULT NULL COMMENT '房屋设施',
  `fangwuxiangqing` longtext COMMENT '房屋详情',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `fangzhuxingming` varchar(200) DEFAULT NULL COMMENT '房主姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855484230 DEFAULT CHARSET=utf8mb3 COMMENT='房屋信息';

DELETE FROM `fangwuxinxi`;
INSERT INTO `fangwuxinxi` (`id`, `addtime`, `fangwumingcheng`, `fangwuleixing`, `tupian`, `zulinfangshi`, `chaoxianglouceng`, `mianji`, `fangwuzhuangtai`, `xiaoqu`, `xiangxidizhi`, `yuezujiage`, `yajin`, `fangwusheshi`, `fangwuxiangqing`, `faburiqi`, `fangzhuzhanghao`, `fangzhuxingming`) VALUES
	(41, '2026-03-05 10:46:53', '湖景雅苑1栋1201', '一室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwuxinxi_tupian1.jpg', '整租', '朝南 高层', '45平', '可租', '湖景雅苑', '浦东新区梅花路88号', 3200, 3200, '空调、洗衣机、冰箱', '近地铁2号线，拎包入住', '2026-03-05', 'landlord_zhang', '张明'),
	(42, '2026-03-05 10:46:53', '星河湾2期8栋502', '两室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855060611.jpg', '整租', '东南 中层', '68平', '可租', '星河湾二期', '闵行区都会路266号', 4800, 4800, '空调、冰箱、燃气灶', '<p>小区安静，适合上班族</p>', '2026-03-05', 'landlord_li', '李娜'),
	(43, '2026-03-05 10:46:53', '金域蓝湾3栋1802', '两室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwuxinxi_tupian3.jpg', '整租', '南北 高层', '89平', '可租', '金域蓝湾', '徐汇区漕溪北路520号', 6200, 6200, '全屋家电、独立卫浴', '双阳台，采光通风优秀', '2026-03-05', 'landlord_wang', '王强'),
	(44, '2026-03-05 10:46:53', '华都花园B座1003', '三室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855071690.jpg', '整租', '朝东 低层', '96平', '可租', '华都花园', '长宁区天山路188号', 7200, 7200, '全屋家电、阳台、地暖', '<p>学区房，生活配套完善</p>', '2026-03-05', 'landlord_zhao', '赵敏'),
	(45, '2026-03-05 10:46:53', '城市春天5栋902', '三室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwuxinxi_tupian5.jpg', '整租', '西南 中高层', '118平', '可租', '城市春天', '宝山区顾村公园路66号', 8800, 8800, '品牌家电、车位可租', '南北通透，带储物间', '2026-03-05', 'landlord_chen', '陈凯'),
	(46, '2026-03-05 10:46:53', '云顶公馆6栋1501', '四室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855082369.jpg', '整租', '南北 顶层', '136平', '可租', '云顶公馆', '杨浦区国权路399号', 10800, 10800, '智能家居、中央空调', '<p>高层视野好，精装修</p>', '2026-03-05', 'landlord_sun', '孙悦'),
	(1614855484229, '2026-03-05 10:58:03', '新记家园605房', '3房1厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855416340.jpg', '整租', '南北 共8层', '90平', '可租', '新记家园', '朝阳区太阳宫中路16号', 2000, 2000, '设施齐全', '<p>设施齐全，采光极好</p><p><img src="http://localhost:8080/zhihuifangwuzulin/upload/1614855482288.jpg"></p>', '2026-03-05', 'landlord_zhang_old', '张明');

DROP TABLE IF EXISTS `fangzhu`;
CREATE TABLE IF NOT EXISTS `fangzhu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangzhuzhanghao` varchar(200) NOT NULL COMMENT '房主账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `fangzhuxingming` varchar(200) NOT NULL COMMENT '房主姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fangzhuzhanghao` (`fangzhuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855337501 DEFAULT CHARSET=utf8mb3 COMMENT='房主';

DELETE FROM `fangzhu`;
INSERT INTO `fangzhu` (`id`, `addtime`, `fangzhuzhanghao`, `mima`, `fangzhuxingming`, `xingbie`, `touxiang`, `shouji`, `shenfenzheng`) VALUES
	(21, '2021-03-04 10:46:53', 'landlord_zhang', '123456', '张明', '男', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang1.jpg', '13823888881', '440300199101010001'),
	(22, '2021-03-04 10:46:53', 'landlord_li', '123456', '李娜', '女', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang2.jpg', '13823888882', '440300199202020002'),
	(23, '2021-03-04 10:46:53', 'landlord_wang', '123456', '王强', '男', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang3.jpg', '13823888883', '440300199303030003'),
	(24, '2021-03-04 10:46:53', 'landlord_zhao', '123456', '赵敏', '女', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang4.jpg', '13823888884', '440300199404040004'),
	(25, '2021-03-04 10:46:53', 'landlord_chen', '123456', '陈凯', '男', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang5.jpg', '13823888885', '440300199505050005'),
	(26, '2021-03-04 10:46:53', 'landlord_sun', '123456', '孙悦', '女', 'http://localhost:8080/zhihuifangwuzulin/upload/fangzhu_touxiang6.jpg', '13823888886', '440300199606060006'),
	(1614855337500, '2021-03-04 10:55:37', 'landlord_zhang_old', '123456', '张明', '男', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855356133.jpg', '12312312312', '123456789789456123');

DROP TABLE IF EXISTS `hetongxinxi`;
CREATE TABLE IF NOT EXISTS `hetongxinxi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hetongbianhao` varchar(200) DEFAULT NULL COMMENT '合同编号',
  `fangwumingcheng` varchar(200) DEFAULT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `yuezujiage` varchar(200) DEFAULT NULL COMMENT '月租价格',
  `zuyongyueshu` varchar(200) DEFAULT NULL COMMENT '租用月数',
  `zuyongjine` int DEFAULT NULL COMMENT '租用金额',
  `yajin` int DEFAULT NULL COMMENT '押金',
  `fangzuzhuangtai` varchar(200) DEFAULT NULL COMMENT '房租状态',
  `hetongjine` varchar(200) DEFAULT NULL COMMENT '合同金额',
  `hetongneirong` varchar(200) DEFAULT NULL COMMENT '合同内容',
  `shengxiaori` date DEFAULT NULL COMMENT '生效日',
  `youxianqizhi` date DEFAULT NULL COMMENT '有限期至',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `fangzhuxingming` varchar(200) DEFAULT NULL COMMENT '房主姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hetongbianhao` (`hetongbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855849545 DEFAULT CHARSET=utf8mb3 COMMENT='合同信息';

DELETE FROM `hetongxinxi`;
INSERT INTO `hetongxinxi` (`id`, `addtime`, `hetongbianhao`, `fangwumingcheng`, `fangwuleixing`, `xiaoqu`, `yuezujiage`, `zuyongyueshu`, `zuyongjine`, `yajin`, `fangzuzhuangtai`, `hetongjine`, `hetongneirong`, `shengxiaori`, `youxianqizhi`, `yonghuming`, `lianxidianhua`, `fangzhuzhanghao`, `fangzhuxingming`, `sfsh`, `shhf`, `ispay`) VALUES
	(61, '2025-03-04 10:46:53', 'HT2026-0001', '湖景雅苑1栋1201', '一室一厅', '湖景雅苑', '3200', '12', 38400, 3200, '已退租', '41600', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-03-04', '2026-03-04', 'tenant_lin', '13900010001', 'landlord_zhang', '张明', '是', '审核通过', '已支付'),
	(62, '2025-09-04 10:46:53', 'HT2026-0002', '星河湾2期8栋502', '两室一厅', '星河湾二期', '4800', '6', 28800, 4800, '已退租', '33600', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-09-04', '2026-03-04', 'tenant_zhou', '13900010002', 'landlord_li', '李娜', '是', '审核通过', '已支付'),
	(63, '2025-03-04 10:46:53', 'HT2026-0003', '金域蓝湾3栋1802', '两室两厅', '金域蓝湾', '6200', '12', 74400, 6200, '已退租', '80600', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-03-04', '2026-03-04', 'tenant_he', '13900010003', 'landlord_wang', '王强', '是', '审核通过', '已支付'),
	(64, '2025-03-04 10:46:53', 'HT2026-0004', '华都花园B座1003', '三室一厅', '华都花园', '7200', '12', 86400, 7200, '已退租', '93600', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-03-04', '2026-03-04', 'tenant_wu', '13900010004', 'landlord_zhao', '赵敏', '是', '审核通过', '已支付'),
	(65, '2024-03-04 10:46:53', 'HT2026-0005', '城市春天5栋902', '三室两厅', '城市春天', '8800', '24', 211200, 8800, '已退租', '220000', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2024-03-04', '2026-03-04', 'tenant_ma', '13900010005', 'landlord_chen', '陈凯', '是', '审核通过', '已支付'),
	(66, '2025-03-04 10:46:53', 'HT2026-0006', '云顶公馆6栋1501', '四室两厅', '云顶公馆', '10800', '12', 129600, 10800, '已退租', '140400', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-03-04', '2026-03-04', 'tenant_qian', '13900010006', 'landlord_sun', '孙悦', '是', '审核通过', '已支付'),
	(1614855849544, '2025-03-04 11:04:09', 'HT2026-0007', '新记家园605房', '3房1厅', '新记家园', '2000', '12', 24000, 2000, '已退租', '26000', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855836417.doc', '2025-03-04', '2026-03-04', 'tenant_chenyi', '12312312312', 'landlord_zhang_old', '张明', '是', '双方已确认条款', '已支付');

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '留言人id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '留言内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1703250291716 DEFAULT CHARSET=utf8mb3 COMMENT='留言板';

DELETE FROM `messages`;
INSERT INTO `messages` (`id`, `addtime`, `userid`, `username`, `content`, `reply`) VALUES
	(131, '2026-03-09 10:46:53', 11, 'tenant_lin', '周末可以看房吗？', '感谢反馈，欢迎随时预约看房。'),
	(132, '2026-03-09 10:46:53', 12, 'tenant_zhou', '押金支持分两次付吗？', '谢谢认可，合同可按年签。'),
	(133, '2026-03-09 10:46:53', 13, 'tenant_he', '可以养猫吗？', '已核实，欢迎再次带家人看房。'),
	(134, '2026-03-09 10:46:53', 14, 'tenant_wu', '附近有公交站吗？', '已收到，后续问题可直接联系我。'),
	(135, '2026-03-09 10:46:53', 15, 'tenant_ma', '合同最短签多久？', '感谢建议，近期会再做保洁。'),
	(136, '2026-03-09 10:46:53', 16, 'tenant_qian', '水电是民用还是商用？', '谢谢支持，可协商入住时间。'),
	(1614855688487, '2026-03-09 11:01:28', 1614855579738, 'tenant_chenyi', '请问雨花石小区有房源吗', '目前有两套可租，已私信你预约链接。'),
	(1703250291715, '2026-03-10 09:04:51', 11, 'tenant_lin', '合同到期后可以续租吗？', '可以，提前30天申请即可。');

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` varchar(200) NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855517964 DEFAULT CHARSET=utf8mb3 COMMENT='公告信息';

DELETE FROM `news`;
INSERT INTO `news` (`id`, `addtime`, `title`, `introduction`, `picture`, `content`) VALUES
	(121, '2026-03-06 10:46:53', '三月新房源上线通知', '本周新增6套优质整租房源', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture1.jpg', '平台已新增多套地铁沿线房源，支持在线咨询与预约。'),
	(122, '2026-03-06 10:46:53', '看房预约规则更新', '预约看房需提前24小时提交', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture2.jpg', '请在看房前一天完成预约并保持电话畅通，避免爽约。'),
	(123, '2026-03-06 10:46:53', '租客信用免押活动', '符合条件可申请押金减免', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture3.jpg', '信用分达标用户可申请部分押金减免，详情咨询客服。'),
	(124, '2026-03-06 10:46:53', '维修服务时间调整', '周末维修响应时间延长到22点', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture4.jpg', '维修工单默认24小时内响应，紧急故障优先处理。'),
	(125, '2026-03-06 10:46:53', '合同线上签署说明', '新增电子合同下载与签署入口', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture5.jpg', '签约完成后可在“合同信息”页面下载电子版合同。'),
	(126, '2026-03-06 10:46:53', '节假日客服值班安排', '春节期间服务时间安排说明', 'http://localhost:8080/zhihuifangwuzulin/upload/news_picture6.jpg', '节假日期间客服在线时间为9:00-18:00，紧急工单照常受理。'),
	(1614855517963, '2026-03-06 10:58:37', '租赁流程', '租赁须知', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855502003.jpg', '<p>租赁流程：</p><p>1. 在线预约看房</p><p>2. 线下验房并确认租金</p><p>3. 平台签署电子合同并支付费用</p>');

DROP TABLE IF EXISTS `storeup`;
CREATE TABLE IF NOT EXISTS `storeup` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '用户id',
  `refid` bigint DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1703250272426 DEFAULT CHARSET=utf8mb3 COMMENT='收藏表';

DELETE FROM `storeup`;
INSERT INTO `storeup` (`id`, `addtime`, `userid`, `refid`, `tablename`, `name`, `picture`) VALUES
	(1703250272425, '2026-03-10 13:04:32', 11, 41, 'fangwuxinxi', '湖景雅苑1栋1201', 'http://localhost:8080/zhihuifangwuzulin/upload/fangwuxinxi_tupian1.jpg');

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

DELETE FROM `token`;
INSERT INTO `token` (`id`, `userid`, `username`, `tablename`, `role`, `token`, `addtime`, `expiratedtime`) VALUES
	(1, 1, 'admin', 'users', '管理员', '7d86qwj0uodmxkquupozhdv7qpd4ulvu', '2026-03-10 09:00:00', '2026-03-17 09:00:00'),
	(2, 1614855337500, 'landlord_zhang_old', 'fangzhu', '房主', 'iumiceml897a25hpnecq2uudxw58sa5q', '2026-03-10 09:05:00', '2026-03-17 09:05:00'),
	(3, 1614855579738, 'tenant_chenyi', 'yonghu', '用户', 'hn33g6k468pem5wkdrksstimshbg7c6p', '2026-03-10 09:06:00', '2026-03-17 09:06:00'),
	(4, 11, 'tenant_lin', 'yonghu', '用户', 'jsonr4o2oaqkrhsmvfuspxfns5yfrymv', '2026-03-10 09:07:00', '2026-03-17 09:07:00'),
	(5, 21, 'landlord_zhang', 'fangzhu', '房主', 'thx8p7v6f0q2f88ootyibu7yslx1or7l', '2026-03-10 09:08:00', '2026-03-17 09:08:00');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';

DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `addtime`) VALUES
	(1, 'admin', '123456', '管理员', '2026-03-01 10:46:53');

DROP TABLE IF EXISTS `weixiuchuli`;
CREATE TABLE IF NOT EXISTS `weixiuchuli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) DEFAULT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `baoxiumingcheng` varchar(200) DEFAULT NULL COMMENT '报修名称',
  `leixing` varchar(200) DEFAULT NULL COMMENT '类型',
  `baoxiuriqi` varchar(200) DEFAULT NULL COMMENT '报修日期',
  `weixiufankui` varchar(200) DEFAULT NULL COMMENT '维修反馈',
  `weixiujindu` varchar(200) DEFAULT NULL COMMENT '维修进度',
  `gengxinriqi` date DEFAULT NULL COMMENT '更新日期',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `fangzhuxingming` varchar(200) DEFAULT NULL COMMENT '房主姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614856078292 DEFAULT CHARSET=utf8mb3 COMMENT='维修处理';

DELETE FROM `weixiuchuli`;
INSERT INTO `weixiuchuli` (`id`, `addtime`, `fangwumingcheng`, `fangwuleixing`, `baoxiumingcheng`, `leixing`, `baoxiuriqi`, `weixiufankui`, `weixiujindu`, `gengxinriqi`, `fangzhuzhanghao`, `fangzhuxingming`, `yonghuming`, `lianxidianhua`) VALUES
	(81, '2026-03-01 10:46:53', '湖景雅苑1栋1201', '一室一厅', '卫生间漏水', '水工', '2026-03-01', '已更换密封件，观察48小时', '维修中', '2026-03-02', 'landlord_zhang', '张明', 'tenant_lin', '13900010001'),
	(82, '2026-03-02 10:46:53', '星河湾2期8栋502', '两室一厅', '厨房水龙头松动', '水工', '2026-03-02', '已紧固并更换垫片', '维修中', '2026-03-03', 'landlord_li', '李娜', 'tenant_zhou', '13900010002'),
	(83, '2026-03-03 10:46:53', '金域蓝湾3栋1802', '两室两厅', '卧室灯具不亮', '电工', '2026-03-03', '已更换灯泡和镇流器', '维修中', '2026-03-04', 'landlord_wang', '王强', 'tenant_he', '13900010003'),
	(84, '2026-03-04 10:46:53', '华都花园B座1003', '三室一厅', '空调制冷不足', '电工', '2026-03-04', '已补充冷媒并清洗滤网', '维修中', '2026-03-05', 'landlord_zhao', '赵敏', 'tenant_wu', '13900010004'),
	(85, '2026-03-05 10:46:53', '城市春天5栋902', '三室两厅', '阳台门轨道卡顿', '木工', '2026-03-05', '已调整轨道并上润滑油', '维修中', '2026-03-06', 'landlord_chen', '陈凯', 'tenant_ma', '13900010005'),
	(86, '2026-03-06 10:46:53', '云顶公馆6栋1501', '四室两厅', '热水器点火异常', '电工', '2026-03-06', '已清理点火针并测试通过', '维修中', '2026-03-07', 'landlord_sun', '孙悦', 'tenant_qian', '13900010006'),
	(1614856078291, '2026-03-07 11:07:57', '新记家园605房', '3房1厅', '下水管堵塞', '水工', '2026-03-07', '已清理堵塞并更换弯头，排水恢复正常', '已完成', '2026-03-08', 'landlord_zhang_old', '张明', 'tenant_chenyi', '12312312312');

DROP TABLE IF EXISTS `woyaodangfangzhu`;
CREATE TABLE IF NOT EXISTS `woyaodangfangzhu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  `tupian` varchar(200) NOT NULL COMMENT '图片',
  `zulinfangshi` varchar(200) NOT NULL COMMENT '租赁方式',
  `chaoxianglouceng` varchar(200) DEFAULT NULL COMMENT '朝向楼层',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `mianji` varchar(200) DEFAULT NULL COMMENT '面积',
  `yuezujiage` int DEFAULT NULL COMMENT '月租价格',
  `fangwuxiangqing` longtext COMMENT '房屋详情',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855750985 DEFAULT CHARSET=utf8mb3 COMMENT='我要当房主';

DELETE FROM `woyaodangfangzhu`;
INSERT INTO `woyaodangfangzhu` (`id`, `addtime`, `fangwumingcheng`, `fangwuleixing`, `tupian`, `zulinfangshi`, `chaoxianglouceng`, `xiaoqu`, `mianji`, `yuezujiage`, `fangwuxiangqing`, `faburiqi`, `yonghuming`, `lianxidianhua`, `sfsh`, `shhf`) VALUES
	(101, '2026-03-02 10:46:53', '湖景雅苑1栋1201', '一室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/woyaodangfangzhu_tupian1.jpg', '整租', '朝南 高层', '湖景雅苑', '45平', 3200, '近地铁2号线，拎包入住', '2026-03-02', 'tenant_lin', '13900010001', '是', ''),
	(102, '2026-03-02 10:46:53', '星河湾2期8栋502', '两室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/woyaodangfangzhu_tupian2.jpg', '整租', '东南 中层', '星河湾二期', '68平', 4800, '小区安静，适合上班族', '2026-03-02', 'tenant_zhou', '13900010002', '是', ''),
	(103, '2026-03-02 10:46:53', '金域蓝湾3栋1802', '两室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/woyaodangfangzhu_tupian3.jpg', '整租', '南北 高层', '金域蓝湾', '89平', 6200, '双阳台，采光通风优秀', '2026-03-02', 'tenant_he', '13900010003', '是', ''),
	(104, '2026-03-02 10:46:53', '华都花园B座1003', '三室一厅', 'http://localhost:8080/zhihuifangwuzulin/upload/woyaodangfangzhu_tupian4.jpg', '整租', '朝东 低层', '华都花园', '96平', 7200, '学区房，生活配套完善', '2026-03-02', 'tenant_wu', '13900010004', '是', ''),
	(105, '2026-03-02 10:46:53', '城市春天5栋902', '三室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/woyaodangfangzhu_tupian5.jpg', '整租', '西南 中高层', '城市春天', '118平', 8800, '南北通透，带储物间', '2026-03-02', 'tenant_ma', '13900010005', '是', ''),
	(106, '2026-03-02 10:46:53', '云顶公馆6栋1501', '四室两厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855114406.jpg', '整租', '南北 顶层', '云顶公馆', '136平', 10800, '<p>高层视野好，精装修</p>', '2026-03-02', 'tenant_qian', '13900010006', '是', ''),
	(1614855750984, '2026-03-03 11:02:30', '雨花石604', '3房1厅', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855720959.jpg', '整租', '东南 中层', '雨花石', '60', 1000, '<p>采光好</p><p><img src="http://localhost:8080/zhihuifangwuzulin/upload/1614855748947.jpg"></p>', '2026-03-03', 'tenant_chenyi', '12312312312', '是', '信息完整，已通过审核。');

DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE IF NOT EXISTS `yonghu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) NOT NULL COMMENT '用户名',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `zhiye` varchar(200) DEFAULT NULL COMMENT '职业',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuming` (`yonghuming`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855579739 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

DELETE FROM `yonghu`;
INSERT INTO `yonghu` (`id`, `addtime`, `yonghuming`, `mima`, `xingming`, `touxiang`, `xingbie`, `zhiye`, `lianxidianhua`, `shenfenzheng`) VALUES
	(11, '2021-03-04 10:46:53', 'tenant_lin', '123456', '林雨桐', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang1.jpg', '女', '产品经理', '13900010001', '440300199101010001'),
	(12, '2021-03-04 10:46:53', 'tenant_zhou', '123456', '周子轩', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang2.jpg', '男', '软件工程师', '13900010002', '440300199202020002'),
	(13, '2021-03-04 10:46:53', 'tenant_he', '123456', '何晨曦', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang3.jpg', '男', '设计师', '13900010003', '440300199303030003'),
	(14, '2021-03-04 10:46:53', 'tenant_wu', '123456', '吴思远', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang4.jpg', '男', '财务专员', '13900010004', '440300199404040004'),
	(15, '2021-03-04 10:46:53', 'tenant_ma', '123456', '马可欣', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang5.jpg', '女', '教师', '13900010005', '440300199505050005'),
	(16, '2021-03-04 10:46:53', 'tenant_qian', '123456', '钱嘉乐', 'http://localhost:8080/zhihuifangwuzulin/upload/yonghu_touxiang6.jpg', '男', '医生', '13900010006', '440300199606060006'),
	(1614855579738, '2021-03-04 10:59:39', 'tenant_chenyi', '123456', '陈一', 'http://localhost:8080/zhihuifangwuzulin/upload/1614855594396.jpg', '女', 'IT', '12312312312', '123456789789456123');

DROP TABLE IF EXISTS `yuyuekanfang`;
CREATE TABLE IF NOT EXISTS `yuyuekanfang` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuyuebianhao` varchar(200) NOT NULL COMMENT '预约编号',
  `fangwumingcheng` varchar(200) DEFAULT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `fangwuzhuangtai` varchar(200) DEFAULT NULL COMMENT '房屋状态',
  `xiaoqu` varchar(200) DEFAULT NULL COMMENT '小区',
  `yuezujiage` int DEFAULT NULL COMMENT '月租价格',
  `yajin` varchar(200) DEFAULT NULL COMMENT '押金',
  `zuyongyueshu` int DEFAULT NULL COMMENT '租用月数',
  `zuyongjine` varchar(200) DEFAULT NULL COMMENT '租用金额',
  `yuyueshijian` datetime NOT NULL COMMENT '预约时间',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `fangzhuzhanghao` varchar(200) DEFAULT NULL COMMENT '房主账号',
  `fangzhuxingming` varchar(200) DEFAULT NULL COMMENT '房主姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yuyuebianhao` (`yuyuebianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1614855637717 DEFAULT CHARSET=utf8mb3 COMMENT='预约看房';

DELETE FROM `yuyuekanfang`;
INSERT INTO `yuyuekanfang` (`id`, `addtime`, `yuyuebianhao`, `fangwumingcheng`, `fangwuleixing`, `fangwuzhuangtai`, `xiaoqu`, `yuezujiage`, `yajin`, `zuyongyueshu`, `zuyongjine`, `yuyueshijian`, `yonghuming`, `xingming`, `shenfenzheng`, `lianxidianhua`, `fangzhuzhanghao`, `fangzhuxingming`, `sfsh`, `shhf`) VALUES
	(51, '2026-03-09 10:46:53', 'YYKF20260309001', '湖景雅苑1栋1201', '一室一厅', '可租', '湖景雅苑', 3200, '3200', 12, '38400', '2026-03-09 18:46:53', 'tenant_lin', '林雨桐', '440300199101010001', '13900010001', 'landlord_zhang', '张明', '是', ''),
	(52, '2026-03-09 10:46:53', 'YYKF20260309002', '星河湾2期8栋502', '两室一厅', '可租', '星河湾二期', 4800, '4800', 6, '28800', '2026-03-09 18:46:53', 'tenant_zhou', '周子轩', '440300199202020002', '13900010002', 'landlord_li', '李娜', '是', ''),
	(53, '2026-03-09 10:46:53', 'YYKF20260309003', '金域蓝湾3栋1802', '两室两厅', '可租', '金域蓝湾', 6200, '6200', 12, '74400', '2026-03-09 18:46:53', 'tenant_he', '何晨曦', '440300199303030003', '13900010003', 'landlord_wang', '王强', '是', ''),
	(54, '2026-03-09 10:46:53', 'YYKF20260309004', '华都花园B座1003', '三室一厅', '可租', '华都花园', 7200, '7200', 12, '86400', '2026-03-09 18:46:53', 'tenant_wu', '吴思远', '440300199404040004', '13900010004', 'landlord_zhao', '赵敏', '是', ''),
	(55, '2026-03-09 10:46:53', 'YYKF20260309005', '城市春天5栋902', '三室两厅', '可租', '城市春天', 8800, '8800', 24, '211200', '2026-03-09 18:46:53', 'tenant_ma', '马可欣', '440300199505050005', '13900010005', 'landlord_chen', '陈凯', '是', ''),
	(56, '2026-03-09 10:46:53', 'YYKF20260309006', '云顶公馆6栋1501', '四室两厅', '可租', '云顶公馆', 10800, '10800', 12, '129600', '2026-03-09 18:46:53', 'tenant_qian', '钱嘉乐', '440300199606060006', '13900010006', 'landlord_sun', '孙悦', '是', ''),
	(1614855637716, '2026-03-09 11:00:37', 'YYKF20260309007', '新记家园605房', '3房1厅', '可租', '新记家园', 2000, '2000', 12, '24000', '2026-03-09 19:00:35', 'tenant_chenyi', '陈一', '123456789789456123', '12312312312', 'landlord_zhang_old', '张明', '是', '可以，周末可看房。');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
