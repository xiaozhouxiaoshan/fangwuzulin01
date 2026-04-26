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


import com.dao.RentalContractDao;
import com.entity.RentalContractEntity;
import com.service.RentalContractService;
import com.entity.vo.RentalContractVO;
import com.entity.view.RentalContractView;

@Service("rentalContractService")
public class RentalContractServiceImpl extends ServiceImpl<RentalContractDao, RentalContractEntity> implements RentalContractService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RentalContractEntity> page = this.selectPage(
                new Query<RentalContractEntity>(params).getPage(),
                new EntityWrapper<RentalContractEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RentalContractEntity> wrapper) {
		  Page<RentalContractView> page =new Query<RentalContractView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RentalContractVO> selectListVO(Wrapper<RentalContractEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RentalContractVO selectVO(Wrapper<RentalContractEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RentalContractView> selectListView(Wrapper<RentalContractEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RentalContractView selectView(Wrapper<RentalContractEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
