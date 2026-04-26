package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HouseReviewEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HouseReviewVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HouseReviewView;


/**
 * 房屋评价
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseReviewService extends IService<HouseReviewEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouseReviewVO> selectListVO(Wrapper<HouseReviewEntity> wrapper);
   	
   	HouseReviewVO selectVO(@Param("ew") Wrapper<HouseReviewEntity> wrapper);
   	
   	List<HouseReviewView> selectListView(Wrapper<HouseReviewEntity> wrapper);
   	
   	HouseReviewView selectView(@Param("ew") Wrapper<HouseReviewEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouseReviewEntity> wrapper);
   	
}

