/*
 * BasTitleStyle.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="标题样式对象")
public class BasTitleStyle {
    
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 1内屏 2外屏
     */
    @ApiModelProperty(value="1内屏 2外屏")
    private Integer type;

    @ApiModelProperty(value="标题")
    private String title;

    /**
     * 样式
     */
    @ApiModelProperty(value="样式")
    private String style;

    /**
     * 翻页时间
     */
    @ApiModelProperty(value="翻页时间")
    private Float flipTime;

    /**
     * 是否显示边框1是0否
     */
    @ApiModelProperty(value="是否显示边框1是0否")
    private Integer broderState;

    /**
     * 是否全屏 1是 0 否
     */
    @ApiModelProperty(value="是否全屏 1是 0 否")
    private Integer fullScreen;

    /**
     * 关闭选择项 1是 0否
     */
    @ApiModelProperty(value="关闭选择项 1是 0否")
    private Integer chooseState;

    /**
     * 列样式包含字体大小颜色等
     */
    @ApiModelProperty(value="列样式包含字体大小颜色等")
    private String columnStyle;

    @ApiModelProperty(value="每页数量")
    private Integer pageSize;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Float getFlipTime() {
        return flipTime;
    }

    public void setFlipTime(Float flipTime) {
        this.flipTime = flipTime;
    }

    public Integer getBroderState() {
        return broderState;
    }

    public void setBroderState(Integer broderState) {
        this.broderState = broderState;
    }

    public Integer getFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(Integer fullScreen) {
        this.fullScreen = fullScreen;
    }

    public Integer getChooseState() {
        return chooseState;
    }

    public void setChooseState(Integer chooseState) {
        this.chooseState = chooseState;
    }

    public String getColumnStyle() {
        return columnStyle;
    }

    public void setColumnStyle(String columnStyle) {
        this.columnStyle = columnStyle == null ? null : columnStyle.trim();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}