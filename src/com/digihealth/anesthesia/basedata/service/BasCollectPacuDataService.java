/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-10 下午5:32:33    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.basedata.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasCollectPacuData;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.SysUtil;

/**
 * Title: CollectPacuDataService.java Description: 描述
 */
@Service
public class BasCollectPacuDataService extends BaseService{
	
	private Logger logger = Logger.getLogger(BasCollectPacuDataService.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**
	 * 根据患者id+time查询对应时间的生命体征指标
	 * @param regOptId
	 * @param time
	 * @return
	 */
	public List<BasCollectPacuData> searchPacuObserveDataList(String regOptId,Date time) {
		//return collectPacuDataDao.searchPacuObserveDataList(regOptId,time);
	    String timeFormat = SysUtil.getTimeFormat(time);
		return jdbcTemplate.query("SELECT a.* FROM bas_collect_pacu_data a WHERE a.regOptId = ? and a.time = ?", 
		    new Object[]{regOptId,timeFormat},  new CollectPacuDataMapper());
	}
	
	public class CollectPacuDataMapper implements RowMapper<BasCollectPacuData> {  
        
        @Override  
        public BasCollectPacuData mapRow(ResultSet rs, int rowNum) throws SQLException {  
            BasCollectPacuData cpd = new BasCollectPacuData();
            cpd.setId(rs.getString("id"));
            cpd.setRegOptId(rs.getString("regOptId"));
            cpd.setTime(rs.getTimestamp("time"));
            cpd.setObserveId(rs.getString("observeId"));
            cpd.setValue(rs.getFloat("value"));
            cpd.setState(rs.getInt("state"));
            cpd.setObserveName(rs.getString("observeName"));
            cpd.setIcon(rs.getString("icon"));
            cpd.setColor(rs.getString("color"));
            cpd.setFreq(rs.getInt("freq"));
            cpd.setPosition(rs.getInt("position"));
            cpd.setIntervalTime(rs.getInt("intervalTime"));
            cpd.setDeviceId(rs.getString("deviceId"));
            cpd.setBeid(rs.getString("beid"));
//            user.setId(rs.getInt("id"));  
//            user.setUsername(rs.getString("username"));  
//            user.setPassword(rs.getString("password"));  
            return cpd;  
        }  
          
    }  
    
	
	@Transactional
	public void insertPacuObserveData(List<BasCollectPacuData> CollectPacuDataList) {
		if(null != CollectPacuDataList)
		{
			for(BasCollectPacuData collectPacuData : CollectPacuDataList)
			{
				//collectPacuDataDao.insertSelective(collectPacuData);
				savePacuData(collectPacuData);
			}
		}
	}
	
	@Transactional
	public void deletePacuObserveData(String regOptId)
	{
		//collectPacuDataDao.deleteByDocId(regOptId);
		
		jdbcTemplate.update("delete from bas_collect_pacu_data where regOptId = ? ",  
	                new Object[] { regOptId }); 
	}
	
	 
    /**
     * @param collectPacuData
     * 将采集数据插入到数据表中
     */
    public void savePacuData(final BasCollectPacuData cpd) {
        logger.info("savePacuData------新增b_collect_pacu_data消息：" + cpd);
        //try {
            String sql = "INSERT INTO bas_collect_pacu_data(id,time,regOptId,observeId,value,state,observeName,icon,color,freq,position,intervalTime,deviceId,beid) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            jdbcTemplate.update(sql, new Object[]{cpd.getId(),cpd.getTime(),cpd.getRegOptId(),cpd.getObserveId(),
            		cpd.getValue(),cpd.getState(),cpd.getObserveName(),cpd.getIcon(),cpd.getColor(),
            		cpd.getFreq(),cpd.getPosition(),cpd.getIntervalTime(),cpd.getDeviceId(),getBeid()});
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
    }
    
}
