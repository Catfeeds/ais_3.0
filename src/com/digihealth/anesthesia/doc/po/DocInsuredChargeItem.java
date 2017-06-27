/*
 * DocInsuredChargeItem.java
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

@ApiModel(value = "参保患者使用自费药品、医用材料和服务设施项目对象")
public class DocInsuredChargeItem {
    /**
     * 主键Id
     */
    @ApiModelProperty(value = "主键Id")
     private String id;

    /**
     * 参保单Id
     */
    @ApiModelProperty(value = "参保单Id")
     private String insuredId;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
     private Date time;

    /**
     * 自费项目名称
     */
    @ApiModelProperty(value = "自费项目名称")
     private String name;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
     private Float price;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
     private Float count;

    /**
     * 预计金额
     */
    @ApiModelProperty(value = "预计金额")
     private Float totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId == null ? null : insuredId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}