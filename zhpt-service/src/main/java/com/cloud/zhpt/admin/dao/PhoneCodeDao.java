package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.PhoneCode;
import org.apache.ibatis.annotations.Param;

public interface PhoneCodeDao {
    /**
     * 根据主键删除数据
     * sys_phone_code
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * sys_phone_code
     *
     * @param record
     * @return int
     */
    int insert(PhoneCode record);

    /**
     * 插入数据，动态字段
     * sys_phone_code
     *
     * @param record
     * @return int
     */
    int insertSelective(PhoneCode record);

    /**
     * 根据主键查询数据
     * sys_phone_code
     *
     * @param id
     * @return PhoneCode
     */
    PhoneCode selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段
     * sys_phone_code
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(PhoneCode record);

    /**
     * 根据主键更新数据
     * sys_phone_code
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(PhoneCode record);

    /////////////////////////////////////////////////////////////

    /**
     * 根据手机号以及类型查找验证码
     *
     * @param phone
     * @param type
     * @return Integer
     */
    Integer getCodeByPhone(@Param("phone") String phone, @Param("type") Integer type);
}
