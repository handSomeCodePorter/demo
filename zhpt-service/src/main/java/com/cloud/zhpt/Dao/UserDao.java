/*
*
* UserDao.java
* @date 2019-09-08
*/
package com.cloud.zhpt.Dao;

import com.cloud.zhpt.entity.Role;
import com.cloud.zhpt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


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
}