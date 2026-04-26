package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HouseListingCommentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HouseListingCommentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HouseListingCommentView;


/**
 * 房屋信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseListingCommentService extends IService<HouseListingCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouseListingCommentVO> selectListVO(Wrapper<HouseListingCommentEntity> wrapper);
   	
   	HouseListingCommentVO selectVO(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
   	
   	List<HouseListingCommentView> selectListView(Wrapper<HouseListingCommentEntity> wrapper);
   	
   	HouseListingCommentView selectView(@Param("ew") Wrapper<HouseListingCommentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouseListingCommentEntity> wrapper);
   	
}

