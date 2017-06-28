package com.digihealth.anesthesia.operProceed.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.basedata.po.BasOperroom;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.basedata.po.Device;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.evt.formbean.EvtAnaesMethodFormBean;
import com.digihealth.anesthesia.evt.formbean.OperBodyFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOperaPatrolRecordFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByRoomIdAndOperDateAndStateFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.digihealth.anesthesia.evt.service.EvtAnaesEventService;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.operProceed.core.MyConstants;
import com.digihealth.anesthesia.operProceed.datasync.MessageProcess;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.operProceed.formbean.CtlBreathDateFormBean;
import com.digihealth.anesthesia.operProceed.formbean.DeviceConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.EndOperationFormBean;
import com.digihealth.anesthesia.operProceed.formbean.EnterRoomFormBean;
import com.digihealth.anesthesia.operProceed.formbean.FirstSpotFormBean;
import com.digihealth.anesthesia.operProceed.formbean.IntervalDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.LegendData;
import com.digihealth.anesthesia.operProceed.formbean.MonDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorData;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDataPage;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDisplayChangeFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorFreqFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorPupilFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RealTimeDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RegOptFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RescueeventFormBean;
import com.digihealth.anesthesia.operProceed.formbean.SeriesData;
import com.digihealth.anesthesia.operProceed.formbean.SeriesDataObj;
import com.digihealth.anesthesia.operProceed.formbean.SuspendFormBean;
import com.digihealth.anesthesia.operProceed.formbean.XAxisData1;
import com.digihealth.anesthesia.operProceed.formbean.XAxisDataBean;
import com.digihealth.anesthesia.operProceed.formbean.YAxisData;
import com.digihealth.anesthesia.operProceed.po.BasAnaesMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplay;
import com.digihealth.anesthesia.operProceed.po.BasMonitorFreqChange;
import com.digihealth.anesthesia.operProceed.po.BasMonitorPupil;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@org.springframework.stereotype.Controller
@RequestMapping("/operCtl")
@Api(value = "MyObserveDataController", description = "术中总控处理类")
public class MyObserveDataController extends BaseController {

	public static int SYMBOL_OBSDATA = 12;
	public static int SYMBOL_PRINTDATA = 11;

	public static String O2_EVENT_ID = "91001";

	public static String RESP_EVENT_ID = "100001";

	public static String NP_TEMP_POSITION_RT = "30008"; // 鼻咽温实时数据位置体温
	public static String NP_TEMP_POSITION_LINE = "31008"; // 鼻咽温图形位置体温

	public static String TEMP_POSITION_RT = "30016"; // 体温实时数据位置体温
	public static String TEMP_POSITION_LINE = "31016"; // 体温图形位置体温

	public static String RE_TEMP_POSITION_RT = "30010"; // 直肠温实时数据位置体温
	public static String RE_TEMP_POSITION_LINE = "31010"; // 直肠温图形位置体温

	public static String CVP_MEAN_POSITION_RT = "30011"; // 中心静脉压 实时数据位置
	public static String CVP_MEAN_POSITION_LINE = "31011"; // 中心静脉压 图形位置

	/**
	 * 新增点,无需发送采集数据模块，新增显示表，b_observe_data表需要先根据time+docId+observeId查询是否有值，如果有记录
	 * ，则修改，无记录，则新增；
	 * 
	 * @return
	 */
	@RequestMapping("/addobsdat")
	@ResponseBody
	@ApiOperation(value = "添加点", httpMethod = "POST", notes = "添加点")
	public String addobsdat(@ApiParam(name = "params", value = "参数") @RequestBody BasMonitorDisplay monitorDisp) {
		logger.info("----------------start addobsdat------------------------");
		ResponseValue res = new ResponseValue();
		basMonitorDisplayService.addobsdat(monitorDisp);
		res.setResultCode("1");
		res.setResultMessage("操作成功");
		logger.info("------------------end addobsdat------------------------");
		return res.getJsonStr();
	}

	/**
	 * 修改点，无需发送采集数据模块，修改显示表，历史表，并处理b_observe_data表
	 * （b_observe_data表需要先根据time+docId+observeId查询是否有值，如果有记录，则修改，无记录，则新增）
	 * 
	 * @return
	 */
	@RequestMapping("/updobsdat")
	@ResponseBody
	@ApiOperation(value = "修改点", httpMethod = "POST", notes = "修改点")
	public String updobsdat(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDisplayChangeFormBean changeBean) {
		logger.info("----------------start updobsdat------------------------");
		ResponseValue res = new ResponseValue();
		basMonitorDisplayService.changeMonitDisplay(changeBean);
		res.setResultCode("1");
		res.setResultMessage("操作成功");
		logger.info("------------------end updobsdat------------------------");
		return res.getJsonStr();
	}

	/**
	 * 批量新增or修改点
	 * 
	 * @param monitors
	 * @return
	 */
	@RequestMapping("/batchHandleObsDat")
	@ResponseBody
	@ApiOperation(value = "批量修改点", httpMethod = "POST", notes = "批量修改点")
	public String batchHandleObsDat(@ApiParam(name = "params", value = "参数") @RequestBody List<MonitorDisplayChangeFormBean> monitors) {
		logger.info("----------------start batchHandleObsDat------------------------");
		ResponseValue res = new ResponseValue();
		if (null != monitors && monitors.size() > 0) {
			basMonitorDisplayService.batchHandleObsDat(monitors);
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("------------------end batchHandleObsDat------------------------");
			return res.getJsonStr();
		}
		res.setResultCode("1");
		res.setResultMessage("操作成功");
		logger.info("------------------end batchHandleObsDat------------------------");
		return res.getJsonStr();
	}

	/**
	 * 修改颜色、图标、max、min，无需发送采集数据模块, ---
	 * 页面只传递已勾选的AnaesMonitorConfig列表，存入b_anaes_monitor_config
	 * 
	 * @return
	 */
	@RequestMapping("/updmonitorDisp")
	@ResponseBody
	@ApiOperation(value = "修改颜色、图标、max、min", httpMethod = "POST", notes = "修改颜色、图标、max、min")
	public String updmonitorDisp(@ApiParam(name = "params", value = "参数") @RequestBody List<BasAnaesMonitorConfig> anaesMonitorConfigList) {
		logger.info("----------------start updmonitorDisp------------------------");
		ResponseValue res = new ResponseValue();
		basAnaesMonitorConfigService.saveAnaesMonitorConfig(anaesMonitorConfigList);
		res.setResultCode("1");
		res.setResultMessage("修改成功！");
		logger.info("------------------end updmonitorDisp------------------------");
		return res.getJsonStr();
	}

	/**
	 * 查询麻醉记录单
	 * 
	 * @param regOptId
	 * @return
	 */
	@RequestMapping("/getAnaesRecord")
	@ResponseBody
	@ApiOperation(value = "查询麻醉记录单", httpMethod = "POST", notes = "查询麻醉记录单")
	public String getAnaesRecord(@ApiParam(name = "regOptId", value = "手术信息id") @RequestBody String regOptId) {
		logger.info("----------------start getAnaesRecord------------------------");
		ResponseValue res = new ResponseValue();
		DocAnaesRecord anaesRecord = docAnaesRecordService.getAnaesRecord(regOptId);
		res.put("anaesRecord", anaesRecord);
		res.setResultCode("1");
		res.setResultMessage("获取麻醉记录单成功！");
		logger.info("------------------end getAnaesRecord------------------------");
		return res.getJsonStr();
	}

	/**
	 * 获取实时数据和获取设备状态，无需发送采集数据模块； 如果手脱了，数据还是原来的数据，比对5s，如果超过5s，则不传递数据给前端；
	 * 
	 * @return
	 */
	@RequestMapping("/getrtData")
	@ResponseBody
	@ApiOperation(value = "获取实时数据和获取设备状态", httpMethod = "POST", notes = "获取实时数据和获取设备状态")
	public String getrtData(@ApiParam(name = "params", value = "参数") @RequestBody BaseInfoQuery baseQuery) {
		logger.info("----------------start getrtData------------------------");
		ResponseValue res = new ResponseValue();
		if (null != baseQuery) {
			// List<RealTimeDataFormBean> monitorList =
			// basMonitorDisplayService.searchObserveDataByPosition(baseQuery);
		    if (StringUtils.isBlank(baseQuery.getBeid()))
		    {
		        baseQuery.setBeid(getBeid());
		    }
		    
			Map<String, RealTimeDataFormBean> resultMap = basMonitorDisplayService.searchObserveMapByPosition(baseQuery);
			res.put("monitorList", resultMap);
			// 获取设备列表
			List<Device> devices = basDeviceService.searchDeviceListByRoomId(null, baseQuery.getBeid());
			res.put("devices", devices);

			res.setResultCode("1");
			res.setResultMessage("操作成功");
		}
		logger.info("------------------end getrtData------------------------");
		return res.getJsonStr();
	}

