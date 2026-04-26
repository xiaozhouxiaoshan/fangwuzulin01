package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MessageBoardEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MessageBoardVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MessageBoardView;


/**
 * 留言板
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface MessageBoardService extends IService<MessageBoardEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MessageBoardVO> selectListVO(Wrapper<MessageBoardEntity> wrapper);
   	
   	MessageBoardVO selectVO(@Param("ew") Wrapper<MessageBoardEntity> wrapper);
   	
   	List<MessageBoardView> selectListView(Wrapper<MessageBoardEntity> wrapper);
   	
   	MessageBoardView selectView(@Param("ew") Wrapper<MessageBoardEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MessageBoardEntity> wrapper);
   	
}

