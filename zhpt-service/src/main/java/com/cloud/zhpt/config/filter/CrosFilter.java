package com.cloud.zhpt.config.filter;


import com.cloud.zhpt.warper.BodyReaderHttpServletRequestWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName CrosFilter
 * @Description
 * @Author SW
 * @Date 2019/9/15 10:19
 **/
@Component
public class CrosFilter implements Filter {

    @Value("${spring.cloud.cros.allow-origin}")
    private String allowOrigin ;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String origin = request.getHeader("Origin");
        if (origin == null) {
            origin = request.getHeader("Referer");
        }
        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessToken,TOKEN,username,offlineticket,Authorization");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        filterChain.doFilter(request, httpServletResponse);

    }



    @Override
    public void destroy() {

    }
}