	/**
	 * 描点数据和表格数据(历史)，无需发送采集数据模块 如果是已经修改的值，在具体的点上面增加flag
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/getobsData")
	@ResponseBody
	@ApiOperation(value = "描点历史数据查询", httpMethod = "POST", notes = "描点历史数据查询")
	public Map getobsData(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getobsData------------------------");
		Map map = new HashMap();
		LegendData legend = new LegendData();
		List<String> legendData = new ArrayList<String>();

		List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
		XAxisData1 xaisData = null;
		List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

		// 建造yAxis数据
		List<YAxisData> yAxis = new ArrayList<YAxisData>();
		YAxisData yd = null;
		yd = new YAxisData();
		// yd.setName(ObserveDataController.PR_NAME);
		yd.setType("value");
		yd.setMax(180);
		yd.setMin(0);
		yd.setOrder(1);
		yAxis.add(yd);
		yd = new YAxisData();
		// yd.setName(ObserveDataController.TEMP_NAME);
		yd.setType("value");
		yd.setMax(60);
		yd.setMin(30);
		yd.setOrder(2);
		yAxis.add(yd);
		Collections.sort(yAxis);

		List<SeriesData> series = new ArrayList<SeriesData>();
		SeriesData seriesdata = null;
		List<SeriesDataObj> da = null;
		SeriesDataObj obj = null;
		Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();

		// 获取需要显示的数据
		String regOptId = formBean.getRegOptId();
		Integer position = 0;
		String beid = formBean.getBeid();
		if (StringUtils.isBlank(beid))
		{
		    beid = getBeid();
		    formBean.setBeid(beid);
		}

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition(position + "");
		baseQuery.setEnable("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		List<String> observeIds = new ArrayList<String>();

		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
				String observeId = bean.getEventId();
				// 获取显示项需要的observeIds
				observeIds.add(observeId);
				String observeName = bean.getEventName();
				String color = bean.getColor();// 对应图标
				String icon = bean.getIconId();// 对应颜色
				String svg = basIconSvgService.getPathByIcon(bean.getIconId(), beid);
				String units = bean.getUnits(); // 默认单位
				Float max = bean.getMax(); // max
				Float min = bean.getMin(); // min
				legendData.add(observeName);

				// ABP_HR，CVP，℃
				if (observeId.equals(NP_TEMP_POSITION_RT) || observeId.equals(RE_TEMP_POSITION_RT) || observeId.equals(NP_TEMP_POSITION_LINE) || observeId.equals(RE_TEMP_POSITION_LINE) || observeId.equals(TEMP_POSITION_RT) || observeId.equals(TEMP_POSITION_LINE)) { // 如果是温度，则y轴为2
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 2, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				} else if (observeId.equals(CVP_MEAN_POSITION_RT) || observeId.equals(CVP_MEAN_POSITION_LINE)) { // cvp,则y轴为1
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 1, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				} else {// abp_hp等
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 0, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				}

			}
		}

		List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(formBean, observeIds);

		List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchBreathListOrder(regOptId);
		CtlBreathDateFormBean cbFormBean = null;
		List<CtlBreathDateFormBean> cbList = new ArrayList<CtlBreathDateFormBean>();

		if (null != ctlBreathList && ctlBreathList.size() > 0) {
			for (int i = 0; i < ctlBreathList.size(); i++) {
				EvtCtlBreath ctlBreath = ctlBreathList.get(i);
				int curState = ctlBreath.getCurrentState();
				int type = ctlBreath.getType();
				if (1 == curState) {
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formBean.getBeid());
					if (null != scList && scList.size() > 0) {
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
						cbFormBean.setCodeSvg(basIconSvgService.getPathByIcon(codeValue, beid));
					}
					cbList.add(cbFormBean);
				} else {
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setEndTime(cbList.get(cbList.size() - 1).getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formBean.getBeid());
					if (null != scList && scList.size() > 0) {
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
						cbFormBean.setCodeSvg(basIconSvgService.getPathByIcon(codeValue, beid));
					}
					cbList.add(cbFormBean);
				}
			}
		}

		Date t = new Date(1L);
		if (null != monitorList && monitorList.size() > 0) {
			for (int i = 0; i < monitorList.size(); i++) {
				BasMonitorDisplay md = monitorList.get(i);
				String key = md.getObserveId();
				Date time = md.getTime();

				if (t.getTime() != time.getTime()) {
					t = time;
					XAxisDataBean bean = new XAxisDataBean();
					bean.setValue(t);
					Integer freq = md.getIntervalTime();
					bean.setFreq(freq);
					data.add(bean);
				}
				// series
				if (!seriesMap.containsKey(key)) {
					logger.info("------------------没有当前key" + key + "------------------------");
				} else {
					seriesdata = seriesMap.get(key);
					da = seriesdata.getData();
					seriesdata.setType("line");
					seriesdata.setName(md.getObserveName());

					// 设置指定对应的y轴
					if (NP_TEMP_POSITION_LINE.equals(md.getObserveId()) || NP_TEMP_POSITION_RT.equals(md.getObserveId()) || RE_TEMP_POSITION_LINE.equals(md.getObserveId()) || RE_TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_LINE.equals(md.getObserveId())) {
						seriesdata.setyAxisIndex(2);
					} else if (CVP_MEAN_POSITION_LINE.equals(md.getObserveId()) || CVP_MEAN_POSITION_RT.equals(md.getObserveId())) {
						seriesdata.setyAxisIndex(1);
					} else {
						seriesdata.setyAxisIndex(0);
					}

					// 增加呼吸事件图标的判断(呼吸机和麻醉机的observeId)
					if (RESP_EVENT_ID.equals(md.getObserveId())) {
						if (null != cbList && cbList.size() > 0) {
							int flag = -1;
							for (CtlBreathDateFormBean cb : cbList) {
								Date st = cb.getStartTime();
								Date et = cb.getEndTime();
								// logger.info("getobsData----st="+st+",et="+et+",time="+time);
								if (null != et) {
									if (time.getTime() >= st.getTime() && time.getTime() < et.getTime()) {
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue(), md.getValue() != null ? cb.getCodeSvg() : "");
										flag = 0;
										break;
									}
								} else {
									if (time.getTime() >= st.getTime()) {
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue(), md.getValue() != null ? cb.getCodeSvg() : "");
										flag = 0;
										break;
									}
								}
							}
							if (flag == -1) {
								obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
							}
						} else {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
						}
					} else {
						obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
					}
					// 如果 amendFlag为2，则设值
					if (null != md.getAmendFlag()) {
						if (md.getAmendFlag() == 2) {
							obj.setAmendFlag(md.getAmendFlag());
						}
					}
					da.add(obj);
					seriesdata.setData(da);
					seriesMap.put(key, seriesdata);
				}

			}

		} else {
			// 无采集数据
			logger.info("----------无采集数据----------------");
		}

		// 循环seriesMap中的数据
		for (String key : seriesMap.keySet()) {
			SeriesData sd = seriesMap.get(key);
			series.add(sd);
		}

		// 添加times到x轴
		xaisData = new XAxisData1();
		xaisData.setData(data);
		xAxis.add(xaisData);

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);

		// 获取修改频率的List
		List<BasMonitorFreqChange> monitorFreqChanges = basMonitorFreqChangeService.getMonitorFreqChanges(regOptId);

		// 获取当前频率
		String currentModel = basRegOptService.getCurrentModel(regOptId);
		BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqService.searchMonitorFreqByType(currentModel);
		String f = "";
		Integer freq = 0;
		if (monitorFreq != null) {
			f = monitorFreq.getValue();
			freq = Integer.valueOf(f);
		}

		// 获取最近点
		BasMonitorDisplay md = basMonitorDisplayService.findLastestMonitorDisplay(regOptId);

		map.put("xAxis", xAxis);
		map.put("yAxis", yAxis);
		map.put("series", series);
		// 有显示项 则增加legend数据，传递给前端
		legend.setData(legendData);
		map.put("legend", legend);
		// 获取数据total
		map.put("total", total);
		map.put("monitorFreqChanges", monitorFreqChanges);
		map.put("freq", freq);
		map.put("md", md);

		// 计算偏移量
		Date inTime = formBean.getInTime();

		long offset = 0;// 偏移量
		BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
		if (null == regOpt) {
			logger.info("getobsData----regOpt手术为null！--------------");
			map.put("resultCode", "10000000");
			map.put("resultMessage", "查询数据有误，请与系统管理员联系!");
			return map;
		} else {
			Date operTime = regOpt.getOperTime();
			if (null == operTime) {
				logger.info("getobsData----operTime手术时间为null！--------------");
				map.put("resultCode", "10000000");
				map.put("resultMessage", "查询数据有误，请与系统管理员联系!");
				return map;
			} else {

				BasMonitorFreqChange monitorFreqChange = basMonitorFreqChangeService.selectFirstChangeTime(regOptId, DateUtils.formatDateTime(inTime));
				if (null == monitorFreqChange) {
					map.put("changeFreqTime", null);
				} else {
					map.put("changeFreqTime", monitorFreqChange.getTime());
				}

				long time = inTime.getTime() - operTime.getTime();
				if (time == 0) {
					map.put("offset", offset);
				} else if (time < 0) { // 修改后的入室时间小于第一次的手术命令开始时间
					BasMonitorDisplay firstMd = basMonitorDisplayService.findMonitorDisplaybyTime(regOptId, SysUtil.getTimeFormat(operTime));
					long operFreq = 0;
					if (null != firstMd) {
						operFreq = firstMd.getFreq();
						offset = (Math.abs(time) % (operFreq * 1000)) / 1000;// 取绝对值取mod
						map.put("offset", offset);
					} else {
						logger.info("getobsData----operTime查询出来的MonitorDisplay为null！--------------");
						map.put("resultCode", "10000000");
						map.put("resultMessage", "查询数据有误，请与系统管理员联系!");
						return map;
					}
				} else { // time > 0
					BasMonitorDisplay curMd = basMonitorDisplayService.findMonitorDisplayByInTimeLimit1(regOptId, inTime);
					if (null != curMd) {
						Date curTime = curMd.getTime();
						Integer operFreq = curMd.getFreq();
						Integer intervalTime = curMd.getIntervalTime();
						if (operFreq.intValue() != intervalTime.intValue()) {
							long myTime = ((curTime.getTime() + intervalTime * 1000) - inTime.getTime()) / 1000;
							if (myTime > 0) { // 1、如果最近点+intervalTime大于intime，则
												// offset
												// =(curTime+interval_time)-inTime
								map.put("offset", myTime);
							} else if (myTime == 0) {
								map.put("offset", 0);
							} else { // 3、如果最近点+intervalTime小于intime，则offset =
										// freq(当前频率)-(inTime-(curTime+interval_time))
								long tt = ((inTime.getTime() - (curTime.getTime() + intervalTime * 1000)) / 1000) % freq;
								if (tt == 0) {
									map.put("offset", 0);
								} else {
									offset = freq - tt;
									map.put("offset", offset);
								}
							}
						} else {
							long cTime = (inTime.getTime() - curTime.getTime()) / 1000; // cTime
																						// 等于
																						// 根据
							if (cTime == 0) {
								map.put("offset", 0);
							} else {
								offset = operFreq - cTime;// 当前频率-（入室时间-当前最近点时间）
								logger.info("offset===" + offset + ",cTime==" + cTime + ",inTime=" + inTime + ",curTime==" + curTime);
								map.put("offset", offset);
							}
						}
					} else {
						logger.info("getobsData----inTime查询出来的最近的右边的MonitorDisplay为null！--------------");
						map.put("resultCode", "10000000");
						map.put("resultMessage", "查询数据有误，请与系统管理员联系!");
						return map;
					}
				}
			}
		}

		map.put("resultCode", "1");
		map.put("resultMessage", "操作成功！");

		logger.info("getobsData---allData===" + JsonType.jsonType(map) + ",inTime==" + formBean.getInTime());
		logger.info("------------------end getobsData------------------------");
		return map;
	}

	/**
	 * 获取新点
	 * 
	 * @param formBean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/getobsDataNew")
	@ResponseBody
	@ApiOperation(value = "获取新点", httpMethod = "POST", notes = "获取新点")
	public Map getobsDataNew(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getobsDataNew------------------------");
		Map map = new HashMap();
		if (StringUtils.isBlank(formBean.getBeid())) {
			formBean.setBeid(getBeid());
		}
		Date inTime = formBean.getInTime();
		Date startTime = formBean.getStartTime();
		// Date endTime = formBean.getEndTime();
		if (null == inTime) {
			map.put("resultCode", "30000001");
			map.put("resultMessage", "入室时间不能为空！");
			return map;
		}
		if (null == startTime) {
			map.put("resultCode", "30000001");
			map.put("resultMessage", "开始时间不能为空！");
			return map;
		}

		LegendData legend = new LegendData();
		List<String> legendData = new ArrayList<String>();

		List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
		XAxisData1 xaisData = null;
		List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

		// 建造yAxis数据
		List<YAxisData> yAxis = new ArrayList<YAxisData>();
		YAxisData yd = null;
		yd = new YAxisData();
		// yd.setName(ObserveDataController.PR_NAME);
		yd.setType("value");
		yd.setMax(180);
		yd.setMin(0);
		yd.setOrder(1);
		yAxis.add(yd);
		yd = new YAxisData();
		// yd.setName(ObserveDataController.TEMP_NAME);
		yd.setType("value");
		yd.setMax(60);
		yd.setMin(30);
		yd.setOrder(2);
		yAxis.add(yd);
		Collections.sort(yAxis);

		List<SeriesData> series = new ArrayList<SeriesData>();
		SeriesData seriesdata = null;
		List<SeriesDataObj> da = null;
		SeriesDataObj obj = null;
		Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();

		// 获取需要显示的数据
		String regOptId = formBean.getRegOptId();
		Integer position = 0;
		String beid = formBean.getBeid();
		if (StringUtils.isBlank(beid))
		{
		    beid = getBeid();
		    formBean.setBeid(getBeid());
		}

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition(position + "");
		baseQuery.setEnable("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		List<String> observeIds = new ArrayList<String>();

		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
				String observeId = bean.getEventId();
				// 获取显示项需要的observeIds
				observeIds.add(observeId);
				String observeName = bean.getEventName();
				String color = bean.getColor();// 对应颜色
				String icon = bean.getIconId();// 对应图标
				String svg = basIconSvgService.getPathByIcon(icon, beid);
				String units = bean.getUnits(); // 默认单位
				Float max = bean.getMax();
				Float min = bean.getMin();
				legendData.add(observeName);

				// ABP_HR，CVP，℃
				if (observeId.equals(NP_TEMP_POSITION_RT) || observeId.equals(RE_TEMP_POSITION_RT) || observeId.equals(NP_TEMP_POSITION_LINE) || observeId.equals(RE_TEMP_POSITION_LINE) || observeId.equals(TEMP_POSITION_RT) || observeId.equals(TEMP_POSITION_LINE)) { // 如果是温度，则y轴为2
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 2, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				} else if (observeId.equals(CVP_MEAN_POSITION_RT) || observeId.equals(CVP_MEAN_POSITION_LINE)) { // cvp,则y轴为1
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 1, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				} else {// abp_hp等,y轴为0
					seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 0, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
				}

			}
		}

		List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsDataNew4(formBean, observeIds); // 增加特殊处理逻辑

		EvtCtlBreath ctlBreath = evtCtlBreathService.selCtlBreathCur(regOptId);
		int type = 0;
		if (null != ctlBreath) {
			type = ctlBreath.getType();
		}
		List<SysCodeFormbean> sysCodeList = basSysCodeService.searchSysCodeByGroupId("breath_event", formBean.getBeid());
		String code_value_1 = "", svg_value_1 = "";
		String code_value_2 = "", svg_value_2 = "";
		String code_value_3 = "", svg_value_3 = "";
		if (null != sysCodeList && sysCodeList.size() > 0) {
			for (SysCodeFormbean sysCodeFormbean : sysCodeList) {
				String codeName = sysCodeFormbean.getCodeName();
				if ("1".equals(codeName)) {
					code_value_1 = sysCodeFormbean.getCodeValue();
					svg_value_1 = basIconSvgService.getPathByIcon(code_value_1, beid);
				} else if ("2".equals(codeName)) {
					code_value_2 = sysCodeFormbean.getCodeValue();
					svg_value_2 = basIconSvgService.getPathByIcon(code_value_2, beid);
				} else if ("3".equals(codeName)) {
					code_value_3 = sysCodeFormbean.getCodeValue();
					svg_value_3 = basIconSvgService.getPathByIcon(code_value_3, beid);
				}
			}
		}

		Date t = new Date(1L);
		if (null != monitorList && monitorList.size() > 0) {
			for (int i = 0; i < monitorList.size(); i++) {
				BasMonitorDisplay md = monitorList.get(i);
				String key = md.getObserveId();
				Date time = md.getTime();
				if (t.getTime() != time.getTime()) {
					t = time;
					// data.add(t);
					XAxisDataBean bean = new XAxisDataBean();
					bean.setValue(t);
					Integer freq = md.getIntervalTime();
					bean.setFreq(freq);
					data.add(bean);
				}
				// series
				if (!seriesMap.containsKey(key)) {
					logger.info("------------------没有当前key" + key + "------------------------");
				} else {
					seriesdata = seriesMap.get(key);
					da = seriesdata.getData();
					seriesdata.setType("line");
					seriesdata.setName(md.getObserveName());
					// 设置指定对应的y轴
					if (NP_TEMP_POSITION_LINE.equals(md.getObserveId()) || NP_TEMP_POSITION_RT.equals(md.getObserveId()) || RE_TEMP_POSITION_LINE.equals(md.getObserveId()) || RE_TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_LINE.equals(md.getObserveId())) {
						seriesdata.setyAxisIndex(2);
					} else if (CVP_MEAN_POSITION_LINE.equals(md.getObserveId()) || CVP_MEAN_POSITION_RT.equals(md.getObserveId())) {
						seriesdata.setyAxisIndex(1);
					} else {
						seriesdata.setyAxisIndex(0);
					}
					// seriesdata.setSymbolSize(8);
					if (RESP_EVENT_ID.equals(md.getObserveId())) {
						if (1 == type) {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), code_value_1, svg_value_1);
						} else if (2 == type) {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), code_value_2, svg_value_2);
						} else if (3 == type) {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), code_value_3, svg_value_3);
						} else {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
						}
					} else {
						obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
					}

					da.add(obj);
					seriesdata.setData(da);
					seriesMap.put(key, seriesdata);
				}

			}

		} else {
			// 无采集数据
			logger.info("----------无采集数据----------------");
		}

		// 循环seriesMap中的数据
		for (String key : seriesMap.keySet()) {
			SeriesData sd = seriesMap.get(key);
			series.add(sd);
		}

		// 添加times到x轴
		xaisData = new XAxisData1();
		xaisData.setData(data);
		xAxis.add(xaisData);

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);

		// 获取修改频率的List
		// List<BasMonitorFreqChange> monitorFreqChanges =
		// basMonitorFreqChangeService.getMonitorFreqChanges(formBean.getRegOptId());

		// 获取当前频率
		String currentModel = basRegOptService.getCurrentModel(formBean.getRegOptId());
		BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqService.searchMonitorFreqByType(currentModel);
		String f = "";
		Integer freq = 0;
		if (monitorFreq != null) {
			f = monitorFreq.getValue();
			freq = Integer.valueOf(f);
		}

		BasMonitorFreqChange monitorFreqChange = basMonitorFreqChangeService.selectFirstChangeTime(regOptId, DateUtils.formatDateTime(inTime));
		if (null == monitorFreqChange) {
			map.put("changeFreqTime", null);
		} else {
			map.put("changeFreqTime", monitorFreqChange.getTime());
		}

		map.put("xAxis", xAxis);
		map.put("yAxis", yAxis);
		map.put("series", series);
		// 有显示项 则增加legend数据，传递给前端
		legend.setData(legendData);
		map.put("legend", legend);
		// 获取数据total
		map.put("total", total);
		map.put("freq", freq);

		map.put("resultCode", "1");
		map.put("resultMessage", "操作成功！");

		logger.info("------------------end getobsDataNew------------------------");
		return map;
	}

	/**
	 * 页面再次打开，间隔点的处理
	 * 
	 * @param formbean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/getIntervalObsData")
	@ResponseBody
	@ApiOperation(value = "页面再次打开，间隔点的处理", httpMethod = "POST", notes = "页面再次打开，间隔点的处理")
	public Map getIntervalObsData(@ApiParam(name = "formbean", value = "参数")@RequestBody IntervalDataFormBean formbean) {
		logger.info("----------------start getIntervalObsData------------------------");
		ResponseValue res = new ResponseValue();
		Map map = new HashMap();
		if (formbean != null) {
			basMonitorDisplayService.getIntervalObsData(formbean); // 获取中间断的点

			LegendData legend = new LegendData();
			List<String> legendData = new ArrayList<String>();

			List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
			XAxisData1 xaisData = null;
			List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

			// 建造yAxis数据
			List<YAxisData> yAxis = new ArrayList<YAxisData>();
			YAxisData yd = null;
			yd = new YAxisData();
			yd.setType("value");
			yd.setMax(180);
			yd.setMin(0);
			yd.setOrder(1);
			yAxis.add(yd);
			yd = new YAxisData();
			yd.setType("value");
			yd.setMax(60);
			yd.setMin(30);
			yd.setOrder(2);
			yAxis.add(yd);
			Collections.sort(yAxis);

			List<SeriesData> series = new ArrayList<SeriesData>();
			SeriesData seriesdata = null;
			List<SeriesDataObj> da = null;
			SeriesDataObj obj = null;
			Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();

			// 获取需要显示的数据
			String regOptId = formbean.getRegOptId();
			Integer position = 0;
			String beid = formbean.getBeid();
			if (StringUtils.isBlank(beid))
			{
			    beid = getBeid();
			    formbean.setBeid(beid);
			}

			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setRegOptId(regOptId);
			baseQuery.setPosition(position + "");
			baseQuery.setEnable("1");
			List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
			List<String> observeIds = new ArrayList<String>();

			if (null != anaesLists && anaesLists.size() > 0) {
				for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
					String observeId = bean.getEventId();
					// 获取显示项需要的observeIds
					observeIds.add(observeId);
					String observeName = bean.getEventName();
					String color = bean.getColor();// 对应图标
					String icon = bean.getIconId();// 对应颜色
					String svg = basIconSvgService.getPathByIcon(icon, beid);
					String units = bean.getUnits(); // 默认单位
					Float max = bean.getMax(); // max
					Float min = bean.getMin(); // min
					legendData.add(observeName);
					// ABP_HR，CVP，℃
					if (observeId.equals(NP_TEMP_POSITION_RT) || observeId.equals(RE_TEMP_POSITION_RT) || observeId.equals(NP_TEMP_POSITION_LINE) || observeId.equals(RE_TEMP_POSITION_LINE) || observeId.equals(TEMP_POSITION_RT) || observeId.equals(TEMP_POSITION_LINE)) { // 如果是温度，则y轴为2
						seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 2, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
					} else if (observeId.equals(CVP_MEAN_POSITION_RT) || observeId.equals(CVP_MEAN_POSITION_LINE)) { // cvp,则y轴为1
						seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 1, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
					} else {// abp_hp等,y轴为0
						seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 0, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
					}
				}
			}
			MonitorDataFormBean mdFormBean = new MonitorDataFormBean();
			BeanUtils.copyProperties(formbean, mdFormBean);
			List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(mdFormBean, observeIds);

			List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchBreathListOrder(regOptId);
			CtlBreathDateFormBean cbFormBean = null;
			List<CtlBreathDateFormBean> cbList = new ArrayList<CtlBreathDateFormBean>();

			if (null != ctlBreathList && ctlBreathList.size() > 0) {
				for (int i = 0; i < ctlBreathList.size(); i++) {
					EvtCtlBreath ctlBreath = ctlBreathList.get(i);
					int curState = ctlBreath.getCurrentState();
					int type = ctlBreath.getType();
					if (1 == curState) {
						cbFormBean = new CtlBreathDateFormBean();
						cbFormBean.setStartTime(ctlBreath.getStartTime());
						cbFormBean.setType(type);
						List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formbean.getBeid());
						if (null != scList && scList.size() > 0) {
							String codeValue = scList.get(0).getCodeValue();
							cbFormBean.setCodeValue(codeValue);
							cbFormBean.setCodeSvg(basIconSvgService.getPathByIcon(codeValue, beid));
						}
						cbList.add(cbFormBean);
					} else {
						cbFormBean = new CtlBreathDateFormBean();
						cbFormBean.setStartTime(ctlBreath.getStartTime());
						cbFormBean.setEndTime(cbList.get(cbList.size() - 1).getStartTime());
						cbFormBean.setType(type);
						List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formbean.getBeid());
						if (null != scList && scList.size() > 0) {
							String codeValue = scList.get(0).getCodeValue();
							cbFormBean.setCodeValue(codeValue);
							cbFormBean.setCodeSvg(basIconSvgService.getPathByIcon(codeValue, beid));
						}
						cbList.add(cbFormBean);
					}
				}
			}

			Date t = new Date(1L);
			if (null != monitorList && monitorList.size() > 0) {
				for (int i = 0; i < monitorList.size(); i++) {
					BasMonitorDisplay md = monitorList.get(i);
					String key = md.getObserveId();
					Date time = md.getTime();

					if (t.getTime() != time.getTime()) {
						t = time;
						XAxisDataBean bean = new XAxisDataBean();
						bean.setValue(t);
						Integer freq = md.getIntervalTime();
						bean.setFreq(freq);
						data.add(bean);
					}
					// series
					if (!seriesMap.containsKey(key)) {
						logger.info("------------------没有当前key" + key + "------------------------");
					} else {
						seriesdata = seriesMap.get(key);
						da = seriesdata.getData();
						seriesdata.setType("line");
						seriesdata.setName(md.getObserveName());
						// 设置指定对应的y轴
						if (NP_TEMP_POSITION_LINE.equals(md.getObserveId()) || NP_TEMP_POSITION_RT.equals(md.getObserveId()) || RE_TEMP_POSITION_LINE.equals(md.getObserveId()) || RE_TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_LINE.equals(md.getObserveId())) {
							seriesdata.setyAxisIndex(2);
						} else if (CVP_MEAN_POSITION_LINE.equals(md.getObserveId()) || CVP_MEAN_POSITION_RT.equals(md.getObserveId())) {
							seriesdata.setyAxisIndex(1);
						} else {
							seriesdata.setyAxisIndex(0);
						}
						// seriesdata.setSymbolSize(8);

						// 增加呼吸事件图标的判断
						if (RESP_EVENT_ID.equals(md.getObserveId())) {
							if (null != cbList && cbList.size() > 0) {
								int flag = -1;
								for (CtlBreathDateFormBean cb : cbList) {
									Date st = cb.getStartTime();
									Date et = cb.getEndTime();
									// logger.info("getobsData----st="+st+",et="+et+",time="+time);
									if (null != et) {
										if (time.getTime() >= st.getTime() && time.getTime() < et.getTime()) {
											obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue(), cb.getCodeSvg());
											flag = 0;
											break;
										}
									} else {
										if (time.getTime() >= st.getTime()) {
											obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue(), cb.getCodeSvg());
											flag = 0;
											break;
										}
									}
								}
								if (flag == -1) {
									obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
								}
							} else {
								obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
							}
						} else {
							obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
						}
						// 如果 amendFlag为2，则设值
						if (null != md.getAmendFlag()) {
							if (md.getAmendFlag() == 2) {
								obj.setAmendFlag(md.getAmendFlag());
							}
						}
						da.add(obj);
						seriesdata.setData(da);
						seriesMap.put(key, seriesdata);
					}

				}

			} else {
				// 无采集数据
				logger.info("----------无采集数据----------------");
			}

			// 循环seriesMap中的数据
			for (String key : seriesMap.keySet()) {
				SeriesData sd = seriesMap.get(key);
				series.add(sd);
			}

			// 添加times到x轴
			xaisData = new XAxisData1();
			xaisData.setData(data);
			xAxis.add(xaisData);

			// 获取总数
			int total = basMonitorDisplayService.getobsDataTotal(mdFormBean, observeIds);

			// 获取修改频率的List
			List<BasMonitorFreqChange> monitorFreqChanges = basMonitorFreqChangeService.getMonitorFreqChanges(regOptId);

			// 获取当前频率
			String currentModel = basRegOptService.getCurrentModel(regOptId);
			BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqService.searchMonitorFreqByType(currentModel);
			String f = "";
			Integer freq = 0;
			if (monitorFreq != null) {
				f = monitorFreq.getValue();
				freq = Integer.valueOf(f);
			}

			// 获取最近点
			BasMonitorDisplay md = basMonitorDisplayService.findLastestMonitorDisplay(regOptId);

			map.put("xAxis", xAxis);
			map.put("yAxis", yAxis);
			map.put("series", series);
			// 有显示项 则增加legend数据，传递给前端
			legend.setData(legendData);
			map.put("legend", legend);
			// 获取数据total
			map.put("total", total);
			map.put("monitorFreqChanges", monitorFreqChanges);
			map.put("freq", freq);
			map.put("md", md);

			map.put("resultCode", "1");
			map.put("resultMessage", "操作成功！");

		} else {
			map.put("resultCode", "70000000");
			map.put("resultMessage", Global.getRetMsg(res.getResultCode()));
		}

		logger.info("------------------end getIntervalObsData------------------------");
		return map;
	}

	/**
	 * 新增、修改、停用设备、采样频率，判断是否需要发送采集数据模块 修改设备配置
	 * 
	 * @return
	 */
	@RequestMapping("/updDeviceConfig")
	@ResponseBody
	@ApiOperation(value = "修改设备配置", httpMethod = "POST", notes = "修改设备配置")
	public String updDeviceConfig(@ApiParam(name = "params", value = "参数") @RequestBody DeviceConfigFormBean deviceConfigFormBean) {
		logger.info("----------------start updDeviceConfig------------------------");
		ResponseValue res = new ResponseValue();
		if (deviceConfigFormBean != null) {

			List<BasDeviceConfig> enableDeviceConfigList = basDeviceConfigService.getEnableDeviceConfigList();
			if (null != enableDeviceConfigList && enableDeviceConfigList.size() > 0) {
				BasDeviceConfig deviceConfig = deviceConfigFormBean.getDeviceConfig();
				if (null != deviceConfig && (null == deviceConfig.getEnable() || 1 == deviceConfig.getEnable())) {
					for (BasDeviceConfig enableDevConf : enableDeviceConfigList) {
						if (!enableDevConf.getDeviceId().equals(deviceConfig.getDeviceId()) && enableDevConf.getDeviceType().equals(deviceConfig.getDeviceType())) {
							res.setResultCode("70000000");
							res.setResultMessage("已有相同类型的设备启用！");
							return res.getJsonStr();
						}
					}
				}
			}

			basMonitorDisplayService.updDeviceConfig(deviceConfigFormBean);
			// 根据房间和术中状态查询手术
			BasRegOpt regOpt = basRegOptService.queryRegOptByState(Global.getConfig("roomId").toString(), "04");
			if (null != regOpt) {
				// 发送修改设备配置的命令给数据处理模块
				CmdMsg msg = new CmdMsg();
				msg.setMsgType(MyConstants.OPERATION_STATUS_CHECK);
				msg.setRegOptId(regOpt.getRegOptId());
				res = MessageProcess.process(msg);
			}
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}

		logger.info("------------------end updDeviceConfig------------------------");
		return res.getJsonStr();
	}

