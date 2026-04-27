package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/** 
 * token表
 */
@TableName("token")
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * token
	 */
	private String token;
	
	/**
	 * 过期时间
	 */
	private Date expiresAt;
	
	/**
	 * 新增时间
	 */
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userId;
	}

	public void setUserid(Long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public String getTablename() {
		return tableName;
	}

	public void setTablename(String tableName) {
		this.tableName = tableName;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiratedtime() {
		return expiresAt;
	}

	public void setExpiratedtime(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Date getAddtime() {
		return createdAt;
	}

	public void setAddtime(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TokenEntity(Long userId, String username, String tableName,String role, String token, Date expiresAt) {
		super();
		this.userId = userId;
		this.username = username;
		this.tableName = tableName;
		this.role = role;
		this.token = token;
		this.expiresAt = expiresAt;
	}
	
	public TokenEntity() {
	}
	
}
