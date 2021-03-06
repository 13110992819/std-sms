package com.std.sms.dto.req;

/**
 * 公告修改
 * @author: xieyj 
 * @since: 2016年11月29日 上午11:53:27 
 * @history:
 */
public class XN804035Req {
    // 序号(必填)
    private String id;

    // 消息类型(必填)（1 即时发 2定时发）
    private String smsType;

    // to分组(1 C端，2 B端，3 平台)(必填)
    private String toKind;

    // 消息标题(必填)
    private String smsTitle;

    // 消息内容(必填)
    private String smsContent;

    // 拟发送时间(选填，定时发必填)
    private String topushDatetime;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getTopushDatetime() {
        return topushDatetime;
    }

    public void setTopushDatetime(String topushDatetime) {
        this.topushDatetime = topushDatetime;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToKind() {
        return toKind;
    }

    public void setToKind(String toKind) {
        this.toKind = toKind;
    }
}
