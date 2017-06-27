package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocOptNurseRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.po.EvtEgress;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.websocket.WebSocketHandler;

/**
 * Title: OptNurseService.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:32:33
 */
@Service
public class DocOptNurseRecordService extends BaseService {

	/**
	 * 
	 * @discription 根据手术ID获取手术护理记录单
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@Transactional
	public String searchOptNurseRecByRegOptId(Map<String, Object> map) {
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId") != null ? map.get("regOptId")
				.toString() : "";
		DocOptNurseRecord optNurseRec = docOptNurseRecordDao
				.selectByRegOptId(regOptId);

		if (null == optNurseRec) {
			resp.setResultCode("40000002");
			resp.setResultMessage("护理记录单不存在");
			return resp.getJsonStr();
		}

		// 根据患者id获取到手术基本信息
		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptDao
				.searchApplicationById(regOptId, getBeid());
		SearchRegOptByIdFormBean searchRegOptByIdFormBean = searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList
				.get(0) : null;

		// 获取麻醉记录单信息
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);

		String anaRecordId = null;

		if (null != anaesRecord) {
			anaRecordId = anaesRecord.getAnaRecordId();
		}

		// 如果是全麻，则开始时间、手术名称等信息需要从麻醉记录单获取
		if ("0".equals(searchRegOptByIdFormBean.getIsLocalAnaes())) {
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(anaRecordId);

			// 全麻时从麻醉记录单中获取到开始、结束、入室、出室等时间
			if (null != anaesRecord) {
				if (null != anaesRecord.getOperStartTime()
						&& null != DateUtils.getParseTime(anaesRecord
								.getOperStartTime())) {
					optNurseRec.setOperStartTime(DateUtils
							.getParseTime(anaesRecord.getOperStartTime()));
				}

				if (null != anaesRecord.getOperEndTime()
						&& null != DateUtils.getParseTime(anaesRecord
								.getOperEndTime())) {
					optNurseRec.setOperEndTime(DateUtils
							.getParseTime(anaesRecord.getOperEndTime()));
				}

				if (null != anaesRecord.getInOperRoomTime()
						&& null != DateUtils.getParseTime(anaesRecord
								.getInOperRoomTime())) {
					optNurseRec.setInOperRoomTime(DateUtils
							.getParseTime(anaesRecord.getInOperRoomTime()));
				}

				if (null != anaesRecord.getOutOperRoomTime()
						&& null != DateUtils.getParseTime(anaesRecord
								.getOutOperRoomTime())) {
					optNurseRec
							.setOutOperRoomTime(DateUtils
									.getParseTime(anaesRecord
											.getOutOperRoomTime()));
				}
			}

			// 根据麻醉记录单获取到手术名称
			List<EvtOptRealOper> optROList = evtOptRealOperDao.searchOptRealOperList(searchBean);
			// optNurseRec.setOperationName("");
			List operationNameList = new ArrayList();
			if (optROList.size() > 0 && optROList != null) {
				for (int i = 0; i < optROList.size(); i++) {
					Map optMap = new HashMap();
					optMap.put("operdefId", optROList.get(i).getOperDefId());
					optMap.put("name", optROList.get(i).getName());
					operationNameList.add(optMap);
					// optNurseRec.setOperationName(optNurseRec.getOperationName()
					// + optROList.get(i).getName() + ",");
				}
			}
			optNurseRec.setOperationNameList(operationNameList);
			// if (!StringUtils.isEmpty(optNurseRec.getOperationName()))
			// {
			// optNurseRec.setOperationName(optNurseRec.getOperationName().substring(0,
			// optNurseRec.getOperationName().length() - 1));
			// }

			// 洗手/巡回护士列表
			searchBean.setRole(EvtParticipantService.ROLE_NURSE);
			searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);
			List<UserInfoFormBean> instruNurseList = evtParticipantDao
					.getSelectParticipantList(searchBean, getBeid());
			String instruNurse = "";
			String tourNurse = "";
			if (instruNurseList != null && instruNurseList.size() > 0) {
				for (int i = 0; i < instruNurseList.size(); i++) {
					instruNurse = instruNurse
							+ instruNurseList.get(i).getName() + ",";
				}
			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(instruNurse)) {
				instruNurse = instruNurse.substring(0,
						instruNurse.length() - 1);
			}

			searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);
			List<UserInfoFormBean> tourNurseList = evtParticipantDao
					.getSelectParticipantList(searchBean, getBeid());
			if (tourNurseList != null && tourNurseList.size() > 0) {
				for (int i = 0; i < tourNurseList.size(); i++) {
					tourNurse = tourNurse + tourNurseList.get(i).getName()
							+ ",";
				}

			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(tourNurse)) {
				tourNurse = tourNurse.substring(0, tourNurse.length() - 1);
			}

			optNurseRec.setTourNurse(instruNurse + "/" + tourNurse);

			// 根据麻醉记录单获取到麻醉方法名
			List designedAnaesMethodList = new ArrayList();
			// if (null == optNurseRec.getDesignedAnaesMethodName() || null
			// == optNurseRec.getDesignedAnaesMethodCode())
			// {
			List<EvtRealAnaesMethod> realAnaesMethodList = evtRealAnaesMethodDao
					.searchRealAnaesMethodList(searchBean);
			optNurseRec.setDesignedAnaesMethodName("");
			if (realAnaesMethodList != null
					&& realAnaesMethodList.size() > 0) {
				for (int i = 0; i < realAnaesMethodList.size(); i++) {
					Map anaesMethodmap = new HashMap();
					anaesMethodmap.put("anaMedId",
							realAnaesMethodList.get(i).getAnaMedId());
					anaesMethodmap.put("name", realAnaesMethodList.get(i)
							.getName());
					designedAnaesMethodList.add(anaesMethodmap);
				}
			}
			if (null != designedAnaesMethodList
					&& designedAnaesMethodList.size() > 0) {
				optNurseRec.setDesignedAnaesMethod(designedAnaesMethodList);
			}
			// }
			// else
			// {
			// String[] code =
			// optNurseRec.getDesignedAnaesMethodCode().split(",");
			// String[] name =
			// optNurseRec.getDesignedAnaesMethodName().split(",");
			//
			// if (code.length == name.length)
			// {
			// for (int i = 0; i < code.length; i++)
			// {
			// Map anaesMethodmap = new HashMap();
			// anaesMethodmap.put("anaMedId", code[i]);
			// anaesMethodmap.put("name", name[i]);
			// designedAnaesMethodList.add(anaesMethodmap);
			// }
			// }
			//
			// optNurseRec.setDesignedAnaesMethod(designedAnaesMethodList);
			// }

			// 根据麻醉记录单获取到手术体位
			// if (null == optNurseRec.getOptBody())
			// {
			optNurseRec.setOptBody(anaesRecord.getOptBody());
			// }

			// 查询出患者的出量事件
			setIOEvent(anaesRecord, optNurseRec);

			// 查询出总入量
			Integer inTotal = evtInEventDao.getIoeventCountValueByIoDef(
					anaRecordId, null);
			optNurseRec.setTotalIn(inTotal == null ? 0 : inTotal);

			// 查询出所有的输液事件
			// if (null == optNurseRec.getInfusion())
			// {
			searchBean.setSubType("1");
			List<SearchOptOperIoevent> ioEventList = evtInEventDao
					.queryIoeventTotalGroupByDefId(searchBean);
			StringBuffer infusionBuf = new StringBuffer();
			Map infusionMap = new HashMap();
			if (null != ioEventList && ioEventList.size() > 0) {
				for (SearchOptOperIoevent ioEvent : ioEventList) {
					infusionBuf.append(ioEvent.getName()).append(" ")
							.append(ioEvent.getTotalAmout())
							.append(ioEvent.getDosageUnit()).append("; ");
					infusionMap.put(
							ioEvent.getName(),
							ioEvent.getTotalAmout()
									+ ioEvent.getDosageUnit());
				}
			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(infusionBuf)) {
				optNurseRec.setInfusion((infusionBuf.substring(0,
						infusionBuf.length() - 1)).toString());
				optNurseRec.setInfusionMap(infusionMap);
			}
			// }
			// else
			// {
			// JSONObject jasonObject2 =
			// JSONObject.fromObject(optNurseRec.getInfusion());
			// optNurseRec.setInfusionMap((Map)jasonObject2);
			// }

			// 查询出所有的输血事件
			// if (null == optNurseRec.getBlood())
			// {
			searchBean.setSubType("2");
			List<SearchOptOperIoevent> bloodEventList = evtInEventDao
					.queryIoeventTotalGroupByDefId(searchBean);
			StringBuffer bloodBuf = new StringBuffer();
			Map bloodMap = new HashMap();
			if (null != bloodEventList && bloodEventList.size() > 0) {
				bloodBuf.append("血制品：");
				for (SearchOptOperIoevent ioEvent : bloodEventList) {
					if (7 == ioEvent.getIoDefId()) {

						bloodBuf.append("血型 ").append(ioEvent.getBlood())
								.append(",").append(ioEvent.getName())
								.append(ioEvent.getTotalAmout())
								.append(ioEvent.getDosageUnit())
								.append("; ");
						bloodMap.put(
								"血型 " + ioEvent.getBlood() + ","
										+ ioEvent.getName(),
								ioEvent.getTotalAmout()
										+ ioEvent.getDosageUnit());
					} else {
						bloodBuf.append(ioEvent.getName()).append(" ")
								.append(ioEvent.getTotalAmout())
								.append(ioEvent.getDosageUnit())
								.append("; ");
						bloodMap.put(
								ioEvent.getName(),
								ioEvent.getTotalAmout()
										+ ioEvent.getDosageUnit());
					}
				}
			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(bloodBuf)) {
				optNurseRec.setBlood((bloodBuf.substring(0,
						bloodBuf.length() - 2)).toString());
				optNurseRec.setBloodMap(bloodMap);
			}
			// }
			// else
			// {
			// JSONObject jasonObject1 =
			// JSONObject.fromObject(optNurseRec.getBlood());
			// optNurseRec.setBloodMap((Map)jasonObject1);
			// }
		} else {
			// 局麻时从基本信息表中获取手术名称
			List operationNameList = new ArrayList();
			if (null == optNurseRec.getOperationName()
					|| null == optNurseRec.getOperationCode()) {
				String[] code = searchRegOptByIdFormBean
						.getDesignedOptCode().split(",");
				String[] name = searchRegOptByIdFormBean
						.getDesignedOptName().split(",");
				if (code.length == name.length) {
					for (int i = 0; i < code.length; i++) {
						Map optMap = new HashMap();
						optMap.put("operdefId", code[i]);
						optMap.put("name", name[i]);
						operationNameList.add(optMap);
					}
				}
			} else if ("".equals(optNurseRec.getOperationName())
					|| "".equals(optNurseRec.getOperationCode())) {
				optNurseRec.setOperationNameList(operationNameList);
			} else {
				String[] code = optNurseRec.getOperationCode().split(",");
				String[] name = optNurseRec.getOperationName().split(",");

				if (code.length == name.length) {
					for (int i = 0; i < code.length; i++) {
						Map optMap = new HashMap();
						optMap.put("operdefId", code[i]);
						optMap.put("name", name[i]);
						operationNameList.add(optMap);
					}
				}
			}
			optNurseRec.setOperationNameList(operationNameList);

			if (null == optNurseRec.getTourNurse()) {
				// 局麻时从排班表中获取巡回护士和洗手护士
				DispatchPeopleNameFormBean dispatchName = basDispatchDao
						.searchPeopleNameByRegOptId(regOptId, getBeid());
				if (null != dispatchName) {
					String str = "";
					if (null != dispatchName.getInstrnurseName1()) {
						str = str + dispatchName.getInstrnurseName1() + ",";
					}

					if (null != dispatchName.getInstrnurseName2()) {
						str = str + dispatchName.getInstrnurseName2();
					} else {
						if (org.apache.commons.lang3.StringUtils.isNotBlank(str)) {
							str = str.substring(0, str.length() - 1);
						}
					}

					str = str + "/";

					if (null != dispatchName.getCircunurseName1()) {
						str = str + dispatchName.getCircunurseName1() + ",";
					}
					if (null != dispatchName.getCircunurseName2()) {
						str = str + dispatchName.getCircunurseName2();
					} else {
						str = str.substring(0, str.length() - 1);
					}
					optNurseRec.setTourNurse(str);
				}
			}

			// 局麻时从基本信息表中获取麻醉方法
			List designedAnaesMethodList = new ArrayList();
			if (null == optNurseRec.getDesignedAnaesMethodName()
					|| null == optNurseRec.getDesignedAnaesMethodCode()) {
				String[] code = searchRegOptByIdFormBean
						.getDesignedAnaesMethodCode().split(",");
				String[] name = searchRegOptByIdFormBean
						.getDesignedAnaesMethodName().split(",");
				if (code.length == name.length) {
					for (int i = 0; i < code.length; i++) {
						Map anaesMethodmap = new HashMap();
						anaesMethodmap.put("anaMedId", code[i]);
						anaesMethodmap.put("name", name[i]);
						designedAnaesMethodList.add(anaesMethodmap);
					}
				}
			} else if ("".equals(optNurseRec.getDesignedAnaesMethodName())
					|| "".equals(optNurseRec.getDesignedAnaesMethodCode())) {
				optNurseRec.setDesignedAnaesMethod(designedAnaesMethodList);
			} else {
				String[] code = optNurseRec.getDesignedAnaesMethodCode()
						.split(",");
				String[] name = optNurseRec.getDesignedAnaesMethodName()
						.split(",");

				if (code.length == name.length) {
					for (int i = 0; i < code.length; i++) {
						Map anaesMethodmap = new HashMap();
						anaesMethodmap.put("anaMedId", code[i]);
						anaesMethodmap.put("name", name[i]);
						designedAnaesMethodList.add(anaesMethodmap);
					}
				}
			}

			optNurseRec.setDesignedAnaesMethod(designedAnaesMethodList);

			if (null != optNurseRec.getInfusion()) {
				JSONObject jasonObject5 = JSONObject.fromObject(optNurseRec
						.getInfusion());
				optNurseRec.setInfusionMap(jasonObject5);
			}

			if (null != optNurseRec.getBlood()) {
				JSONObject jasonObject6 = JSONObject.fromObject(optNurseRec
						.getBlood());
				optNurseRec.setBloodMap(jasonObject6);
			}
		}

		JSONObject jasonObject3 = JSONObject.fromObject(optNurseRec
				.getBradenCond());
		optNurseRec.setBradenMap(jasonObject3);
		JSONObject jasonObject4 = JSONObject.fromObject(optNurseRec
				.getFallCond());
		optNurseRec.setFallMap(jasonObject4);

		// 局麻手术第一次进入手术室时，需要将手术状态改为术中
		if (null == optNurseRec.getInOperRoomTime()) {
			controllerDao.checkOperation(
					searchRegOptByIdFormBean.getRegOptId(),
					OperationState.SURGERY,
					searchRegOptByIdFormBean.getState());
			optNurseRec.setInOperRoomTime(new Date());
			docOptNurseRecordDao.updateByPrimaryKey(optNurseRec);

			// 将消息推送到手术室大屏
			BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);
			String bedStr = org.apache.commons.lang3.StringUtils.isNotBlank(regOpt.getBed()) == true ? regOpt
					.getBed() + "床的"
					: "";
			WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName()
					+ regOpt.getRegionName() + bedStr + regOpt.getName()
					+ "开始手术");
		}

		resp.put("result", "true");
		resp.put("optNurseItem", optNurseRec);
		resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
		return resp.getJsonStr();
	}

	private void saveEgress(DocOptNurseRecord optNurseRec) {
		DocAnaesRecord anaesRecord = docAnaesRecordDao
				.searchAnaesRecordByRegOptId(optNurseRec.getRegOptId());

		String anaRecordId = null;

		if (null != anaesRecord) {
			anaRecordId = anaesRecord.getAnaRecordId();
		}

		EvtEgress egress = new EvtEgress();
		egress.setStartTime(new Date());
		egress.setDocId(anaRecordId);

		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setDocId(anaRecordId);

		if (optNurseRec.getBleeding() != null) {
			searchFormBean.setCode("2");
			List<EvtEgress> egressList1 = evtEgressDao
					.queryEgressListByCode(searchFormBean);

			if (egressList1 != null && egressList1.size() > 0) {
				EvtEgress egress1 = egressList1.get(0);
				egress1.setValue(optNurseRec.getBleeding() + "");
				evtEgressDao.updateByPrimaryKeySelective(egress1);
			} else {
				egress.setIoDefId(2);
				egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
				egress.setValue(optNurseRec.getBleeding() + "");
				evtEgressDao.insert(egress);
			}
		}

		if (optNurseRec.getUrine() != null) {
			searchFormBean.setCode("1");
			List<EvtEgress> egressList2 = evtEgressDao
					.queryEgressListByCode(searchFormBean);

			if (egressList2 != null && egressList2.size() > 0) {
				EvtEgress egress2 = egressList2.get(0);
				egress2.setValue(optNurseRec.getUrine() + "");
				evtEgressDao.updateByPrimaryKeySelective(egress2);
			} else {
				egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
				egress.setIoDefId(1);
				egress.setValue(optNurseRec.getUrine() + "");
				evtEgressDao.insert(egress);
			}
		}

		if (optNurseRec.getHematocele() != null) {
			searchFormBean.setCode("3");
			List<EvtEgress> egressList3 = evtEgressDao
					.queryEgressListByCode(searchFormBean);

			if (egressList3 != null && egressList3.size() > 0) {
				EvtEgress egress3 = egressList3.get(0);
				egress3.setValue(optNurseRec.getHematocele() + "");
				evtEgressDao.updateByPrimaryKeySelective(egress3);
			} else {
				egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
				egress.setIoDefId(3);
				egress.setValue(optNurseRec.getHematocele() + "");
				evtEgressDao.insert(egress);
			}
		}

		if (optNurseRec.getOutOther() != null) {
			searchFormBean.setCode("6");
			List<EvtEgress> egressList4 = evtEgressDao
					.queryEgressListByCode(searchFormBean);

			if (egressList4 != null && egressList4.size() > 0) {
				EvtEgress egress4 = egressList4.get(0);
				egress4.setValue(optNurseRec.getOutOther() + "");
				evtEgressDao.updateByPrimaryKeySelective(egress4);
			} else {
				egress.setEgressId(GenerateSequenceUtil.generateSequenceNo());
				egress.setIoDefId(6);
				egress.setValue(optNurseRec.getOutOther() + "");
				evtEgressDao.insert(egress);
			}
		}
	}

	private void setIOEvent(DocAnaesRecord anaesRecord, DocOptNurseRecord optNurseRec) {
		String anaRecordId = anaesRecord.getAnaRecordId();
		Integer bleeding = evtEgressDao.getEgressCountValueByIoDef("2", anaRecordId) == null ? 0 : evtEgressDao.getEgressCountValueByIoDef("2", anaRecordId);
		optNurseRec.setBleeding(bleeding); // 失血量
		Integer urine = evtEgressDao.getEgressCountValueByIoDef("1", anaRecordId) == null ? 0 : evtEgressDao.getEgressCountValueByIoDef("1", anaRecordId);
		optNurseRec.setUrine(urine); // 尿量
		Integer hematocele = evtEgressDao.getEgressCountValueByIoDef("3", anaRecordId) == null ? 0 : evtEgressDao.getEgressCountValueByIoDef("3", anaRecordId);
		optNurseRec.setHematocele(hematocele); // 出量其他
		Integer outOther = evtEgressDao.getEgressCountValueByIoDef("6", anaRecordId) == null ? 0 : evtEgressDao.getEgressCountValueByIoDef("6", anaRecordId);
		optNurseRec.setOutOther(String.valueOf(outOther)); // 出量其他
		Integer outfusion = evtEgressDao.getEgressCountValueByIoDef(null, anaRecordId) == null ? 0 : evtEgressDao.getEgressCountValueByIoDef(null, anaRecordId);
		optNurseRec.setTotalOut(outfusion); // 总出量
	}

	/**
	 * 
	 * @discription 保存手术护理
	 * @author chengwang
	 * @created 2015-10-20 下午1:44:18
	 * @param preVisit
	 * @return
	 */
	@Transactional
	public String updateOptNurseRec(DocOptNurseRecord optNurseRecord) {
		ResponseValue resp = new ResponseValue();
		Controller controller = controllerDao.getControllerById(optNurseRecord
				.getRegOptId() != null ? optNurseRecord.getRegOptId() : "");
		// RegOpt regOpt = basRegOptDao.searchRegOptById(optNurseRecord.getRegOptId() != null ? optNurseRecord.getRegOptId() : "");
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp.getJsonStr();
		}

