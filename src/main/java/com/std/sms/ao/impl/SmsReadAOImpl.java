package com.std.sms.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISmsReadAO;
import com.std.sms.bo.ISmsBO;
import com.std.sms.bo.ISmsReadBO;
import com.std.sms.exception.BizException;

@Service
public class SmsReadAOImpl implements ISmsReadAO {

    @Autowired
    private ISmsReadBO smsReadBO;

    @Autowired
    private ISmsBO smsBO;

    @Override
    public void addSmsRead(String userId, List<String> smsIdList) {
        for (String smsId : smsIdList) {
            Long count = smsReadBO.getTotalCount(userId, smsId);
            if (count > 1) {
                throw new BizException("xn0000", "编号" + smsId + "的公告您已查看过");
            }
            smsReadBO.saveSmsRead(userId, smsId);
        }
    }

    @Override
    public Long totalCount(String userId, String kind, String systemCode) {
        Long smsCount = smsBO.getTotalCount(kind, systemCode);
        Long readCount = smsReadBO.getTotalCount(userId, null);
        Long unReadCount = smsCount - readCount;
        return unReadCount;
    }
}
