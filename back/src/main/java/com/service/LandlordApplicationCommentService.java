package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LandlordApplicationCommentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LandlordApplicationCommentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LandlordApplicationCommentView;


/**
 * 我要当房主评论表
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordApplicationCommentService extends IService<LandlordApplicationCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LandlordApplicationCommentVO> selectListVO(Wrapper<LandlordApplicationCommentEntity> wrapper);
   	
   	LandlordApplicationCommentVO selectVO(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
   	
   	List<LandlordApplicationCommentView> selectListView(Wrapper<LandlordApplicationCommentEntity> wrapper);
   	
   	LandlordApplicationCommentView selectView(@Param("ew") Wrapper<LandlordApplicationCommentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LandlordApplicationCommentEntity> wrapper);
   	
}

