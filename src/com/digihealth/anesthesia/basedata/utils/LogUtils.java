package com.digihealth.anesthesia.basedata.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.digihealth.anesthesia.basedata.dao.BasOperateLogDao;
import com.digihealth.anesthesia.basedata.po.BasOperateLog;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.sysMng.dao.BasMenuDao;
import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
     * Title: LogUtils.java    
     * Description: 字典工具类
     * @author chengwang       
     * @created 2015-10-8 下午1:51:04
 */
public class LogUtils {

	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";
	
	/**
     * 日志类型
     */
    public static final String OPT_TYPE_USRE_LOGIN = "1";   //用户登录
    public static final String OPT_TYPE_USRE_OUT = "2";     //用户退出
    public static final String OPT_TYPE_INFO_QUERY = "3";   //数据查询
    public static final String OPT_TYPE_INFO_SAVE = "4";    //数据保存
    public static final String OPT_TYPE_INFO_DEL = "5";     //数据删除
    
    /**
     * 所属模块
     */
    public static final String OPT_MODULE_LOGIN = "1";   //用户登录模块
    public static final String OPT_MODULE_OPER_DOC = "2";//文书模块
    public static final String OPT_MODULE_OPER_RECORD = "3";//术中记录模块
    public static final String OPT_MODULE_BASE_INFO = "4";//基础信息
    public static final String OPT_MODULE_INTERFACE = "5";//接口模块
	
	
	private static BasMenuDao basMenuDao = SpringContextHolder.getBean(BasMenuDao.class);
	private static BasOperateLogDao basOperateLogDao = SpringContextHolder.getBean(BasOperateLogDao.class);
	

	/**
	 * 
	     * @discription 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
	     * @author chengwang       
	     * @created 2015-10-8 下午1:52:56     
	     * @param requestUri
	     * @param permission
	     * @return
	 */
	public static String getMenuNamePath(String requestUri, String permission){
		String href = org.apache.commons.lang3.StringUtils.substringAfter(requestUri, Global.getAdminPath());
		Map<String, String> menuMap = null;
		if (menuMap == null){
			menuMap = Maps.newHashMap();
			List<BasMenu> menuList = basMenuDao.findAllList(new BasMenu());
			for (BasMenu menu : menuList){
				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
				String namePath = "";
				if (menu.getParentIds() != null){
					List<String> namePathList = Lists.newArrayList();
					for (String id : org.apache.commons.lang3.StringUtils.split(menu.getParentIds(), ",")){
//						if (BasMenu.getRootId().equals(id)){
//							continue; // 过滤跟节点
//						}
						for (BasMenu m : menuList){
							if (m.getId().equals(id)){
								namePathList.add(m.getName());
								break;
							}
						}
					}
					namePathList.add(menu.getName());
					namePath = org.apache.commons.lang3.StringUtils.join(namePathList, "-");
				}
				// 设置菜单名称路径
				if (org.apache.commons.lang3.StringUtils.isNotBlank(menu.getUrl())){
					menuMap.put(menu.getUrl(), namePath);
				}/*else if (StringUtils.isNotBlank(menu.getPermission())){
					for (String p : StringUtils.split(menu.getPermission())){
						menuMap.put(p, namePath);
					}
				}*/
				
			}
			//CacheUtils.put(CACHE_MENU_NAME_PATH_MAP, menuMap);
		}
		String menuNamePath = menuMap.get(href);
		if (menuNamePath == null){
			for (String p : org.apache.commons.lang3.StringUtils.split(permission)){
				menuNamePath = menuMap.get(p);
				if (org.apache.commons.lang3.StringUtils.isNotBlank(menuNamePath)){
					break;
				}
			}
			if (menuNamePath == null){
				return "";
			}
		}
		return menuNamePath;
	}

	public static void saveOperateLog(String regOptId,String operType,String operModule,String desc,String contents,BasUser user, String beid){
        BasOperateLog log = new BasOperateLog();
        log.setId(GenerateSequenceUtil.generateSequenceNo());
        log.setBusiId(regOptId);
        log.setOperTime(new Date());
        log.setOperType(operType);
        log.setOperContents(contents);
        log.setDescription(desc);
        if(user != null){
            log.setOperId(user.getUserName());
            log.setOperName(user.getName());
        }
        log.setOperModule(operModule);
        log.setBeid(beid);
        basOperateLogDao.insertSelective(log);
    }
}
