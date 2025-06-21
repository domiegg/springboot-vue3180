package com.entity.model;

import com.entity.YijianjianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 意见建议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YijianjianyiModel implements Serializable {
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
     * 意见建议名称
     */
    private String yijianjianyiName;


    /**
     * 意见建议类型
     */
    private Integer yijianjianyiTypes;


    /**
     * 意见建议详情
     */
    private String yijianjianyiContent;


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
	 * 获取：意见建议名称
	 */
    public String getYijianjianyiName() {
        return yijianjianyiName;
    }


    /**
	 * 设置：意见建议名称
	 */
    public void setYijianjianyiName(String yijianjianyiName) {
        this.yijianjianyiName = yijianjianyiName;
    }
    /**
	 * 获取：意见建议类型
	 */
    public Integer getYijianjianyiTypes() {
        return yijianjianyiTypes;
    }


    /**
	 * 设置：意见建议类型
	 */
    public void setYijianjianyiTypes(Integer yijianjianyiTypes) {
        this.yijianjianyiTypes = yijianjianyiTypes;
    }
    /**
	 * 获取：意见建议详情
	 */
    public String getYijianjianyiContent() {
        return yijianjianyiContent;
    }


    /**
	 * 设置：意见建议详情
	 */
    public void setYijianjianyiContent(String yijianjianyiContent) {
        this.yijianjianyiContent = yijianjianyiContent;
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
