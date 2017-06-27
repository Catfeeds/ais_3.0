package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.digihealth.anesthesia.operProceed.formbean.LegendData;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SciCompareFormbean {

	@ApiModelProperty(value = "姓名")
	private String name;// 姓名

	@ApiModelProperty(value = "性别")
	private String sex;// 性别

	@ApiModelProperty(value = "年龄")
	private String age;// 年龄

	@ApiModelProperty(value = "身高")
	private Float height;// 身高

	@ApiModelProperty(value = "体重")
	private Float weight;// 体重

	@ApiModelProperty(value = "药物过敏史")
	private String hyperSusceptiBility;// 药物过敏史

	@ApiModelProperty(value = "手术开始时间")
	private String operStartTime;// 手术开始时间

	@ApiModelProperty(value = "手术类型")
	private String emergency;// 手术类型

	@ApiModelProperty(value = "诊断名称")
	private String diagnosisName;// 诊断名称

	@ApiModelProperty(value = "手术名称")
	private String operationName;// 手术名称

	@ApiModelProperty(value = "手术体位")
	private String optBody;// 手术体位

	@ApiModelProperty(value = "手术时长")
	private String operateTime;// 手术时长

	@ApiModelProperty(value = "麻醉方法")
	private String anaesMethod;// 麻醉方法

	@ApiModelProperty(value = "麻醉事件")
	private String anaesEvent;// 麻醉事件

	@ApiModelProperty(value = "麻醉时长")
	private String anaesTime;// 麻醉时长

	@ApiModelProperty(value = "麻醉总结")
	private String anaesSummary;// 麻醉总结

	@ApiModelProperty(value = "镇痛方式")
	private String analgesicMethod;// 镇痛方式

	@ApiModelProperty(value = "用药信息")
	private String medicLs;// 用药信息

	@ApiModelProperty(value = "入量信息")
	private String ioevent;// 入量信息

	@ApiModelProperty(value = "出量信息")
	private String egressevent;// 出量信息

	@ApiModelProperty(value = "asa分级")
	private String asa;// asa分级

	@ApiModelProperty(value = "是否局麻;0-不是局麻，即全麻,1-是局麻")
	private Integer isLocalAnaes;//

	@ApiModelProperty(value = "x轴数据")
	private List<LifeSignXAxis1Data> xAxis;

	@ApiModelProperty(value = "series数据")
	private List<LifeSignSeriesData> series;

	@ApiModelProperty(value = "y轴数据")
	private List<LifeSignYAxisData> yAxis;

	@ApiModelProperty(value = "图例数据")
	private LegendData legend;

	public Integer getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(Integer isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getHyperSusceptiBility() {
		return hyperSusceptiBility;
	}

	public void setHyperSusceptiBility(String hyperSusceptiBility) {
		this.hyperSusceptiBility = hyperSusceptiBility;
	}

	public String getOperStartTime() {
		return operStartTime;
	}

	public void setOperStartTime(String operStartTime) {
		this.operStartTime = operStartTime;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOptBody() {
		return optBody;
	}

	public void setOptBody(String optBody) {
		this.optBody = optBody;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getAnaesMethod() {
		return anaesMethod;
	}

	public void setAnaesMethod(String anaesMethod) {
		this.anaesMethod = anaesMethod;
	}

	public String getAnaesEvent() {
		return anaesEvent;
	}

	public void setAnaesEvent(String anaesEvent) {
		this.anaesEvent = anaesEvent;
	}

	public String getAnaesTime() {
		return anaesTime;
	}

	public void setAnaesTime(String anaesTime) {
		this.anaesTime = anaesTime;
	}

	public String getAnaesSummary() {
		return anaesSummary;
	}

	public void setAnaesSummary(String anaesSummary) {
		this.anaesSummary = anaesSummary;
	}

	public String getAnalgesicMethod() {
		return analgesicMethod;
	}

	public void setAnalgesicMethod(String analgesicMethod) {
		this.analgesicMethod = analgesicMethod;
	}

	public String getMedicLs() {
		return medicLs;
	}

	public void setMedicLs(String medicLs) {
		this.medicLs = medicLs;
	}

	public String getIoevent() {
		return ioevent;
	}

	public void setIoevent(String ioevent) {
		this.ioevent = ioevent;
	}

	public String getEgressevent() {
		return egressevent;
	}

	public void setEgressevent(String egressevent) {
		this.egressevent = egressevent;
	}

	public String getAsa() {
		return asa;
	}

	public void setAsa(String asa) {
		this.asa = asa;
	}

	public List<LifeSignXAxis1Data> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<LifeSignXAxis1Data> xAxis) {
		this.xAxis = xAxis;
	}

	public List<LifeSignSeriesData> getSeries() {
		return series;
	}

	public void setSeries(List<LifeSignSeriesData> series) {
		this.series = series;
	}

	public List<LifeSignYAxisData> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<LifeSignYAxisData> yAxis) {
		this.yAxis = yAxis;
	}

	public LegendData getLegend() {
		return legend;
	}

	public void setLegend(LegendData legend) {
		this.legend = legend;
	}

}
