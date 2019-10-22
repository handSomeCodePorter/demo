package com.cloud.zhpt.config.filter;


import com.cloud.zhpt.warper.BodyReaderHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName HttpServletRequestWrapperFilter
 * @Description 替换request 解决request中参数只能获取一次的问题
 * @Author SW
 * @Date 2019/10/14 12:16
 **/
@Component
public class HttpServletRequestWrapperFilter implements Filter {



    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if (null == requestWrapper) {

            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy() {

    }
}
