package com.std.sms.domain;

import com.std.sms.dao.base.ABaseDO;

/**
* 公告阅读
* @author: shan 
* @since: 2017-09-22 10:04:51
* @history:
*/
public class SmsRead extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 公告编号
	private String smsId;

	// 用户编号
	private String userId;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}