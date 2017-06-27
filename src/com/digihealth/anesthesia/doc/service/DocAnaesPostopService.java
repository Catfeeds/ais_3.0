/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.doc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.doc.po.DocAnaesPostop;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;

/**
 * 
 * Title: CheckeventService.java Description:检验检查事件service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class DocAnaesPostopService extends BaseService {
	/**
	 * 
	 * @discription 根据手术ID获取术后随访
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesPostop searchAnaesPostopByRegOptId(String regOptId) {
		return docAnaesPostopDao.searchAnaesPostopByRegOptId(regOptId);
	}

	/**
	 * 
	 * @discription 通过ID查询术后随访
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:32
	 * @param id
	 * @return
	 */
	public DocAnaesPostop searchAnaesPostopById(String id) {
		return docAnaesPostopDao.searchAnaesPostopById(id);
	}

	/**
	 * 
	 * @discription 保存术后随访
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public ResponseValue updateAnaesPostop(DocAnaesPostop anaesPostop) {
		ResponseValue resp = new ResponseValue();
		if (anaesPostop == null) {
			resp.setResultCode("80000001");
			resp.setResultMessage("术后访视单不存在!");
			return resp;
		}
		anaesPostop.setProcessState("END");
		Controller controller = controllerDao.getControllerById(anaesPostop.getRegOptId()!=null?anaesPostop.getRegOptId():"");
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp;
		}
		DocAnaesPostop oldAnaesPostop = searchAnaesPostopById(anaesPostop
				.getAnaPostopId()!=null?anaesPostop
						.getAnaPostopId():"");
		if (anaesPostop == null) {
			resp.setResultCode("80000001");
			resp.setResultMessage("术后访视单不存在!");
			return resp;
		}
		docAnaesPostopDao.updateAnaesPostop(anaesPostop);
		BasUser user = UserUtils.getUserCache();
		LogUtils.saveOperateLog(anaesPostop.getRegOptId(), "4",
            "2", "术后随访单修改", JsonType.jsonType(anaesPostop),user, getBeid());
		resp.setResultCode("1");
		resp.setResultMessage("术后访视单修改成功!");
		return resp;

	}
	
	/**
	 * 查询未完成的术前访视单
	 * @param searchConditionFormBean
	 * @return
	 */
	public List<SearchMyOperationFormBean> searchNoEndAnaesPostop(SearchConditionFormBean searchConditionFormBean){
		searchConditionFormBean.setState("06");
		if(StringUtils.isEmpty(searchConditionFormBean.getSort())){
			searchConditionFormBean.setSort("operaDate");
		}
		if(StringUtils.isEmpty(searchConditionFormBean.getOrderBy())){
			searchConditionFormBean.setOrderBy("DESC");
		}
		
		BasUser user = basUserDao.get(searchConditionFormBean.getLoginName()!=null?searchConditionFormBean.getLoginName():"");
		
		return docAnaesPostopDao.searchNoEndAnaesPostop(user == null?"":user.getUserName(), searchConditionFormBean, getBeid());
	}
}
