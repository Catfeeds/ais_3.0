package com.digihealth.anesthesia.tmp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SearchDoctempFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.tmp.po.TmpAnaesDoctemp;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: AnaesDoctempController.java Description: 模板操作
 * 
 * @author pengqing
 * @created 2016-7-29
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "TmpAnaesDoctempController", description = "文书模版处理类")
public class TmpAnaesDoctempController extends BaseController {
	/**
	 * 查询模板信息
	 */
	@RequestMapping(value = "/queryAnaesDoctempList")
	@ResponseBody
	@ApiOperation(value = "查询模板信息", httpMethod = "POST", notes = "查询模板信息")
	public String queryAnaesDoctempList(@ApiParam(name = "searchDoctempFormBean", value = "查询对象") @RequestBody SearchDoctempFormBean searchDoctempFormBean) {
		logger.info("begin queryAnaesDoctempList");
		List<TmpAnaesDoctemp> resultList = tmpAnaesDoctempService.selectAnaesDoctempByForbean(searchDoctempFormBean);
		int total = tmpAnaesDoctempService.selectAnaesDoctempTotalByForbean(searchDoctempFormBean);
		ResponseValue resp = new ResponseValue();
		resp.put("resultList", resultList);
		resp.put("total", total);

		logger.info("end queryAnaesDoctempList");
		return resp.getJsonStr();
	}

//	/**
//	 * 增加模板信息
//	 */
//	@RequestMapping(value = "/saveAnaesDoctemp")
//	@ResponseBody
//	@ApiOperation(value = "增加模板信息", httpMethod = "POST", notes = "增加模板信息")
//	public String saveAnaesDoctemp(@ApiParam(name = "anaesDoctemp", value = "保存参数") @RequestBody TmpAnaesDoctemp anaesDoctemp) {
//		logger.info("begin saveAnaesDoctemp");
//		ResponseValue resp = new ResponseValue();
//		// 前台没有传时间，补个系统时间
//		if (StringUtils.isBlank(anaesDoctemp.getCreateTime())) {
//			String time = DateUtils.getDateTime();
//			anaesDoctemp.setCreateTime(time);
//		}
//		if (StringUtils.isBlank(anaesDoctemp.getCreateName())) {
//			resp.setResultCode("10000003");
//			resp.setResultMessage("创建者名字不能为空");
//			return resp.getJsonStr();
//		}
//		if (StringUtils.isBlank(anaesDoctemp.getMedTempName())) {
//			resp.setResultCode("10000004");
//			resp.setResultMessage("模板名称不能为空");
//			return resp.getJsonStr();
//		}
//		if (anaesDoctemp.getDocType() == null) {
//			resp.setResultCode("10000005");
//			resp.setResultMessage("模板文书类型不能为空");
//			return resp.getJsonStr();
//		}
//		tmpAnaesDoctempService.addAnaesDoctemp(anaesDoctemp);
//		resp.setResultMessage("保存模板成功!");
//		logger.info("end saveAnaesDoctemp");
//		return resp.getJsonStr();
//	}
//
//	/**
//	 * 删除模板信息
//	 */
//	@RequestMapping(value = "/delAnaesDoctemp")
//	@ResponseBody
//	@ApiOperation(value = "删除模板信息", httpMethod = "POST", notes = "删除模板信息")
//	public String DelAnaesDoctemp(@ApiParam(name = "anaesDoctemp", value = "删除参数") @RequestBody TmpAnaesDoctemp anaesDoctemp) {
//		logger.info("begin DelAnaesDoctemp");
//		ResponseValue resp = new ResponseValue();
//		if (null == anaesDoctemp.getId() || "".equals(anaesDoctemp.getId())) {
//			resp.setResultCode("10000001");
//			resp.setResultMessage("需要删除模板的ID不能传空!");
//			return resp.getJsonStr();
//		}
//		tmpAnaesDoctempService.delAnaesDoctemp(anaesDoctemp.getId());
//		resp.setResultMessage("删除模板成功!");
//		logger.info("end DelAnaesDoctemp");
//		return resp.getJsonStr();
//	}
	
	
	 /**
     * 增加模板信息
     */
    @RequestMapping(value = "/addAnaesDoctemp")
    @ResponseBody
    @ApiOperation(value = "增加模板信息", httpMethod = "POST", notes = "增加模板信息")
    public String AddAnaesDoctemp(@ApiParam(name = "anaesDoctemp", value = "保存参数") @RequestBody TmpAnaesDoctemp anaesDoctemp)
    {
        logger.info("begin AddAnaesDoctemp");
        ResponseValue resp = new ResponseValue();
        Boolean resultFlag = true;
        //前台没有传时间，补个系统时间
        if (StringUtils.isBlank(anaesDoctemp.getCreateTime()))
        {
            String time = DateUtils.getDateTime();
            anaesDoctemp.setCreateTime(time);
        }
        if (StringUtils.isBlank(anaesDoctemp.getCreateUser()))
        {
            resp.put("resultCode", "10000002");
            resp.put("resultMessage", "创建者编号不能为空");
            resultFlag = false;
        }
        if (StringUtils.isBlank(anaesDoctemp.getCreateName()))
        {
            resp.put("resultCode", "10000003");
            resp.put("resultMessage", "创建者名字不能为空");
            resultFlag = false;
        }
        if (null == anaesDoctemp.getType() || anaesDoctemp.getType() == 0)
        {
            resp.put("resultCode", "10000004");
            resp.put("resultMessage", "模板类型不能为空");
            resultFlag = false;
        }
        if (null == anaesDoctemp.getDocType() || anaesDoctemp.getDocType() == 0)
        {
            resp.put("resultCode", "10000005");
            resp.put("resultMessage", "模板文书类型不能为空");
            resultFlag = false;
        }
        if (resultFlag)
        {
            tmpAnaesDoctempService.addAnaesDoctemp(anaesDoctemp);
        }
        logger.info("end AddAnaesDoctemp");
        return resp.getJsonStr();

    }
    
    
     /**
     * 修改模板信息
     */
    @RequestMapping(value = "/upAnaesDoctemp")
    @ResponseBody
    @ApiOperation(value = "更新模板信息", httpMethod = "POST", notes = "更新模板信息")
    public String upAnaesDoctemp(@ApiParam(name = "anaesDoctemp", value = "更新参数") @RequestBody TmpAnaesDoctemp  anaesDoctemp) {
        logger.info("begin upAnaesDoctemp");
        Boolean resultFlag = true;
        ResponseValue resp = new ResponseValue();
        if (StringUtils.isBlank(anaesDoctemp.getId()))
        {
            resp.put("resultCode", "10000002");
            resp.put("resultMessage", "模板编号不能为空");
            resultFlag = false;
        }
        if(resultFlag)
        {
            tmpAnaesDoctempService.addAnaesDoctemp(anaesDoctemp);
        }
        logger.info("end upAnaesDoctemp");
        return resp.getJsonStr();
    }
    
    
    /**
     * 删除模板信息
     */
    @RequestMapping(value = "/delAnaesDoctemp")
    @ResponseBody
    @ApiOperation(value = "删除模板信息", httpMethod = "POST", notes = "删除模板信息")
    public String DelAnaesDoctemp(@ApiParam(name = "anaesDoctemp", value = "删除参数") @RequestBody TmpAnaesDoctemp  anaesDoctemp) {
        logger.info("begin DelAnaesDoctemp");
        ResponseValue resp = new ResponseValue();
        if(StringUtils.isBlank(anaesDoctemp.getId()))
        {
            resp.put("resultCode", "10000001");
            resp.put("resultMessage", "需要删除模板的ID不能传空!");
            return JsonType.jsonType(resp);
        }
        tmpAnaesDoctempService.delAnaesDoctemp(anaesDoctemp.getId());
        logger.info("end DelAnaesDoctemp");
        return JsonType.jsonType(resp);
    }
}
