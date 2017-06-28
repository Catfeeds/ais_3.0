package com.digihealth.anesthesia.doc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.config.OperationState;
import com.digihealth.anesthesia.basedata.formbean.DesignedOptCodes;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.formbean.OptNurseInstrubillItemFormbean;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.formbean.SearchRegOptByIdFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.digihealth.anesthesia.evt.service.EvtParticipantService;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.websocket.WebSocketHandler;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 本溪局点手术清点单逻辑和其他局点有很大不同，这里讲本溪局点的手术清点单单独写出来
 * <功能详细描述>
 * 
 * @author  姓名 工号
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocOptNurseForSYBXController",description="手术清点单处理类")
public class DocOptNurseForSYBXController extends BaseController
{
    @RequestMapping(value = "/searchOptNurseForSYBX")
    @ResponseBody
    @ApiOperation(value="根据手术ID获取手术清点单",httpMethod="POST",notes="根据手术ID获取手术清点单")
    public String searchOptNurseForSYBX(@ApiParam(name="map", value ="查询参数") @RequestBody Map map) {
        logger.info("----------------------begin searchOptNurseForSYBX-----------------------");
        ResponseValue resp = new ResponseValue();
        String regOptId = map.get("regOptId") != null ? map.get("regOptId").toString() : "";
        
        DocOptNurse optNurse = docOptNurseService.searchOptNurseByRegOptId(regOptId);
        if (optNurse == null)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("护理记录单不存在");
            return resp.getJsonStr();
        }
        
        List<DocInstrubillItem> instrubillItem = docInstrubillItemService.searchInstrubillItemByRegOptId(regOptId);
        List<SearchRegOptByIdFormBean> searchRegOptByIdFormBeanList = basRegOptService.searchApplicationById(regOptId);
        SearchRegOptByIdFormBean searchRegOptByIdFormBean =
            searchRegOptByIdFormBeanList != null ? searchRegOptByIdFormBeanList.get(0) : null;
        
        DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
        SearchFormBean searchBean = new SearchFormBean();
        searchBean.setDocId(anaesRecord.getAnaRecordId());
        String isLocalAnaes = searchRegOptByIdFormBean.getIsLocalAnaes();
        
        // 器械护士处理 首次进入清点单或者点击数据同步时，不从清点表中获取数据
        List<String> instrnuseList = new ArrayList<String>();
        if (null == optNurse.getInstrnuseId() || "1".equals(map.get("type")))
        {
            // 全麻时从麻醉记录单中获取到器械护士
            if ("0".equals(isLocalAnaes))
            {
                searchBean.setRole(EvtParticipantService.ROLE_NURSE);
                searchBean.setType(EvtParticipantService.OPER_TYPE_INSTRUMENT);
                List<UserInfoFormBean> instruNurseList = evtParticipantService.getSelectParticipantList(searchBean);
                if (instruNurseList != null && instruNurseList.size() > 0)
                {
                    for (int i = 0; i < instruNurseList.size(); i++)
                    {
                        instrnuseList.add(instruNurseList.get(i).getId());
                    }
                    optNurse.setInstrnuseId(StringUtils.getStringByList(instrnuseList));
                }
            }
            else
            {
                // 局麻时从手术排程中获取到器械护士
                BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
                if (null != dispatch)
                {
                    if (StringUtils.isNotBlank(dispatch.getInstrnurseId1()))
                    {
                        instrnuseList.add(dispatch.getInstrnurseId1());
                    }
                    
                    if (StringUtils.isNotBlank(dispatch.getInstrnurseId2()))
                    {
                        instrnuseList.add(dispatch.getInstrnurseId2());
                    }
                }
            }
        }
        else
        {
            instrnuseList = StringUtils.getListByString(optNurse.getInstrnuseId());
        }
        optNurse.setInstrnuseList(instrnuseList);
        
