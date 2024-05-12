package com.entity.model;

import com.entity.ChuangweiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 床位调动申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuangweiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String chuangweiYuyueUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 床位
     */
    private Integer chuangweiId;


    /**
     * 报名理由
     */
    private String chuangweiYuyueText;


    /**
     * 床位调动申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer chuangweiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String chuangweiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuangweiYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
