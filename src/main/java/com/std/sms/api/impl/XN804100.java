package com.std.sms.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.sms.ao.ISmsReadAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804100Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 阅读公告
 * @author: asus 
 * @since: 2017年9月22日 上午10:16:56 
 * @history:
 */
public class XN804100 extends AProcessor {
    private ISmsReadAO smsReadAO = SpringContextHolder
        .getBean(ISmsReadAO.class);

    private XN804100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        smsReadAO.addSmsRead(req.getUserId(), req.getSmsIdList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804100Req.class);
        StringValidater.validateBlank(req.getUserId());
        if (CollectionUtils.isEmpty(req.getSmsIdList())) {
            throw new BizException("xn0000", "公告编号不能为空");
        }
    }

}
