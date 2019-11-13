package com.cloud.zhpt.config.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName CustomLoginFilter
 * @Description
 * @Author SW
 * @Date 2019/10/17 16:01
 **/

public class CustomLoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if(null != subject && subject.isAuthenticated()){
            return Boolean.TRUE;
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
      //  saveRequestAndRedirectToLogin(request, response);
        saveRequestAndReturnApiAccessError(request, response);
        return false;
    }




    private void saveRequestAndReturnApiAccessError(ServletRequest request, ServletResponse response) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", HttpStatus.UNAUTHORIZED.value());
        jsonObject.put("desc", "未登录");
        try {
            flushMsgStrToClient(response, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveRequest(request);
    }

    public static void flushMsgStrToClient(ServletResponse response, Object object)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(object));
        response.getWriter().flush();
    }

}
