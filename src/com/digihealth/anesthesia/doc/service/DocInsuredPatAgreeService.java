package com.digihealth.anesthesia.doc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.formbean.InsuredPatAgreeFormBean;
import com.digihealth.anesthesia.doc.formbean.SearchMedAndInstruFormBean;
import com.digihealth.anesthesia.doc.po.DocInsuredItem;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class DocInsuredPatAgreeService extends BaseService
{
    public InsuredPatAgreeFormBean searchInsuredPatAgreeByRegOptId(String regOptId)
    {
        InsuredPatAgreeFormBean insuredPatAgreeFormBean = new InsuredPatAgreeFormBean();
        DocInsuredPatAgree insuredPatAgree = docInsuredPatAgreeDao.searchByRegOptId(regOptId);
        insuredPatAgreeFormBean.setDocInsuredPatAgree(insuredPatAgree);
        if (null != insuredPatAgree)
        {
            List<DocInsuredItem> insuredItemList = docInsuredItemDao.searchByInsuredId(insuredPatAgree.getId());
            insuredPatAgreeFormBean.setDocInsuredItemList(insuredItemList);
        }
        return insuredPatAgreeFormBean;
    }
    
    @Transactional
    public ResponseValue updateInsuredItem(DocInsuredItem insuredItem)
    {
        ResponseValue resp = new ResponseValue();
        
        DocInsuredItem insuredItemSql =
            docInsuredItemDao.searchByTypeAndCode(insuredItem.getInsuredId(),
                insuredItem.getCode(),
                insuredItem.getType(),
                insuredItem.getKind()); 
        if (null != insuredItemSql)
        {
            if (null == insuredItem.getId())
            {
                resp.setResultCode("40000002");
                resp.setResultMessage("药品或者耗材已存在，添加失败");
            }
            else
            {
                docInsuredItemDao.updateByPrimaryKeySelective(insuredItem);
            }
        }
        else
        {
            insuredItem.setId(GenerateSequenceUtil.generateSequenceNo());
            docInsuredItemDao.insertSelective(insuredItem);
        }
        
        return resp;
    }
    
    @Transactional
    public void deleteInsuredItem(DocInsuredItem insuredItem)
    {
        docInsuredItemDao.deleteByPrimaryKey(insuredItem.getId());
    }
    
    @Transactional
    public void updateInsuredPatAgree(DocInsuredPatAgree insuredPatAgree)
    {
        docInsuredPatAgreeDao.updateByPrimaryKeySelective(insuredPatAgree);
    }
    
    public List<SearchMedAndInstruFormBean> searchMedAndInstru(SystemSearchFormBean systemSearchFormBean)
    {
        if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
        
        String filter = "";
        List<Filter> filters = systemSearchFormBean.getFilters();
        if (filters != null && filters.size() > 0)
        {
            for (int i = 0; i < filters.size(); i++)
            {
                if (!StringUtils.isEmpty(filters.get(i).getValue().toString()))
                {
                    filter =
                        filter + " AND " + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
                }
            }
        }
        List<SearchMedAndInstruFormBean> resultList = docInsuredPatAgreeDao.searchMedAndInstru(filter, systemSearchFormBean.getBeid());
        return resultList;
    }
}
