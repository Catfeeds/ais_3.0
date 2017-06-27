package com.digihealth.anesthesia.doc.formbean;

/*
 * PatShuttleTransfer.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-01-14 Created
 */
import java.util.Date;

import com.digihealth.anesthesia.doc.formbean.DocKVFilters;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术患者接送交接单参数对象")
public class PatShuttleFormbean {

	@ApiModelProperty(value = "主键id")
    private String id;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 姓名
     */
	@ApiModelProperty(value = "姓名")
    private Integer nameChk;

    /**
     * 性别
     */
	@ApiModelProperty(value = "性别")
    private Integer sexChk;

    /**
     * 年龄
     */
	@ApiModelProperty(value = "年龄")
    private Integer ageChk;

    /**
     * 病室
     */
	@ApiModelProperty(value = "病室")
    private Integer roomChk;

    /**
     * 床号
     */
	@ApiModelProperty(value = "床号")
    private Integer bedChk;

    /**
     * 住院号
     */
	@ApiModelProperty(value = "住院号")
    private Integer hidChk;

    /**
     * 诊断
     */
	@ApiModelProperty(value = "诊断")
    private Integer diagChk;

    /**
     * 手术时间
     */
	@ApiModelProperty(value = "手术时间")
    private Integer operTimeChk;

    /**
     * 手术名称
     */
	@ApiModelProperty(value = "手术名称")
    private Integer operNameChk;

    /**
     * 手术部位
     */
	@ApiModelProperty(value = "手术部位")
    private Integer operBodyChk;

    /**
     * 检查患者皮肤准备情况
     */
	@ApiModelProperty(value = "检查患者皮肤准备情况")
    private Integer skinPlanChk;

    /**
     * 术前用清洁剂和温水彻底进行皮肤清洁（包括脐部）
     */
	@ApiModelProperty(value = "术前用清洁剂和温水彻底进行皮肤清洁（包括脐部）")
    private Integer preCleanChk;

    /**
     * 皮肤完整
     */
	@ApiModelProperty(value = "皮肤完整")
    private Integer skinFullChk;

    /**
     * 术前用药
     */
	@ApiModelProperty(value = "术前用药")
    private Integer preMedChk;

    /**
     * 特殊用药
     */
	@ApiModelProperty(value = "特殊用药")
    private Integer specMedChk;

    /**
     * 更衣
     */
	@ApiModelProperty(value = "更衣")
    private Integer dressingChk;

    /**
     * 戴手术帽
     */
	@ApiModelProperty(value = "戴手术帽")
    private Integer wearCapChk;

    /**
     * 腕带
     */
	@ApiModelProperty(value = "腕带")
    private Integer spireChk;

    /**
     * X片
     */
	@ApiModelProperty(value = "X片")
    private Integer xPianChk;

    /**
     * CT
     */
	@ApiModelProperty(value = "CT")
    private Integer ctChk;

    /**
     * MRI
     */
	@ApiModelProperty(value = "MRI")
    private Integer mriChk;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String other;

    /**
     * 手术室护士签名
     */
	@ApiModelProperty(value = "手术室护士签名")
    private String signUser;

    /**
     * 手术室护士签名日期时间
     */
	@ApiModelProperty(value = "手术室护士签名日期时间")
    private Date signTime;

    /**
     * 完成状态:END,NO_END
     */
	@ApiModelProperty(value = "完成状态:END,NO_END")
    private String processState;

    /**
     * 破损部位
     */
	@ApiModelProperty(value = "破损部位")
    private DocKVFilters worn;
    
    /**
     * 病例
     */
	@ApiModelProperty(value = "病例")
    private Integer patCase;

    /**
     * 下列物品是否除去
     */
	@ApiModelProperty(value = "下列物品是否除去")
    private DocKVFilters goodsRemove;

    /**
     * 术前医嘱执行情况
     */
	@ApiModelProperty(value = "术前医嘱执行情况")
    private DocKVFilters preAdviceExec;

    /**
     * 静脉通路部位
     */
	@ApiModelProperty(value = "静脉通路部位")
    private DocKVFilters veinBody;

    
	public DocKVFilters getWorn() {
		return worn;
	}

	public void setWorn(DocKVFilters worn) {
		this.worn = worn;
	}

	public Integer getPatCase() {
		return patCase;
	}

