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
 * 成绩
 *
 * @author 
 * @email
 */
@TableName("chengji")
public class ChengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengjiEntity() {

	}

	public ChengjiEntity(T t) {
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
     * 考试
     */
    @TableField(value = "kaoshi_id")

    private Integer kaoshiId;


    /**
     * 家长学生
     */
    @TableField(value = "jiazhangxuesheng_id")

    private Integer jiazhangxueshengId;


    /**
     * 试卷答题文件
     */
    @TableField(value = "chengji_file")

    private String chengjiFile;


    /**
     * 考试得分
     */
    @TableField(value = "huida_defen")

    private Double huidaDefen;


    /**
     * 排名
     */
    @TableField(value = "paiming")

    private Integer paiming;


    /**
     * 成绩意见
     */
    @TableField(value = "huida_content")

    private String huidaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }
    /**
	 * 获取：考试
	 */

    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
    }
    /**
	 * 设置：家长学生
	 */
    public Integer getJiazhangxueshengId() {
        return jiazhangxueshengId;
    }
    /**
	 * 获取：家长学生
	 */

    public void setJiazhangxueshengId(Integer jiazhangxueshengId) {
        this.jiazhangxueshengId = jiazhangxueshengId;
    }
    /**
	 * 设置：试卷答题文件
	 */
    public String getChengjiFile() {
        return chengjiFile;
    }
    /**
	 * 获取：试卷答题文件
	 */

    public void setChengjiFile(String chengjiFile) {
        this.chengjiFile = chengjiFile;
    }
    /**
	 * 设置：考试得分
	 */
    public Double getHuidaDefen() {
        return huidaDefen;
    }
    /**
	 * 获取：考试得分
	 */

    public void setHuidaDefen(Double huidaDefen) {
        this.huidaDefen = huidaDefen;
    }
    /**
	 * 设置：排名
	 */
    public Integer getPaiming() {
        return paiming;
    }
    /**
	 * 获取：排名
	 */

    public void setPaiming(Integer paiming) {
        this.paiming = paiming;
    }
    /**
	 * 设置：成绩意见
	 */
    public String getHuidaContent() {
        return huidaContent;
    }
    /**
	 * 获取：成绩意见
	 */

    public void setHuidaContent(String huidaContent) {
        this.huidaContent = huidaContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Chengji{" +
            "id=" + id +
            ", kaoshiId=" + kaoshiId +
            ", jiazhangxueshengId=" + jiazhangxueshengId +
            ", chengjiFile=" + chengjiFile +
            ", huidaDefen=" + huidaDefen +
            ", paiming=" + paiming +
            ", huidaContent=" + huidaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
