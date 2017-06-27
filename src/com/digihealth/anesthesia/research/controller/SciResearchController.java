package com.digihealth.anesthesia.research.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.research.formbean.LifeSignObserveFormBean;
import com.digihealth.anesthesia.research.formbean.ResearchFormbean;
import com.digihealth.anesthesia.research.formbean.SciArray;
import com.digihealth.anesthesia.research.formbean.SciCompareFormbean;
import com.digihealth.anesthesia.research.formbean.SciResearchFilter;
import com.digihealth.anesthesia.research.formbean.SciResearchFormBean;
import com.digihealth.anesthesia.research.formbean.SciResearchType;
import com.digihealth.anesthesia.research.formbean.SciTempFormBean;
import com.digihealth.anesthesia.tmp.po.TmpSciTemp;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/sci")
@Api(value="SciResearchController",description="模板管理处理类")
public class SciResearchController extends BaseController {

	/**
	 * 从数据库中查询所有的条件
	 * 
	 * @return
	 */
	@RequestMapping("/getAllField")
	@ResponseBody
	@ApiOperation(value="从数据库中查询所有的条件",httpMethod="POST",notes="从数据库中查询所有的条件")
	public String getAllField() {
		logger.info("----------------start getAllField------------------------");
		ResponseValue res = new ResponseValue();
		res.put("fields", tmpSciResearchFieldService.getAllField());
		res.setResultCode("1");
		res.setResultMessage("查询所有记录完成！");
		logger.info("----------------end getAllField------------------------");
		return res.getJsonStr();
	}

	/**
	 * 根据sciId查询当前模板，返回模板内容
	 * 
	 * @param sciId
	 * @return
	 */
	@RequestMapping("/getSciTemp")
	@ResponseBody
	@ApiOperation(value="根据sciId查询当前模板，返回模板内容",httpMethod="POST",notes="根据sciId查询当前模板，返回模板内容")
	public String getSciTemp(@ApiParam(name="sciId", value ="查询参数") @RequestBody String sciId) {
		logger.info("----------------start getSciTemp------------------------");
		ResponseValue res = new ResponseValue();
		TmpSciTemp sciTemp = tmpSciTempService.getSciResearch(sciId);
		res.put("temp", sciTemp);
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		logger.info("----------------end getSciTemp------------------------");
		return res.getJsonStr();
	}

	
	/**
	 * 新增or修改模板temp_json等
	 * 
	 * @return
	 */
	@RequestMapping("/handleSciTemp")
	@ResponseBody
	@ApiOperation(value="新增or修改模板temp_json等",httpMethod="POST",notes="新增or修改模板temp_json等")
	public String handleSciTemp(@ApiParam(name="bean", value ="保存修改参数") @RequestBody ResearchFormbean bean) {
		logger.info("----------------start handleSciTemp------------------------");
		ResponseValue res = new ResponseValue();
		if (null != bean) {
			String id = tmpSciTempService.HandleSciTemp(bean);
			res.put("id", id);
			res.setResultCode("1");
			res.setResultMessage("操作成功");
		} else {
			res.setResultCode("70000000");
			res.setResultMessage(Global.getRetMsg(res.getResultCode()));
		}
		logger.info("------------------end handleSciTemp------------------------");
		return res.getJsonStr();
	}

	/**
	 * 新增模板
	 * 
	 * @return
	 */
	/*@RequestMapping("/insertSciTemp")
	@ResponseBody
	public String insertSciTemp(@RequestBody ResearchFormbean bean) {
		ResponseValue res = new ResponseValue();
		try {
			if (null != bean) {
			//	logger.info(JsonType.jsonType(bean));
			//	SciResearchFormBean formBean = convertFormBean(bean);
			//	logger.info(JsonType.jsonType(formBean));
				tmpSciTempService.HandleSciTemp(bean);
			} else {
				res.setResultCode("70000000");
				res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			}
		} catch (Exception e) {
			
		}

		return res.getJsonStr();
	}*/