		optNurseRecord.setBlood(String.valueOf(optNurseRecord.getBloodMap()));
		optNurseRecord.setInfusion(String.valueOf(optNurseRecord.getInfusionMap()));
		optNurseRecord.setBradenCond(String.valueOf(optNurseRecord.getBradenMap()));
		optNurseRecord.setFallCond(String.valueOf(optNurseRecord.getFallMap()));

		getAnaesMethod(optNurseRecord);
		getOperatiomName(optNurseRecord);

		// 局麻手术时，将出量写入出量表中
		if ("1".equals(controller.getIsLocalAnaes())) {
			saveEgress(optNurseRecord);
		}

		docOptNurseRecordDao.updateByPrimaryKey(optNurseRecord);

		resp.setResultCode("1");
		resp.setResultMessage("护理记录单修改成功!");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 更新手术护理记录单中的输血和输液事件
	 * @author zhouyi
	 * @created 2016年10月8日16:24:17
	 * @param optNurseRecord
	 * @return
	 */
	@Transactional
	public String updateBloodAndInfusion(DocOptNurseRecord optNurseRecord) {
		ResponseValue resp = new ResponseValue();
		if (null != optNurseRecord.getInfusionMap()) {
			optNurseRecord.setInfusion(String.valueOf(optNurseRecord.getInfusionMap()));
		}
		if (null != optNurseRecord.getBloodMap()) {
			optNurseRecord.setBlood(String.valueOf(optNurseRecord.getBloodMap()));
		}
		docOptNurseRecordDao.updateBloodAndInfusion(optNurseRecord);
		resp.setResultCode("1");
		resp.setResultMessage("护理记录单修改成功!");
		return resp.getJsonStr();

	}

