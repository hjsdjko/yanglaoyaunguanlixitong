package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 房间
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangjian")
public class FangjianView extends FangjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 房间类型的值
	*/
	@ColumnInfo(comment="房间类型的字典表值",type="varchar(200)")
	private String fangjianValue;




	public FangjianView() {

	}

	public FangjianView(FangjianEntity fangjianEntity) {
		try {
			BeanUtils.copyProperties(this, fangjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "FangjianView{" +
			", fangjianValue=" + fangjianValue +
			"} " + super.toString();
	}
}