	/**
	 * 修改采集频率，获取当前频率
	 * 
	 * @param freqList
	 * @return
	 */
	@RequestMapping("/updFreq")
	@ResponseBody
	@ApiOperation(value = "修改采集频率", httpMethod = "POST", notes = "修改采集频率")
	public String updFreq(@ApiParam(name = "params", value = "参数") @RequestBody MonitorFreqFormBean formBean) {
		logger.info("----------------start updFreq------------------------");
		ResponseValue res = new ResponseValue("1");
		String regOptId = formBean.getRegOptId();
		List<BasMonitorConfigFreq> freqList = formBean.getFreqList();
		Date time = formBean.getTime();
		String currentModel = basRegOptService.getCurrentModel(regOptId);
		BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqService.searchMonitorFreqByType(currentModel);
		String f = "";
		Integer freq = 0;
		String model = "";
		if (monitorFreq != null) {
			f = monitorFreq.getValue();
			freq = Integer.valueOf(f);
			model = monitorFreq.getType();
		}
		// monitorConfigFreqService.updateFreq(freqList); //修改采集频率
		basMonitorDisplayService.updateFreq(freqList, model, time, regOptId);

		if (null != freqList && freqList.size() > 0) {
			for (BasMonitorConfigFreq monitorConfigFreq : freqList) {
				String type = monitorConfigFreq.getType();
				if (type.equals(model)) {// 传递过来的数据有当前模式下的频率 当前模式=传递过来的模式
					String value = monitorConfigFreq.getValue();
					Integer curFreq = Integer.valueOf(value);
					if (curFreq != freq) { // 频率不相等，则发送修改频率的命令到数据处理模块，只有普通模式的时候，频率才会不相等
						CmdMsg msg = new CmdMsg();
						msg.setMsgType(MyConstants.OPERATION_UPDATE_FREQ);
						msg.setRegOptId(regOptId);
						res = MessageProcess.process(msg);
						break;
					}
				}
			}
		}
		logger.info("------------------end updFreq------------------------");

		return res.getJsonStr();
	}

