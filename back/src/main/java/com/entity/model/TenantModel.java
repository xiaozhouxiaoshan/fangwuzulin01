package com.entity.model;

import com.entity.TenantEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 用户
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public class TenantModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 姓名
	 */
	
	private String fullName;
		
	/**
	 * 头像
	 */
	
	private String avatar;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 职业
	 */
	
	private String occupation;
		
	/**
	 * 联系电话
	 */
	
	private String contactPhone;
		
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
	 * 设置：职业
	 */
	 
	public void setZhiye(String occupation) {
		this.occupation = occupation;
	}
	
	/**
	 * 获取：职业
	 */
	public String getZhiye() {
		return occupation;
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
