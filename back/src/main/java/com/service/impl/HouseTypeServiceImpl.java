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


import com.dao.HouseTypeDao;
import com.entity.HouseTypeEntity;
import com.service.HouseTypeService;
import com.entity.vo.HouseTypeVO;
import com.entity.view.HouseTypeView;

@Service("houseTypeService")
public class HouseTypeServiceImpl extends ServiceImpl<HouseTypeDao, HouseTypeEntity> implements HouseTypeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouseTypeEntity> page = this.selectPage(
                new Query<HouseTypeEntity>(params).getPage(),
                new EntityWrapper<HouseTypeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouseTypeEntity> wrapper) {
		  Page<HouseTypeView> page =new Query<HouseTypeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HouseTypeVO> selectListVO(Wrapper<HouseTypeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HouseTypeVO selectVO(Wrapper<HouseTypeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HouseTypeView> selectListView(Wrapper<HouseTypeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouseTypeView selectView(Wrapper<HouseTypeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