	/**
	 * 在手术初始化后，查询设备状态
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/getDeviceStatus")
	@ResponseBody
	@ApiOperation(value = "手术初始化查询设备状态", httpMethod = "POST", notes = "手术初始化查询设备状态")
	public String getDeviceStatus() {
		logger.info("----------------start getDeviceStatus------------------------");
		ResponseValue res = new ResponseValue();
		List<Device> devices = basDeviceService.searchDeviceListByRoomId(null, null);
		res.put("devices", devices);
		res.setResultCode("1");
		res.setResultMessage("获取设备列表成功！");
		logger.info("------------------end getDeviceStatus------------------------");
		return res.getJsonStr();
	}

	/**
	 * 切换模式（普通模式/抢救模式），发送采集数据模块
	 * 
	 * 1、传递切换频率的时间,修改最近点的interval_time 2、存入抢救事件
	 * 
	 * @return
	 */
	@RequestMapping("/changeModel")
	@ResponseBody
	@ApiOperation(value = "切换模式", httpMethod = "POST", notes = "切换模式")
	public String changeModel(@ApiParam(name = "params", value = "参数") @RequestBody RescueeventFormBean rescueeventFormBean) {
		logger.info("----------------start changeModel------------------------");
		ResponseValue res = new ResponseValue();
		EvtRescueevent rescueevent = rescueeventFormBean.getRescueevent();
		basMonitorDisplayService.changeModel(rescueeventFormBean);
		CmdMsg msg = new CmdMsg();
		msg.setMsgType(rescueevent.getModel());
		String regOptId = rescueeventFormBean.getRegOptId();
		msg.setRegOptId(regOptId);
		// 发送模式切换的命令
		res = MessageProcess.process(msg);
		logger.info("------------------end changeModel------------------------");
		return res.getJsonStr();
	}

	/**
	 * 查看非急诊的手术，是否相关文书已经完成
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping("/searchDocIsFinished")
	@ResponseBody
	@ApiOperation(value = "查看非急诊的手术，是否相关文书已经完成", httpMethod = "POST", notes = "查看非急诊的手术，是否相关文书已经完成")
	public String searchDocIsFinished(@ApiParam(name = "params", value = "参数") @RequestBody JSONObject json) {
		logger.info("-----------------start  searchDocIsFinished------------------------");
		ResponseValue res = new ResponseValue();
		String regOptId = json.get("regOptId").toString();
		if (StringUtils.isBlank(regOptId)) {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("-----------------end  searchDocIsFinished------------------------");
			return res.getJsonStr();
		}
		if (null != regOptId) {
			BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
			DocPreVisit preVisit = docPreVisitService.searchPreVisitByRegOptId(regOptId);
			DocAccede accede = docAccedeService.searchAccedeByRegOptId(regOptId);

			if (null == regOpt) {
				res.setResultCode("10000000");
				res.setResultMessage("未查询到regOptId=" + regOptId + "的记录！");
			} else {
				Integer emergency = regOpt.getEmergency();
				if (1 == emergency) {
					res.setResultCode("10000000");
					res.setResultMessage("手术regOptId=" + regOptId + "是急诊手术,无需检查！");
				} else {
					if (null != preVisit && null != accede) {
						String pv_processState = preVisit.getProcessState();
						String accede_processState = accede.getProcessState();
						if ("0".equals(regOpt.getIsLocalAnaes())) {
							if ("END".equals(pv_processState) && "END".equals(accede_processState)) {
								res.setResultCode("1");
								res.setResultMessage("术前访视单和麻醉同意书都已经完成！");
							} else if (!"END".equals(pv_processState)) {
								res.setResultCode("10000000");
								res.setResultMessage("术前访视单未完成！");
							} else if (!"END".equals(accede_processState)) {
								res.setResultCode("10000000");
								res.setResultMessage("麻醉同意书未完成！");
							}
						}

					} else {
						res.setResultCode("10000000");
						res.setResultMessage("系统错误，请联系管理员！");
					}
				}
			}
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}

		logger.info("-----------------end  searchDocIsFinished------------------------");
		return res.getJsonStr();
	}

	/**
	 * 手术初始化
	 * 
	 * @param msg
	 * @return
	 */
	@RequestMapping("/initOper")
	@ResponseBody
	@ApiOperation(value = "手术初始化", httpMethod = "POST", notes = "手术初始化")
	public String initOper(@ApiParam(name = "params", value = "参数") @RequestBody CmdMsg msg) {
		logger.info("----------------start initOper------------------------");
		ResponseValue res = new ResponseValue();
		if (null == msg) {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("----------------end initOper------------------------");
			return res.getJsonStr();
		} else {
			if (StringUtils.isEmpty(msg.getMsgType())) {
				res.setResultCode("70000000");
				res.setResultMessage(Global.getRetMsg(res.getResultCode()));
				logger.info("----------------end initOper------------------------");
				return res.getJsonStr();
			} else {
				res = MessageProcess.process(msg);
			}
		}

		logger.info("------------------end initOper------------------------");
		return res.getJsonStr();
	}

	/**
	 * 查询手术室是否有正在进行的手术
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/queryRoomOper")
	@ResponseBody
	@ApiOperation(value = "查询手术室是否有正在进行的手术", httpMethod = "POST", notes = "查询手术室是否有正在进行的手术")
	public String queryRoomOper(@ApiParam(name = "params", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("----------------begin queryRoomOper------------------------");
		Map result = new HashMap();
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setOperRoomId(Global.getConfig("roomId").toString());
		baseQuery.setState(OperationState.SURGERY);
		// 判断当前手术室是否存在未完成的手术，如果存在则返回错误消息
		List<SearchOperaPatrolRecordFormBean> operaPatrolList = basRegOptService.getOperaPatrolRecordListByRoomId(baseQuery);
		if (operaPatrolList.size() > 0) {
			SearchOperaPatrolRecordFormBean po = operaPatrolList.get(0);
			if (!po.getRegOptId().equals(searchBean.getRegOptId())) {
				result.put("resultCode", "40000004");
				result.put("resultMessage", po.getOperRoomName() + "存在病人信息为：" + po.getName() + ",手术未完成!");
				result.put("id", po.getRegOptId());
				logger.info("------------------end queryRoomOper------------------------");
				return JsonType.jsonType(result);
			} else {
				result.put("resultCode", "1");
				result.put("resultMessage", "当前手术正在术中!");
				logger.info("------------------end queryRoomOper------------------------");
				return JsonType.jsonType(result);
			}
		} else {
			result.put("resultCode", "1");
			result.put("resultMessage", "当前手术室暂无正在进行的手术!");
			logger.info("------------------end queryRoomOper------------------------");
			return JsonType.jsonType(result);
		}
	}

	/**
	 * 1、第一次进入手术室的时候，存入手术命令开始时间，存入入室事件，存入开始手术时间 2、存入第一个数据点 3、返回麻醉时间list
	 */
	@RequestMapping("/firstSpot")
	@ResponseBody
	@ApiOperation(value = "首次进入手术", httpMethod = "POST", notes = "首次进入手术")
	public String firstSpot(@RequestBody FirstSpotFormBean formBean) {
		logger.info("----------------start firstSpot------------------------");
		ResponseValue res = new ResponseValue();
		if (null != formBean) {
			basMonitorDisplayService.firstSpot(formBean);
			// 根据docId查询对应的事件id
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(formBean.getDocId());
			List<EvtAnaesEvent> resultList = new ArrayList<EvtAnaesEvent>();
			resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
			res.put("anaeseventList", resultList);
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}
		logger.info("----------------end firstSpot------------------------");
		return res.getJsonStr();
	}

