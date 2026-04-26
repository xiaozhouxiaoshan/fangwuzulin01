
package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AdminUserEntity;

/**
 * 用户
 */
public interface AdminUserDao extends BaseMapper<AdminUserEntity> {
	
	List<AdminUserEntity> selectListView(@Param("ew") Wrapper<AdminUserEntity> wrapper);

	List<AdminUserEntity> selectListView(Pagination page,@Param("ew") Wrapper<AdminUserEntity> wrapper);
	
}
