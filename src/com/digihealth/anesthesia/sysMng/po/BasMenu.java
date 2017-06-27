/*
 * BasMenu.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.po;

import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统菜单对象")
public class BasMenu extends PKEntity<String> {

	/**
	 * 权限名称
	 */
	@ApiModelProperty(value = "权限名称")
	private String name;

	/**
	 * 类型：0-仅目录,1-页面
	 */
	@ApiModelProperty(value = "类型：0-仅目录,1-页面")
	private Integer type;

	/**
	 * 菜单icon
	 */
	@ApiModelProperty(value = "菜单icon")
	private String icon;

	/**
	 * 菜单对应的跳转目标
	 */
	@ApiModelProperty(value = "菜单对应的跳转目标")
	private String target;

	/**
	 * 菜单url
	 */
	@ApiModelProperty(value = "菜单url")
	private String url;

	/**
	 * 是否在左边菜单显示;0-否，1-是
	 */
	@ApiModelProperty(value = "是否在左边菜单显示;0-否，1-是")
	private Integer isLeftMenu;

	/**
	 * 指向:当查看要跳转到其他同等作用地址的时候使用
	 */
	@ApiModelProperty(value = "指向:当查看要跳转到其他同等作用地址的时候使用")
	private String direct;

	/**
	 * 父编号
	 */
	@ApiModelProperty(value = "父编号")
	private String parentId;

	/**
	 * 父编号列表
	 */
	@ApiModelProperty(value = "父编号列表")
	private String parentIds;

	/**
	 * 按钮权限字符串列表（当前字段初始配置页面具有哪些按钮）： 1、查询列表 Q_LIST 2、查询详情 Q_DET 3、添加 ADD （手动录入）
	 * 4、修改 UPD （保存、编辑） 5、删除 DEL 6、his同步 H_SYNC （his导入） 7、数据导入 IMP 8、批量执行
	 * BATEXEC 9、打印 PRINT 10、文书完成情况 DOCFIN 11、批量打印、一键打印 KEYPRINT 12、导出数据、导出excel
	 * EXP 13、对比 COMPARE 14、选择模板 CHOOSE(应用暂时先不算) 15、批准手术 APPR 16、取消手术 CANC 17、提交
	 * SUBM 18、归档 FILE 19、退档 RETREAT
	 */
	@ApiModelProperty(value = "按钮权限字符串列表")
	private String permission;

	/**
	 * 是否可用：0-不可用,1-可用
	 */
	@ApiModelProperty(value = "是否可用：0-不可用,1-可用")
	private Integer enable;

	/**
	 * 链接类型：link-链接,toggle-下拉
	 */
	@ApiModelProperty(value = "链接类型：link-链接,toggle-下拉")
	private String urlType;

	/**
	 * 菜单分模块：OPRM-术中,PACU-复苏室,CTRLCENT-控制中心,LRGSCRN -大屏
	 */
	@ApiModelProperty(value = "菜单分模块：OPRM-术中,PACU-复苏室,CTRLCENT-控制中心,LRGSCRN -大屏")
	private String module;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer sort;

	/**
	 * 对应文书表(bas_document)的docId字段
	 */
	@ApiModelProperty(value = "对应文书表(bas_document)的docId字段")
	private String docTableId;

	private List<BasMenu> pages = new ArrayList<BasMenu>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Integer getIsLeftMenu() {
		return isLeftMenu;
	}

	public void setIsLeftMenu(Integer isLeftMenu) {
		this.isLeftMenu = isLeftMenu;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct == null ? null : direct.trim();
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds == null ? null : parentIds.trim();
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission == null ? null : permission.trim();
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType == null ? null : urlType.trim();
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module == null ? null : module.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<BasMenu> getPages() {
		return pages;
	}

	public void setPages(List<BasMenu> pages) {
		this.pages = pages;
	}

	public String getDocTableId() {
		return docTableId;
	}

	public void setDocTableId(String docTableId) {
		this.docTableId = docTableId;
	}

}