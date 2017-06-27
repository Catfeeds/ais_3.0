package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperRoomFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperroom;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;

@Service
public class BasOperroomService extends BaseService {

	public List<BasOperroom> selectEntityList(BasOperroom params) {
        return basOperroomDao.selectEntityList(params);
    }

	public BasOperroom selectEntityByPrimaryKey(String id) {
		return basOperroomDao.selectByPrimaryKey(id);
	}

	@Transactional
	public int updateEntity(BasOperroom entity) {
		return basOperroomDao.updateByPrimaryKey(entity);
	}

	@Transactional
	public int deleteByPrimaryKey(String id) {
		return basOperroomDao.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public void insertEntity(BasOperroom entity) {
		entity.setOperRoomId(GenerateSequenceUtil.generateSequenceNo());
		entity.setBeid(super.getBeid());
		basOperroomDao.insert(entity);
	}

	public List<OperRoomFormBean> findList(BaseInfoQuery baseQuery) {
		String beid = baseQuery.getBeid();
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		baseQuery.setBeid(beid);
		return basOperroomDao.findList(baseQuery == null?new BaseInfoQuery():baseQuery);
	}
	
	public List<BasOperroom> queryRoomList(SystemSearchFormBean systemSearchFormBean) {
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operRoomId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basOperroomDao.queryRoomList(filter,systemSearchFormBean);
	}
	
	public int queryRoomListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("operRoomId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basOperroomDao.queryRoomListTotal(filter, systemSearchFormBean);
	}
	
	public BasOperroom queryRoomListById(String  operRoomId) {
		return basOperroomDao.queryRoomListById(operRoomId, getBeid());
	}
	
	@Transactional
	public int updateHealthnurse(String operRoomId,String healthnurse){
		return basOperroomDao.updateHealthnurse(operRoomId, healthnurse);
	}
	
	@Transactional
	public void saveOperroom(BasOperroom operroom){
	    if (StringUtils.isEmpty(operroom.getBeid()))
        {
	        operroom.setBeid(getBeid());
        }
        if(operroom.getOperRoomId()!=null){
            basOperroomDao.updateByPrimaryKey(operroom);
        }else{
            operroom.setOperRoomId(GenerateSequenceUtil.generateSequenceNo());
            basOperroomDao.insertSelective(operroom);
        }
    }
}
