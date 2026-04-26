package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LandlordApplicationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LandlordApplicationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LandlordApplicationView;


/**
 * 我要当房主
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface LandlordApplicationService extends IService<LandlordApplicationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LandlordApplicationVO> selectListVO(Wrapper<LandlordApplicationEntity> wrapper);
   	
   	LandlordApplicationVO selectVO(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
   	
   	List<LandlordApplicationView> selectListView(Wrapper<LandlordApplicationEntity> wrapper);
   	
   	LandlordApplicationView selectView(@Param("ew") Wrapper<LandlordApplicationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LandlordApplicationEntity> wrapper);
   	
}

