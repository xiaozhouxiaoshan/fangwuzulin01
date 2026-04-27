package com.entity.vo;

import com.entity.RepairHandlingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修处理
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class RepairHandlingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋类型
	 */
	
	private String houseType;
		
	/**
	 * 报修名称
	 */
	
	private String repairTitle;
		
	/**
	 * 类型
	 */
	
	private String repairType;
		
	/**
	 * 报修日期
	 */
	
	private String repairDate;
		
	/**
	 * 维修反馈
	 */
	
	private String handlingFeedback;
		
	/**
	 * 维修进度
	 */
	
	private String handlingProgress;
		
	/**
	 * 更新日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date updatedDate;
		
	/**
	 * 房主账号
	 */
	
	private String landlordAccount;
		
	/**
	 * 房主姓名
	 */
	
	private String landlordName;
		
	/**
	 * 用户名
	 */
	
	private String tenantUsername;
		
	/**
	 * 联系电话
	 */
	
	private String contactPhone;
				
	
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
	 
	public void setBaoxiumingcheng(String repairTitle) {
		this.repairTitle = repairTitle;
	}
	
	/**
	 * 获取：报修名称
	 */
	public String getBaoxiumingcheng() {
		return repairTitle;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String repairType) {
		this.repairType = repairType;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return repairType;
	}
				
	
	/**
	 * 设置：报修日期
	 */
	 
	public void setBaoxiuriqi(String repairDate) {
		this.repairDate = repairDate;
	}
	
	/**
	 * 获取：报修日期
	 */
	public String getBaoxiuriqi() {
		return repairDate;
	}
				
	
	/**
	 * 设置：维修反馈
	 */
	 
	public void setWeixiufankui(String handlingFeedback) {
		this.handlingFeedback = handlingFeedback;
	}
	
	/**
	 * 获取：维修反馈
	 */
	public String getWeixiufankui() {
		return handlingFeedback;
	}
				
	
	/**
	 * 设置：维修进度
	 */
	 
	public void setWeixiujindu(String handlingProgress) {
		this.handlingProgress = handlingProgress;
	}
	
	/**
	 * 获取：维修进度
	 */
	public String getWeixiujindu() {
		return handlingProgress;
	}
				
	
	/**
	 * 设置：更新日期
	 */
	 
	public void setGengxinriqi(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	/**
	 * 获取：更新日期
	 */
	public Date getGengxinriqi() {
		return updatedDate;
	}
				
	
	/**
	 * 设置：房主账号
	 */
	 
	public void setLandlordzhanghao(String landlordAccount) {
		this.landlordAccount = landlordAccount;
	}
	
	/**
	 * 获取：房主账号
	 */
	public String getLandlordzhanghao() {
		return landlordAccount;
	}
				
	
	/**
	 * 设置：房主姓名
	 */
	 
	public void setLandlordfullName(String landlordName) {
		this.landlordName = landlordName;
	}
	
	/**
	 * 获取：房主姓名
	 */
	public String getLandlordfullName() {
		return landlordName;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setTenantming(String tenantUsername) {
		this.tenantUsername = tenantUsername;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getTenantming() {
		return tenantUsername;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return contactPhone;
	}
			
}
