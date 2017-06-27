package com.digihealth.anesthesia.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.digihealth.anesthesia.basedata.dao.BasBusEntityDao;
import com.digihealth.anesthesia.common.persistence.EntityDao;
import com.digihealth.anesthesia.common.persistence.PKEntity;

public abstract class EntityService<P, E> {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected BasBusEntityDao basBusEntityDao;
	
	protected abstract EntityDao<P, E> getDao();
	
	public List<E> selectEntityList(E params) {
        return getDao().selectEntityList(params);
    }
	
	public E selectEntityByPrimaryKey(PKEntity<P> primaryKey) {
		return getDao().selectByPrimaryKey(primaryKey);
	}
	
	public E selectByPrimaryKeyAndBeid(PKEntity<P> primaryKey) {
		return getDao().selectByPrimaryKeyAndBeid(primaryKey);
	}
	
	public void insertEntity(E entity) {
		getDao().insert(entity);
	}
	
	public int updateEntity(E entity) {
		return getDao().updateByPrimaryKey(entity);
	}
	
	public int deleteByPrimaryKey(PKEntity<P> primaryKey) {
		return getDao().deleteByPrimaryKey(primaryKey);
	}

	public int deleteByPrimaryKeyAndBeid(PKEntity<P> primaryKey) throws Exception {
		return getDao().deleteByPrimaryKeyAndBeid(primaryKey);
	}

	public String getBeid() {
		String beid = request.getHeader("beid");
		if (beid == null) {
			beid = basBusEntityDao.getBeid();
		}
		return beid;
	}
}
