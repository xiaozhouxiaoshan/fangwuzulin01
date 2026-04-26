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


import com.dao.RepairHandlingDao;
import com.entity.RepairHandlingEntity;
import com.service.RepairHandlingService;
import com.entity.vo.RepairHandlingVO;
import com.entity.view.RepairHandlingView;

@Service("repairHandlingService")
public class RepairHandlingServiceImpl extends ServiceImpl<RepairHandlingDao, RepairHandlingEntity> implements RepairHandlingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RepairHandlingEntity> page = this.selectPage(
                new Query<RepairHandlingEntity>(params).getPage(),
                new EntityWrapper<RepairHandlingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RepairHandlingEntity> wrapper) {
		  Page<RepairHandlingView> page =new Query<RepairHandlingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RepairHandlingVO> selectListVO(Wrapper<RepairHandlingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RepairHandlingVO selectVO(Wrapper<RepairHandlingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RepairHandlingView> selectListView(Wrapper<RepairHandlingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RepairHandlingView selectView(Wrapper<RepairHandlingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
