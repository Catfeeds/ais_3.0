/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.config.InOutStockTypeOption;
import com.digihealth.anesthesia.basedata.config.InventoryTypeOption;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInventory;
import com.digihealth.anesthesia.basedata.po.BasInventoryMonth;
import com.digihealth.anesthesia.basedata.po.BasInOutInfo;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
 * Title: InOutInfoService.java Description: 出入量
 * 
 * @author chengwang
 * @created 2015年12月15日 上午10:33:47
 */
@Service
public class BasInOutInfoService extends BaseService {

	// 可以对手术包管理，药品管理，耗材管理等管理库存的统一入出库接口
	@Transactional
	public String updateInOutInfo(BasInOutInfo inOutInfo) {

	    if (StringUtils.isEmpty(inOutInfo.getBeid()))
        {
	        inOutInfo.setBeid(getBeid());
        }
		BasInOutInfo oldInOutInfo = null;
		// 如果oldInOutInfo为空，那么就是加一条库存，如果不为空，那么就是编辑某一条库存信息
		if (inOutInfo.getIoId() != null) {
			oldInOutInfo = basInOutInfoDao
					.searchInOutInfoById(inOutInfo.getIoId());
		}

		BasInventory selectInventory = new BasInventory();
		selectInventory.setBeid(getBeid());
		selectInventory.setInvtId(GenerateSequenceUtil.generateSequenceNo());
		BasInventoryMonth selectInventoryMonth = new BasInventoryMonth();
		selectInventoryMonth.setBeid(getBeid());
		selectInventoryMonth.setInvtMonId(GenerateSequenceUtil.generateSequenceNo());
		// 根据库存类型，如果是药品的库存，那么对药品库存搜索追加条件，对药品的月统计搜索追加条件
		if (inOutInfo.getMaterielType().equals(InventoryTypeOption.MEDICINE)) {
			selectInventory.setSpec(inOutInfo.getSpec());
			selectInventory.setFirm(inOutInfo.getFirm());
			selectInventoryMonth.setSpec(inOutInfo.getSpec());
			selectInventoryMonth.setFirm(inOutInfo.getFirm());
		}
		// 如果不是药品就根据批次和收费项目ID和 materielType来查询
		// materielType是类型，如果是药品此值就是M,如果是耗材就是I
		selectInventory.setBatch(inOutInfo.getBatch());
		selectInventory.setType(inOutInfo.getMaterielType());
		selectInventoryMonth.setBatch(inOutInfo.getBatch());
		selectInventoryMonth.setType(inOutInfo.getMaterielType());
		selectInventoryMonth.setChargeItemId(inOutInfo.getChargeItemId()+""+"");
		selectInventoryMonth.setInventoryMonth(DateUtils.getDateToString());
		selectInventory.setChargeItemId(inOutInfo.getChargeItemId()+""+"");

		// 如果materielType为I 查询库存里有没有相同批次的耗材
		List<BasInventory> list = basInventoryDao.findList(selectInventory);
		// 如果materielType为I 查询月进销的相同批次的耗材
		List<BasInventoryMonth> monthList = basInventoryMonthDao
				.findList(selectInventoryMonth);
		BasInventory inventory = null;
		BasInventoryMonth inventoryMonth = null;
		if (list != null && list.size() > 0) {
			inventory = list.get(0);
		}
		if (monthList != null && monthList.size() > 0) {
			inventoryMonth = monthList.get(0);
		}
		// 根据类型判断是入库
		if (inOutInfo.getInOutType().equals(InOutStockTypeOption.INSTOCK)) {

			Float inventoryAmount = null;
			Float inventoryMonthAmount = null;
			// 如果该耗材是第一次入库
			if (inventory == null) {
				// 得到入库的库存
				inventoryAmount = inOutInfo.getInOutAmount();
				inventory = new BasInventory();
				inventory.setInvtId(GenerateSequenceUtil.generateSequenceNo());
				// 自动把耗材名字转成pinyin码
				inventory.setPinYin(PingYinUtil.getFirstSpell(inOutInfo.getName()));
				inventory.setChargeItemId(inOutInfo.getChargeItemId()+"");
				inventory.setName(inOutInfo.getName());
				inventory.setSpec(inOutInfo.getSpec());
				inventory.setFirm(inOutInfo.getFirm());
				inventory.setBatch(inOutInfo.getBatch());
				inventory.setType(inOutInfo.getMaterielType());
				inventory.setMinPackageUnit(inOutInfo.getMinPackageUnit());
				inventory.setPriceMinPackage(inOutInfo.getPriceStock());
				inventory.setProductionDate(inOutInfo.getProductionDate());
				inventory.setExpiryDate(inOutInfo.getExpiryDate());
				inventory.setInventoryAmount(inventoryAmount);
				inventory.setBeid(getBeid());
				basInventoryDao.insert(inventory);
			} else {
				// 如果oldInOutInfo为空，那么就是加一条入库信息，那么库存表里面的此耗材的库存总量就会追加，
				// 如果oldInOutInfo不为空，那么就是编辑入库信息，那么就用此耗材的总库存，减去原来加一条的入库信息的数量，加上编辑后的数量
				if (oldInOutInfo == null) {
					inventoryAmount = inventory.getInventoryAmount()
							+ inOutInfo.getInOutAmount();
				} else {
					inventoryAmount = inventory.getInventoryAmount()
							- oldInOutInfo.getInOutAmount()
							+ inOutInfo.getInOutAmount();
				}
				inventory.setInventoryAmount(inventoryAmount);
				basInventoryDao.update(inventory);
			}
			// 如果月进销为空，那么就创建一条，统计这个批次的耗材月进销存值
			if (inventoryMonth == null) {
				inventoryMonthAmount = inOutInfo.getInOutAmount();
				inventoryMonth = new BasInventoryMonth();
				inventoryMonth.setInvtMonId(GenerateSequenceUtil.generateSequenceNo());
				inventoryMonth.setChargeItemId(inOutInfo.getChargeItemId()+"");
				inventoryMonth.setSpec(inOutInfo.getSpec());
				inventoryMonth.setFirm(inOutInfo.getFirm());
				inventoryMonth.setBatch(inOutInfo.getBatch());
				inventoryMonth.setType(inOutInfo.getMaterielType());
				inventoryMonth.setInventoryMonth(DateUtils.getDateToString());
				inventoryMonth.setInventoryMonthAmount(inventoryMonthAmount);
				inventoryMonth.setBeid(getBeid());
				basInventoryMonthDao.insert(inventoryMonth);
			} else {
				// 如果oldInOutInfo为空，那么就是加一条入库信息，那么月进销存表里面的此耗材的进的总量就会追加，
				// 如果oldInOutInfo不为空，那么就是编辑入库信息，那么就用此耗材的月进销存表总库存，减去原来加一条的入库信息的数量，加上编辑后的数量
				if (oldInOutInfo == null) {
					inventoryMonthAmount = inventoryMonth
							.getInventoryMonthAmount()
							+ inOutInfo.getInOutAmount();
				} else {
					inventoryMonthAmount = inventoryMonth
							.getInventoryMonthAmount()
							- oldInOutInfo.getInOutAmount()
							+ inOutInfo.getInOutAmount();
				}
				inventoryMonth.setInventoryMonthAmount(inventoryMonthAmount);
				basInventoryMonthDao.update(inventoryMonth);
			}

			inventory.setInventoryAmount(inventoryAmount);
		} else if (inOutInfo.getInOutType().equals(
				InOutStockTypeOption.OUTSTOCK)) {// 此处表示是出库

			// 得到出库的数量
			Float formBean_amount = inOutInfo.getInOutAmount();
			BasInOutInfo inOutInfoTargets = null;
			if (inOutInfo.getIoId() != null) {
				// IoId不为空，那么就是编辑出库信息
				inOutInfoTargets = basInOutInfoDao.searchInOutInfoById(inOutInfo
						.getIoId());
				// 如果编辑的出库数量和原先的出库数量一致，那么不修改此条出库信息
				if ((inOutInfoTargets.getInOutAmount() + "") != (formBean_amount
						.toString())
						&& (!(inOutInfoTargets.getInOutAmount() + "")
								.equals(formBean_amount.toString()))) {
					// 这里是修改出库信息，就在库存表里面得到此耗材的库存然后加上编辑前的出库数量减去现在需要出库的数量
					Float inventoryAmount = inventory.getInventoryAmount()
							+ inOutInfoTargets.getInOutAmount()
							- inOutInfo.getInOutAmount();
					inventory.setInventoryAmount(inventoryAmount);
					basInventoryDao.update(inventory);

					Float inventoryMonthAmount = null;
					// 如果月进销存为空，就新增一条此批次的耗材的月进销存数据
					if (inventoryMonth == null) {
						inventoryMonthAmount = inOutInfo.getInOutAmount();
						inventoryMonth = new BasInventoryMonth();
						inventoryMonth.setInvtMonId(GenerateSequenceUtil.generateSequenceNo());
						inventoryMonth.setChargeItemId(inOutInfo.getChargeItemId()+"");
						inventoryMonth.setSpec(inOutInfo.getSpec());
						inventoryMonth.setFirm(inOutInfo.getFirm());
						inventoryMonth.setBatch(inOutInfo.getBatch());
						inventoryMonth.setType(inOutInfo.getMaterielType());
						inventoryMonth.setInventoryMonth(DateUtils.getDateToString());
						inventoryMonth.setInventoryMonthAmount(0 - inventoryMonthAmount);
						inventoryMonth.setBeid(getBeid());
						basInventoryMonthDao.insert(inventoryMonth);
					} else {
						// 如果月进销存不为空，那么就当月进销存的量加上编辑前的出库数量减去编辑后的出库数量
						inventoryMonthAmount = inventoryMonth
								.getInventoryMonthAmount()
								+ inOutInfoTargets.getInOutAmount()
								- inOutInfo.getInOutAmount();
						inventoryMonth
								.setInventoryMonthAmount(inventoryMonthAmount);
						basInventoryMonthDao.update(inventoryMonth);
					}
					inventory.setInventoryAmount(inventoryAmount);
				}
			} else {
				// 这里是表示加一条出库信息
				if (inventory != null) {
					// 在此批次此耗材的总库存减去需要出库的数量
					Float inventoryAmount = inventory.getInventoryAmount()
							- inOutInfo.getInOutAmount();
					inventory.setInventoryAmount(inventoryAmount);
					basInventoryDao.update(inventory);
					Float inventoryMonthAmount = null;
					// 如果月进销存为空，就新增一条此批次的耗材的月进销存数据
					if (inventoryMonth == null) {
						inventoryMonthAmount = inOutInfo.getInOutAmount();
						inventoryMonth = new BasInventoryMonth();
						inventoryMonth.setInvtMonId(GenerateSequenceUtil.generateSequenceNo());
						inventoryMonth.setChargeItemId(inOutInfo.getChargeItemId()+"");
						inventoryMonth.setSpec(inOutInfo.getSpec());
						inventoryMonth.setFirm(inOutInfo.getFirm());
						inventoryMonth.setBatch(inOutInfo.getBatch());
						inventoryMonth.setType(inOutInfo.getMaterielType());
						inventoryMonth.setInventoryMonth(DateUtils.getDateToString());
						inventoryMonth.setInventoryMonthAmount(0 - inventoryMonthAmount);
						inventoryMonth.setBeid(getBeid());
						basInventoryMonthDao.insert(inventoryMonth);
					} else {
						// 如果月进销存不为空，那么就当月进销存的量减去出库数量
						inventoryMonthAmount = inventoryMonth
								.getInventoryMonthAmount()
								- inOutInfo.getInOutAmount();
						inventoryMonth
								.setInventoryMonthAmount(inventoryMonthAmount);
						basInventoryMonthDao.update(inventoryMonth);
					}
					inventory.setInventoryAmount(inventoryAmount);
				}
			}
		}
		// 更新出入库的信息
		if (inOutInfo.getIoId() != null) {
			basInOutInfoDao.update(inOutInfo);
		} else {
			// 加一条出入库的信息
			inOutInfo.setIoId(GenerateSequenceUtil.generateSequenceNo());
			inOutInfo.setInOutDate(DateUtils.getDate());
			basInOutInfoDao.insert(inOutInfo);
		}
		return "成功";

	}

