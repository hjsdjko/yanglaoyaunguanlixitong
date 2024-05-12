package com.entity.model;

import com.entity.JiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 护工
     */
    private Integer yonghuId;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 记录名称
     */
    private String jiluName;


    /**
     * 记录编号
     */
    private String jiluUuidNumber;


    /**
     * 记录照片
     */
    private String jiluPhoto;


    /**
     * 体温
     */
    private Double jiluTiwen;


    /**
     * 血压
     */
    private Double jiluXueya;


    /**
     * 健康介绍
     */
    private String jiluContent;


    /**
     * 逻辑删除
     */
    private Integer jiluDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：护工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：护工
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
	 * 获取：记录名称
	 */
    public String getJiluName() {
        return jiluName;
    }


    /**
	 * 设置：记录名称
	 */
    public void setJiluName(String jiluName) {
        this.jiluName = jiluName;
    }
    /**
	 * 获取：记录编号
	 */
    public String getJiluUuidNumber() {
        return jiluUuidNumber;
    }


    /**
	 * 设置：记录编号
	 */
    public void setJiluUuidNumber(String jiluUuidNumber) {
        this.jiluUuidNumber = jiluUuidNumber;
    }
    /**
	 * 获取：记录照片
	 */
    public String getJiluPhoto() {
        return jiluPhoto;
    }


    /**
	 * 设置：记录照片
	 */
    public void setJiluPhoto(String jiluPhoto) {
        this.jiluPhoto = jiluPhoto;
    }
    /**
	 * 获取：体温
	 */
    public Double getJiluTiwen() {
        return jiluTiwen;
    }


    /**
	 * 设置：体温
	 */
    public void setJiluTiwen(Double jiluTiwen) {
        this.jiluTiwen = jiluTiwen;
    }
    /**
	 * 获取：血压
	 */
    public Double getJiluXueya() {
        return jiluXueya;
    }


    /**
	 * 设置：血压
	 */
    public void setJiluXueya(Double jiluXueya) {
        this.jiluXueya = jiluXueya;
    }
    /**
	 * 获取：健康介绍
	 */
    public String getJiluContent() {
        return jiluContent;
    }


    /**
	 * 设置：健康介绍
	 */
    public void setJiluContent(String jiluContent) {
        this.jiluContent = jiluContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiluDelete() {
        return jiluDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiluDelete(Integer jiluDelete) {
        this.jiluDelete = jiluDelete;
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
