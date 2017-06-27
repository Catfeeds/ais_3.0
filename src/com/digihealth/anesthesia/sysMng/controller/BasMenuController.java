package com.digihealth.anesthesia.sysMng.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.FindAllMenuFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.sysMng.formbean.BasMenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.MenuSelectByRoleId;
import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.basedata.po.BasDocument;
import com.digihealth.anesthesia.basedata.utils.MenuParentIdsComparator;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value="BasMenuController",description="系统菜单处理类")
public class BasMenuController extends BaseController{

	@RequestMapping(value = "/searchBasMenuList")
	@ResponseBody
	@ApiOperation(value="查询系统菜单列表",httpMethod="POST",notes="查询系统菜单列表")
	public String searchBasMenuList(@ApiParam(name="params", value ="系统查询参数") @RequestBody BasMenuFormBean params) {
		logger.info("begin searchBasMenuList");
		Map<String, Object> map = new HashMap<String, Object>();
		params.setBeid(super.getBeid());
		List<BasMenu> resultList = basMenuService.selectEntityList(params);
		params.setPageSize(null);
		List<BasMenu> totalList = basMenuService.selectEntityList(params);
		map.put("resultCode", "1");
		map.put("resultMessage", "查询系统菜单列表成功");
		map.put("entityList", resultList);
		map.put("total", totalList.size());
		logger.info("end searchBasMenuList");
		return JsonType.jsonType(map);
	}

	@RequestMapping(value = "/searchBasMenuById")
	@ResponseBody
	@ApiOperation(value="根据主键查询系统菜单",httpMethod="POST",notes="根据主键查询系统菜单")
	public String searchBasMenuById(@ApiParam(name="params", value ="系统查询参数") @RequestBody PKEntity<String> id) {
		logger.info("begin searchAnnouncement");
		Map<String, Object> map = new HashMap<String, Object>();
		id.setBeid(getBeid());
		BasMenu entity = basMenuService.selectEntityByPrimaryKey(id);
		map.put("resultCode", "1");
		map.put("resultMessage", "查询系统菜单成功");
		map.put("entity", entity);
		logger.info("end searchAnnouncement");
		return JsonType.jsonType(map);
	}

