package com.digihealth.anesthesia.tmp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.MedTempFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.evt.po.EvtInEvent;
import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;
import com.digihealth.anesthesia.tmp.po.TmpIoEvent;
import com.digihealth.anesthesia.tmp.po.TmpMedicine;
import com.digihealth.anesthesia.tmp.po.TmpMedicineEvent;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "TmpMedicineController", description = "用药模板处理类")
public class TmpMedicineController extends BaseController {

	@RequestMapping(value = "/updateMedTempForm")
	@ResponseBody
	@ApiOperation(value = "更新用药模板", httpMethod = "POST", notes = "更新用药模板")
	public String updateAnaesMethod(@ApiParam(name = "medTempFromBean", value = "用药模板查询对象") @RequestBody MedTempFormBean medTempFromBean) {
		logger.info("begin updateAnaesMethod");
		ResponseValue resp = new ResponseValue();
		tmpMedicineService.updateMedTemp(medTempFromBean);
		logger.info("end updateAnaesMethod");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/queryMedTempList")
	@ResponseBody
	@ApiOperation(value = "查询用药模版信息", httpMethod = "POST", notes = "查询用药模版信息")
	public String queryMedTempList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryMedTempList");
		ResponseValue resp = new ResponseValue();
		List<TmpMedicine> resultList = tmpMedicineService.queryMedTempList(systemSearchFormBean);
		int total = tmpMedicineService.queryMedTempListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryMedTempList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/queryMedTempById")
	@ResponseBody
	@ApiOperation(value = "查询单个用药模版信息", httpMethod = "POST", notes = "查询单个用药模版信息")
	public String queryMedTempById(@ApiParam(name = "medTempMap", value = "查询条件对象") @RequestBody Map medTempMap) {
		logger.info("begin queryMedTempById");
		ResponseValue resp = new ResponseValue();
		String type = medTempMap.get("type").toString();
		String medTempId = medTempMap.get("medTempId").toString();
		TmpMedicine resultMedTemp = tmpMedicineService.searchMedTempById(medTempId);
		List<TmpMedicineEvent> medTempEventList = new ArrayList<TmpMedicineEvent>();
		List<TmpMedicineEvent> zlTempEventList = new ArrayList<TmpMedicineEvent>();
		List<TmpIoEvent> ioTempEventList = new ArrayList<TmpIoEvent>();
		List<SearchOptOperMedicalevent> medEventList = new ArrayList<SearchOptOperMedicalevent>();
		List<SearchOptOperMedicalevent> zlEventList = new ArrayList<SearchOptOperMedicalevent>();
		List<SearchOptOperIoevent> ioEventList = new ArrayList<SearchOptOperIoevent>();
		if (resultMedTemp != null) {
			medTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(medTempId, "02");
			zlTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(medTempId, "01");
			ioTempEventList = tmpIoEventService.selectIoTempEventByMedTempId(medTempId);
			if (StringUtils.isEmpty(type)) {
				resp.put("medTempEventList", medTempEventList);
				resp.put("zlTempEventList", zlTempEventList);
				resp.put("ioTempEventList", ioTempEventList);
				resp.put("metTemp", resultMedTemp);
			} else if (type.equals("02")) {
				if (medTempEventList != null && medTempEventList.size() > 0) {
					for (int i = 0; i < medTempEventList.size(); i++) {
						SearchOptOperMedicalevent medEvent = new SearchOptOperMedicalevent();
						medEvent.setDiluentQuant(medTempEventList.get(i).getDiluentQuant());
						medEvent.setDosage(medTempEventList.get(i).getDosage());
						medEvent.setEnded(medTempEventList.get(i).getEnded());
						medEvent.setFirm(medTempEventList.get(i).getFirm());
						medEvent.setFlow(medTempEventList.get(i).getFlow());
						medEvent.setFlowUnit(medTempEventList.get(i).getFlowUnit());
						medEvent.setIsContinued(medTempEventList.get(i).getIsContinued());
						medEvent.setMedicineId(medTempEventList.get(i).getMedicineId());
						medEvent.setMedTakeWayId(medTempEventList.get(i).getMedTakeWayId());
						medEvent.setMedTakeWayName(medTempEventList.get(i).getMedTakeWayName());
						medEvent.setMedEventId(medTempEventList.get(i).getMedEventId() + "");
						medEvent.setName(medTempEventList.get(i).getName());
						medEvent.setOccurHour(medTempEventList.get(i).getOccurHour());
						medEvent.setPriceId(medTempEventList.get(i).getPriceId());
						medEvent.setReason(medTempEventList.get(i).getReason());
						medEvent.setSpec(medTempEventList.get(i).getSpec());
						medEvent.setThickness(medTempEventList.get(i).getThickness());
						medEvent.setThicknessUnit(medTempEventList.get(i).getThicknessUnit());
						medEvent.setStartTime(DateUtils.getDateStringTime());
						long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
						Date date = new Date(currentTime);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						medEvent.setEndTime(df.format(date));
						medEvent.setDurable(medTempEventList.get(i).getDurable());
						medEventList.add(medEvent);
					}
				}
				resp.put("resultList", medEventList);
			} else if (type.equals("01")) {
				if (zlTempEventList != null && zlTempEventList.size() > 0) {
					for (int i = 0; i < zlTempEventList.size(); i++) {
						SearchOptOperMedicalevent medEvent = new SearchOptOperMedicalevent();
						medEvent.setDiluentQuant(zlTempEventList.get(i).getDiluentQuant());
						medEvent.setDosage(zlTempEventList.get(i).getDosage());
						medEvent.setEnded(zlTempEventList.get(i).getEnded());
						medEvent.setFirm(zlTempEventList.get(i).getFirm());
						medEvent.setFlow(zlTempEventList.get(i).getFlow());
						medEvent.setFlowUnit(zlTempEventList.get(i).getFlowUnit());
						medEvent.setIsContinued(zlTempEventList.get(i).getIsContinued());
						medEvent.setMedicineId(zlTempEventList.get(i).getMedicineId());
						medEvent.setMedTakeWayId(zlTempEventList.get(i).getMedTakeWayId());
						medEvent.setMedTakeWayName(zlTempEventList.get(i).getMedTakeWayName());
						medEvent.setName(zlTempEventList.get(i).getName());
						medEvent.setOccurHour(zlTempEventList.get(i).getOccurHour());
						medEvent.setPriceId(zlTempEventList.get(i).getPriceId());
						medEvent.setReason(zlTempEventList.get(i).getReason());
						medEvent.setMedEventId(zlTempEventList.get(i).getMedEventId() + "");
						medEvent.setSpec(zlTempEventList.get(i).getSpec());
						medEvent.setThickness(zlTempEventList.get(i).getThickness());
						medEvent.setThicknessUnit(zlTempEventList.get(i).getThicknessUnit());
						medEvent.setStartTime(DateUtils.getDateStringTime());
						long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
						Date date = new Date(currentTime);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						medEvent.setEndTime(df.format(date));
						medEvent.setDurable(zlTempEventList.get(i).getDurable());
						zlEventList.add(medEvent);
					}
				}
				resp.put("resultList", zlEventList);
			} else if (type.equals("I")) {
				if (ioTempEventList != null && ioTempEventList.size() > 0) {
					for (int i = 0; i < ioTempEventList.size(); i++) {
						SearchOptOperIoevent medEvent = new SearchOptOperIoevent();
						medEvent.setDosageAmount(ioTempEventList.get(i).getDosageAmount());
						medEvent.setIoDefId(ioTempEventList.get(i).getIoDefId());
						medEvent.setIsCharged(ioTempEventList.get(i).getIsCharged() + "");
						medEvent.setName(ioTempEventList.get(i).getName());
						medEvent.setPassage(ioTempEventList.get(i).getPassage());
						medEvent.setPriceId(Integer.parseInt(ioTempEventList.get(i).getPriceId()));
						medEvent.setInEventId(ioTempEventList.get(i).getIoeventId() + "");
						medEvent.setSpec(ioTempEventList.get(i).getSpec());
						medEvent.setStartTime(DateUtils.getDateStringTime());
						long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
						Date date = new Date(currentTime);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						medEvent.setEndTime(df.format(date));
						ioEventList.add(medEvent);
					}
				}
				resp.put("resultList", ioEventList);
			}

		}
		resp.put("resultCode", "1");
		resp.put("resultMessage", "查询单个用药模版信息成功");

		logger.info("end queryMedTempById");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/deleteMedTempById")
	@ResponseBody
	@ApiOperation(value = "删除用药模版信息", httpMethod = "POST", notes = "删除用药模版信息")
	public String deleteMedTempById(@ApiParam(name = "medTemp", value = "用药模版对象") @RequestBody TmpMedicine medTemp) {
		logger.info("begin deleteMedTempById");
		ResponseValue resp = new ResponseValue();
		tmpMedicineService.deleteMedTempById(medTemp);
		logger.info("end deleteMedTempById");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/operMedTempList")
	@ResponseBody
	@ApiOperation(value = "根据条件查询用药模版信息", httpMethod = "POST", notes = "根据条件查询用药模版信息")
	public String queryMedTempList(@ApiParam(name = "map", value = "查询条件对象") @RequestBody Map map) {
		logger.info("begin queryMedTempList");
		ResponseValue resp = new ResponseValue();
		SystemSearchFormBean systemSearchFormBean = new SystemSearchFormBean();
		String type = map.get("type").toString();
		List<TmpMedicine> resultList = tmpMedicineService.queryMedTempList(systemSearchFormBean);
		int total = tmpMedicineService.queryMedTempListTotal(systemSearchFormBean);

		List<TmpMedicine> resultTempList = new ArrayList<TmpMedicine>();
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				if (type.equals("02")) {
					List<TmpMedicineEvent> medTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(resultList.get(i).getMedTempId(), "02");
					if (medTempEventList != null && medTempEventList.size() > 0) {
						resultTempList.add(resultList.get(i));
					}
				}
				if (type.equals("01")) {
					List<TmpMedicineEvent> medTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(resultList.get(i).getMedTempId(), "01");
					if (medTempEventList != null && medTempEventList.size() > 0) {
						resultTempList.add(resultList.get(i));
					}
				}
				if (type.equals("I")) {
					List<TmpIoEvent> ioTempEventList = tmpIoEventService.selectIoTempEventByMedTempId(resultList.get(i).getMedTempId());
					if (ioTempEventList != null && ioTempEventList.size() > 0) {
						resultTempList.add(resultList.get(i));
					}
				}
			}
		}

		resp.put("resultList", resultTempList);
		resp.put("total", total);
		logger.info("end queryMedTempList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/insertTemp")
	@ResponseBody
	@ApiOperation(value = "添加模版信息", httpMethod = "POST", notes = "添加模版信息")
	public String insertTemp(@ApiParam(name = "map", value = "条件对象") @RequestBody Map map) {
		ResponseValue req = new ResponseValue();
		Integer type = 0;
		if (map.get("type") != null) {
			type = Integer.parseInt(map.get("type").toString());
		}
		String[] ids = map.get("ids").toString().split(",");
		String docId = map.get("docId").toString();
		String flag = map.get("flag").toString();
		if (type.equals("02") || type.equals("01")) {
			if (ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					TmpMedicineEvent medTempEvent = tmpMedicineEventService.queryMedTempEvemtById(ids[i]);
					EvtMedicalEvent medicalevent = new EvtMedicalEvent();
					medicalevent.setCreateUser("");
					medicalevent.setDiluentQuant(medTempEvent.getDiluentQuant());
					medicalevent.setDocId(docId);
					medicalevent.setDosage(medTempEvent.getDosage());
					medicalevent.setEnded(medTempEvent.getEnded());
					medicalevent.setStartTime(new Date());
					long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
					Date date = new Date(currentTime);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					medicalevent.setEndTime(date);
					medicalevent.setDurable(Integer.parseInt(medTempEvent.getDurable()));
					medicalevent.setFlow(medTempEvent.getFlow());
					medicalevent.setFlowUnit(medTempEvent.getFlowUnit());
					medicalevent.setIsCharged(medTempEvent.getIsCharged() + "");
					medicalevent.setIsContinued(medTempEvent.getIsContinued());
					medicalevent.setMedicineId(medTempEvent.getMedicineId());
					medicalevent.setMedTakeWayId(medTempEvent.getMedTakeWayId());
					medicalevent.setOccurHour(medTempEvent.getOccurHour());
					medicalevent.setPriceId(medTempEvent.getPriceId());
					medicalevent.setReason(medTempEvent.getReason());
					medicalevent.setShowOption(medTempEvent.getShowOption());
					medicalevent.setThickness(medTempEvent.getThickness());
					medicalevent.setThicknessUnit(medTempEvent.getThicknessUnit());
					medicalevent.setType(type);
					evtMedicaleventService.saveMedicalevent(medicalevent, req);
				}
			}

		} else if (type.equals("I")) {
			if (ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					TmpIoEvent ioTempEvent = tmpIoEventService.queryIoTempEvemtById(ids[i]);
					EvtInEvent ioevent = new EvtInEvent();
					ioevent.setCreateUser("");
					ioevent.setDocId(docId);
					ioevent.setDosageAmount(ioTempEvent.getDosageAmount());
					ioevent.setStartTime(new Date());
					long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
					Date date = new Date(currentTime);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					ioevent.setEndTime(new Date());
					// ioevent.setIoDefId(ioTempEvent.getIoDefId());
					// ioevent.setIsCharged(ioTempEvent.getIsCharged());
					// ioevent.setPassage(ioTempEvent.getPassage());
					// ioevent.setPriceId(ioTempEvent.getPriceId());
					// if(StringUtils.isNotBlank(flag)){
					// ioevent.setFlag(Integer.valueOf(flag));
					// }
					evtInEventService.saveIoevent(ioevent, req);
				}
			}
		}

		return req.getJsonStr();
	}

