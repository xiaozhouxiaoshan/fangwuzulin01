
package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AdminUserDao;
import com.entity.AdminUserEntity;
import com.service.AdminUserService;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 系统用户
 */
@Service("userService")
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao, AdminUserEntity> implements AdminUserService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<AdminUserEntity> page = this.selectPage(
                new Query<AdminUserEntity>(params).getPage(),
                new EntityWrapper<AdminUserEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<AdminUserEntity> selectListView(Wrapper<AdminUserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<AdminUserEntity> wrapper) {
		 Page<AdminUserEntity> page =new Query<AdminUserEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}
}
