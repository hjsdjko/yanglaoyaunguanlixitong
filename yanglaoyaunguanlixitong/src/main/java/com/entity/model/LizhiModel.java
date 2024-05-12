package com.entity.model;

import com.entity.LizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 离职申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String lizhiUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报名理由
     */
    private String lizhiText;


    /**
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer lizhiYesnoTypes;


    /**
     * 审核回复
     */
    private String lizhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date lizhiShenheTime;


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
    public String getLizhiUuidNumber() {
        return lizhiUuidNumber;
    }


    /**
	 * 设置：报名编号
	 */
    public void setLizhiUuidNumber(String lizhiUuidNumber) {
        this.lizhiUuidNumber = lizhiUuidNumber;
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
	 * 获取：报名理由
	 */
    public String getLizhiText() {
        return lizhiText;
    }


    /**
	 * 设置：报名理由
	 */
    public void setLizhiText(String lizhiText) {
        this.lizhiText = lizhiText;
    }
    /**
	 * 获取：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：离职申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getLizhiYesnoTypes() {
        return lizhiYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setLizhiYesnoTypes(Integer lizhiYesnoTypes) {
        this.lizhiYesnoTypes = lizhiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getLizhiYesnoText() {
        return lizhiYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setLizhiYesnoText(String lizhiYesnoText) {
        this.lizhiYesnoText = lizhiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLizhiShenheTime() {
        return lizhiShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setLizhiShenheTime(Date lizhiShenheTime) {
        this.lizhiShenheTime = lizhiShenheTime;
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
