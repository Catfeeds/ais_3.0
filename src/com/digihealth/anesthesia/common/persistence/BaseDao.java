/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.persistence;

import java.util.List;

/**
 * 
     * Title: BaseDao.java    
     * Description: DAO支持类实现
     * @author chengwang       
     * @created 2015-10-8 下午1:54:32
 */
public interface BaseDao<P, E> {
	E selectEntity(P primaryKey);
	
	List<E> selectEntityList(E params);
}