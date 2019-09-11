package com.cloud.zhpt.config.Shiro;

import com.cloud.zhpt.Service.MenuService;
import com.cloud.zhpt.Service.UserService;
import com.cloud.zhpt.controller.LoginController;
import com.cloud.zhpt.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName CustomRealm
 * @Description
 * @Author SW
 * @Date 2019/9/8 22:17
 **/
public class CustomRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    /**
     * 权限验证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 用户授权
        authorizationInfo.setRoles(userService.findRoles(loginName));
        authorizationInfo.setStringPermissions(menuService.findPermissions(loginName));
        return authorizationInfo;
    }

    /**
     * 获取身份验证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("【系统登陆】开始身份认证……");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        User user = userService.getUserByLoginName(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException("【系统登陆】用户不存在");
        } else if (user.getLocked().intValue() == 1) {
            throw new LockedAccountException(); // 帐号锁定
        }

        return new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(), getName());
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
