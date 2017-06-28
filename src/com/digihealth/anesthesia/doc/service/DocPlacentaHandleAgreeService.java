package com.digihealth.anesthesia.doc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocPlacentaHandleAgree;

@Service
public class DocPlacentaHandleAgreeService extends BaseService
{
    public DocPlacentaHandleAgree searchPlacentaHandleAgreeByRegOptId(String regOptId) 
    {
        return docPlacentaHandleAgreeDao.selectByRegOptId(regOptId);
    }
    
    @Transactional
    public void updatePlacentaHandleAgree(DocPlacentaHandleAgree placentaHandleAgree)
    {
        docPlacentaHandleAgreeDao.updateByPrimaryKeySelective(placentaHandleAgree);
    }
}
