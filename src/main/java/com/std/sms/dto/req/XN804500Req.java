package com.std.sms.dto.req;

/**
 * 统计未读公告
 * @author: asus 
 * @since: 2017年9月22日 上午10:16:56 
 * @history:
 */
public class XN804500Req {
    // 用户编号
    private String userId;

    // 公告针对用户类型
    private String kind;

    // 系统编号
    private String systemCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