	@RequestMapping(value = "/saveBasMenu")
	@ResponseBody
	@ApiOperation(value="保存系统菜单",httpMethod="POST",notes="保存系统菜单")
	public String saveBasMenu(@ApiParam(name="params", value ="保存参数") @RequestBody BasMenu entity) {
		logger.info("begin saveBasMenu");
		ResponseValue res = new ResponseValue();
		if (entity.getId() != null) {
			basMenuService.updateEntity(entity);
		}else {
			basMenuService.insertEntity(entity);
		}
		res.setResultCode("1");
		res.setResultMessage("保存系统菜单成功");
		logger.info("end saveBasMenu");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/deleteBasMenuById")
	@ResponseBody
	@ApiOperation(value="根据主键删除系统菜单",httpMethod="POST",notes="根据主键删除系统菜单")
	public String deleteBasMenuById(@ApiParam(name="params", value ="删除参数") @RequestBody PKEntity<String> id) {
		logger.info("begin deleteBasMenu");
		ResponseValue res = new ResponseValue();
		basMenuService.deleteByPrimaryKeyAndBeid(id);
		res.setResultCode("1");
		res.setResultMessage("删除系统菜单成功");
		logger.info("end deleteBasMenu");
		return res.getJsonStr();
	}
	
	@RequestMapping(value = "/getAllMenu")
	@ResponseBody
	@ApiOperation(value="根据查询参数获取菜单列表",httpMethod="POST",notes="根据查询参数获取菜单列表")
	public String getAllMenu(@RequestBody Map<String, Object> map){
		logger.info("begin getAllMenu");
		String id = map.get("id") != null ? map.get("id").toString() : "0";
		List<FindAllMenuFormBean> resultList = basMenuService.findAllMenu();
		MenuParentIdsComparator comparator = new MenuParentIdsComparator();
		Collections.sort(resultList, comparator);
		Map<String,FindAllMenuFormBean> map1 = new HashMap<String,FindAllMenuFormBean>();
		Map<String,FindAllMenuFormBean> map2 = new HashMap<String,FindAllMenuFormBean>();
		Map<String,FindAllMenuFormBean> map3 = new HashMap<String,FindAllMenuFormBean>();
		Map<String,FindAllMenuFormBean> map4 = new HashMap<String,FindAllMenuFormBean>();
		List<MenuSelectByRoleId> menuSelecteds = null;
		if(resultList!=null&&resultList.size()>0){
			if(StringUtils.isNotBlank(id)){
				menuSelecteds = basRoleService.searchMenuByRoleId(id);
			}
			for(int i = 0;i<resultList.size();i++){
				FindAllMenuFormBean menu = resultList.get(i);
				if(menu.getParentIds().split(",").length == 4){
					if(StringUtils.isNotBlank(id)){
						if(menuSelecteds !=null&&menuSelecteds.size()>0){
							for(int a = 0;a<menuSelecteds.size();a++){
								if(menuSelecteds.get(a).getId() == menu.getId()){
									if(menuSelecteds.get(a).getSelected() == 1){
										menu.setSelected(true);
										break;
									}
								}
							} 
						}
					}
					map4.put(menu.getId(), menu);
				}
				
				if(menu.getParentIds().split(",").length == 3){
					for (Map.Entry<String, FindAllMenuFormBean> entry : map4.entrySet()) {
						FindAllMenuFormBean f = entry.getValue();
						if(f.getParentId().equals(menu.getId()+"")){
							List<FindAllMenuFormBean> list = menu.getChildren();
							list.add(f);
							menu.setChildren(list);
						}
					}
					if(StringUtils.isNotBlank(id)){
						if(menuSelecteds !=null&&menuSelecteds.size()>0){
							for(int a = 0;a<menuSelecteds.size();a++){
								if(menuSelecteds.get(a).getId() == menu.getId()){
									if(menuSelecteds.get(a).getSelected() == 1){
										menu.setSelected(true);
										break;
									}
								}
							} 
						}
					}
					map3.put(menu.getId(), menu);
				}
				
				if(menu.getParentIds().split(",").length == 2){
					for (Map.Entry<String, FindAllMenuFormBean> entry : map3.entrySet()) {
						FindAllMenuFormBean f = entry.getValue();
						if(f.getParentId().equals(menu.getId()+"")){
							List<FindAllMenuFormBean> list = menu.getChildren();
							list.add(f);
							menu.setChildren(list);
						}
					}
					if(StringUtils.isNotBlank(id)){
						if(menuSelecteds !=null&&menuSelecteds.size()>0){
							for(int a = 0;a<menuSelecteds.size();a++){
								if(menuSelecteds.get(a).getId() == menu.getId()){
									if(menuSelecteds.get(a).getSelected() == 1){
										menu.setSelected(true);
										break;
									}
								}
							} 
						}
					}
					map2.put(menu.getId(), menu);
				}
				if(menu.getParentIds().split(",").length == 1){
					for (Map.Entry<String, FindAllMenuFormBean> entry : map2.entrySet()) {
						FindAllMenuFormBean f = entry.getValue();
						if(f.getParentId().equals(menu.getId()+"")){
							List<FindAllMenuFormBean> list = menu.getChildren();
							list.add(f);
							menu.setChildren(list);
						}
					}
					if(StringUtils.isNotBlank(id)){
						if(menuSelecteds !=null&&menuSelecteds.size()>0){
							for(int a = 0;a<menuSelecteds.size();a++){
								if(menuSelecteds.get(a).getId() == menu.getId()){
									if(menuSelecteds.get(a).getSelected() == 1){
										menu.setSelected(true);
										break;
									}
								}
							} 
						}
					}
					map1.put(menu.getId(), menu);
				}
			}
			
		}
		resultList.clear();
		for (Map.Entry<String, FindAllMenuFormBean> entry : map1.entrySet()) {
			resultList.add(entry.getValue());
		}
		logger.info("end getAllMenu");
		return JsonType.jsonType(resultList);
	}
	
	@RequestMapping(value = "/getMenuTree")
	@ResponseBody
	@ApiOperation(value="查询菜单信息",httpMethod="POST",notes="通过系统查询对象查询菜单信息")
	public String getMenuTree(@ApiParam(name="systemSearchFormBean", value ="系统查询传参对象,beid为必传参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("----------------begin getMenuTree--------------------");
		ResponseValue resp = new ResponseValue();
		String beid = systemSearchFormBean.getBeid();
		String module = systemSearchFormBean.getModule();
		if(StringUtils.isBlank(module)){//默认走控制中心
			module = Global.getConfig("defModule").toString();
		}
		List<BasMenuFormBean> resultList = basMenuService.selectMenuTree(beid,module);
		resp.put("roleMenus", resultList);
		logger.info("--------------- end getMenuTree --------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/delMenu")
	@ResponseBody
	@ApiOperation(value = "删除菜单信息", httpMethod = "POST", notes = "删除菜单信息")
	public String delMenu(@ApiParam(name = "menu", value = "删除菜单对象") @RequestBody BasMenu menu) {
		logger.info("------------------start delMenu----------------------------");
		ResponseValue resp = new ResponseValue();
		String beid = menu.getBeid();
		String id = menu.getId();
		if (StringUtils.isBlank(beid) || StringUtils.isBlank(id)) {
			resp.setResultCode("20000009");
			resp.setResultMessage(Global.getRetMsg("20000009"));
		} else {
			basMenuService.delMenu(id, beid, resp);
		}
		logger.info("------------------end delMenu----------------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/addMenu")
	@ResponseBody
	@ApiOperation(value = "添加菜单信息", httpMethod = "POST", notes = "新增菜单信息")
	public String addMenu(@ApiParam(name = "menu", value = "菜单对象") @RequestBody BasMenu menu) {
		logger.info("------------------start addMenu----------------------------");
		ResponseValue resp = new ResponseValue();
		if (null == menu) {
			resp.setResultCode("20000008");
			resp.setResultMessage(Global.getRetMsg("20000008"));
		} else {
			basMenuService.addMenu(menu);
		}
		logger.info("------------------end addMenu----------------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/updateMenu")
	@ResponseBody
	@ApiOperation(value = "修改菜单信息", httpMethod = "POST", notes = "修改菜单信息")
	public String updateMenu(@ApiParam(name = "menu", value = "菜单对象") @RequestBody BasMenu menu) {
		logger.info("---------------------start updateMenu----------------------");
		ResponseValue resp = new ResponseValue();
		if (null == menu) {
			resp.setResultCode("20000008");
			resp.setResultMessage(Global.getRetMsg("20000008"));
		} else {
			basMenuService.updateMenu(menu);
		}
		logger.info("---------------------end updateMenu----------------------");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchAllDocumentByBeid")
	@ResponseBody
	@ApiOperation(value = "修改菜单信息", httpMethod = "POST", notes = "修改菜单信息")
	public String searchAllDocumentByBeid(@ApiParam(name = "infoQuery", value = "菜单对象") @RequestBody BaseInfoQuery infoQuery) {
		logger.info("---------------------start searchAllDocumentByBeid----------------------");
		ResponseValue resp = new ResponseValue();
		List<BasDocument> baseDocumentList = basMenuService.getBaseDocumentList(infoQuery);
		resp.put("resultList", baseDocumentList);
		logger.info("---------------------end searchAllDocumentByBeid----------------------");
		return resp.getJsonStr();
	}
}
