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
 * 老人请假申请
 *
 * @author 
 * @email
 */
@TableName("laorenqingjia")
public class LaorenqingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaorenqingjiaEntity() {

	}

	public LaorenqingjiaEntity(T t) {
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
    @TableField(value = "laorenqingjia_uuid_number")

    private String laorenqingjiaUuidNumber;


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
    @TableField(value = "laorenqingjia_text")

    private String laorenqingjiaText;


    /**
     * 老人请假申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="老人请假申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "laorenqingjia_yesno_types")

    private Integer laorenqingjiaYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "laorenqingjia_yesno_text")

    private String laorenqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "laorenqingjia_shenhe_time")

    private Date laorenqingjiaShenheTime;


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
    public String getLaorenqingjiaUuidNumber() {
        return laorenqingjiaUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setLaorenqingjiaUuidNumber(String laorenqingjiaUuidNumber) {
        this.laorenqingjiaUuidNumber = laorenqingjiaUuidNumber;
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
    public String getLaorenqingjiaText() {
        return laorenqingjiaText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setLaorenqingjiaText(String laorenqingjiaText) {
        this.laorenqingjiaText = laorenqingjiaText;
    }
    /**
	 * 获取：老人请假申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：老人请假申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getLaorenqingjiaYesnoTypes() {
        return laorenqingjiaYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setLaorenqingjiaYesnoTypes(Integer laorenqingjiaYesnoTypes) {
        this.laorenqingjiaYesnoTypes = laorenqingjiaYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getLaorenqingjiaYesnoText() {
        return laorenqingjiaYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setLaorenqingjiaYesnoText(String laorenqingjiaYesnoText) {
        this.laorenqingjiaYesnoText = laorenqingjiaYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLaorenqingjiaShenheTime() {
        return laorenqingjiaShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setLaorenqingjiaShenheTime(Date laorenqingjiaShenheTime) {
        this.laorenqingjiaShenheTime = laorenqingjiaShenheTime;
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
        return "Laorenqingjia{" +
            ", id=" + id +
            ", laorenqingjiaUuidNumber=" + laorenqingjiaUuidNumber +
            ", jiashuId=" + jiashuId +
            ", laorenId=" + laorenId +
            ", laorenqingjiaText=" + laorenqingjiaText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", laorenqingjiaYesnoTypes=" + laorenqingjiaYesnoTypes +
            ", laorenqingjiaYesnoText=" + laorenqingjiaYesnoText +
            ", laorenqingjiaShenheTime=" + DateUtil.convertString(laorenqingjiaShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
