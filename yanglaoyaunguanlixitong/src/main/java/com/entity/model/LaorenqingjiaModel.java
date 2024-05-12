package com.entity.model;

import com.entity.LaorenqingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人请假申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaorenqingjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String laorenqingjiaUuidNumber;


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
    private String laorenqingjiaText;


    /**
     * 老人请假申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer laorenqingjiaYesnoTypes;


    /**
     * 审核回复
     */
    private String laorenqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date laorenqingjiaShenheTime;


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

    }
