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
 * 意见建议
 *
 * @author 
 * @email
 */
@TableName("yijianjianyi")
public class YijianjianyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YijianjianyiEntity() {

	}

	public YijianjianyiEntity(T t) {
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
     * 意见建议名称
     */
    @TableField(value = "yijianjianyi_name")

    private String yijianjianyiName;


    /**
     * 意见建议类型
     */
    @TableField(value = "yijianjianyi_types")

    private Integer yijianjianyiTypes;


    /**
     * 意见建议详情
     */
    @TableField(value = "yijianjianyi_content")

    private String yijianjianyiContent;


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
	 * 设置：意见建议名称
	 */
    public String getYijianjianyiName() {
        return yijianjianyiName;
    }
    /**
	 * 获取：意见建议名称
	 */

    public void setYijianjianyiName(String yijianjianyiName) {
        this.yijianjianyiName = yijianjianyiName;
    }
    /**
	 * 设置：意见建议类型
	 */
    public Integer getYijianjianyiTypes() {
        return yijianjianyiTypes;
    }
    /**
	 * 获取：意见建议类型
	 */

    public void setYijianjianyiTypes(Integer yijianjianyiTypes) {
        this.yijianjianyiTypes = yijianjianyiTypes;
    }
    /**
	 * 设置：意见建议详情
	 */
    public String getYijianjianyiContent() {
        return yijianjianyiContent;
    }
    /**
	 * 获取：意见建议详情
	 */

    public void setYijianjianyiContent(String yijianjianyiContent) {
        this.yijianjianyiContent = yijianjianyiContent;
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
        return "Yijianjianyi{" +
            "id=" + id +
            ", jiazhangxueshengId=" + jiazhangxueshengId +
            ", yijianjianyiName=" + yijianjianyiName +
            ", yijianjianyiTypes=" + yijianjianyiTypes +
            ", yijianjianyiContent=" + yijianjianyiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
