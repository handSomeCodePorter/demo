package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.dto.MessageQuery;
import com.cloud.zhpt.admin.entity.Message;

import java.util.List;

public interface MessageDao {
    /**
     * 根据主键删除数据
     * sys_message
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * sys_message
     *
     * @param record
     * @return int
     */
    int insert(Message record);

    /**
     * 插入数据，动态字段
     * sys_message
     *
     * @param record
     * @return int
     */
    int insertSelective(Message record);

    /**
     * 根据主键查询数据
     * sys_message
     *
     * @param id
     * @return Message
     */
    Message selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段
     * sys_message
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * 根据主键更新数据
     * sys_message
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Message record);

    /**
     * 根据用户id查询系统消息列表
     *
     * @param userId
     * @return List<Message>
     */
    List<Message> listMessageByUserId(Integer userId);

    /**
     * 根据用户id查询未读且未过期消息列表
     *
     * @param userId
     * @return List<Message>
     */
    List<Message> listUnreadMessageByUserId(Integer userId);

    /**
     * 条件查询消息列表
     *
     * @param messageQuery
     * @return List<Message>
     */
    List<Message> listMessage(MessageQuery messageQuery);

    /**
     * 批量标记消息为已读
     *
     * @param ids
     */
    void updateMessageReadedBatch(Integer[] ids);
}
