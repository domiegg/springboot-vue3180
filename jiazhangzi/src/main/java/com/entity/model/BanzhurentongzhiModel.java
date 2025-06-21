package com.entity.model;

import com.entity.BanzhurentongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 班主任通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BanzhurentongzhiModel implements Serializable {
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
     * 家长学生
     */
    private Integer jiazhangxueshengId;


    /**
     * 班主任通知名称
     */
    private String banzhurentongzhiName;


    /**
     * 班主任通知类型
     */
    private Integer banzhurentongzhiTypes;


    /**
     * 班主任通知详情
     */
    private String banzhurentongzhiContent;


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
	 * 获取：班主任通知名称
	 */
    public String getBanzhurentongzhiName() {
        return banzhurentongzhiName;
    }


    /**
	 * 设置：班主任通知名称
	 */
    public void setBanzhurentongzhiName(String banzhurentongzhiName) {
        this.banzhurentongzhiName = banzhurentongzhiName;
    }
    /**
	 * 获取：班主任通知类型
	 */
    public Integer getBanzhurentongzhiTypes() {
        return banzhurentongzhiTypes;
    }


    /**
	 * 设置：班主任通知类型
	 */
    public void setBanzhurentongzhiTypes(Integer banzhurentongzhiTypes) {
        this.banzhurentongzhiTypes = banzhurentongzhiTypes;
    }
    /**
	 * 获取：班主任通知详情
	 */
    public String getBanzhurentongzhiContent() {
        return banzhurentongzhiContent;
    }


    /**
	 * 设置：班主任通知详情
	 */
    public void setBanzhurentongzhiContent(String banzhurentongzhiContent) {
        this.banzhurentongzhiContent = banzhurentongzhiContent;
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
