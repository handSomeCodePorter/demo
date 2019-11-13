package com.cloud.zhpt.admin.Service;


import cn.hutool.crypto.SecureUtil;
import com.cloud.zhpt.Utils.PinyinToolkit;
import com.cloud.zhpt.admin.dao.UserDao;
import com.cloud.zhpt.admin.entity.Role;
import com.cloud.zhpt.admin.entity.User;
import com.cloud.zhpt.admin.entity.UserRole;
import com.cloud.zhpt.config.Shiro.CustomRealm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName UserService
 * @Description
 * @Author SW
 * @Date 2019/9/8 23:05
 **/
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * 添加用户
     *
     * @param user
     * @param roleIds
     */
    public void insertUser(User user, Integer[] roleIds) {
        // 密码加密
        String password = user.getPassword();
        user.setPassword(SecureUtil.md5(password));

        // 全拼设置
        user.setSpellFull(PinyinToolkit.cn2Spell(user.getName()));
        // 首字母设置
        user.setSpellFirst(PinyinToolkit.cn2FirstSpell(user.getName()));
        userDao.insertSelective(user);

        // 添加人员与角色关系
        if (roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(Integer.valueOf(roleId));
                userRole.setUserId(user.getId());
                userDao.insertUserRole(userRole);
            }
        }
    }


    /**
     * 修改用户信息
     *
     * @param user
     * @param roleIds
     */
    @CacheEvict(value = "userCache", allEntries = true)
    public void updateUser(User user, Integer[] roleIds) {
        // 全拼设置
        user.setSpellFull(PinyinToolkit.cn2Spell(user.getName()));
        // 首字母设置
        user.setSpellFirst(PinyinToolkit.cn2FirstSpell(user.getName()));
        userDao.updateByPrimaryKeySelective(user);
        // 添加人员与角色关系
        if (roleIds != null && roleIds.length > 0) {
            // 删除人员与角色关系
            userDao.deleteUserRoleByUserId(user.getId());
            for (Integer roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getId());
                userDao.insertUserRole(userRole);
            }
        }
        // 更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm userRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCachedAuthorizationInfo();

    }

    /**
     * 删除用户信息
     *
     * @param id
     */
/*    public void deleteUser(Integer id) {
        // 若为部门负责人，根据用户id清空用户所负责部门的部门负责人
        organService.updateOrganManager(id);
        // 若为部门分管领导，根据用户id清空用户所分管部门的分管领导
        organService.updateOrganMainDirector(id);
        // 删除人员与角色关系
        userDao.deleteUserRoleByUserId(id);
        // 删除人员
        userDao.deleteByPrimaryKey(id);
        // 更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm userRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCachedAuthorizationInfo();
    }*/


    /**
     * 根据登录账号查询用户
     *
     * @param loginName
     * @return User
     */
    public User getUserByLoginName(String loginName) {
        User user = userDao.getUserByLoginName(loginName);
//        if (user != null) {
//            user.setDgm(userDao.getUserDgmById(user.getId()));
//        }
        return user;
    }

    /**
     * 根据登录名查询角色标识
     *
     * @param loginName
     * @return Set<String>
     */
    @SuppressWarnings("unchecked")
    public Set<String> findRoles(String loginName) {
        List<Role> list = listRoleByUserLoginName(loginName);
        if (list == null) {
            return Collections.EMPTY_SET;
        } else {
            Set<String> roles = new HashSet<>();
            for (Role role : list) {
                roles.add(role.getIdentify());
            }
            return roles;
        }
    }

    /**
     * 查询指定部门ID用户数量
     *
     * @param organId
     * @return Integer
     */
    public Integer getUserCountByOrganId(Integer organId) {
        return userDao.getUserCountByOrganId(organId);
    }

    /**
     * 根据用户登录账号查询用户角色列表
     *
     * @param loginName
     * @return List<Role>
     */
    public List<Role> listRoleByUserLoginName(String loginName) {
        return userDao.listRoleByUserLoginName(loginName);
    }


    /**
     * 根据用户id更新用户登录信息
     *
     * @param userId
     * @param loginTime
     * @param loginIp
     */
    public void updateLoginInfo(Integer userId, Date loginTime, String loginIp) {
        userDao.updateLoginInfo(userId, loginTime, loginIp);
    }


    /**
     * 分页查询用户列表
     *
     * @param paraMap
     * @param pageNum
     * @param pageSize
     * @return PageInfo<User>
     */
    public PageInfo<User> listPagedUser(Map paraMap, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> listUser = userDao.listUser(paraMap);
        if (listUser != null && listUser.size() > 0) {
            for (User user : listUser) {
                List<Role> listRole = userDao.listRoleByUserLoginName(user.getLoginName());
                if (listRole != null && listRole.size() > 0) {
                    String[] roleNames = new String[listRole.size()];
                    for (int i = 0; i < listRole.size(); i++) {
                        roleNames[i] = listRole.get(i).getName();
                    }
                    user.setRoleNames(StringUtils.join(roleNames, ","));
                }
            }
        }
        PageInfo<User> p = new PageInfo<User>(listUser);
        return p;
    }


}
