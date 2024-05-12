package com.entity.vo;

import com.entity.DiaodongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 调动申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("diaodong")
public class DiaodongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "diaodong_uuid_number")
    private String diaodongUuidNumber;


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
     * 床位
     */

    @TableField(value = "chuangwei_id")
    private Integer chuangweiId;


    /**
     * 报名理由
     */

    @TableField(value = "diaodong_text")
    private String diaodongText;


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

    @TableField(value = "diaodong_yesno_types")
    private Integer diaodongYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "diaodong_yesno_text")
    private String diaodongYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "diaodong_shenhe_time")
    private Date diaodongShenheTime;


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
    public String getDiaodongUuidNumber() {
        return diaodongUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setDiaodongUuidNumber(String diaodongUuidNumber) {
        this.diaodongUuidNumber = diaodongUuidNumber;
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
    public String getDiaodongText() {
        return diaodongText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setDiaodongText(String diaodongText) {
        this.diaodongText = diaodongText;
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
    public Integer getDiaodongYesnoTypes() {
        return diaodongYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setDiaodongYesnoTypes(Integer diaodongYesnoTypes) {
        this.diaodongYesnoTypes = diaodongYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getDiaodongYesnoText() {
        return diaodongYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setDiaodongYesnoText(String diaodongYesnoText) {
        this.diaodongYesnoText = diaodongYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getDiaodongShenheTime() {
        return diaodongShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setDiaodongShenheTime(Date diaodongShenheTime) {
        this.diaodongShenheTime = diaodongShenheTime;
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
