package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LizhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 离职申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("lizhi")
public class LizhiView extends LizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String lizhiYesnoValue;

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



	public LizhiView() {

	}

	public LizhiView(LizhiEntity lizhiEntity) {
		try {
			BeanUtils.copyProperties(this, lizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getLizhiYesnoValue() {
		return lizhiYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setLizhiYesnoValue(String lizhiYesnoValue) {
		this.lizhiYesnoValue = lizhiYesnoValue;
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


	@Override
	public String toString() {
		return "LizhiView{" +
			", lizhiYesnoValue=" + lizhiYesnoValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuJaiwei=" + yonghuJaiwei +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
