package com.std.sms.api.impl;

import com.std.sms.ao.ISmsReadAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804500Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 统计未读公告
 * @author: asus 
 * @since: 2017年9月22日 上午10:16:56 
 * @history:
 */
public class XN804500 extends AProcessor {
    private ISmsReadAO smsReadAO = SpringContextHolder
        .getBean(ISmsReadAO.class);

    private XN804500Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return smsReadAO.totalCount(req.getUserId(), req.getKind(),
            req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804500Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getKind(),
            req.getSystemCode());
    }

}
