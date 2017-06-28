/*
 * DocPrePostVisit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术病人术前术后访问记录单对象")
public class DocPrePostVisit {
	@ApiModelProperty(value = "主键ID")
	private String id;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "是否完成")
	private String processState;

	/**
	 * 血型
	 */
	@ApiModelProperty(value = "血型")
	private Integer blood;

	/**
	 * 药物过敏史
	 */
	@ApiModelProperty(value = "药物过敏史")
	private String allergy;

	/**
	 * 既往病史
	 */
	@ApiModelProperty(value = "既往病史")
	private String briefHis;

	/**
	 * 既往病史其他
	 */
	@ApiModelProperty(value = "既往病史其他")
	private String briefHisOther;

	/**
	 * 术前护理问题及护理措施
	 */
	@ApiModelProperty(value = "术前护理问题及护理措施")
	private String nurseProblem;

	/**
	 * 术前护理问题及护理措施其他
	 */
	@ApiModelProperty(value = "术前护理问题及护理措施其他")
	private String nurseProblemOther;

	/**
	 * 术前访视人Id
	 */
	@ApiModelProperty(value = "术前访视人Id")
	private String preVisitorId;

	/**
	 * 术前访视人姓名
	 */
	@ApiModelProperty(value = "术前访视人姓名")
	private String preVisitorName;

	/**
	 * 术前访视时间
	 */
	@ApiModelProperty(value = "术前访视时间")
	private Date preVisitTime;

	/**
	 * 病人入手术室心理状况
	 */
	@ApiModelProperty(value = "病人入手术室心理状况")
	private String psychological;

	/**
	 * 病人入手术室心理状况其他
	 */
	@ApiModelProperty(value = "病人入手术室心理状况其他")
	private String psychologicalOther;

	/**
	 * 手术室环境
	 */
	@ApiModelProperty(value = "手术室环境")
	private Integer environment;

	/**
	 * 手术室护士工作态度
	 */
	@ApiModelProperty(value = "手术室护士工作态度")
	private Integer workAttitude;

	/**
	 * 手术室护士对患者
	 */
	@ApiModelProperty(value = "手术室护士对患者")
	private Integer care;

	/**
	 * 建议
	 */
	@ApiModelProperty(value = "建议")
	private String suggest;

	/**
	 * 术后访视人ID
	 */
	@ApiModelProperty(value = "术后访视人ID")
	private String postVisitorId;

	/**
	 * 术后访视人姓名
	 */
	@ApiModelProperty(value = "术后访视人姓名")
	private String postVisitorName;

	/**
	 * 术后访视时间
	 */
	@ApiModelProperty(value = "术后访视时间")
	private Date postVisitTime;
	
	/**
     * HBsAg
     */
	@ApiModelProperty(value = "HBsAg")
    private Integer hbsag;

    /**
     * HCV
     */
	@ApiModelProperty(value = "HCV")
    private Integer hcv;

    /**
     * HIV
     */
	@ApiModelProperty(value = "HIV")
    private Integer hiv;

    /**
     * TPHA
     */
	@ApiModelProperty(value = "TPHA")
    private Integer tpha;

    /**
     * 血糖
     */
	@ApiModelProperty(value = "血糖")
    private Float bloodSugar;

    /**
     * 是否有过敏史
     */
	@ApiModelProperty(value = "是否有过敏史")
    private Integer isAllergy;

    /**
     * 手术史
     */
	@ApiModelProperty(value = "手术史")
    private Integer operHis;

    /**
     * 身体状况
     */
	@ApiModelProperty(value = "身体状况")
    private Integer bodyStatus;

    /**
     * 体型
     */
	@ApiModelProperty(value = "体型")
    private Integer bodyType;

    /**
     * 心理状态
     */
	@ApiModelProperty(value = "心理状态")
    private Integer mentalStatus;

    /**
     * 运动障碍
     */
	@ApiModelProperty(value = "运动障碍")
    private Integer moveObstacle;

    /**
     * 血管
     */
	@ApiModelProperty(value = "血管")
    private Integer bloodVessels;

    /**
     * 告知内容
     */
	@ApiModelProperty(value = "告知内容")
    private Integer informContent;

    /**
     * 特殊问题及注意事项
     */
	@ApiModelProperty(value = "特殊问题及注意事项")
    private String precautions;

    /**
     * 术前经治医生签名
     */
	@ApiModelProperty(value = "术前经治医生签名")
    private String preDoctorSign;

    /**
     * 术前麻醉师签名
     */
	@ApiModelProperty(value = "术前麻醉师签名")
    private String preAnaesSign;

    /**
     * 术前护士签名
     */
	@ApiModelProperty(value = "术前护士签名")
    private String preNurseSign;

    /**
     * 精神状态
     */
	@ApiModelProperty(value = "精神状态")
    private Integer spiritStatus;

    /**
     * 体温
     */
	@ApiModelProperty(value = "体温")
    private Integer temp;

    /**
     * 是否疼痛
     */
	@ApiModelProperty(value = "是否疼痛")
    private Integer pain;

    /**
     * 疼痛程度
     */
	@ApiModelProperty(value = "疼痛程度")
    private Integer painDegree;

    /**
     * 皮肤是否破损灼伤
     */
	@ApiModelProperty(value = "皮肤是否破损灼伤")
    private Integer skinDamaged;

    /**
     * 皮肤破损灼伤详情
     */
	@ApiModelProperty(value = "皮肤破损灼伤详情")
    private String skinDamagedDetails;

    /**
     * 切口敷料
     */
	@ApiModelProperty(value = "切口敷料")
    private Integer incisionDress;

    /**
     * 是否有并发症
     */
	@ApiModelProperty(value = "是否有并发症")
    private Integer complication;

    /**
     * 并发症详情
     */
	@ApiModelProperty(value = "并发症详情")
    private String complicationDetails;

    /**
     * 患者家属对手术室工作评价
     */
	@ApiModelProperty(value = "患者家属对手术室工作评价")
    private Integer jobAssess;

    /**
     * 患者家属对访视工作态度
     */
	@ApiModelProperty(value = "患者家属对访视工作态度")
    private Integer visitAttitude;

    /**
     * 特殊意见
     */
	@ApiModelProperty(value = "特殊意见")
    private String specialOpinions;

    /**
     * 术后经治医生签名
     */
	@ApiModelProperty(value = "术后经治医生签名")
    private String postDoctorSign;

    /**
     * 术后麻醉师签名
     */
	@ApiModelProperty(value = "术后麻醉师签名")
    private String postAnaesSign;

    /**
     * 术后护士签名
     */
	@ApiModelProperty(value = "术后护士签名")
    private String postNurseSign;

	public Integer getHbsag()
    {
        return hbsag;
    }

    public void setHbsag(Integer hbsag)
    {
        this.hbsag = hbsag;
    }

    public Integer getHcv()
    {
        return hcv;
    }

    public void setHcv(Integer hcv)
    {
        this.hcv = hcv;
    }

    public Integer getHiv()
    {
        return hiv;
    }

    public void setHiv(Integer hiv)
    {
        this.hiv = hiv;
    }

    public Integer getTpha()
    {
        return tpha;
    }

    public void setTpha(Integer tpha)
    {
        this.tpha = tpha;
    }

    public Float getBloodSugar()
    {
        return bloodSugar;
    }

    public void setBloodSugar(Float bloodSugar)
    {
        this.bloodSugar = bloodSugar;
    }

    public Integer getIsAllergy()
    {
        return isAllergy;
    }

    public void setIsAllergy(Integer isAllergy)
    {
        this.isAllergy = isAllergy;
    }

    public Integer getOperHis()
    {
        return operHis;
    }

    public void setOperHis(Integer operHis)
    {
        this.operHis = operHis;
    }

    public Integer getBodyStatus()
    {
        return bodyStatus;
    }

    public void setBodyStatus(Integer bodyStatus)
    {
        this.bodyStatus = bodyStatus;
    }

    public Integer getBodyType()
    {
        return bodyType;
    }

    public void setBodyType(Integer bodyType)
    {
        this.bodyType = bodyType;
    }

    public Integer getMentalStatus()
    {
        return mentalStatus;
    }

    public void setMentalStatus(Integer mentalStatus)
    {
        this.mentalStatus = mentalStatus;
    }

    public Integer getMoveObstacle()
    {
        return moveObstacle;
    }

    public void setMoveObstacle(Integer moveObstacle)
    {
        this.moveObstacle = moveObstacle;
    }

    public Integer getBloodVessels()
    {
        return bloodVessels;
    }

    public void setBloodVessels(Integer bloodVessels)
    {
        this.bloodVessels = bloodVessels;
    }

    public Integer getInformContent()
    {
        return informContent;
    }

    public void setInformContent(Integer informContent)
    {
        this.informContent = informContent;
    }

    public String getPrecautions()
    {
        return precautions;
    }

    public void setPrecautions(String precautions)
    {
        this.precautions = precautions;
    }

    public String getPreDoctorSign()
    {
        return preDoctorSign;
    }

    public void setPreDoctorSign(String preDoctorSign)
    {
        this.preDoctorSign = preDoctorSign;
    }

    public String getPreAnaesSign()
    {
        return preAnaesSign;
    }

    public void setPreAnaesSign(String preAnaesSign)
    {
        this.preAnaesSign = preAnaesSign;
    }

    public String getPreNurseSign()
    {
        return preNurseSign;
    }

    public void setPreNurseSign(String preNurseSign)
    {
        this.preNurseSign = preNurseSign;
    }

    public Integer getSpiritStatus()
    {
        return spiritStatus;
    }

    public void setSpiritStatus(Integer spiritStatus)
    {
        this.spiritStatus = spiritStatus;
    }

    public Integer getTemp()
    {
        return temp;
    }

    public void setTemp(Integer temp)
    {
        this.temp = temp;
    }

    public Integer getPain()
    {
        return pain;
    }

    public void setPain(Integer pain)
    {
        this.pain = pain;
    }

    public Integer getPainDegree()
    {
        return painDegree;
    }

    public void setPainDegree(Integer painDegree)
    {
        this.painDegree = painDegree;
    }

    public Integer getSkinDamaged()
    {
        return skinDamaged;
    }

    public void setSkinDamaged(Integer skinDamaged)
    {
        this.skinDamaged = skinDamaged;
    }

    public String getSkinDamagedDetails()
    {
        return skinDamagedDetails;
    }

    public void setSkinDamagedDetails(String skinDamagedDetails)
    {
        this.skinDamagedDetails = skinDamagedDetails;
    }

    public Integer getIncisionDress()
    {
        return incisionDress;
    }

    public void setIncisionDress(Integer incisionDress)
    {
        this.incisionDress = incisionDress;
    }

    public Integer getComplication()
    {
        return complication;
    }

    public void setComplication(Integer complication)
    {
        this.complication = complication;
    }

    public String getComplicationDetails()
    {
        return complicationDetails;
    }

    public void setComplicationDetails(String complicationDetails)
    {
        this.complicationDetails = complicationDetails;
    }

    public Integer getJobAssess()
    {
        return jobAssess;
    }

    public void setJobAssess(Integer jobAssess)
    {
        this.jobAssess = jobAssess;
    }

    public Integer getVisitAttitude()
    {
        return visitAttitude;
    }

    public void setVisitAttitude(Integer visitAttitude)
    {
        this.visitAttitude = visitAttitude;
    }

    public String getSpecialOpinions()
    {
        return specialOpinions;
    }

    public void setSpecialOpinions(String specialOpinions)
    {
        this.specialOpinions = specialOpinions;
    }

    public String getPostDoctorSign()
    {
        return postDoctorSign;
    }

    public void setPostDoctorSign(String postDoctorSign)
    {
        this.postDoctorSign = postDoctorSign;
    }

    public String getPostAnaesSign()
    {
        return postAnaesSign;
    }

    public void setPostAnaesSign(String postAnaesSign)
    {
        this.postAnaesSign = postAnaesSign;
    }

    public String getPostNurseSign()
    {
        return postNurseSign;
    }

    public void setPostNurseSign(String postNurseSign)
    {
        this.postNurseSign = postNurseSign;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
	}

	public Integer getBlood() {
		return blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy == null ? null : allergy.trim();
	}

	public String getBriefHis() {
		return briefHis;
	}

	public void setBriefHis(String briefHis) {
		this.briefHis = briefHis == null ? null : briefHis.trim();
	}

	public String getBriefHisOther() {
		return briefHisOther;
	}

	public void setBriefHisOther(String briefHisOther) {
		this.briefHisOther = briefHisOther == null ? null : briefHisOther
				.trim();
	}

	public String getNurseProblem() {
		return nurseProblem;
	}

	public void setNurseProblem(String nurseProblem) {
		this.nurseProblem = nurseProblem == null ? null : nurseProblem.trim();
	}

	public String getNurseProblemOther() {
		return nurseProblemOther;
	}

	public void setNurseProblemOther(String nurseProblemOther) {
		this.nurseProblemOther = nurseProblemOther == null ? null
				: nurseProblemOther.trim();
	}

	public String getPreVisitorId() {
		return preVisitorId;
	}

	public void setPreVisitorId(String preVisitorId) {
		this.preVisitorId = preVisitorId;
	}

	public String getPreVisitorName() {
		return preVisitorName;
	}

	public void setPreVisitorName(String preVisitorName) {
		this.preVisitorName = preVisitorName == null ? null : preVisitorName
				.trim();
	}

	public Date getPreVisitTime() {
		return preVisitTime;
	}

	public void setPreVisitTime(Date preVisitTime) {
		this.preVisitTime = preVisitTime;
	}

	public String getPsychological() {
		return psychological;
	}

	public void setPsychological(String psychological) {
		this.psychological = psychological == null ? null : psychological
				.trim();
	}

	public String getPsychologicalOther() {
		return psychologicalOther;
	}

	public void setPsychologicalOther(String psychologicalOther) {
		this.psychologicalOther = psychologicalOther == null ? null
				: psychologicalOther.trim();
	}

	public Integer getEnvironment() {
		return environment;
	}

	public void setEnvironment(Integer environment) {
		this.environment = environment;
	}

	public Integer getWorkAttitude() {
		return workAttitude;
	}

	public void setWorkAttitude(Integer workAttitude) {
		this.workAttitude = workAttitude;
	}

	public Integer getCare() {
		return care;
	}

	public void setCare(Integer care) {
		this.care = care;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest == null ? null : suggest.trim();
	}

	public String getPostVisitorId() {
		return postVisitorId;
	}

	public void setPostVisitorId(String postVisitorId) {
		this.postVisitorId = postVisitorId;
	}

	public String getPostVisitorName() {
		return postVisitorName;
	}

	public void setPostVisitorName(String postVisitorName) {
		this.postVisitorName = postVisitorName == null ? null : postVisitorName
				.trim();
	}

	public Date getPostVisitTime() {
		return postVisitTime;
	}

	public void setPostVisitTime(Date postVisitTime) {
		this.postVisitTime = postVisitTime;
	}
}