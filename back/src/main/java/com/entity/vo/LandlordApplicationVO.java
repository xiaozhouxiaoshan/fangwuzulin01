package com.entity.vo;

import com.entity.LandlordApplicationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 我要当房主
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class LandlordApplicationVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋类型
	 */
	
	private String houseType;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 租赁方式
	 */
	
	private String rentalMode;
		
	/**
	 * 朝向楼层
	 */
	
	private String orientationFloor;
		
	/**
	 * 小区
	 */
	
	private String community;
		
	/**
	 * 面积
	 */
	
	private String area;
		
	/**
	 * 月租价格
	 */
	
	private Integer monthlyRent;
		
	/**
	 * 房屋详情
	 */
	
	private String houseDescription;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date publishDate;
		
	/**
	 * 用户名
	 */
	
	private String tenantUsername;
		
	/**
	 * 联系电话
	 */
	
	private String contactPhone;
		
	/**
	 * 是否审核
	 */
	
	private String reviewStatus;
		
	/**
	 * 审核回复
	 */
	
	private String reviewReply;
				
	
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
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：租赁方式
	 */
	 
	public void setZulinfangshi(String rentalMode) {
		this.rentalMode = rentalMode;
	}
	
	/**
	 * 获取：租赁方式
	 */
	public String getZulinfangshi() {
		return rentalMode;
	}
				
	
	/**
	 * 设置：朝向楼层
	 */
	 
	public void setChaoxianglouceng(String orientationFloor) {
		this.orientationFloor = orientationFloor;
	}
	
	/**
	 * 获取：朝向楼层
	 */
	public String getChaoxianglouceng() {
		return orientationFloor;
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
	 * 设置：面积
	 */
	 
	public void setMianji(String area) {
		this.area = area;
	}
	
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return area;
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
	 * 设置：房屋详情
	 */
	 
	public void setFangwuxiangqing(String houseDescription) {
		this.houseDescription = houseDescription;
	}
	
	/**
	 * 获取：房屋详情
	 */
	public String getFangwuxiangqing() {
		return houseDescription;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return publishDate;
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
