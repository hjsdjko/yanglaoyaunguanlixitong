package com.entity.vo;

import com.entity.JiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jilu")
public class JiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 护工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 老人
     */

    @TableField(value = "laoren_id")
    private Integer laorenId;


    /**
     * 记录名称
     */

    @TableField(value = "jilu_name")
    private String jiluName;


    /**
     * 记录编号
     */

    @TableField(value = "jilu_uuid_number")
    private String jiluUuidNumber;


    /**
     * 记录照片
     */

    @TableField(value = "jilu_photo")
    private String jiluPhoto;


    /**
     * 体温
     */

    @TableField(value = "jilu_tiwen")
    private Double jiluTiwen;


    /**
     * 血压
     */

    @TableField(value = "jilu_xueya")
    private Double jiluXueya;


    /**
     * 健康介绍
     */

    @TableField(value = "jilu_content")
    private String jiluContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jilu_delete")
    private Integer jiluDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：护工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：护工
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
	 * 设置：记录名称
	 */
    public String getJiluName() {
        return jiluName;
    }


    /**
	 * 获取：记录名称
	 */

    public void setJiluName(String jiluName) {
        this.jiluName = jiluName;
    }
    /**
	 * 设置：记录编号
	 */
    public String getJiluUuidNumber() {
        return jiluUuidNumber;
    }


    /**
	 * 获取：记录编号
	 */

    public void setJiluUuidNumber(String jiluUuidNumber) {
        this.jiluUuidNumber = jiluUuidNumber;
    }
    /**
	 * 设置：记录照片
	 */
    public String getJiluPhoto() {
        return jiluPhoto;
    }


    /**
	 * 获取：记录照片
	 */

    public void setJiluPhoto(String jiluPhoto) {
        this.jiluPhoto = jiluPhoto;
    }
    /**
	 * 设置：体温
	 */
    public Double getJiluTiwen() {
        return jiluTiwen;
    }


    /**
	 * 获取：体温
	 */

    public void setJiluTiwen(Double jiluTiwen) {
        this.jiluTiwen = jiluTiwen;
    }
    /**
	 * 设置：血压
	 */
    public Double getJiluXueya() {
        return jiluXueya;
    }


    /**
	 * 获取：血压
	 */

    public void setJiluXueya(Double jiluXueya) {
        this.jiluXueya = jiluXueya;
    }
    /**
	 * 设置：健康介绍
	 */
    public String getJiluContent() {
        return jiluContent;
    }


    /**
	 * 获取：健康介绍
	 */

    public void setJiluContent(String jiluContent) {
        this.jiluContent = jiluContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiluDelete() {
        return jiluDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiluDelete(Integer jiluDelete) {
        this.jiluDelete = jiluDelete;
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
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
