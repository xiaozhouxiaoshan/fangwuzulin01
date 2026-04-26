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


import com.dao.HouseReviewDao;
import com.entity.HouseReviewEntity;
import com.service.HouseReviewService;
import com.entity.vo.HouseReviewVO;
import com.entity.view.HouseReviewView;

@Service("houseReviewService")
public class HouseReviewServiceImpl extends ServiceImpl<HouseReviewDao, HouseReviewEntity> implements HouseReviewService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouseReviewEntity> page = this.selectPage(
                new Query<HouseReviewEntity>(params).getPage(),
                new EntityWrapper<HouseReviewEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouseReviewEntity> wrapper) {
		  Page<HouseReviewView> page =new Query<HouseReviewView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HouseReviewVO> selectListVO(Wrapper<HouseReviewEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HouseReviewVO selectVO(Wrapper<HouseReviewEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HouseReviewView> selectListView(Wrapper<HouseReviewEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouseReviewView selectView(Wrapper<HouseReviewEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
