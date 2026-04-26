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


import com.dao.LandlordApplicationDao;
import com.entity.LandlordApplicationEntity;
import com.service.LandlordApplicationService;
import com.entity.vo.LandlordApplicationVO;
import com.entity.view.LandlordApplicationView;

@Service("landlordApplicationService")
public class LandlordApplicationServiceImpl extends ServiceImpl<LandlordApplicationDao, LandlordApplicationEntity> implements LandlordApplicationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LandlordApplicationEntity> page = this.selectPage(
                new Query<LandlordApplicationEntity>(params).getPage(),
                new EntityWrapper<LandlordApplicationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LandlordApplicationEntity> wrapper) {
		  Page<LandlordApplicationView> page =new Query<LandlordApplicationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LandlordApplicationVO> selectListVO(Wrapper<LandlordApplicationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LandlordApplicationVO selectVO(Wrapper<LandlordApplicationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LandlordApplicationView> selectListView(Wrapper<LandlordApplicationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LandlordApplicationView selectView(Wrapper<LandlordApplicationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
