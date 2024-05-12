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
 * 出院申请
 *
 * @author 
 * @email
 */
@TableName("chuyaun")
public class ChuyaunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuyaunEntity() {

	}

	public ChuyaunEntity(T t) {
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
    @TableField(value = "chuyaun_uuid_number")

    private String chuyaunUuidNumber;


    /**
     * 家属
     */
    @ColumnInfo(comment="家属",type="int(11)")
    @TableField(value = "jiashu_id")

    private Integer jiashuId;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "chuyaun_text")

    private String chuyaunText;


    /**
     * 出院申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出院申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "chuyaun_yesno_types")

    private Integer chuyaunYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "chuyaun_yesno_text")

    private String chuyaunYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "chuyaun_shenhe_time")

    private Date chuyaunShenheTime;


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
	 * 获取：报名编号
	 */
    public String getChuyaunUuidNumber() {
        return chuyaunUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setChuyaunUuidNumber(String chuyaunUuidNumber) {
        this.chuyaunUuidNumber = chuyaunUuidNumber;
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
	 * 获取：报名理由
	 */
    public String getChuyaunText() {
        return chuyaunText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setChuyaunText(String chuyaunText) {
        this.chuyaunText = chuyaunText;
    }
    /**
	 * 获取：出院申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：出院申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getChuyaunYesnoTypes() {
        return chuyaunYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setChuyaunYesnoTypes(Integer chuyaunYesnoTypes) {
        this.chuyaunYesnoTypes = chuyaunYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getChuyaunYesnoText() {
        return chuyaunYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setChuyaunYesnoText(String chuyaunYesnoText) {
        this.chuyaunYesnoText = chuyaunYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getChuyaunShenheTime() {
        return chuyaunShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setChuyaunShenheTime(Date chuyaunShenheTime) {
        this.chuyaunShenheTime = chuyaunShenheTime;
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
        return "Chuyaun{" +
            ", id=" + id +
            ", chuyaunUuidNumber=" + chuyaunUuidNumber +
            ", jiashuId=" + jiashuId +
            ", laorenId=" + laorenId +
            ", chuyaunText=" + chuyaunText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", chuyaunYesnoTypes=" + chuyaunYesnoTypes +
            ", chuyaunYesnoText=" + chuyaunYesnoText +
            ", chuyaunShenheTime=" + DateUtil.convertString(chuyaunShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
