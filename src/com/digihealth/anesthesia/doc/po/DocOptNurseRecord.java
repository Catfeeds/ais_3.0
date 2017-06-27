/*
 * DocOptNurseRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术护理记录单对象")
public class DocOptNurseRecord {
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 手术id
     */
	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * NO_END,END
     */
	@ApiModelProperty(value = "是否完成(NO_END-未完成,END-完成)")
    private String processState;

    /**
     * 手术开始时间
     */
	@ApiModelProperty(value = "手术开始时间")
    private Date operStartTime;

    /**
     * 手术结束时间
     */
	@ApiModelProperty(value = "手术结束时间")
    private Date operEndTime;

    /**
     * 入室时间
     */
	@ApiModelProperty(value = "入室时间")
    private Date inOperRoomTime;

    /**
     * 出室时间
     */
	@ApiModelProperty(value = "出室时间")
    private Date outOperRoomTime;

    /**
     * 绿色通道
     */
	@ApiModelProperty(value = "绿色通道")
    private String greenChannel;

    /**
     * 洗手/巡回护士
     */
	@ApiModelProperty(value = "洗手/巡回护士")
    private String tourNurse;

    /**
     * 手术code
     */
	@ApiModelProperty(value = "手术code")
    private String operationCode;

    /**
     * 手术名称
     */
	@ApiModelProperty(value = "手术名称")
    private String operationName;

    /**
     * 手术名称
     */
	@ApiModelProperty(value = "手术名称")
    private List<Map<String, Object>> operationNameList;
    
    /**
     * 全身皮肤情况
     */
	@ApiModelProperty(value = "全身皮肤情况")
    private String bodySkin;

    /**
     * 全身皮肤情况描述
     */
	@ApiModelProperty(value = "全身皮肤情况描述")
    private String bodySkinDes;

    /**
     * 压疮评分
     */
	@ApiModelProperty(value = "压疮评分")
    private Integer braden;

    /**
     * 压疮评分详情
     */
	@ApiModelProperty(value = "压疮评分详情")
    private String bradenCond;

    /**
     * 坠床评分
     */
	@ApiModelProperty(value = "坠床评分")
    private Integer fall;

    /**
     * 坠床评分详情
     */
	@ApiModelProperty(value = "坠床评分详情")
    private String fallCond;

    /**
     * 手术部位标识
     */
	@ApiModelProperty(value = "手术部位标识")
    private String operPositionFlag;

    /**
     * 药物过敏史
     */
	@ApiModelProperty(value = "药物过敏史")
    private String allergic;

    /**
     * 手术前使用抗生素
     */
	@ApiModelProperty(value = "手术前使用抗生素")
    private String antibiotic;

	@ApiModelProperty(value = "麻醉方法CODE")
    private String designedAnaesMethodCode;

    /**
     * 麻醉方式名字
     */
	@ApiModelProperty(value = "麻醉方法名称")
    private String designedAnaesMethodName;

    /**
     * 皮肤消毒
     */
	@ApiModelProperty(value = "皮肤消毒")
    private String skinDisinfect;

    /**
     * 皮肤消毒其他
     */
	@ApiModelProperty(value = "皮肤消毒其他")
    private String skinDisinfectOther;

    /**
     * 总入量
     */
	@ApiModelProperty(value = "总入量")
    private Integer totalIn;

    /**
     * 输液
     */
	@ApiModelProperty(value = "输液")
    private String infusion;

    /**
     * 血型
     */
	@ApiModelProperty(value = "血型")
    private String bloodType;

    /**
     * 输血
     */
	@ApiModelProperty(value = "输血")
    private String blood;

    /**
     * 总出量
     */
	@ApiModelProperty(value = "总出量")
    private Integer totalOut;

    /**
     * 尿量
     */
	@ApiModelProperty(value = "尿量")
    private Integer urine;

    /**
     * 出血量
     */
	@ApiModelProperty(value = "出血量")
    private Integer bleeding;

    /**
     * 积血量
     */
	@ApiModelProperty(value = "积血量")
    private Integer hematocele;

    /**
     * 出量其他
     */
	@ApiModelProperty(value = "出量其他")
    private String outOther;

    /**
     * 气压止血器
     */
	@ApiModelProperty(value = "气压止血器")
    private String tourniquet;

    /**
     * 胸腔引流管
     */
	@ApiModelProperty(value = "胸腔引流管")
    private Integer chestTube;

    /**
     * 腹腔引流管
     */
	@ApiModelProperty(value = "腹腔引流管")
    private Integer intraperitonealTube;

    /**
     * 脑室引流管
     */
	@ApiModelProperty(value = "脑室引流管")
    private Integer intraventricularTube;

    /**
     * T管
     */
	@ApiModelProperty(value = "T管")
    private Integer tTube;

    /**
     * 负压球
     */
	@ApiModelProperty(value = "负压球")
    private Integer suctionBall;

    /**
     * 胶片
     */
	@ApiModelProperty(value = "胶片")
    private Integer film;

    /**
     * 伤口引流其他
     */
	@ApiModelProperty(value = "伤口引流其他")
    private String other;

    /**
     * 放置部位1
     */
	@ApiModelProperty(value = "放置部位1")
    private String placeSiteA1;

	@ApiModelProperty(value = "放置部位2")
    private String placeSiteA2;

    /**
     * 充气时间1
     */
	@ApiModelProperty(value = "充气时间1")
    private Date aeratedTime1;

    /**
     * 放气时间1
     */
	@ApiModelProperty(value = "放气时间1")
    private Date deflationTime1;

    /**
     * 总时间1
     */
	@ApiModelProperty(value = "总时间1")
    private Integer totalTime1;

    /**
     * 压力1
     */
	@ApiModelProperty(value = "压力1")
    private Integer pressure1;

	@ApiModelProperty(value = "放置部位1")
    private String placeSiteB1;

    /**
     * 放置部位2
     */
	@ApiModelProperty(value = "放置部位2")
    private String placeSiteB2;

    /**
     * 充气时间2
     */
	@ApiModelProperty(value = "充气时间2")
    private Date aeratedTime2;

    /**
     * 放气时间2
     */
	@ApiModelProperty(value = "放气时间2")
    private Date deflationTime2;

    /**
     * 总时间2
     */
	@ApiModelProperty(value = "总时间2")
    private Integer totalTime2;

    /**
     * 压力2
     */
	@ApiModelProperty(value = "压力2")
    private Integer pressure2;

    /**
     * 手术体位
     */
	@ApiModelProperty(value = "手术体位")
    private String optBody;

    /**
     * 使用车床时上拉床挡板
     */
	@ApiModelProperty(value = "使用车床时上拉床挡板")
    private String preventFall1;

    /**
     * 专人看护
     */
	@ApiModelProperty(value = "专人看护")
    private String preventFall2;

    /**
     * 约束带约束
     */
	@ApiModelProperty(value = "约束带约束")
    private String preventFall3;

    /**
     * 摆放体位时专人扶持
     */
	@ApiModelProperty(value = "摆放体位时专人扶持")
    private String preventFall4;

    /**
     * 保持床铺清洁平整干燥
     */
	@ApiModelProperty(value = "保持床铺清洁平整干燥")
    private String preventBraden1;

    /**
     * 骨突容易受压部位垫软垫
     */
	@ApiModelProperty(value = "骨突容易受压部位垫软垫")
    private String preventBraden2;

    /**
     * 术中注意观察皮肤及重要器官受压情况，病情允许时妥善调整体位
     */
	@ApiModelProperty(value = "术中注意观察皮肤及重要器官受压情况，病情允许时妥善调整体位")
    private String preventBraden3;

    /**
     * 防压疮其他
     */
	@ApiModelProperty(value = "防压疮其他")
    private String preventBradenOther;

    /**
     * 调节室温
     */
	@ApiModelProperty(value = "调节室温")
    private String preventHypothermia1;

    /**
     * 加盖棉被
     */
	@ApiModelProperty(value = "加盖棉被")
    private String preventHypothermia2;

    /**
     * 输注温液体
     */
	@ApiModelProperty(value = "输注温液体")
    private String preventHypothermia3;

    /**
     * 使用输血加温仪
     */
	@ApiModelProperty(value = "使用输血加温仪")
    private String preventHypothermia4;

    /**
     * 防术中低体温其他
     */
	@ApiModelProperty(value = "防术中低体温其他")
    private String preventHypothermiaOther;

    /**
     * 导尿
     */
	@ApiModelProperty(value = "导尿")
    private String otherNurse1;

    /**
     * 插胃管
     */
	@ApiModelProperty(value = "插胃管")
    private String otherNurse2;

    /**
     * 使用超声刀
     */
	@ApiModelProperty(value = "使用超声刀")
    private String otherNurse3;

    /**
     * 使用电刀
     */
	@ApiModelProperty(value = "使用电刀")
    private String otherNurse4;

    /**
     * 大腿
     */
	@ApiModelProperty(value = "大腿")
    private String negativePosition1;

    /**
     * 小腿
     */
	@ApiModelProperty(value = "小腿")
    private String negativePosition2;

    /**
     * 背部
     */
	@ApiModelProperty(value = "背部")
    private String negativePosition3;

    /**
     * 臀部
     */
	@ApiModelProperty(value = "臀部")
    private String negativePosition4;

    /**
     * 其他负极板放置部位
     */
	@ApiModelProperty(value = "其他负极板放置部位")
    private String negativePosition;

    /**
     * 粘贴部分皮肤
     */
	@ApiModelProperty(value = "粘贴部分皮肤")
    private String pasteSkin;

    /**
     * 是否有标本
     */
	@ApiModelProperty(value = "是否有标本")
    private String specimen;

    /**
     * 常规病理检查
     */
	@ApiModelProperty(value = "常规病理检查")
    private String specimen1;

    /**
     * 冰冻切片
     */
	@ApiModelProperty(value = "冰冻切片")
    private String specimen2;

    /**
     * 细菌培养
     */
	@ApiModelProperty(value = "细菌培养")
    private String specimen3;

    /**
     * 其他标本
     */
	@ApiModelProperty(value = "其他标本")
    private String specimenOther;

	@ApiModelProperty(value = "")
    private String specimenOtherCond;

    /**
     * 术后全身皮肤完整
     */
	@ApiModelProperty(value = "术后全身皮肤完整")
    private String postoperativeSkin1;

    /**
     * 术后全身皮肤受损
     */
	@ApiModelProperty(value = "术后全身皮肤受损")
    private String postoperativeSkin2;

    /**
     * ICU
     */
	@ApiModelProperty(value = "ICU")
    private String leaveto1;

    /**
     * 病房
     */
	@ApiModelProperty(value = "病房")
    private String leaveto2;

    /**
     * 病人去向其他
     */
	@ApiModelProperty(value = "病人去向其他")
    private String leavetoOther;

    /**
     * 离室血压
     */
	@ApiModelProperty(value = "离室血压")
    private String outBloodPre;

    /**
     * 离室脉搏
     */
	@ApiModelProperty(value = "离室脉搏")
    private Integer outPulse;

    /**
     * 离室呼吸
     */
	@ApiModelProperty(value = "离室呼吸")
    private Integer outBreath;

    /**
     * 特殊记录1
     */
	@ApiModelProperty(value = "特殊记录1")
    private String specialRecord1;

    /**
     * 特殊记录1时间
     */
	@ApiModelProperty(value = "特殊记录1时间")
    private Date specialRecord1Time;

    /**
     * 特殊记录1签名
     */
	@ApiModelProperty(value = "特殊记录1签名")
    private String specialRecord1Signature;

    /**
     * 特殊记录2
     */
	@ApiModelProperty(value = "特殊记录2")
    private String specialRecord2;

    /**
     * 特殊记录2时间
     */
	@ApiModelProperty(value = "特殊记录2时间")
    private Date specialRecord2Time;

    /**
     * 特殊记录2签名
     */
	@ApiModelProperty(value = "特殊记录2签名")
    private String specialRecord2Signature;

    /**
     * 特殊记录3
     */
	@ApiModelProperty(value = "特殊记录3")
    private String specialRecord3;

    /**
     * 特殊记录3时间
     */
	@ApiModelProperty(value = "特殊记录3时间")
    private Date specialRecord3Time;

    /**
     * 特殊记录3签名
     */
	@ApiModelProperty(value = "特殊记录3签名")
    private String specialRecord3Signature;

    /**
     * 特殊记录4
     */
	@ApiModelProperty(value = "特殊记录4")
    private String specialRecord4;

    /**
     * 特殊记录4时间
     */
	@ApiModelProperty(value = "特殊记录4时间")
    private Date specialRecord4Time;

    /**
     * 特殊记录4签名
     */
	@ApiModelProperty(value = "特殊记录4签名")
    private String specialRecord4Signature;

    /**
     * 接班血压
     */
	@ApiModelProperty(value = "接班血压")
    private String takeOverBloodPre;

    /**
     * 接班脉搏
     */
	@ApiModelProperty(value = "接班脉搏")
    private Integer takeOverPulse;

    /**
     * 接班呼吸
     */
	@ApiModelProperty(value = "接班呼吸")
    private Integer takeOverBreath;

    /**
     * 巡回护士签名
     */
	@ApiModelProperty(value = "巡回护士签名")
    private String tourNurseSignature;

    /**
     * 病区护士签名
     */
	@ApiModelProperty(value = "病区护士签名")
    private String wardNurseSignature;

    /**
     * 时间
     */
	@ApiModelProperty(value = "时间")
    private Date time;

    /**
     * 医生确认
     */
	@ApiModelProperty(value = "医生确认")
    private String doctorConfirm;

    /**
     * 麻醉方式
     */
	@ApiModelProperty(value = "麻醉方法")
    private List<Map<String, Object>> designedAnaesMethod;

	@ApiModelProperty(value = "输液值")
    private Map<String, Object> infusionMap;

	@ApiModelProperty(value = "输血值")
    private Map<String, Object> bloodMap;

	@ApiModelProperty(value = "压疮评分值")
    private Map<String, Object> bradenMap;

	@ApiModelProperty(value = "坠床评分值")
    private Map<String, Object> fallMap;
    
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

    public Date getOperStartTime() {
        return operStartTime;
    }

    public void setOperStartTime(Date operStartTime) {
        this.operStartTime = operStartTime;
    }

    public Date getOperEndTime() {
        return operEndTime;
    }

    public void setOperEndTime(Date operEndTime) {
        this.operEndTime = operEndTime;
    }

    public Date getInOperRoomTime() {
        return inOperRoomTime;
    }

    public void setInOperRoomTime(Date inOperRoomTime) {
        this.inOperRoomTime = inOperRoomTime;
    }

    public Date getOutOperRoomTime() {
        return outOperRoomTime;
    }

    public void setOutOperRoomTime(Date outOperRoomTime) {
        this.outOperRoomTime = outOperRoomTime;
    }

    public String getGreenChannel() {
        return greenChannel;
    }

    public void setGreenChannel(String greenChannel) {
        this.greenChannel = greenChannel == null ? null : greenChannel.trim();
    }

    public String getTourNurse() {
        return tourNurse;
    }

    public void setTourNurse(String tourNurse) {
        this.tourNurse = tourNurse == null ? null : tourNurse.trim();
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public String getBodySkin() {
        return bodySkin;
    }

    public void setBodySkin(String bodySkin) {
        this.bodySkin = bodySkin == null ? null : bodySkin.trim();
    }

    public String getBodySkinDes() {
        return bodySkinDes;
    }

    public void setBodySkinDes(String bodySkinDes) {
        this.bodySkinDes = bodySkinDes == null ? null : bodySkinDes.trim();
    }

    public Integer getBraden() {
        return braden;
    }

    public void setBraden(Integer braden) {
        this.braden = braden;
    }

    public String getBradenCond() {
        return bradenCond;
    }

    public void setBradenCond(String bradenCond) {
        this.bradenCond = bradenCond == null ? null : bradenCond.trim();
    }

    public Integer getFall() {
        return fall;
    }

    public void setFall(Integer fall) {
        this.fall = fall;
    }

    public String getFallCond() {
        return fallCond;
    }

    public void setFallCond(String fallCond) {
        this.fallCond = fallCond == null ? null : fallCond.trim();
    }

    public String getOperPositionFlag() {
        return operPositionFlag;
    }

    public void setOperPositionFlag(String operPositionFlag) {
        this.operPositionFlag = operPositionFlag == null ? null : operPositionFlag.trim();
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic == null ? null : allergic.trim();
    }

    public String getAntibiotic() {
        return antibiotic;
    }

    public void setAntibiotic(String antibiotic) {
        this.antibiotic = antibiotic == null ? null : antibiotic.trim();
    }

    public String getDesignedAnaesMethodCode() {
        return designedAnaesMethodCode;
    }

    public void setDesignedAnaesMethodCode(String designedAnaesMethodCode) {
        this.designedAnaesMethodCode = designedAnaesMethodCode == null ? null : designedAnaesMethodCode.trim();
    }

    public String getDesignedAnaesMethodName() {
        return designedAnaesMethodName;
    }

    public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
        this.designedAnaesMethodName = designedAnaesMethodName == null ? null : designedAnaesMethodName.trim();
    }

    public String getSkinDisinfect() {
        return skinDisinfect;
    }

    public void setSkinDisinfect(String skinDisinfect) {
        this.skinDisinfect = skinDisinfect == null ? null : skinDisinfect.trim();
    }

    public String getSkinDisinfectOther() {
        return skinDisinfectOther;
    }

    public void setSkinDisinfectOther(String skinDisinfectOther) {
        this.skinDisinfectOther = skinDisinfectOther == null ? null : skinDisinfectOther.trim();
    }

    public Integer getTotalIn() {
        return totalIn;
    }

    public void setTotalIn(Integer totalIn) {
        this.totalIn = totalIn;
    }

    public String getInfusion() {
        return infusion;
    }

    public void setInfusion(String infusion) {
        this.infusion = infusion == null ? null : infusion.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public Integer getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(Integer totalOut) {
        this.totalOut = totalOut;
    }

    public Integer getUrine() {
        return urine;
    }

    public void setUrine(Integer urine) {
        this.urine = urine;
    }

    public Integer getBleeding() {
        return bleeding;
    }

    public void setBleeding(Integer bleeding) {
        this.bleeding = bleeding;
    }

    public Integer getHematocele() {
        return hematocele;
    }

    public void setHematocele(Integer hematocele) {
        this.hematocele = hematocele;
    }

    public String getOutOther() {
        return outOther;
    }

    public void setOutOther(String outOther) {
        this.outOther = outOther == null ? null : outOther.trim();
    }

    public String getTourniquet() {
        return tourniquet;
    }

    public void setTourniquet(String tourniquet) {
        this.tourniquet = tourniquet == null ? null : tourniquet.trim();
    }

    public Integer getChestTube() {
        return chestTube;
    }

    public void setChestTube(Integer chestTube) {
        this.chestTube = chestTube;
    }

    public Integer getIntraperitonealTube() {
        return intraperitonealTube;
    }

    public void setIntraperitonealTube(Integer intraperitonealTube) {
        this.intraperitonealTube = intraperitonealTube;
    }

    public Integer getIntraventricularTube() {
        return intraventricularTube;
    }

    public void setIntraventricularTube(Integer intraventricularTube) {
        this.intraventricularTube = intraventricularTube;
    }

    public Integer gettTube() {
        return tTube;
    }

    public void settTube(Integer tTube) {
        this.tTube = tTube;
    }

    public Integer getSuctionBall() {
        return suctionBall;
    }

    public void setSuctionBall(Integer suctionBall) {
        this.suctionBall = suctionBall;
    }

    public Integer getFilm() {
        return film;
    }

    public void setFilm(Integer film) {
        this.film = film;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getPlaceSiteA1() {
        return placeSiteA1;
    }

    public void setPlaceSiteA1(String placeSiteA1) {
        this.placeSiteA1 = placeSiteA1 == null ? null : placeSiteA1.trim();
    }

    public String getPlaceSiteA2() {
        return placeSiteA2;
    }

    public void setPlaceSiteA2(String placeSiteA2) {
        this.placeSiteA2 = placeSiteA2 == null ? null : placeSiteA2.trim();
    }

    public Date getAeratedTime1() {
        return aeratedTime1;
    }

    public void setAeratedTime1(Date aeratedTime1) {
        this.aeratedTime1 = aeratedTime1;
    }

    public Date getDeflationTime1() {
        return deflationTime1;
    }

    public void setDeflationTime1(Date deflationTime1) {
        this.deflationTime1 = deflationTime1;
    }

    public Integer getTotalTime1() {
        return totalTime1;
    }

    public void setTotalTime1(Integer totalTime1) {
        this.totalTime1 = totalTime1;
    }

    public Integer getPressure1() {
        return pressure1;
    }

    public void setPressure1(Integer pressure1) {
        this.pressure1 = pressure1;
    }

    public String getPlaceSiteB1() {
        return placeSiteB1;
    }

    public void setPlaceSiteB1(String placeSiteB1) {
        this.placeSiteB1 = placeSiteB1 == null ? null : placeSiteB1.trim();
    }

    public String getPlaceSiteB2() {
        return placeSiteB2;
    }

    public void setPlaceSiteB2(String placeSiteB2) {
        this.placeSiteB2 = placeSiteB2 == null ? null : placeSiteB2.trim();
    }

    public Date getAeratedTime2() {
        return aeratedTime2;
    }

    public void setAeratedTime2(Date aeratedTime2) {
        this.aeratedTime2 = aeratedTime2;
    }

    public Date getDeflationTime2() {
        return deflationTime2;
    }

    public void setDeflationTime2(Date deflationTime2) {
        this.deflationTime2 = deflationTime2;
    }

    public Integer getTotalTime2() {
        return totalTime2;
    }

    public void setTotalTime2(Integer totalTime2) {
        this.totalTime2 = totalTime2;
    }

    public Integer getPressure2() {
        return pressure2;
    }

    public void setPressure2(Integer pressure2) {
        this.pressure2 = pressure2;
    }

    public String getOptBody() {
        return optBody;
    }

    public void setOptBody(String optBody) {
        this.optBody = optBody == null ? null : optBody.trim();
    }

    public String getPreventFall1() {
        return preventFall1;
    }

    public void setPreventFall1(String preventFall1) {
        this.preventFall1 = preventFall1 == null ? null : preventFall1.trim();
    }

    public String getPreventFall2() {
        return preventFall2;
    }

    public void setPreventFall2(String preventFall2) {
        this.preventFall2 = preventFall2 == null ? null : preventFall2.trim();
    }

    public String getPreventFall3() {
        return preventFall3;
    }

    public void setPreventFall3(String preventFall3) {
        this.preventFall3 = preventFall3 == null ? null : preventFall3.trim();
    }

    public String getPreventFall4() {
        return preventFall4;
    }

    public void setPreventFall4(String preventFall4) {
        this.preventFall4 = preventFall4 == null ? null : preventFall4.trim();
    }

    public String getPreventBraden1() {
        return preventBraden1;
    }

    public void setPreventBraden1(String preventBraden1) {
        this.preventBraden1 = preventBraden1 == null ? null : preventBraden1.trim();
    }

    public String getPreventBraden2() {
        return preventBraden2;
    }

    public void setPreventBraden2(String preventBraden2) {
        this.preventBraden2 = preventBraden2 == null ? null : preventBraden2.trim();
    }

    public String getPreventBraden3() {
        return preventBraden3;
    }

    public void setPreventBraden3(String preventBraden3) {
        this.preventBraden3 = preventBraden3 == null ? null : preventBraden3.trim();
    }

    public String getPreventBradenOther() {
        return preventBradenOther;
    }

    public void setPreventBradenOther(String preventBradenOther) {
        this.preventBradenOther = preventBradenOther == null ? null : preventBradenOther.trim();
    }

    public String getPreventHypothermia1() {
        return preventHypothermia1;
    }

    public void setPreventHypothermia1(String preventHypothermia1) {
        this.preventHypothermia1 = preventHypothermia1 == null ? null : preventHypothermia1.trim();
    }

    public String getPreventHypothermia2() {
        return preventHypothermia2;
    }

    public void setPreventHypothermia2(String preventHypothermia2) {
        this.preventHypothermia2 = preventHypothermia2 == null ? null : preventHypothermia2.trim();
    }

    public String getPreventHypothermia3() {
        return preventHypothermia3;
    }

    public void setPreventHypothermia3(String preventHypothermia3) {
        this.preventHypothermia3 = preventHypothermia3 == null ? null : preventHypothermia3.trim();
    }

    public String getPreventHypothermia4() {
        return preventHypothermia4;
    }

    public void setPreventHypothermia4(String preventHypothermia4) {
        this.preventHypothermia4 = preventHypothermia4 == null ? null : preventHypothermia4.trim();
    }

    public String getPreventHypothermiaOther() {
        return preventHypothermiaOther;
    }

    public void setPreventHypothermiaOther(String preventHypothermiaOther) {
        this.preventHypothermiaOther = preventHypothermiaOther == null ? null : preventHypothermiaOther.trim();
    }

    public String getOtherNurse1() {
        return otherNurse1;
    }

    public void setOtherNurse1(String otherNurse1) {
        this.otherNurse1 = otherNurse1 == null ? null : otherNurse1.trim();
    }

    public String getOtherNurse2() {
        return otherNurse2;
    }

    public void setOtherNurse2(String otherNurse2) {
        this.otherNurse2 = otherNurse2 == null ? null : otherNurse2.trim();
    }

    public String getOtherNurse3() {
        return otherNurse3;
    }

    public void setOtherNurse3(String otherNurse3) {
        this.otherNurse3 = otherNurse3 == null ? null : otherNurse3.trim();
    }

    public String getOtherNurse4() {
        return otherNurse4;
    }

    public void setOtherNurse4(String otherNurse4) {
        this.otherNurse4 = otherNurse4 == null ? null : otherNurse4.trim();
    }

    public String getNegativePosition1() {
        return negativePosition1;
    }

    public void setNegativePosition1(String negativePosition1) {
        this.negativePosition1 = negativePosition1 == null ? null : negativePosition1.trim();
    }

    public String getNegativePosition2() {
        return negativePosition2;
    }

    public void setNegativePosition2(String negativePosition2) {
        this.negativePosition2 = negativePosition2 == null ? null : negativePosition2.trim();
    }

    public String getNegativePosition3() {
        return negativePosition3;
    }

    public void setNegativePosition3(String negativePosition3) {
        this.negativePosition3 = negativePosition3 == null ? null : negativePosition3.trim();
    }

    public String getNegativePosition4() {
        return negativePosition4;
    }

    public void setNegativePosition4(String negativePosition4) {
        this.negativePosition4 = negativePosition4 == null ? null : negativePosition4.trim();
    }

    public String getNegativePosition() {
        return negativePosition;
    }

    public void setNegativePosition(String negativePosition) {
        this.negativePosition = negativePosition == null ? null : negativePosition.trim();
    }

    public String getPasteSkin() {
        return pasteSkin;
    }

    public void setPasteSkin(String pasteSkin) {
        this.pasteSkin = pasteSkin == null ? null : pasteSkin.trim();
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen == null ? null : specimen.trim();
    }

    public String getSpecimen1() {
        return specimen1;
    }

    public void setSpecimen1(String specimen1) {
        this.specimen1 = specimen1 == null ? null : specimen1.trim();
    }

    public String getSpecimen2() {
        return specimen2;
    }

    public void setSpecimen2(String specimen2) {
        this.specimen2 = specimen2 == null ? null : specimen2.trim();
    }

    public String getSpecimen3() {
        return specimen3;
    }

    public void setSpecimen3(String specimen3) {
        this.specimen3 = specimen3 == null ? null : specimen3.trim();
    }

    public String getSpecimenOther() {
        return specimenOther;
    }

    public void setSpecimenOther(String specimenOther) {
        this.specimenOther = specimenOther == null ? null : specimenOther.trim();
    }

    public String getSpecimenOtherCond() {
        return specimenOtherCond;
    }

    public void setSpecimenOtherCond(String specimenOtherCond) {
        this.specimenOtherCond = specimenOtherCond == null ? null : specimenOtherCond.trim();
    }

    public String getPostoperativeSkin1() {
        return postoperativeSkin1;
    }

    public void setPostoperativeSkin1(String postoperativeSkin1) {
        this.postoperativeSkin1 = postoperativeSkin1 == null ? null : postoperativeSkin1.trim();
    }

    public String getPostoperativeSkin2() {
        return postoperativeSkin2;
    }

    public void setPostoperativeSkin2(String postoperativeSkin2) {
        this.postoperativeSkin2 = postoperativeSkin2 == null ? null : postoperativeSkin2.trim();
    }

    public String getLeaveto1() {
        return leaveto1;
    }

    public void setLeaveto1(String leaveto1) {
        this.leaveto1 = leaveto1 == null ? null : leaveto1.trim();
    }

    public String getLeaveto2() {
        return leaveto2;
    }

    public void setLeaveto2(String leaveto2) {
        this.leaveto2 = leaveto2 == null ? null : leaveto2.trim();
    }

    public String getLeavetoOther() {
        return leavetoOther;
    }

    public void setLeavetoOther(String leavetoOther) {
        this.leavetoOther = leavetoOther == null ? null : leavetoOther.trim();
    }

    public String getOutBloodPre() {
        return outBloodPre;
    }

    public void setOutBloodPre(String outBloodPre) {
        this.outBloodPre = outBloodPre == null ? null : outBloodPre.trim();
    }

    public Integer getOutPulse() {
        return outPulse;
    }

    public void setOutPulse(Integer outPulse) {
        this.outPulse = outPulse;
    }

    public Integer getOutBreath() {
        return outBreath;
    }

    public void setOutBreath(Integer outBreath) {
        this.outBreath = outBreath;
    }

    public String getSpecialRecord1() {
        return specialRecord1;
    }

    public void setSpecialRecord1(String specialRecord1) {
        this.specialRecord1 = specialRecord1 == null ? null : specialRecord1.trim();
    }

    public Date getSpecialRecord1Time() {
        return specialRecord1Time;
    }

    public void setSpecialRecord1Time(Date specialRecord1Time) {
        this.specialRecord1Time = specialRecord1Time;
    }

    public String getSpecialRecord1Signature() {
        return specialRecord1Signature;
    }

    public void setSpecialRecord1Signature(String specialRecord1Signature) {
        this.specialRecord1Signature = specialRecord1Signature == null ? null : specialRecord1Signature.trim();
    }

    public String getSpecialRecord2() {
        return specialRecord2;
    }

    public void setSpecialRecord2(String specialRecord2) {
        this.specialRecord2 = specialRecord2 == null ? null : specialRecord2.trim();
    }

    public Date getSpecialRecord2Time() {
        return specialRecord2Time;
    }

    public void setSpecialRecord2Time(Date specialRecord2Time) {
        this.specialRecord2Time = specialRecord2Time;
    }

    public String getSpecialRecord2Signature() {
        return specialRecord2Signature;
    }

    public void setSpecialRecord2Signature(String specialRecord2Signature) {
        this.specialRecord2Signature = specialRecord2Signature == null ? null : specialRecord2Signature.trim();
    }

    public String getSpecialRecord3() {
        return specialRecord3;
    }

    public void setSpecialRecord3(String specialRecord3) {
        this.specialRecord3 = specialRecord3 == null ? null : specialRecord3.trim();
    }

    public Date getSpecialRecord3Time() {
        return specialRecord3Time;
    }

    public void setSpecialRecord3Time(Date specialRecord3Time) {
        this.specialRecord3Time = specialRecord3Time;
    }

    public String getSpecialRecord3Signature() {
        return specialRecord3Signature;
    }

    public void setSpecialRecord3Signature(String specialRecord3Signature) {
        this.specialRecord3Signature = specialRecord3Signature == null ? null : specialRecord3Signature.trim();
    }

    public String getSpecialRecord4() {
        return specialRecord4;
    }

    public void setSpecialRecord4(String specialRecord4) {
        this.specialRecord4 = specialRecord4 == null ? null : specialRecord4.trim();
    }

    public Date getSpecialRecord4Time() {
        return specialRecord4Time;
    }

    public void setSpecialRecord4Time(Date specialRecord4Time) {
        this.specialRecord4Time = specialRecord4Time;
    }

    public String getSpecialRecord4Signature() {
        return specialRecord4Signature;
    }

    public void setSpecialRecord4Signature(String specialRecord4Signature) {
        this.specialRecord4Signature = specialRecord4Signature == null ? null : specialRecord4Signature.trim();
    }

    public String getTakeOverBloodPre() {
        return takeOverBloodPre;
    }

    public void setTakeOverBloodPre(String takeOverBloodPre) {
        this.takeOverBloodPre = takeOverBloodPre == null ? null : takeOverBloodPre.trim();
    }

    public Integer getTakeOverPulse() {
        return takeOverPulse;
    }

    public void setTakeOverPulse(Integer takeOverPulse) {
        this.takeOverPulse = takeOverPulse;
    }

    public Integer getTakeOverBreath() {
        return takeOverBreath;
    }

    public void setTakeOverBreath(Integer takeOverBreath) {
        this.takeOverBreath = takeOverBreath;
    }

    public String getTourNurseSignature() {
        return tourNurseSignature;
    }

    public void setTourNurseSignature(String tourNurseSignature) {
        this.tourNurseSignature = tourNurseSignature == null ? null : tourNurseSignature.trim();
    }

    public String getWardNurseSignature() {
        return wardNurseSignature;
    }

    public void setWardNurseSignature(String wardNurseSignature) {
        this.wardNurseSignature = wardNurseSignature == null ? null : wardNurseSignature.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDoctorConfirm() {
        return doctorConfirm;
    }

    public void setDoctorConfirm(String doctorConfirm) {
        this.doctorConfirm = doctorConfirm == null ? null : doctorConfirm.trim();
    }

	public List<Map<String, Object>> getOperationNameList() {
		return operationNameList;
	}

	public void setOperationNameList(List<Map<String, Object>> operationNameList) {
		this.operationNameList = operationNameList;
	}

	public List<Map<String, Object>> getDesignedAnaesMethod() {
		return designedAnaesMethod;
	}

	public void setDesignedAnaesMethod(List<Map<String, Object>> designedAnaesMethod) {
		this.designedAnaesMethod = designedAnaesMethod;
	}

	public Map<String, Object> getInfusionMap() {
		return infusionMap;
	}

	public void setInfusionMap(Map<String, Object> infusionMap) {
		this.infusionMap = infusionMap;
	}

	public Map<String, Object> getBloodMap() {
		return bloodMap;
	}

	public void setBloodMap(Map<String, Object> bloodMap) {
		this.bloodMap = bloodMap;
	}

	public Map<String, Object> getBradenMap() {
		return bradenMap;
	}

	public void setBradenMap(Map<String, Object> bradenMap) {
		this.bradenMap = bradenMap;
	}

	public Map<String, Object> getFallMap() {
		return fallMap;
	}

	public void setFallMap(Map<String, Object> fallMap) {
		this.fallMap = fallMap;
	}
    
}