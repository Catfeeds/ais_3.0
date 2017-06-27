/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author liukui       
 * @created 2015-10-10 下午5:34:19    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.doc.po.DocSpinalCanalPuncture;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Title: SpinalCanalPunctureController.java Description: 描述
 * 
 * @author liukui
 * @created 2015-10-10 下午5:34:19
 */
@Controller
@RequestMapping(value = "/document")
@Api(value="DocSpinalCanalPunctureController",description="椎管内穿刺处理类")
public class DocSpinalCanalPunctureController extends BaseController {

	/**
	 * 查询椎管内穿刺
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchSpinalCanalPunctureList")
	@ResponseBody
	@ApiOperation(value="查询椎管内穿刺",httpMethod="POST",notes="查询椎管内穿刺")
	public String searchSpinalCanalPunctureList(@ApiParam(name="searchBean", value ="查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchSpinalCanalPunctureList");
		ResponseValue resp = new ResponseValue();
		List<DocSpinalCanalPuncture> spinalCanalPunctureList = docSpinalCanalPunctureService.searchSpinalCanalPunctureList(searchBean);
		resp.put("resultList", spinalCanalPunctureList);
		logger.info("end searchSpinalCanalPunctureList");
		return resp.getJsonStr();
	}
	/**
	 * 新增椎管内穿刺
	 * @param SpinalCanalPuncture
	 * @return
	 */
	@RequestMapping(value = "/insertSpinalCanalPuncture")
	@ResponseBody
	@ApiOperation(value="新增椎管内穿刺",httpMethod="POST",notes="新增椎管内穿刺")
	public String insertSpinalCanalPuncture(@ApiParam(name="spinalCanalPuncture", value ="保存参数") @RequestBody DocSpinalCanalPuncture spinalCanalPuncture) {
		logger.info("begin insertSpinalCanalPuncture");
		ResponseValue resp = new ResponseValue();
		String result = docSpinalCanalPunctureService.insertSpinalCanalPuncture(spinalCanalPuncture);
		logger.info("end insertSpinalCanalPuncture");
		return resp.getJsonStr();
	}
	/**
	 * 修改椎管内穿刺
	 * @param SpinalCanalPuncture
	 * @return
	 */
	@RequestMapping(value = "/updateSpinalCanalPuncture")
	@ResponseBody
	@ApiOperation(value="修改椎管内穿刺",httpMethod="POST",notes="修改椎管内穿刺")
	public String updateSpinalCanalPuncture(@ApiParam(name="spinalCanalPuncture", value ="修改参数") @RequestBody DocSpinalCanalPuncture spinalCanalPuncture) {
		logger.info("begin updateSpinalCanalPuncture");
		ResponseValue resp = new ResponseValue();
		String result = docSpinalCanalPunctureService.updateSpinalCanalPuncture(spinalCanalPuncture);
		logger.info("end updateSpinalCanalPuncture");
		return resp.getJsonStr();
	}

}