	/**
	 * 开始手术，术前转术中 ，发送采集数据模块，并发送采集服务
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/startOper")
	@ResponseBody
	@ApiOperation(value = "开始手术", httpMethod = "POST", notes = "开始手术")
	public String startOper(@ApiParam(name = "params", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("----------------start startOper------------------------");
		
		Map result = new HashMap();
		String regOptId = searchBean.getRegOptId();
		String accessSource = searchBean.getAccessSource();
		
		if (StringUtils.isBlank(searchBean.getBeid()))
		{
		    searchBean.setBeid(getBeid());
		}
		// 麻醉记录单
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
		String anaRecordId = anaesRecord.getAnaRecordId();
		// 设置文书ID
		searchBean.setDocId(anaRecordId);
		// 手术信息表
		BasRegOpt opt = basRegOptService.searchRegOptById(regOptId);

		// 只有手术从术前到术中时，才需要将手术排程的麻醉医生、麻醉方法等数据插入到事件表
		boolean flagInsert = false;

		// 不为空则为术中访问、否则为术后访视
		if (StringUtils.isNotBlank(accessSource)) {

			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setOperRoomId(Global.getConfig("roomId").toString());
			baseQuery.setState(OperationState.SURGERY);
			// 判断当前手术室是否存在未完成的手术，如果存在则返回错误消息
			List<SearchOperaPatrolRecordFormBean> operaPatrolList = basRegOptService.getOperaPatrolRecordListByRoomId(baseQuery);
			if (operaPatrolList.size() > 0) {
				SearchOperaPatrolRecordFormBean po = operaPatrolList.get(0);
				if (!po.getRegOptId().equals(searchBean.getRegOptId())) {
					result.put("resultCode", "40000004");
					result.put("resultMessage", po.getOperRoomName() + "存在病人信息为：" + po.getName() + ",手术未完成!");
					result.put("id", po.getRegOptId());
					logger.info("------------------end startOper------------------------");
					return JsonType.jsonType(result);
				}
			}
			// 当source传入start表示进入手术室，需要更新状态为术中，否则不更新当前状态
			if ("start".equals(searchBean.getAccessSource())) {
				Controller controller = controllerService.getControllerById(regOptId);
				if (controller.getState().equals(OperationState.PREOPERATIVE)) {
					controllerService.changeControllerState(searchBean.getRegOptId(), OperationState.SURGERY);
					flagInsert = true;
				}
				
				// 如果已经是术后or中止状态，则直接返回给前端
				if (("06").equals(opt.getState())) { // 术后状态
					logger.info("当前患者(" + opt.getName() + ")的手术已结束!regOptId="+regOptId);
					flagInsert = false;
					//return JsonType.jsonType(result);
				} else if ("07".equals(opt.getState())) {
					logger.info("当前患者(" + opt.getName() + ")的手术已中止!regOptId="+regOptId);
					flagInsert = false;
					//return JsonType.jsonType(result);
				}
				
				if(flagInsert){
					// 发送命令给数据处理模块
					CmdMsg msg = new CmdMsg();
					msg.setMsgType(MyConstants.OPERATION_STATUS_START);
					msg.setRegOptId(searchBean.getRegOptId());
					ResponseValue res = MessageProcess.process(msg);
					result.put("startOper", res);
				}else{
					result.put("startOper", "当前手术不发送采集程序处理端，只有手术真正需要开启才发送采集程序处理端！");
				}

			}
			
			// 设置文书ID
			searchBean.setDocId(anaRecordId);
			// 手术信息表
			opt = basRegOptService.searchRegOptById(regOptId);
			// 获取排程信息
			BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);

			// 当麻醉记录表中的手术体位为空时则将排程表中的手术体位字段写入
			if (StringUtils.isBlank(anaesRecord.getOptBody()) && StringUtils.isNotBlank(dispatch.getOptBody())) {
				anaesRecord.setOptBody(dispatch.getOptBody());
				docAnaesRecordService.saveAnaesRecord(anaesRecord);
			}

			//当麻醉记录表中的手术室为空时则将排程表中的手术室字段写入
            if(StringUtils.isBlank(anaesRecord.getOperRoomName()) && null != dispatch.getOperRoomId())
            {
                BasOperroom operroom = basOperroomService.queryRoomListById(dispatch.getOperRoomId().toString());
                anaesRecord.setOperRoomName(null == operroom ? null : operroom.getName());
                docAnaesRecordService.saveAnaesRecord(anaesRecord);
            }
			
			if (flagInsert) {
				// 实际麻醉方法
				List<EvtRealAnaesMethod> realList = evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
				if (realList.size() < 1) {
					if (StringUtils.isNotBlank(opt.getDesignedAnaesMethodCode())) {
						String[] methodArray = opt.getDesignedAnaesMethodCode().split(",");
						String[] methodNameArray = opt.getDesignedAnaesMethodName().split(",");
						for (int i = 0; i < methodArray.length; i++) {
							String anaMedId = methodArray[i];
							String realAnaMedName = methodNameArray[i];
							EvtRealAnaesMethod realAnaesMethod = new EvtRealAnaesMethod();
							realAnaesMethod.setDocId(searchBean.getDocId());
							realAnaesMethod.setAnaMedId(anaMedId);
							realAnaesMethod.setName(realAnaMedName);
							evtRealAnaesMethodService.insertRealAnaesMethod(realAnaesMethod);
						}
					}
				}
				// 手术医生人员
				searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
				List<EvtParticipant> participantList = evtParticipantService.searchParticipantList(searchBean);
				/*
				 * 进入手术时，判断是否编辑了手术人员信息 如果存在则跳过读取regOpt表的手术人员记录
				 */
				if (participantList.size() < 1) {
					// 将RegOpt表中的主刀手术医生字段写入到participant表
					if (StringUtils.isNotBlank(opt.getOperatorId())) {
						String[] optArray = opt.getOperatorId().split(",");
						for (int i = 0; i < optArray.length; i++) {
							String operatorId = optArray[i];
							EvtParticipant participant = new EvtParticipant();
							participant.setDocId(searchBean.getDocId());
							participant.setRole(EvtParticipantService.ROLE_OPERAT);
							participant.setOperatorType("06"); // 主刀医生
							participant.setUserLoginName(operatorId);
							evtParticipantService.insertParticipant(participant);
						}
					}
					// 助手医生
					if (StringUtils.isNotBlank(opt.getAssistantId())) {
						String[] assArray = opt.getAssistantId().split(",");
						for (int i = 0; i < assArray.length; i++) {
							String assistantId = assArray[i];
							EvtParticipant participant = new EvtParticipant();
							participant.setDocId(searchBean.getDocId());
							participant.setRole(EvtParticipantService.ROLE_OPERAT);
							participant.setOperatorType("07"); // 助手医生
							participant.setUserLoginName(assistantId);
							evtParticipantService.insertParticipant(participant);
						}
					}
				}
			}
		}

		anaesRecord.setOptBodys(docAnaesRecordService.getOptBodys(anaesRecord.getOptBody()));
		// 麻醉事件
		List<EvtAnaesEvent> anaeseventList = evtAnaesEventService.searchAnaeseventList(searchBean);
		// 实际麻醉方法
		List<EvtAnaesMethodFormBean> realAnaesList = evtRealAnaesMethodService.getSelectRealAnaesMethodList(searchBean);
		// 术后诊断
		List<DiagnosedefFormBean> optLatterDiagList = evtOptLatterDiagService.getSelectOptLatterDiagList(searchBean);
		// 实施手术
		List<OperDefFormBean> optRealOperList = evtOptRealOperService.getSelectOptRealOperList(searchBean);
		// 麻醉医生列表
		searchBean.setRole(EvtParticipantService.ROLE_ANESTH);
		List<UserInfoFormBean> anesDocList = evtParticipantService.getSelectParticipantList(searchBean);

		// 手术医生列表
		searchBean.setRole(EvtParticipantService.ROLE_OPERAT);
		List<UserInfoFormBean> operatDocList = evtParticipantService.getSelectParticipantList(searchBean);

		// 巡回护士列表
		searchBean.setRole(EvtParticipantService.ROLE_NURSE);
		searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);// 05
		List<UserInfoFormBean> nurseList = evtParticipantService.getSelectParticipantList(searchBean);

		// 器械护士列表
		searchBean.setRole(EvtParticipantService.ROLE_NURSE);
		searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);// 04
		List<UserInfoFormBean> instruNurseList = evtParticipantService.getSelectParticipantList(searchBean);

		// 麻醉药事件明细 麻醉前用药
		//searchBean.setType("02");
		//List<RegOptOperMedicaleventFormBean> anaesMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);

		// 治疗药事件明细 用药
		//searchBean.setType("01");
		//List<RegOptOperMedicaleventFormBean> treatMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);
		
		//  用药 
		searchBean.setType("01");
		searchBean.setDocType(1);
		List<RegOptOperMedicaleventFormBean> treatMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);
		
		//  麻醉前用药
		searchBean.setType("02");
		List<RegOptOperMedicaleventFormBean> anaesMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);
		
		//  药物维持    
        searchBean.setType("03");
        List<RegOptOperMedicaleventFormBean> analgesicMedEvtList = evtMedicaleventService.searchMedicaleventGroupByCodeList(searchBean);

		// 入药量事件 输液
		searchBean.setSubType("1"); // 输液
		List<RegOptOperIoeventFormBean> transfusioninIoeventList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);

		searchBean.setSubType("2");// 输血
		List<RegOptOperIoeventFormBean> bloodinIoeventList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);

		// 出药量事件
		List<RegOptOperEgressFormBean> egressList = evtEgressService.searchEgressGroupByDefIdList(searchBean);

		// 手术体位变更
		List<OperBodyFormBean> operBodyList = evtOperBodyEventService.queryOperBodyEventList(searchBean);

		// 术中监测显示项
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(searchBean.getRegOptId());
		baseQuery.setEnable("1");
		baseQuery.setPosition("0");
		List<BasAnaesMonitorConfigFormBean> showList = basAnaesMonitorConfigService.getAnaesRecordShowListByRegOptId(baseQuery);

		// 防止出现首次进入术中时没有设备启用，但是后来追加设备启用但是设备并不是默认设备的情况，及时将b_anaes_monitor_config中重复监测项的realEventId更新为启用设备的eventId
		List<BasAnaesMonitorConfigFormBean> anaesMonitorConfigFormBeanList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		List<BasMonitorConfigDefault> monitorConfigDefaultList = monitorConfigDefaultService.selectAll();
		if (null != monitorConfigDefaultList && monitorConfigDefaultList.size() > 0) {
			for (BasMonitorConfigDefault monitorConfigDefault : monitorConfigDefaultList) {
				if (null == anaesMonitorConfigFormBeanList || anaesMonitorConfigFormBeanList.size() < 1) {
					break;
				}
				for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : anaesMonitorConfigFormBeanList) {
					if (monitorConfigDefault.getEventId().equals(anaesMonitorConfigFormBean.getEventId())) {
						String enableEventId = basMonitorConfigService.selectEventIdByEventName(anaesMonitorConfigFormBean, searchBean.getRegOptId());
						anaesMonitorConfigFormBean.setRealEventId(enableEventId);
						BasAnaesMonitorConfig amc = new BasAnaesMonitorConfig();
						BeanUtils.copyProperties(anaesMonitorConfigFormBean, amc);
						amc.setRegOptId(searchBean.getRegOptId());
						basAnaesMonitorConfigService.updateByEventId(amc);
					}
				}

			}
		}
		result.put("showList", anaesMonitorConfigFormBeanList);

		if ((null == anaesMonitorConfigFormBeanList || anaesMonitorConfigFormBeanList.size() <= 0) && null != showList && showList.size() > 0) {
			List<BasAnaesMonitorConfig> anaesMonitorConfigList = new ArrayList<BasAnaesMonitorConfig>();
			for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : showList) {
				BasAnaesMonitorConfig anaesMonitorConfig = new BasAnaesMonitorConfig();
				BeanUtils.copyProperties(anaesMonitorConfigFormBean, anaesMonitorConfig);
				anaesMonitorConfig.setRegOptId(searchBean.getRegOptId());

				BasMonitorConfigDefault monitorConfigDefault = monitorConfigDefaultService.searchByEventName(anaesMonitorConfigFormBean.getEventName());
				if (null != monitorConfigDefault) {
					// 获取到启动设备对应的eventId，如果都没启动，则取默认值
					String enableEventId = basMonitorConfigService.selectEventIdByEventName(anaesMonitorConfigFormBean, searchBean.getRegOptId());
					if (enableEventId.equals(anaesMonitorConfig.getEventId())) {
						anaesMonitorConfigList.add(anaesMonitorConfig);
					}
				} else {
					anaesMonitorConfigList.add(anaesMonitorConfig);
				}
			}
			basAnaesMonitorConfigService.saveAnaesMonitorConfig(anaesMonitorConfigList);
			result.put("showList", anaesMonitorConfigList);
		}

		BasMonitorConfig O2 = basMonitorConfigService.selectByEventId(MyObserveDataController.O2_EVENT_ID);

		// 左侧采集项显示
		baseQuery.setPosition("1");
		baseQuery.setEnable(null);
		List<BasAnaesMonitorConfigFormBean> leftShowList = basAnaesMonitorConfigService.getAnaesRecordShowListByRegOptId(baseQuery);
		anaesMonitorConfigFormBeanList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		if (null != anaesMonitorConfigFormBeanList && anaesMonitorConfigFormBeanList.size() > 0) {
			// 去除O2的监测项
			for (int i = 0; i < anaesMonitorConfigFormBeanList.size(); i++) {
				BasAnaesMonitorConfigFormBean mc = anaesMonitorConfigFormBeanList.get(i);
				if (mc.getEventId().equals("91001")) {
					anaesMonitorConfigFormBeanList.remove(mc);
					break;
				}
			}
		}

		result.put("leftShowList", anaesMonitorConfigFormBeanList);
		if ((null == anaesMonitorConfigFormBeanList || anaesMonitorConfigFormBeanList.size() <= 0) && null != leftShowList && leftShowList.size() > 0) {
			List<BasAnaesMonitorConfig> anaesMonitorConfigList = new ArrayList<BasAnaesMonitorConfig>();
			for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : leftShowList) {
				BasAnaesMonitorConfig anaesMonitorConfig = new BasAnaesMonitorConfig();
				BeanUtils.copyProperties(anaesMonitorConfigFormBean, anaesMonitorConfig);
				anaesMonitorConfig.setRegOptId(searchBean.getRegOptId());
				anaesMonitorConfigList.add(anaesMonitorConfig);
			}

			BasAnaesMonitorConfig anaesMonitorConfig = new BasAnaesMonitorConfig();
			BeanUtils.copyProperties(O2, anaesMonitorConfig);
			anaesMonitorConfig.setRegOptId(searchBean.getRegOptId());
			anaesMonitorConfig.setEventId(MyObserveDataController.O2_EVENT_ID);
			anaesMonitorConfigList.add(anaesMonitorConfig);

			basAnaesMonitorConfigService.saveAnaesMonitorConfig(anaesMonitorConfigList);

			result.put("leftShowList", leftShowList);
		}

		// 安全核查单
		DocAnaesBeforeSafeCheck anaesBeforeSafeCheck = docAnaesBeforeSafeCheckService.searchAnaBeCheckByRegOptId(opt.getRegOptId());
		DocExitOperSafeCheck exitOperSafeCheck = docExitOperSafeCheckService.searchExitOperCheckByRegOptId(opt.getRegOptId());
		DocOperBeforeSafeCheck operBeforeSafeCheck = docOperBeforeSafeCheckService.searchOperBeCheckByRegOptId(opt.getRegOptId());

		// 去除O2
		List<BasMonitorConfig> monitorConfigList = basMonitorConfigService.selectMustShowListWithoutO2();
		List<SysCodeFormbean> analgesias = basSysCodeService.searchSysCodeByGroupId("pat_analgesia", searchBean.getBeid());

		result.put("resultCode", "1");
		result.put("resultMessage", "查询麻醉记录单成功!!!");
		result.put("regOpt", opt);
		result.put("anaesBeforeSafeCheck", anaesBeforeSafeCheck.getProcessState());
		result.put("exitOperSafeCheck", exitOperSafeCheck.getProcessState());
		result.put("operBeforeSafeCheck", operBeforeSafeCheck.getProcessState());
		result.put("anaesRecord", anaesRecord);
		result.put("anaesMedEvtList", anaesMedEvtList);
		result.put("treatMedEvtList", treatMedEvtList);
		result.put("analgesicMedEvtList", analgesicMedEvtList);
		result.put("realAnaesList", realAnaesList);
		result.put("optLatterDiagList", optLatterDiagList);
		result.put("optRealOperList", optRealOperList);
		result.put("anaeseventList", anaeseventList);
		result.put("transfusioninIoeventList", transfusioninIoeventList);
		result.put("bloodinIoeventList", bloodinIoeventList);
		result.put("outIoeventList", egressList);
		result.put("anesDocList", anesDocList);
		result.put("operatDocList", operatDocList);
		result.put("nurseList", nurseList);
		result.put("instruNurseList", instruNurseList);
		result.put("operBodyList", operBodyList);
		result.put("O2", O2);// 氧流量
		result.put("monitorConfigList", monitorConfigList);
		result.put("analgesias", analgesias); //病人自控镇痛方式
		//logger.info("startOper---result-------" + JsonType.jsonType(result));
		logger.info("------------------end startOper------------------------");
		return JsonType.jsonType(result);
	}

	/**
	 * 正常结束手术，发送采集数据模块，并发送采集服务
	 * 
	 * @return
	 */
	@RequestMapping("/endOperation")
	@ResponseBody
	@ApiOperation(value = "正常结束手术", httpMethod = "POST", notes = "正常结束手术")
	public String endOperation(@ApiParam(name = "params", value = "参数") @RequestBody EndOperationFormBean formBean) {
		logger.info("----------------start endOperation------------------------");
		ResponseValue res = new ResponseValue();
		EvtAnaesEvent anaesevent = formBean.getAnaesevent();
		logger.info("endOperation----" + anaesevent);
		String regOptId = formBean.getRegOptId();
		if (anaesevent != null) {
		    SearchFormBean searchBean = new SearchFormBean();
		    searchBean.setDocId(anaesevent.getDocId());
		    List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
		    if (null != resultList && resultList.size() > 0)
		    {
		        for (EvtAnaesEvent event : resultList)
		        {
		            if (EvtAnaesEventService.OUT_ROOM.equals(event.getCode()))
		            {
		                anaesevent.setAnaEventId(event.getAnaEventId());
		                break;
		            }
		        }
		    }
		    
			evtAnaesEventService.saveAnaesevent(anaesevent, res);
			if (res.getResultCode().equals("1")) { // 只有成功了，才执行正常结束手术命令
				CmdMsg msg = new CmdMsg();
				msg.setMsgType(MyConstants.OPERATION_STATUS_END);
				msg.setRegOptId(regOptId);
				res = MessageProcess.process(msg);
			}
			res.put("resultList", resultList);
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}
		logger.info("------------------end endOperation------------------------");
		return res.getJsonStr();
	}

	/**
	 * 强制结束手术，发送采集数据模块，并发送采集服务
	 * 
	 * @return
	 */
	@RequestMapping("/forceEndOper")
	@ResponseBody
	@ApiOperation(value = "强制结束手术", httpMethod = "POST", notes = "强制结束手术")
	public String forceEndOper(@ApiParam(name = "params", value = "参数") @RequestBody CmdMsg msg) {
		logger.info("----------------start forceEndOper------------------------");
		ResponseValue res = new ResponseValue();
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setOperRoomId(Global.getConfig("roomId").toString());
		baseQuery.setState(OperationState.SURGERY);
		// 判断当前手术室是否存在未完成的手术，如果存在则返回错误消息
		List<SearchOperaPatrolRecordFormBean> operaPatrolList = basRegOptService.getOperaPatrolRecordListByRoomId(baseQuery);
		List<String> regOptIds = new ArrayList<String>();
		if (operaPatrolList.size() > 0) {
			for (int i = 0; i < operaPatrolList.size(); i++) {
				String regOptId = operaPatrolList.get(i).getRegOptId();
				regOptIds.add(regOptId);
			}
			if (null != regOptIds && regOptIds.size() > 0) {
				basRegOptService.forceEndOperation(regOptIds);
			}
			// 发送结束手术的命令
			if (StringUtils.isNotBlank(msg.getMsgType())) {
				if (StringUtils.isNotBlank(msg.getRegOptId())) {
					res = MessageProcess.process(msg);
				}
			}
		}
		logger.info("------------------end forceEndOper------------------------");
		return res.getJsonStr();
	}

	/**
	 * 终止手术 觉得手术不宜做，直接终止手术
	 * 
	 * @return
	 */
	@RequestMapping("/suspendOperation")
	@ResponseBody
	@ApiOperation(value = "终止手术", httpMethod = "POST", notes = "终止手术")
	public String suspendOperation(@ApiParam(name = "params", value = "参数") @RequestBody SuspendFormBean bean) {
		logger.info("----------------start suspendOperation------------------------");
		ResponseValue res = new ResponseValue();
		basRegOptService.suspendOperation(bean);
		// 发送结束手术的命令
		if (StringUtils.isNotBlank(bean.getMsgType())) {
			CmdMsg msg = new CmdMsg();
			msg.setMsgType(bean.getMsgType());
			msg.setRegOptId(bean.getRegOptId());
			res = MessageProcess.process(msg);
		}

		logger.info("----------------end suspendOperation------------------------");
		return res.getJsonStr();
	}

	/**
	 * 修改入室时间 时间往前修改，时间往后修改 往后修改，时间高于手术开始命令时间，不做数据处理操作
	 * 往前修改，时间低于手术开始命令时间，先删除原有的不对的数据，然后再添加以频率（第一个点的频率）算好的对应的点 入室事件
	 * 需要记录到s_anaesevent,并将时间存入d_anaesrecord 麻醉记录单中
	 * 
	 * @return
	 */
	@RequestMapping("/updateEnterRoomTime")
	@ResponseBody
	@ApiOperation(value = "修改入室时间", httpMethod = "POST", notes = "修改入室时间")
	public String updateEnterRoomTime(@ApiParam(name = "params", value = "参数") @RequestBody EnterRoomFormBean formBean) {
		// 1、从b_reg_opt表中获取发起手术命令时间
		// 2、比对传入的入室时间和发起手术命令时间的大小 分支：2.1：入室时间大于手术时间，则不修改，删除无用数据，记录事件，并修改入室时间；
		// 2.2：入室时间小于手术时间，删除无用数据，根据当前手术时间往前推freq的值，存入b_monitor_display表中，记录事件，并修改入室时间；
		// 3、根据手术命令时间，查询当前手术的点和freq
		logger.info("----------------start updateEnterRoomTime------------------------");
		ResponseValue res = new ResponseValue();
		String regOptId = formBean.getRegOptId();
		Date inTime = formBean.getInTime();
		String docId = formBean.getDocId();
		if (StringUtils.isNotBlank(regOptId) && inTime != null && StringUtils.isNotBlank(docId)) {

			BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
			if (null == regOpt) {
				logger.info("updateEnterRoomTime----regOpt手术为null！--------------");
				res.setResultCode("10000000");
				res.setResultMessage("查询数据有误，请与系统管理员联系!");
			} else {
				Date operTime = regOpt.getOperTime();
				if (null == operTime) {
					logger.info("updateEnterRoomTime----operTime手术时间为null！--------------");
					res.setResultCode("10000000");
					res.setResultMessage("查询数据有误，请与系统管理员联系!");
				} else {
					long inTimeLong = inTime.getTime();
					long operTimeLong = operTime.getTime();
					formBean.setOperTime(operTime);
					if (inTimeLong > operTimeLong) { // 入室时间大于手术命令开始时间
						// 1、根据手术命令时间，删除没有用的数据
						// 2、记录事件，并修改入室时间
						basMonitorDisplayService.updateEnterRoomTimegt(formBean, res);
					} else if (inTimeLong < operTimeLong) {// 入室时间小于手术命令开始时间
						// 1、根据手术命令时间，删除没有用的数据
						// 2、根据当前手术时间往前推freq的值，存入b_monitor_display表中
						// 3、记录事件，并修改入室时间
						basMonitorDisplayService.updEnterRoomTimelt(formBean, res);
					} else { // = 不处理

					}
				}
			}

			// 根据docId查询对应的事件id
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(docId);
			List<EvtAnaesEvent> resultList = evtAnaesEventService.searchAnaeseventList(searchBean);
			res.put("anaeseventList", resultList);

		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}

		logger.info("----------------end updateEnterRoomTime------------------------");
		return res.getJsonStr();
	}

	/**
	 * 
	 * 查询数字部分的监测项
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/queryAllMonitorConfig")
	@ResponseBody
	@ApiOperation(value = "查询监测项", httpMethod = "POST", notes = "查询监测项")
	public String getMonitorConfig(@ApiParam(name = "params", value = "参数") @RequestBody Map map) {
		logger.info("----------------start queryAllMonitorConfig------------------------");
		ResponseValue res = new ResponseValue();
		List<BasMonitorConfig> monitorConfigList = basMonitorConfigService.queryAllMonitorConfig();

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId((String) map.get("regOptId"));
		baseQuery.setPosition("1");
		List<BasAnaesMonitorConfigFormBean> anaesMonitorConfigList = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		if (null != monitorConfigList && monitorConfigList.size() > 0) {
			for (BasMonitorConfig monitorConfig : monitorConfigList) {
				// 将监测项设置为未勾选
				monitorConfig.setMustShow("0");
				if (null != anaesMonitorConfigList && anaesMonitorConfigList.size() > 0) {
					for (BasAnaesMonitorConfigFormBean anaesMonitorConfig : anaesMonitorConfigList) {
						// 如果监测项在b_anaes_monitor_config表中，则设置为勾选
						if (anaesMonitorConfig.getEventId().equals(String.valueOf(monitorConfig.getEventId()))) {
							monitorConfig.setMustShow("1");
							break;
						}
					}
				}
			}
		}
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		res.put("monitorConfigList", monitorConfigList);
		logger.info("----------------end queryAllMonitorConfig------------------------");
		return res.getJsonStr();
	}

	/**
	 * 修改数字部分监测项的显示字段
	 * 
	 * @param monitorConfigList
	 * @return
	 */
	@RequestMapping("/updMonitorConfig")
	@ResponseBody
	@ApiOperation(value = "修改数字部分监测项的显示字段", httpMethod = "POST", notes = "修改数字部分监测项的显示字段")
	public String updMonitorConfig(@ApiParam(name = "params", value = "参数") @RequestBody List<BasAnaesMonitorConfig> anaesMonitorConfigList) {
		logger.info("----------------start updMonitorConfig------------------------");
		ResponseValue res = new ResponseValue();
		if (null != anaesMonitorConfigList && anaesMonitorConfigList.size() > 0) {
			basAnaesMonitorConfigService.saveAnaesMonitorConfig(anaesMonitorConfigList);
			res.setResultCode("1");
			res.setResultMessage("修改成功！");
			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setRegOptId(anaesMonitorConfigList.get(0).getRegOptId());
			baseQuery.setPosition("1");
			res.put("monitorConfigList", basAnaesMonitorConfigService.finaAnaesListWithoutO2(baseQuery));
		}

		logger.info("----------------end updMonitorConfig------------------------");
		return res.getJsonStr();
	}

	/**
	 * 数字部分：获取历史数据，需分页
	 * 
	 * @param formbean
	 * @return
	 */
	@RequestMapping("/getmonData")
	@ResponseBody
	@ApiOperation(value = "获取监测项分页历史数据", httpMethod = "POST", notes = "获取监测项分页历史数据")
	public String getmonData(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getmonData------------------------");
		ResponseValue res = new ResponseValue();
		String regOptId = formBean.getRegOptId();
		if (StringUtils.isBlank(regOptId)) {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("----------------end getmonData------------------------");
			return res.getJsonStr();
		}

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		List<String> observeIds = new ArrayList<String>();

		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean mc : anaesLists) {
				if (!observeIds.contains(mc.getEventId() + "")) {
					observeIds.add(mc.getEventId() + "");
				}
			}
		}
		List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(formBean, observeIds);
		Map<Date, List<BasMonitorDisplay>> map = new TreeMap<Date, List<BasMonitorDisplay>>();
		List<BasMonitorDisplay> mds = null;
		if (null != monitorList && monitorList.size() > 0) {
			for (BasMonitorDisplay md : monitorList) {
				Date time = md.getTime();
				if (!map.containsKey(time)) {
					mds = new ArrayList<BasMonitorDisplay>();
					mds.add(md);
					map.put(time, mds);
				} else {
					mds = map.get(time);
					mds.add(md);
					map.put(time, mds);
				}
			}
		} else {
			// 无采集数据
			logger.info("----------无采集数据----------------");
		}

		List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
		MonDataFormBean monData = null;
		MonitorData monitorData = null;

		if (!map.isEmpty() && map.size() > 0) {
			// int i = 0;
			int index = 0;
			// 循环seriesMap中的数据
			for (Date key : map.keySet()) {
				// if(i%3==0){
				monData = new MonDataFormBean();
				List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
				List<BasMonitorDisplay> list = map.get(key);
				monData.setTime(key);
				monData.setIndex(index++);
				if (null != list && list.size() > 0) {
					for (BasMonitorDisplay md : list) {
						Integer freq = md.getFreq();
						if (null != freq) {
							monData.setFreq(freq);
						}
						monitorData = new MonitorData();
						BeanUtils.copyProperties(md, monitorData);
						monitorDataList.add(monitorData);
					}
				}
				monData.setMonitorDataList(monitorDataList);
				monDataList.add(monData);
				// }
				// i++;
			}
		}

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);

		res.setResultCode("1");
		res.setResultMessage("查询监测项数据成功！");
		res.put("total", total);
		res.put("monDataList", monDataList);
		logger.info("----------------end getmonData------------------------");
		return res.getJsonStr();
	}

	/**
	 * 数字部分：获取新点
	 * 
	 * @param formbean
	 * @return
	 */
	@RequestMapping("/getmonDataNew")
	@ResponseBody
	@ApiOperation(value = "数字部分：获取新点", httpMethod = "POST", notes = "数字部分：获取新点")
	public String getmonDataNew(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("------------------start  getmonDataNew---------------------------");
		ResponseValue res = new ResponseValue();
		String regOptId = formBean.getRegOptId();
		if (StringUtils.isBlank(regOptId)) {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("----------------end getmonDataNew------------------------");
			return res.getJsonStr();
		}

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);

		List<String> observeIds = new ArrayList<String>();

		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean mc : anaesLists) {
				if (!observeIds.contains(mc.getEventId() + "")) {
					observeIds.add(mc.getEventId() + "");
				}
			}
		}
		List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getMonDataNew(formBean, observeIds);
		Map<Date, List<BasMonitorDisplay>> map = new TreeMap<Date, List<BasMonitorDisplay>>();
		List<BasMonitorDisplay> mds = null;
		if (null != monitorList && monitorList.size() > 0) {
			for (BasMonitorDisplay md : monitorList) {
				Date time = md.getTime();
				if (!map.containsKey(time)) {
					mds = new ArrayList<BasMonitorDisplay>();
					mds.add(md);
					map.put(time, mds);
				} else {
					mds = map.get(time);
					mds.add(md);
					map.put(time, mds);
				}
			}
		} else {
			// 无采集数据
			logger.info("----------无采集数据----------------");
		}

		List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
		MonDataFormBean monData = null;
		MonitorData monitorData = null;
		if (!map.isEmpty() && map.size() > 0) {
			// 循环seriesMap中的数据
			for (Date key : map.keySet()) {
				monData = new MonDataFormBean();
				List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
				List<BasMonitorDisplay> list = map.get(key);
				monData.setTime(key);
				if (null != list && list.size() > 0) {
					for (BasMonitorDisplay md : list) {
						Integer freq = md.getFreq();
						if (null != freq) {
							monData.setFreq(freq);
						}
						monitorData = new MonitorData();
						BeanUtils.copyProperties(md, monitorData);
						monitorDataList.add(monitorData);
					}
				}
				monData.setMonitorDataList(monitorDataList);
				monDataList.add(monData);
			}
		}

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);
		res.setResultCode("1");
		res.setResultMessage("查询监测项数据成功！");
		res.put("total", total);
		res.put("monDataList", monDataList);
		logger.info("------------------end  getmonDataNew---------------------------");
		return res.getJsonStr();
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping("/printObserveData")
	@ResponseBody
	@ApiOperation(value = "获取打印数据", httpMethod = "POST", notes = "获取打印数据")
	public Map printObserveData(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getPrintObserveData------------------------");
		Map map = new HashMap();
		basMonitorDisplayService.printObserveData(formBean, map);
		logger.info("----------------end getPrintObserveData------------------------");
		return map;
	}

	/**
	 * 后台不分页，但根据每页分组给前端数据
	 * 
	 * @param formBean
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/getPrintObserveData")
	@ResponseBody
	@ApiOperation(value = "分组获取打印数据", httpMethod = "POST", notes = "分组获取打印数据")
	public Map getPrintObserveData(@ApiParam(name = "params", value = "参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getPrintObserveData------------------------");
		Map map = new HashMap();
		List<MonitorDataPage> mdPageList = new ArrayList<MonitorDataPage>();

		// 获取需要显示的数据
		String regOptId = formBean.getRegOptId();
		if (StringUtils.isBlank(regOptId)) {
			map.put("resultCode", "70000000");
			map.put("resultMessage", Global.getRetMsg(map.get("resultCode").toString()));
			logger.info("----------------end getPrintObserveData------------------------");
			return map;
		}

		int size = 31;
		int pageSize = formBean.getSize();
		if (pageSize == 0) {
			pageSize = size;
		}

		// 查询入室时间
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
		if (null != anaesRecord) {
			String inTime = anaesRecord.getInOperRoomTime();
			Date inTimeDate = null;
			if (StringUtils.isNotBlank(inTime)) {
				inTimeDate = SysUtil.getDate(inTime);
				formBean.setInTime(inTimeDate);
			} else {
				map.put("resultCode", "70000000");
				map.put("resultMessage", "入室时间不能为空！");
				logger.info("----------------end getPrintObserveData------------------------");
				return map;
			}

		} else {
			map.put("resultCode", "70000000");
			map.put("resultMessage", "麻醉记录单没有查询到记录！");
			logger.info("----------------end getPrintObserveData------------------------");
			return map;
		}

		Integer position = 0;
		String beid = formBean.getBeid();

		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition(position + "");
		baseQuery.setEnable("1");
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		List<String> observeIds = new ArrayList<String>();

		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
				String observeId = bean.getEventId();
				// 获取显示项需要的observeIds
				observeIds.add(observeId);
			}
		}

		// 数字部分的obsIds
		baseQuery.setPosition("1");
		List<BasAnaesMonitorConfigFormBean> anaesNumberLists = basAnaesMonitorConfigService.finaAnaesList(baseQuery);
		// List<BasMonitorConfig> monitorConfigList =
		// basMonitorConfigService.selectMustShowList();

		// 获取当前频率
		String currentModel = basRegOptService.getCurrentModel(formBean.getRegOptId());
		BasMonitorConfigFreq monitorFreq = basMonitorConfigFreqService.searchMonitorFreqByType(currentModel);
		String f = "";
		Integer curfreq = 0;
		if (monitorFreq != null) {
			f = monitorFreq.getValue();
			curfreq = Integer.valueOf(f);
		}

		// 获取呼吸事件列表
		List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchBreathListOrder(regOptId);
		CtlBreathDateFormBean cbFormBean = null;
		List<CtlBreathDateFormBean> cbList = new ArrayList<CtlBreathDateFormBean>();

		if (null != ctlBreathList && ctlBreathList.size() > 0) {
			for (int i = 0; i < ctlBreathList.size(); i++) {
				EvtCtlBreath ctlBreath = ctlBreathList.get(i);
				int curState = ctlBreath.getCurrentState();
				int type = ctlBreath.getType();
				if (1 == curState) {
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formBean.getBeid());
					if (null != scList && scList.size() > 0) {
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
					}
					cbList.add(cbFormBean);
				} else {
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setEndTime(cbList.get(cbList.size() - 1).getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeService.searchSysCodeByGroupIdAndCodeName("breath_event", type + "", formBean.getBeid());
					if (null != scList && scList.size() > 0) {
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
					}
					cbList.add(cbFormBean);
				}
			}
		}

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);

		if (total == 0) {
			map.put("resultCode", "1");
			map.put("resultMessage", "当前患者采集点数据暂无！");
			map.put("mdPageList", mdPageList);
			return map;
		} else {
			int no = total / pageSize; // 页码
			int mod = total % pageSize;
			if (no == 0) {
				if (0 != mod) {
					no = no + 1;
				}
				// 只有1页的数据
				formBean.setNo(no);
				formBean.setSize(pageSize);

				List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
				XAxisData1 xaisData = null;
				List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

				// 建造yAxis数据
				List<YAxisData> yAxis = new ArrayList<YAxisData>();
				YAxisData yd = null;
				yd = new YAxisData();
				yd.setType("value");
				yd.setMax(180);
				yd.setMin(0);
				yd.setOrder(1);
				yAxis.add(yd);
				yd = new YAxisData();
				yd.setType("value");
				yd.setMax(60);
				yd.setMin(30);
				yd.setOrder(2);
				yAxis.add(yd);
				Collections.sort(yAxis);

				List<SeriesData> series = new ArrayList<SeriesData>();
				SeriesData seriesdata = null;
				List<SeriesDataObj> da = null;
				SeriesDataObj obj = null;
				Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();

				if (null != anaesLists && anaesLists.size() > 0) {
					for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
						String observeId = bean.getEventId();
						// 获取显示项需要的observeIds
						observeIds.add(observeId);
						String observeName = bean.getEventName();
						String color = bean.getColor();// 对应图标
						String icon = bean.getIconId();// 对应颜色
						String units = bean.getUnits(); // 默认单位
						String svg = basIconSvgService.getPathByIcon(bean.getIconId(), beid);
						Float max = bean.getMax(); // max
						Float min = bean.getMin(); // min
						// ABP_HR，CVP，℃
						if (observeId.equals(NP_TEMP_POSITION_RT) || observeId.equals(RE_TEMP_POSITION_RT) || observeId.equals(NP_TEMP_POSITION_LINE) || observeId.equals(RE_TEMP_POSITION_LINE) || observeId.equals(TEMP_POSITION_RT) || observeId.equals(TEMP_POSITION_LINE)) { // 如果是温度，则y轴为2
							seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 2, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
						} else if (observeId.equals(CVP_MEAN_POSITION_RT) || observeId.equals(CVP_MEAN_POSITION_LINE)) { // cvp,则y轴为1
							seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 1, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
						} else {// abp_hp等,y轴为0
							seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 0, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
						}
					}
				}

				// 数字部分的obsIds
				List<String> obsIds = new ArrayList<String>();
				if (null != anaesNumberLists && anaesNumberLists.size() > 0) {
					for (BasAnaesMonitorConfigFormBean mc : anaesNumberLists) {
						if (!obsIds.contains(mc.getEventId() + "")) {
							obsIds.add(mc.getEventId() + "");
						}
					}
				}

				List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(formBean, observeIds);

				Date t = new Date(1L);
				if (null != monitorList && monitorList.size() > 0) {
					for (int i = 0; i < monitorList.size(); i++) {
						BasMonitorDisplay md = monitorList.get(i);
						String key = md.getObserveId();
						Date time = md.getTime();

						if (t.getTime() != time.getTime()) {
							t = time;
							XAxisDataBean bean = new XAxisDataBean();
							bean.setValue(t);
							Integer freq = md.getIntervalTime();
							bean.setFreq(freq);
							data.add(bean);
						}

						// series
						if (!seriesMap.containsKey(key)) {
							logger.info("------------------没有当前key" + key + "------------------------");
						} else {
							seriesdata = seriesMap.get(key);
							da = seriesdata.getData();
							seriesdata.setType("line");
							seriesdata.setName(md.getObserveName());
							// 设置指定对应的y轴
							// 设置指定对应的y轴
							if (NP_TEMP_POSITION_LINE.equals(md.getObserveId()) || NP_TEMP_POSITION_RT.equals(md.getObserveId()) || RE_TEMP_POSITION_LINE.equals(md.getObserveId()) || RE_TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_LINE.equals(md.getObserveId())) {
								seriesdata.setyAxisIndex(2);
							} else if (CVP_MEAN_POSITION_LINE.equals(md.getObserveId()) || CVP_MEAN_POSITION_RT.equals(md.getObserveId())) {
								seriesdata.setyAxisIndex(1);
							} else {
								seriesdata.setyAxisIndex(0);
							}
							// seriesdata.setSymbolSize(8);
							// 增加呼吸事件图标的判断
							if (RESP_EVENT_ID.equals(md.getObserveId())) {
								if (null != cbList && cbList.size() > 0) {
									int flag = -1;
									for (CtlBreathDateFormBean cb : cbList) {
										Date st = cb.getStartTime();
										Date et = cb.getEndTime();
										// logger.info("getobsData----st="+st+",et="+et+",time="+time);
										if (null != et) {
											if (time.getTime() >= st.getTime() && time.getTime() < et.getTime()) {
												obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue());
												flag = 0;
												break;
											}
										} else {
											if (time.getTime() >= st.getTime()) {
												obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue());
												flag = 0;
												break;
											}
										}
									}
									if (flag == -1) {
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
									}
								} else {
									obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
								}
							} else {
								obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
							}

							da.add(obj);
							seriesdata.setData(da);
							seriesMap.put(key, seriesdata);
						}

					}

				} else {
					// 无采集数据
					logger.info("----------无采集数据----------------");
				}

				// 循环seriesMap中的数据
				for (String key : seriesMap.keySet()) {
					SeriesData sd = seriesMap.get(key);
					series.add(sd);
				}

				// 添加times到x轴
				xaisData = new XAxisData1();
				xaisData.setData(data);
				xAxis.add(xaisData);

				// 获取数字部分
				List<BasMonitorDisplay> monitorDisplayList = basMonitorDisplayService.getobsData(formBean, obsIds);
				Map<Date, List<BasMonitorDisplay>> tableMap = new TreeMap<Date, List<BasMonitorDisplay>>();
				List<BasMonitorDisplay> mds = null;
				if (null != monitorDisplayList && monitorDisplayList.size() > 0) {
					for (BasMonitorDisplay md : monitorDisplayList) {
						Date time = md.getTime();
						if (!tableMap.containsKey(time)) {
							mds = new ArrayList<BasMonitorDisplay>();
							mds.add(md);
							tableMap.put(time, mds);
						} else {
							mds = tableMap.get(time);
							mds.add(md);
							tableMap.put(time, mds);
						}
					}
				} else {
					// 无采集数据
					logger.info("----------无采集数据----------------");
				}

				List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
				MonDataFormBean monData = null;
				MonitorData monitorData = null;

				if (!tableMap.isEmpty() && tableMap.size() > 0) {
					// int i = 0;
					int index = 0;
					// 循环seriesMap中的数据
					for (Date key : tableMap.keySet()) {
						// if(i%3==0){
						monData = new MonDataFormBean();
						List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
						List<BasMonitorDisplay> list = tableMap.get(key);
						monData.setTime(key);
						monData.setIndex(index++);
						if (null != list && list.size() > 0) {
							for (BasMonitorDisplay md : list) {
								Integer fre = md.getFreq();
								if (null != fre) {
									monData.setFreq(fre);
								}
								monitorData = new MonitorData();
								BeanUtils.copyProperties(md, monitorData);
								monitorDataList.add(monitorData);
							}
						}
						monData.setMonitorDataList(monitorDataList);
						monDataList.add(monData);
						// }
						// i++;
					}
				}

				MonitorDataPage page = new MonitorDataPage();
				page.setxAxis(xAxis);
				page.setyAxis(yAxis);
				page.setSeries(series);
				page.setMonDataList(monDataList);
				page.setFreq(curfreq); // 发送当前频率
				mdPageList.add(page);
				map.put("resultCode", "1");
				map.put("resultMessage", "操作成功！");
				map.put("mdPageList", mdPageList);
				logger.info("------------------end getPrintObserveData------------------------");
				return map;

			} else if (no > 0) { // 多页分组
				if (0 != mod) {
					no = no + 1;
				}
				for (int j = 0; j < no; j++) {
					int pageNo = j + 1;
					formBean.setNo(pageNo);
					formBean.setSize(pageSize);

					List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
					XAxisData1 xaisData = null;
					List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

					// 建造yAxis数据
					List<YAxisData> yAxis = new ArrayList<YAxisData>();
					YAxisData yd = null;
					yd = new YAxisData();
					yd.setType("value");
					yd.setMax(180);
					yd.setMin(0);
					yd.setOrder(1);
					yAxis.add(yd);
					yd = new YAxisData();
					yd.setType("value");
					yd.setMax(60);
					yd.setMin(30);
					yd.setOrder(2);
					yAxis.add(yd);
					Collections.sort(yAxis);

					List<SeriesData> series = new ArrayList<SeriesData>();
					SeriesData seriesdata = null;
					List<SeriesDataObj> da = null;
					SeriesDataObj obj = null;
					Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();

					if (null != anaesLists && anaesLists.size() > 0) {
						for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
							String observeId = bean.getEventId();
							// 获取显示项需要的observeIds
							observeIds.add(observeId);
							String observeName = bean.getEventName();
							String color = bean.getColor();// 对应图标
							String icon = bean.getIconId();// 对应颜色
							String units = bean.getUnits(); // 默认单位
							String svg = basIconSvgService.getPathByIcon(bean.getIconId(), beid);
							Float max = bean.getMax(); // max
							Float min = bean.getMin(); // min
							// ABP_HR，CVP，℃
							if (observeId.equals(NP_TEMP_POSITION_RT) || observeId.equals(RE_TEMP_POSITION_RT) || observeId.equals(NP_TEMP_POSITION_LINE) || observeId.equals(RE_TEMP_POSITION_LINE) || observeId.equals(TEMP_POSITION_RT) || observeId.equals(TEMP_POSITION_LINE)) { // 如果是温度，则y轴为2
								seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 2, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
							} else if (observeId.equals(CVP_MEAN_POSITION_RT) || observeId.equals(CVP_MEAN_POSITION_LINE)) { // cvp,则y轴为1
								seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 1, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
							} else {// abp_hp等,y轴为0
								seriesMap.put(observeId, new SeriesData(observeId, observeName, "line", new ArrayList<SeriesDataObj>(), icon, svg, 0, MyObserveDataController.SYMBOL_OBSDATA, color, units, max, min));
							}

						}
					}

					// 数字部分的obsIds
					List<String> obsIds = new ArrayList<String>();
					if (null != anaesNumberLists && anaesNumberLists.size() > 0) {
						for (BasAnaesMonitorConfigFormBean mc : anaesNumberLists) {
							if (!obsIds.contains(mc.getEventId() + "")) {
								obsIds.add(mc.getEventId() + "");
							}
						}
					}

					// 获取当页的数据集合
					List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(formBean, observeIds);

					Date t = new Date(1L);
					if (null != monitorList && monitorList.size() > 0) {
						for (int i = 0; i < monitorList.size(); i++) {
							BasMonitorDisplay md = monitorList.get(i);
							String key = md.getObserveId();
							Date time = md.getTime();

							if (t.getTime() != time.getTime()) {
								t = time;
								XAxisDataBean bean = new XAxisDataBean();
								bean.setValue(t);
								Integer freq = md.getIntervalTime();
								bean.setFreq(freq);
								data.add(bean);
							}

							// series
							if (!seriesMap.containsKey(key)) {
								logger.info("------------------没有当前key" + key + "------------------------");
							} else {
								seriesdata = seriesMap.get(key);
								da = seriesdata.getData();
								seriesdata.setType("line");
								seriesdata.setName(md.getObserveName());
								// 设置指定对应的y轴
								if (NP_TEMP_POSITION_LINE.equals(md.getObserveId()) || NP_TEMP_POSITION_RT.equals(md.getObserveId()) || RE_TEMP_POSITION_LINE.equals(md.getObserveId()) || RE_TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_RT.equals(md.getObserveId()) || TEMP_POSITION_LINE.equals(md.getObserveId())) {
									seriesdata.setyAxisIndex(2);
								} else if (CVP_MEAN_POSITION_LINE.equals(md.getObserveId()) || CVP_MEAN_POSITION_RT.equals(md.getObserveId())) {
									seriesdata.setyAxisIndex(1);
								} else {
									seriesdata.setyAxisIndex(0);
								}
								// seriesdata.setSymbolSize(8);

								// 增加呼吸事件图标的判断
								if (RESP_EVENT_ID.equals(md.getObserveId())) {
									if (null != cbList && cbList.size() > 0) {
										int flag = -1;
										for (CtlBreathDateFormBean cb : cbList) {
											Date st = cb.getStartTime();
											Date et = cb.getEndTime();
											// logger.info("getobsData----st="+st+",et="+et+",time="+time);
											if (null != et) {
												if (time.getTime() >= st.getTime() && time.getTime() < et.getTime()) {
													obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue());
													flag = 0;
													break;
												}
											} else {
												if (time.getTime() >= st.getTime()) {
													obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(), cb.getCodeValue());
													flag = 0;
													break;
												}
											}
										}
										if (flag == -1) {
											obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
										}
									} else {
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
									}
								} else {
									obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
								}

								da.add(obj);
								seriesdata.setData(da);
								seriesMap.put(key, seriesdata);
							}

						}

					} else {
						// 无采集数据
						logger.info("----------无采集数据----------------");
					}

					// 循环seriesMap中的数据
					for (String key : seriesMap.keySet()) {
						SeriesData sd = seriesMap.get(key);
						series.add(sd);
					}

					// 添加times到x轴
					xaisData = new XAxisData1();
					xaisData.setData(data);
					xAxis.add(xaisData);

					// 获取数字部分
					List<BasMonitorDisplay> monitorDisplayList = basMonitorDisplayService.getobsData(formBean, obsIds);
					Map<Date, List<BasMonitorDisplay>> tableMap = new TreeMap<Date, List<BasMonitorDisplay>>();
					List<BasMonitorDisplay> mds = null;
					if (null != monitorDisplayList && monitorDisplayList.size() > 0) {
						for (BasMonitorDisplay md : monitorDisplayList) {
							Date time = md.getTime();
							if (!tableMap.containsKey(time)) {
								mds = new ArrayList<BasMonitorDisplay>();
								mds.add(md);
								tableMap.put(time, mds);
							} else {
								mds = tableMap.get(time);
								mds.add(md);
								tableMap.put(time, mds);
							}
						}
					} else {
						// 无采集数据
						logger.info("----------无采集数据----------------");
					}

					List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
					MonDataFormBean monData = null;
					MonitorData monitorData = null;

					if (!tableMap.isEmpty() && tableMap.size() > 0) {
						// int i = 0;
						int index = 0;
						// 循环seriesMap中的数据
						for (Date key : tableMap.keySet()) {
							// if(i%3==0){
							monData = new MonDataFormBean();
							List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
							List<BasMonitorDisplay> list = tableMap.get(key);
							monData.setTime(key);
							monData.setIndex(index++);
							if (null != list && list.size() > 0) {
								for (BasMonitorDisplay md : list) {
									Integer fre = md.getFreq();
									if (null != fre) {
										monData.setFreq(fre);
									}
									monitorData = new MonitorData();
									BeanUtils.copyProperties(md, monitorData);
									monitorDataList.add(monitorData);
								}
							}
							monData.setMonitorDataList(monitorDataList);
							monDataList.add(monData);
							// }
							// i++;
						}
					}

					MonitorDataPage page = new MonitorDataPage();
					page.setxAxis(xAxis);
					page.setyAxis(yAxis);
					page.setSeries(series);
					page.setMonDataList(monDataList);
					page.setFreq(curfreq);
					mdPageList.add(page);

				}
				map.put("resultCode", "1");
				map.put("resultMessage", "操作成功！");
				map.put("mdPageList", mdPageList);
				logger.info("------------------end getPrintObserveData------------------------");
				return map;
			}
		}

		logger.info("------------------end getPrintObserveData------------------------");
		return map;
	}

	/**
	 * -- 当前医生或护士下面的手术（包含手术中未完成的手术和当前登录用户下的术前的手术），以及下面部分所有人当天的手术；
	 * 
	 * 当天所有的手术
	 */
	@RequestMapping("/getDayOper")
	@ResponseBody
	@ApiOperation(value = "当天所有的手术", httpMethod = "POST", notes = "当天所有的手术")
	public String getDayOper() {
		logger.info("------------------start getDayOper------------------------");
		ResponseValue res = new ResponseValue();
		List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> resultList = basRegOptService.searchDayRegOpt(Global.getConfig("roomId").toString(), DateUtils.getDate());
		res.put("resultList", resultList);
		String operRoomName = resultList.size() > 0 ? resultList.get(0).getOperRoomName() : basOperroomService.queryRoomListById(Global.getConfig("roomId").toString()).getName();
		res.put("operRoomName", operRoomName);
		res.put("roomId", Global.getConfig("roomId").toString());

		logger.info("------------------end getDayOper------------------------");
		return res.getJsonStr();
	}

	/**
	 * -- 当前麻醉医生或巡回护士下面的手术（包含当前手术室下术中的手术和当前登录用户下的术前的手术） 麻醉医生只显示全麻的术前手术
	 * 巡回护士显示全麻和局麻的术前手术；
	 * 
	 * 当前用户下的手术（麻醉医生和巡回护士）
	 */
	@RequestMapping("/getCurUserOper")
	@ResponseBody
	@ApiOperation(value = "当前用户下的手术", httpMethod = "POST", notes = "当前用户下的手术")
	public String getCurUserOper(@ApiParam(name = "params", value = "参数") @RequestBody JSONObject json) {
		logger.info("------------------start getCurUserOper------------------------");
		ResponseValue res = new ResponseValue();
		String userId = json.get("userId").toString();
		List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> resultList = basRegOptService.searchCurUserRegOpt(Global.getConfig("roomId").toString(), DateUtils.getDate(), userId);
		res.put("resultList", resultList);
		String operRoomName = resultList.size() > 0 ? resultList.get(0).getOperRoomName() : basOperroomService.queryRoomListById(Global.getConfig("roomId").toString()).getName();
		res.put("operRoomName", operRoomName);
		res.put("roomId", Global.getConfig("roomId").toString());
		logger.info("------------------end getCurUserOper------------------------");
		return res.getJsonStr();
	}

	/**
	 * 查询历史记录
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/queryAllRegOpt")
	@ResponseBody
	@ApiOperation(value = "查询所有手术", httpMethod = "POST", notes = "查询所有手术")
	public String queryAllRegOpt(@ApiParam(name = "params", value = "参数") @RequestBody RegOptFormBean bean) {
		logger.info("------------------start queryAllRegOpt------------------------");
		ResponseValue res = new ResponseValue();
		String roomId = Global.getConfig("roomId").toString();
		bean.setRoomId(roomId);
		List<SearchRegOptByRoomIdAndOperDateAndStateFormBean> resultList = basRegOptService.queryAllRegOpt(bean);
		res.put("resultList", resultList);
		String operRoomName = resultList.size() > 0 ? resultList.get(0).getOperRoomName() : basOperroomService.queryRoomListById(Global.getConfig("roomId").toString()).getName();
		res.put("operRoomName", operRoomName);
		res.put("roomId", Global.getConfig("roomId").toString());
		logger.info("------------------end queryAllRegOpt------------------------");
		return res.getJsonStr();
	}

	@RequestMapping("/getPupilData")
	@ResponseBody
	@ApiOperation(value = "getPupilData", httpMethod = "POST", notes = "getPupilData")
	public String getPupilData(@ApiParam(name = "formBean", value = "查询参数") @RequestBody MonitorDataFormBean formBean) {
		logger.info("----------------start getPupilData------------------------");
		ResponseValue res = new ResponseValue();
		String regOptId = formBean.getRegOptId();
		if (StringUtils.isBlank(regOptId)) {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			logger.info("----------------end getPupilData------------------------");
			return res.getJsonStr();
		}
		// Integer position = 1;
		// List<Observe> observes =
		// observeService.searchMonitorsDispList(regOptId, position);
		List<BasMonitorConfig> monitorConfigList = basMonitorConfigService.selectMustShowList();
		List<String> observeIds = new ArrayList<String>();

		if (null != monitorConfigList && monitorConfigList.size() > 0) {
			for (BasMonitorConfig mc : monitorConfigList) {
				if (!observeIds.contains(mc.getEventId() + "")) {
					observeIds.add(mc.getEventId() + "");
				}
			}
		}

		List<BasMonitorDisplay> monitorList = basMonitorDisplayService.getobsData(formBean, observeIds);
		TreeMap<Date, Integer> treeMap = new TreeMap<Date, Integer>();
		if (null != monitorList && monitorList.size() > 0) {
			for (int i = 0; i < monitorList.size(); i++) {
				BasMonitorDisplay md = monitorList.get(i);
				Date time = md.getTime();
				if (!treeMap.containsKey(time)) {
					treeMap.put(time, i);
				} else {
					treeMap.put(time, i);
				}
			}
		} else {
			// 无采集数据
			logger.info("treeMap----------无采集数据----------------");
		}

		List<MonitorPupilFormBean> mpList = new ArrayList<MonitorPupilFormBean>();

		if (!treeMap.isEmpty() && treeMap.size() > 0) {
			Date startTime = treeMap.firstKey();
			Date endTime = treeMap.lastKey();
			if (null == startTime) {
				startTime = new Date();
			}
			if (null == endTime) {
				endTime = new Date();
			}
			List<BasMonitorPupil> pupilList = basMonitorPupilService.getPupilList(regOptId, startTime, endTime);

			MonitorPupilFormBean tempBean = null;
			boolean bool = false;
			int index = 0;
			if (null != pupilList && pupilList.size() > 0) {
				for (Date key : treeMap.keySet()) {
					for (int i = 0; i < pupilList.size(); i++) {
						BasMonitorPupil mp = pupilList.get(i);
						if (mp.getTime().getTime() == key.getTime()) {
							MonitorPupilFormBean monitorPupil = new MonitorPupilFormBean();
							BeanUtils.copyProperties(mp, monitorPupil);
							monitorPupil.setIndex(index++);
							// mpList.add(monitorPupil);
							tempBean = monitorPupil;
							bool = true;
							break;
						}
					}
					if (bool) {
						mpList.add(tempBean);
						bool = false;
					} else {
						MonitorPupilFormBean monitorPupil = new MonitorPupilFormBean();
						monitorPupil.setRegOptId(regOptId);
						monitorPupil.setTime(key);
						monitorPupil.setIndex(index++);
						mpList.add(monitorPupil);
					}
				}

			} else {
				for (Date key : treeMap.keySet()) {
					MonitorPupilFormBean mp = new MonitorPupilFormBean();
					mp.setRegOptId(regOptId);
					mp.setTime(key);
					mp.setIndex(index++);
					mpList.add(mp);
				}
			}

		}

		// 获取总数
		int total = basMonitorDisplayService.getobsDataTotal(formBean, observeIds);

		res.setResultCode("1");
		res.setResultMessage("查询监测项数据成功！");
		res.put("total", total);
		res.put("pupilDataList", mpList);
		logger.info("----------------end getPupilData------------------------");
		return res.getJsonStr();
	}
	
	/**
     * 包含新增和修改
     * @param mp
     * @return
     */
    @RequestMapping("/saveMonitorPupil")
    @ResponseBody
    public String saveMonitorPupil(@RequestBody BasMonitorPupil mp){
        logger.info("----------------start saveMonitorPupil------------------------");
        ResponseValue res = new ResponseValue();
        try {
            String pupilId = basMonitorDisplayService.saveMonitorPupil(mp);
            res.put("pupilId", pupilId);
            res.setResultCode("1");
            res.setResultMessage("操作成功");
        } catch (Exception e) {
            logger.error("saveMonitorPupil---"+Exceptions.getStackTraceAsString(e));
            res.setResultCode("10000000");
            res.setResultMessage("系统错误，请与系统管理员联系!");
        }
        logger.info("------------------end saveMonitorPupil------------------------");
        return res.getJsonStr();
    }
}
