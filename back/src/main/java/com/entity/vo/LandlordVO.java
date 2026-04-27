package com.entity.vo;

import com.entity.LandlordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房主
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class LandlordVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 房主姓名
	 */
	
	private String landlordName;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 头像
	 */
	
	private String avatar;
		
	/**
	 * 手机
	 */
	
	private String phoneNumber;
		
	/**
	 * 身份证
	 */
	
	private String idCardNumber;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return password;
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return gender;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String avatar) {
		this.avatar = avatar;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return avatar;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return phoneNumber;
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
			
}
