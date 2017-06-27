package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnnouncement;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: AnaesMethodController.java Description: 公告Controller
 * 
 * @author chengwang
 * @created 2015-12-07 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnnouncementController", description = "公告处理类")
public class BasAnnouncementController extends BaseController
{
    
    @RequestMapping(value = "/searchAllAnnouncement")
    @ResponseBody
    @ApiOperation(value = "查询所有公告", httpMethod = "POST", notes = "查询所有公告")
    public String getAnaesMethodList(
        @ApiParam(name = "baseQuery", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin searchAllAnnouncement");
        ResponseValue resp = new ResponseValue();
        List<BasAnnouncement> resultList = basAnnouncementService.searchAllAnnouncement(systemSearchFormBean);
        int total = basAnnouncementService.searchAllAnnouncementTotal();
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end searchAllAnnouncement");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/deleteAnnouncement")
    @ResponseBody
    @ApiOperation(value = "删除公告", httpMethod = "POST", notes = "删除公告")
    public String deleteAnnouncement(
        @ApiParam(name = "announcement", value = "公告对象") @RequestBody BasAnnouncement announcement)
    {
        logger.info("begin deleteAnnouncement");
        ResponseValue resp = new ResponseValue();
        int result = basAnnouncementService.deleteById(announcement.getId());
        if (result >= 1)
        {
            resp.put("resultMessage", "删除公告信息成功");
        }
        else
        {
            resp.put("resultMessage", "删除公告信息失败");
        }
        logger.info("end deleteAnnouncement");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/saveAnnouncement")
    @ResponseBody
    @ApiOperation(value = "发布公告信息", httpMethod = "POST", notes = "发布公告信息")
    public String saveAnnouncement(@ApiParam(name = "announcement", value = "公告对象") @RequestBody BasAnnouncement announcement) {
        logger.info("begin saveAnnouncement");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(announcement);
        if (!(validatorBean.isValidator())) {
            resp.put("resultCode", "10000001");
            resp.put("resultMessage", validatorBean.getMessage());
            return resp.getJsonStr();
        }
        int result = basAnnouncementService.saveAnnouncement(announcement);
        if (result == 1) {
            resp.put("resultMessage", "发布公告信息成功");
        } else {
            resp.put("resultMessage", "发布公告信息失败");
        }
        logger.info("end saveAnnouncement");
        return resp.getJsonStr();
    }
    
}
