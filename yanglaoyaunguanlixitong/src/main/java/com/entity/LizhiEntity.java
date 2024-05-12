package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 离职申请
 *
 * @author 
 * @email
 */
@TableName("lizhi")
public class LizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LizhiEntity() {

	}

	public LizhiEntity(T t) {
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
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "lizhi_uuid_number")

    private String lizhiUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "lizhi_text")

    private String lizhiText;


    /**
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="离职申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "lizhi_yesno_types")

    private Integer lizhiYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "lizhi_yesno_text")

    private String lizhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "lizhi_shenhe_time")

    private Date lizhiShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：报名编号
	 */
    public String getLizhiUuidNumber() {
        return lizhiUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setLizhiUuidNumber(String lizhiUuidNumber) {
        this.lizhiUuidNumber = lizhiUuidNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getLizhiText() {
        return lizhiText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setLizhiText(String lizhiText) {
        this.lizhiText = lizhiText;
    }
    /**
	 * 获取：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：离职申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getLizhiYesnoTypes() {
        return lizhiYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setLizhiYesnoTypes(Integer lizhiYesnoTypes) {
        this.lizhiYesnoTypes = lizhiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getLizhiYesnoText() {
        return lizhiYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setLizhiYesnoText(String lizhiYesnoText) {
        this.lizhiYesnoText = lizhiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLizhiShenheTime() {
        return lizhiShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setLizhiShenheTime(Date lizhiShenheTime) {
        this.lizhiShenheTime = lizhiShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Lizhi{" +
            ", id=" + id +
            ", lizhiUuidNumber=" + lizhiUuidNumber +
            ", yonghuId=" + yonghuId +
            ", lizhiText=" + lizhiText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", lizhiYesnoTypes=" + lizhiYesnoTypes +
            ", lizhiYesnoText=" + lizhiYesnoText +
            ", lizhiShenheTime=" + DateUtil.convertString(lizhiShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
