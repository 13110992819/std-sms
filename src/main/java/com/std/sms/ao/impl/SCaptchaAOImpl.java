package com.std.sms.ao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.bo.ICompanyBO;
import com.std.sms.bo.ISCaptchaBO;
import com.std.sms.domain.Company;
import com.std.sms.domain.SCaptcha;
import com.std.sms.enums.ESmsStatus;
import com.std.sms.exception.BizException;
import com.std.sms.sent.Senter;
import com.std.sms.util.PhoneUtil;
import com.std.sms.util.RandomUtil;

@Service
public class SCaptchaAOImpl implements ISCaptchaAO {

    @Autowired
    ICompanyBO companyBO;

    @Autowired
    Senter senter;

    @Autowired
    ISCaptchaBO sCaptchaBO;

    @Override
    public String doSend(String channel, String mobile) {
        String[] str = channel.split("-");
        String captcha = RandomUtil.generate4();
        String captchaContent = addContent(mobile, captcha);
        String content = changeContent(str[0], captchaContent);
        senter.send(str[0], channel, mobile, content);
        return sCaptchaBO.savaSCaptcha(channel, mobile, captcha);
    }

    @Override
    public boolean doCheck(String code, String captcha) {
        boolean result = false;
        SCaptcha data = sCaptchaBO.getSCaptcha(code);
        if (data == null) {
            throw new BizException("xn799002", "该短信验证码编号无验证码");
        }
        Date invalidDatetime = data.getInvalidDatetime();
        Date now = new Date();
        if (data.getCaptcha().equals(captcha) && invalidDatetime.after(now)) {
            data.setStatus(ESmsStatus.CHECKED.getCode());
            data.setCheckDatetime(now);
            sCaptchaBO.refreshSCaptchaInfo(data);
            result = true;
        }
        return result;
    }

    public String changeContent(String companyCode, String content) {
        Company data = companyBO.queryCompany(companyCode);
        String result = "【" + data.getPrefix() + "】" + content;
        return result;
    }

    private String addContent(String mobile, String captcha) {
        return "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户, 您的验证码为" + captcha
                + "，请妥善保管此验证码，切勿泄露给他人。";
    }

}
