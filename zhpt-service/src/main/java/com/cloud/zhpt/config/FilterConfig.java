package com.cloud.zhpt.config;

import com.cloud.zhpt.config.filter.CrosFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebAppConfig
 * @Description
 * @Author SW
 * @Date 2019/9/15 10:35
 **/
@Configuration
public class FilterConfig   {

    @Autowired
    CrosFilter crosFilter;

    @Bean
    public FilterRegistrationBean registCrosFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(1);
        return registration;
    }

}
