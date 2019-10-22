package com.cloud.zhpt.config.filter;

import com.cloud.zhpt.config.filter.CrosFilter;
import com.cloud.zhpt.config.filter.HttpServletRequestWrapperFilter;
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

//    @Autowired
//    HttpServletRequestWrapperFilter httpServletRequestWrapperFilter;

    @Bean
    public FilterRegistrationBean CrosFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(2);
        return registration;
    }

   /* @Bean
    public FilterRegistrationBean registHttpServletRequestWrapperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(httpServletRequestWrapperFilter);
        registration.addUrlPatterns("/*");
        registration.setName("httpServletRequestWrapperFilter");
        registration.setOrder(1);
        return registration;
    }*/


  /*  @Bean
    public FilterRegistrationBean shiroLoginFilterRegistration(LoginFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public FilterRegistrationBean shiroPermFilterRegistration(PermFailFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }*/
}
