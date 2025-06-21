package com.entity.vo;

import com.entity.BanzhurentongzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 班主任通知
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("banzhurentongzhi")
public class BanzhurentongzhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 家长学生
     */

    @TableField(value = "jiazhangxuesheng_id")
    private Integer jiazhangxueshengId;


    /**
     * 班主任通知名称
     */

    @TableField(value = "banzhurentongzhi_name")
    private String banzhurentongzhiName;


    /**
     * 班主任通知类型
     */

    @TableField(value = "banzhurentongzhi_types")
    private Integer banzhurentongzhiTypes;


    /**
     * 班主任通知详情
     */

    @TableField(value = "banzhurentongzhi_content")
    private String banzhurentongzhiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 设置：班主任通知名称
	 */
    public String getBanzhurentongzhiName() {
        return banzhurentongzhiName;
    }


    /**
	 * 获取：班主任通知名称
	 */

    public void setBanzhurentongzhiName(String banzhurentongzhiName) {
        this.banzhurentongzhiName = banzhurentongzhiName;
    }
    /**
	 * 设置：班主任通知类型
	 */
    public Integer getBanzhurentongzhiTypes() {
        return banzhurentongzhiTypes;
    }


    /**
	 * 获取：班主任通知类型
	 */

    public void setBanzhurentongzhiTypes(Integer banzhurentongzhiTypes) {
        this.banzhurentongzhiTypes = banzhurentongzhiTypes;
    }
    /**
	 * 设置：班主任通知详情
	 */
    public String getBanzhurentongzhiContent() {
        return banzhurentongzhiContent;
    }


    /**
	 * 获取：班主任通知详情
	 */

    public void setBanzhurentongzhiContent(String banzhurentongzhiContent) {
        this.banzhurentongzhiContent = banzhurentongzhiContent;
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

}
