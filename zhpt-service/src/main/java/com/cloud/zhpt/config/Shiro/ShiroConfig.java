package com.cloud.zhpt.config.Shiro;


import cn.hutool.core.codec.Base64;
import com.cloud.zhpt.Utils.RedisCacheUtils;
import com.cloud.zhpt.config.cache.RedisCacheManager;
import com.cloud.zhpt.config.filter.CustomAuthFilter;
import com.cloud.zhpt.config.filter.CustomLoginFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.Filter;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description
 * @Author SW
 * @Date 2019/9/8 22:05
 **/
@Configuration
public class ShiroConfig {

    private long CACHE_EXPIRETIME = 2 * 60 * 60;

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //自定义filter
        Map<String, Filter> shiroCustomFilterMap = new HashMap<String, Filter>();

        shiroCustomFilterMap.put("customAuthFilter", new CustomAuthFilter());
        shiroCustomFilterMap.put("customLoginFilter", new CustomLoginFilter());
        shiroFilterFactoryBean.setFilters(shiroCustomFilterMap);


        shiroFilterFactoryBean.setLoginUrl("/unAuth");
        // 设置无权限时跳转的 url;
        /*  shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");*/
        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，开发权限
        filterChainDefinitionMap.put("/welcome/**", "anon");
        //游客，开发权限
        filterChainDefinitionMap.put("/loginWithRememberMe/**", "anon");

        //游客，开发权限
        filterChainDefinitionMap.put("/getImgCode/**", "anon");
        //websocket 开放权限
        filterChainDefinitionMap.put("/websocket/**", "anon");
        //用户，需要角色权限 “user”
        /*   filterChainDefinitionMap.put("/user/**", "roles[user]");*/
        //管理员，需要角色权限 “admin”
        /*    filterChainDefinitionMap.put("/admin/**", "roles[admin]");*/
        //开放登陆接口
        filterChainDefinitionMap.put("/login", "anon");

        //开发测试接口
        filterChainDefinitionMap.put("/test/**", "anon");

        filterChainDefinitionMap.put("/unAuth", "anon");

        filterChainDefinitionMap.put("/upload", "anon");
        /* filterChainDefinitionMap.put("/logout", "logout");*/

        //其余接口一律拦截 主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 customLoginFilter,customAuthFilter,
        filterChainDefinitionMap.put("/**", "authc");



        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return shiroFilterFactoryBean;
    }

  /*  @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) context.getBean("securityManager");
        securityManager.setRealm(customRealm());
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(configWebSessionManager(new RedisSessionDao()));
        securityManager.setCacheManager(shrioCacheManager());
    }*/

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(webSessionManager());
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }


    /**
     * 自定义身份认证 realm;
     * <p>
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        CustomRealm realm = new CustomRealm();
        realm.setAuthenticationCachingEnabled(true); //开启缓存
        realm.setAuthorizationCachingEnabled(true);
        return realm;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        simpleCookie.setHttpOnly(false);
        //记住我cookie生效时间,单位是秒
        simpleCookie.setMaxAge(60 * 60 * 24 * 30);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //rememberme cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey deskey = keygen.generateKey();
            byte[] cipherKey = Base64.decode(deskey.toString());
            cookieRememberMeManager.setCipherKey(cipherKey);
            cookieRememberMeManager.setCookie(rememberMeCookie());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return cookieRememberMeManager;
    }

    /**
     * 配置会话ID生成器
     *
     * @return
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    @Bean
    public RedisSessionDao redisSessionDao() {
        RedisSessionDao redisSessionDao = new RedisSessionDao();
        redisSessionDao.setSessionIdGenerator(new CustomSessionIdGenerator());
        return redisSessionDao;
    }

    @Bean
    public ShiroSessionManager webSessionManager() {
        ShiroSessionManager manager = new ShiroSessionManager();
        manager.setCacheManager(redisCacheManager());// 加入缓存管理器
        manager.setSessionDAO(redisSessionDao());// 设置SessionDao
        manager.setDeleteInvalidSessions(true);// 删除过期的session
        manager.setGlobalSessionTimeout(new RedisSessionDao().getExpireTime());// 设置全局session超时时间
        manager.setSessionValidationSchedulerEnabled(true);// 是否定时检查session
        return manager;
    }


    /**
     * Shiro生命周期处理器
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        advisorAutoProxyCreator.setUsePrefix(true);
        return advisorAutoProxyCreator;
    }


    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setExpireTime(CACHE_EXPIRETIME);
        return redisCacheManager;
    }


    /**
     * 开启shiro 注解模式
     * 可以在controller中的方法前加上注解
     * 如 @RequiresPermissions("userInfo:add")
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public RedisCacheUtils redisCacheUtils(RedisTemplate redisTemplate) {
        RedisCacheUtils redisCacheUtils = new RedisCacheUtils();
        redisCacheUtils.setRedisTemplate(redisTemplate);
        return redisCacheUtils;
    }
}
