package com.zhpt.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.core.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

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
        HttpServletRequest req = (HttpServletRequest) RequestContext.getCurrentContext().getRequest();
        Enumeration<String> headers = req.getHeaderNames();

        logger.info("---->>>REQUEST URI:: " + req.getRequestURI());
        final RequestContext ctx = RequestContext.getCurrentContext();
        if (!ctx.isChunkedRequestBody()) {
            ServletInputStream inp = null;
            InputStreamReader is = null;
            try {
                inp = ctx.getRequest().getInputStream();
                String body = null;
                if (inp != null) {
                    is = new InputStreamReader(inp);
                    body = IOUtils.toString(is);
                    logger.info("---->>>REQUEST PARAM:: " + body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inp != null) {
                        inp.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