	public BasInOutInfo searchInOutInfoById(String inId) {
		return basInOutInfoDao.searchInOutInfoById(inId);
	}

	public List<BasInOutInfo> searchInOutInfo(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("inOutDate");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		String groupId = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if (filters.get(i).getField().toString().equals("inOutType")) {
						if (filters.get(i).getValue().toString().equals("I")) {
							groupId = "in_way";
						} else {
							groupId = "out_way";
						}
					}
					if("inOutWayName".equals(filters.get(i).getField().toString())) {
						filter += " AND t.inOutWay IN(SELECT codeValue FROM bas_sys_code WHERE codeName LIKE '%" + filters.get(i).getValue() + "%' AND beid = '" + systemSearchFormBean.getBeid() + "')";
					}else {
						filter += " AND t." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}
		return basInOutInfoDao.queryInOutInfoList(filter, groupId, systemSearchFormBean);
	}

	public List<BasInOutInfo> searchOutInfo(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
            systemSearchFormBean.setBeid(getBeid());
        }
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("inOutDate");
		} 
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		String groupId = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if (filters.get(i).getField().toString().equals("inOutType")) {
						if (filters.get(i).getValue().toString().equals("I")) {
							groupId = "in_way";
						} else {
							groupId = "out_way";
						}
					}
					if("inOutWayName".equals(filters.get(i).getField().toString())) {
						filter += " AND t.inOutWay IN(SELECT codeValue FROM bas_sys_code WHERE codeName LIKE '%" + filters.get(i).getValue() + "%' AND beid = '" + systemSearchFormBean.getBeid() + "')";
					}else {
						filter += " AND t."+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basInOutInfoDao.queryInOutInfoList(filter, groupId, systemSearchFormBean);
	}

	public int searchTotalOutInfo(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
            systemSearchFormBean.setBeid(getBeid());
        }
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("inOutDate");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		String groupId = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if (filters.get(i).getField().toString().equals("inOutType")) {
						if (filters.get(i).getValue().toString().equals("I")) {
							groupId = "in_way";
						} else {
							groupId = "out_way";
						}
					}
					if("inOutWayName".equals(filters.get(i).getField().toString())) {
						filter += " AND t.inOutWay IN(SELECT codeValue FROM bas_sys_code WHERE codeName LIKE '%" + filters.get(i).getValue() + "%' AND beid = '" + systemSearchFormBean.getBeid() + "')";
					}else {
						filter += " AND t."+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basInOutInfoDao.queryInOutInfoListTotal(filter, systemSearchFormBean);
	}

	public int searchTotalInOutInfo(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("inOutDate");
		} 
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("DESC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if("inOutWayName".equals(filters.get(i).getField().toString())) {
						filter += " AND t.inOutWay IN(SELECT codeValue FROM bas_sys_code WHERE codeName LIKE '%" + filters.get(i).getValue() + "%' AND beid = '" + systemSearchFormBean.getBeid() + "')";
					}else {
						filter += " AND t."+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
				}
			}
		}
		return basInOutInfoDao.queryInOutInfoListTotal(filter, systemSearchFormBean);
	}

	@Transactional
	public int deleteInOutInfoById(BasInOutInfo inOutInfo) throws ParseException {
	    
		BasInOutInfo oldInOutInfo = basInOutInfoDao.searchInOutInfoById(inOutInfo
				.getIoId());

		BasInventory selectInventory = new BasInventory();
		selectInventory.setBeid(getBeid());
		BasInventoryMonth selectInventoryMonth = new BasInventoryMonth();
		selectInventoryMonth.setBeid(getBeid());
		if (inOutInfo.getMaterielType().equals(InventoryTypeOption.MEDICINE)) {
			selectInventory.setSpec(oldInOutInfo.getSpec());
			selectInventory.setFirm(oldInOutInfo.getFirm());
			selectInventoryMonth.setSpec(oldInOutInfo.getSpec());
			selectInventoryMonth.setFirm(oldInOutInfo.getFirm());
		}
		selectInventory.setBatch(oldInOutInfo.getBatch());
		selectInventory.setType(oldInOutInfo.getMaterielType());
		selectInventoryMonth.setBatch(oldInOutInfo.getBatch());
		selectInventoryMonth.setType(oldInOutInfo.getMaterielType());
		selectInventoryMonth.setChargeItemId(oldInOutInfo.getChargeItemId()+"");
		selectInventoryMonth.setInventoryMonth(DateUtils
				.getDateToString(oldInOutInfo.getInOutDate()));
		selectInventory.setChargeItemId(oldInOutInfo.getChargeItemId()+"");
		List<BasInventory> list = basInventoryDao.findList(selectInventory);
		List<BasInventoryMonth> monthList = basInventoryMonthDao
				.findList(selectInventoryMonth);
		BasInventory inventory = null;
		BasInventoryMonth inventoryMonth = null;
		if (list != null && list.size() > 0) {
			inventory = list.get(0);
		}
		if (monthList != null && monthList.size() > 0) {
			inventoryMonth = monthList.get(0);
		}

		if (inOutInfo.getInOutType().equals(InOutStockTypeOption.INSTOCK)) {

			Float inventoryAmount = null;
			inventoryAmount = inventory.getInventoryAmount()
					- oldInOutInfo.getInOutAmount();
			inventory.setInventoryAmount(inventoryAmount);
			basInventoryDao.update(inventory);

			Float inventoryMonthAmount = inventoryMonth
					.getInventoryMonthAmount() - oldInOutInfo.getInOutAmount();
			inventoryMonth.setInventoryMonthAmount(inventoryMonthAmount);
			basInventoryMonthDao.update(inventoryMonth);
		} else if (inOutInfo.getInOutType().equals(
				InOutStockTypeOption.OUTSTOCK)) {
			Float inventoryAmount = inventory.getInventoryAmount()
					+ oldInOutInfo.getInOutAmount();
			inventory.setInventoryAmount(inventoryAmount);
			basInventoryDao.update(inventory);

			Float inventoryMonthAmount = inventoryMonth
					.getInventoryMonthAmount() + oldInOutInfo.getInOutAmount();
			inventoryMonth.setInventoryMonthAmount(inventoryMonthAmount);
			basInventoryMonthDao.update(inventoryMonth);
		}
		return basInOutInfoDao.deleteInOutInfoById(inOutInfo.getIoId());
		// return basInOutInfoDao.deleteInOutInfoById(ioId);
	}

}
