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


import com.dao.AnnouncementDao;
import com.entity.AnnouncementEntity;
import com.service.AnnouncementService;
import com.entity.vo.AnnouncementVO;
import com.entity.view.AnnouncementView;

@Service("announcementService")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, AnnouncementEntity> implements AnnouncementService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnnouncementEntity> page = this.selectPage(
                new Query<AnnouncementEntity>(params).getPage(),
                new EntityWrapper<AnnouncementEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnnouncementEntity> wrapper) {
		  Page<AnnouncementView> page =new Query<AnnouncementView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AnnouncementVO> selectListVO(Wrapper<AnnouncementEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AnnouncementVO selectVO(Wrapper<AnnouncementEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AnnouncementView> selectListView(Wrapper<AnnouncementEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnnouncementView selectView(Wrapper<AnnouncementEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