	/**
	 * 根据id删除模板 只有创建模版的人才能删除对应模版：需要判断删除操作是否为本人
	 * 
	 * @param sciId
	 * @return
	 */
	@RequestMapping("/delSciTemp")
	@ResponseBody
	@ApiOperation(value="根据id删除模板 只有创建模版的人才能删除对应模版：需要判断删除操作是否为本人",httpMethod="POST",notes="根据id删除模板 只有创建模版的人才能删除对应模版：需要判断删除操作是否为本人")
	public String delSciTemp(@ApiParam(name="json", value ="删除参数") @RequestBody JSONObject json) {
		logger.info("----------------start delSciTemp------------------------");
		ResponseValue res = new ResponseValue();
		String sciId = json.get("sciId").toString();
		String userId = json.get("userId").toString();
		res = tmpSciTempService.delSciResearch(sciId, userId);
		logger.info("----------------end delSciTemp------------------------");
		return res.getJsonStr();
	}

	// 根据条件查询所有的b_reg_opt记录
	@RequestMapping("/getDataByField")
	@ResponseBody
	@ApiOperation(value="根据条件查询所有的患者记录",httpMethod="POST",notes="根据条件查询所有的患者记录")
	public String getDataByField(@ApiParam(name="bean", value ="查询参数") @RequestBody ResearchFormbean bean) {
		logger.info("----------------start getDataByField------------------------");
		logger.info("getDataByField---"+JsonType.jsonType(bean));
		ResponseValue res = new ResponseValue();
		SciResearchFormBean formBean = convertFormBean(bean);
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		res.put("resultList", tmpSciResearchFieldService.changeResearchAnalysisTemp(formBean));
		logger.info("----------------end getDataByField------------------------");
		return res.getJsonStr();
	}

	/**
	 * 比较两个的值，封装对应的数据
	 * 
	 * @return
	 */
	@RequestMapping("/compareAllRegOpt")
	@ResponseBody
	@ApiOperation(value="比较两个的值，封装对应的数据",httpMethod="POST",notes="比较两个的值，封装对应的数据")
	public String compareAllRegOpt(@ApiParam(name="regList", value ="查询参数") @RequestBody List<String> regList) {
		logger.info("----------------start compareAllRegOpt------------------------");
		ResponseValue res = new ResponseValue();
		List<SciCompareFormbean> sciCompareList = new ArrayList<SciCompareFormbean>();
		if(regList.size()>0){
			for (String regOptId : regList) {
				sciCompareList.add(tmpSciResearchFieldService.getSciCompareRegInfo(regOptId));
			}
		}
		res.setResultMessage("查询成功！");
		res.put("resultList", sciCompareList);
		logger.info("----------------end compareAllRegOpt------------------------");
		return res.getJsonStr();
	}

	@RequestMapping("/changeResearchAnalysisTemp")
	@ResponseBody
	@ApiOperation(value="",httpMethod="POST",notes="")
	public String changeResearchAnalysisTemp(@ApiParam(name="bean", value ="查询参数") @RequestBody ResearchFormbean bean) {
		logger.info("----------------start changeResearchAnalysisTemp------------------------");
		ResponseValue res = new ResponseValue();
		SciResearchFormBean formBean = convertFormBean(bean);
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		res.put("resultList", tmpSciResearchFieldService.changeResearchAnalysisTemp(formBean));
		logger.info("----------------end changeResearchAnalysisTemp------------------------");
		return res.getJsonStr();
	}
	
	/**
	 * 获取所有模板
	 * @return
	 */
	@RequestMapping("/getSciTempList")
	@ResponseBody
	@ApiOperation(value="获取所有模板",httpMethod="POST",notes="获取所有模板")
	public String getSciTempList() {
		logger.info("----------------start getSciTempList------------------------");
		ResponseValue res = new ResponseValue();
		List<SciTempFormBean> tempList = tmpSciTempService.getSciTempList();
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		res.put("tempList", tempList);
		logger.info("----------------end getSciTempList------------------------");
		return res.getJsonStr();
	}
	
	
	/**
	 * 获取描点的生命体征监测项
	 * @return
	 */
	@RequestMapping("/getLifeSignList")
	@ResponseBody
	@ApiOperation(value="获取描点的生命体征监测项",httpMethod="POST",notes="获取描点的生命体征监测项")
	public String getLifeSignList(){
		logger.info("----------------start getLifeSignList------------------------");
		ResponseValue res = new ResponseValue();
		List<LifeSignObserveFormBean> lifeSignList = tmpSciResearchFieldService.getLifeSignList();
		res.put("lifeSignList", lifeSignList);
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		logger.info("----------------end getLifeSignList------------------------");
		return res.getJsonStr();
	}
		
