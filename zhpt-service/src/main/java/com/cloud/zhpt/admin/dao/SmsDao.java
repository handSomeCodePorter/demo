package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.dto.SmsQuery;
import com.cloud.zhpt.admin.entity.Sms;

import java.util.List;

public interface SmsDao {
    /**
     * 根据主键删除数据
     * sys_sms
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * sys_sms
     *
     * @param record
     * @return int
     */
    int insert(Sms record);

    /**
     * 插入数据，动态字段
     * sys_sms
     *
     * @param record
     * @return int
     */
    int insertSelective(Sms record);

    /**
     * 根据主键查询数据
     * sys_sms
     *
     * @param id
     * @return Sms
     */
    Sms selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段
     * sys_sms
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Sms record);

    /**
     * 根据主键更新数据
     * sys_sms
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Sms record);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 根据条件查询手机短信列表
     *
     * @param smsQuery
     * @return List<Sms>
     */
    List<Sms> listSms(SmsQuery smsQuery);

    /**
     * 根据size查询待发送的短信列表
     *
     * @param size
     * @return List<Sms>
     */
    List<Sms> listSentSms(Integer size);
}
