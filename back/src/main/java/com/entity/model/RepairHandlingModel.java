package com.entity.model;

import com.entity.RepairHandlingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修处理
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class RepairHandlingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋类型
	 */
	
	private String houseType;
		
	/**
	 * 报修名称
	 */
	
	private String baoxiumingcheng;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 报修日期
	 */
	
	private String baoxiuriqi;
		
	/**
	 * 维修反馈
	 */
	
	private String weixiufankui;
		
	/**
	 * 维修进度
	 */
	
	private String weixiujindu;
		
	/**
	 * 更新日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date gengxinriqi;
		
	/**
	 * 房主账号
	 */
	
	private String landlordzhanghao;
		
	/**
	 * 房主姓名
	 */
	
	private String landlordxingming;
		
	/**
	 * 用户名
	 */
	
	private String tenantming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
				
	
	/**
	 * 设置：房屋类型
	 */
	 
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	/**
	 * 获取：房屋类型
	 */
	public String getHouseType() {
		return houseType;
	}
				
	
	/**
	 * 设置：报修名称
	 */
	 
	public void setBaoxiumingcheng(String baoxiumingcheng) {
		this.baoxiumingcheng = baoxiumingcheng;
	}
	
	/**
	 * 获取：报修名称
	 */
	public String getBaoxiumingcheng() {
		return baoxiumingcheng;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：报修日期
	 */
	 
	public void setBaoxiuriqi(String baoxiuriqi) {
		this.baoxiuriqi = baoxiuriqi;
	}
	
	/**
	 * 获取：报修日期
	 */
	public String getBaoxiuriqi() {
		return baoxiuriqi;
	}
				
	
	/**
	 * 设置：维修反馈
	 */
	 
	public void setWeixiufankui(String weixiufankui) {
		this.weixiufankui = weixiufankui;
	}
	
	/**
	 * 获取：维修反馈
	 */
	public String getWeixiufankui() {
		return weixiufankui;
	}
				
	
	/**
	 * 设置：维修进度
	 */
	 
	public void setWeixiujindu(String weixiujindu) {
		this.weixiujindu = weixiujindu;
	}
	
	/**
	 * 获取：维修进度
	 */
	public String getWeixiujindu() {
		return weixiujindu;
	}
				
	
	/**
	 * 设置：更新日期
	 */
	 
	public void setGengxinriqi(Date gengxinriqi) {
		this.gengxinriqi = gengxinriqi;
	}
	
	/**
	 * 获取：更新日期
	 */
	public Date getGengxinriqi() {
		return gengxinriqi;
	}
				
	
	/**
	 * 设置：房主账号
	 */
	 
	public void setLandlordzhanghao(String landlordzhanghao) {
		this.landlordzhanghao = landlordzhanghao;
	}
	
	/**
	 * 获取：房主账号
	 */
	public String getLandlordzhanghao() {
		return landlordzhanghao;
	}
				
	
	/**
	 * 设置：房主姓名
	 */
	 
	public void setLandlordxingming(String landlordxingming) {
		this.landlordxingming = landlordxingming;
	}
	
	/**
	 * 获取：房主姓名
	 */
	public String getLandlordxingming() {
		return landlordxingming;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setTenantming(String tenantming) {
		this.tenantming = tenantming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getTenantming() {
		return tenantming;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
			
}
