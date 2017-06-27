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
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.doc.po.DocBadEvent;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * Title: PreVisitService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocBadEventService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取不良事件
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocBadEvent searchBadEventByRegOptId(String regOptId) {
		return docBadEventDao.searchBadEventByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询不良事件
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocBadEvent searchBadEventById(String id) {
		return docBadEventDao.searchBadEventById(id);
	}

	/**
	 * 
	 * @discription 保存不良事件
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateBadEvent(DocBadEvent badEvent) {
		badEvent.setProcessState("END");
		ResponseValue resp = new ResponseValue();
		Controller controller = controllerDao.getControllerById(badEvent
				.getRegOptId() != null ? badEvent.getRegOptId() : "");
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocBadEvent oldBadEvent = searchBadEventById(badEvent.getBadEventId());
		//if (controller.getState().equals(oldBadEvent.getState())) {
			docBadEventDao.updateBadEvent(badEvent);
		/*} else {
			oldBadEvent.setFlag("0");
			badEventDao.updateBadEvent(oldBadEvent);
			BadEvent newBadEvent = new BadEvent();
			BeanHelper.copyProperties(badEvent, newBadEvent);
			newBadEvent.setState(controller.getState());
			newBadEvent.setFlag("1");
			badEventDao.insert(newBadEvent);
		}*/
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(badEvent.getRegOptId(), "4",
            "2", "不良事件单修改", JsonType.jsonType(badEvent),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("不良事件修改成功!");
		return resp;
	}

}
