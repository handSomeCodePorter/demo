package com.cloud.zhpt.config.Shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * @ClassName CustomSessionIdGenerator
 * @Description
 * @Author SW
 * @Date 2019/10/16 16:49
 **/
public class CustomSessionIdGenerator implements SessionIdGenerator {


    @Override
    public Serializable generateId(Session session) {
        return "zhpt_" + new JavaUuidSessionIdGenerator().generateId(session);
    }
}
