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
public class StatisAnaesOptFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "总数")
	private Long total;

	@ApiModelProperty(value = "cate1")
	private String cate1;

	@ApiModelProperty(value = "麻醉开始时间")
	private String anaesStartTime;

	@ApiModelProperty(value = "麻醉结束时间")
	private String anaesEndTime;

	@ApiModelProperty(value = "时间")
	private String Time;

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @return type
	 */

	public Long getTotal() {
		return total;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @param total
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @return type
	 */

	public String getCate1() {
		return cate1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @param cate1
	 */
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @return type
	 */

	public String getAnaesStartTime() {
		return anaesStartTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @param anaesStartTime
	 */
	public void setAnaesStartTime(String anaesStartTime) {
		this.anaesStartTime = anaesStartTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @return type
	 */

	public String getAnaesEndTime() {
		return anaesEndTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @param anaesEndTime
	 */
	public void setAnaesEndTime(String anaesEndTime) {
		this.anaesEndTime = anaesEndTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @return type
	 */

	public String getTime() {
		return Time;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午11:27:52
	 * @param time
	 */
	public void setTime(String time) {
		Time = time;
	}

}