	private void getAnaesMethod(DocOptNurseRecord optNurseRecord) {
		if (null != optNurseRecord.getDesignedAnaesMethod()) {
			optNurseRecord.setDesignedAnaesMethodCode("");
			optNurseRecord.setDesignedAnaesMethodName("");
			for (Map<String, Object> anaesMethodMap : optNurseRecord.getDesignedAnaesMethod()) {
				optNurseRecord.setDesignedAnaesMethodCode(optNurseRecord
						.getDesignedAnaesMethodCode()
						+ anaesMethodMap.get("anaMedId") + ",");
				optNurseRecord.setDesignedAnaesMethodName(optNurseRecord
						.getDesignedAnaesMethodName()
						+ anaesMethodMap.get("name") + ",");
			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(optNurseRecord
					.getDesignedAnaesMethodCode())
					&& !org.apache.commons.lang3.StringUtils.isEmpty(optNurseRecord
							.getDesignedAnaesMethodName())) {
				optNurseRecord.setDesignedAnaesMethodCode(optNurseRecord
						.getDesignedAnaesMethodCode().substring(
								0,
								optNurseRecord.getDesignedAnaesMethodCode()
										.length() - 1));

				optNurseRecord.setDesignedAnaesMethodName(optNurseRecord
						.getDesignedAnaesMethodName().substring(
								0,
								optNurseRecord.getDesignedAnaesMethodName()
										.length() - 1));
			}
		}
	}

