/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.doc.po.DocCollectPacuData;

/**
 * Title: CollectPacuDataService.java Description: 描述
 */
@Service
public class DocCollectPacuDataService extends BaseService{
	
	private Logger logger = Logger.getLogger(DocCollectPacuDataService.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**
	 * 根据患者id+time查询对应时间的生命体征指标
	 * @param regOptId
	 * @param time
	 * @return
	 */
	public List<DocCollectPacuData> searchPacuObserveDataList(String regOptId,Date time) {
		//return collectPacuDataDao.searchPacuObserveDataList(regOptId,time);
		return jdbcTemplate.queryForList("SELECT a.* FROM b_collect_pacu_data a WHERE a.doc_id = ? and a.time = ?", 
				DocCollectPacuData.class, new Object[]{regOptId,time});
	}
	
	@Transactional
	public void insertPacuObserveData(List<DocCollectPacuData> CollectPacuDataList) {
		if(null != CollectPacuDataList)
		{
			for(DocCollectPacuData collectPacuData : CollectPacuDataList)
			{
				//collectPacuDataDao.insertSelective(collectPacuData);
				savePacuData(collectPacuData);
			}
		}
	}
	
	@Transactional
	public void deletePacuObserveData(String regOptId) {
		//collectPacuDataDao.deleteByDocId(regOptId);
		jdbcTemplate.update("delete from b_collect_pacu_data where doc_id = ? ",  
	                new Object[] { regOptId }); 
	}
	
	 
    /**
     * @param collectPacuData
     * 将采集数据插入到数据表中
     */
    public void savePacuData(final DocCollectPacuData cpd) {
        logger.info("savePacuData------新增b_collect_pacu_data消息：" + cpd);
        //try {
            String sql = "INSERT INTO b_collect_pacu_data(id,time,doc_Id,observe_Id,value,state,observe_name,icon,color,freq,position,interval_time,device_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            /*jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement pstmt)
                        throws SQLException {
                    pstmt.setObject(1, collectPacuData.getId());
                    pstmt.setObject(2, collectPacuData.getTime());
                    pstmt.setObject(3, collectPacuData.getDocId());
                    pstmt.setObject(4, collectPacuData.getObserveId());
                    pstmt.setObject(5, collectPacuData.getValue());
                    pstmt.setObject(6, collectPacuData.getState());
                    pstmt.setObject(7, collectPacuData.getObserveName());
                    pstmt.setObject(8, collectPacuData.getIcon());
                    pstmt.setObject(9, collectPacuData.getColor());
                    pstmt.setObject(10, collectPacuData.getFreq());
                    pstmt.setObject(11, collectPacuData.getPosition());
                    pstmt.setObject(12, collectPacuData.getIntervalTime());
                    pstmt.setObject(13, collectPacuData.getDeviceId());
                }
            });*/
            //logger.info(jdbcTemplate+"----------------------");
            jdbcTemplate.update(sql, new Object[]{cpd.getId(),cpd.getTime(),cpd.getDocId(),cpd.getObserveId(),
            		cpd.getValue(),cpd.getState(),cpd.getObserveName(),cpd.getIcon(),cpd.getColor(),
            		cpd.getFreq(),cpd.getPosition(),cpd.getIntervalTime(),cpd.getDeviceId()});
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
    }
    
}
