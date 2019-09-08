/*
*
* UserDao.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-09-08
*/
package com.cloud.zhpt.Dao;

import com.cloud.zhpt.entity.User;

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
}