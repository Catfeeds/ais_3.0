/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-19 下午4:39:34    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.basedata.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.Controller;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

/**
 * Title: ControllerDao.java Description: 控制表
 * 
 * @author chengwang
 * @created 2015-10-19 下午4:39:34
 */
@MyBatisDao
public interface ControllerDao extends CrudDao<Controller> {

	/**
	 * 
	 * @discription 通过ID修改状态
	 * @author chengwang
	 * @created 2015-10-19 下午4:41:47
	 * @param id
	 * @param state
	 * @return
	 */
	public void checkOperation(@Param("id") String id,
			@Param("state") String state,@Param("previousState") String previousState);
	
	/**
	 * 
	     * @discription 根据控制表ID获取病人控制表信息
	     * @author chengwang       
	     * @created 2015-10-20 上午9:35:19     
	     * @param id
	     * @return
	 */
	public Controller getControllerById(@Param("id")String id);
}
