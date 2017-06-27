/*
 * BasIconSvg.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="svg图标对象")
public class BasIconSvg {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * icon图标
     */
    @ApiModelProperty(value="icon图标")
    private String icon;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    /**
     * svg path路劲
     */
    @ApiModelProperty(value="svg path路劲")
    private String svg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg == null ? null : svg.trim();
    }
}