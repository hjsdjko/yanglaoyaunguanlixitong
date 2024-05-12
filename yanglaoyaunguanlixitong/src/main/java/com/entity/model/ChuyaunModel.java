package com.entity.model;

import com.entity.ChuyaunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出院申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuyaunModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String chuyaunUuidNumber;


    /**
     * 家属
     */
    private Integer jiashuId;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 报名理由
     */
    private String chuyaunText;


    /**
     * 出院申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer chuyaunYesnoTypes;


    /**
     * 审核回复
     */
    private String chuyaunYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuyaunShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
