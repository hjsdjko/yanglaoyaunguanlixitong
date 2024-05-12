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
 * 床位调动申请
 *
 * @author 
 * @email
 */
@TableName("chuangwei_yuyue")
public class ChuangweiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuangweiYuyueEntity() {

	}

	public ChuangweiYuyueEntity(T t) {
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
    @TableField(value = "chuangwei_yuyue_uuid_number")

    private String chuangweiYuyueUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 床位
     */
    @ColumnInfo(comment="床位",type="int(11)")
    @TableField(value = "chuangwei_id")

    private Integer chuangweiId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "chuangwei_yuyue_text")

    private String chuangweiYuyueText;


    /**
     * 床位调动申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="床位调动申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "chuangwei_yuyue_yesno_types")

    private Integer chuangweiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "chuangwei_yuyue_yesno_text")

    private String chuangweiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "chuangwei_yuyue_shenhe_time")

    private Date chuangweiYuyueShenheTime;


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
    public String getChuangweiYuyueUuidNumber() {
        return chuangweiYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setChuangweiYuyueUuidNumber(String chuangweiYuyueUuidNumber) {
        this.chuangweiYuyueUuidNumber = chuangweiYuyueUuidNumber;
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
	 * 获取：报名理由
	 */
    public String getChuangweiYuyueText() {
        return chuangweiYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setChuangweiYuyueText(String chuangweiYuyueText) {
        this.chuangweiYuyueText = chuangweiYuyueText;
    }
    /**
	 * 获取：床位调动申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：床位调动申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getChuangweiYuyueYesnoTypes() {
        return chuangweiYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setChuangweiYuyueYesnoTypes(Integer chuangweiYuyueYesnoTypes) {
        this.chuangweiYuyueYesnoTypes = chuangweiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getChuangweiYuyueYesnoText() {
        return chuangweiYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setChuangweiYuyueYesnoText(String chuangweiYuyueYesnoText) {
        this.chuangweiYuyueYesnoText = chuangweiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getChuangweiYuyueShenheTime() {
        return chuangweiYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setChuangweiYuyueShenheTime(Date chuangweiYuyueShenheTime) {
        this.chuangweiYuyueShenheTime = chuangweiYuyueShenheTime;
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
        return "ChuangweiYuyue{" +
            ", id=" + id +
            ", chuangweiYuyueUuidNumber=" + chuangweiYuyueUuidNumber +
            ", yonghuId=" + yonghuId +
            ", laorenId=" + laorenId +
            ", chuangweiId=" + chuangweiId +
            ", chuangweiYuyueText=" + chuangweiYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", chuangweiYuyueYesnoTypes=" + chuangweiYuyueYesnoTypes +
            ", chuangweiYuyueYesnoText=" + chuangweiYuyueYesnoText +
            ", chuangweiYuyueShenheTime=" + DateUtil.convertString(chuangweiYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
