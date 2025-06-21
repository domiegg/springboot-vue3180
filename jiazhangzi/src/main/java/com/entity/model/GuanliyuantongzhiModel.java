package com.entity.model;

import com.entity.GuanliyuantongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 管理员通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuanliyuantongzhiModel implements Serializable {
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
     * 管理员通知名称
     */
    private String guanliyuantongzhiName;


    /**
     * 管理员通知类型
     */
    private Integer guanliyuantongzhiTypes;


    /**
     * 管理员通知内容
     */
    private String guanliyuantongzhiContent;


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
	 * 获取：管理员通知名称
	 */
    public String getGuanliyuantongzhiName() {
        return guanliyuantongzhiName;
    }


    /**
	 * 设置：管理员通知名称
	 */
    public void setGuanliyuantongzhiName(String guanliyuantongzhiName) {
        this.guanliyuantongzhiName = guanliyuantongzhiName;
    }
    /**
	 * 获取：管理员通知类型
	 */
    public Integer getGuanliyuantongzhiTypes() {
        return guanliyuantongzhiTypes;
    }


    /**
	 * 设置：管理员通知类型
	 */
    public void setGuanliyuantongzhiTypes(Integer guanliyuantongzhiTypes) {
        this.guanliyuantongzhiTypes = guanliyuantongzhiTypes;
    }
    /**
	 * 获取：管理员通知内容
	 */
    public String getGuanliyuantongzhiContent() {
        return guanliyuantongzhiContent;
    }


    /**
	 * 设置：管理员通知内容
	 */
    public void setGuanliyuantongzhiContent(String guanliyuantongzhiContent) {
        this.guanliyuantongzhiContent = guanliyuantongzhiContent;
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
