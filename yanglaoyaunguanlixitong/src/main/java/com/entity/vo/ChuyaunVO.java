package com.entity.vo;

import com.entity.ChuyaunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出院申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuyaun")
public class ChuyaunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "chuyaun_uuid_number")
    private String chuyaunUuidNumber;


    /**
     * 家属
     */

    @TableField(value = "jiashu_id")
    private Integer jiashuId;


    /**
     * 老人
     */

    @TableField(value = "laoren_id")
    private Integer laorenId;


    /**
     * 报名理由
     */

    @TableField(value = "chuyaun_text")
    private String chuyaunText;


    /**
     * 出院申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "chuyaun_yesno_types")
    private Integer chuyaunYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "chuyaun_yesno_text")
    private String chuyaunYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chuyaun_shenhe_time")
    private Date chuyaunShenheTime;


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
	 * 设置：报名编号
	 */
    public String getChuyaunUuidNumber() {
        return chuyaunUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setChuyaunUuidNumber(String chuyaunUuidNumber) {
        this.chuyaunUuidNumber = chuyaunUuidNumber;
    }
    /**
	 * 设置：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }


    /**
	 * 获取：家属
	 */

    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 设置：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 获取：老人
	 */

    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getChuyaunText() {
        return chuyaunText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setChuyaunText(String chuyaunText) {
        this.chuyaunText = chuyaunText;
    }
    /**
	 * 设置：出院申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：出院申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getChuyaunYesnoTypes() {
        return chuyaunYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setChuyaunYesnoTypes(Integer chuyaunYesnoTypes) {
        this.chuyaunYesnoTypes = chuyaunYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getChuyaunYesnoText() {
        return chuyaunYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setChuyaunYesnoText(String chuyaunYesnoText) {
        this.chuyaunYesnoText = chuyaunYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getChuyaunShenheTime() {
        return chuyaunShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setChuyaunShenheTime(Date chuyaunShenheTime) {
        this.chuyaunShenheTime = chuyaunShenheTime;
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
