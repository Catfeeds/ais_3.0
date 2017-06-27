package com.digihealth.anesthesia.sysMng.formbean;

import java.util.List;

import com.digihealth.anesthesia.evt.formbean.Filter;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户参数对象")
public class UserFormbean {
	
	@ApiModelProperty(value = "第几页")
	private Integer pageNo;

	@ApiModelProperty(value = "每页显示多少行")
	private Integer pageSize;

	@ApiModelProperty(value = "其他过滤条件")
	private List<Filter> filters;

	@ApiModelProperty(value = "局点id")
	private String beid;
	
	public String getBeid()
    {
        return beid;
    }
    public void setBeid(String beid)
    {
        this.beid = beid;
    }
    public Integer getPageNo() {
		if(pageNo!=null){
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
	
	public List<Filter> getFilters() {
		return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
}
