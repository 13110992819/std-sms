package com.std.sms.dto.req;

public class XN804041Req {
    // from系统编号(选填)
    private String fromSystemCode;

    // 渠道大类(0 全渠道 1短信 2 APP 3 微信 4 公告)(选填)
    private String channelType;

    // 渠道小类(11 创世漫道 12 汇禾 21 极光推送 31 微信 41 公告)(选填)
    private String pushType;

    // to系统编号(选填)
    private String toSystemCode;

    // to类型(选填)
    private String toKind;

    // to手机号(选填)
    private String toMobile;

    // 消息类型（1 即时发 2定时发）(选填)
    private String smsType;

    // 状态（0 未发送，1 已发送） (选填)
    private String status;

    // 当前用户编号
    private String userId;

    public String getToKind() {
        return toKind;
    }

    public void setToKind(String toKind) {
        this.toKind = toKind;
    }

    public String getFromSystemCode() {
        return fromSystemCode;
    }

    public void setFromSystemCode(String fromSystemCode) {
        this.fromSystemCode = fromSystemCode;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getToSystemCode() {
        return toSystemCode;
    }

    public void setToSystemCode(String toSystemCode) {
        this.toSystemCode = toSystemCode;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
