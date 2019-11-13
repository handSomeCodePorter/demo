package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.dto.LogQuery;
import com.cloud.zhpt.admin.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {
    /**
     * 根据主键删除数据
     * sys_log
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * sys_log
     *
     * @param record
     * @return int
     */
    int insert(Log record);

    /**
     * 插入数据，动态字段
     * sys_log
     *
     * @param record
     * @return int
     */
    int insertSelective(Log record);

    /**
     * 根据主键查询数据
     * sys_log
     *
     * @param id
     * @return Log
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段
     * sys_log
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * sys_log
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(Log record);

    /**
     * 根据主键更新数据
     * sys_log
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Log record);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * 查询系统日志列表
     *
     * @param logQuery
     * @return List<Log>
     */
    List<Log> listLog(LogQuery logQuery);

    /**
     * 通过id查询系统日志
     *
     * @param id
     * @return Log
     */
    Log getLogById(Integer id);

    /**
     * 更新日志的用户代理信息
     */
    void updateUAInfo(@Param("osName") String osName, @Param("browserName") String browserName, @Param("browserVersion") String browserVersion, @Param("id") Integer id);

    /**
     * 查询日志总数
     * 注：用于日志同步
     *
     * @return
     */
    int getLogTotalCount();

    /**
     * 根据行号 查询日志
     * 注：用于日志同步
     *
     * @param startRowNo
     * @param endRowNo
     * @return
     */
    List<Log> listPagedLog(@Param("startRowNo") int startRowNo, @Param("endRowNO") int endRowNo);

}