        // 巡回护士处理 首次进入清点单或者点击数据同步时，不从清点表中获取数据
        List<String> circunurseList = new ArrayList<String>();
        if (null == optNurse.getCircunurseId() || "1".equals(map.get("type")))
        {
            // 全麻时从麻醉记录单中获取到巡回护士
            if ("0".equals(isLocalAnaes))
            {
                searchBean.setRole(EvtParticipantService.ROLE_NURSE);
                searchBean.setType(EvtParticipantService.OPER_TYPE_TOUR);
                List<UserInfoFormBean> circuNurseList = evtParticipantService.getSelectParticipantList(searchBean);
                if (circuNurseList != null && circuNurseList.size() > 0)
                {
                    for (int i = 0; i < circuNurseList.size(); i++)
                    {
                        circunurseList.add(circuNurseList.get(i).getId());
                    }
                    optNurse.setCircunurseId(StringUtils.getStringByList(circunurseList));
                }
            }
            else
            {
                // 局麻时从手术排程中获取到巡回护士
                BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
                if (null != dispatch)
                {
                    if (StringUtils.isNotBlank(dispatch.getCircunurseId1()))
                    {
                        circunurseList.add(dispatch.getCircunurseId1());
                    }
                    
                    if (StringUtils.isNotBlank(dispatch.getCircunurseId2()))
                    {
                        circunurseList.add(dispatch.getCircunurseId2());
                    }
                }
            }
        }
        else
        {
            circunurseList = StringUtils.getListByString(optNurse.getCircunurseId());
        }
        optNurse.setCircunurseList(circunurseList);
        
        // 手术名称处理 首次进入清点单或者点击数据同步时，不从清点表中获取数据
        List<DesignedOptCodes> operationNameList = new ArrayList<DesignedOptCodes>();
        String operatorId = optNurse.getOperatorId();
        if (null == operatorId || "1".equals(map.get("type")))
        {
            // 全麻时从麻醉记录单中获取到手术名称
            if ("0".equals(isLocalAnaes))
            {
                List<EvtOptRealOper> optROList = evtOptRealOperService.searchOptRealOperList(searchBean);
                String operationNameId = "";
                if (optROList != null && optROList.size() > 0)
                {
                    for (int i = 0; i < optROList.size(); i++)
                    {
                        DesignedOptCodes optCode = new DesignedOptCodes();
                        String operId = optROList.get(i).getOperDefId();
                        BasOperdef basOperdef = basOperdefService.queryOperdefById(operId);
                        if(null != basOperdef)
                        {
                            optCode.setOperDefId(operId);
                            optCode.setName(basOperdef.getName());
                            optCode.setPinYin(basOperdef.getPinYin());
                        }
                        operationNameList.add(optCode);
                        
                        if (StringUtils.isBlank(operationNameId))
                        {
                            operationNameId = operId;
                        }
                        else
                        {
                            operationNameId = operationNameId + "," + operId;
                        }
                    }
                }
            }
            else
            {
                // 局麻时从手术基本信息中获取到手术名称
                if (StringUtils.isNotBlank(searchRegOptByIdFormBean.getDesignedOptCode()))
                {
                    String[] ary = searchRegOptByIdFormBean.getDesignedOptCode().split(",");
                    for (int i = 0; i < ary.length; i++)
                    {
                        DesignedOptCodes optCode = new DesignedOptCodes();
                        BasOperdef basOperdef = basOperdefService.queryOperdefById(ary[i]);
                        if (null != basOperdef)
                        {
                            optCode.setOperDefId(ary[i]);
                            optCode.setName(basOperdef.getName());
                            optCode.setPinYin(basOperdef.getPinYin());
                        }
                        operationNameList.add(optCode);
                    }
                }
            }
        }
        else if (StringUtils.isNotBlank(operatorId))
        {
            String[] ary = operatorId.split(",");
            for (int i = 0; i < ary.length; i++)
            {
                DesignedOptCodes optCode = new DesignedOptCodes();
                BasOperdef basOperdef = basOperdefService.queryOperdefById(ary[i]);
                if (null != basOperdef)
                {
                    optCode.setOperDefId(ary[i]);
                    optCode.setName(basOperdef.getName());
                    optCode.setPinYin(basOperdef.getPinYin());
                }
                operationNameList.add(optCode);
            }
        }
        optNurse.setOperationNameList(operationNameList);
        
