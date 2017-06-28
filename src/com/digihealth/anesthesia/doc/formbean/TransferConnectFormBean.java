package com.digihealth.anesthesia.doc.formbean;

import java.util.List;

import com.digihealth.anesthesia.doc.po.DocTransferConnectRecord;
import com.digihealth.anesthesia.doc.po.DocTransferConnectType;

public class TransferConnectFormBean
{
    private DocTransferConnectRecord transferConnectRecord;
    
    private List<DocTransferConnectType> transferConnectTypeList;

    public DocTransferConnectRecord getTransferConnectRecord()
    {
        return transferConnectRecord;
    }

    public void setTransferConnectRecord(DocTransferConnectRecord transferConnectRecord)
    {
        this.transferConnectRecord = transferConnectRecord;
    }

    public List<DocTransferConnectType> getTransferConnectTypeList()
    {
        return transferConnectTypeList;
    }

    public void setTransferConnectTypeList(List<DocTransferConnectType> transferConnectTypeList)
    {
        this.transferConnectTypeList = transferConnectTypeList;
    }
}
