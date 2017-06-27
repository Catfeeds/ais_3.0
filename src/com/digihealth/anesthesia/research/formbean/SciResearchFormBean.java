package com.digihealth.anesthesia.research.formbean;

import java.util.Date;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SciResearchFormBean {

	@ApiModelProperty(value = "")
	private List<SciResearchFilter> regOptFilters; // b_reg_opt

	@ApiModelProperty(value = "")
	private List<SciResearchFilter> anaesRecordFilters; // d_anaes_record

	@ApiModelProperty(value = "")
	private SciResearchFilter anaesEventFilter; // s_anaes_event

	@ApiModelProperty(value = "")
	private SciResearchFilter useMedEventFilter;// s_medical_event

	@ApiModelProperty(value = "")
	private SciResearchFilter ioEventFilter;// s_ioevent

	@ApiModelProperty(value = "")
	private SciResearchFilter egressEventFilter;// s_egress

	@ApiModelProperty(value = "")
	private SciResearchFilter instrumentFilter;// d_instrubill_item

	@ApiModelProperty(value = "")
	private SciResearchFilter analgesicFilter; // d_analgesic_record

	@ApiModelProperty(value = "")
	private SciResearchFilter lifeSignFilter;// b_monitor_config

	@ApiModelProperty(value = "")
	private SciResearchFilter implOperFilter; // s_real_anaes_method全麻
												// d_opt_nurse_record 局麻

	@ApiModelProperty(value = "")
	private SciResearchFilter implDiagFilter;// s_opt_latter_diag 全麻
												// 局麻从b_reg_opt中获取

	@ApiModelProperty(value = "")
	private SciResearchFilter implAnaesMethodFilter; // s_real_anaes_method全麻
														// d_opt_nurse_record 局麻

	@ApiModelProperty(value = "模板id")
	private String id; // 模板id

	@ApiModelProperty(value = "应用级别")
	private Integer type; // 应用级别

	@ApiModelProperty(value = "说明")
	private String remark; // 说明

	@ApiModelProperty(value = "模板名称")
	private String tmpName; // 模板名称

	@ApiModelProperty(value = "创建id")
	private Integer createUser;// 创建id

	@ApiModelProperty(value = "创建时间")
	private Date createTime;// 创建时间

	public List<SciResearchFilter> getRegOptFilters() {
		return regOptFilters;
	}

	public void setRegOptFilters(List<SciResearchFilter> regOptFilters) {
		this.regOptFilters = regOptFilters;
	}

	public List<SciResearchFilter> getAnaesRecordFilters() {
		return anaesRecordFilters;
	}

	public void setAnaesRecordFilters(List<SciResearchFilter> anaesRecordFilters) {
		this.anaesRecordFilters = anaesRecordFilters;
	}

	public SciResearchFilter getAnaesEventFilter() {
		return anaesEventFilter;
	}

	public void setAnaesEventFilter(SciResearchFilter anaesEventFilter) {
		this.anaesEventFilter = anaesEventFilter;
	}

	public SciResearchFilter getUseMedEventFilter() {
		return useMedEventFilter;
	}

	public void setUseMedEventFilter(SciResearchFilter useMedEventFilter) {
		this.useMedEventFilter = useMedEventFilter;
	}

	public SciResearchFilter getIoEventFilter() {
		return ioEventFilter;
	}

	public void setIoEventFilter(SciResearchFilter ioEventFilter) {
		this.ioEventFilter = ioEventFilter;
	}

	public SciResearchFilter getEgressEventFilter() {
		return egressEventFilter;
	}

	public void setEgressEventFilter(SciResearchFilter egressEventFilter) {
		this.egressEventFilter = egressEventFilter;
	}

	public SciResearchFilter getInstrumentFilter() {
		return instrumentFilter;
	}

	public void setInstrumentFilter(SciResearchFilter instrumentFilter) {
		this.instrumentFilter = instrumentFilter;
	}

	public SciResearchFilter getAnalgesicFilter() {
		return analgesicFilter;
	}

	public void setAnalgesicFilter(SciResearchFilter analgesicFilter) {
		this.analgesicFilter = analgesicFilter;
	}

	public SciResearchFilter getLifeSignFilter() {
		return lifeSignFilter;
	}

	public void setLifeSignFilter(SciResearchFilter lifeSignFilter) {
		this.lifeSignFilter = lifeSignFilter;
	}

	public SciResearchFilter getImplOperFilter() {
		return implOperFilter;
	}

	public void setImplOperFilter(SciResearchFilter implOperFilter) {
		this.implOperFilter = implOperFilter;
	}

	public SciResearchFilter getImplDiagFilter() {
		return implDiagFilter;
	}

	public void setImplDiagFilter(SciResearchFilter implDiagFilter) {
		this.implDiagFilter = implDiagFilter;
	}

	public SciResearchFilter getImplAnaesMethodFilter() {
		return implAnaesMethodFilter;
	}

	public void setImplAnaesMethodFilter(SciResearchFilter implAnaesMethodFilter) {
		this.implAnaesMethodFilter = implAnaesMethodFilter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTmpName() {
		return tmpName;
	}

	public void setTmpName(String tmpName) {
		this.tmpName = tmpName;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
