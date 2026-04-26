package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HouseRepairEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HouseRepairVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HouseRepairView;


/**
 * 房屋报修
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseRepairService extends IService<HouseRepairEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouseRepairVO> selectListVO(Wrapper<HouseRepairEntity> wrapper);
   	
   	HouseRepairVO selectVO(@Param("ew") Wrapper<HouseRepairEntity> wrapper);
   	
   	List<HouseRepairView> selectListView(Wrapper<HouseRepairEntity> wrapper);
   	
   	HouseRepairView selectView(@Param("ew") Wrapper<HouseRepairEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouseRepairEntity> wrapper);
   	
}

