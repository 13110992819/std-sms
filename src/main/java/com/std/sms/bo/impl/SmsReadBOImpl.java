package com.std.sms.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ISmsReadBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.core.OrderNoGenerater;
import com.std.sms.dao.ISmsReadDAO;
import com.std.sms.domain.SmsRead;
import com.std.sms.enums.EGeneratePrefix;

@Component
public class SmsReadBOImpl extends PaginableBOImpl<SmsRead> implements
        ISmsReadBO {

    @Autowired
    private ISmsReadDAO smsReadDAO;

    @Override
    public String saveSmsRead(String userId, String smsId) {
        SmsRead data = new SmsRead();
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.SMSREAD.getCode());
            data.setCode(code);
            data.setUserId(userId);
            data.setSmsId(smsId);
            smsReadDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<SmsRead> querySmsReadList(SmsRead condition) {
        return smsReadDAO.selectList(condition);
    }

    @Override
    public Long getTotalCount(String userId, String smsId) {
        SmsRead condition = new SmsRead();
        condition.setUserId(userId);
        condition.setSmsId(smsId);
        return smsReadDAO.selectTotalCount(condition);
    }

    @Override
    public void removeSmeRead(Long id) {
        SmsRead condition = new SmsRead();
        condition.setSmsId(String.valueOf(id));
        smsReadDAO.delete(condition);
    }
}
