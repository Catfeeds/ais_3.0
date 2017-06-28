package com.digihealth.anesthesia.evt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.basedata.utils.LogUtils;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.evt.formbean.MedicalDetailFormbean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;
import com.digihealth.anesthesia.evt.po.EvtMedicalEventDetail;

@Service
public class EvtMedicalEventService extends BaseService {

	//private static final String MEDICAL_EVENT_TYPE_ANAES="02";//麻醉用药
	//private static final String MEDICAL_EVENT_TYPE_TREAT="01";//治疗用药

	/**
	 * 根据用药事件信息关联查询药品表数据
	 * 
	 * @param docId
	 * @return
	 */
	public List<SearchOptOperMedicalevent> searchMedicaleventList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
        {
            searchBean.setBeid(getBeid());
        }
		return evtMedicaleventDao.searchMedicaleventList(searchBean);
	}

	/**
	 * 按药品名称分组显示药品信息
	 * 
	 * @param searchBean
	 * @return
	 */
	public List<RegOptOperMedicaleventFormBean> searchMedicaleventGroupByCodeList(SearchFormBean searchBean) {
	    if (StringUtils.isBlank(searchBean.getBeid()))
        {
            searchBean.setBeid(getBeid());
        }
		// 将相同药品的数据重新封装
		List<RegOptOperMedicaleventFormBean> resultList = null;
		resultList = evtMedicaleventDao.getMedicalGroupByNameList(searchBean);
		
		if(null != resultList && resultList.size()>0){
			for (RegOptOperMedicaleventFormBean regOptOperMedicaleventFormBean : resultList) {
				//麻醉用药事件列表
				searchBean.setCode(regOptOperMedicaleventFormBean.getCode());
				RegOptOperMedicaleventFormBean romf = evtMedicaleventDao.getUseMedicalTotalById(searchBean);
				regOptOperMedicaleventFormBean.setDosage(romf.getDosage());
				regOptOperMedicaleventFormBean.setDosageUnit(romf.getDosageUnit());
				regOptOperMedicaleventFormBean.setMedicalEventList(evtMedicaleventDao.searchMedicaleventList(searchBean));
			}
		}
		
		if (null != resultList && resultList.size() > 0) {
			for (RegOptOperMedicaleventFormBean regOptOperMedicaleventFormBean : resultList) {
				// 麻醉用药事件列表
				searchBean.setCode(regOptOperMedicaleventFormBean.getCode());
				// 传递持续 or 非持续 or tci模式
				searchBean.setDurable(regOptOperMedicaleventFormBean.getDurable());
				List<SearchOptOperMedicalevent> medicaleventList = evtMedicaleventDao.searchMedicaleventList(searchBean);

				if (null != medicaleventList && medicaleventList.size() > 0) {
					for (int i = 0; i < medicaleventList.size(); i++) {
						SearchOptOperMedicalevent medicalevent = medicaleventList.get(i);
						List<EvtMedicalEventDetail> medDetailList = evtMedicalEventDetailDao.selectByMedEventandDocId(medicalevent.getMedEventId());
						// 设值到medDetailList对象中
						medicalevent.setMedDetailList(medDetailList);
					}
				}

				regOptOperMedicaleventFormBean.setMedicalEventList(medicaleventList);
			}
		}
		
		
		
		return resultList;
	}

	/**
	 * 查询用药事件表数据
	 * 
	 * @param searchBean
	 * @return
	 */
	public List<EvtMedicalEvent> queryMedicaleventListById(SearchFormBean searchBean) {
		return evtMedicaleventDao.queryMedicaleventListById(searchBean);
	}

	public List<SearchOptOperMedicalevent> getPacuMedicaleventList(String docId, String medIds, List<String> medIdLs) {
		return evtMedicaleventDao.getPacuMedicaleventList(docId, medIds, medIdLs, getBeid());
	}

	@Transactional
	public void saveMedicalevent(EvtMedicalEvent medicalevent, ResponseValue value) {
		//if (medicalevent.getDocType() != 2) { // 1为麻醉记录单 2为复苏单
		//	DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(medicalevent.getDocId());
		//}

		SearchFormBean searchFormBean = new SearchFormBean();
		searchFormBean.setDocId(medicalevent.getDocId());
		searchFormBean.setId(medicalevent.getMedEventId());
		List<EvtMedicalEvent> List = evtMedicaleventDao.checkMedicaleventCanInsert(searchFormBean, medicalevent.getMedicineId());
		
		// 持续用药
		if ("1".equals(medicalevent.getDurable())) {
			for (EvtMedicalEvent event : List) {
				Date startTime = medicalevent.getStartTime();
				Date eventStartTime = event.getStartTime();
				Date endTime = medicalevent.getEndTime();
				Date eventEndTime = event.getEndTime();
				// (startTime < eventStartTime && endTime < eventStartTime) || startTime > eventEndTime  则继续往下走，并存入
				if ((startTime.getTime() < eventStartTime.getTime() && endTime.getTime()<eventStartTime.getTime()) || startTime.getTime()>eventEndTime.getTime()) {
					continue;
				} else {
					value.setResultCode("10000001");
					value.setResultMessage("该药品在开始时间：" + medicalevent.getStartTime() + "至结束时间：" + medicalevent.getEndTime() + ", 已经存在持续用药情况,请勿重复添加!");
					return;
				}
			}
		} else {// 普通用药
			for (EvtMedicalEvent event : List) {
				Date startTime = medicalevent.getStartTime();
				Date eventStartTime = event.getStartTime();
				//Date endTime = medicalevent.getEndTime();
				Date eventEndTime = event.getEndTime();
				// !(startTime > eventStartTime && startTime < eventEndTime) 则进行插入
				if (!(startTime.getTime() > eventStartTime.getTime() && startTime.getTime() < eventEndTime.getTime())) {
					continue;
				} else {
					value.setResultCode("10000001");
					value.setResultMessage("该药品在开始时间：" + medicalevent.getStartTime() + ", 已经存在持续用药情况,请勿重复添加!");
					return;
				}
			}
		}
		if (StringUtils.isNotBlank(medicalevent.getMedEventId())) {
			evtMedicaleventDao.updateByPrimaryKeySelective(medicalevent);
			List<EvtMedicalEventDetail> mdList = evtMedicalEventDetailDao.selectByMedEventandDocId(medicalevent.getMedEventId()); // 根据时间排序
			if (null != mdList && mdList.size() > 0) {
				if (mdList.size() == 1) {// 一个说明只有一条浓度的记录
					EvtMedicalEventDetail mdDetail = mdList.get(0);

					if (null != medicalevent.getDurable() && medicalevent.getDurable().equals("2")) {
						if (null != medicalevent.getTciValue()) {
							mdDetail.setFlow(medicalevent.getTciValue());
						}
						if (null != medicalevent.getTciUnit()) {
							mdDetail.setFlowUnit(medicalevent.getFlowUnit());
						}
					} else {
						if (medicalevent.getFlow() > 0) {
							mdDetail.setFlow(medicalevent.getFlow());
						}
						if (null != medicalevent.getFlowUnit()) {
							mdDetail.setFlowUnit(medicalevent.getFlowUnit());
						}
					}

					if (medicalevent.getThickness() > 0) {
						mdDetail.setThickness(medicalevent.getThickness());
					}
					if (null != medicalevent.getThicknessUnit()) {
						mdDetail.setThicknessUnit(medicalevent.getThicknessUnit());
					}
					if (null != medicalevent.getStartTime()) {
						Date startDate = medicalevent.getStartTime();
						mdDetail.setStartTime(startDate);
					}
					if (null != medicalevent.getEndTime()) {
						Date endDate = medicalevent.getEndTime();
						mdDetail.setEndTime(endDate);
					}
					evtMedicalEventDetailDao.updateByPrimaryKey(mdDetail);
				} else { // 多条记录，则说明修改过浓度, 修改开始时间不大于第一条结束时间，结束时间不能小于最后一条的开始时间
					EvtMedicalEventDetail firstMd = mdList.get(0);
					EvtMedicalEventDetail lastMd = mdList.get(mdList.size() - 1);
					if (null != medicalevent.getStartTime()) {
						Date startDate = medicalevent.getStartTime();
						Date firstMdEndTime = firstMd.getEndTime();
						if (startDate.getTime() >= firstMdEndTime.getTime()) { // 开始时间大于第一条记录的结束时间
							value.setResultCode("10000001");
							value.setResultMessage("该药品开始时间大于等于修改浓度后的第一条的结束时间，不能修改！");
							return;
						}
						firstMd.setStartTime(startDate);

						if (null != medicalevent.getDurable() && medicalevent.getDurable().equals("2")) {
							if (null != medicalevent.getTciValue()) {
								firstMd.setFlow(medicalevent.getTciValue());
							}
							if (null != medicalevent.getTciUnit()) {
								firstMd.setFlowUnit(medicalevent.getFlowUnit());
							}
						} else {
							if (medicalevent.getFlow() > 0) {
								firstMd.setFlow(medicalevent.getFlow());
							}
							if (null != medicalevent.getFlowUnit()) {
								firstMd.setFlowUnit(medicalevent.getFlowUnit());
							}
						}

						/*
						 * if(medicalevent.getFlow() > 0){
						 * firstMd.setFlow(medicalevent.getFlow()); } if(null !=
						 * medicalevent.getFlowUnit()){
						 * firstMd.setFlowUnit(medicalevent.getFlowUnit()); }
						 */
						if (medicalevent.getThickness() > 0) {
							firstMd.setThickness(medicalevent.getThickness());
						}
						if (null != medicalevent.getThicknessUnit()) {
							firstMd.setThicknessUnit(medicalevent.getThicknessUnit());
						}
						evtMedicalEventDetailDao.updateByPrimaryKey(firstMd);
					}
					if (null != medicalevent.getEndTime()) {
						Date endDate = medicalevent.getEndTime();
						Date lastMdStartTime = lastMd.getStartTime();
						if (endDate.getTime() <= lastMdStartTime.getTime()) {
							value.setResultCode("10000001");
							value.setResultMessage("该药品结束时间小于等于修改浓度后的最后一条记录的开始时间，不能修改！");
							return;
						}
						lastMd.setEndTime(endDate);
						evtMedicalEventDetailDao.updateByPrimaryKey(lastMd);
					}

				}
			}
			// medicaleventDetailDao.updateByPrimaryKeySelective(medicaleventDetail);
		} else {
			String medEventId = GenerateSequenceUtil.generateSequenceNo();
			medicalevent.setMedEventId(medEventId);
			Integer durable = medicalevent.getDurable();
			if (null != durable) {
				evtMedicaleventDao.insert(medicalevent);
			} else {
				medicalevent.setDurable(0);// 如果页面未传值，则为非持续用药 ，默认为0
				evtMedicaleventDao.insert(medicalevent);
			}

			EvtMedicalEventDetail md = new EvtMedicalEventDetail();
			md.setId(GenerateSequenceUtil.generateSequenceNo());
			//md.setDocId(medicalevent.getDocId());
			md.setMedEventId(medEventId);
			if (null != medicalevent.getDurable() && medicalevent.getDurable().equals("2")) {
				if (null != medicalevent.getTciValue()) {
					md.setFlow(medicalevent.getTciValue());
				}
				if (null != medicalevent.getTciUnit()) {
					md.setFlowUnit(medicalevent.getFlowUnit());
				}
			} else {
				md.setFlow(medicalevent.getFlow());
				md.setFlowUnit(medicalevent.getFlowUnit());
			}

			md.setThickness(medicalevent.getThickness());
			md.setThicknessUnit(medicalevent.getThicknessUnit());
			Date startDate = medicalevent.getStartTime();
			md.setStartTime(startDate);
			Date endtime = medicalevent.getEndTime();
			if (null != endtime) {
				md.setEndTime(endtime);
			}

			evtMedicalEventDetailDao.insert(md);
		}
		value.put("medicineId", medicalevent.getMedEventId());
		LogUtils.saveOperateLog(medicalevent.getDocId(), LogUtils.OPT_TYPE_INFO_SAVE, LogUtils.OPT_MODULE_INTERFACE, "术中添加用药事件保存", JsonType.jsonType(medicalevent), UserUtils.getUserCache(), getBeid());
	}

	@Transactional
	public void batchSaveMedicalevent(List<EvtMedicalEvent> medicaleventList, ResponseValue value) {
		if (null != medicaleventList && medicaleventList.size() > 0) {
			List<String> successList = new ArrayList<String>();
			List<String> failList = new ArrayList<String>();
			//DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(medicaleventList.get(0).getDocId());
			for (EvtMedicalEvent medicalevent : medicaleventList) {

				SearchFormBean searchFormBean = new SearchFormBean();
				searchFormBean.setDocId(medicalevent.getDocId());
				searchFormBean.setId(medicalevent.getMedEventId());
				List<EvtMedicalEvent> List = evtMedicaleventDao.checkMedicaleventCanInsert(searchFormBean, medicalevent.getMedicineId() + "");

				boolean flag = false;
				// 持续用药
				if ("1".equals(medicalevent.getDurable())) {
					for (EvtMedicalEvent event : List) {
						Date startTime = medicalevent.getStartTime();
						Date eventStartTime = event.getStartTime();
						Date endTime = medicalevent.getEndTime();
						Date eventEndTime = event.getEndTime();
						// (startTime < eventStartTime && endTime < eventStartTime) || startTime > eventEndTime  则继续往下走，并存入
						if ((startTime.getTime() < eventStartTime.getTime() && endTime.getTime()<eventStartTime.getTime()) || startTime.getTime()>eventEndTime.getTime()) {
						//if ((DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getStartTime())) < 0 && DateUtils.parseDate(medicalevent.getEndTime()).compareTo(DateUtils.parseDate(event.getStartTime())) < 0) || DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getEndTime())) > 0) {
							continue;
						} else {
							// value.setResultCode("10000001");
							// value.setResultMessage("该药品在开始时间："+medicalevent.getStarttime()+"至结束时间："+medicalevent.getEndtime()+", 已经存在持续用药情况,请勿重复添加!");
							// return;

							flag = true;
						}
					}
				} else {// 普通用药
					for (EvtMedicalEvent event : List) {
						Date startTime = medicalevent.getStartTime();
						Date eventStartTime = event.getStartTime();
						//Date endTime = medicalevent.getEndTime();
						Date eventEndTime = event.getEndTime();
						// !(startTime > eventStartTime && startTime < eventEndTime) 则进行插入
						if (!(startTime.getTime() > eventStartTime.getTime() && startTime.getTime() < eventEndTime.getTime())) {
						//if (!(DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getStartTime())) > 0 && DateUtils.parseDate(medicalevent.getStartTime()).compareTo(DateUtils.parseDate(event.getEndTime())) < 0)) {
							continue;
						} else {
							// value.setResultCode("10000001");
							// value.setResultMessage("该药品在开始时间："+medicalevent.getStarttime()+", 已经存在持续用药情况,请勿重复添加!");
							// return;
							flag = true;
						}
					}
				}
				BasMedicine medicine = basMedicineDao.queryMedicineById(medicalevent.getMedicineId() + "");

				if (flag) {
					failList.add(medicine.getName());
					continue;
				}

				if (!StringUtils.isNotBlank(medicalevent.getMedEventId())) {
					medicalevent.setMedEventId(GenerateSequenceUtil.generateSequenceNo());
					evtMedicaleventDao.insert(medicalevent);
					successList.add(medicine.getName());
				}

			}
			value.put("success", successList);
			value.put("fail", failList);

		}
	}

	/**
	 * 删除用药事件
	 * 
	 * @param medicalevent
	 */
	@Transactional
	public void deleteMedicalevent(EvtMedicalEvent medicalevent) {
		evtMedicaleventDao.deleteByPrimaryKey(medicalevent.getMedEventId());
		// 删除用药详情相关的记录
		evtMedicalEventDetailDao.deleteByMedEventId(medicalevent.getMedEventId());
	}

	@Transactional
	public void saveMedicalEventDetail(MedicalDetailFormbean bean, ResponseValue value) {
		String id = bean.getId();
		if (null != id && StringUtils.isNotBlank(id)) { // 修改记录
			EvtMedicalEventDetail mdDetail = evtMedicalEventDetailDao.selectByPrimaryKey(id);
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setId(id);
			List<EvtMedicalEvent> mdEventList = evtMedicaleventDao.queryMedicaleventListById(searchBean);
			Date insertTime = bean.getInsertTime();
			if (null != mdEventList && mdEventList.size() > 0) {
				EvtMedicalEvent medicalevent = mdEventList.get(0);
				Date starttime = medicalevent.getStartTime();
				if (null != insertTime) {
					if (starttime.getTime() == starttime.getTime()) { // 时间相等则修改事件表的流速
						if (null != bean.getFlow() && bean.getFlow() > 0) {
							medicalevent.setFlow(bean.getFlow());
						}
						if (null != bean.getThickness() && bean.getThickness() > 0) {
							medicalevent.setThickness(bean.getThickness());
						}
						evtMedicaleventDao.updateByPrimaryKeySelective(medicalevent); // 修改浓度或流速
					}
				}
			}
			if (null != mdDetail) {
				if (null != bean.getFlow() && bean.getFlow() > 0) {
					mdDetail.setFlow(bean.getFlow());
				}
				if (null != bean.getThickness() && bean.getThickness() > 0) {
					mdDetail.setThickness(bean.getThickness());
				}
				evtMedicalEventDetailDao.updateByPrimaryKeySelective(mdDetail);
			} else {
				value.setResultCode("10000001");
				value.setResultMessage("未找到对应的用药记录详情！");
				return;
			}

		} else { // 新增，根据时间拆分
			Date insertTime = bean.getInsertTime();
			//String docId = bean.getDocId();
			String medEventId = bean.getMedEventId();
			List<EvtMedicalEventDetail> mdDetailList = evtMedicalEventDetailDao.selectByStartTimeWithEndTime(medEventId, insertTime);
			if (null != mdDetailList && mdDetailList.size() > 0) {
				EvtMedicalEventDetail mdDetail = mdDetailList.get(0);
				// 存入第一条数据
				EvtMedicalEventDetail firstMd = new EvtMedicalEventDetail();
				BeanUtils.copyProperties(mdDetail, firstMd, new String[] { "id", "endTime" });
				firstMd.setId(GenerateSequenceUtil.generateSequenceNo());
				firstMd.setEndTime(insertTime);
				evtMedicalEventDetailDao.insertSelective(firstMd);

				// 存入第二条数据
				EvtMedicalEventDetail secondMd = new EvtMedicalEventDetail();
				BeanUtils.copyProperties(mdDetail, secondMd, new String[] { "id", "startTime", "flow", "thickness" });
				if (null != bean.getFlow() && bean.getFlow() > 0) {
					secondMd.setFlow(bean.getFlow());
				}
				if (null != bean.getThickness() && bean.getThickness() > 0) {
					secondMd.setThickness(bean.getThickness());
				}
				secondMd.setId(GenerateSequenceUtil.generateSequenceNo());
				secondMd.setStartTime(insertTime);
				evtMedicalEventDetailDao.insertSelective(secondMd);
				// 删除mdDetail数据
				evtMedicalEventDetailDao.deleteByPrimaryKey(mdDetail.getId());
			} else {
				value.setResultCode("10000001");
				value.setResultMessage("修改浓度的时间不在用药时间之内，无法新增！");
				return;
			}
		}
	}

	@Transactional
	public void deleteMedicalEventDetail(MedicalDetailFormbean bean, ResponseValue value) {
		//String docId = bean.getDocId();
		String medEventId = bean.getMedEventId();
		Date insertTime = bean.getInsertTime();

		List<EvtMedicalEventDetail> mdDetailList = evtMedicalEventDetailDao.getMedEventDetailListByTime(medEventId, insertTime);
		if (null != mdDetailList && mdDetailList.size() > 0) {
			if (mdDetailList.size() == 1) {
				value.setResultCode("10000001");
				value.setResultMessage("当前用药记录详情只有一条记录，不能删除！");
				return;
			} else if (mdDetailList.size() == 2) {
				EvtMedicalEventDetail firstMd = mdDetailList.get(0);
				EvtMedicalEventDetail secondMd = mdDetailList.get(1);
				firstMd.setEndTime(secondMd.getEndTime());
				evtMedicalEventDetailDao.updateByPrimaryKeySelective(firstMd); // 第一条修改结束时间为第二条的结束时间
				evtMedicalEventDetailDao.deleteByPrimaryKey(secondMd.getId()); // 第二条删除
			} else {
				value.setResultCode("10000001");
				value.setResultMessage("查询出来的用药记录详情多于两条记录，数据有误！");
				return;
			}
		}
	}
}
