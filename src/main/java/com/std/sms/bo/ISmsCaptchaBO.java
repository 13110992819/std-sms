package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SmsCaptcha;

/**
 * 短信验证码
 * @author: xieyj 
 * @since: 2015-3-10 下午8:37:28 
 * @history:
 */
public interface ISmsCaptchaBO extends IPaginableBO<SmsCaptcha> {

    public int saveSentSmsCaptcha(SmsCaptcha data);

    public void checkSmsCaptcha(String mobile, String captcha, String bizType);

    public SmsCaptcha getSmsCaptchaBO(Long id);

    public List<SmsCaptcha> querySmsCaptchaBOList(SmsCaptcha condition);

}
