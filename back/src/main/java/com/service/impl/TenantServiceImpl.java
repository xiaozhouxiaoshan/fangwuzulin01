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


import com.dao.TenantDao;
import com.entity.TenantEntity;
import com.service.TenantService;
import com.entity.vo.TenantVO;
import com.entity.view.TenantView;

@Service("tenantService")
public class TenantServiceImpl extends ServiceImpl<TenantDao, TenantEntity> implements TenantService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TenantEntity> page = this.selectPage(
                new Query<TenantEntity>(params).getPage(),
                new EntityWrapper<TenantEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TenantEntity> wrapper) {
		  Page<TenantView> page =new Query<TenantView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TenantVO> selectListVO(Wrapper<TenantEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TenantVO selectVO(Wrapper<TenantEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TenantView> selectListView(Wrapper<TenantEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TenantView selectView(Wrapper<TenantEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
