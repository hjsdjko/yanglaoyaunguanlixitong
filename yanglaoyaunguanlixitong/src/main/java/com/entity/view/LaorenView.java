package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LaorenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 老人
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("laoren")
public class LaorenView extends LaorenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;

	//级联表 床位
							/**
		* 床位名称
		*/

		@ColumnInfo(comment="床位名称",type="varchar(200)")
		private String chuangweiName;
		/**
		* 床位编号
		*/

		@ColumnInfo(comment="床位编号",type="varchar(200)")
		private String chuangweiUuidNumber;
		/**
		* 床位照片
		*/

		@ColumnInfo(comment="床位照片",type="varchar(200)")
		private String chuangweiPhoto;
		/**
		* 床位地点
		*/

		@ColumnInfo(comment="床位地点",type="varchar(200)")
		private String chuangweiAddress;
		/**
		* 床位类型
		*/
		@ColumnInfo(comment="床位类型",type="int(11)")
		private Integer chuangweiTypes;
			/**
			* 床位类型的值
			*/
			@ColumnInfo(comment="床位类型的字典表值",type="varchar(200)")
			private String chuangweiValue;
		/**
		* 床位介绍
		*/

		@ColumnInfo(comment="床位介绍",type="longtext")
		private String chuangweiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chuangweiDelete;
	//级联表 家属
		/**
		* 家属编号
		*/

		@ColumnInfo(comment="家属编号",type="varchar(200)")
		private String jiashuUuidNumber;
		/**
		* 家属姓名
		*/

		@ColumnInfo(comment="家属姓名",type="varchar(200)")
		private String jiashuName;
		/**
		* 家属手机号
		*/

		@ColumnInfo(comment="家属手机号",type="varchar(200)")
		private String jiashuPhone;
		/**
		* 家属身份证号
		*/

		@ColumnInfo(comment="家属身份证号",type="varchar(200)")
		private String jiashuIdNumber;
		/**
		* 家属头像
		*/

		@ColumnInfo(comment="家属头像",type="varchar(200)")
		private String jiashuPhoto;
		/**
		* 家属邮箱
		*/

		@ColumnInfo(comment="家属邮箱",type="varchar(200)")
		private String jiashuEmail;
	//级联表 护工
		/**
		* 护工编号
		*/

		@ColumnInfo(comment="护工编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 护工姓名
		*/

		@ColumnInfo(comment="护工姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 护工手机号
		*/

		@ColumnInfo(comment="护工手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 护工身份证号
		*/

		@ColumnInfo(comment="护工身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 护工头像
		*/

		@ColumnInfo(comment="护工头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 护工等级
		*/
		@ColumnInfo(comment="护工等级",type="int(11)")
		private Integer yonghuTypes;
			/**
			* 护工等级的值
			*/
			@ColumnInfo(comment="护工等级的字典表值",type="varchar(200)")
			private String yonghuValue;
		/**
		* 价钱
		*/

		@ColumnInfo(comment="价钱",type="varchar(200)")
		private String yonghuJaiwei;
		/**
		* 护工邮箱
		*/

		@ColumnInfo(comment="护工邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;

	//重复字段


	public LaorenView() {

	}

	public LaorenView(LaorenEntity laorenEntity) {
		try {
			BeanUtils.copyProperties(this, laorenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}


	//级联表的get和set 床位

		/**
		* 获取： 床位名称
		*/
		public String getChuangweiName() {
			return chuangweiName;
		}
		/**
		* 设置： 床位名称
		*/
		public void setChuangweiName(String chuangweiName) {
			this.chuangweiName = chuangweiName;
		}

		/**
		* 获取： 床位编号
		*/
		public String getChuangweiUuidNumber() {
			return chuangweiUuidNumber;
		}
		/**
		* 设置： 床位编号
		*/
		public void setChuangweiUuidNumber(String chuangweiUuidNumber) {
			this.chuangweiUuidNumber = chuangweiUuidNumber;
		}

		/**
		* 获取： 床位照片
		*/
		public String getChuangweiPhoto() {
			return chuangweiPhoto;
		}
		/**
		* 设置： 床位照片
		*/
		public void setChuangweiPhoto(String chuangweiPhoto) {
			this.chuangweiPhoto = chuangweiPhoto;
		}

		/**
		* 获取： 床位地点
		*/
		public String getChuangweiAddress() {
			return chuangweiAddress;
		}
		/**
		* 设置： 床位地点
		*/
		public void setChuangweiAddress(String chuangweiAddress) {
			this.chuangweiAddress = chuangweiAddress;
		}
		/**
		* 获取： 床位类型
		*/
		public Integer getChuangweiTypes() {
			return chuangweiTypes;
		}
		/**
		* 设置： 床位类型
		*/
		public void setChuangweiTypes(Integer chuangweiTypes) {
			this.chuangweiTypes = chuangweiTypes;
		}


			/**
			* 获取： 床位类型的值
			*/
			public String getChuangweiValue() {
				return chuangweiValue;
			}
			/**
			* 设置： 床位类型的值
			*/
			public void setChuangweiValue(String chuangweiValue) {
				this.chuangweiValue = chuangweiValue;
			}

		/**
		* 获取： 床位介绍
		*/
		public String getChuangweiContent() {
			return chuangweiContent;
		}
		/**
		* 设置： 床位介绍
		*/
		public void setChuangweiContent(String chuangweiContent) {
			this.chuangweiContent = chuangweiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChuangweiDelete() {
			return chuangweiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChuangweiDelete(Integer chuangweiDelete) {
			this.chuangweiDelete = chuangweiDelete;
		}
	//级联表的get和set 家属

		/**
		* 获取： 家属编号
		*/
		public String getJiashuUuidNumber() {
			return jiashuUuidNumber;
		}
		/**
		* 设置： 家属编号
		*/
		public void setJiashuUuidNumber(String jiashuUuidNumber) {
			this.jiashuUuidNumber = jiashuUuidNumber;
		}

		/**
		* 获取： 家属姓名
		*/
		public String getJiashuName() {
			return jiashuName;
		}
		/**
		* 设置： 家属姓名
		*/
		public void setJiashuName(String jiashuName) {
			this.jiashuName = jiashuName;
		}

		/**
		* 获取： 家属手机号
		*/
		public String getJiashuPhone() {
			return jiashuPhone;
		}
		/**
		* 设置： 家属手机号
		*/
		public void setJiashuPhone(String jiashuPhone) {
			this.jiashuPhone = jiashuPhone;
		}

		/**
		* 获取： 家属身份证号
		*/
		public String getJiashuIdNumber() {
			return jiashuIdNumber;
		}
		/**
		* 设置： 家属身份证号
		*/
		public void setJiashuIdNumber(String jiashuIdNumber) {
			this.jiashuIdNumber = jiashuIdNumber;
		}

		/**
		* 获取： 家属头像
		*/
		public String getJiashuPhoto() {
			return jiashuPhoto;
		}
		/**
		* 设置： 家属头像
		*/
		public void setJiashuPhoto(String jiashuPhoto) {
			this.jiashuPhoto = jiashuPhoto;
		}

		/**
		* 获取： 家属邮箱
		*/
		public String getJiashuEmail() {
			return jiashuEmail;
		}
		/**
		* 设置： 家属邮箱
		*/
		public void setJiashuEmail(String jiashuEmail) {
			this.jiashuEmail = jiashuEmail;
		}
	//级联表的get和set 护工

		/**
		* 获取： 护工编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 护工编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 护工姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 护工姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 护工手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 护工手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 护工身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 护工身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 护工头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 护工头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}
		/**
		* 获取： 护工等级
		*/
		public Integer getYonghuTypes() {
			return yonghuTypes;
		}
		/**
		* 设置： 护工等级
		*/
		public void setYonghuTypes(Integer yonghuTypes) {
			this.yonghuTypes = yonghuTypes;
		}


			/**
			* 获取： 护工等级的值
			*/
			public String getYonghuValue() {
				return yonghuValue;
			}
			/**
			* 设置： 护工等级的值
			*/
			public void setYonghuValue(String yonghuValue) {
				this.yonghuValue = yonghuValue;
			}

		/**
		* 获取： 价钱
		*/
		public String getYonghuJaiwei() {
			return yonghuJaiwei;
		}
		/**
		* 设置： 价钱
		*/
		public void setYonghuJaiwei(String yonghuJaiwei) {
			this.yonghuJaiwei = yonghuJaiwei;
		}

		/**
		* 获取： 护工邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 护工邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}

	//重复字段

	@Override
	public String toString() {
		return "LaorenView{" +
			", sexValue=" + sexValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuJaiwei=" + yonghuJaiwei +
			", yonghuEmail=" + yonghuEmail +
			", chuangweiName=" + chuangweiName +
			", chuangweiUuidNumber=" + chuangweiUuidNumber +
			", chuangweiPhoto=" + chuangweiPhoto +
			", chuangweiAddress=" + chuangweiAddress +
			", chuangweiContent=" + chuangweiContent +
			", chuangweiDelete=" + chuangweiDelete +
			", jiashuUuidNumber=" + jiashuUuidNumber +
			", jiashuName=" + jiashuName +
			", jiashuPhone=" + jiashuPhone +
			", jiashuIdNumber=" + jiashuIdNumber +
			", jiashuPhoto=" + jiashuPhoto +
			", jiashuEmail=" + jiashuEmail +
			"} " + super.toString();
	}
}
