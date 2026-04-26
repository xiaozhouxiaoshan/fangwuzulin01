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


import com.dao.LandlordDao;
import com.entity.LandlordEntity;
import com.service.LandlordService;
import com.entity.vo.LandlordVO;
import com.entity.view.LandlordView;

@Service("landlordService")
public class LandlordServiceImpl extends ServiceImpl<LandlordDao, LandlordEntity> implements LandlordService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LandlordEntity> page = this.selectPage(
                new Query<LandlordEntity>(params).getPage(),
                new EntityWrapper<LandlordEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LandlordEntity> wrapper) {
		  Page<LandlordView> page =new Query<LandlordView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LandlordVO> selectListVO(Wrapper<LandlordEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LandlordVO selectVO(Wrapper<LandlordEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LandlordView> selectListView(Wrapper<LandlordEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LandlordView selectView(Wrapper<LandlordEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
