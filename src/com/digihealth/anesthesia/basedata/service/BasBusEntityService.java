package com.digihealth.anesthesia.basedata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasDeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesKndgbase;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.basedata.po.BasBusEntity;
import com.digihealth.anesthesia.basedata.po.BasCheckItem;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasIoDefination;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeReason;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeWay;
import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasOperroom;
import com.digihealth.anesthesia.basedata.po.BasPacuDeviceMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasPacuDeviceSpecification;
import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasPrice;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.basedata.po.BasRequiredItem;
import com.digihealth.anesthesia.basedata.po.BasSysCode;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;
import com.digihealth.anesthesia.sysMng.po.BasMenu;

@Service
public class BasBusEntityService extends BaseService {

	/**
	 * 查询当前局点是哪一个局点
	 */
	public String getBeid() {
		String beid;
		beid = basBusEntityDao.getBeid();
		// 如果局点不存在，默认设置为101
		if (null == beid || ("").equals(beid)) {
			beid = Global.getConfig("operatorBeid").toString();
		}
		return beid;
	}

	/**
	 * 查询局点列表
	 */
	public List<BasBusEntity> selectBusEntityList(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("beid");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		List<Filter> filters = new ArrayList<Filter>();
		filters = systemSearchFormBean.getFilters();
		String userName = getUserName();
		String operatorAdmin = Global.getConfig("operatorAdmin").toString();
		if (!operatorAdmin.equals(userName)) {
			Filter filter = new Filter();
			filter.setField("beid");
			filter.setValue(getBeid());
			filters.add(filter);
		}
		return basBusEntityDao.selectBusEntityList(filters, systemSearchFormBean);
	}

	/**
	 * 查询局点列表数量
	 */
	public Integer selectBusEntityTotal(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("beid");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		List<Filter> filters = systemSearchFormBean.getFilters();
		return basBusEntityDao.selectBusEntityTotal(filters, systemSearchFormBean);
	}

