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
 * 健康信息
 *
 * @author 
 * @email
 */
@TableName("jilu")
public class JiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiluEntity() {

	}

	public JiluEntity(T t) {
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
     * 护工
     */
    @ColumnInfo(comment="护工",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 记录名称
     */
    @ColumnInfo(comment="记录名称",type="varchar(200)")
    @TableField(value = "jilu_name")

    private String jiluName;


    /**
     * 记录编号
     */
    @ColumnInfo(comment="记录编号",type="varchar(200)")
    @TableField(value = "jilu_uuid_number")

    private String jiluUuidNumber;


    /**
     * 记录照片
     */
    @ColumnInfo(comment="记录照片",type="varchar(200)")
    @TableField(value = "jilu_photo")

    private String jiluPhoto;


    /**
     * 体温
     */
    @ColumnInfo(comment="体温",type="decimal(10,2)")
    @TableField(value = "jilu_tiwen")

    private Double jiluTiwen;


    /**
     * 血压
     */
    @ColumnInfo(comment="血压",type="decimal(10,2)")
    @TableField(value = "jilu_xueya")

    private Double jiluXueya;


    /**
     * 健康介绍
     */
    @ColumnInfo(comment="健康介绍",type="longtext")
    @TableField(value = "jilu_content")

    private String jiluContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jilu_delete")

    private Integer jiluDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：护工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：护工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }
    /**
	 * 设置：老人
	 */

    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 获取：记录名称
	 */
    public String getJiluName() {
        return jiluName;
    }
    /**
	 * 设置：记录名称
	 */

    public void setJiluName(String jiluName) {
        this.jiluName = jiluName;
    }
    /**
	 * 获取：记录编号
	 */
    public String getJiluUuidNumber() {
        return jiluUuidNumber;
    }
    /**
	 * 设置：记录编号
	 */

    public void setJiluUuidNumber(String jiluUuidNumber) {
        this.jiluUuidNumber = jiluUuidNumber;
    }
    /**
	 * 获取：记录照片
	 */
    public String getJiluPhoto() {
        return jiluPhoto;
    }
    /**
	 * 设置：记录照片
	 */

    public void setJiluPhoto(String jiluPhoto) {
        this.jiluPhoto = jiluPhoto;
    }
    /**
	 * 获取：体温
	 */
    public Double getJiluTiwen() {
        return jiluTiwen;
    }
    /**
	 * 设置：体温
	 */

    public void setJiluTiwen(Double jiluTiwen) {
        this.jiluTiwen = jiluTiwen;
    }
    /**
	 * 获取：血压
	 */
    public Double getJiluXueya() {
        return jiluXueya;
    }
    /**
	 * 设置：血压
	 */

    public void setJiluXueya(Double jiluXueya) {
        this.jiluXueya = jiluXueya;
    }
    /**
	 * 获取：健康介绍
	 */
    public String getJiluContent() {
        return jiluContent;
    }
    /**
	 * 设置：健康介绍
	 */

    public void setJiluContent(String jiluContent) {
        this.jiluContent = jiluContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiluDelete() {
        return jiluDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiluDelete(Integer jiluDelete) {
        this.jiluDelete = jiluDelete;
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jilu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", laorenId=" + laorenId +
            ", jiluName=" + jiluName +
            ", jiluUuidNumber=" + jiluUuidNumber +
            ", jiluPhoto=" + jiluPhoto +
            ", jiluTiwen=" + jiluTiwen +
            ", jiluXueya=" + jiluXueya +
            ", jiluContent=" + jiluContent +
            ", jiluDelete=" + jiluDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
