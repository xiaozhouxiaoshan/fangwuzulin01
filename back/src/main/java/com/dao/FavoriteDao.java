package com.dao;

import com.entity.FavoriteEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FavoriteVO;
import com.entity.view.FavoriteView;


/**
 * 收藏表
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface FavoriteDao extends BaseMapper<FavoriteEntity> {
	
	List<FavoriteVO> selectListVO(@Param("ew") Wrapper<FavoriteEntity> wrapper);
	
	FavoriteVO selectVO(@Param("ew") Wrapper<FavoriteEntity> wrapper);
	
	List<FavoriteView> selectListView(@Param("ew") Wrapper<FavoriteEntity> wrapper);

	List<FavoriteView> selectListView(Pagination page,@Param("ew") Wrapper<FavoriteEntity> wrapper);
	
	FavoriteView selectView(@Param("ew") Wrapper<FavoriteEntity> wrapper);
	
}
