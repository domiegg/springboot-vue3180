package com.entity.view;

import com.entity.JiazhangxueshengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 家长学生
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiazhangxuesheng")
public class JiazhangxueshengView extends JiazhangxueshengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 学生性别的值
		*/
		private String sexValue;
		/**
		* 班级的值
		*/
		private String banjiValue;



	public JiazhangxueshengView() {

	}

	public JiazhangxueshengView(JiazhangxueshengEntity jiazhangxueshengEntity) {
		try {
			BeanUtils.copyProperties(this, jiazhangxueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 学生性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 学生性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 班级的值
			*/
			public String getBanjiValue() {
				return banjiValue;
			}
			/**
			* 设置： 班级的值
			*/
			public void setBanjiValue(String banjiValue) {
				this.banjiValue = banjiValue;
			}
















}
