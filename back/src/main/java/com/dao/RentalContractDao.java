package com.dao;

import com.entity.RentalContractEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RentalContractVO;
import com.entity.view.RentalContractView;


/**
 * 合同信息
 * 
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
public interface RentalContractDao extends BaseMapper<RentalContractEntity> {
	
	List<RentalContractVO> selectListVO(@Param("ew") Wrapper<RentalContractEntity> wrapper);
	
	RentalContractVO selectVO(@Param("ew") Wrapper<RentalContractEntity> wrapper);
	
	List<RentalContractView> selectListView(@Param("ew") Wrapper<RentalContractEntity> wrapper);

	List<RentalContractView> selectListView(Pagination page,@Param("ew") Wrapper<RentalContractEntity> wrapper);
	
	RentalContractView selectView(@Param("ew") Wrapper<RentalContractEntity> wrapper);
	
}
