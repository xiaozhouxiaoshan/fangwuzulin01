package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ViewingAppointmentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ViewingAppointmentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ViewingAppointmentView;


/**
 * 预约看房
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface ViewingAppointmentService extends IService<ViewingAppointmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ViewingAppointmentVO> selectListVO(Wrapper<ViewingAppointmentEntity> wrapper);
   	
   	ViewingAppointmentVO selectVO(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
   	
   	List<ViewingAppointmentView> selectListView(Wrapper<ViewingAppointmentEntity> wrapper);
   	
   	ViewingAppointmentView selectView(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViewingAppointmentEntity> wrapper);
   	
}

