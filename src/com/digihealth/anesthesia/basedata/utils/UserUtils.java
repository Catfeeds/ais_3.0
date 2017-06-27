/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.digihealth.anesthesia.basedata.dao.BasBusEntityDao;
import com.digihealth.anesthesia.common.utils.CacheUtils;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.sysMng.dao.BasMenuDao;
import com.digihealth.anesthesia.sysMng.dao.BasRoleDao;
import com.digihealth.anesthesia.sysMng.dao.BasUserDao;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.digihealth.anesthesia.sysMng.po.BasUser;



/**
 * 
     * Title: UserUtils.java    
     * Description: 用户工具类
     * @author chengwang       
     * @created 2015-10-7 下午3:01:06
 */
public class UserUtils {

	/*private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);*/
	private static BasUserDao basUserDao = SpringContextHolder.getBean(BasUserDao.class);
	private static BasRoleDao basRoleDao = SpringContextHolder.getBean(BasRoleDao.class);
	private static BasMenuDao basMenuDao = SpringContextHolder.getBean(BasMenuDao.class);
	private static BasBusEntityDao basBusEntityDao = SpringContextHolder.getBean(BasBusEntityDao.class);

	@Autowired    
	private static HttpSession session;
	@Autowired
	private static HttpServletRequest request;
	
	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID = "aisUser";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	//public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	/*public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	
	*/
	
	public static void setUserCache(BasUser user){
		CacheUtils.put(USER_CACHE, USER_CACHE_ID , user);
	}
	
	public static BasUser getUserCache(){
		return (BasUser) CacheUtils.get(USER_CACHE, USER_CACHE_ID);
	}
	
	/**
	 * 获取用户ID
	 * @param id
	 * @return 取不到返回null
	 */
	public static String getId(){
		String id = (String) CacheUtils.get(USER_CACHE, USER_CACHE_ID);
		/*if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			//user.setRoleList(basRoleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID , user.getId());
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}*/
		return id;
	}
	
	
	public static String getAge(String age,String ageMon,Integer ageDay){
		if(age!=null&&(!age.equals(""))&&(!age.equals("0"))){
			return age+"岁";
		}else if(age == null || age.equals("")||age.equals("0")){
			if(ageMon!=null&&(!ageMon.equals(""))&&(!ageMon.equals("0"))){
				return ageMon+"月";
			}else if(ageMon == null || ageMon.equals("")||ageMon.equals("0")){
				if(ageDay!=null){
					return ageDay+"天";
				}
				
			}
		}
		return "";
	}
	
	/**
	 * 
	     * @discription 根据用户ID获取用户
	     * @author chengwang       
	     * @created 2015-10-7 下午3:01:30     
	     * @param id
	     * @return
	 */
	public static BasUser getUserById(String id){
		BasUser user = (BasUser) CacheUtils.get(USER_CACHE, USER_CACHE_ID_+id);
		if (user ==  null){
			user = basUserDao.get(id);
			if (user == null){
				return null;
			}
			//user.setRoleList(basRoleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_+user.getUserName() , user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUserName(), user);
		}
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static BasUser getByLoginName(String loginName){
		BasUser user = (BasUser)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null){
			user = basUserDao.getByLoginName(loginName, getBeid());
			if (user == null){
				return null;
			}
			//user.setRoleList(basRoleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getUserName(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUserName(), user);
		}
		return user;
	}
	
	/**
	 * 清除当前用户缓存
	 */
	/*public static void clearCache(){
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		//UserUtils.clearCache(getUser());
	}*/
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	/*public static void clearCache(User user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
		if (user.getOffice() != null && user.getOffice().getId() != null){
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
		}
	}*/

	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(BasUser user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID+user.getUserName());
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static BasUser getUser2() {
		BasUser user = (BasUser) getSession().getAttribute("user");
		if (user != null) {
			return user;
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new BasUser();
	}

	public static BasUser getUser1(HttpServletRequest request) {
		BasUser user = (BasUser) request.getSession().getAttribute("user");
		if (user != null) {
			return user;
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new BasUser();
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<BasRole> getRoleList(){
		/*@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>)getCache(CACHE_ROLE_LIST);
		if (roleList == null){
			User user = getUser();
			if (user.isAdmin()){
				roleList = basRoleDao.findAllList(new Role());
			}else{
				Role role = new Role();
				role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
				roleList = basRoleDao.findList(role);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}*/
		return null;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	/*public static List<Menu> getMenuList(HttpServletRequest request){
		@SuppressWarnings("unchecked")
		//List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		List<Menu> menuList = null;
		if (menuList == null){
			User user = getUser1(request);
			if (user.isAdmin()){
				menuList = basMenuDao.findAllList(new Menu());
			}else{
				Menu m = new Menu();
				m.setUserId(user.getId());
				menuList = basMenuDao.findByUserId(m);
			}
			//putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}*/
	
	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	/*public static List<Area> getAreaList(){
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			areaList = areaDao.findAllList(new Area());
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}*/
	
	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	/*public static List<Office> getOfficeList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			User user = getUser();
			if (user.isAdmin()){
				officeList = officeDao.findAllList(new Office());
			}else{
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.findList(office);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}*/

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	/*public static List<Office> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = officeDao.findAllList(new Office());
		}
		return officeList;
	}*/
	
	/**
	 * 获取授权主要对象
	 */
	/*public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}*/
	
	/**
	 * 获取当前登录者对象
	 */
	/*public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}*/
	
	public static HttpServletRequest getSession(){
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		//HttpServletRequest session = (HttpServletRequest) ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static String getBeid() {
		String beid = basBusEntityDao.getBeid();
		if (StringUtils.isBlank(beid)) {
			beid = "101";
		}
		return beid;
	}
	
	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		
		getSession().setAttribute(key, value);
	}
	/*
	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}*/
	
//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}
	
}