	@RequestMapping(value = "/useTemp")
	@ResponseBody
	@ApiOperation(value = "查询用药模版信息", httpMethod = "POST", notes = "查询用药模版信息")
	public String useTemp(@ApiParam(name = "map", value = "查询条件对象") @RequestBody Map map) {
		ResponseValue req = new ResponseValue();
		String type = map.get("type").toString();
		String medTempId = map.get("medTempId").toString();

		List<SearchOptOperMedicalevent> medEventList = new ArrayList<SearchOptOperMedicalevent>();
		List<SearchOptOperMedicalevent> zlEventList = new ArrayList<SearchOptOperMedicalevent>();
		List<SearchOptOperIoevent> ioEventList = new ArrayList<SearchOptOperIoevent>();

		List<TmpMedicineEvent> medTempEventList = new ArrayList<TmpMedicineEvent>();
		List<TmpMedicineEvent> zlTempEventList = new ArrayList<TmpMedicineEvent>();
		List<TmpIoEvent> ioTempEventList = new ArrayList<TmpIoEvent>();
		// 02表示麻醉药，01表示查治疗药，I表示入量
		if (type.equals("02")) {
			medTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(medTempId, "02");
			if (medTempEventList != null && medTempEventList.size() > 0) {
				for (int i = 0; i < medTempEventList.size(); i++) {
					SearchOptOperMedicalevent medEvent = new SearchOptOperMedicalevent();
					medEvent.setDiluentQuant(medTempEventList.get(i).getDiluentQuant());
					medEvent.setDosage(medTempEventList.get(i).getDosage());
					medEvent.setEnded(medTempEventList.get(i).getEnded());
					medEvent.setFirm(medTempEventList.get(i).getFirm());
					medEvent.setFlow(medTempEventList.get(i).getFlow());
					medEvent.setFlowUnit(medTempEventList.get(i).getFlowUnit());
					medEvent.setIsContinued(medTempEventList.get(i).getIsContinued());
					medEvent.setMedicineId(medTempEventList.get(i).getMedicineId());
					medEvent.setMedTakeWayId(medTempEventList.get(i).getMedTakeWayId());
					medEvent.setMedTakeWayName(medTempEventList.get(i).getMedTakeWayName());
					medEvent.setName(medTempEventList.get(i).getName());
					medEvent.setOccurHour(medTempEventList.get(i).getOccurHour());
					medEvent.setPriceId(medTempEventList.get(i).getPriceId());
					medEvent.setReason(medTempEventList.get(i).getReason());
					medEvent.setSpec(medTempEventList.get(i).getSpec());
					medEvent.setThickness(medTempEventList.get(i).getThickness());
					medEvent.setThicknessUnit(medTempEventList.get(i).getThicknessUnit());
					medEvent.setStartTime(DateUtils.getDateTime());
					long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
					Date date = new Date(currentTime);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					medEvent.setEndTime(df.format(date));
					medEvent.setDurable(medTempEventList.get(i).getDurable());
					medEventList.add(medEvent);
				}
			}
			req.put("resultList", medEventList);
			return req.getJsonStr();
		} else if (type.equals("01")) {
			zlTempEventList = tmpMedicineEventService.selectMedTempEventByMedTempId(medTempId, "01");
			if (zlTempEventList != null && zlTempEventList.size() > 0) {
				for (int i = 0; i < zlTempEventList.size(); i++) {
					SearchOptOperMedicalevent medEvent = new SearchOptOperMedicalevent();
					medEvent.setDiluentQuant(zlTempEventList.get(i).getDiluentQuant());
					medEvent.setDosage(zlTempEventList.get(i).getDosage());
					medEvent.setEnded(zlTempEventList.get(i).getEnded());
					medEvent.setFirm(zlTempEventList.get(i).getFirm());
					medEvent.setFlow(zlTempEventList.get(i).getFlow());
					medEvent.setFlowUnit(zlTempEventList.get(i).getFlowUnit());
					medEvent.setIsContinued(zlTempEventList.get(i).getIsContinued());
					medEvent.setMedicineId(zlTempEventList.get(i).getMedicineId());
					medEvent.setMedTakeWayId(zlTempEventList.get(i).getMedTakeWayId());
					medEvent.setMedTakeWayName(zlTempEventList.get(i).getMedTakeWayName());
					medEvent.setName(zlTempEventList.get(i).getName());
					medEvent.setOccurHour(zlTempEventList.get(i).getOccurHour());
					medEvent.setPriceId(zlTempEventList.get(i).getPriceId());
					medEvent.setReason(zlTempEventList.get(i).getReason());
					medEvent.setSpec(zlTempEventList.get(i).getSpec());
					medEvent.setThickness(zlTempEventList.get(i).getThickness());
					medEvent.setThicknessUnit(zlTempEventList.get(i).getThicknessUnit());
					medEvent.setStartTime(DateUtils.getDateTime());
					long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
					Date date = new Date(currentTime);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					medEvent.setEndTime(df.format(date));
					medEvent.setDurable(zlTempEventList.get(i).getDurable());
					zlEventList.add(medEvent);
				}
			}
			req.put("resultList", zlEventList);
			return req.getJsonStr();
		} else if (type.equals("I")) {
			ioTempEventList = tmpIoEventService.selectIoTempEventByMedTempId(medTempId);
			if (ioTempEventList != null && ioTempEventList.size() > 0) {
				for (int i = 0; i < ioTempEventList.size(); i++) {
					SearchOptOperIoevent medEvent = new SearchOptOperIoevent();
					medEvent.setDosageAmount(ioTempEventList.get(i).getDosageAmount());
					medEvent.setIoDefId(ioTempEventList.get(i).getIoDefId());
					medEvent.setIsCharged(ioTempEventList.get(i).getIsCharged() + "");
					medEvent.setName(ioTempEventList.get(i).getName());
					medEvent.setPassage(ioTempEventList.get(i).getPassage());
					medEvent.setPriceId(Integer.parseInt(ioTempEventList.get(i).getPriceId()));
					medEvent.setSpec(ioTempEventList.get(i).getSpec());
					medEvent.setStartTime(DateUtils.getDateTime());
					long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
					Date date = new Date(currentTime);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					medEvent.setEndTime(df.format(date));
					ioEventList.add(medEvent);
				}
			}
			req.put("resultList", ioEventList);
			return req.getJsonStr();
		}
		return null;
	}

}
