package com.entity.vo;

import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjian")
public class FangjianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房间名称
     */

    @TableField(value = "fangjian_name")
    private String fangjianName;


    /**
     * 房间编号
     */

    @TableField(value = "fangjian_uuid_number")
    private String fangjianUuidNumber;


    /**
     * 房间照片
     */

    @TableField(value = "fangjian_photo")
    private String fangjianPhoto;


    /**
     * 房间地点
     */

    @TableField(value = "fangjian_address")
    private String fangjianAddress;


    /**
     * 房间类型
     */

    @TableField(value = "fangjian_types")
    private Integer fangjianTypes;


    /**
     * 房间介绍
     */

    @TableField(value = "fangjian_content")
    private String fangjianContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangjian_delete")
    private Integer fangjianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：房间名称
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 获取：房间名称
	 */

    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 设置：房间编号
	 */
    public String getFangjianUuidNumber() {
        return fangjianUuidNumber;
    }


    /**
	 * 获取：房间编号
	 */

    public void setFangjianUuidNumber(String fangjianUuidNumber) {
        this.fangjianUuidNumber = fangjianUuidNumber;
    }
    /**
	 * 设置：房间照片
	 */
    public String getFangjianPhoto() {
        return fangjianPhoto;
    }


    /**
	 * 获取：房间照片
	 */

    public void setFangjianPhoto(String fangjianPhoto) {
        this.fangjianPhoto = fangjianPhoto;
    }
    /**
	 * 设置：房间地点
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }


    /**
	 * 获取：房间地点
	 */

    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 设置：房间类型
	 */
    public Integer getFangjianTypes() {
        return fangjianTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setFangjianTypes(Integer fangjianTypes) {
        this.fangjianTypes = fangjianTypes;
    }
    /**
	 * 设置：房间介绍
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }


    /**
	 * 获取：房间介绍
	 */

    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangjianDelete() {
        return fangjianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangjianDelete(Integer fangjianDelete) {
        this.fangjianDelete = fangjianDelete;
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
