/**
 * 
 */
package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author ChengW
 * 
 */
@ApiModel(value = "查询参数对象")
public class StatisAnaesMethodNum implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * year property
	 */
	@ApiModelProperty(value = "年份")
	private Integer year;
	/**
	 * month property
	 */
	@ApiModelProperty(value = "月份")
	private Integer month;
	/**
	 * quarter property
	 */
	@ApiModelProperty(value = "季度")
	private Integer quarter;
	/**
	 * statisLevel property
	 */
	// private java.lang.String statisLevel;
	/**
	 * name property
	 */
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * vo property
	 */
	@ApiModelProperty(value = "vo")
	private ValueObjcet[] vo;
	/**
	 * voSize property
	 */
	@ApiModelProperty(value = "voSize")
	private Integer voSize;

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public Integer getYear() {
		return year;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public Integer getMonth() {
		return month;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param month
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public Integer getQuarter() {
		return quarter;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param quarter
	 */
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public String getName() {
		return name;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public ValueObjcet[] getVo() {
		return vo;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param vo
	 */
	public void setVo(ValueObjcet[] vo) {
		this.vo = vo;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @return type
	 */

	public Integer getVoSize() {
		return voSize;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:41:10
	 * @param voSize
	 */
	public void setVoSize(Integer voSize) {
		this.voSize = voSize;
	}

}
