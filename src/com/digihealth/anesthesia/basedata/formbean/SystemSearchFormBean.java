/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-23 上午9:48:27    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Title: SearchConditionFormBean.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-23 上午9:48:27
 */
@ApiModel(value = "系统查询对象")
public class SystemSearchFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "第几页")
	private Integer pageNo = 1;

	@ApiModelProperty(value = "一页展示的数量")
	private Integer pageSize = 15;

	@ApiModelProperty(value = "排序字段")
	private String sort;

	@ApiModelProperty(value = "排序 asc 升序     desc 降序")
	private String orderBy;

	@ApiModelProperty(value = "其他过滤条件")
	private List<Filter> filters;

	@ApiModelProperty(value = "局点id")
	private String beid;

	@ApiModelProperty(value = "模块")
	private String module;

	/**
	 * pageNo处理
	 * 
	 * @return
	 */
	public Integer getPageNo() {
		if (pageNo == null) {
			return 0;
		} else if (pageNo == 0) {
			return 0;
		} else {
			return (pageNo - 1) * pageSize;
		}
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return StringUtils.sqlValidate(sort);
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrderBy() {
		return StringUtils.sqlValidate(orderBy);
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
