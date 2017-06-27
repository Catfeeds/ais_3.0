package com.digihealth.anesthesia.doc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocPreOperVisit;

@Service
public class DocPreOperVisitService extends BaseService {
	/**
	 * 查询麻醉术前访视单 <功能详细描述>
	 * 
	 * @param regOptId
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public DocPreOperVisit searchPreOperVisit(String regOptId) {
		return docPreOperVisitDao.selectByRegOptId(regOptId);
	}

	/**
	 * 更新麻醉术前访视单 <功能详细描述>
	 * 
	 * @param preOperVisit
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@Transactional
	public void updatePreOperVisit(DocPreOperVisit preOperVisit) {
		docPreOperVisitDao.updateByPrimaryKeySelective(preOperVisit);
	}
}
