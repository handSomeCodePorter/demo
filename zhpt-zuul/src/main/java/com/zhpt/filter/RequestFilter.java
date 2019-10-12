package com.zhpt.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RequestFilter
 * @Description
 * @Author SW
 * @Date 2019/9/30 16:26
 **/
@Component
public class RequestFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = (HttpServletRequest) RequestContext.getCurrentContext().getRequest();

        String url = String.valueOf(request.getRequestURI());

        // 请求方法
        String method = request.getMethod();
        logger.info("------>>>current request url is:" + url);
        if (method.equals("POST")) {
            Enumeration<String> parameterNames = request.getParameterNames();
            Map res = new HashMap();
            while (parameterNames.hasMoreElements()) {
                res.put(parameterNames, (String) request.getParameter(parameterNames.nextElement()));
            }
            Map<String, String[]> pmap = request.getParameterMap();
            logger.info("------>>>current request data is:" + res.toString());
        }


        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


}