	public void setPatCase(Integer patCase) {
		this.patCase = patCase;
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
		this.regOptId = regOptId;
	}

	public Integer getNameChk() {
        return nameChk;
    }

    public void setNameChk(Integer nameChk) {
        this.nameChk = nameChk;
    }

    public Integer getSexChk() {
        return sexChk;
    }

    public void setSexChk(Integer sexChk) {
        this.sexChk = sexChk;
    }

    public Integer getAgeChk() {
        return ageChk;
    }

    public void setAgeChk(Integer ageChk) {
        this.ageChk = ageChk;
    }

    public Integer getRoomChk() {
        return roomChk;
    }

    public void setRoomChk(Integer roomChk) {
        this.roomChk = roomChk;
    }

    public Integer getBedChk() {
        return bedChk;
    }

    public void setBedChk(Integer bedChk) {
        this.bedChk = bedChk;
    }

    public Integer getHidChk() {
        return hidChk;
    }

    public void setHidChk(Integer hidChk) {
        this.hidChk = hidChk;
    }

    public Integer getDiagChk() {
        return diagChk;
    }

    public void setDiagChk(Integer diagChk) {
        this.diagChk = diagChk;
    }

    public Integer getOperTimeChk() {
        return operTimeChk;
    }

    public void setOperTimeChk(Integer operTimeChk) {
        this.operTimeChk = operTimeChk;
    }

    public Integer getOperNameChk() {
        return operNameChk;
    }

    public void setOperNameChk(Integer operNameChk) {
        this.operNameChk = operNameChk;
    }

    public Integer getOperBodyChk() {
        return operBodyChk;
    }

    public void setOperBodyChk(Integer operBodyChk) {
        this.operBodyChk = operBodyChk;
    }

    public Integer getSkinPlanChk() {
        return skinPlanChk;
    }

    public void setSkinPlanChk(Integer skinPlanChk) {
        this.skinPlanChk = skinPlanChk;
    }

    public Integer getPreCleanChk() {
        return preCleanChk;
    }

    public void setPreCleanChk(Integer preCleanChk) {
        this.preCleanChk = preCleanChk;
    }

    public Integer getSkinFullChk() {
        return skinFullChk;
    }

    public void setSkinFullChk(Integer skinFullChk) {
        this.skinFullChk = skinFullChk;
    }

    public Integer getPreMedChk() {
        return preMedChk;
    }

    public void setPreMedChk(Integer preMedChk) {
        this.preMedChk = preMedChk;
    }

    public Integer getSpecMedChk() {
        return specMedChk;
    }

    public void setSpecMedChk(Integer specMedChk) {
        this.specMedChk = specMedChk;
    }

    public Integer getDressingChk() {
        return dressingChk;
    }

    public void setDressingChk(Integer dressingChk) {
        this.dressingChk = dressingChk;
    }

    public Integer getWearCapChk() {
        return wearCapChk;
    }

    public void setWearCapChk(Integer wearCapChk) {
        this.wearCapChk = wearCapChk;
    }

    public Integer getSpireChk() {
        return spireChk;
    }

    public void setSpireChk(Integer spireChk) {
        this.spireChk = spireChk;
    }

    public Integer getxPianChk() {
        return xPianChk;
    }

    public void setxPianChk(Integer xPianChk) {
        this.xPianChk = xPianChk;
    }

    public Integer getCtChk() {
        return ctChk;
    }

    public void setCtChk(Integer ctChk) {
        this.ctChk = ctChk;
    }

    public Integer getMriChk() {
        return mriChk;
    }

    public void setMriChk(Integer mriChk) {
        this.mriChk = mriChk;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getSignUser() {
        return signUser;
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser == null ? null : signUser.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public DocKVFilters getVeinBody() {
        return veinBody;
    }

    public void setVeinBody(DocKVFilters veinBody) {
        this.veinBody = veinBody;
    }

	public DocKVFilters getGoodsRemove() {
		return goodsRemove;
	}

	public void setGoodsRemove(DocKVFilters goodsRemove) {
		this.goodsRemove = goodsRemove;
	}

	public DocKVFilters getPreAdviceExec() {
		return preAdviceExec;
	}

	public void setPreAdviceExec(DocKVFilters preAdviceExec) {
		this.preAdviceExec = preAdviceExec;
	}
    
}