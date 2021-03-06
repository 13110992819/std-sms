package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.dto.req.XN804083Req;
import com.std.sms.dto.res.PKCodeRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.EmailUtil;

/**
 * 指定系统发送短信验证码
 * @author: xieyj 
 * @since: 2017年2月2日 上午10:24:30 
 * @history:
 */
public class XN804083 extends AProcessor {

    private ISCaptchaAO sCaptchaAO = SpringContextHolder
        .getBean(ISCaptchaAO.class);

    private XN804083Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = sCaptchaAO.doSendEmailBySystem(req.getSystemCode(),
            req.getCompanyCode(), req.getEmail(), req.getBizType());
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804083Req.class);
        if (StringUtils.isBlank(req.getSystemCode())) {
            throw new ParaException("xn804081", "系统编号不能为空");
        }
        if (!EmailUtil.isEmail(req.getEmail())) {
            throw new ParaException("xn804081", "邮箱格式非法");
        }
        if (StringUtils.isBlank(req.getBizType())) {
            throw new ParaException("xn804081", "业务类型不能为空");
        }
    }
}
