package com.cloud.zhpt.Service;


import com.cloud.zhpt.Dao.UserDao;
import com.cloud.zhpt.entity.Role;
import com.cloud.zhpt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
}
