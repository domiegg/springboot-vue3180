package com.entity.model;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考试
     */
    private Integer kaoshiId;


    /**
     * 家长学生
     */
    private Integer jiazhangxueshengId;


    /**
     * 试卷答题文件
     */
    private String chengjiFile;


    /**
     * 考试得分
     */
    private Double huidaDefen;


    /**
     * 排名
     */
    private Integer paiming;


    /**
     * 成绩意见
     */
    private String huidaContent;


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
	 * 获取：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }


    /**
	 * 设置：考试
	 */
    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
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
	 * 获取：试卷答题文件
	 */
    public String getChengjiFile() {
        return chengjiFile;
    }


    /**
	 * 设置：试卷答题文件
	 */
    public void setChengjiFile(String chengjiFile) {
        this.chengjiFile = chengjiFile;
    }
    /**
	 * 获取：考试得分
	 */
    public Double getHuidaDefen() {
        return huidaDefen;
    }


    /**
	 * 设置：考试得分
	 */
    public void setHuidaDefen(Double huidaDefen) {
        this.huidaDefen = huidaDefen;
    }
    /**
	 * 获取：排名
	 */
    public Integer getPaiming() {
        return paiming;
    }


    /**
	 * 设置：排名
	 */
    public void setPaiming(Integer paiming) {
        this.paiming = paiming;
    }
    /**
	 * 获取：成绩意见
	 */
    public String getHuidaContent() {
        return huidaContent;
    }


    /**
	 * 设置：成绩意见
	 */
    public void setHuidaContent(String huidaContent) {
        this.huidaContent = huidaContent;
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
