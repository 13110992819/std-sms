/**
 * @Title XNlh5015.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午8:14:13 
 * @version V1.0   
 */
package com.std.sms.api.impl;

import com.std.sms.ao.ISYSDictAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804907Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 详情查询数据字典
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午8:14:13 
 * @history:
 */
public class XN804907 extends AProcessor {
    private ISYSDictAO sysDictAO = SpringContextHolder
        .getBean(ISYSDictAO.class);

    private XN804907Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return sysDictAO.getSYSDict(StringValidater.toLong(req.getId()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804907Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
