package com.entity.model;

import com.entity.RentalContractEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 合同信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class RentalContractModel  implements Serializable {
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
	 * 小区
	 */
	
	private String community;
		
	/**
	 * 月租价格
	 */
	
	private String monthlyRent;
		
	/**
	 * 租用月数
	 */
	
	private String rentalMonths;
		
	/**
	 * 租用金额
	 */
	
	private Integer rentalAmount;
		
	/**
	 * 押金
	 */
	
	private Integer deposit;
		
	/**
	 * 房租状态
	 */
	
	private String rentalStatus;
		
	/**
	 * 合同金额
	 */
	
	private String contractAmount;
		
	/**
	 * 合同内容
	 */
	
	private String contractContent;
		
	/**
	 * 生效日
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date effectiveDate;
		
	/**
	 * 有限期至
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date expiryDate;
		
	/**
	 * 用户名
	 */
	
	private String tenantUsername;
		
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
	 * 是否支付
	 */
	
	private String paymentStatus;
				
	
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
	 
	public void setYuezujiage(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	
	/**
	 * 获取：月租价格
	 */
	public String getYuezujiage() {
		return monthlyRent;
	}
				
	
	/**
	 * 设置：租用月数
	 */
	 
	public void setZuyongyueshu(String rentalMonths) {
		this.rentalMonths = rentalMonths;
	}
	
	/**
	 * 获取：租用月数
	 */
	public String getZuyongyueshu() {
		return rentalMonths;
	}
				
	
	/**
	 * 设置：租用金额
	 */
	 
	public void setZuyongjine(Integer rentalAmount) {
		this.rentalAmount = rentalAmount;
	}
	
	/**
	 * 获取：租用金额
	 */
	public Integer getZuyongjine() {
		return rentalAmount;
	}
				
	
	/**
	 * 设置：押金
	 */
	 
	public void setYajin(Integer deposit) {
		this.deposit = deposit;
	}
	
	/**
	 * 获取：押金
	 */
	public Integer getYajin() {
		return deposit;
	}
				
	
	/**
	 * 设置：房租状态
	 */
	 
	public void setFangzuzhuangtai(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	
	/**
	 * 获取：房租状态
	 */
	public String getFangzuzhuangtai() {
		return rentalStatus;
	}
				
	
	/**
	 * 设置：合同金额
	 */
	 
	public void setHetongjine(String contractAmount) {
		this.contractAmount = contractAmount;
	}
	
	/**
	 * 获取：合同金额
	 */
	public String getHetongjine() {
		return contractAmount;
	}
				
	
	/**
	 * 设置：合同内容
	 */
	 
	public void setHetongneirong(String contractContent) {
		this.contractContent = contractContent;
	}
	
	/**
	 * 获取：合同内容
	 */
	public String getHetongneirong() {
		return contractContent;
	}
				
	
	/**
	 * 设置：生效日
	 */
	 
	public void setShengxiaori(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	/**
	 * 获取：生效日
	 */
	public Date getShengxiaori() {
		return effectiveDate;
	}
				
	
	/**
	 * 设置：有限期至
	 */
	 
	public void setYouxianqizhi(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	/**
	 * 获取：有限期至
	 */
	public Date getYouxianqizhi() {
		return expiryDate;
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
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return paymentStatus;
	}
			
}
