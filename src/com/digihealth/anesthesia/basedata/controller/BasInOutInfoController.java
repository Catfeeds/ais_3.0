package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInOutInfo;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: InOutInfoController.java    
     * Description: 出入库
     * @author chengwang       
     * @created 2015年12月15日 上午10:04:53
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasInOutInfoController", description = "出入库处理类")
public class BasInOutInfoController extends BaseController{

	@RequestMapping(value = "/updateInOutInfo")
	@ResponseBody
	@ApiOperation(value = "更新出入库信息", httpMethod = "POST", notes = "更新出入库信息")
	public String updateInOutInfo(@ApiParam(name = "inOutInfo", value = "出入库信息对象") @RequestBody BasInOutInfo inOutInfo){
        logger.info("begin updateInOutInfo");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(inOutInfo);
        if (!(validatorBean.isValidator()))
        {
            resp.setResultCode("10000001");
            resp.setResultMessage(validatorBean.getMessage());
            return resp.getJsonStr();
        }
        basInOutInfoService.updateInOutInfo(inOutInfo);
        logger.info("end updateInOutInfo");
        return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchInOutInfo")
	@ResponseBody
	@ApiOperation(value = "查询入库信息", httpMethod = "POST", notes = "查询入库信息")
	public String searchInOutInfo(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean ){
		logger.info("begin searchInOutInfo");
		ResponseValue resp = new ResponseValue();
		List<BasInOutInfo> inOutInfoList = basInOutInfoService.searchInOutInfo(systemSearchFormBean);
		int total = basInOutInfoService.searchTotalInOutInfo(systemSearchFormBean);
		resp.put("resultList", inOutInfoList);
		resp.put("total", total);
		logger.info("end searchInOutInfo");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchOutInfo")
	@ResponseBody
	@ApiOperation(value = "查询出库信息", httpMethod = "POST", notes = "查询出库信息")
	public String searchOutInfo(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean ){
		logger.info("begin searchInOutInfo");
		ResponseValue resp = new ResponseValue();
		List<BasInOutInfo> inOutInfoList = basInOutInfoService.searchOutInfo(systemSearchFormBean);
		int total = basInOutInfoService.searchTotalOutInfo(systemSearchFormBean);
		resp.put("resultList", inOutInfoList);
		resp.put("total", total);
		logger.info("end searchInOutInfo");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchInOutInfoById")
	@ResponseBody
	@ApiOperation(value = "根据Id查询出入库信息", httpMethod = "POST", notes = "根据Id查询出入库信息")
	public String searchInOutInfoById(@ApiParam(name = "inOutInfo", value = "出入库信息对象") @RequestBody BasInOutInfo inOutInfo){
		logger.info("begin searchInOutInfoById");
		ResponseValue resp = new ResponseValue();
		BasInOutInfo inOutInfoResult = basInOutInfoService.searchInOutInfoById(inOutInfo.getIoId());
		resp.put("inOutInfo", inOutInfoResult);
		logger.info("end searchInOutInfoById");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/deleteInOutInfoById")
	@ResponseBody
	@ApiOperation(value = "删除出入库信息", httpMethod = "POST", notes = "删除出入库信息")
	public String deleteInOutInfoById(@ApiParam(name = "inOutInfo", value = "出入库信息对象") @RequestBody BasInOutInfo inOutInfo) throws Exception{
        logger.info("begin searchInOutInfoById");
        ResponseValue resp = new ResponseValue();
        int result = basInOutInfoService.deleteInOutInfoById(inOutInfo);
        if (result >= 1)
        {
            resp.put("resultMessage", "删除成功!");
        }
        else
        {
            resp.put("resultMessage", "删除失败!");
        }
		logger.info("end deleteInOutInfoById");
		return resp.getJsonStr();
	}
}
