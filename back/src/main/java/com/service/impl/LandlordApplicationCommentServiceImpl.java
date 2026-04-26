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


import com.dao.LandlordApplicationCommentDao;
import com.entity.LandlordApplicationCommentEntity;
import com.service.LandlordApplicationCommentService;
import com.entity.vo.LandlordApplicationCommentVO;
import com.entity.view.LandlordApplicationCommentView;

@Service("landlordApplicationCommentService")
public class LandlordApplicationCommentServiceImpl extends ServiceImpl<LandlordApplicationCommentDao, LandlordApplicationCommentEntity> implements LandlordApplicationCommentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LandlordApplicationCommentEntity> page = this.selectPage(
                new Query<LandlordApplicationCommentEntity>(params).getPage(),
                new EntityWrapper<LandlordApplicationCommentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LandlordApplicationCommentEntity> wrapper) {
		  Page<LandlordApplicationCommentView> page =new Query<LandlordApplicationCommentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LandlordApplicationCommentVO> selectListVO(Wrapper<LandlordApplicationCommentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LandlordApplicationCommentVO selectVO(Wrapper<LandlordApplicationCommentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LandlordApplicationCommentView> selectListView(Wrapper<LandlordApplicationCommentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LandlordApplicationCommentView selectView(Wrapper<LandlordApplicationCommentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
