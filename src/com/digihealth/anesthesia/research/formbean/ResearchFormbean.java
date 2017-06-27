package com.digihealth.anesthesia.research.formbean;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class ResearchFormbean {

	@ApiModelProperty(value = "性别")
	private SciResearchFilter sex; // 性别

	@ApiModelProperty(value = "年龄")
	private SciResearchFilter age;// 年龄

	@ApiModelProperty(value = "身高")
	private SciResearchFilter height;// 身高

	@ApiModelProperty(value = "体重")
	private SciResearchFilter weight;// 体重

	@ApiModelProperty(value = "手术日期")
	private SciResearchFilter operaDate;// 手术日期

	@ApiModelProperty(value = "手术类型，择期or急诊")
	private SciResearchFilter emergency;// 手术类型，择期or急诊

	@ApiModelProperty(value = "拟施手术方法")
	private SciResearchFilter designedOptCode;// 拟施手术方法

	@ApiModelProperty(value = "拟施诊断")
	private SciResearchFilter diagnosisCode;// 拟施诊断

	@ApiModelProperty(value = "拟施麻醉方法")
	private SciResearchFilter designedAnaesMethodCode;// 拟施麻醉方法

	@ApiModelProperty(value = "麻醉事件")
	private SciResearchFilter anaesEvent;// 麻醉事件

	@ApiModelProperty(value = "用药事件")
	private SciResearchFilter medEvent;// 用药事件

	@ApiModelProperty(value = "入量")
	private SciResearchFilter ioEvent;// 入量

	@ApiModelProperty(value = "出量")
	private SciResearchFilter egressEvent;// 出量

	@ApiModelProperty(value = "镇痛")
	private SciResearchFilter analgesic;// 镇痛

	@ApiModelProperty(value = "实施手术方法")
	private SciResearchFilter implOper;// 实施手术方法

	@ApiModelProperty(value = "实施诊断")
	private SciResearchFilter implDiag;// 实施诊断

	@ApiModelProperty(value = "实施麻醉方法")
	private SciResearchFilter implAnaesMethod;// 实施麻醉方法

	@ApiModelProperty(value = "手术时长")
	private SciResearchFilter operTimeLength;// 手术时长

	@ApiModelProperty(value = "麻醉时长")
	private SciResearchFilter anaesTimeLength;// 麻醉时长

	@ApiModelProperty(value = "asa分级")
	private SciResearchFilter asaLevel;// asa分级

	@ApiModelProperty(value = "手术体位")
	private SciResearchFilter optBody;// 手术体位

	@ApiModelProperty(value = "生命体征")
	private SciResearchFilter lifeSign;// 生命体征

	@ApiModelProperty(value = "器械")
	private SciResearchFilter instrument;// 器械

	@ApiModelProperty(value = "模板id")
	private String id; // 模板id

	@ApiModelProperty(value = "应用级别")
	private Integer type; // 应用级别

	@ApiModelProperty(value = "说明")
	private String remark; // 说明

	@ApiModelProperty(value = "模板名称")
	private String tmpName; // 模板名称

	@ApiModelProperty(value = "创建id")
	private String createUser;// 创建id

	@ApiModelProperty(value = "创建时间")
	private Date createTime;// 创建时间

	public SciResearchFilter getSex() {
		return sex;
	}

	public void setSex(SciResearchFilter sex) {
		this.sex = sex;
	}

	public SciResearchFilter getAge() {
		return age;
	}

	public void setAge(SciResearchFilter age) {
		this.age = age;
	}

	public SciResearchFilter getHeight() {
		return height;
	}

	public void setHeight(SciResearchFilter height) {
		this.height = height;
	}

	public SciResearchFilter getWeight() {
		return weight;
	}

	public void setWeight(SciResearchFilter weight) {
		this.weight = weight;
	}

	public SciResearchFilter getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(SciResearchFilter operaDate) {
		this.operaDate = operaDate;
	}

	public SciResearchFilter getEmergency() {
		return emergency;
	}

	public void setEmergency(SciResearchFilter emergency) {
		this.emergency = emergency;
	}

	public SciResearchFilter getDesignedOptCode() {
		return designedOptCode;
	}

	public void setDesignedOptCode(SciResearchFilter designedOptCode) {
		this.designedOptCode = designedOptCode;
	}

	public SciResearchFilter getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(SciResearchFilter diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public SciResearchFilter getDesignedAnaesMethodCode() {
		return designedAnaesMethodCode;
	}

	public void setDesignedAnaesMethodCode(
			SciResearchFilter designedAnaesMethodCode) {
		this.designedAnaesMethodCode = designedAnaesMethodCode;
	}

	public SciResearchFilter getAnaesEvent() {
		return anaesEvent;
	}

	public void setAnaesEvent(SciResearchFilter anaesEvent) {
		this.anaesEvent = anaesEvent;
	}

	public SciResearchFilter getMedEvent() {
		return medEvent;
	}

	public void setMedEvent(SciResearchFilter medEvent) {
		this.medEvent = medEvent;
	}

	public SciResearchFilter getIoEvent() {
		return ioEvent;
	}

	public void setIoEvent(SciResearchFilter ioEvent) {
		this.ioEvent = ioEvent;
	}

	public SciResearchFilter getEgressEvent() {
		return egressEvent;
	}

	public void setEgressEvent(SciResearchFilter egressEvent) {
		this.egressEvent = egressEvent;
	}

	public SciResearchFilter getAnalgesic() {
		return analgesic;
	}

	public void setAnalgesic(SciResearchFilter analgesic) {
		this.analgesic = analgesic;
	}

	public SciResearchFilter getImplOper() {
		return implOper;
	}

	public void setImplOper(SciResearchFilter implOper) {
		this.implOper = implOper;
	}

	public SciResearchFilter getImplDiag() {
		return implDiag;
	}

	public void setImplDiag(SciResearchFilter implDiag) {
		this.implDiag = implDiag;
	}

	public SciResearchFilter getImplAnaesMethod() {
		return implAnaesMethod;
	}

	public void setImplAnaesMethod(SciResearchFilter implAnaesMethod) {
		this.implAnaesMethod = implAnaesMethod;
	}

	public SciResearchFilter getOperTimeLength() {
		return operTimeLength;
	}

	public void setOperTimeLength(SciResearchFilter operTimeLength) {
		this.operTimeLength = operTimeLength;
	}

	public SciResearchFilter getAnaesTimeLength() {
		return anaesTimeLength;
	}

	public void setAnaesTimeLength(SciResearchFilter anaesTimeLength) {
		this.anaesTimeLength = anaesTimeLength;
	}

	public SciResearchFilter getAsaLevel() {
		return asaLevel;
	}

	public void setAsaLevel(SciResearchFilter asaLevel) {
		this.asaLevel = asaLevel;
	}

	public SciResearchFilter getOptBody() {
		return optBody;
	}

	public void setOptBody(SciResearchFilter optBody) {
		this.optBody = optBody;
	}

	public SciResearchFilter getLifeSign() {
		return lifeSign;
	}

	public void setLifeSign(SciResearchFilter lifeSign) {
		this.lifeSign = lifeSign;
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SciResearchFilter getInstrument() {
		return instrument;
	}

	public void setInstrument(SciResearchFilter instrument) {
		this.instrument = instrument;
	}

}
