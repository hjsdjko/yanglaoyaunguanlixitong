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
 * 房间
 *
 * @author 
 * @email
 */
@TableName("fangjian")
public class FangjianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangjianEntity() {

	}

	public FangjianEntity(T t) {
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
     * 房间名称
     */
    @ColumnInfo(comment="房间名称",type="varchar(200)")
    @TableField(value = "fangjian_name")

    private String fangjianName;


    /**
     * 房间编号
     */
    @ColumnInfo(comment="房间编号",type="varchar(200)")
    @TableField(value = "fangjian_uuid_number")

    private String fangjianUuidNumber;


    /**
     * 房间照片
     */
    @ColumnInfo(comment="房间照片",type="varchar(200)")
    @TableField(value = "fangjian_photo")

    private String fangjianPhoto;


    /**
     * 房间地点
     */
    @ColumnInfo(comment="房间地点",type="varchar(200)")
    @TableField(value = "fangjian_address")

    private String fangjianAddress;


    /**
     * 房间类型
     */
    @ColumnInfo(comment="房间类型",type="int(11)")
    @TableField(value = "fangjian_types")

    private Integer fangjianTypes;


    /**
     * 房间介绍
     */
    @ColumnInfo(comment="房间介绍",type="longtext")
    @TableField(value = "fangjian_content")

    private String fangjianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangjian_delete")

    private Integer fangjianDelete;


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
	 * 获取：房间名称
	 */
    public String getFangjianName() {
        return fangjianName;
    }
    /**
	 * 设置：房间名称
	 */

    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 获取：房间编号
	 */
    public String getFangjianUuidNumber() {
        return fangjianUuidNumber;
    }
    /**
	 * 设置：房间编号
	 */

    public void setFangjianUuidNumber(String fangjianUuidNumber) {
        this.fangjianUuidNumber = fangjianUuidNumber;
    }
    /**
	 * 获取：房间照片
	 */
    public String getFangjianPhoto() {
        return fangjianPhoto;
    }
    /**
	 * 设置：房间照片
	 */

    public void setFangjianPhoto(String fangjianPhoto) {
        this.fangjianPhoto = fangjianPhoto;
    }
    /**
	 * 获取：房间地点
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }
    /**
	 * 设置：房间地点
	 */

    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 获取：房间类型
	 */
    public Integer getFangjianTypes() {
        return fangjianTypes;
    }
    /**
	 * 设置：房间类型
	 */

    public void setFangjianTypes(Integer fangjianTypes) {
        this.fangjianTypes = fangjianTypes;
    }
    /**
	 * 获取：房间介绍
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }
    /**
	 * 设置：房间介绍
	 */

    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangjianDelete() {
        return fangjianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangjianDelete(Integer fangjianDelete) {
        this.fangjianDelete = fangjianDelete;
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
        return "Fangjian{" +
            ", id=" + id +
            ", fangjianName=" + fangjianName +
            ", fangjianUuidNumber=" + fangjianUuidNumber +
            ", fangjianPhoto=" + fangjianPhoto +
            ", fangjianAddress=" + fangjianAddress +
            ", fangjianTypes=" + fangjianTypes +
            ", fangjianContent=" + fangjianContent +
            ", fangjianDelete=" + fangjianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
