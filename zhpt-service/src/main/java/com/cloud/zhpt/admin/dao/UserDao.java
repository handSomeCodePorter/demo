/*
*
* UserDao.java
* @date 2019-09-08
*/
package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.Role;
import com.cloud.zhpt.admin.entity.User;
import com.cloud.zhpt.admin.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UserDao {
    /**
     *
     * @mbg.generated 2019-09-08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKey(User record);

    /////////////////////////////////////////////////////////////////////////


    User getUserByLoginName(String loginName);

    List<Role>listRoleByUserLoginName(String loginName);

    /**
     * 根据用户id更新用户登录信息
     *
     * @param userId
     * @param loginTime
     * @param loginIp
     */
    void updateLoginInfo(@Param("userId") Integer userId, @Param("loginTime") Date loginTime,
                         @Param("loginIp") String loginIp);


    /**
     * 添加人员与角色关系
     *
     * @param userRole
     */
    void insertUserRole(UserRole userRole);


    /**
     * 根据人员id删除人员与角色的关系
     *
     * @param userId
     */
    void deleteUserRoleByUserId(Integer userId);

    /**
     * 查询用户列表
     *
     * @param map
     * @return List<User>
     */
    List<User> listUser(Map map);

    /**
     * 查询指定部门ID用户数量
     *
     * @param organId
     * @return Integer
     */
    Integer getUserCountByOrganId(Integer organId);

}
