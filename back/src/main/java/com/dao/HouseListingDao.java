package com.dao;

import com.entity.HouseListingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HouseListingVO;
import com.entity.view.HouseListingView;


/**
 * 房屋信息
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseListingDao extends BaseMapper<HouseListingEntity> {
	
	List<HouseListingVO> selectListVO(@Param("ew") Wrapper<HouseListingEntity> wrapper);
	
	HouseListingVO selectVO(@Param("ew") Wrapper<HouseListingEntity> wrapper);
	
	List<HouseListingView> selectListView(@Param("ew") Wrapper<HouseListingEntity> wrapper);

	List<HouseListingView> selectListView(Pagination page,@Param("ew") Wrapper<HouseListingEntity> wrapper);
	
	HouseListingView selectView(@Param("ew") Wrapper<HouseListingEntity> wrapper);
	
}
