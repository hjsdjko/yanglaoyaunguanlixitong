package com.entity.vo;

import com.entity.ChuangweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 床位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuangwei")
public class ChuangweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房间
     */

    @TableField(value = "fangjian_id")
    private Integer fangjianId;


    /**
     * 床位名称
     */

    @TableField(value = "chuangwei_name")
    private String chuangweiName;


    /**
     * 床位编号
     */

    @TableField(value = "chuangwei_uuid_number")
    private String chuangweiUuidNumber;


    /**
     * 床位照片
     */

    @TableField(value = "chuangwei_photo")
    private String chuangweiPhoto;


    /**
     * 床位地点
     */

    @TableField(value = "chuangwei_address")
    private String chuangweiAddress;


    /**
     * 床位类型
     */

    @TableField(value = "chuangwei_types")
    private Integer chuangweiTypes;


    /**
     * 床位介绍
     */

    @TableField(value = "chuangwei_content")
    private String chuangweiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chuangwei_delete")
    private Integer chuangweiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 获取：房间
	 */

    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 设置：床位名称
	 */
    public String getChuangweiName() {
        return chuangweiName;
    }


    /**
	 * 获取：床位名称
	 */

    public void setChuangweiName(String chuangweiName) {
        this.chuangweiName = chuangweiName;
    }
    /**
	 * 设置：床位编号
	 */
    public String getChuangweiUuidNumber() {
        return chuangweiUuidNumber;
    }


    /**
	 * 获取：床位编号
	 */

    public void setChuangweiUuidNumber(String chuangweiUuidNumber) {
        this.chuangweiUuidNumber = chuangweiUuidNumber;
    }
    /**
	 * 设置：床位照片
	 */
    public String getChuangweiPhoto() {
        return chuangweiPhoto;
    }


    /**
	 * 获取：床位照片
	 */

    public void setChuangweiPhoto(String chuangweiPhoto) {
        this.chuangweiPhoto = chuangweiPhoto;
    }
    /**
	 * 设置：床位地点
	 */
    public String getChuangweiAddress() {
        return chuangweiAddress;
    }


    /**
	 * 获取：床位地点
	 */

    public void setChuangweiAddress(String chuangweiAddress) {
        this.chuangweiAddress = chuangweiAddress;
    }
    /**
	 * 设置：床位类型
	 */
    public Integer getChuangweiTypes() {
        return chuangweiTypes;
    }


    /**
	 * 获取：床位类型
	 */

    public void setChuangweiTypes(Integer chuangweiTypes) {
        this.chuangweiTypes = chuangweiTypes;
    }
    /**
	 * 设置：床位介绍
	 */
    public String getChuangweiContent() {
        return chuangweiContent;
    }


    /**
	 * 获取：床位介绍
	 */

    public void setChuangweiContent(String chuangweiContent) {
        this.chuangweiContent = chuangweiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChuangweiDelete() {
        return chuangweiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChuangweiDelete(Integer chuangweiDelete) {
        this.chuangweiDelete = chuangweiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
