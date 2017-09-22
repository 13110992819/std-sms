package com.std.sms.ao;

import org.springframework.stereotype.Component;

@Component
public interface ISmsReadAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addSmsRead(String userId, String smsId);

    public Long totalCount(String userId, String kind, String systemCode);

}
