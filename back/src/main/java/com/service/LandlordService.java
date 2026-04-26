package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LandlordEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LandlordVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LandlordView;


/**
 * 房主
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordService extends IService<LandlordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LandlordVO> selectListVO(Wrapper<LandlordEntity> wrapper);
   	
   	LandlordVO selectVO(@Param("ew") Wrapper<LandlordEntity> wrapper);
   	
   	List<LandlordView> selectListView(Wrapper<LandlordEntity> wrapper);
   	
   	LandlordView selectView(@Param("ew") Wrapper<LandlordEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LandlordEntity> wrapper);
   	
}

