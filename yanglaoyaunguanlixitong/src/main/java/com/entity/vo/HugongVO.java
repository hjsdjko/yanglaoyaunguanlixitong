package com.entity.vo;

import com.entity.HugongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 护工更换申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hugong")
public class HugongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "hugong_uuid_number")
    private String hugongUuidNumber;


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

    @TableField(value = "hugong_text")
    private String hugongText;


    /**
     * 护工更换申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "hugong_yesno_types")
    private Integer hugongYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "hugong_yesno_text")
    private String hugongYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "hugong_shenhe_time")
    private Date hugongShenheTime;


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
    public String getHugongUuidNumber() {
        return hugongUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setHugongUuidNumber(String hugongUuidNumber) {
        this.hugongUuidNumber = hugongUuidNumber;
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
    public String getHugongText() {
        return hugongText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setHugongText(String hugongText) {
        this.hugongText = hugongText;
    }
    /**
	 * 设置：护工更换申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：护工更换申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getHugongYesnoTypes() {
        return hugongYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setHugongYesnoTypes(Integer hugongYesnoTypes) {
        this.hugongYesnoTypes = hugongYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getHugongYesnoText() {
        return hugongYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setHugongYesnoText(String hugongYesnoText) {
        this.hugongYesnoText = hugongYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHugongShenheTime() {
        return hugongShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHugongShenheTime(Date hugongShenheTime) {
        this.hugongShenheTime = hugongShenheTime;
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
