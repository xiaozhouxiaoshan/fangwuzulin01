package com.dao;

import com.entity.AnnouncementEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnnouncementVO;
import com.entity.view.AnnouncementView;


/**
 * 公告信息
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface AnnouncementDao extends BaseMapper<AnnouncementEntity> {
	
	List<AnnouncementVO> selectListVO(@Param("ew") Wrapper<AnnouncementEntity> wrapper);
	
	AnnouncementVO selectVO(@Param("ew") Wrapper<AnnouncementEntity> wrapper);
	
	List<AnnouncementView> selectListView(@Param("ew") Wrapper<AnnouncementEntity> wrapper);

	List<AnnouncementView> selectListView(Pagination page,@Param("ew") Wrapper<AnnouncementEntity> wrapper);
	
	AnnouncementView selectView(@Param("ew") Wrapper<AnnouncementEntity> wrapper);
	
}