        // 手术体位处理
        List<String> optBodyList = new ArrayList<String>();
        if (null == optNurse.getOptBody() || "1".equals(map.get("type")))
        {
            // 全麻时从麻醉记录单获取
            if ("0".equals(isLocalAnaes))
            {
                String optBodys = anaesRecord.getOptBody();
                optBodyList = StringUtils.getListByString(optBodys);
                optNurse.setOptBody(optBodys);
            }
            // 局麻时从基本信息获取
            else
            {
                BasDispatch dispatch = basDispatchService.getDispatchOper(regOptId);
                optBodyList.add(dispatch.getOptBody());
            }
        }
        else
        {
            optBodyList = StringUtils.getListByString(optNurse.getOptBody());
        }
        optNurse.setOptBodyList(optBodyList);
        
        // 麻醉方法处理
        List<String> anaesMethodList = new ArrayList<String>();
        if (null == optNurse.getAnaesMethodId() || "1".equals(map.get("type")))
        {
            if ("0".equals(isLocalAnaes))
            {
                List<EvtRealAnaesMethod> realAnaesMethodList =
                    evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
                if (null != realAnaesMethodList && realAnaesMethodList.size() > 0)
                {
                    for (int i = 0; i < realAnaesMethodList.size(); i++)
                    {
                        anaesMethodList.add(realAnaesMethodList.get(i).getAnaMedId());
                    }
                    optNurse.setAnaesMethodId(StringUtils.getStringByList(anaesMethodList));
                }
            }
            else
            {
                // 局麻从手术基本信息中获取到麻醉方法
                anaesMethodList = StringUtils.getListByString(searchRegOptByIdFormBean.getDesignedAnaesMethodCode());
            }
        }
        else
        {
            anaesMethodList = StringUtils.getListByString(optNurse.getAnaesMethodId());
        }
        optNurse.setAnaesMethodList(anaesMethodList);
        
        if ((null == optNurse.getInOperRoomTime() && "0".equals(isLocalAnaes)) || "1".equals(map.get("type")))
        {
            String inOperRoomTime = anaesRecord.getInOperRoomTime();
            
            if (null != inOperRoomTime && null != DateUtils.getParseTime(inOperRoomTime))
            {
                optNurse.setInOperRoomTime(DateUtils.getParseTime(inOperRoomTime));
            }
        }
        
        if ((null == optNurse.getOutOperRoomTime() && "0".equals(isLocalAnaes)) || "1".equals(map.get("type")))
        {
            String outOperRoomTime = anaesRecord.getOutOperRoomTime();
            
            if (null != outOperRoomTime && null != DateUtils.getParseTime(outOperRoomTime))
            {
                optNurse.setOutOperRoomTime(DateUtils.getParseTime(outOperRoomTime));
            }
        }
        
        // 点击数据同步时 需要将数据更新到数据库中
        if ("1".equals("type"))
        {
            OptNurseInstrubillItemFormbean optNurseItem = new OptNurseInstrubillItemFormbean();
            optNurseItem.setOptNurse(optNurse);
            docOptNurseService.updateOptNurse(optNurseItem);
        }
        
