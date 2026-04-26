package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RepairHandlingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RepairHandlingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RepairHandlingView;


/**
 * 维修处理
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface RepairHandlingService extends IService<RepairHandlingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RepairHandlingVO> selectListVO(Wrapper<RepairHandlingEntity> wrapper);
   	
   	RepairHandlingVO selectVO(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
   	
   	List<RepairHandlingView> selectListView(Wrapper<RepairHandlingEntity> wrapper);
   	
   	RepairHandlingView selectView(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RepairHandlingEntity> wrapper);
   	
}

