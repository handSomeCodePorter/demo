package com.cloud.zhpt.config.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName CustomAuthFilter
 * @Description
 * @Author SW
 * @Date 2019/10/17 18:21
 **/
public class CustomAuthFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        String url = httpServletRequest.getServletPath();
        if (subject.isPermitted(url)) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", HttpStatus.FORBIDDEN.value());
        jsonObject.put("desc", "权限不足");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(jsonObject));
        response.getWriter().flush();
        return false;
    }
}
