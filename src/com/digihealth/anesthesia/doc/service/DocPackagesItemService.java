/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.config.ChargeStateOption;
import com.digihealth.anesthesia.basedata.config.ChargeTypeOption;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItem;
import com.digihealth.anesthesia.basedata.po.BasChargeItemPackagesRel;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.BeanHelper;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.doc.po.DocPackagesItem;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: PackagesItemService.java    
     * Description: 收费项目
     * @author chengwang       
     * @created 2015年12月16日 下午2:07:08
 */
@Service
public class DocPackagesItemService extends BaseService {

	public List<DocPackagesItem> queryPackagesItemList(SystemSearchFormBean systemSearchFormBean,int type){
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!org.apache.commons.lang3.StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if("user_type".equals(filters.get(i).getField().toString())||"reg_opt_id".equals(filters.get(i).getField().toString())){
						filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
					}
					
				}
			}
		}
		//表示查询收费套餐包
		if(type == 1){
			filter = filter + " AND charge_pkg_id is not null ";
		}
		//表示查询单项收费
		if(type == 0){
			filter = filter + " AND charge_pkg_id is null ";
		}
		List<DocPackagesItem> resultList = docPackagesItemDao.queryPackagesItemList(filter, systemSearchFormBean, getBeid());
		List<DocPackagesItem> packagesItemList = new ArrayList<DocPackagesItem>();
		if(resultList!=null && resultList.size()>0){
			for(int i = 0 ; i < resultList.size();i++){
				DocPackagesItem packageItem = new DocPackagesItem();
				BeanHelper.copyProperties(resultList.get(i), packageItem);
				
				BasChargeItem chargeItem = basChargeItemDao.searchChargeItemById(resultList.get(i).getChargeItemId()+"",getBeid());
				packageItem.setChargeType(ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())?"复杂":"简单");
				packageItem.setName(chargeItem.getChargeItemName());
				if(chargeItem.getChargeType()!=null && ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())){
					Float basicUnitAmount = chargeItem.getBasicUnitAmount();
					Float basicUnitPrice = chargeItem.getBasicUnitPrice();
					Float unitAmount = packageItem.getChargeAmount() - basicUnitAmount;
					if(unitAmount > 0){
						packageItem.setShouldSum(basicUnitPrice + chargeItem.getPrice()*unitAmount);
						packageItem.setRealSum((basicUnitPrice + chargeItem.getPrice()*unitAmount)*packageItem.getDiscount());
					}else{
						packageItem.setShouldSum(basicUnitPrice);
						packageItem.setRealSum(basicUnitPrice*packageItem.getDiscount());
					}
				}else{
					packageItem.setShouldSum(packageItem.getPriceMinPackage()*packageItem.getChargeAmount());
					packageItem.setRealSum((packageItem.getPriceMinPackage()*packageItem.getChargeAmount())*packageItem.getDiscount());
				}
				packagesItemList.add(packageItem);
			}
		}
		return packagesItemList;
	}
	
	@Transactional
	public List<DocPackagesItem> insertPackagesItem(DocPackagesItem viewPackagesItem){
		List<DocPackagesItem> packagesItemList = new ArrayList<DocPackagesItem>();
		BasChargeItem chargeItem = null;
		if(viewPackagesItem.getChargeItemId()!=null){
			chargeItem = basChargeItemDao.searchChargeItemById(viewPackagesItem.getChargeItemId()+"",getBeid());
			if(chargeItem != null){
				DocPackagesItem packagesItem = new DocPackagesItem();
				packagesItem.setPkItId(GenerateSequenceUtil.generateSequenceNo());
				packagesItem.setCreateTime(DateUtils.getDateTime());
				packagesItem.setCreateUser(viewPackagesItem.getCreateUser());
				packagesItem.setUserType(viewPackagesItem.getUserType());
				packagesItem.setChargeItemId(Integer.parseInt(chargeItem.getChargeItemId()));
				packagesItem.setDiscount(1f);
				packagesItem.setName(chargeItem.getChargeItemName());
				packagesItem.setChargeAmount(1f);
				packagesItem.setIsCharge(true);
				packagesItem.setPriceMinPackage(chargeItem.getPrice());
				packagesItem.setRegOptId(viewPackagesItem.getRegOptId());
				packagesItem.setState(ChargeStateOption.NO_FINISH);
				packagesItem.setUnit(chargeItem.getUnit());
				packagesItem.setChargeType(ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())?"复杂":"简单");
				if(chargeItem.getChargeType()!=null && ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())){
					Float basicUnitAmount = chargeItem.getBasicUnitAmount();
					Float basicUnitPrice = chargeItem.getBasicUnitPrice();
					Float unitAmount = packagesItem.getChargeAmount() - basicUnitAmount;
					if(unitAmount > 0){
						packagesItem.setShouldSum(basicUnitPrice + chargeItem.getPrice()*unitAmount);
						packagesItem.setRealSum((basicUnitPrice + chargeItem.getPrice()*unitAmount)*packagesItem.getDiscount());
					}else{
						packagesItem.setShouldSum(basicUnitPrice);
						packagesItem.setRealSum(basicUnitPrice*packagesItem.getDiscount());
					}
				}else{
					packagesItem.setShouldSum(packagesItem.getPriceMinPackage()*packagesItem.getChargeAmount());
					packagesItem.setRealSum((packagesItem.getPriceMinPackage()*packagesItem.getChargeAmount())*packagesItem.getDiscount());
				}
				docPackagesItemDao.insert(packagesItem);
				packagesItemList.add(packagesItem);
			}
		}else if(viewPackagesItem.getChargePkgId()!=null){
			List<BasChargeItemPackagesRel> checkPacList =   basChargeItemPackagesRelDao.searchChargeItemByChargePackagesId(viewPackagesItem.getChargePkgId()+"");
			if(checkPacList != null && checkPacList.size()>0){
				String flag = DateUtils.getDate(new Date());
				for(int i = 0 ; i < checkPacList.size();i++){
					chargeItem = basChargeItemDao.searchChargeItemById(checkPacList.get(i).getChargeItemId(),getBeid());
					if(chargeItem != null){
						DocPackagesItem packagesItem = new DocPackagesItem();
						packagesItem.setPkItId(GenerateSequenceUtil.generateSequenceNo());
						packagesItem.setCreateTime(DateUtils.getDateTime());
						packagesItem.setCreateUser(viewPackagesItem.getCreateUser());
						packagesItem.setUserType(viewPackagesItem.getUserType());
						packagesItem.setChargeItemId(Integer.parseInt(chargeItem.getChargeItemId()));
						packagesItem.setDiscount(1f);
						packagesItem.setName(chargeItem.getChargeItemName());
						packagesItem.setFlag(flag);
						packagesItem.setChargeType(ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())?"复杂":"简单");
						packagesItem.setChargePkgId(Integer.parseInt(checkPacList.get(i).getChargePkgId()));
						packagesItem.setChargeAmount(checkPacList.get(i).getChgItemAmount());
						packagesItem.setIsCharge(true);
						if(chargeItem.getChargeType()!=null && ChargeTypeOption.COMPLEX.equals(chargeItem.getChargeType())){
							Float basicUnitAmount = chargeItem.getBasicUnitAmount();
							Float basicUnitPrice = chargeItem.getBasicUnitPrice();
							Float unitAmount = packagesItem.getChargeAmount() - basicUnitAmount;
							if(unitAmount > 0){
								packagesItem.setShouldSum(basicUnitPrice + chargeItem.getPrice()*unitAmount);
								packagesItem.setRealSum((basicUnitPrice + chargeItem.getPrice()*unitAmount)*packagesItem.getDiscount());
							}else{
								packagesItem.setShouldSum(basicUnitPrice);
								packagesItem.setRealSum(basicUnitPrice*packagesItem.getDiscount());
							}
						}else{
							packagesItem.setShouldSum(packagesItem.getPriceMinPackage()*packagesItem.getChargeAmount());
							packagesItem.setRealSum((packagesItem.getPriceMinPackage()*packagesItem.getChargeAmount())*packagesItem.getDiscount());
						}
						packagesItem.setPriceMinPackage(chargeItem.getPrice());
						packagesItem.setRegOptId(viewPackagesItem.getRegOptId());
						packagesItem.setState(ChargeStateOption.NO_FINISH);
						packagesItem.setUnit(chargeItem.getUnit());
						docPackagesItemDao.insert(packagesItem);
						packagesItemList.add(packagesItem);
					}
				}
			}
		}
		return packagesItemList;
	}
	
	@Transactional
	public int updateIsCharge(DocPackagesItem packagesItem){
		return docPackagesItemDao.updateIsCharge(packagesItem);
	}
	
}
