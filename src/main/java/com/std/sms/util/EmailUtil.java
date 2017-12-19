/**
 * @Title PhoneUtils.java 
 * @Package com.hsnet.pz.utils 
 * @Description 
 * @author miyb  
 * @date 2014-8-19 下午3:39:39 
 * @version V1.0   
 */
package com.std.sms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2014-8-19 下午3:39:39 
 * @history:
 */
public class EmailUtil {
    /** 
     * 手机号验证 
     * @param  mobile 
     * @return 验证通过返回true 
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        Pattern p = Pattern
            .compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /** 
     * 手机号验证 
     * @param  mobile 
     * @return 验证通过返回true 
     */
    public static void checkEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new BizException("FA0000", "邮箱格式非法");
        }
        Pattern p = Pattern
            .compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new BizException("FA0000", "邮箱格式非法");
        }
    }

}
