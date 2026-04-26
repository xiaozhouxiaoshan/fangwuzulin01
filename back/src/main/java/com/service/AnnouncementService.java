package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnnouncementEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnnouncementVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnnouncementView;


/**
 * 公告信息
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface AnnouncementService extends IService<AnnouncementEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnnouncementVO> selectListVO(Wrapper<AnnouncementEntity> wrapper);
   	
   	AnnouncementVO selectVO(@Param("ew") Wrapper<AnnouncementEntity> wrapper);
   	
   	List<AnnouncementView> selectListView(Wrapper<AnnouncementEntity> wrapper);
   	
   	AnnouncementView selectView(@Param("ew") Wrapper<AnnouncementEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnnouncementEntity> wrapper);
   	
}