	/*@RequestMapping("/test")
	@ResponseBody
	public String test(@RequestBody ResearchFormbean bean) {
		ResponseValue res = new ResponseValue();
		logger.info(JsonType.jsonType(bean));
		SciResearchFormBean formBean = convertFormBean(bean);
		logger.info(JsonType.jsonType(formBean));
		res.setResultCode("1");
		res.setResultMessage("查询成功！");
		res.put("sql", tmpSciResearchFieldService.changeResearchAnalysisTemp(formBean));
		return res.getJsonStr();
	}*/
	
	/**
	 * 接收对象转换
	 * @param bean
	 * @return
	 */
	public SciResearchFormBean convertFormBean(ResearchFormbean bean) {
		logger.info("----------------start convertFormBean------------------------");
		SciResearchFormBean formBean = new SciResearchFormBean();
		List<SciResearchFilter> regOptFilters = null;
		List<SciResearchFilter> anaesRecordFilters = null;
		if (null != bean) {
			
			BeanUtils.copyProperties(bean, formBean);//先将数据传递到另外的对象
			
			SciResearchFilter sex = bean.getSex();
			SciResearchFilter age = bean.getAge();
			SciResearchFilter height = bean.getHeight();
			SciResearchFilter weight = bean.getWeight();
			SciResearchFilter opera_date = bean.getOperaDate();
			SciResearchFilter emergency = bean.getEmergency();
			SciResearchFilter designedOptCode = bean.getDesignedOptCode();
			SciResearchFilter diagnosisCode = bean.getDiagnosisCode();
			SciResearchFilter designedAnaesMethodCode = bean.getDesignedAnaesMethodCode();
			SciResearchFilter operTimeLength = bean.getOperTimeLength();
			SciResearchFilter anaesTimeLength = bean.getAnaesTimeLength();
			SciResearchFilter asa_level = bean.getAsaLevel();
			SciResearchFilter optBody = bean.getOptBody();
			SciResearchFilter anaesEvent = bean.getAnaesEvent();
			SciResearchFilter medEvent = bean.getMedEvent();
			SciResearchFilter ioEvent = bean.getIoEvent();
			SciResearchFilter egressEvent = bean.getEgressEvent();
			SciResearchFilter implOper = bean.getImplOper();
			SciResearchFilter analgesic = bean.getAnalgesic();
			SciResearchFilter implDiag = bean.getImplDiag();
			SciResearchFilter implAnaesMethod = bean.getImplAnaesMethod();
			SciResearchFilter lifeSign = bean.getLifeSign();
			SciResearchFilter instrument = bean.getInstrument();
			
			if (null != sex) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(sex)){
					regOptFilters.add(sex);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != age) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(age)){
					regOptFilters.add(age);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != height) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(height)){
					regOptFilters.add(height);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != weight) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(weight)){
					regOptFilters.add(weight);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != opera_date) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(opera_date)){
					regOptFilters.add(opera_date);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != emergency) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(emergency)){
					regOptFilters.add(emergency);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != designedOptCode) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(designedOptCode)){
					regOptFilters.add(designedOptCode);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != diagnosisCode) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(diagnosisCode)){
					regOptFilters.add(diagnosisCode);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != designedAnaesMethodCode) {
				if (null == regOptFilters) {
					regOptFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(designedAnaesMethodCode)){
					regOptFilters.add(designedAnaesMethodCode);
					formBean.setRegOptFilters(regOptFilters);
				}
			}
			if (null != anaesEvent) {
				if(this.juge(anaesEvent)){
					formBean.setAnaesEventFilter(anaesEvent);
				}
			}
			if (null != medEvent) {
				if(this.juge(medEvent)){
					formBean.setUseMedEventFilter(medEvent);
				}
			}
			if (null != ioEvent) {
				if(this.juge(ioEvent)){
					formBean.setIoEventFilter(ioEvent);
				}
			}
			if (null != egressEvent) {
				if(this.juge(egressEvent)){
					formBean.setEgressEventFilter(egressEvent);
				}
			}
			if (null != analgesic) {
				if(this.juge(analgesic)){
					formBean.setAnalgesicFilter(analgesic);
				}
			}
			if (null != implOper) {
				if(this.juge(implOper)){
					formBean.setImplOperFilter(implOper);
				}
			}
			if (null != implDiag) {
				if(this.juge(implDiag)){
					formBean.setImplDiagFilter(implDiag);
				}
			}
			if (null != implAnaesMethod) {
				if(this.juge(implAnaesMethod)){
					formBean.setImplAnaesMethodFilter(implAnaesMethod);
				}
			}
			if(null != instrument){
				if(this.juge(instrument)){
					formBean.setInstrumentFilter(instrument);
				}
			}
			if (null != operTimeLength) {
				if (null == anaesRecordFilters) {
					anaesRecordFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(operTimeLength)){
					anaesRecordFilters.add(operTimeLength);
					formBean.setAnaesRecordFilters(anaesRecordFilters);
				}
			}
			if (null != anaesTimeLength) {
				if (null == anaesRecordFilters) {
					anaesRecordFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(anaesTimeLength)){
					anaesRecordFilters.add(anaesTimeLength);
					formBean.setAnaesRecordFilters(anaesRecordFilters);
				}
			}
			if (null != asa_level) {
				if (null == anaesRecordFilters) {
					anaesRecordFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(asa_level)){
					anaesRecordFilters.add(asa_level);
					formBean.setAnaesRecordFilters(anaesRecordFilters);
				}
			}
			if (null != optBody) {
				if (null == anaesRecordFilters) {
					anaesRecordFilters = new ArrayList<SciResearchFilter>();
				}
				if(this.juge(optBody)){
					anaesRecordFilters.add(optBody);
					formBean.setAnaesRecordFilters(anaesRecordFilters);
				}
			}
			if (null != lifeSign) {
				if(this.juge(lifeSign)){
					formBean.setLifeSignFilter(lifeSign);
				}
			}
		}
		logger.info("sciTempJson=="+JsonType.jsonType(formBean));
		logger.info("----------------end convertFormBean------------------------");
		return formBean;
	}
	
	
	public boolean juge(SciResearchFilter filter){
		boolean bool = false;
		if(null != filter){
			String type = filter.getType();
			if(null != type && StringUtils.isNotBlank(type)){
				if(type.equals("equal")){
					String value = filter.getValue();
					if(null != value && StringUtils.isNotBlank(value)){
						return true;
					}
				}else if(type.equals("between")){
					String bt1 = filter.getBt1();
					String bt2 = filter.getBt2();
					if((null != bt1 && StringUtils.isNotBlank(bt1)) && (null != bt2 && StringUtils.isNotBlank(bt2))){
						return true;
					}
				}else if(type.equals("andor")){
					List<SciArray> array = filter.getArray();
					if(null != array && array.size()>0){
						return true;
					}
				}
			}
		}
		return bool;
	}

	public SciResearchFormBean convert(ResearchFormbean bean) throws IllegalArgumentException, IllegalAccessException {
		SciResearchFormBean formBean = new SciResearchFormBean();
		List<SciResearchFilter> regOptFilters = null;
		//List<SciResearchFilter> anaesRecordFilters = null;
		if (null != bean) {
			SciResearchFilter sex = bean.getSex();
			if (null != sex) {
				String pid = sex.getPid();
				SciResearchType sct = StrToObj(pid);
				if (null != sct) {
					String type = sct.getType();
					String name = sct.getName();
					if (type.endsWith("String")) {

					} else if (type.endsWith("int") || type.endsWith("Integer")) {

					} else if (type.endsWith("Date")) {

					} else if (type.endsWith("SciResearchFilter")) {

					} else if (type.endsWith("java.util.List")) { // 生成数组filter
						regOptFilters = new ArrayList<SciResearchFilter>();
						regOptFilters.add(sex);
						try {
							Method mSex = formBean.getClass().getMethod("set" + name);
							mSex.setAccessible(true);
							mSex.invoke(formBean, new Object[] { regOptFilters });
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return formBean;
	}

	private SciResearchType StrToObj(String pid) {
		SciResearchType sct = null;
		SciResearchFormBean formBean = new SciResearchFormBean();
		Class<? extends SciResearchFormBean> userCla = (Class<? extends SciResearchFormBean>) formBean.getClass();
		Field[] fs = userCla.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			String name = f.getName();
			String type = f.getType().toString();
			logger.info("name=" + f.getName() + ",type=" + f.getType());
			if (pid.equals(name)) {
				sct = new SciResearchType();
				sct.setName(name);
				sct.setType(type);
				break;
			}
		}

		/*
		 * 得到类中的方法
		 */
		Method[] methods = userCla.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("set")) {
				System.out.print("methodName:" + method.getName() + "\t");
				// System.out.println("value:"+method.invoke(bean));//得到get 方法的值
			}
		}
		return sct;
	}


}
