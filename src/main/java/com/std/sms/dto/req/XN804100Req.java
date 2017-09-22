package com.std.sms.dto.req;

import java.util.List;

/**
 * 阅读公告
 * @author: asus 
 * @since: 2017年9月22日 上午10:16:56 
 * @history:
 */
public class XN804100Req {
    // 用户编号
    private String userId;

    // 公告编号
    private List<String> smsIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSmsIdList() {
        return smsIdList;
    }

    public void setSmsIdList(List<String> smsIdList) {
        this.smsIdList = smsIdList;
    }

}