        // 局麻手术第一次进入手术室时，需要将手术状态改为术中
        if ("1".equals(isLocalAnaes) && null == optNurse.getInOperRoomTime())
        {
            controllerService.changeControllerState(searchRegOptByIdFormBean.getRegOptId(), OperationState.SURGERY);
            optNurse.setInOperRoomTime(new Date());
            OptNurseInstrubillItemFormbean optNurseItem = new OptNurseInstrubillItemFormbean();
            optNurseItem.setOptNurse(optNurse);
            docOptNurseService.updateOptNurse(optNurseItem);
            
            // 将消息推送到手术室大屏
            BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
            String bedStr = StringUtils.isNotBlank(regOpt.getBed()) == true ? regOpt.getBed() + "床的" : "";
            WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName() + regOpt.getRegionName() + bedStr
                + regOpt.getName() + "开始手术");
        }
        
        // 血型列表
        List<SysCodeFormbean> bloodTypeList = basSysCodeService.searchSysCodeByGroupId("blood_type", null);
        searchBean.setSubType("1");
        List<SearchOptOperIoevent> transfusionList = evtInEventService.searchIoeventList(searchBean);
        searchBean.setSubType("2");
        List<SearchOptOperIoevent> bloodList = evtInEventService.searchIoeventList(searchBean);
        
        resp.put("result", "true");
        resp.put("optNurseItem", optNurse);
        resp.put("instrubillItem", instrubillItem);
        resp.put("searchRegOptByIdFormBean", searchRegOptByIdFormBean);
        resp.put("bloodTypeList", bloodTypeList);
        resp.put("transfusionList", transfusionList);
        resp.put("bloodList", bloodList);
        
        logger.info("---------------------------end searchOptNurseByRegOptId------------------------");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/updateOptNurseForSYBX")
    @ResponseBody
    @ApiOperation(value="修改手术清点单",httpMethod="POST",notes="修改手术清点单")
    public String updateOptNurse(@ApiParam(name="optNurseFormBean", value ="修改参数") @RequestBody OptNurseInstrubillItemFormbean optNurseFormBean) 
    {
        logger.info("-------------------------begin updateOptNurseForSYBX---------------------------------");
        ResponseValue resp = new ResponseValue();
        DocOptNurse optNurse = optNurseFormBean.getOptNurse();
        if (optNurse == null)
        {
            resp.setResultCode("40000002");
            resp.setResultMessage("护理记录单不存在");
            return resp.getJsonStr();
        }
        String regOptId = optNurse.getRegOptId() != null ? optNurse.getRegOptId() : "";
        BasRegOpt regOpt = basRegOptService.searchRegOptById(regOptId);
        optNurse.setInstrnuseId(StringUtils.getStringByList(optNurse.getInstrnuseList()));
        optNurse.setCircunurseId(StringUtils.getStringByList(optNurse.getCircunurseList()));
        List<DesignedOptCodes> operationNameList = optNurse.getOperationNameList();
        if (null != operationNameList && operationNameList.size() > 0)
        {
            String operatorId = "";
            for (DesignedOptCodes designedOptCode : operationNameList)
            {
                if (StringUtils.isBlank(operatorId))
                {
                    operatorId = designedOptCode.getOperDefId();
                }
                else
                {
                    operatorId = operatorId + "," + designedOptCode.getOperDefId();
                }
            }
            optNurse.setOperatorId(operatorId);
        }
        
        
        optNurse.setOptBody(StringUtils.getStringByList(optNurse.getOptBodyList()));
        optNurse.setAnaesMethodId(StringUtils.getStringByList(optNurse.getAnaesMethodList()));
        
        // 局麻手术时，提交护理单需要将手术状态改为术后
        if ("1".equals(regOpt.getIsLocalAnaes()) && "END".equals(optNurse.getProcessState()))
        {
            controllerService.changeControllerState(regOptId, OperationState.POSTOPERATIVE);
            
            String leaveTo = "";
            // 将消息推送到手术室大屏
            if (null != optNurse.getLeaveTo())
            {
                if (1 == optNurse.getLeaveTo())
                {
                    leaveTo = "病房";
                }
                
                if (2 == optNurse.getLeaveTo())
                {
                    leaveTo = "PACU";
                }
                
                if (3 == optNurse.getLeaveTo())
                {
                    leaveTo = "ICU";
                }
                
                if (4 == optNurse.getLeaveTo())
                {
                    leaveTo = "死亡";
                }
            }
            
            WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName() + regOpt.getRegionName() + regOpt.getBed()
                + regOpt.getName() + "手术已结束,去往" + leaveTo);
            
            // 获取麻醉记录单信息，局麻时将手术开始时间和结束时间写入到麻醉记录单中
            DocAnaesRecord anaesRecord = docAnaesRecordService.searchAnaesRecordByRegOptId(regOptId);
            anaesRecord.setOperStartTime(DateUtils.formatDateTime(optNurse.getInOperRoomTime()));
            anaesRecord.setOperEndTime(DateUtils.formatDateTime(optNurse.getOutOperRoomTime()));
            anaesRecord.setOptBody(optNurse.getOptBody());
            docAnaesRecordService.saveAnaesRecord(anaesRecord);
        }
        optNurseFormBean.setOptNurse(optNurse);
        resp = docOptNurseService.updateOptNurse(optNurseFormBean);
        
        logger.info("--------------------------end updateOptNurseForSYBX----------------------------");
        return resp.getJsonStr();
    }
}
