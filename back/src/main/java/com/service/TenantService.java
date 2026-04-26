package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TenantEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TenantVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TenantView;


/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface TenantService extends IService<TenantEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TenantVO> selectListVO(Wrapper<TenantEntity> wrapper);
   	
   	TenantVO selectVO(@Param("ew") Wrapper<TenantEntity> wrapper);
   	
   	List<TenantView> selectListView(Wrapper<TenantEntity> wrapper);
   	
   	TenantView selectView(@Param("ew") Wrapper<TenantEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TenantEntity> wrapper);
   	
}