	/**
	 * 新增局点信息列表
	 */
	@Transactional
	public void saveBusEntity(BasBusEntity sysBusEntity) {
		if (null != sysBusEntity && null != sysBusEntity.getBeid()) 
		{
			basBusEntityDao.insertSelective(sysBusEntity);
			//新局点beid
			String beid = sysBusEntity.getBeid();
			//葛洲坝医院beid(以葛洲坝医院为模板)
			String gzbBeid = "102";
			
			//拷贝 bas_menu 给新局点
			List<BasMenu> basMenuList = basMenuDao.findSubMenuByBeid(gzbBeid);
			if(null != basMenuList && basMenuList.size()>0)
			{
				for(BasMenu basMenu : basMenuList)
				{
					String newMenuId = GenerateSequenceUtil.generateSequenceNo();
					String oldMenuId = basMenu.getId();
					basMenu.setBeid(beid);
					basMenu.setId(newMenuId);
					
					//把对应关系也替换掉
					for(BasMenu basMenu2 : basMenuList)
					{
						String patid = basMenu2.getParentId();
						String patids = basMenu2.getParentIds();
						
						if(StringUtils.isNotBlank(patid)  && oldMenuId.equals(patid))
						{
							basMenu2.setParentId(newMenuId);
						}
						
						if(StringUtils.isNotBlank(patids))
						{
							String[] ptds = patids.split(",");
							
							if(null != ptds && ptds.length>=1)
							{
								for(int i = 0;i<ptds.length;i++)
								{
									if(oldMenuId.equals(ptds[i]))
									{
										ptds[i] = newMenuId;
									}
								}
								String newPartids = StringUtils.join(ptds, ",");
								basMenu2.setParentIds(newPartids);
							}
						}
					}
					basMenuDao.insertSelective(basMenu);
				}
			}
			
			//拷贝bas_anaes_method给新局点
			List<BasAnaesMethod> basAnaesMethodList = basAnaesMethodDao.selectAnaesMethodByBeid(gzbBeid);
			if(null != basAnaesMethodList && basAnaesMethodList.size()>0)
			{
				for(BasAnaesMethod basAnaesMethod : basAnaesMethodList)
				{
					String anaMedId = GenerateSequenceUtil.generateSequenceNo();
					basAnaesMethod.setAnaMedId(anaMedId);
					basAnaesMethod.setBeid(beid);
					basAnaesMethodDao.insertSelective(basAnaesMethod);
				}
			}
			
			//拷贝bas_anaes_method给新局点
			List<BasCheckItem> basCheckItemList = basCheckItemDao.selectCheckItemByBeid(gzbBeid);
			if(null != basCheckItemList && basCheckItemList.size()>0)
			{
				for(BasCheckItem basCheckItem : basCheckItemList)
				{
					String chkItemId = GenerateSequenceUtil.generateSequenceNo();
					basCheckItem.setChkItemId(chkItemId);
					basCheckItem.setBeid(beid);
					basCheckItemDao.insertSelective(basCheckItem);
				}
			}
			
			//拷贝 bas_io_defination 给新局点
			List<BasIoDefination> basIoDefinationList = basIoDefinationDao.queryIoDefinationByBeid(gzbBeid);
			if(null != basIoDefinationList && basIoDefinationList.size()>0)
			{
				for(BasIoDefination basIoDefination : basIoDefinationList)
				{
					String ioDefId = GenerateSequenceUtil.generateSequenceNo();
					basIoDefination.setIoDefId(ioDefId);
					basIoDefination.setBeid(beid);
					basIoDefinationDao.insertSelective(basIoDefination);
				}
			}
			
			//拷贝 bas_medical_take_reason 给新局点
			List<BasMedicalTakeReason> basMedicalTakeReasonList = basMedicalTakeReasonDao.queryMedicalTakeReasonByBeid(gzbBeid);
			if(null != basMedicalTakeReasonList && basMedicalTakeReasonList.size()>0)
			{
				for(BasMedicalTakeReason basMedicalTakeReason : basMedicalTakeReasonList)
				{
					String medTakeReasonId = GenerateSequenceUtil.generateSequenceNo();
					basMedicalTakeReason.setMedTakeReasonId(medTakeReasonId);
					basMedicalTakeReason.setBeid(beid);
					basMedicalTakeReasonDao.insertSelective(basMedicalTakeReason);
				}
			}
			
			//拷贝 bas_medical_take_way 给新局点
			List<BasMedicalTakeWay> basMedicalTakeWayList = basMedicalTakeWayDao.queryMedicalTakeWayByBeId(gzbBeid);
			if(null != basMedicalTakeWayList && basMedicalTakeWayList.size()>0)
			{
				for(BasMedicalTakeWay basMedicalTakeWay : basMedicalTakeWayList)
				{
					String medTakeWayId = GenerateSequenceUtil.generateSequenceNo();
					basMedicalTakeWay.setMedTakeWayId(medTakeWayId);
					basMedicalTakeWay.setBeid(beid);
					basMedicalTakeWayDao.insertSelective(basMedicalTakeWay);
				}
			}
			
			//拷贝  bas_monitor_config 给新局点
			List<BasMonitorConfig> basMonitorConfigList = basMonitorConfigDao.queryAllMonitorConfig(gzbBeid);
			if(null != basMonitorConfigList && basMonitorConfigList.size()>0)
			{
				for(BasMonitorConfig basMonitorConfig : basMonitorConfigList)
				{
					basMonitorConfig.setBeid(beid);
					basMonitorConfigDao.insertSelective(basMonitorConfig);
				}
			}
			
			//拷贝 bas_monitor_config_default 给新局点
			List<BasMonitorConfigDefault> basMonitorConfigDefaultList = basMonitorConfigDefaultDao.selectAll(gzbBeid);
			if(null != basMonitorConfigDefaultList && basMonitorConfigDefaultList.size()>0)
			{
				for(BasMonitorConfigDefault basMonitorConfigDefault : basMonitorConfigDefaultList)
				{
					basMonitorConfigDefault.setBeid(beid);
					basMonitorConfigDefaultDao.insertSelective(basMonitorConfigDefault);
				}
			}
			
			//拷贝 bas_pacu_monitor_config 给新局点
			List<BasPacuMonitorConfig> basPacuMonitorConfigList = basPacuMonitorConfigDao.getPacuMonitorConfigByBeid(gzbBeid);
			if(null != basPacuMonitorConfigList && basPacuMonitorConfigList.size()>0)
			{
				for(BasPacuMonitorConfig basPacuMonitorConfig : basPacuMonitorConfigList)
				{
					basPacuMonitorConfig.setBeid(beid);
					basPacuMonitorConfigDao.insertSelective(basPacuMonitorConfig);
				}
			}
			
			//拷贝  bas_monitor_config_freq 给新局点
			List<BasMonitorConfigFreq> basMonitorConfigFreqList = basMonitorConfigFreqDao.searchMonitorFreqList(gzbBeid);
			if(null != basMonitorConfigFreqList && basMonitorConfigFreqList.size()>0)
			{
				for(BasMonitorConfigFreq basMonitorConfigFreq : basMonitorConfigFreqList)
				{
					basMonitorConfigFreq.setId(GenerateSequenceUtil.generateSequenceNo());
					basMonitorConfigFreq.setBeid(beid);
					basMonitorConfigFreqDao.insertSelective(basMonitorConfigFreq);
				}
			}
			
			//拷贝  bas_required_item 给新局点
			List<BasRequiredItem> BasRequiredItemList = basRequiredItemDao.selectBasRequiredItemByBeid(gzbBeid);
			if(null != BasRequiredItemList && BasRequiredItemList.size()>0)
			{
				for(BasRequiredItem basRequiredItem : BasRequiredItemList)
				{
					basRequiredItem.setId(GenerateSequenceUtil.generateSequenceNo());
					basRequiredItem.setBeid(beid);
					basRequiredItemDao.insertSelective(basRequiredItem);
				}
			}

			//拷贝  bas_anaes_kndgbase 给新局点
			BasAnaesKndgbase entity = new BasAnaesKndgbase();
			entity.setBeid(gzbBeid);
			List<BasAnaesKndgbase> basAnaesKndgbaseList = basAnaesKndgbaseDao.queryAnaesKndgbaseList(entity);
			if (null != basAnaesKndgbaseList && basAnaesKndgbaseList.size() > 0) {
				for (BasAnaesKndgbase basAnaesKndgbase : basAnaesKndgbaseList) {
					basAnaesKndgbase.setId(GenerateSequenceUtil.generateSequenceNo());
					basAnaesKndgbase.setBeid(beid);
					basAnaesKndgbaseDao.insertSelective(basAnaesKndgbase);
				}
			}
			//拷贝  bas_dept 给新局点
			BasDeptFormBean dept = new BasDeptFormBean();
			dept.setBeid(gzbBeid);
			List<BasDept> basDeptList = basDeptDao.selectEntityList(dept);
			if (null != basDeptList && basDeptList.size() > 0) {
				for (BasDept basDept : basDeptList) {
					basDept.setDeptId(GenerateSequenceUtil.generateSequenceNo());
					basDept.setBeid(beid);
					basDeptDao.insert(basDept);
				}
			}
			//拷贝  bas_operroom 给新局点
			BasOperroom operroom = new BasOperroom();
			operroom.setBeid(gzbBeid);
			List<BasOperroom> basOperroomList = basOperroomDao.selectEntityList(operroom);
			if (null != basOperroomList && basOperroomList.size() > 0) {
				for (BasOperroom basOperroom : basOperroomList) {
					basOperroom.setBeid(beid);
					basOperroomDao.insert(basOperroom);
				}
			}
			//拷贝  bas_pacu_device_monitor_config 给新局点
			List<BasPacuDeviceMonitorConfig> pacuDeviceMonitorConfigList = basPacuDeviceMonitorConfigDao.queryEntityByBeid(gzbBeid);
			if (null != pacuDeviceMonitorConfigList && pacuDeviceMonitorConfigList.size() > 0) {
				for (BasPacuDeviceMonitorConfig basPacuDeviceMonitorConfig : pacuDeviceMonitorConfigList) {
					basPacuDeviceMonitorConfig.setBeid(beid);
					basPacuDeviceMonitorConfigDao.insert(basPacuDeviceMonitorConfig);
				}
			}
			//拷贝  bas_pacu_device_specification 给新局点
			List<BasPacuDeviceSpecification> pacuDeviceSpecificationList = basPacuDeviceSpecificationDao.queryEntityByBeid(gzbBeid);
			if (null != pacuDeviceSpecificationList && pacuDeviceSpecificationList.size() > 0) {
				for (BasPacuDeviceSpecification basPacuDeviceSpecification : pacuDeviceSpecificationList) {
					basPacuDeviceSpecification.setBeid(beid);
					basPacuDeviceSpecificationDao.insert(basPacuDeviceSpecification);
				}
			}
			//拷贝  bas_price 给新局点
			BaseInfoQuery price = new BaseInfoQuery();
			price.setBeid(gzbBeid);
			List<BasPrice> priceList = basPriceDao.searchPriceList(price);
			if (null != priceList && priceList.size() > 0) {
				for (BasPrice basPrice : priceList) {
					basPrice.setPriceId(GenerateSequenceUtil.generateSequenceNo());
					basPrice.setBeid(beid);
					basPriceDao.insert(basPrice);
				}
			}
			//拷贝  bas_region 给新局点
			BasRegion region = new BasRegion();
			region.setBeid(gzbBeid);
			List<BasRegion> regionList = basRegionDao.selectEntityList(region);
			if (null != regionList && regionList.size() > 0) {
				for (BasRegion basRegion : regionList) {
					basRegion.setRegionId(GenerateSequenceUtil.generateSequenceNo());
					basRegion.setBeid(beid);
					basRegionDao.insert(basRegion);
				}
			}
			//拷贝  bas_region_bed 给新局点
			BasRegionBed regionBed = new BasRegionBed();
			regionBed.setBeid(gzbBeid);
			List<BasRegionBed> regionBedList = basRegionBedDao.selectEntityList(regionBed);
			if (null != regionBedList && regionBedList.size() > 0) {
				for (BasRegionBed basRegionBed : regionBedList) {
					basRegionBed.setId(beid + basRegionBed.getId());
					basRegionBed.setBeid(beid);
					basRegionBedDao.insert(basRegionBed);
				}
			}
			//拷贝  bas_sys_code 给新局点
			BasSysCode sysCode = new BasSysCode();
			sysCode.setBeid(gzbBeid);
			List<BasSysCode> sysCodeList = basSysCodeDao.selectEntityList(sysCode);
			if (null != sysCodeList && sysCodeList.size() > 0) {
				for (BasSysCode basSysCode : sysCodeList) {
					basSysCode.setSysCodeId(GenerateSequenceUtil.generateSequenceNo());
					basSysCode.setBeid(beid);
					basSysCodeDao.insert(basSysCode);
				}
			}
			//***********************初始化大数据量表**************************
			double random = Math.floor(Math.random()*10000);
			if (random < 1000) {
				random = random * 10;
			}
			String rand = (int)random + "";
			BasOperationPeople people = new BasOperationPeople();
			people.setBeid(beid);
			basOperationPeopleDao.initData(people, rand);
			
			BasDiagnosedef basDiagnosedef = new BasDiagnosedef();
			basDiagnosedef.setBeid(beid);
			basDiagnosedefDao.initData(basDiagnosedef, rand);
			
			BasOperdef basOperdef = new BasOperdef();
			basOperdef.setBeid(beid);
			basOperdefDao.initData(basOperdef, rand);

			BasMedicine basMedicine = new BasMedicine();
			basMedicine.setBeid(beid);
			basMedicineDao.initData(basMedicine, rand);
			//***********************初始化大数据量表**************************
		}
	}

