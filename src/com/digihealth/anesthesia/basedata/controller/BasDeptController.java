package com.digihealth.anesthesia.basedata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDept;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: DeptController.java Description: 科室Controller
 * 
 * @author chengwang
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasDeptController", description = "科室处理类")
public class BasDeptController extends BaseController {

    /**
     * 
     * @discription 根据条件查询科室
     * @author chengwang
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
	@RequestMapping(value = "/getDeptList")
	@ResponseBody
    @ApiOperation(value = "查询科室列表", httpMethod = "POST", notes = "查询科室列表")
	public String getDeptList(@RequestBody Map<String,Object> map) {
		logger.info("----------------------begin getDeptList----------------------");
        ResponseValue resp = new ResponseValue();
        BaseInfoQuery baseQuery = new BaseInfoQuery();
        if(null != map && null != map.get("name"))
		{
			String name = map.get("name").toString();
			baseQuery.setName(name);
		}
		List<DeptFormBean> resultList = basDeptService.findList(baseQuery);
        resp.put("resultList", resultList);
		logger.info("----------------------end getDeptList----------------------");
		return resp.getJsonStr();
	}
	
    /**
     * 
     * @discription 根据条件查询科室
     * @author chengwang
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryDeptList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询科室", httpMethod = "POST", notes = "根据条件查询科室")
    public String queryDeptList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryDeptList");
        ResponseValue resp = new ResponseValue();
        List<BasDept> resultList = basDeptService.queryDeptList(systemSearchFormBean);
        int total = basDeptService.queryDeptListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryDeptList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个科室信息
     * @author chengwang
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryDeptById")
    @ResponseBody
    @ApiOperation(value = "查询单个科室信息", httpMethod = "POST", notes = "查询单个科室信息")
    public String queryDeptById(@ApiParam(name = "dept", value = "科室对象") @RequestBody BasDept dept)
    {
        logger.info("begin queryDeptById");
        ResponseValue resp = new ResponseValue();
        BasDept resultDept = basDeptService.searchDeptById(dept.getDeptId());
        resp.put("resultDept", resultDept);
        logger.info("end queryDeptById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加科室
     * @author chengwang
     * @created 2015年12月3日 下午3:02:15
     * @param dept
     * @return
     */
    @RequestMapping(value = "/updateDept")
    @ResponseBody
    @ApiOperation(value = "修改或者添加科室", httpMethod = "POST", notes = "修改或者添加科室")
    public String updateDept(@ApiParam(name = "dept", value = "科室对象") @RequestBody BasDept dept)
    {
        logger.info("begin updateDept");
        ResponseValue resp = new ResponseValue();
        basDeptService.updateDept(dept);
        logger.info("end updateDept");
        return resp.getJsonStr();
    }
    
}
