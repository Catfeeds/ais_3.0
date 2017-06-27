/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.OptNurseInstrubillItemFormbean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: PreVisitController.java Description: 描述
 * 
 * @author chengwang
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocOptNurseController",description="手术清点单处理类")
public class DocOptNurseController extends BaseController {

	/**
	 * 
	 * @discription 根据手术ID获取手术护理
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	@RequestMapping(value = "/searchOptNurseByRegOptId")
	@ResponseBody
	@ApiOperation(value="根据手术ID获取手术清点单",httpMethod="POST",notes="根据手术ID获取手术清点单")
	public String searchOptNurseByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
		logger.info("begin searchOptNurseByRegOptId");
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId")!=null?map.get("regOptId").toString():"";
		String type = map.get("type")!=null?map.get("type").toString():"";
		
		DocOptNurse optNurse = docOptNurseService.searchOptNurseByRegOptId(regOptId);
		if(optNurse == null){
			resp.setResultCode("40000002");
			resp.setResultMessage("护理记录单不存在");
			return resp.getJsonStr();
		}
		List<DocInstrubillItem> instrubillItem = docInstrubillItemService.searchInstrubillItemByRegOptId(regOptId);
		List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
		SearchRegOptByIdFormBean searchRegOptByIdFormBean =  searchRegOptByIdFormBeanList!=null?searchRegOptByIdFormBeanList.get(0):null;
		
		
		DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
        SearchFormBean searchBean = new SearchFormBean();
        searchBean.setDocId(anaesRecord.getAnaRecordId());
		String isLocalAnaes = searchRegOptByIdFormBean.getIsLocalAnaes();
		
		//术前巡回护士
		List<String> preCircunurseList = new ArrayList<String>();
        if (null == optNurse.getPreCircunurseId())
        {
            if ("0".equals(isLocalAnaes))
            {
                searchBean.setRole(EvtParticipantService.ROLE_NURSE);
                searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);
                List<UserInfoFormBean> tourNurseList = evtParticipantService.getSelectParticipantList(searchBean);
                if (tourNurseList != null && tourNurseList.size() > 0) {
                    for (int i = 0; i < tourNurseList.size(); i++) {
                        preCircunurseList.add(tourNurseList.get(i).getId());
                    }
                }
            } else {
                //局麻时从手术排程中获取到器械护士
                BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
                if (null != dispatch) {
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(dispatch.getCircunurseId1())) {
                        preCircunurseList.add(dispatch.getCircunurseId1());
                    }
                    
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(dispatch.getCircunurseId2())) {
                        preCircunurseList.add(dispatch.getCircunurseId2());
                    }
                }
            }
        }
        else if (!"".equals(optNurse.getPreCircunurseId()))
        {
            String[] circuNurseAry = optNurse.getPreCircunurseId().split(",");
            if (null != circuNurseAry && circuNurseAry.length > 0) {
                for (int i = 0; i < circuNurseAry.length; i++) {
                    preCircunurseList.add(circuNurseAry[i]);
                }
            }
        }
        optNurse.setPreCircunurseList(preCircunurseList);
        
        //术后巡回护士
        List<String> postCircunurseList = new ArrayList<String>();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(optNurse.getPostCircunurseId()))
        {
            String[] postCircunurseAry = optNurse.getPostCircunurseId().split(",");
            if (null != postCircunurseAry && postCircunurseAry.length > 0) {
                for (int i = 0; i < postCircunurseAry.length; i++) {
                    postCircunurseList.add(postCircunurseAry[i]);
                }
            }
        }
        optNurse.setPostCircunurseList(postCircunurseList);
        
        //术中巡回护士
        List<String> midCircunurseList = new ArrayList<String>();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(optNurse.getMidCircunurseId())) {
            String[] midCircunurseAry = optNurse.getMidCircunurseId().split(",");
            if (null != midCircunurseAry && midCircunurseAry.length > 0) {
                for (int i = 0; i < midCircunurseAry.length; i++) {
                    midCircunurseList.add(midCircunurseAry[i]); 
                }
            }
        }
        optNurse.setMidCircunurseList(midCircunurseList);
        
        //术前洗手护士
        if (null == optNurse.getInstrnuseId())
        {
            if ("0".equals(isLocalAnaes))
            {
                searchBean.setRole(EvtParticipantService.ROLE_NURSE);
                searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);
                List<UserInfoFormBean> instruNurseList = evtParticipantService.getSelectParticipantList(searchBean);
                if (instruNurseList != null && instruNurseList.size() > 0)
                {
                    optNurse.setInstrnuseId(instruNurseList.get(0).getName());
                }
            }
            else
            {
                //局麻时从手术排程中获取到巡回护士
                BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
                if (null != dispatch)
                {
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(dispatch.getInstrnurseId1()))
                    {
                        optNurse.setInstrnuseId(basUserService.searchUserById(dispatch.getInstrnurseId1(), getBeid()).getName());
                    }
                }
            }
        }
        
        if ("1".equals(type))
        {
            OptNurseInstrubillItemFormbean optNurseItem = new OptNurseInstrubillItemFormbean();
            optNurseItem.setOptNurse(optNurse);
            docOptNurseService.updateOptNurse(optNurseItem);
        }
        
		resp.put("result", "true");
		resp.put("resultCode", "1");
		resp.put("resultMessage", "查询成功!");
		resp.put("optNurseItem", optNurse);
		resp.put("instrubillItem", instrubillItem);
		resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
		logger.info("-----------------end searchOptNurseByRegOptId-----------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 修改手术护理
	 * @author chengwang
	 * @created 2015-10-20 上午9:33:40
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "/updateOptNurse")
	@ResponseBody
	@ApiOperation(value="修改手术清点单",httpMethod="POST",notes="修改手术清点单")
	public String updateOptNurse(@ApiParam(name="optNurseItem", value ="修改参数") @RequestBody OptNurseInstrubillItemFormbean optNurseItem) {
		logger.info("-----------------begin updateOptNurse-----------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(optNurseItem.getOptNurse());
		if(!(validatorBean.isValidator())){
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		resp = docOptNurseService.updateOptNurse(optNurseItem);
		logger.info("-----------------end updateOptNurse-----------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 插入器械
	 * @author chengwang
	 * @created 2015-10-22 下午1:56:23
	 * @return
	 */
	@RequestMapping(value = "/insertInstrubillItem")
	@ResponseBody
	@ApiOperation(value="插入器械",httpMethod="POST",notes="插入器械")
	public String insertInstrubillItem(@ApiParam(name="map", value ="保存参数") @RequestBody Map<String, Object> map) {
		logger.info("-----------------begin insertInstrubillItem-----------------");
		ResponseValue resp = new ResponseValue();
		String regOptId = map.get("regOptId") == null ? "" : map.get("regOptId").toString();
		String optNurseId = map.get("optNurseId") == null ? "" : map.get("optNurseId").toString();
		String instrumentCode = map.get("instrumentId") == null ? "" : map.get("instrumentId").toString();
		String instrsuitCode = map.get("instrsuitId") == null ? "" : map.get("instrsuitId").toString();
		List<DocInstrubillItem> list = docOptNurseService.insertInstubillItem(regOptId,
				optNurseId, instrumentCode, instrsuitCode);
		resp.put("result", list);
		logger.info("-----------------end insertInstrubillItem-----------------");
		return resp.getJsonStr();
	}

	/**
	 * 
	 * @discription 删除器械
	 * @author chengwang
	 * @created 2015-10-23 上午9:39:38
	 */
	@RequestMapping(value = "/deleteInstrubillItem")
	@ResponseBody
	@ApiOperation(value="删除器械",httpMethod="POST",notes="删除器械")
	public String deleteInstrubillItem(@ApiParam(name="map", value ="删除参数") @RequestBody Map<String, Object> map) {
		logger.info("-----------------begin deleteInstrubillItem-----------------");
		ResponseValue resp = new ResponseValue();
		String instruItemId = map.get("instruItemId")!=null?map.get("instruItemId").toString():"";
		int result =docInstrubillItemService.deleteInstrubillItem(instruItemId);
		if(result == 1){
			resp.setResultCode("1");
			resp.setResultMessage("删除手术所用器械成功!");
		}
		if(result == 0){
			resp.setResultCode("1");
			resp.setResultMessage("删除手术所用器械失败!");
		}
		logger.info("-----------------end deleteInstrubillItem-----------------");
		return resp.getJsonStr();
	}

}
