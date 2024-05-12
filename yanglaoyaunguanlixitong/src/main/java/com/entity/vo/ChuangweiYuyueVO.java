package com.entity.vo;

import com.entity.ChuangweiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 床位调动申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuangwei_yuyue")
public class ChuangweiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "chuangwei_yuyue_uuid_number")
    private String chuangweiYuyueUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 老人
     */

    @TableField(value = "laoren_id")
    private Integer laorenId;


    /**
     * 床位
     */

    @TableField(value = "chuangwei_id")
    private Integer chuangweiId;


    /**
     * 报名理由
     */

    @TableField(value = "chuangwei_yuyue_text")
    private String chuangweiYuyueText;


    /**
     * 床位调动申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "chuangwei_yuyue_yesno_types")
    private Integer chuangweiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "chuangwei_yuyue_yesno_text")
    private String chuangweiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chuangwei_yuyue_shenhe_time")
    private Date chuangweiYuyueShenheTime;


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
    public String getChuangweiYuyueUuidNumber() {
        return chuangweiYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setChuangweiYuyueUuidNumber(String chuangweiYuyueUuidNumber) {
        this.chuangweiYuyueUuidNumber = chuangweiYuyueUuidNumber;
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
	 * 设置：床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }


    /**
	 * 获取：床位
	 */

    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getChuangweiYuyueText() {
        return chuangweiYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setChuangweiYuyueText(String chuangweiYuyueText) {
        this.chuangweiYuyueText = chuangweiYuyueText;
    }
    /**
	 * 设置：床位调动申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：床位调动申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getChuangweiYuyueYesnoTypes() {
        return chuangweiYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setChuangweiYuyueYesnoTypes(Integer chuangweiYuyueYesnoTypes) {
        this.chuangweiYuyueYesnoTypes = chuangweiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getChuangweiYuyueYesnoText() {
        return chuangweiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setChuangweiYuyueYesnoText(String chuangweiYuyueYesnoText) {
        this.chuangweiYuyueYesnoText = chuangweiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getChuangweiYuyueShenheTime() {
        return chuangweiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setChuangweiYuyueShenheTime(Date chuangweiYuyueShenheTime) {
        this.chuangweiYuyueShenheTime = chuangweiYuyueShenheTime;
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
