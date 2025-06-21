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
 * 缴费
 *
 * @author 
 * @email
 */
@TableName("jiaofei")
public class JiaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaofeiEntity() {

	}

	public JiaofeiEntity(T t) {
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
     * 家长学生
     */
    @TableField(value = "jiazhangxuesheng_id")

    private Integer jiazhangxueshengId;


    /**
     * 缴费名称
     */
    @TableField(value = "jiaofei_name")

    private String jiaofeiName;


    /**
     * 缴费类型
     */
    @TableField(value = "jiaofei_types")

    private Integer jiaofeiTypes;


    /**
     * 缴费金额
     */
    @TableField(value = "shangdian_shouyin_true_price")

    private Double shangdianShouyinTruePrice;


    /**
     * 缴费详情
     */
    @TableField(value = "jiaofei_content")

    private String jiaofeiContent;


    /**
     * 是否缴费
     */
    @TableField(value = "jiaofei_shifou_types")

    private Integer jiaofeiShifouTypes;


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
	 * 设置：缴费名称
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }
    /**
	 * 获取：缴费名称
	 */

    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 设置：缴费类型
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }
    /**
	 * 获取：缴费类型
	 */

    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getShangdianShouyinTruePrice() {
        return shangdianShouyinTruePrice;
    }
    /**
	 * 获取：缴费金额
	 */

    public void setShangdianShouyinTruePrice(Double shangdianShouyinTruePrice) {
        this.shangdianShouyinTruePrice = shangdianShouyinTruePrice;
    }
    /**
	 * 设置：缴费详情
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }
    /**
	 * 获取：缴费详情
	 */

    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 设置：是否缴费
	 */
    public Integer getJiaofeiShifouTypes() {
        return jiaofeiShifouTypes;
    }
    /**
	 * 获取：是否缴费
	 */

    public void setJiaofeiShifouTypes(Integer jiaofeiShifouTypes) {
        this.jiaofeiShifouTypes = jiaofeiShifouTypes;
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
        return "Jiaofei{" +
            "id=" + id +
            ", jiazhangxueshengId=" + jiazhangxueshengId +
            ", jiaofeiName=" + jiaofeiName +
            ", jiaofeiTypes=" + jiaofeiTypes +
            ", shangdianShouyinTruePrice=" + shangdianShouyinTruePrice +
            ", jiaofeiContent=" + jiaofeiContent +
            ", jiaofeiShifouTypes=" + jiaofeiShifouTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