	/**
	 * 修改局点信息列表
	 */
	@Transactional
	public void updateBusEntity(BasBusEntity basBusEntity) {
		if (null != basBusEntity && null != basBusEntity.getBeid()) {
			basBusEntityDao.updateByPrimaryKeySelective(basBusEntity);
		}
	}

	/**
	 * 删除局点信息列表
	 */
	@Transactional
	public void delBusEntity(String beid) {
		basBusEntityDao.deleteByPrimaryKey(beid);
		
		//删除 bas_menu 
		List<BasMenu> basMenuList = basMenuDao.findSubMenuByBeid(beid);
		if(null != basMenuList && basMenuList.size()>0)
		{
			for(BasMenu basMenu : basMenuList)
			{
				basMenuDao.deleteByPrimaryKey(basMenu.getId(), beid);
			}
		}
		
		//删除bas_anaes_method
		basAnaesMethodDao.deleteAnaesMethodByBeid(beid);
		
		//删除bas_anaes_method
		List<BasCheckItem> basCheckItemList = basCheckItemDao.selectCheckItemByBeid(beid);
		if(null != basCheckItemList && basCheckItemList.size()>0)
		{
			for(BasCheckItem basCheckItem : basCheckItemList)
			{
				basCheckItemDao.deleteByPrimaryKey(basCheckItem.getChkItemId());
			}
		}
		
		//删除bas_io_defination
		List<BasIoDefination> basIoDefinationList = basIoDefinationDao.queryIoDefinationByBeid(beid);
		if(null != basIoDefinationList && basIoDefinationList.size()>0)
		{
			for(BasIoDefination basIoDefination : basIoDefinationList)
			{
				basIoDefinationDao.deleteByPrimaryKey(basIoDefination.getIoDefId());
			}
		}
		
		//删除 bas_medical_take_reason 
		List<BasMedicalTakeReason> basMedicalTakeReasonList = basMedicalTakeReasonDao.queryMedicalTakeReasonByBeid(beid);
		if(null != basMedicalTakeReasonList && basMedicalTakeReasonList.size()>0)
		{
			for(BasMedicalTakeReason basMedicalTakeReason : basMedicalTakeReasonList)
			{
				basMedicalTakeReasonDao.deleteMedicalTakeReason(basMedicalTakeReason.getMedTakeReasonId());
			}
		}
		
		//删除 bas_medical_take_way
		List<BasMedicalTakeWay> basMedicalTakeWayList = basMedicalTakeWayDao.queryMedicalTakeWayByBeId(beid);
		if(null != basMedicalTakeWayList && basMedicalTakeWayList.size()>0)
		{
			for(BasMedicalTakeWay basMedicalTakeWay : basMedicalTakeWayList)
			{
				String medTakeWayId = basMedicalTakeWay.getMedTakeWayId();
				basMedicalTakeWayDao.deleteMedicalTakeWay(medTakeWayId);
			}
		}
		
		//删除  bas_monitor_config 
		List<BasMonitorConfig> basMonitorConfigList = basMonitorConfigDao.queryAllMonitorConfig(beid);
		if(null != basMonitorConfigList && basMonitorConfigList.size()>0)
		{
			for(BasMonitorConfig basMonitorConfig : basMonitorConfigList)
			{
				basMonitorConfigDao.deleteByPrimaryKey(basMonitorConfig.getEventId(), beid);
			}
		}
		
		//删除 bas_monitor_config_default
		List<BasMonitorConfigDefault> basMonitorConfigDefaultList = basMonitorConfigDefaultDao.selectAll(beid);
		if(null != basMonitorConfigDefaultList && basMonitorConfigDefaultList.size()>0)
		{
			for(BasMonitorConfigDefault basMonitorConfigDefault : basMonitorConfigDefaultList)
			{
				basMonitorConfigDefaultDao.deleteByPrimaryKey(basMonitorConfigDefault.getEventId(), beid);
			}
		}
		
		//删除 bas_pacu_monitor_config
		List<BasPacuMonitorConfig> basPacuMonitorConfigList = basPacuMonitorConfigDao.getPacuMonitorConfigByBeid(beid);
		if(null != basPacuMonitorConfigList && basPacuMonitorConfigList.size()>0)
		{
			for(BasPacuMonitorConfig basPacuMonitorConfig : basPacuMonitorConfigList)
			{
				basPacuMonitorConfigDao.deleteByPrimaryKey(basPacuMonitorConfig.getEventId(),beid);
			}
		}
		
		//删除  bas_monitor_config_freq
		List<BasMonitorConfigFreq> basMonitorConfigFreqList = basMonitorConfigFreqDao.searchMonitorFreqList(beid);
		if(null != basMonitorConfigFreqList && basMonitorConfigFreqList.size()>0)
		{
			for(BasMonitorConfigFreq basMonitorConfigFreq : basMonitorConfigFreqList)
			{
				basMonitorConfigFreqDao.deleteByPrimaryKey(basMonitorConfigFreq.getId());
			}
		}
		
		//删除  bas_monitor_config_freq 
		List<BasRequiredItem> BasRequiredItemList = basRequiredItemDao.selectBasRequiredItemByBeid(beid);
		if(null != BasRequiredItemList && BasRequiredItemList.size()>0)
		{
			for(BasRequiredItem basRequiredItem : BasRequiredItemList)
			{
				basRequiredItemDao.deleteByPrimaryKey(basRequiredItem.getId());
			}
		}
	}

