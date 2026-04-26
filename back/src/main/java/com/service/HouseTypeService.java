package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HouseTypeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HouseTypeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HouseTypeView;


/**
 * 房屋类型
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface HouseTypeService extends IService<HouseTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HouseTypeVO> selectListVO(Wrapper<HouseTypeEntity> wrapper);
   	
   	HouseTypeVO selectVO(@Param("ew") Wrapper<HouseTypeEntity> wrapper);
   	
   	List<HouseTypeView> selectListView(Wrapper<HouseTypeEntity> wrapper);
   	
   	HouseTypeView selectView(@Param("ew") Wrapper<HouseTypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HouseTypeEntity> wrapper);
   	
}

