package com.entity.model;

import com.entity.HouseListingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class HouseListingModel  implements Serializable {
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
	 * 面积
	 */
	
	private String area;
		
	/**
	 * 房屋状态
	 */
	
	private String houseStatus;
		
	/**
	 * 小区
	 */
	
	private String community;
		
	/**
	 * 详细地址
	 */
	
	private String addressDetail;
		
	/**
	 * 月租价格
	 */
	
	private Integer monthlyRent;
		
	/**
	 * 押金
	 */
	
	private Integer deposit;
		
	/**
	 * 房屋设施
	 */
	
	private String facilities;
		
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
	 * 房主账号
	 */
	
	private String landlordAccount;
		
	/**
	 * 房主姓名
	 */
	
	private String landlordName;
				
	
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
	 * 设置：详细地址
	 */
	 
	public void setXiangxidizhi(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return addressDetail;
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
	 * 设置：房屋设施
	 */
	 
	public void setFangwusheshi(String facilities) {
		this.facilities = facilities;
	}
	
	/**
	 * 获取：房屋设施
	 */
	public String getFangwusheshi() {
		return facilities;
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
			
}
