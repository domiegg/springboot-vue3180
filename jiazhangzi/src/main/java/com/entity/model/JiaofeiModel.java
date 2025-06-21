package com.entity.model;

import com.entity.JiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 缴费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 家长学生
     */
    private Integer jiazhangxueshengId;


    /**
     * 缴费名称
     */
    private String jiaofeiName;


    /**
     * 缴费类型
     */
    private Integer jiaofeiTypes;


    /**
     * 缴费金额
     */
    private Double shangdianShouyinTruePrice;


    /**
     * 缴费详情
     */
    private String jiaofeiContent;


    /**
     * 是否缴费
     */
    private Integer jiaofeiShifouTypes;


    /**
     * 录入时间
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
	 * 获取：家长学生
	 */
    public Integer getJiazhangxueshengId() {
        return jiazhangxueshengId;
    }


    /**
	 * 设置：家长学生
	 */
    public void setJiazhangxueshengId(Integer jiazhangxueshengId) {
        this.jiazhangxueshengId = jiazhangxueshengId;
    }
    /**
	 * 获取：缴费名称
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }


    /**
	 * 设置：缴费名称
	 */
    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 获取：缴费类型
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }


    /**
	 * 设置：缴费类型
	 */
    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 获取：缴费金额
	 */
    public Double getShangdianShouyinTruePrice() {
        return shangdianShouyinTruePrice;
    }


    /**
	 * 设置：缴费金额
	 */
    public void setShangdianShouyinTruePrice(Double shangdianShouyinTruePrice) {
        this.shangdianShouyinTruePrice = shangdianShouyinTruePrice;
    }
    /**
	 * 获取：缴费详情
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }


    /**
	 * 设置：缴费详情
	 */
    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 获取：是否缴费
	 */
    public Integer getJiaofeiShifouTypes() {
        return jiaofeiShifouTypes;
    }


    /**
	 * 设置：是否缴费
	 */
    public void setJiaofeiShifouTypes(Integer jiaofeiShifouTypes) {
        this.jiaofeiShifouTypes = jiaofeiShifouTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
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
