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


import com.dao.HouseRepairDao;
import com.entity.HouseRepairEntity;
import com.service.HouseRepairService;
import com.entity.vo.HouseRepairVO;
import com.entity.view.HouseRepairView;

@Service("houseRepairService")
public class HouseRepairServiceImpl extends ServiceImpl<HouseRepairDao, HouseRepairEntity> implements HouseRepairService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HouseRepairEntity> page = this.selectPage(
                new Query<HouseRepairEntity>(params).getPage(),
                new EntityWrapper<HouseRepairEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HouseRepairEntity> wrapper) {
		  Page<HouseRepairView> page =new Query<HouseRepairView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HouseRepairVO> selectListVO(Wrapper<HouseRepairEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HouseRepairVO selectVO(Wrapper<HouseRepairEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HouseRepairView> selectListView(Wrapper<HouseRepairEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HouseRepairView selectView(Wrapper<HouseRepairEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
