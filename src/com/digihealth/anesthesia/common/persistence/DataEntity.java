/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.persistence;

import org.springframework.stereotype.Service;

/**
 * 
     * Title: DataEntity.java    
     * Description: 数据Entity类
     * @author chengwang       
     * @created 2015-10-8 下午1:55:48
 */
@Service
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	/*@Autowired  
	private HttpSession session;  
	
	protected String remarks;	// 备注
	protected User createBy;	// 创建者
	protected Date createDate;	// 创建日期
	protected User updateBy;	// 更新者
	protected Date updateDate;	// 更新日期
*/	//protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	
	

	/*@JsonIgnore
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}*/

}
