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
 * 老人
 *
 * @author 
 * @email
 */
@TableName("laoren")
public class LaorenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaorenEntity() {

	}

	public LaorenEntity(T t) {
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
     * 床位
     */
    @ColumnInfo(comment="床位",type="int(11)")
    @TableField(value = "chuangwei_id")

    private Integer chuangweiId;


    /**
     * 家属
     */
    @ColumnInfo(comment="家属",type="int(11)")
    @TableField(value = "jiashu_id")

    private Integer jiashuId;


    /**
     * 看护人姓名
     */
    @ColumnInfo(comment="看护人姓名",type="varchar(200)")
    @TableField(value = "kanhuren_name")

    private String kanhurenName;


    /**
     * 看护人联系方式
     */
    @ColumnInfo(comment="看护人联系方式",type="varchar(200)")
    @TableField(value = "kanhuren_phone")

    private String kanhurenPhone;


    /**
     * 老人姓名
     */
    @ColumnInfo(comment="老人姓名",type="varchar(200)")
    @TableField(value = "laoren_name")

    private String laorenName;


    /**
     * 老人手机号
     */
    @ColumnInfo(comment="老人手机号",type="varchar(200)")
    @TableField(value = "laoren_phone")

    private String laorenPhone;


    /**
     * 老人身份证号
     */
    @ColumnInfo(comment="老人身份证号",type="varchar(200)")
    @TableField(value = "laoren_id_number")

    private String laorenIdNumber;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 年龄
     */
    @ColumnInfo(comment="年龄",type="int(11)")
    @TableField(value = "age")

    private Integer age;


    /**
     * 老人照片
     */
    @ColumnInfo(comment="老人照片",type="varchar(200)")
    @TableField(value = "laoren_photo")

    private String laorenPhoto;


    /**
     * 老人描述
     */
    @ColumnInfo(comment="老人描述",type="text")
    @TableField(value = "laoren_content")

    private String laorenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }
    /**
	 * 设置：床位
	 */

    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
    }
    /**
	 * 获取：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }
    /**
	 * 设置：家属
	 */

    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 获取：看护人姓名
	 */
    public String getKanhurenName() {
        return kanhurenName;
    }
    /**
	 * 设置：看护人姓名
	 */

    public void setKanhurenName(String kanhurenName) {
        this.kanhurenName = kanhurenName;
    }
    /**
	 * 获取：看护人联系方式
	 */
    public String getKanhurenPhone() {
        return kanhurenPhone;
    }
    /**
	 * 设置：看护人联系方式
	 */

    public void setKanhurenPhone(String kanhurenPhone) {
        this.kanhurenPhone = kanhurenPhone;
    }
    /**
	 * 获取：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }
    /**
	 * 设置：老人姓名
	 */

    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 获取：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }
    /**
	 * 设置：老人手机号
	 */

    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 获取：老人身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }
    /**
	 * 设置：老人身份证号
	 */

    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }
    /**
	 * 设置：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }
    /**
	 * 设置：老人照片
	 */

    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
    }
    /**
	 * 获取：老人描述
	 */
    public String getLaorenContent() {
        return laorenContent;
    }
    /**
	 * 设置：老人描述
	 */

    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
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
        return "Laoren{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", chuangweiId=" + chuangweiId +
            ", jiashuId=" + jiashuId +
            ", kanhurenName=" + kanhurenName +
            ", kanhurenPhone=" + kanhurenPhone +
            ", laorenName=" + laorenName +
            ", laorenPhone=" + laorenPhone +
            ", laorenIdNumber=" + laorenIdNumber +
            ", sexTypes=" + sexTypes +
            ", age=" + age +
            ", laorenPhoto=" + laorenPhoto +
            ", laorenContent=" + laorenContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
