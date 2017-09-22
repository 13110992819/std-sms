package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.SmsRead;

//dao层 
public interface ISmsReadDAO extends IBaseDAO<SmsRead> {
    String NAMESPACE = ISmsReadDAO.class.getName().concat(".");

}
