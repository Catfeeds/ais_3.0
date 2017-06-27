package com.digihealth.anesthesia.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocPrePostVisit;
import com.digihealth.anesthesia.doc.po.DocPrePostVisitItem;

@Service
public class DocPrePostVisitService extends BaseService {
	/**
	 * 查询术前术后访问单 <功能详细描述>
	 * 
	 * @param regOptId
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public DocPrePostVisit searchPrePostVisit(String regOptId) {
		return docPrePostVisitDao.selectByRegOptId(regOptId);
	}

	/**
	 * 更新术前术后访问单 <功能详细描述>
	 * 
	 * @param prePostVisitFormBean
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public void updatePrePostVisit(DocPrePostVisit prePostVisit) {
		docPrePostVisitDao.updateByPrimaryKeySelective(prePostVisit);
	}

	/**
	 * 保存更新术前术后访问单中术中条目 <功能详细描述>
	 * 
	 * @param prePostVisitItem
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public void updatePrePostVisitItem(DocPrePostVisitItem prePostVisitItem) {
		if (null != prePostVisitItem.getId()) {
			docPrePostVisitItemDao
					.updateByPrimaryKeySelective(prePostVisitItem);
		} else {
			prePostVisitItem.setId(GenerateSequenceUtil.generateSequenceNo());
			docPrePostVisitItemDao.insertSelective(prePostVisitItem);
		}
	}

	/**
	 * 删除术前术后访问单中术中条目 <功能详细描述>
	 * 
	 * @param id
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public void delPrePostVisitItem(String id) {
		docPrePostVisitItemDao.deleteByPrimaryKey(id);
	}

	public List<DocPrePostVisitItem> searchItemsByPrePostId(String prePostId) {
		return docPrePostVisitItemDao.selectByPrePostId(prePostId);
	}
}
