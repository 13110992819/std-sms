/**
 * @Title WxTemplate.java 
 * @Package com.std.sms.sent.wechat 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月25日 上午10:52:02 
 * @version V1.0   
 */
package com.std.sms.sent.wechat;

import java.util.Map;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月25日 上午10:52:02 
 * @history:
 */
public class WxTemplate {
    private String template_id;

    private String touser;

    private String url;

    private String topcolor;

    private Map<String, TemplateData> data;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TemplateData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}