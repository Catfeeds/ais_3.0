package com.digihealth.anesthesia.sysMng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.formbean.BasMenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.BasRoleFormBean;
import com.digihealth.anesthesia.sysMng.formbean.ButtonPermission;
import com.digihealth.anesthesia.sysMng.formbean.MenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.MenuSelectByRoleId;
import com.digihealth.anesthesia.sysMng.formbean.RoleSelectMenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UpdateRoleMenuFormBean;
import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value="BasRoleController",description="权限处理类")
public class BasRoleController extends BaseController{

	@RequestMapping(value = "/searchBasRoleList")
	@ResponseBody
	@ApiOperation(value="查询权限列表",httpMethod="POST",notes="查询权限列表")
	public String searchBasRoleList(@ApiParam(name="params", value ="系统查询参数") @RequestBody BasRoleFormBean params) {
		logger.info("begin searchBasRoleList");
		ResponseValue res = new ResponseValue();
		params.setBeid(super.getBeid());
		List<BasRole> resultList = basRoleService.selectEntityList(params);
		params.setPageSize(null);
		List<BasRole> totalList = basRoleService.selectEntityList(params);
		res.put("resultList", resultList);
		res.put("total", totalList.size());
		logger.info("end searchBasRoleList");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/searchBasRoleById")
	@ResponseBody
	@ApiOperation(value="根据主键查询权限信息",httpMethod="POST",notes="根据主键查询权限信息")
	public String searchBasRoleById(@ApiParam(name="params", value ="系统查询参数") @RequestBody PKEntity<String> params) {
		logger.info("begin searchBasRoleById");
		ResponseValue res = new ResponseValue();
		params.setBeid(super.getBeid());
		BasRole entity = basRoleService.selectByPrimaryKeyAndBeid(params);
		res.put("entity", entity);
		logger.info("end searchBasRoleById");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/saveBasRole")
	@ResponseBody
	@ApiOperation(value="保存权限信息",httpMethod="POST",notes="保存权限信息")
	public String saveBasRole(@ApiParam(name="params", value ="保存参数") @RequestBody BasRole entity) {
		logger.info("begin saveBasRole");
		ResponseValue res = new ResponseValue();
		if (entity.getId() != null) {
			basRoleService.updateEntity(entity);
		}else {
			basRoleService.insertEntity(entity);
		}
		logger.info("end saveBasRole");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/deleteBasRoleById")
	@ResponseBody
	@ApiOperation(value="根据主键删除权限信息",httpMethod="POST",notes="根据主键删除权限信息")
	public String deleteBasRoleById(@ApiParam(name="params", value ="删除参数") @RequestBody PKEntity<String> id) throws Exception {
		logger.info("begin deleteBasRoleById");
		ResponseValue res = new ResponseValue();
		basRoleService.deleteByPrimaryKeyAndBeid(id);
		res.setResultCode("1");
		res.setResultMessage("删除权限信息成功");
		logger.info("end deleteBasRoleById");
		return res.getJsonStr();
	}
	
	@RequestMapping(value = "/getAllRole")
	@ResponseBody
	@ApiOperation(value="查询权限列表并查出对应的菜单名称",httpMethod="POST",notes="查询权限列表并查出对应的菜单名称")
	public String getRoleInfo(@ApiParam(name="systemSearchFormBean", value ="系统查询传参对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin getAllRole");
		ResponseValue res = new ResponseValue();
		if(null == systemSearchFormBean)
		{
			systemSearchFormBean = new SystemSearchFormBean();
		}
		List<BasRole> resultList = basRoleService.findAllList(systemSearchFormBean);
		int total = basRoleService.findAllListTotal(systemSearchFormBean);
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				String menuName = "";
				List<MenuSelectByRoleId> menuSelectedList = basRoleService.searchMenuByRoleId(resultList.get(i).getId());
				if (menuSelectedList != null && menuSelectedList.size() > 0) {
					for (int j = 0; j < menuSelectedList.size(); j++) {
						if (menuSelectedList.get(j).getSelected() == 1) {
							if (StringUtils.isBlank(menuName)) {
								menuName = menuSelectedList.get(j).getName();
							} else {
								menuName += "," + menuSelectedList.get(j).getName();
							}
						}
					}

				}
				resultList.get(i).setMenuName(menuName);
			}
		}
		res.put("resultList", resultList);
		res.put("total", total);
		logger.info("end getAllRole");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/getAllRoleByDelFlag")
	@ResponseBody
	@ApiOperation(value="根据条件查询权限信息",httpMethod="POST",notes="根据条件查询权限信息")
	public String getAllRoleByDelFlag(){
		logger.info("-------------------begin getAllRoleByDelFlag-------------------");
		ResponseValue resp = new ResponseValue();
		List<BasRole> resultList = basRoleService.getAllRoleByDelFlag();
		resp.put("resultList", resultList);
		logger.info("-------------------end getAllRoleByDelFlag-------------------");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/deleteRole")
	@ResponseBody
	@ApiOperation(value="删除权限信息",httpMethod="POST",notes="删除权限信息")
	public String deleteRole(@ApiParam(name="role", value ="权限信息参数") @RequestBody BasRole role){
		logger.info("-------------------begin deleteRole-------------------");
		ResponseValue req = new ResponseValue();
		basRoleService.delete(role);
		logger.info("-------------------end deleteRole-------------------");
		return req.getJsonStr();
	}
	
	@RequestMapping(value = "/searchRoleById")
	@ResponseBody
	@ApiOperation(value="根据主键ID查询权限信息",httpMethod="POST",notes="根据主键ID查询权限信息")
	public String searchRoleById(@ApiParam(name="map", value ="权限信息参数") @RequestBody Map<String, Object> map){
		logger.info("-------------------begin searchRoleById-------------------");
		ResponseValue resp = new ResponseValue();
		String id = map.get("id")!=null?map.get("id").toString():"0";
		BasRole role = basRoleService.searchRoleById(id);
		resp.setResultCode("1");
		resp.setResultMessage("根据角色ID查询角色成功！");
		List<MenuSelectByRoleId> menuSelecteds = basRoleService.searchMenuByRoleId(id);
		List<BasMenu> grant = new ArrayList<BasMenu>();
		if(menuSelecteds!=null&&menuSelecteds.size()>0){
			for(int i = 0;i<menuSelecteds.size();i++){
				if(menuSelecteds.get(i).getSelected() == 1){
					MenuSelectByRoleId ms = menuSelecteds.get(i);
					BasMenu m = new BasMenu();
					m.setId(ms.getId());
					m.setName(ms.getName());
					m.setParentId(ms.getParentId());
					m.setParentIds(ms.getParentIds());
//					m.setSelected(true);
					grant.add(m);
				}
			}
		}
		//role.setGrant(grant);
		resp.put("role", role);
		//resultMap.put("menuSelected", grant);
		logger.info("-------------------end searchRoleById-------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/getrolelist")
	@ResponseBody
	@ApiOperation(value="查询角色信息",httpMethod="POST",notes="通过系统查询对象查询角色信息")
	public String getrolelist(@ApiParam(name="systemSearchFormBean", value ="系统查询传参对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin getrolelist");
		List<BasRole> resultList = basRoleService.queryRoleList(systemSearchFormBean);
		int total = basRoleService.queryRoleListTotal(systemSearchFormBean);
		ResponseValue resp = new ResponseValue();
		resp.put("sysMngRole", resultList);
		resp.put("total", total);
		logger.info("end getrolelist");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/queryRoleById")
	@ResponseBody
	@ApiOperation(value="查询角色拥有的菜单",httpMethod="POST",notes="通过角色查询这个角色拥有的菜单")
	public String queryRoleById(@ApiParam(name="role", value ="角色对象") @RequestBody BasRoleFormBean role){
		logger.info("begin queryRoleById");
		
        ResponseValue resp = new ResponseValue();
        List<BasMenuFormBean> roleMenus = new ArrayList<BasMenuFormBean>();
        if(role != null){
        	if (StringUtils.isBlank(role.getBeid())) {
				role.setBeid(getBeid());
			}
        	BasRole resultRole = basRoleService.searchRoleById(role.getId(),role.getBeid());
    		List<RoleSelectMenuFormBean> bean = basRoleService.selectRoleSelectMenuByRoleId(role.getId(),role.getBeid(),role.getModule());
    		Map<String,List<ButtonPermission>> buttonMap = basRoleService.getButtonPermissionList(role.getId(),role.getBeid(),role.getModule());
    		
    		if(null != bean && bean.size()>0){
    			for(int i = 0 ; i < bean.size();i++){
    				BasMenuFormBean menuBean = new BasMenuFormBean();
    				String menuId = bean.get(i).getId();
    				menuBean.setId(menuId);
    				menuBean.setpId(bean.get(i).getpId());
    				menuBean.setName(bean.get(i).getName());
    				menuBean.setOpen(true);
    				menuBean.setChecked(bean.get(i).getSelected() == 1 ? true:false);
    				menuBean.setButtonPermissionList(buttonMap.get(menuId));
    				menuBean.setType(bean.get(i).getType());
    				roleMenus.add(menuBean);
    			}
    		}
    		if (resultRole == null) {
    			resultRole = new BasRole();
			}
    		resp.put("role", resultRole);
            resp.put("roleMenus", roleMenus);
        }else{
        	resp.put("role", null);
            resp.put("roleMenus", null);
        }
        
		logger.info("end queryRoleById");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/updateRole")
	@ResponseBody
	@ApiOperation(value="修改角色信息",httpMethod="POST",notes="修改角色信息")
	public String updateRole(@ApiParam(name="bean", value ="角色休息信息对象") @RequestBody UpdateRoleMenuFormBean bean){
		logger.info("begin updateRole");
		
        ResponseValue resp = new ResponseValue();
        basRoleService.updateRole(bean);
		logger.info("end updateRole");
		return resp.getJsonStr();
	}
}
