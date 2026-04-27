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
 * 用户
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("tenant")
public class TenantEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TenantEntity() {
		
	}
	
	public TenantEntity(T t) {
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
	 * 用户名
	 */
					
	private String tenantUsername;
	
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
