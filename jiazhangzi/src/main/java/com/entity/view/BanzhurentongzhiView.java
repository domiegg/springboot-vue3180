package com.entity.view;

import com.entity.BanzhurentongzhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 班主任通知
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("banzhurentongzhi")
public class BanzhurentongzhiView extends BanzhurentongzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 班主任通知类型的值
		*/
		private String banzhurentongzhiValue;



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

		//级联表 jiazhangxuesheng
			/**
			* 家长姓名
			*/
			private String jiazhangxueshengJiazhangname;
			/**
			* 家长联系方式
			*/
			private String jiazhangxueshengPhone;
			/**
			* 学号
			*/
			private String jiazhangxueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String jiazhangxueshengXuesheng;
			/**
			* 学生身份证号
			*/
			private String jiazhangxueshengIdNumber;
			/**
			* 学生头像
			*/
			private String jiazhangxueshengPhoto;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 年级
			*/
			private String jiazhangxueshengNianji;
			/**
			* 联系邮箱
			*/
			private String jiazhangxueshengEmail;
			/**
			* 现有余额
			*/
			private Double newMoney;

	public BanzhurentongzhiView() {

	}

	public BanzhurentongzhiView(BanzhurentongzhiEntity banzhurentongzhiEntity) {
		try {
			BeanUtils.copyProperties(this, banzhurentongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 班主任通知类型的值
			*/
			public String getBanzhurentongzhiValue() {
				return banzhurentongzhiValue;
			}
			/**
			* 设置： 班主任通知类型的值
			*/
			public void setBanzhurentongzhiValue(String banzhurentongzhiValue) {
				this.banzhurentongzhiValue = banzhurentongzhiValue;
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




				//级联表的get和set jiazhangxuesheng

					/**
					* 获取： 家长姓名
					*/
					public String getJiazhangxueshengJiazhangname() {
						return jiazhangxueshengJiazhangname;
					}
					/**
					* 设置： 家长姓名
					*/
					public void setJiazhangxueshengJiazhangname(String jiazhangxueshengJiazhangname) {
						this.jiazhangxueshengJiazhangname = jiazhangxueshengJiazhangname;
					}

					/**
					* 获取： 家长联系方式
					*/
					public String getJiazhangxueshengPhone() {
						return jiazhangxueshengPhone;
					}
					/**
					* 设置： 家长联系方式
					*/
					public void setJiazhangxueshengPhone(String jiazhangxueshengPhone) {
						this.jiazhangxueshengPhone = jiazhangxueshengPhone;
					}

					/**
					* 获取： 学号
					*/
					public String getJiazhangxueshengUuidNumber() {
						return jiazhangxueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setJiazhangxueshengUuidNumber(String jiazhangxueshengUuidNumber) {
						this.jiazhangxueshengUuidNumber = jiazhangxueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getJiazhangxueshengXuesheng() {
						return jiazhangxueshengXuesheng;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setJiazhangxueshengXuesheng(String jiazhangxueshengXuesheng) {
						this.jiazhangxueshengXuesheng = jiazhangxueshengXuesheng;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getJiazhangxueshengIdNumber() {
						return jiazhangxueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setJiazhangxueshengIdNumber(String jiazhangxueshengIdNumber) {
						this.jiazhangxueshengIdNumber = jiazhangxueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getJiazhangxueshengPhoto() {
						return jiazhangxueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setJiazhangxueshengPhoto(String jiazhangxueshengPhoto) {
						this.jiazhangxueshengPhoto = jiazhangxueshengPhoto;
					}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
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
					* 获取： 年级
					*/
					public String getJiazhangxueshengNianji() {
						return jiazhangxueshengNianji;
					}
					/**
					* 设置： 年级
					*/
					public void setJiazhangxueshengNianji(String jiazhangxueshengNianji) {
						this.jiazhangxueshengNianji = jiazhangxueshengNianji;
					}

					/**
					* 获取： 联系邮箱
					*/
					public String getJiazhangxueshengEmail() {
						return jiazhangxueshengEmail;
					}
					/**
					* 设置： 联系邮箱
					*/
					public void setJiazhangxueshengEmail(String jiazhangxueshengEmail) {
						this.jiazhangxueshengEmail = jiazhangxueshengEmail;
					}

					/**
					* 获取： 现有余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 现有余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}















}
