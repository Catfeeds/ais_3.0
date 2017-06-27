/*
 * EvtCheckEventItemRelation.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import java.util.Date;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "检验检查事件项目关联表对象")
public class EvtCheckEventItemRelation {
    /**
     * 检验检查事件项目关联表主键
     */
	@ApiModelProperty(value = "检验检查事件项目关联表主键")
    private String itemId;

    /**
     * 检验检查事件id
     */
	@ApiModelProperty(value = "检验检查事件id")
    private String cheEventId;

    /**
     * 检验检查项目代码
     */
	@ApiModelProperty(value = "检验检查项目代码")
    private String chkItemId;

    /**
     * 值
     */
	@ApiModelProperty(value = "值")
    private String value;

    /**
     * 文书Id
     */
	@ApiModelProperty(value = "文书Id")
    private String docId;

    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
    private Date occurTime;
    /**
     * 描述
     */
	@ApiModelProperty(value = "描述")
    private String resultDescribe;

	@ApiModelProperty(value = "检验检查项目名称")
    private String name;

	@ApiModelProperty(value = "检验检查项目单位")
    private String unit;

//	@ApiModelProperty(value = "检验检查事件项目关联表集合")
//	private List<EvtCheckEventItemRelation> vaildCheckItems;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getCheEventId() {
        return cheEventId;
    }

    public void setCheEventId(String cheEventId) {
        this.cheEventId = cheEventId == null ? null : cheEventId.trim();
    }

    public String getChkItemId() {
		return chkItemId;
	}

	public void setChkItemId(String chkItemId) {
		this.chkItemId = chkItemId;
	}

	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getResultDescribe() {
        return resultDescribe;
    }

    public void setResultDescribe(String resultDescribe) {
        this.resultDescribe = resultDescribe == null ? null : resultDescribe.trim();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

//	public List<EvtCheckEventItemRelation> getVaildCheckItems() {
//		return vaildCheckItems;
//	}
//
//	public void setVaildCheckItems(List<EvtCheckEventItemRelation> vaildCheckItems) {
//		this.vaildCheckItems = vaildCheckItems;
//	}
    
}