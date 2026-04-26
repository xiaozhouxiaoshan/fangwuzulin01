package com.dao;

import com.entity.HouseListingCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HouseListingCommentVO;
import com.entity.view.HouseListingCommentView;


/**
 * 房屋信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseListingCommentDao extends BaseMapper<HouseListingCommentEntity> {
	
	List<HouseListingCommentVO> selectListVO(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
	
	HouseListingCommentVO selectVO(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
	
	List<HouseListingCommentView> selectListView(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);

	List<HouseListingCommentView> selectListView(Pagination page,@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
	
	HouseListingCommentView selectView(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
	
}
