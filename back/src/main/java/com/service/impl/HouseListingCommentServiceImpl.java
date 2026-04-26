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


import com.dao.HouseListingCommentDao;
import com.entity.HouseListingCommentEntity;
import com.service.HouseListingCommentService;
import com.entity.vo.HouseListingCommentVO;
import com.entity.view.HouseListingCommentView;

@Service("houseListingCommentService")
public class HouseListingCommentServiceImpl extends ServiceImpl<HouseListingCommentDao, HouseListingCommentEntity> implements HouseListingCommentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouseListingCommentEntity> page = this.selectPage(
                new Query<HouseListingCommentEntity>(params).getPage(),
                new EntityWrapper<HouseListingCommentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouseListingCommentEntity> wrapper) {
		  Page<HouseListingCommentView> page =new Query<HouseListingCommentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HouseListingCommentVO> selectListVO(Wrapper<HouseListingCommentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HouseListingCommentVO selectVO(Wrapper<HouseListingCommentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HouseListingCommentView> selectListView(Wrapper<HouseListingCommentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouseListingCommentView selectView(Wrapper<HouseListingCommentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
