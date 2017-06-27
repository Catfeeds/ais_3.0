/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;

/**
 * Title: SafeCheckService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocSafeCheckService extends BaseService {

	/**
	 * 
	 * @discription 根据手术ID获取手术核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocSafeCheck searchSafeCheckByRegOptId(String regOptId) {
		return docSafeCheckDao.searchSafeCheckByRegOptId(regOptId, getBeid());
	}

	/**
	 * 
	 * @discription 通过ID查询手术核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocSafeCheck searchSafeCheckById(String id) {
		return docSafeCheckDao.searchSafeCheckById(id);
	}

	/**
	 * 
	 * @discription 保存手术核查
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public String updateSafeCheck(DocSafeCheck safeCheck) {
		Controller controller = controllerDao.getControllerById(safeCheck
				.getRegOptId());
		DocSafeCheck oldSafeCheck = searchSafeCheckById(safeCheck
				.getSafCheckId());
		// if (controller.getState().equals(oldSafeCheck.getState())) {
		docSafeCheckDao.updateSafeCheck(safeCheck);
		// } else {
		// // oldSafeCheck.setFlag("0");
		// docSafeCheckDao.updateSafeCheck(oldSafeCheck);
		// SafeCheck newSafeCheck = new SafeCheck();
		// BeanHelper.copyProperties(safeCheck, newSafeCheck);
		// newSafeCheck.setState(controller.getState());
		// newSafeCheck.setFlag("1");
		// safeCheckDao.insert(newSafeCheck);
		// }
		return "true";
	}

}
