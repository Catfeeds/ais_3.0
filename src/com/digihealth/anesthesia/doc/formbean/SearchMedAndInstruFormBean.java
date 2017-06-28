package com.digihealth.anesthesia.doc.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "参保患者特殊用药、卫材查询对象")
public class SearchMedAndInstruFormBean
{
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;
    
    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private String spec;
    
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private Float price;
    
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSpec()
    {
        return spec;
    }

    public void setSpec(String spec)
    {
        this.spec = spec;
    }

    public Float getPrice()
    {
        return price;
    }

    public void setPrice(Float price)
    {
        this.price = price;
    }
}
