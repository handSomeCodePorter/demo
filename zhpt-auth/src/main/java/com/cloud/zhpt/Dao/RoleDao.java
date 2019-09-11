/*
*
* RoleDao.java
* @date 2019-09-08
*/
package com.cloud.zhpt.Dao;

import com.cloud.zhpt.entity.Role;

public interface RoleDao {
    /**
     *
     * @mbg.generated 2019-09-08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    Role selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKey(Role record);
}