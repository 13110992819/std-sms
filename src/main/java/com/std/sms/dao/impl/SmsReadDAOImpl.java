package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISmsReadDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.SmsRead;

@Repository("smsReadDAOImpl")
public class SmsReadDAOImpl extends AMybatisTemplate implements ISmsReadDAO {

    @Override
    public int insert(SmsRead data) {
        return super.insert(NAMESPACE.concat("insert_smsRead"), data);
    }

    @Override
    public int delete(SmsRead data) {
        return super.delete(NAMESPACE.concat("delete_smsRead"), data);
    }

    @Override
    public SmsRead select(SmsRead condition) {
        return super.select(NAMESPACE.concat("select_smsRead"), condition,
            SmsRead.class);
    }

    @Override
    public long selectTotalCount(SmsRead condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_smsRead_count"),
            condition);
    }

    @Override
    public List<SmsRead> selectList(SmsRead condition) {
        return super.selectList(NAMESPACE.concat("select_smsRead"), condition,
            SmsRead.class);
    }

    @Override
    public List<SmsRead> selectList(SmsRead condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_smsRead"), start,
            count, condition, SmsRead.class);
    }

}
