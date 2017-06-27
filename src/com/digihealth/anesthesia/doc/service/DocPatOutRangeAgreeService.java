package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeAgree;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeItem;
@Service
public class DocPatOutRangeAgreeService extends BaseService
{
    /** 
     * 查询医疗保险病人超范围用药同意书
     * <功能详细描述>
     * @param regOptId
     * @return
     * @see [类、类#方法、类#成员]
     */
    public DocPatOutRangeAgree searchPatOutRangeAgree(String regOptId)
    {
        return docPatOutRangeAgreeDao.selectByRegOptId(regOptId);
    }
    
    /** 
     * 更新医疗保险病人超范围用药同意书
     * <功能详细描述>
     * @param pora
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Transactional
    public void updatePatOutRangeAgree(DocPatOutRangeAgree pora)
    {
    	docPatOutRangeAgreeDao.updateByPrimaryKeySelective(pora);
    }
    
    /** 
     * 更新保存医疗保险病人超范围用药同意书条目
     * <功能详细描述>
     * @param pori
     * @return
     * @see [类、类#方法、类#成员]
     */
	@Transactional
	public void updatePatOutRangeItem(DocPatOutRangeItem pori) {
		if (null != pori.getId()) {
			docPatOutRangeItemDao.updateByPrimaryKeySelective(pori);
		} else {
			pori.setId(GenerateSequenceUtil.generateSequenceNo());
			docPatOutRangeItemDao.insertSelective(pori);
		}
	}
    
    /** 
     * 删除医疗保险病人超范围用药同意书条目
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
	@Transactional
	public void delPatOutRangeItem(String id) {
		docPatOutRangeItemDao.deleteByPrimaryKey(id);
	}

	public List<DocPatOutRangeItem> searchByPatOutRangeId(String id) {
		return docPatOutRangeItemDao.selectByPatOutRangeId(id);
	}
}
