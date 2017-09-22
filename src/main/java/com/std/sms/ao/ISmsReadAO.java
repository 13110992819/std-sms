package com.std.sms.ao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ISmsReadAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addSmsRead(String userId, List<String> smsIdList);

    public Long totalCount(String userId, String kind, String systemCode);

}
