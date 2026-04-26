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


import com.dao.FavoriteDao;
import com.entity.FavoriteEntity;
import com.service.FavoriteService;
import com.entity.vo.FavoriteVO;
import com.entity.view.FavoriteView;

@Service("favoriteService")
public class FavoriteServiceImpl extends ServiceImpl<FavoriteDao, FavoriteEntity> implements FavoriteService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FavoriteEntity> page = this.selectPage(
                new Query<FavoriteEntity>(params).getPage(),
                new EntityWrapper<FavoriteEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FavoriteEntity> wrapper) {
		  Page<FavoriteView> page =new Query<FavoriteView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FavoriteVO> selectListVO(Wrapper<FavoriteEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FavoriteVO selectVO(Wrapper<FavoriteEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FavoriteView> selectListView(Wrapper<FavoriteEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FavoriteView selectView(Wrapper<FavoriteEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
