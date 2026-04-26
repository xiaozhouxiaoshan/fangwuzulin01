package com.dao;

import com.entity.RepairHandlingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RepairHandlingVO;
import com.entity.view.RepairHandlingView;


/**
 * 维修处理
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface RepairHandlingDao extends BaseMapper<RepairHandlingEntity> {
	
	List<RepairHandlingVO> selectListVO(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
	
	RepairHandlingVO selectVO(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
	
	List<RepairHandlingView> selectListView(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);

	List<RepairHandlingView> selectListView(Pagination page,@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
	
	RepairHandlingView selectView(@Param("ew") Wrapper<RepairHandlingEntity> wrapper);
	
}
