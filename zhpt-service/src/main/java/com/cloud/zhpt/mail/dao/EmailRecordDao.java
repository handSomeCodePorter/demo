/*
*
* EmailRecordDao.java
* @date 2019-11-13
*/
package com.cloud.zhpt.mail.dao;

import com.cloud.zhpt.mail.entity.EmailRecord;

public interface EmailRecordDao {
    /**
     *
     * @mbg.generated 2019-11-13
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-11-13
     */
    int insert(EmailRecord record);

    /**
     *
     * @mbg.generated 2019-11-13
     */
    int insertSelective(EmailRecord record);

    /**
     *
     * @mbg.generated 2019-11-13
     */
    EmailRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-11-13
     */
    int updateByPrimaryKeySelective(EmailRecord record);

    /**
     *
     * @mbg.generated 2019-11-13
     */
    int updateByPrimaryKey(EmailRecord record);
}