package com.entity.vo;

import com.entity.HouseReviewEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋评价
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class HouseReviewVO  implements Serializable {
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
	 * 评分
	 */
	
	private String rating;
		
	/**
	 * 评价内容
	 */
	
	private String reviewContent;
		
	/**
	 * 评价日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date reviewDate;
		
	/**
	 * 房主账号
	 */
	
	private String landlordAccount;
		
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
	 * 设置：评分
	 */
	 
	public void setPingfen(String rating) {
		this.rating = rating;
	}
	
	/**
	 * 获取：评分
	 */
	public String getPingfen() {
		return rating;
	}
				
	
	/**
	 * 设置：评价内容
	 */
	 
	public void setPingjianeirong(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	/**
	 * 获取：评价内容
	 */
	public String getPingjianeirong() {
		return reviewContent;
	}
				
	
	/**
	 * 设置：评价日期
	 */
	 
	public void setPingjiariqi(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	/**
	 * 获取：评价日期
	 */
	public Date getPingjiariqi() {
		return reviewDate;
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
