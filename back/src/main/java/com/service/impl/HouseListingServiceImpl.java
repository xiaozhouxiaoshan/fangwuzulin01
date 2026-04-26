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


import com.dao.HouseListingDao;
import com.entity.HouseListingEntity;
import com.service.HouseListingService;
import com.entity.vo.HouseListingVO;
import com.entity.view.HouseListingView;

@Service("houseListingService")
public class HouseListingServiceImpl extends ServiceImpl<HouseListingDao, HouseListingEntity> implements HouseListingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouseListingEntity> page = this.selectPage(
                new Query<HouseListingEntity>(params).getPage(),
                new EntityWrapper<HouseListingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouseListingEntity> wrapper) {
		  Page<HouseListingView> page =new Query<HouseListingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HouseListingVO> selectListVO(Wrapper<HouseListingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HouseListingVO selectVO(Wrapper<HouseListingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HouseListingView> selectListView(Wrapper<HouseListingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouseListingView selectView(Wrapper<HouseListingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
