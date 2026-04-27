package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 合同信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("rentalContract")
public class RentalContractEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RentalContractEntity() {
		
	}
	
	public RentalContractEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 合同编号
	 */
					
	private String contractNumber;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date effectiveDate;
	
	/**
	 * 有限期至
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date createdAt;

	public Date getAddtime() {
		return createdAt;
	}
	public void setAddtime(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：合同编号
	 */
	public void setHetongbianhao(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	/**
	 * 获取：合同编号
	 */
	public String getHetongbianhao() {
		return contractNumber;
	}
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
