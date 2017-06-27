package com.digihealth.anesthesia.common.persistence;

import java.util.List;

public interface EntityDao<P, E> {
	E selectByPrimaryKey(PKEntity<P> primaryKey);

	E selectByPrimaryKeyAndBeid(PKEntity<P> primaryKey);
	
	List<E> selectEntityList(E params);
	
	int insert(E entity);
	
    int updateByPrimaryKey(E entity);
    
    int deleteByPrimaryKey(PKEntity<P> primaryKey);
    
    int deleteByPrimaryKeyAndBeid(PKEntity<P> primaryKey);
    
    int isCanDeleteEntity(PKEntity<P> primaryKey);
}
