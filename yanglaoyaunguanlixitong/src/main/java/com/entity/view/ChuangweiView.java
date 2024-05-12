package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChuangweiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 床位
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chuangwei")
public class ChuangweiView extends ChuangweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 床位类型的值
	*/
	@ColumnInfo(comment="床位类型的字典表值",type="varchar(200)")
	private String chuangweiValue;

	//级联表 房间
		/**
		* 房间名称
		*/

		@ColumnInfo(comment="房间名称",type="varchar(200)")
		private String fangjianName;
		/**
		* 房间编号
		*/

		@ColumnInfo(comment="房间编号",type="varchar(200)")
		private String fangjianUuidNumber;
		/**
		* 房间照片
		*/

		@ColumnInfo(comment="房间照片",type="varchar(200)")
		private String fangjianPhoto;
		/**
		* 房间地点
		*/

		@ColumnInfo(comment="房间地点",type="varchar(200)")
		private String fangjianAddress;
		/**
		* 房间类型
		*/
		@ColumnInfo(comment="房间类型",type="int(11)")
		private Integer fangjianTypes;
			/**
			* 房间类型的值
			*/
			@ColumnInfo(comment="房间类型的字典表值",type="varchar(200)")
			private String fangjianValue;
		/**
		* 房间介绍
		*/

		@ColumnInfo(comment="房间介绍",type="longtext")
		private String fangjianContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangjianDelete;



	public ChuangweiView() {

	}

	public ChuangweiView(ChuangweiEntity chuangweiEntity) {
		try {
			BeanUtils.copyProperties(this, chuangweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	//级联表的get和set 房间

		/**
		* 获取： 房间名称
		*/
		public String getFangjianName() {
			return fangjianName;
		}
		/**
		* 设置： 房间名称
		*/
		public void setFangjianName(String fangjianName) {
			this.fangjianName = fangjianName;
		}

		/**
		* 获取： 房间编号
		*/
		public String getFangjianUuidNumber() {
			return fangjianUuidNumber;
		}
		/**
		* 设置： 房间编号
		*/
		public void setFangjianUuidNumber(String fangjianUuidNumber) {
			this.fangjianUuidNumber = fangjianUuidNumber;
		}

		/**
		* 获取： 房间照片
		*/
		public String getFangjianPhoto() {
			return fangjianPhoto;
		}
		/**
		* 设置： 房间照片
		*/
		public void setFangjianPhoto(String fangjianPhoto) {
			this.fangjianPhoto = fangjianPhoto;
		}

		/**
		* 获取： 房间地点
		*/
		public String getFangjianAddress() {
			return fangjianAddress;
		}
		/**
		* 设置： 房间地点
		*/
		public void setFangjianAddress(String fangjianAddress) {
			this.fangjianAddress = fangjianAddress;
		}
		/**
		* 获取： 房间类型
		*/
		public Integer getFangjianTypes() {
			return fangjianTypes;
		}
		/**
		* 设置： 房间类型
		*/
		public void setFangjianTypes(Integer fangjianTypes) {
			this.fangjianTypes = fangjianTypes;
		}


			/**
			* 获取： 房间类型的值
			*/
			public String getFangjianValue() {
				return fangjianValue;
			}
			/**
			* 设置： 房间类型的值
			*/
			public void setFangjianValue(String fangjianValue) {
				this.fangjianValue = fangjianValue;
			}

		/**
		* 获取： 房间介绍
		*/
		public String getFangjianContent() {
			return fangjianContent;
		}
		/**
		* 设置： 房间介绍
		*/
		public void setFangjianContent(String fangjianContent) {
			this.fangjianContent = fangjianContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangjianDelete() {
			return fangjianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangjianDelete(Integer fangjianDelete) {
			this.fangjianDelete = fangjianDelete;
		}


	@Override
	public String toString() {
		return "ChuangweiView{" +
			", chuangweiValue=" + chuangweiValue +
			", fangjianName=" + fangjianName +
			", fangjianUuidNumber=" + fangjianUuidNumber +
			", fangjianPhoto=" + fangjianPhoto +
			", fangjianAddress=" + fangjianAddress +
			", fangjianContent=" + fangjianContent +
			", fangjianDelete=" + fangjianDelete +
			"} " + super.toString();
	}
}
