package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HouseListingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HouseListingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HouseListingView;


/**
 * 房屋信息
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseListingService extends IService<HouseListingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouseListingVO> selectListVO(Wrapper<HouseListingEntity> wrapper);
   	
   	HouseListingVO selectVO(@Param("ew") Wrapper<HouseListingEntity> wrapper);
   	
   	List<HouseListingView> selectListView(Wrapper<HouseListingEntity> wrapper);
   	
   	HouseListingView selectView(@Param("ew") Wrapper<HouseListingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouseListingEntity> wrapper);
   	
}

