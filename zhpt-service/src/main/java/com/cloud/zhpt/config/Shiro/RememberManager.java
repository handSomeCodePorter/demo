package com.cloud.zhpt.config.Shiro;

import cn.hutool.crypto.SecureUtil;
import com.cloud.zhpt.Service.UserService;
import com.cloud.zhpt.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName RememberManager
 * @Description
 * @Author SW
 * @Date 2019/10/12 13:20
 **/
@Component
public class RememberManager {

    private static final String CODE = "ZHPT";

    /**
     * cookie名称
     */
    private final static String COOKIE_NAME = "REM_KEY";

    /**
     * cookie过期时间（单位秒，默认一年）
     */
    private final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 365;


    /**
     * 用户service
     */
    @Autowired
    private static UserService userService;

    public static void saveCookie(String loginName, String passwordMD5, HttpServletResponse response) throws Exception {
        // 加密用户信息
        String cookieValueWithMd5 = SecureUtil.md5(loginName + ":" + passwordMD5 + ":" + CODE);
        // cookie值（登录账号+加密后的用户信息）
        String cookieValue = loginName + ":" + cookieValueWithMd5;
        // BASE64编码
        String cookieValueBase64 = new String(Base64Utils.encode(cookieValue.getBytes()));
        // 保存Cookie
        Cookie cookie = new Cookie(COOKIE_NAME, cookieValueBase64);
        cookie.setMaxAge(COOKIE_MAX_AGE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 验证cookie
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static User checkCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            String cookieValue = null;
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(cookie.getName(), COOKIE_NAME)) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
            if (StringUtils.isEmpty(cookieValue)) {
                return null;
            }
            // 验证cookie
            String cookieValueDecode = new String(Base64Utils.decode(cookieValue.getBytes()));
            String[] cookieValues = cookieValueDecode.split(":");
            if (cookieValues.length == 2) {
                String loginName = cookieValues[0];
                String md5ValueInCookie = cookieValues[1];

                // 验证用户
                User user = userService.getUserByLoginName(loginName);
                if (user != null) {
                    String md5ValueInDB = SecureUtil.md5(user.getLoginName() + ":" + user.getPassword() + ":" + CODE);
                    if (StringUtils.equals(md5ValueInCookie, md5ValueInDB)) {
                        return user;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 清除cookie
     *
     * @param response
     */
    public static void clearCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
