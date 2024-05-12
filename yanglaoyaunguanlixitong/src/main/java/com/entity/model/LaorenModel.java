package com.entity.model;

import com.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaorenModel implements Serializable {
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
     * 床位
     */
    private Integer chuangweiId;


    /**
     * 家属
     */
    private Integer jiashuId;


    /**
     * 看护人姓名
     */
    private String kanhurenName;


    /**
     * 看护人联系方式
     */
    private String kanhurenPhone;


    /**
     * 老人姓名
     */
    private String laorenName;


    /**
     * 老人手机号
     */
    private String laorenPhone;


    /**
     * 老人身份证号
     */
    private String laorenIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 老人照片
     */
    private String laorenPhoto;


    /**
     * 老人描述
     */
    private String laorenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：床位
	 */
    public Integer getChuangweiId() {
        return chuangweiId;
    }


    /**
	 * 设置：床位
	 */
    public void setChuangweiId(Integer chuangweiId) {
        this.chuangweiId = chuangweiId;
    }
    /**
	 * 获取：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }


    /**
	 * 设置：家属
	 */
    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 获取：看护人姓名
	 */
    public String getKanhurenName() {
        return kanhurenName;
    }


    /**
	 * 设置：看护人姓名
	 */
    public void setKanhurenName(String kanhurenName) {
        this.kanhurenName = kanhurenName;
    }
    /**
	 * 获取：看护人联系方式
	 */
    public String getKanhurenPhone() {
        return kanhurenPhone;
    }


    /**
	 * 设置：看护人联系方式
	 */
    public void setKanhurenPhone(String kanhurenPhone) {
        this.kanhurenPhone = kanhurenPhone;
    }
    /**
	 * 获取：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 设置：老人姓名
	 */
    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 获取：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 设置：老人手机号
	 */
    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 获取：老人身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 设置：老人身份证号
	 */
    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }


    /**
	 * 设置：老人照片
	 */
    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
    }
    /**
	 * 获取：老人描述
	 */
    public String getLaorenContent() {
        return laorenContent;
    }


    /**
	 * 设置：老人描述
	 */
    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
