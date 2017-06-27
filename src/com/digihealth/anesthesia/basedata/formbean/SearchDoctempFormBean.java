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
@ApiModel(value = "查询文书模板参数对象")
public class SearchDoctempFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "第几页")
	private Integer pageNo;

	@ApiModelProperty(value = "每页显示条数")
	private Integer pageSize;

	@ApiModelProperty(value = "顺序")
	private String sort;

	@ApiModelProperty(value = "排序字段")
	private String orderBy;

	@ApiModelProperty(value = "创建人")
	private String createUser;

	@ApiModelProperty(value = "类型")
	private Integer type;

	@ApiModelProperty(value = "文书类型")
	private Integer docType;

	@ApiModelProperty(value = "过滤字段")
	private List<Filter> filters;

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public Integer getPageNo() {
		if (pageNo != null) {
			return (pageNo - 1) * pageSize;
		}
		return pageNo;
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
		// return StringUtils.sqlValidate(StringUtils.zhuanData(sort));
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
}
