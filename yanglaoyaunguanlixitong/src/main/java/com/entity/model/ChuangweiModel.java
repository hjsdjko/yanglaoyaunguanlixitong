package com.entity.model;

import com.entity.ChuangweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 床位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuangweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房间
     */
    private Integer fangjianId;


    /**
     * 床位名称
     */
    private String chuangweiName;


    /**
     * 床位编号
     */
    private String chuangweiUuidNumber;


    /**
     * 床位照片
     */
    private String chuangweiPhoto;


    /**
     * 床位地点
     */
    private String chuangweiAddress;


    /**
     * 床位类型
     */
    private Integer chuangweiTypes;


    /**
     * 床位介绍
     */
    private String chuangweiContent;


    /**
     * 逻辑删除
     */
    private Integer chuangweiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 设置：房间
	 */
    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 获取：床位名称
	 */
    public String getChuangweiName() {
        return chuangweiName;
    }


    /**
	 * 设置：床位名称
	 */
    public void setChuangweiName(String chuangweiName) {
        this.chuangweiName = chuangweiName;
    }
    /**
	 * 获取：床位编号
	 */
    public String getChuangweiUuidNumber() {
        return chuangweiUuidNumber;
    }


    /**
	 * 设置：床位编号
	 */
    public void setChuangweiUuidNumber(String chuangweiUuidNumber) {
        this.chuangweiUuidNumber = chuangweiUuidNumber;
    }
    /**
	 * 获取：床位照片
	 */
    public String getChuangweiPhoto() {
        return chuangweiPhoto;
    }


    /**
	 * 设置：床位照片
	 */
    public void setChuangweiPhoto(String chuangweiPhoto) {
        this.chuangweiPhoto = chuangweiPhoto;
    }
    /**
	 * 获取：床位地点
	 */
    public String getChuangweiAddress() {
        return chuangweiAddress;
    }


    /**
	 * 设置：床位地点
	 */
    public void setChuangweiAddress(String chuangweiAddress) {
        this.chuangweiAddress = chuangweiAddress;
    }
    /**
	 * 获取：床位类型
	 */
    public Integer getChuangweiTypes() {
        return chuangweiTypes;
    }


    /**
	 * 设置：床位类型
	 */
    public void setChuangweiTypes(Integer chuangweiTypes) {
        this.chuangweiTypes = chuangweiTypes;
    }
    /**
	 * 获取：床位介绍
	 */
    public String getChuangweiContent() {
        return chuangweiContent;
    }


    /**
	 * 设置：床位介绍
	 */
    public void setChuangweiContent(String chuangweiContent) {
        this.chuangweiContent = chuangweiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChuangweiDelete() {
        return chuangweiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setChuangweiDelete(Integer chuangweiDelete) {
        this.chuangweiDelete = chuangweiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