	/**
	 * 通过beid查询局点信息
	 */
	public BasBusEntity selectBusEntityById(String beid) {
		return basBusEntityDao.selectByPrimaryKey(beid);
	}

	/**
	 * 设置指定局点为当前局点
	 */
	@Transactional
	public void setCurBe(String beid) {
		SystemSearchFormBean systemSearchFormBean = new SystemSearchFormBean();
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("beid");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		// 把局点信息都找出来
		List<BasBusEntity> basBusEntityList = basBusEntityDao.selectBusEntityList(null, systemSearchFormBean);
		if (null != basBusEntityList && basBusEntityList.size() > 0) {
			for (BasBusEntity basBusEntity : basBusEntityList) {
				// 找到指定局点，将它设置为当前局点
				if (basBusEntity.getBeid().equals(beid)) {
					basBusEntity.setIsCurBe(1);
					basBusEntityDao.updateByPrimaryKeySelective(basBusEntity);
					// 把当前局点放入缓存
					// CacheUtils.put(ConstantHolder.ROUTING_ACCESS_CACHE, ConstantHolder.CUR_BEID, beid);
				} else {
					// 找到原来的当前局点，将它设置为非当前局点
					if (null == basBusEntity.getIsCurBe() || basBusEntity.getIsCurBe().intValue() == 1) {
						basBusEntity.setIsCurBe(0);
						basBusEntityDao.updateByPrimaryKeySelective(basBusEntity);
					}
				}
			}
		}
	}

}
