package com.dao;

import com.entity.TenantEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TenantVO;
import com.entity.view.TenantView;


/**
 * 用户
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface TenantDao extends BaseMapper<TenantEntity> {
	
	List<TenantVO> selectListVO(@Param("ew") Wrapper<TenantEntity> wrapper);
	
	TenantVO selectVO(@Param("ew") Wrapper<TenantEntity> wrapper);
	
	List<TenantView> selectListView(@Param("ew") Wrapper<TenantEntity> wrapper);

	List<TenantView> selectListView(Pagination page,@Param("ew") Wrapper<TenantEntity> wrapper);
	
	TenantView selectView(@Param("ew") Wrapper<TenantEntity> wrapper);
	
}
