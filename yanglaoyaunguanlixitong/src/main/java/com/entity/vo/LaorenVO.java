package com.entity.vo;

import com.entity.LaorenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老人
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laoren")
public class LaorenVO implements Serializable {
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
     * 床位
     */

    @TableField(value = "chuangwei_id")
    private Integer chuangweiId;


    /**
     * 家属
     */

    @TableField(value = "jiashu_id")
    private Integer jiashuId;


    /**
     * 看护人姓名
     */

    @TableField(value = "kanhuren_name")
    private String kanhurenName;


    /**
     * 看护人联系方式
     */

    @TableField(value = "kanhuren_phone")
    private String kanhurenPhone;


    /**
     * 老人姓名
     */

    @TableField(value = "laoren_name")
    private String laorenName;


    /**
     * 老人手机号
     */

    @TableField(value = "laoren_phone")
    private String laorenPhone;


    /**
     * 老人身份证号
     */

    @TableField(value = "laoren_id_number")
    private String laorenIdNumber;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 老人照片
     */

    @TableField(value = "laoren_photo")
    private String laorenPhoto;


    /**
     * 老人描述
     */

    @TableField(value = "laoren_content")
    private String laorenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：看护人姓名
	 */
    public String getKanhurenName() {
        return kanhurenName;
    }


    /**
	 * 获取：看护人姓名
	 */

    public void setKanhurenName(String kanhurenName) {
        this.kanhurenName = kanhurenName;
    }
    /**
	 * 设置：看护人联系方式
	 */
    public String getKanhurenPhone() {
        return kanhurenPhone;
    }


    /**
	 * 获取：看护人联系方式
	 */

    public void setKanhurenPhone(String kanhurenPhone) {
        this.kanhurenPhone = kanhurenPhone;
    }
    /**
	 * 设置：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 获取：老人姓名
	 */

    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 设置：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 获取：老人手机号
	 */

    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 设置：老人身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 获取：老人身份证号
	 */

    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }


    /**
	 * 获取：老人照片
	 */

    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
    }
    /**
	 * 设置：老人描述
	 */
    public String getLaorenContent() {
        return laorenContent;
    }


    /**
	 * 获取：老人描述
	 */

    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
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
