package com.entity.model;

import com.entity.KaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 班级
     */
    private Integer banjiTypes;


    /**
     * 考试编号
     */
    private String kaoshiUuidNumber;


    /**
     * 考试名称
     */
    private String kaoshiName;


    /**
     * 年
     */
    private String kaoshiNian;


    /**
     * 学期
     */
    private Integer kaoshiTypes;


    /**
     * 考试地点
     */
    private String kaoshiAddress;


    /**
     * 考试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaoshiTime;


    /**
     * 考试详情
     */
    private String kaoshiContent;


    /**
     * 考试发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 获取：考试编号
	 */
    public String getKaoshiUuidNumber() {
        return kaoshiUuidNumber;
    }


    /**
	 * 设置：考试编号
	 */
    public void setKaoshiUuidNumber(String kaoshiUuidNumber) {
        this.kaoshiUuidNumber = kaoshiUuidNumber;
    }
    /**
	 * 获取：考试名称
	 */
    public String getKaoshiName() {
        return kaoshiName;
    }


    /**
	 * 设置：考试名称
	 */
    public void setKaoshiName(String kaoshiName) {
        this.kaoshiName = kaoshiName;
    }
    /**
	 * 获取：年
	 */
    public String getKaoshiNian() {
        return kaoshiNian;
    }


    /**
	 * 设置：年
	 */
    public void setKaoshiNian(String kaoshiNian) {
        this.kaoshiNian = kaoshiNian;
    }
    /**
	 * 获取：学期
	 */
    public Integer getKaoshiTypes() {
        return kaoshiTypes;
    }


    /**
	 * 设置：学期
	 */
    public void setKaoshiTypes(Integer kaoshiTypes) {
        this.kaoshiTypes = kaoshiTypes;
    }
    /**
	 * 获取：考试地点
	 */
    public String getKaoshiAddress() {
        return kaoshiAddress;
    }


    /**
	 * 设置：考试地点
	 */
    public void setKaoshiAddress(String kaoshiAddress) {
        this.kaoshiAddress = kaoshiAddress;
    }
    /**
	 * 获取：考试时间
	 */
    public Date getKaoshiTime() {
        return kaoshiTime;
    }


    /**
	 * 设置：考试时间
	 */
    public void setKaoshiTime(Date kaoshiTime) {
        this.kaoshiTime = kaoshiTime;
    }
    /**
	 * 获取：考试详情
	 */
    public String getKaoshiContent() {
        return kaoshiContent;
    }


    /**
	 * 设置：考试详情
	 */
    public void setKaoshiContent(String kaoshiContent) {
        this.kaoshiContent = kaoshiContent;
    }
    /**
	 * 获取：考试发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：考试发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
