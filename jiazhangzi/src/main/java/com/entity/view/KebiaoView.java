package com.entity.view;

import com.entity.KebiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 课表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kebiao")
public class KebiaoView extends KebiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 班级的值
		*/
		private String banjiValue;
		/**
		* 星期的值
		*/
		private String xingqiValue;



		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 教师手机号
			*/
			private String jiaoshiPhone;
			/**
			* 教师身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 教师头像
			*/
			private String jiaoshiPhoto;
			/**
			* 科目
			*/
			private Integer kemuTypes;
				/**
				* 科目的值
				*/
				private String kemuValue;
			/**
			* 电子邮箱
			*/
			private String jiaoshiEmail;

	public KebiaoView() {

	}

	public KebiaoView(KebiaoEntity kebiaoEntity) {
		try {
			BeanUtils.copyProperties(this, kebiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			/**
			* 获取： 星期的值
			*/
			public String getXingqiValue() {
				return xingqiValue;
			}
			/**
			* 设置： 星期的值
			*/
			public void setXingqiValue(String xingqiValue) {
				this.xingqiValue = xingqiValue;
			}


















				//级联表的get和set jiaoshi

					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}

					/**
					* 获取： 教师手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 教师手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}

					/**
					* 获取： 教师身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 教师身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}

					/**
					* 获取： 教师头像
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 教师头像
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}

					/**
					* 获取： 科目
					*/
					public Integer getKemuTypes() {
						return kemuTypes;
					}
					/**
					* 设置： 科目
					*/
					public void setKemuTypes(Integer kemuTypes) {
						this.kemuTypes = kemuTypes;
					}


						/**
						* 获取： 科目的值
						*/
						public String getKemuValue() {
							return kemuValue;
						}
						/**
						* 设置： 科目的值
						*/
						public void setKemuValue(String kemuValue) {
							this.kemuValue = kemuValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getJiaoshiEmail() {
						return jiaoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setJiaoshiEmail(String jiaoshiEmail) {
						this.jiaoshiEmail = jiaoshiEmail;
					}












}
