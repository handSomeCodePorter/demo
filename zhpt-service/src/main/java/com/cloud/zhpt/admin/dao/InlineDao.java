package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.Inline;

public interface InlineDao {
    /**
     * 插入数据
     * sys_inline
     *
     * @param record
     * @return int
     */
    int insert(Inline record);

    /**
     * 插入数据，动态字段
     * sys_inline
     *
     * @param record
     * @return int
     */
    int insertSelective(Inline record);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 修改指定用户心跳时间
     *
     * @param inline
     */
    void updateHeartbeat(Inline inline);

    /**
     * 通过userId查询用户在线信息
     *
     * @param userId
     * @return Inline
     */
    Inline getInlineByUserId(Integer userId);
}
