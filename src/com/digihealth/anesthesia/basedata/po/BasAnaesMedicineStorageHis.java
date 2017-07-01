package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineStorageHis {
    private Integer id;

    /**
     * 库存编号
     */
    private Integer storageId;

    /**
     * 库存统计盘点时间
     */
    private Date statisticsTime;

    /**
     * 盘点数量（月库存剩余数）
     */
    private Integer statisticsNum;

    /**
     * 局点编号
     */
    private String beid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public Integer getStatisticsNum() {
        return statisticsNum;
    }

    public void setStatisticsNum(Integer statisticsNum) {
        this.statisticsNum = statisticsNum;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}