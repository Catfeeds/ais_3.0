/**
 * 
 */
package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAllergicReaction;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixCanal;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixGen;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixVisit;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryVenipuncture;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
     * Title: AnaesSummaryItemFormbean.java    
     * Description: 麻醉总结单附属记录创建
     * @author liuikui       
     * @created 2015-10-22 上午9:39:31
 */
@ApiModel(value = "麻醉总结单参数对象")
public class AnaesSummaryItemFormbean implements Serializable{

	@ApiModelProperty(value = "麻醉总结对象")
	private DocAnaesSummary anaesSummary;
	
	@ApiModelProperty(value = "麻醉总结附录单椎管穿刺麻醉对象")
	private DocAnaesSummaryAppendixCanal anaesSummaryAppendixCanal;

	@ApiModelProperty(value = "麻醉总结附录单全麻模块对象")
	private DocAnaesSummaryAppendixGen anaesSummaryAppendixGen;

	@ApiModelProperty(value = "麻醉总结附录单术后访视记录对象")
	private DocAnaesSummaryAppendixVisit anaesSummaryAppendixVisit;

	@ApiModelProperty(value = "麻醉期间严重过敏反应对象")
	private DocAnaesSummaryAllergicReaction anaesSummaryAllergicReaction;

	@ApiModelProperty(value = "中心静脉穿刺并发症对象")
	private DocAnaesSummaryVenipuncture anaesSummaryVenipuncture;
	
	public AnaesSummaryItemFormbean() {
		anaesSummary = new DocAnaesSummary();
		anaesSummaryAppendixCanal = new DocAnaesSummaryAppendixCanal();
		anaesSummaryAppendixGen = new DocAnaesSummaryAppendixGen();
		anaesSummaryAppendixVisit = new DocAnaesSummaryAppendixVisit();
		anaesSummaryAllergicReaction = new DocAnaesSummaryAllergicReaction();
		anaesSummaryVenipuncture = new DocAnaesSummaryVenipuncture();
	}
	
	public DocAnaesSummary getAnaesSummary() {
		return anaesSummary;
	}
	public void setAnaesSummary(DocAnaesSummary anaesSummary) {
		this.anaesSummary = anaesSummary;
	}
	public DocAnaesSummaryAppendixCanal getAnaesSummaryAppendixCanal()
	{
		return anaesSummaryAppendixCanal;
	}
	public void setAnaesSummaryAppendixCanal(
			DocAnaesSummaryAppendixCanal anaesSummaryAppendixCanal)
	{
		this.anaesSummaryAppendixCanal = anaesSummaryAppendixCanal;
	}
	public DocAnaesSummaryAppendixGen getAnaesSummaryAppendixGen()
	{
		return anaesSummaryAppendixGen;
	}
	public void setAnaesSummaryAppendixGen(
			DocAnaesSummaryAppendixGen anaesSummaryAppendixGen)
	{
		this.anaesSummaryAppendixGen = anaesSummaryAppendixGen;
	}
	public DocAnaesSummaryAppendixVisit getAnaesSummaryAppendixVisit()
	{
		return anaesSummaryAppendixVisit;
	}
	public void setAnaesSummaryAppendixVisit(
			DocAnaesSummaryAppendixVisit anaesSummaryAppendixVisit)
	{
		this.anaesSummaryAppendixVisit = anaesSummaryAppendixVisit;
	}
	public DocAnaesSummaryAllergicReaction getAnaesSummaryAllergicReaction() {
		return anaesSummaryAllergicReaction;
	}
	public void setAnaesSummaryAllergicReaction(
			DocAnaesSummaryAllergicReaction anaesSummaryAllergicReaction) {
		this.anaesSummaryAllergicReaction = anaesSummaryAllergicReaction;
	}
	public DocAnaesSummaryVenipuncture getAnaesSummaryVenipuncture() {
		return anaesSummaryVenipuncture;
	}
	public void setAnaesSummaryVenipuncture(
			DocAnaesSummaryVenipuncture anaesSummaryVenipuncture) {
		this.anaesSummaryVenipuncture = anaesSummaryVenipuncture;
	}
	
}
