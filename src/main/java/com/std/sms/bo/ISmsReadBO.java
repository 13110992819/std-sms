package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SmsRead;

public interface ISmsReadBO extends IPaginableBO<SmsRead> {

    public String saveSmsRead(String userId, String smsId);

    public List<SmsRead> querySmsReadList(SmsRead condition);

    public Long getTotalCount(String userId, String smsId);

    public void removeSmeRead(Long id);

}
