package com.dao;

import com.entity.MessageBoardEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MessageBoardVO;
import com.entity.view.MessageBoardView;


/**
 * 留言板
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface MessageBoardDao extends BaseMapper<MessageBoardEntity> {
	
	List<MessageBoardVO> selectListVO(@Param("ew") Wrapper<MessageBoardEntity> wrapper);
	
	MessageBoardVO selectVO(@Param("ew") Wrapper<MessageBoardEntity> wrapper);
	
	List<MessageBoardView> selectListView(@Param("ew") Wrapper<MessageBoardEntity> wrapper);

	List<MessageBoardView> selectListView(Pagination page,@Param("ew") Wrapper<MessageBoardEntity> wrapper);
	
	MessageBoardView selectView(@Param("ew") Wrapper<MessageBoardEntity> wrapper);
	
}
