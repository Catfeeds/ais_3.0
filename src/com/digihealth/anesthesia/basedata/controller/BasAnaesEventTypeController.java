package com.digihealth.anesthesia.basedata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.AnaesEventFormBean;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesEventTypeController", description = "麻醉事件处理类")
public class BasAnaesEventTypeController extends BaseController {

	@RequestMapping(value = "/deleteAnaesEventType")
	@ResponseBody
    @ApiOperation(value = "删除麻醉事件", httpMethod = "POST", notes = "删除麻醉事件")
	public String deleteAnaesEventType(@ApiParam(name = "anaesEventFormBean", value = "删除参数") @RequestBody AnaesEventFormBean anaesEventFormBean) {
		logger.info("begin deleteAnaesEventType");
        String result = basSysCodeService.deleteAnaesEvent(anaesEventFormBean);
        logger.info("end deleteAnaesEventType");
        return result;
	}

	@RequestMapping(value = "/updateAnaesEventType")
	@ResponseBody
    @ApiOperation(value = "修改麻醉事件", httpMethod = "POST", notes = "修改麻醉事件")
	public String updateAnaesEventType(@ApiParam(name = "anaesEventFormBean", value = "修改参数") @RequestBody AnaesEventFormBean anaesEventFormBean) {
		logger.info("begin updateAnaesEventType");
        String result = basSysCodeService.updateAnaesEvent(anaesEventFormBean);
        logger.info("end updateAnaesEventType");
        return result;
	}
}
