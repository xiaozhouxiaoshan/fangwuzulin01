package com.entity.view;

import com.entity.HouseRepairEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 房屋报修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("houseRepair")
public class HouseRepairView  extends HouseRepairEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HouseRepairView(){
	}
 
 	public HouseRepairView(HouseRepairEntity houseRepairEntity){
 	try {
			BeanUtils.copyProperties(this, houseRepairEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
