package com.entity.model;

import com.entity.JiazhangxueshengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家长学生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiazhangxueshengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


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
     * 学生性别
     */
    private Integer sexTypes;


    /**
     * 班级
     */
    private Integer banjiTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：家长姓名
	 */
    public String getJiazhangxueshengJiazhangname() {
        return jiazhangxueshengJiazhangname;
    }


    /**
	 * 设置：家长姓名
	 */
    public void setJiazhangxueshengJiazhangname(String jiazhangxueshengJiazhangname) {
        this.jiazhangxueshengJiazhangname = jiazhangxueshengJiazhangname;
    }
    /**
	 * 获取：家长联系方式
	 */
    public String getJiazhangxueshengPhone() {
        return jiazhangxueshengPhone;
    }


    /**
	 * 设置：家长联系方式
	 */
    public void setJiazhangxueshengPhone(String jiazhangxueshengPhone) {
        this.jiazhangxueshengPhone = jiazhangxueshengPhone;
    }
    /**
	 * 获取：学号
	 */
    public String getJiazhangxueshengUuidNumber() {
        return jiazhangxueshengUuidNumber;
    }


    /**
	 * 设置：学号
	 */
    public void setJiazhangxueshengUuidNumber(String jiazhangxueshengUuidNumber) {
        this.jiazhangxueshengUuidNumber = jiazhangxueshengUuidNumber;
    }
    /**
	 * 获取：学生姓名
	 */
    public String getJiazhangxueshengXuesheng() {
        return jiazhangxueshengXuesheng;
    }


    /**
	 * 设置：学生姓名
	 */
    public void setJiazhangxueshengXuesheng(String jiazhangxueshengXuesheng) {
        this.jiazhangxueshengXuesheng = jiazhangxueshengXuesheng;
    }
    /**
	 * 获取：学生身份证号
	 */
    public String getJiazhangxueshengIdNumber() {
        return jiazhangxueshengIdNumber;
    }


    /**
	 * 设置：学生身份证号
	 */
    public void setJiazhangxueshengIdNumber(String jiazhangxueshengIdNumber) {
        this.jiazhangxueshengIdNumber = jiazhangxueshengIdNumber;
    }
    /**
	 * 获取：学生头像
	 */
    public String getJiazhangxueshengPhoto() {
        return jiazhangxueshengPhoto;
    }


    /**
	 * 设置：学生头像
	 */
    public void setJiazhangxueshengPhoto(String jiazhangxueshengPhoto) {
        this.jiazhangxueshengPhoto = jiazhangxueshengPhoto;
    }
    /**
	 * 获取：学生性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：学生性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }


    /**
	 * 设置：班级
	 */
    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 获取：年级
	 */
    public String getJiazhangxueshengNianji() {
        return jiazhangxueshengNianji;
    }


    /**
	 * 设置：年级
	 */
    public void setJiazhangxueshengNianji(String jiazhangxueshengNianji) {
        this.jiazhangxueshengNianji = jiazhangxueshengNianji;
    }
    /**
	 * 获取：联系邮箱
	 */
    public String getJiazhangxueshengEmail() {
        return jiazhangxueshengEmail;
    }


    /**
	 * 设置：联系邮箱
	 */
    public void setJiazhangxueshengEmail(String jiazhangxueshengEmail) {
        this.jiazhangxueshengEmail = jiazhangxueshengEmail;
    }
    /**
	 * 获取：现有余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：现有余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
