/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-23 上午9:48:27    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.common.utils.StringUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Title: SearchConditionFormBean.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-23 上午9:48:27
 */

@ApiModel(value = "统计查询参数对象")
public class SearchConditionFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户登录名")
	private String loginName;
	@ApiModelProperty(value = "状态")
	private String state;
	private List<String> stateItems;
	private String isHold;
	@ApiModelProperty(value = "第几页")
	private Integer pageNo;
	@ApiModelProperty(value = "每页显示多少条")
	private Integer pageSize;
	@ApiModelProperty(value = "排序")
	private String sort;
	@ApiModelProperty(value = "排序字段")
	private String orderBy;
	@ApiModelProperty(value = "查询过滤字段")
	private List<Filter> filters;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "用户类型")
	private String userType;
	private List<String> optType;
	@ApiModelProperty(value = "手术ID")
	private String regOptId;

	/**
	 * 时间方式 1：月报 2：季报 3：年报 4：区间
	 */
	@ApiModelProperty(value = "时间方式 1：月报 2：季报 3：年报 4：区间")
	private String timeType;

	/**
	 * 时间范围 月报： 0：当前月 1：最近一个月 2：最近两个月 季报：0：当前季度 1：最近一个季度 2：最近两个季度 3：最近三个季度
	 * 年报：0：当前年 1：最近一年 2：最近两年
	 */
	@ApiModelProperty(value = "时间范围 ")
	private String timeRang;

	/**
	 * 手术医生id
	 */
	@ApiModelProperty(value = "手术医生id")
	private String operatorId;

	/**
	 * 护士id
	 */
	@ApiModelProperty(value = "护士id")
	private String nurseId;

	/**
	 * 手术室ID
	 */
	@ApiModelProperty(value = "手术室ID")
	private String operRoomId;

	/**
	 * 麻醉医生
	 */
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistId;

	/**
	 * queryMethod不为空则代表'手术信息查询功能 需要查询大于等于当前日期的数据'
	 * 
	 * @return
	 */
	private String queryMethod;

	/**
	 * 科室ID
	 */
	private String deptId;
	/**
	 * 基线id
	 */
	@ApiModelProperty(value = "基线id")
	private String beid;

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public List<String> getOptType() {
		return optType;
	}

	public void setOptType(List<String> optType) {
		this.optType = optType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<String> getStateItems() {
		if (StringUtils.isNotBlank(state)) {
			stateItems = new ArrayList<String>();
			String[] states = state.split(",");
			for (int i = 0; i < states.length; i++) {
				stateItems.add(states[i]);
			}
		}
		return stateItems;
	}

	public void setStateItems(List<String> stateItems) {
		this.stateItems = stateItems;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public String getIsHold() {
		return isHold;
	}

	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getQueryMethod() {
		return queryMethod;
	}

	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getTimeRang() {
		return timeRang;
	}

	public void setTimeRang(String timeRang) {
		this.timeRang = timeRang;
	}

}
