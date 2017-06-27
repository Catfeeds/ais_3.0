package com.digihealth.anesthesia.evt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.AnaesEventFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtCheckEvent;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;
import com.digihealth.anesthesia.evt.po.EvtOtherEvent;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.digihealth.anesthesia.evt.po.EvtShiftChange;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
@Api(value = "EvtAnaesEventController", description = "麻醉事件处理类")
public class EvtAnaesEventController extends BaseController {

	@RequestMapping(value = "/searchAnaeseventList")
	@ResponseBody
	@ApiOperation(value = "查询所有的麻醉事件", httpMethod = "POST", notes = "查询所有的麻醉事件")
	public String searchAnaeseventList(@ApiParam(name = "searchBean", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchAnaeseventList");
		ResponseValue resp = new ResponseValue();
		List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchAnaeseventList");
		return resp.getJsonStr();
	}

    @RequestMapping(value = "/searchAnaesEventPacuList")
    @ResponseBody
	@ApiOperation(value = "查询所有的PACU麻醉事件", httpMethod = "POST", notes = "查询所有的PACU麻醉事件")
    public String searchAnaesEventPacuList(@ApiParam(name = "searchBean", value = "查询参数") @RequestBody SearchFormBean searchBean) {
    	logger.info("begin searchAnaesEventPacuList");
		ResponseValue resp = new ResponseValue();
		List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaesEventPacuList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchAnaesEventPacuList");
		return resp.getJsonStr();
    }

    @RequestMapping(value = "/saveAnaeseventPacu")
    @ResponseBody
	@ApiOperation(value = "保存PACU麻醉事件", httpMethod = "POST", notes = "保存PACU麻醉事件")
    public String saveAnaeseventPacu(@ApiParam(name = "anaesEventPacu", value = "保存参数") @RequestBody EvtAnaesEvent anaesEventPacu) {
    	logger.info("begin saveAnaeseventPacu");
		ResponseValue resp = new ResponseValue();
		evtAnaesEventService.saveAnaeseventPacu(anaesEventPacu, resp);
		logger.info("end saveAnaeseventPacu");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/deleteAnaeseventPacu")
    @ResponseBody
	@ApiOperation(value = "删除PACU麻醉事件", httpMethod = "POST", notes = "删除PACU麻醉事件")
    public String deleteAnaeseventPacu(@ApiParam(name = "anaesEventPacu", value = "删除参数") @RequestBody EvtAnaesEvent anaesEventPacu) {
    	logger.info("begin deleteAnaeseventPacu");
		ResponseValue resp = new ResponseValue();
		evtAnaesEventService.deleteAnaeseventPacu(anaesEventPacu);
		logger.info("end deleteAnaeseventPacu");
        return resp.getJsonStr();
    }
    
	@RequestMapping(value = "/searchAnaesEventType")
	@ResponseBody
	@ApiOperation(value = "查询麻醉事件", httpMethod = "POST", notes = "查询麻醉事件")
	public String searchAnaesEventType(@ApiParam(name = "searchBean", value = "参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin searchAnaesEventType");
		ResponseValue resp = new ResponseValue();
		List<AnaesEventFormBean> resultList = basSysCodeService.searchAnaesEvent(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", basSysCodeService.searchAnaesEventTotal(systemSearchFormBean));
		logger.info("end searchAnaesEventType");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveAnaesevent")
	@ResponseBody
	@ApiOperation(value = "保存麻醉事件", httpMethod = "POST", notes = "保存麻醉事件")
	public String saveAnaesevent(@ApiParam(name = "anaesevent", value = "麻醉事件对象") @RequestBody EvtAnaesEvent anaesevent) {
		logger.info("begin saveAnaesevent");
		ResponseValue resp = new ResponseValue();
		if (anaesevent != null) {
			evtAnaesEventService.saveAnaesevent(anaesevent, resp);
			resp.put("anaEventId", anaesevent.getAnaEventId());
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(anaesevent.getDocId());
			List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
			resp.put("resultList", resultList);
		} else {
			resp.setResultCode("70000000");
			resp.setResultMessage(Global.getRetMsg(resp.getResultCode()));
		}
		logger.info("end saveAnaesevent");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/deleteByCodeAndDocId")
	@ResponseBody
	@ApiOperation(value = "删除麻醉事件根据code和文书id", httpMethod = "POST", notes = "删除麻醉事件根据code和文书id")
	public String deleteByCodeAndDocId(@ApiParam(name = "anaesevent", value = "麻醉事件对象") @RequestBody EvtAnaesEvent anaesevent) {
		logger.info("begin deleteByCodeAndDocId");
		ResponseValue resp = new ResponseValue();
		evtAnaesEventService.deleteByCodeAndDocId(anaesevent, resp);
		SearchFormBean searchBean = new SearchFormBean();
		searchBean.setDocId(anaesevent.getDocId());
		List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end deleteByCodeAndDocId");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/searchAllEventList")
	@ResponseBody
	@ApiOperation(value = "查询所有的事件", httpMethod = "POST", notes = "查询所有的事件")
	public String searchAllEventList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchAllEventList");
		ResponseValue resp = new ResponseValue();
		// 麻醉事件
		searchBean.setCode(null);
		List<EvtAnaesEvent> anaeseventList = evtAnaesEventService.searchAnaeseventList(searchBean);
		resp.put("anaesevent", anaeseventList);

		 //		 检测事件
		 List<EvtCheckEvent> checkeventList = evtCheckEventService.serarchCheckevent(searchBean);
		 resp.put("checkeventList", checkeventList);

		// 其他事件
		List<EvtOtherEvent> othereventList = evtOtherEventService.searchOthereventList(searchBean);
		resp.put("otherevent", othereventList);

		// 呼吸事件
		List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchCtlBreathList(searchBean);
		resp.put("ctlBreath", ctlBreathList);

		// 抢救事件
		List<EvtRescueevent> rescueeventList = evtRescueeventService.searchRescueeventList(searchBean);
		if (rescueeventList != null && rescueeventList.size() > 0) {
			for (int i = 0; i < rescueeventList.size(); i++) {
//				String date = DateUtils.strToStr(DateUtils.DateToString(rescueeventList.get(i).getStartTime()), "yyyy-MM-dd HH:mm:ss", "HH:mm");
				rescueeventList.get(i).setStartTime(rescueeventList.get(i).getStartTime());
			}
		}
		resp.put("rescueevent", rescueeventList);

		// 交换班事件
		List<EvtShiftChange> shiftChangeList = evtShiftChangeService.searchShiftChangeList(searchBean);
//		if (shiftChangeList != null && shiftChangeList.size() > 0) {
//			for (int i = 0; i < shiftChangeList.size(); i++) {
//				String date = DateUtils.strToStr(shiftChangeList.get(i).getShiftChangeTime(), "yyyy-MM-dd HH:mm:ss", "HH:mm");
//				shiftChangeList.get(i).setShiftChangeTime(date);
//			}
//		}
		resp.put("shiftChange", shiftChangeList);

		// 用药事件
		searchBean.setType("01");
		List<RegOptOperMedicaleventFormBean> list = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);
		List<RegOptOperMedicaleventFormBean> medicaleventList = new ArrayList<RegOptOperMedicaleventFormBean>();
		if (list != null && list.size() > 0 && null != searchBean.getMedEventNum()) {
			for (int i = searchBean.getMedEventNum(); i < list.size(); i++) {
				medicaleventList.add(list.get(i));
			}
		}
		resp.put("medicalevent", medicaleventList);

		// 输液事件
		searchBean.setSubType("1");
		List<RegOptOperIoeventFormBean> infusionAllList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);
		List<RegOptOperIoeventFormBean> infusionList = new ArrayList<RegOptOperIoeventFormBean>();
		if (null != infusionAllList && infusionAllList.size() > 0 && null != searchBean.getInfusionNum()) {
			for (int i = searchBean.getInfusionNum(); i < infusionAllList.size(); i++) {
				infusionList.add(infusionAllList.get(i));
			}
		}
		resp.put("infusionList", infusionList);

		// 输血事件
		searchBean.setSubType("2");
		List<RegOptOperIoeventFormBean> bloodAllList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);
		List<RegOptOperIoeventFormBean> bloodList = new ArrayList<RegOptOperIoeventFormBean>();
		if (null != bloodAllList && bloodAllList.size() > 0 && null != searchBean.getBloodNum()) {
			for (int i = searchBean.getBloodNum(); i < bloodAllList.size(); i++) {
				bloodList.add(bloodAllList.get(i));
			}
		}
		resp.put("bloodList", bloodList);

		// 出量事件
		List<RegOptOperEgressFormBean> egressAllList = evtEgressService.searchEgressGroupByDefIdList(searchBean);
		List<RegOptOperEgressFormBean> egressList = new ArrayList<RegOptOperEgressFormBean>();
		if (null != egressAllList && egressAllList.size() > 0 && null != searchBean.getEgressNum()) {
			for (int i = searchBean.getEgressNum(); i < egressAllList.size(); i++) {
				egressList.add(egressAllList.get(i));
			}
		}
		resp.put("egress", egressList);

		logger.info("end searchAllEventList");
		return resp.getJsonStr();
	}

	/**
	 * 查询麻醉时长和手术时长 <功能详细描述>
	 * 
	 * @param searchBean
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "/searchTimesByCode")
	@ResponseBody
	@ApiOperation(value = "查询麻醉时长和手术时长", httpMethod = "POST", notes = "查询麻醉时长和手术时长")
	public String searchTimesByCode(@ApiParam(name = "searchBean", value = "系统查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchTimesByCode");
		ResponseValue resp = new ResponseValue();
		resp = evtAnaesEventService.searchTimesByCode(searchBean);
		resp.put("resultMessage", "查询手术时长和麻醉时长成功!");
		logger.info("end searchTimesByCode");
		return resp.getJsonStr();
	}
}
