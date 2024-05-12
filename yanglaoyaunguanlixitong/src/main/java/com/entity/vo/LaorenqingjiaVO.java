package com.entity.vo;

import com.entity.LaorenqingjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老人请假申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laorenqingjia")
public class LaorenqingjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "laorenqingjia_uuid_number")
    private String laorenqingjiaUuidNumber;


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

    @TableField(value = "laorenqingjia_text")
    private String laorenqingjiaText;


    /**
     * 老人请假申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "laorenqingjia_yesno_types")
    private Integer laorenqingjiaYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "laorenqingjia_yesno_text")
    private String laorenqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "laorenqingjia_shenhe_time")
    private Date laorenqingjiaShenheTime;


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
    public String getLaorenqingjiaUuidNumber() {
        return laorenqingjiaUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setLaorenqingjiaUuidNumber(String laorenqingjiaUuidNumber) {
        this.laorenqingjiaUuidNumber = laorenqingjiaUuidNumber;
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
    public String getLaorenqingjiaText() {
        return laorenqingjiaText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setLaorenqingjiaText(String laorenqingjiaText) {
        this.laorenqingjiaText = laorenqingjiaText;
    }
    /**
	 * 设置：老人请假申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：老人请假申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getLaorenqingjiaYesnoTypes() {
        return laorenqingjiaYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setLaorenqingjiaYesnoTypes(Integer laorenqingjiaYesnoTypes) {
        this.laorenqingjiaYesnoTypes = laorenqingjiaYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getLaorenqingjiaYesnoText() {
        return laorenqingjiaYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setLaorenqingjiaYesnoText(String laorenqingjiaYesnoText) {
        this.laorenqingjiaYesnoText = laorenqingjiaYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getLaorenqingjiaShenheTime() {
        return laorenqingjiaShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setLaorenqingjiaShenheTime(Date laorenqingjiaShenheTime) {
        this.laorenqingjiaShenheTime = laorenqingjiaShenheTime;
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
