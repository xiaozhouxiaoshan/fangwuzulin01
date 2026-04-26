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


import com.dao.MessageBoardDao;
import com.entity.MessageBoardEntity;
import com.service.MessageBoardService;
import com.entity.vo.MessageBoardVO;
import com.entity.view.MessageBoardView;

@Service("messageBoardService")
public class MessageBoardServiceImpl extends ServiceImpl<MessageBoardDao, MessageBoardEntity> implements MessageBoardService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MessageBoardEntity> page = this.selectPage(
                new Query<MessageBoardEntity>(params).getPage(),
                new EntityWrapper<MessageBoardEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MessageBoardEntity> wrapper) {
		  Page<MessageBoardView> page =new Query<MessageBoardView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MessageBoardVO> selectListVO(Wrapper<MessageBoardEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MessageBoardVO selectVO(Wrapper<MessageBoardEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MessageBoardView> selectListView(Wrapper<MessageBoardEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MessageBoardView selectView(Wrapper<MessageBoardEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
