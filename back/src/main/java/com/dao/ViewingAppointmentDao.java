package com.dao;

import com.entity.ViewingAppointmentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ViewingAppointmentVO;
import com.entity.view.ViewingAppointmentView;


/**
 * 预约看房
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface ViewingAppointmentDao extends BaseMapper<ViewingAppointmentEntity> {
	
	List<ViewingAppointmentVO> selectListVO(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
	
	ViewingAppointmentVO selectVO(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
	
	List<ViewingAppointmentView> selectListView(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);

	List<ViewingAppointmentView> selectListView(Pagination page,@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
	
	ViewingAppointmentView selectView(@Param("ew") Wrapper<ViewingAppointmentEntity> wrapper);
	
}
