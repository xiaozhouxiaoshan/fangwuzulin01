package com.entity.view;

import com.entity.LandlordApplicationCommentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 我要当房主评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-04 18:46:21
 */
@TableName("landlordApplicationComment")
public class LandlordApplicationCommentView  extends LandlordApplicationCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LandlordApplicationCommentView(){
	}
 
 	public LandlordApplicationCommentView(LandlordApplicationCommentEntity landlordApplicationCommentEntity){
 	try {
			BeanUtils.copyProperties(this, landlordApplicationCommentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
