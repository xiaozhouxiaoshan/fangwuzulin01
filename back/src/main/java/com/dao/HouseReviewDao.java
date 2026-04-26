package com.dao;

import com.entity.HouseReviewEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HouseReviewVO;
import com.entity.view.HouseReviewView;


/**
 * 房屋评价
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseReviewDao extends BaseMapper<HouseReviewEntity> {
	
	List<HouseReviewVO> selectListVO(@Param("ew") Wrapper<HouseReviewEntity> wrapper);
	
	HouseReviewVO selectVO(@Param("ew") Wrapper<HouseReviewEntity> wrapper);
	
	List<HouseReviewView> selectListView(@Param("ew") Wrapper<HouseReviewEntity> wrapper);

	List<HouseReviewView> selectListView(Pagination page,@Param("ew") Wrapper<HouseReviewEntity> wrapper);
	
	HouseReviewView selectView(@Param("ew") Wrapper<HouseReviewEntity> wrapper);
	
}
