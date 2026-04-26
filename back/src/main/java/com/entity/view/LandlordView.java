package com.entity.view;

import com.entity.LandlordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 房主
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("landlord")
public class LandlordView  extends LandlordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LandlordView(){
	}
 
 	public LandlordView(LandlordEntity landlordEntity){
 	try {
			BeanUtils.copyProperties(this, landlordEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
