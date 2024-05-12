package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 护工
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 护工编号
     */
    private String yonghuUuidNumber;


    /**
     * 护工姓名
     */
    private String yonghuName;


    /**
     * 护工手机号
     */
    private String yonghuPhone;


    /**
     * 护工身份证号
     */
    private String yonghuIdNumber;


    /**
     * 护工头像
     */
    private String yonghuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 护工等级
     */
    private Integer yonghuTypes;


    /**
     * 价钱
     */
    private String yonghuJaiwei;


    /**
     * 护工邮箱
     */
    private String yonghuEmail;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：护工编号
	 */
    public String getYonghuUuidNumber() {
        return yonghuUuidNumber;
    }


    /**
	 * 设置：护工编号
	 */
    public void setYonghuUuidNumber(String yonghuUuidNumber) {
        this.yonghuUuidNumber = yonghuUuidNumber;
    }
    /**
	 * 获取：护工姓名
	 */
    public String getYonghuName() {
        return yonghuName;
    }


    /**
	 * 设置：护工姓名
	 */
    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }
    /**
	 * 获取：护工手机号
	 */
    public String getYonghuPhone() {
        return yonghuPhone;
    }


    /**
	 * 设置：护工手机号
	 */
    public void setYonghuPhone(String yonghuPhone) {
        this.yonghuPhone = yonghuPhone;
    }
    /**
	 * 获取：护工身份证号
	 */
    public String getYonghuIdNumber() {
        return yonghuIdNumber;
    }


    /**
	 * 设置：护工身份证号
	 */
    public void setYonghuIdNumber(String yonghuIdNumber) {
        this.yonghuIdNumber = yonghuIdNumber;
    }
    /**
	 * 获取：护工头像
	 */
    public String getYonghuPhoto() {
        return yonghuPhoto;
    }


    /**
	 * 设置：护工头像
	 */
    public void setYonghuPhoto(String yonghuPhoto) {
        this.yonghuPhoto = yonghuPhoto;
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
	 * 获取：护工等级
	 */
    public Integer getYonghuTypes() {
        return yonghuTypes;
    }


    /**
	 * 设置：护工等级
	 */
    public void setYonghuTypes(Integer yonghuTypes) {
        this.yonghuTypes = yonghuTypes;
    }
    /**
	 * 获取：价钱
	 */
    public String getYonghuJaiwei() {
        return yonghuJaiwei;
    }


    /**
	 * 设置：价钱
	 */
    public void setYonghuJaiwei(String yonghuJaiwei) {
        this.yonghuJaiwei = yonghuJaiwei;
    }
    /**
	 * 获取：护工邮箱
	 */
    public String getYonghuEmail() {
        return yonghuEmail;
    }


    /**
	 * 设置：护工邮箱
	 */
    public void setYonghuEmail(String yonghuEmail) {
        this.yonghuEmail = yonghuEmail;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 设置：账户状态
	 */
    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
