/**
 * 
 */
package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class ValueObjcet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "名称")
	private String itemName;
	/**
	 * itemVaue property
	 */
	@ApiModelProperty(value = "值")
	private Integer itemValue;

	@ApiModelProperty(value = "编码")
	private String itemCode;

	/**
	 * itemCode property
	 * 
	 * /**
	 * 
	 * @author chengwang
	 * @created 2015-10-19 上午9:39:58
	 * @return type
	 */

	public String getItemName() {
		return itemName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:39:58
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 下午4:11:37
	 * @return type
	 */

	public Integer getItemValue() {
		return itemValue;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 下午4:11:37
	 * @param itemValue
	 */
	public void setItemValue(Integer itemValue) {
		this.itemValue = itemValue;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:39:58
	 * @return type
	 */

	public String getItemCode() {
		return itemCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-19 上午9:39:58
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

}
