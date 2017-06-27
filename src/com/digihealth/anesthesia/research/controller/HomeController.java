package com.digihealth.anesthesia.research.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.digihealth.anesthesia.research.formbean.IncompleteThingFormBean;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: HomeController.java    
     * Description: 首页里面的统计
     * @author chengwang       
     * @created 2015年12月16日 下午2:07:40
 */
@Controller
@RequestMapping(value = "/research")
public class HomeController extends BaseController{

	
	/**
	 * 
	     * @discription 查询待办事项
	     * @author chengwang       
	     * @created 2015年12月16日 下午2:08:04     
	     * @param searchConditionFormBean
	     * @return
	 */
	@RequestMapping(value = "/searchIncompleteThing")
	@ResponseBody
	@ApiOperation(value="待办事项统计",httpMethod="POST",notes="待办事项统计")
	public String searchIncompleteThing(@ApiParam(name="searchConditionFormBean", value ="查询参数对象") @RequestBody SearchConditionFormBean searchConditionFormBean) {
		logger.info("begin searchIncompleteThing");
		Map map = new HashMap();
		
		//我的排班
		IncompleteThingFormBean myOperation = new IncompleteThingFormBean();
		List<SearchMyOperationFormBean> myOperationList = basRegOptService.searchMyOperation(searchConditionFormBean);
		myOperation.setResultList(myOperationList);
		myOperation.setTotal(myOperationList.size());
		
		//今日手术
		IncompleteThingFormBean todayOperation = new IncompleteThingFormBean();
		List<SearchMyOperationFormBean> todayOperationList = basRegOptService.searchTodayOperation(searchConditionFormBean);
		todayOperation.setResultList(todayOperationList);
		todayOperation.setTotal(todayOperationList.size());
		
		//未术前访视
		/*IncompleteThingFormBean noEndPreVisit = new IncompleteThingFormBean();
		List<SearchMyOperationFormBean> noEndPreVisitList = preVisitService.searchNoEndPreVisit(searchConditionFormBean);
		noEndPreVisit.setResultList(noEndPreVisitList);
		noEndPreVisit.setTotal(noEndPreVisitList.size());*/
		
		Map noEndDocument = basRegOptService.searchDocumentUnFinish(searchConditionFormBean);
		IncompleteThingFormBean noEndPreVisit = new IncompleteThingFormBean();
		noEndPreVisit.setResultList((List<SearchMyOperationFormBean>)noEndDocument.get("documentNoFinishRegOpt"));
		noEndPreVisit.setTotal(Integer.parseInt(noEndDocument.get("total").toString()));
		
		//未术后随访
		/*IncompleteThingFormBean noEndAnaesPostop = new IncompleteThingFormBean();
		List<SearchMyOperationFormBean> noEndAnaesPostopList = anaesPostopService.searchNoEndAnaesPostop(searchConditionFormBean);
		noEndAnaesPostop.setResultList(noEndAnaesPostopList);
		noEndAnaesPostop.setTotal(noEndAnaesPostopList.size());*/
		
		//未排班
		IncompleteThingFormBean noScheduling = new IncompleteThingFormBean();
		List<SearchMyOperationFormBean> noSchedulingList = basRegOptService.searchNoScheduling(searchConditionFormBean);
		noScheduling.setResultList(noSchedulingList);
		noScheduling.setTotal(noSchedulingList.size());
		
		map.put("resultCode", "1");
		map.put("resultMessage", "待办事项查询成功!");
		map.put("myOperation", myOperation);
		map.put("todayOperation", todayOperation);
		map.put("noEndPreVisit", noEndPreVisit);
		/*map.put("noEndAnaesPostop", noEndAnaesPostop);*/
		map.put("noScheduling", noScheduling);
		logger.info("end searchIncompleteThing");
		return JsonType.jsonType(map);
	}
	
}
