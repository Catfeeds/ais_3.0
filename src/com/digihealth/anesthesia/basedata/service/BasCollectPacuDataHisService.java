package com.digihealth.anesthesia.basedata.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;

/**
 * @author admin
 *
 */
@Service
public class BasCollectPacuDataHisService extends BaseService
{
	
	private Logger logger = Logger.getLogger(BasCollectPacuDataHisService.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void movePacuObserveDataToHis(String regOptId)
	{
		//collectPacuDataHisDao.insertByDocId(docId);
		//collectPacuDataDao.deleteByDocId(docId);
		
		insertPacuDataHisByDocId(regOptId);
		deletePactDataByDocId(regOptId);
	}
	
	/**
	 * @param docId
	 * 根据患者id删除b_collect_pacu_data表对应记录
	 */
	private void deletePactDataByDocId(final String regOptId) {
		logger.info("deletePactDataByDocId------根据docId删除b_collect_pacu_data记录" + regOptId);
        try {
            String sql = "delete from bas_collect_pacu_data where regOptId = ?";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement pstmt)
                        throws SQLException {
                    pstmt.setObject(1, regOptId);
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
		
	}

	/**
	 * @param docId
	 * 根据患者id将数据表中的记录移入到历史表中
	 */
    public void insertPacuDataHisByDocId(final String regOptId) {
        logger.info("insertPacuDataHisByDocId------新增b_collect_pacu_data_his消息：" + regOptId);
        try {
            String sql = "insert into bas_collect_pacu_data_his select * from bas_collect_pacu_data t where t.regOptId = ?";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement pstmt)
                        throws SQLException {
                    pstmt.setObject(1, regOptId);
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
