package com.digihealth.anesthesia.doc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocAnaesPlan;

@Service
public class DocAnaesPlanService extends BaseService {
    /** 
     * 查询麻醉计划
     * <功能详细描述>
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public DocAnaesPlan searchAnaesPlan(String regOptId) {
        return docAnaesPlanDao.selectByRegOptId(regOptId);
    }
    
    /** 
     * 更新保存麻醉计划
     * <功能详细描述>
     * @param anaesPlan
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Transactional
    public void updateAnaesPlan(DocAnaesPlan anaesPlan) {
    	docAnaesPlanDao.updateByPrimaryKeySelective(anaesPlan);
    }
}
