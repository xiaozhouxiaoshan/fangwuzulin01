package com.entity.vo;

import com.entity.ViewingAppointmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 预约看房
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class ViewingAppointmentVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋名称
	 */
	
	private String houseName;
		
	/**
	 * 房屋类型
	 */
	
	private String houseType;
		
	/**
	 * 房屋状态
	 */
	
	private String houseStatus;
		
	/**
	 * 小区
	 */
	
	private String community;
		
	/**
	 * 月租价格
	 */
	
	private Integer monthlyRent;
		
	/**
	 * 押金
	 */
	
	private String deposit;
		
	/**
	 * 租用月数
	 */
	
	private Integer rentalMonths;
		
	/**
	 * 租用金额
	 */
	
	private String rentalAmount;
		
	/**
	 * 预约时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date appointmentTime;
		
	/**
	 * 用户名
	 */
	
	private String tenantUsername;
		
	/**
	 * 姓名
	 */
	
	private String fullName;
		
	/**
	 * 身份证
	 */
	
	private String idCardNumber;
		
	/**
	 * 联系电话
	 */
	
	private String contactPhone;
		
	/**
	 * 房主账号
	 */
	
	private String landlordAccount;
		
	/**
	 * 房主姓名
	 */
	
	private String landlordName;
		
	/**
	 * 是否审核
	 */
	
	private String reviewStatus;
		
	/**
	 * 审核回复
	 */
	
	private String reviewReply;
				
	
	/**
	 * 设置：房屋名称
	 */
	 
	public void setFangwumingcheng(String houseName) {
		this.houseName = houseName;
	}
	
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return houseName;
	}
				
	
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
	 * 设置：房屋状态
	 */
	 
	public void setFangwuzhuangtai(String houseStatus) {
		this.houseStatus = houseStatus;
	}
	
	/**
	 * 获取：房屋状态
	 */
	public String getFangwuzhuangtai() {
		return houseStatus;
	}
				
	
	/**
	 * 设置：小区
	 */
	 
	public void setXiaoqu(String community) {
		this.community = community;
	}
	
	/**
	 * 获取：小区
	 */
	public String getXiaoqu() {
		return community;
	}
				
	
	/**
	 * 设置：月租价格
	 */
	 
	public void setYuezujiage(Integer monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	
	/**
	 * 获取：月租价格
	 */
	public Integer getYuezujiage() {
		return monthlyRent;
	}
				
	
	/**
	 * 设置：押金
	 */
	 
	public void setYajin(String deposit) {
		this.deposit = deposit;
	}
	
	/**
	 * 获取：押金
	 */
	public String getYajin() {
		return deposit;
	}
				
	
	/**
	 * 设置：租用月数
	 */
	 
	public void setZuyongyueshu(Integer rentalMonths) {
		this.rentalMonths = rentalMonths;
	}
	
	/**
	 * 获取：租用月数
	 */
	public Integer getZuyongyueshu() {
		return rentalMonths;
	}
				
	
	/**
	 * 设置：租用金额
	 */
	 
	public void setZuyongjine(String rentalAmount) {
		this.rentalAmount = rentalAmount;
	}
	
	/**
	 * 获取：租用金额
	 */
	public String getZuyongjine() {
		return rentalAmount;
	}
				
	
	/**
	 * 设置：预约时间
	 */
	 
	public void setYuyueshijian(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	/**
	 * 获取：预约时间
	 */
	public Date getYuyueshijian() {
		return appointmentTime;
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
	 * 设置：姓名
	 */
	 
	public void setXingming(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return fullName;
	}
				
	
	/**
	 * 设置：身份证
	 */
	 
	public void setShenfenzheng(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return idCardNumber;
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
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return reviewStatus;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String reviewReply) {
		this.reviewReply = reviewReply;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return reviewReply;
	}
			
}