	private void getOperatiomName(DocOptNurseRecord optNurseRecord) {
		if (null != optNurseRecord.getOperationNameList()) {
			optNurseRecord.setOperationCode("");
			optNurseRecord.setOperationName("");
			for (Map<String, Object> optMap : optNurseRecord.getOperationNameList()) {
				optNurseRecord.setOperationCode(optNurseRecord
						.getOperationCode() + optMap.get("operdefId") + ",");
				optNurseRecord.setOperationName(optNurseRecord
						.getOperationName() + optMap.get("name") + ",");
			}

			if (!org.apache.commons.lang3.StringUtils.isEmpty(optNurseRecord.getOperationCode())
					&& !org.apache.commons.lang3.StringUtils.isEmpty(optNurseRecord.getOperationName())) {
				optNurseRecord
						.setOperationCode(optNurseRecord.getOperationCode()
								.substring(
										0,
										optNurseRecord.getOperationCode()
												.length() - 1));

				optNurseRecord
						.setOperationName(optNurseRecord.getOperationName()
								.substring(
										0,
										optNurseRecord.getOperationName()
												.length() - 1));
			}
		}
	}

	@Transactional
	public String submitOptNurseRec(DocOptNurseRecord optNurseRecord) {
		ResponseValue resp = new ResponseValue();
		Controller controller = controllerDao.getControllerById(optNurseRecord.getRegOptId() != null ? optNurseRecord.getRegOptId() : "");
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(optNurseRecord.getRegOptId() != null ? optNurseRecord.getRegOptId() : "");
		if (controller == null) {
			resp.setResultCode("70000001");
			resp.setResultMessage("手术控制信息不存在!");
			return resp.getJsonStr();
		}

		optNurseRecord.setBlood(String.valueOf(optNurseRecord.getBloodMap()));
		optNurseRecord.setInfusion(String.valueOf(optNurseRecord.getInfusionMap()));
		optNurseRecord.setBradenCond(String.valueOf(optNurseRecord.getBradenMap()));
		optNurseRecord.setFallCond(String.valueOf(optNurseRecord.getFallMap()));
		getAnaesMethod(optNurseRecord);
		getOperatiomName(optNurseRecord);

		// 局麻手术时，提交护理单需要将手术状态改为术后
		if ("1".equals(controller.getIsLocalAnaes())) {
			controllerDao.checkOperation(optNurseRecord.getRegOptId(), OperationState.POSTOPERATIVE, controller.getState());

			String leaveTo = "";
			// 将消息推送到手术室大屏
			if (null != optNurseRecord.getLeaveto1() && "".equals(optNurseRecord.getLeaveto1())) {
				leaveTo = "病房";
			} else if (null != optNurseRecord.getLeaveto2() && "".equals(optNurseRecord.getLeaveto2())) {
				leaveTo = optNurseRecord.getLeavetoOther();
			}
			WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName()
					+ regOpt.getRegionName() + regOpt.getBed()
					+ regOpt.getName() + "手术已结束,去往" + leaveTo);

			// 获取麻醉记录单信息，局麻时将手术开始时间和结束时间写入到麻醉记录单中
			DocAnaesRecord anaesRecord = docAnaesRecordDao
					.searchAnaesRecordByRegOptId(optNurseRecord.getRegOptId());
			anaesRecord.setOperStartTime(DateUtils
					.formatDateTime(optNurseRecord.getOperStartTime()));
			anaesRecord.setOperEndTime(DateUtils.formatDateTime(optNurseRecord
					.getOperEndTime()));
			anaesRecord.setOptBody(optNurseRecord.getOptBody());
			docAnaesRecordDao.updateByPrimaryKey(anaesRecord);

			saveEgress(optNurseRecord);
		}

		try {
			optNurseRecord.setProcessState("END");
			docOptNurseRecordDao.updateByPrimaryKey(optNurseRecord);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(Exceptions.getStackTraceAsString(e));
			}
			resp.setResultCode("10000000");
			resp.setResultMessage("系统错误，请与系统管理员联系!");
			return resp.getJsonStr();
		}
		resp.setResultCode("1");
		resp.setResultMessage("护理记录单提交成功!");
		return resp.getJsonStr();
	}

}
