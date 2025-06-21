package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 家长学生
 *
 * @author 
 * @email
 */
@TableName("jiazhangxuesheng")
public class JiazhangxueshengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiazhangxueshengEntity() {

	}

	public JiazhangxueshengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 家长姓名
     */
    @TableField(value = "jiazhangxuesheng_jiazhangname")

    private String jiazhangxueshengJiazhangname;


    /**
     * 家长联系方式
     */
    @TableField(value = "jiazhangxuesheng_phone")

    private String jiazhangxueshengPhone;


    /**
     * 学号
     */
    @TableField(value = "jiazhangxuesheng_uuid_number")

    private String jiazhangxueshengUuidNumber;


    /**
     * 学生姓名
     */
    @TableField(value = "jiazhangxuesheng_xuesheng")

    private String jiazhangxueshengXuesheng;


    /**
     * 学生身份证号
     */
    @TableField(value = "jiazhangxuesheng_id_number")

    private String jiazhangxueshengIdNumber;


    /**
     * 学生头像
     */
    @TableField(value = "jiazhangxuesheng_photo")

    private String jiazhangxueshengPhoto;


    /**
     * 学生性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 班级
     */
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 年级
     */
    @TableField(value = "jiazhangxuesheng_nianji")

    private String jiazhangxueshengNianji;


    /**
     * 联系邮箱
     */
    @TableField(value = "jiazhangxuesheng_email")

    private String jiazhangxueshengEmail;


    /**
     * 现有余额
     */
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：家长姓名
	 */
    public String getJiazhangxueshengJiazhangname() {
        return jiazhangxueshengJiazhangname;
    }
    /**
	 * 获取：家长姓名
	 */

    public void setJiazhangxueshengJiazhangname(String jiazhangxueshengJiazhangname) {
        this.jiazhangxueshengJiazhangname = jiazhangxueshengJiazhangname;
    }
    /**
	 * 设置：家长联系方式
	 */
    public String getJiazhangxueshengPhone() {
        return jiazhangxueshengPhone;
    }
    /**
	 * 获取：家长联系方式
	 */

    public void setJiazhangxueshengPhone(String jiazhangxueshengPhone) {
        this.jiazhangxueshengPhone = jiazhangxueshengPhone;
    }
    /**
	 * 设置：学号
	 */
    public String getJiazhangxueshengUuidNumber() {
        return jiazhangxueshengUuidNumber;
    }
    /**
	 * 获取：学号
	 */

    public void setJiazhangxueshengUuidNumber(String jiazhangxueshengUuidNumber) {
        this.jiazhangxueshengUuidNumber = jiazhangxueshengUuidNumber;
    }
    /**
	 * 设置：学生姓名
	 */
    public String getJiazhangxueshengXuesheng() {
        return jiazhangxueshengXuesheng;
    }
    /**
	 * 获取：学生姓名
	 */

    public void setJiazhangxueshengXuesheng(String jiazhangxueshengXuesheng) {
        this.jiazhangxueshengXuesheng = jiazhangxueshengXuesheng;
    }
    /**
	 * 设置：学生身份证号
	 */
    public String getJiazhangxueshengIdNumber() {
        return jiazhangxueshengIdNumber;
    }
    /**
	 * 获取：学生身份证号
	 */

    public void setJiazhangxueshengIdNumber(String jiazhangxueshengIdNumber) {
        this.jiazhangxueshengIdNumber = jiazhangxueshengIdNumber;
    }
    /**
	 * 设置：学生头像
	 */
    public String getJiazhangxueshengPhoto() {
        return jiazhangxueshengPhoto;
    }
    /**
	 * 获取：学生头像
	 */

    public void setJiazhangxueshengPhoto(String jiazhangxueshengPhoto) {
        this.jiazhangxueshengPhoto = jiazhangxueshengPhoto;
    }
    /**
	 * 设置：学生性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：学生性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }
    /**
	 * 获取：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 设置：年级
	 */
    public String getJiazhangxueshengNianji() {
        return jiazhangxueshengNianji;
    }
    /**
	 * 获取：年级
	 */

    public void setJiazhangxueshengNianji(String jiazhangxueshengNianji) {
        this.jiazhangxueshengNianji = jiazhangxueshengNianji;
    }
    /**
	 * 设置：联系邮箱
	 */
    public String getJiazhangxueshengEmail() {
        return jiazhangxueshengEmail;
    }
    /**
	 * 获取：联系邮箱
	 */

    public void setJiazhangxueshengEmail(String jiazhangxueshengEmail) {
        this.jiazhangxueshengEmail = jiazhangxueshengEmail;
    }
    /**
	 * 设置：现有余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }
    /**
	 * 获取：现有余额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiazhangxuesheng{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiazhangxueshengJiazhangname=" + jiazhangxueshengJiazhangname +
            ", jiazhangxueshengPhone=" + jiazhangxueshengPhone +
            ", jiazhangxueshengUuidNumber=" + jiazhangxueshengUuidNumber +
            ", jiazhangxueshengXuesheng=" + jiazhangxueshengXuesheng +
            ", jiazhangxueshengIdNumber=" + jiazhangxueshengIdNumber +
            ", jiazhangxueshengPhoto=" + jiazhangxueshengPhoto +
            ", sexTypes=" + sexTypes +
            ", banjiTypes=" + banjiTypes +
            ", jiazhangxueshengNianji=" + jiazhangxueshengNianji +
            ", jiazhangxueshengEmail=" + jiazhangxueshengEmail +
            ", newMoney=" + newMoney +
            ", createTime=" + createTime +
        "}";
    }
}
