package com.digihealth.anesthesia.operProceed.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.DeviceMonitorFormbean;
import com.digihealth.anesthesia.basedata.po.BasDeviceSpecification;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: AnaesMonitorFormBean.java Description: 麻醉监测点设置formbean
 * 
 * @author liukui
 * @created 2015年11月6日 上午10:41:36
 */
@ApiModel(value="麻醉监测标记点查询对象")
public class BasAnaesMonitorConfigFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
	private String deviceId;
    
    /**
     * b_monitor_config的eventId
     */
    @ApiModelProperty(value="eventId")
	private String eventId;
    
    /**
     * 是否采集
     */
    @ApiModelProperty(value="是否采集")
	private String optional;
    
    /**
     * 监测项名称
     */
    @ApiModelProperty(value="监测项名称")
	private String eventName;
    
    /**
     * 监测项描述
     */
    @ApiModelProperty(value="监测项描述")
	private String eventDesc;
    
    /**
     * 颜色
     */
    @ApiModelProperty(value="颜色")
	private String color;
    
    /**
     * 图片路径
     */
    @ApiModelProperty(value="图片路径")
	private String iconId;
    
    /**
     * 手术室id
     */
    @ApiModelProperty(value="手术室id")
	private Integer roomId;
    
    /**
     * 是否显示
     */
    @ApiModelProperty(value="是否显示")
	private String checked;
    
    /**
     * 必显项
     */
    @ApiModelProperty(value="必显项")
	private String mustShow;
    
    /**
     * 术中显示项对应的采集设备列表信息
     */
    @ApiModelProperty(value="术中显示项对应的采集设备列表信息")
	private List<BasDeviceSpecification> devSpeList;
    
    /**
     * 最大值
     */
    @ApiModelProperty(value="最大值")
	private Float max;
    
    /**
     * 最小值
     */
    @ApiModelProperty(value="最小值")
	private Float min;
    
    /**
     * 位置:0-描点位置,1-代表监测项位置
     */
    @ApiModelProperty(value="位置:0-描点位置,1-代表监测项位置")
	private Integer position;
    
    /**
     * 单位
     */
    @ApiModelProperty(value="单位")
	private String units;
    
    /**
     * 重复监测项对应的实际eventId
     */
    @ApiModelProperty(value="重复监测项对应的实际eventId")
	private String realEventId;

	public String getRealEventId()
    {
        return realEventId;
    }

    public void setRealEventId(String realEventId)
    {
        this.realEventId = realEventId;
    }

    private List<DeviceMonitorFormbean> devEventIdList; // 术中显示项对应的采集设备列表信息+采集指标ID
    
    
    public List<DeviceMonitorFormbean> getDevEventIdList() {
        return devEventIdList;
    }

    public void setDevEventIdList(List<DeviceMonitorFormbean> devEventIdList) {
        this.devEventIdList = devEventIdList;
    }
	public String getMustShow() {
		return mustShow;
	}

	public void setMustShow(String mustShow) {
		this.mustShow = mustShow;
	}

	public List<BasDeviceSpecification> getDevSpeList() {
		return devSpeList;
	}

	public void setDevSpeList(List<BasDeviceSpecification> devSpeList) {
		this.devSpeList = devSpeList;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIconId() {
		return iconId;
	}

	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Float getMax() {
		return max;
	}

	public void setMax(Float max) {
		this.max = max;
	}

	public Float getMin() {
		return min;
	}

	public void setMin(Float min) {
		this.min = min;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

}
