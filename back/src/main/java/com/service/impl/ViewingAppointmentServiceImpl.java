package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ViewingAppointmentDao;
import com.entity.ViewingAppointmentEntity;
import com.service.ViewingAppointmentService;
import com.entity.vo.ViewingAppointmentVO;
import com.entity.view.ViewingAppointmentView;

@Service("viewingAppointmentService")
public class ViewingAppointmentServiceImpl extends ServiceImpl<ViewingAppointmentDao, ViewingAppointmentEntity> implements ViewingAppointmentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ViewingAppointmentEntity> page = this.selectPage(
                new Query<ViewingAppointmentEntity>(params).getPage(),
                new EntityWrapper<ViewingAppointmentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViewingAppointmentEntity> wrapper) {
		  Page<ViewingAppointmentView> page =new Query<ViewingAppointmentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ViewingAppointmentVO> selectListVO(Wrapper<ViewingAppointmentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ViewingAppointmentVO selectVO(Wrapper<ViewingAppointmentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ViewingAppointmentView> selectListView(Wrapper<ViewingAppointmentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ViewingAppointmentView selectView(Wrapper<ViewingAppointmentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
