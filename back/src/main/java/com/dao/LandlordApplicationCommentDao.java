package com.dao;

import com.entity.LandlordApplicationCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LandlordApplicationCommentVO;
import com.entity.view.LandlordApplicationCommentView;


/**
 * 我要当房主评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordApplicationCommentDao extends BaseMapper<LandlordApplicationCommentEntity> {
	
	List<LandlordApplicationCommentVO> selectListVO(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
	
	LandlordApplicationCommentVO selectVO(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
	
	List<LandlordApplicationCommentView> selectListView(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);

	List<LandlordApplicationCommentView> selectListView(Pagination page,@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
	
	LandlordApplicationCommentView selectView(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
	
}
