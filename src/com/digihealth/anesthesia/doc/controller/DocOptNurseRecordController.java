package com.digihealth.anesthesia.doc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocOptNurseRecord;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 手术护理记录单
 * <功能详细描述>
 * 
 * @author  zhouyi
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocOptNurseRecordController",description="手术护理记录单处理类")
public class DocOptNurseRecordController extends BaseController {
	
	/** 
	 * 查询手术护理单
	 * <功能详细描述>
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "/searchOptNurseRecordByRegOptId")
	@ResponseBody
	@ApiOperation(value="查询手术护理单",httpMethod="POST",notes="查询手术护理单")
	public String searchOptNurseRecByRegOptId(@ApiParam(name="map", value ="查询参数") @RequestBody Map<String, Object> map) {
		logger.info("------------------start searchOptNurseRecordByRegOptId------------------");
		String result = docOptNurseRecordService.searchOptNurseRecByRegOptId(map);
		logger.info("------------------end searchOptNurseRecordByRegOptId------------------");
		return result;
	}

    /** 
     * 保存手术护理单，用户还可以进行修改
     * <功能详细描述>
     * @param optNurseRecord
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updateOptNurseRecord")
    @ResponseBody
	@ApiOperation(value="保存手术护理单，用户还可以进行修改",httpMethod="POST",notes="保存手术护理单，用户还可以进行修改")
    public String updateOptNurseRecord(@ApiParam(name="optNurseRecord", value ="保存参数") @RequestBody DocOptNurseRecord optNurseRecord) {
    	logger.info("------------------start updateOptNurseRecord------------------");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(optNurseRecord);
        if (!(validatorBean.isValidator())) {
        	resp.setResultCode("10000001");
        	resp.setResultMessage(validatorBean.getMessage());
            return resp.getJsonStr();
        }
        String result = docOptNurseRecordService.updateOptNurseRec(optNurseRecord);
		logger.info("------------------end updateOptNurseRecord------------------");
        return result;
    }
    
    /** 
     * 提交手术护理记录单，用户不可更改
     * <功能详细描述>
     * @param optNurseRecord
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/submitOptNurseRecord")
    @ResponseBody
	@ApiOperation(value="提交手术护理记录单，用户不可更改",httpMethod="POST",notes="提交手术护理记录单，用户不可更改")
    public String submitOptNurseRecord(@ApiParam(name="optNurseRecord", value ="保存参数") @RequestBody DocOptNurseRecord optNurseRecord) {
    	logger.info("------------------start submitOptNurseRecord------------------");
    	ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(optNurseRecord);
        if (!(validatorBean.isValidator())) {
        	resp.setResultCode("10000001");
        	resp.setResultMessage(validatorBean.getMessage());
            return resp.getJsonStr();
        }
        String result = docOptNurseRecordService.submitOptNurseRec(optNurseRecord);
        logger.info("------------------start submitOptNurseRecord------------------");
        return result;
    }
    
    /** 
     * 更新手术护理记录单中的输血和输液事件
     * <功能详细描述>
     * @param optNurseRecord
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/updateBloodAndInfusion")
    @ResponseBody
	@ApiOperation(value="更新手术护理记录单中的输血和输液事件",httpMethod="POST",notes="更新手术护理记录单中的输血和输液事件")
    public String updateBloodAndInfusion(@ApiParam(name="optNurseRecord", value ="更新参数") @RequestBody DocOptNurseRecord optNurseRecord) {
    	logger.info("------------------start updateBloodAndInfusion------------------");
    	String result = docOptNurseRecordService.updateBloodAndInfusion(optNurseRecord);
    	logger.info("------------------end updateBloodAndInfusion------------------");
        return result;
    }
	
}
