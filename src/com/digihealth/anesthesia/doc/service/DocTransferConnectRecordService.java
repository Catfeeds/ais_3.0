package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.formbean.TransferConnectFormBean;
import com.digihealth.anesthesia.doc.po.DocTransferConnectRecord;
import com.digihealth.anesthesia.doc.po.DocTransferConnectType;

@Service
public class DocTransferConnectRecordService extends BaseService
{
    public TransferConnectFormBean searchTransferConnect(String regOptId)
    {
        TransferConnectFormBean bean = new TransferConnectFormBean();
        DocTransferConnectRecord transferConnectRecord = docTransferConnectRecordDao.selectByRegOptId(regOptId);
        bean.setTransferConnectRecord(transferConnectRecord);
        if (null != transferConnectRecord)
        {
            List<DocTransferConnectType> transferConnectTypeList = docTransferConnectTypeDao.selectByTransferId(transferConnectRecord.getId());
            bean.setTransferConnectTypeList(transferConnectTypeList);
        }
        
        return bean;
    }
    
    @Transactional
    public void updateTransferConnect(TransferConnectFormBean transferConnect)
    {
        docTransferConnectRecordDao.updateByPrimaryKey(transferConnect.getTransferConnectRecord());
        
        List<DocTransferConnectType> transferConnectTypeList = transferConnect.getTransferConnectTypeList();
        if (null != transferConnectTypeList && transferConnectTypeList.size() > 0)
        {
            for (DocTransferConnectType transferConnectType : transferConnectTypeList)
            {
                if (null == transferConnectType.getId()) 
                {
                    transferConnectType.setId(GenerateSequenceUtil.generateSequenceNo());
                    transferConnectType.setRegOptId(transferConnect.getTransferConnectRecord().getRegOptId());
                    transferConnectType.setTransferId(transferConnect.getTransferConnectRecord().getId());
                    docTransferConnectTypeDao.insert(transferConnectType);
                }
                else
                {
                    docTransferConnectTypeDao.updateByPrimaryKey(transferConnectType);
                }
                
            }
        }
    }
}
