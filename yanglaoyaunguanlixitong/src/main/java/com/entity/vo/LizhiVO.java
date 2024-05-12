package com.entity.vo;

import com.entity.LizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 离职申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lizhi")
public class LizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "lizhi_uuid_number")
    private String lizhiUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "lizhi_text")
    private String lizhiText;


    /**
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "lizhi_yesno_types")
    private Integer lizhiYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "lizhi_yesno_text")
    private String lizhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "lizhi_shenhe_time")
    private Date lizhiShenheTime;


    /**
     * 创建时间 show3 listShow
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
    public String getLizhiUuidNumber() {
        return lizhiUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setLizhiUuidNumber(String lizhiUuidNumber) {
        this.lizhiUuidNumber = lizhiUuidNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getLizhiText() {
        return lizhiText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setLizhiText(String lizhiText) {
        this.lizhiText = lizhiText;
    }
    /**
	 * 设置：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：离职申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getLizhiYesnoTypes() {
        return lizhiYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setLizhiYesnoTypes(Integer lizhiYesnoTypes) {
        this.lizhiYesnoTypes = lizhiYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getLizhiYesnoText() {
        return lizhiYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setLizhiYesnoText(String lizhiYesnoText) {
        this.lizhiYesnoText = lizhiYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getLizhiShenheTime() {
        return lizhiShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setLizhiShenheTime(Date lizhiShenheTime) {
        this.lizhiShenheTime = lizhiShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
