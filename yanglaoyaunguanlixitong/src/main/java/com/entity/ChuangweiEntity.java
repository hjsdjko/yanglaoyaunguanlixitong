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
 * 床位
 *
 * @author 
 * @email
 */
@TableName("chuangwei")
public class ChuangweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuangweiEntity() {

	}

	public ChuangweiEntity(T t) {
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
     * 房间
     */
    @ColumnInfo(comment="房间",type="int(11)")
    @TableField(value = "fangjian_id")

    private Integer fangjianId;


    /**
     * 床位名称
     */
    @ColumnInfo(comment="床位名称",type="varchar(200)")
    @TableField(value = "chuangwei_name")

    private String chuangweiName;


    /**
     * 床位编号
     */
    @ColumnInfo(comment="床位编号",type="varchar(200)")
    @TableField(value = "chuangwei_uuid_number")

    private String chuangweiUuidNumber;


    /**
     * 床位照片
     */
    @ColumnInfo(comment="床位照片",type="varchar(200)")
    @TableField(value = "chuangwei_photo")

    private String chuangweiPhoto;


    /**
     * 床位地点
     */
    @ColumnInfo(comment="床位地点",type="varchar(200)")
    @TableField(value = "chuangwei_address")

    private String chuangweiAddress;


    /**
     * 床位类型
     */
    @ColumnInfo(comment="床位类型",type="int(11)")
    @TableField(value = "chuangwei_types")

    private Integer chuangweiTypes;


    /**
     * 床位介绍
     */
    @ColumnInfo(comment="床位介绍",type="longtext")
    @TableField(value = "chuangwei_content")

    private String chuangweiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chuangwei_delete")

    private Integer chuangweiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }
    /**
	 * 设置：房间
	 */

    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 获取：床位名称
	 */
    public String getChuangweiName() {
        return chuangweiName;
    }
    /**
	 * 设置：床位名称
	 */

    public void setChuangweiName(String chuangweiName) {
        this.chuangweiName = chuangweiName;
    }
    /**
	 * 获取：床位编号
	 */
    public String getChuangweiUuidNumber() {
        return chuangweiUuidNumber;
    }
    /**
	 * 设置：床位编号
	 */

    public void setChuangweiUuidNumber(String chuangweiUuidNumber) {
        this.chuangweiUuidNumber = chuangweiUuidNumber;
    }
    /**
	 * 获取：床位照片
	 */
    public String getChuangweiPhoto() {
        return chuangweiPhoto;
    }
    /**
	 * 设置：床位照片
	 */

    public void setChuangweiPhoto(String chuangweiPhoto) {
        this.chuangweiPhoto = chuangweiPhoto;
    }
    /**
	 * 获取：床位地点
	 */
    public String getChuangweiAddress() {
        return chuangweiAddress;
    }
    /**
	 * 设置：床位地点
	 */

    public void setChuangweiAddress(String chuangweiAddress) {
        this.chuangweiAddress = chuangweiAddress;
    }
    /**
	 * 获取：床位类型
	 */
    public Integer getChuangweiTypes() {
        return chuangweiTypes;
    }
    /**
	 * 设置：床位类型
	 */

    public void setChuangweiTypes(Integer chuangweiTypes) {
        this.chuangweiTypes = chuangweiTypes;
    }
    /**
	 * 获取：床位介绍
	 */
    public String getChuangweiContent() {
        return chuangweiContent;
    }
    /**
	 * 设置：床位介绍
	 */

    public void setChuangweiContent(String chuangweiContent) {
        this.chuangweiContent = chuangweiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChuangweiDelete() {
        return chuangweiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChuangweiDelete(Integer chuangweiDelete) {
        this.chuangweiDelete = chuangweiDelete;
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

    @Override
    public String toString() {
        return "Chuangwei{" +
            ", id=" + id +
            ", fangjianId=" + fangjianId +
            ", chuangweiName=" + chuangweiName +
            ", chuangweiUuidNumber=" + chuangweiUuidNumber +
            ", chuangweiPhoto=" + chuangweiPhoto +
            ", chuangweiAddress=" + chuangweiAddress +
            ", chuangweiTypes=" + chuangweiTypes +
            ", chuangweiContent=" + chuangweiContent +
            ", chuangweiDelete=" + chuangweiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
