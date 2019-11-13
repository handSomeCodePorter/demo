package com.cloud.zhpt.admin.dao;


import com.cloud.zhpt.admin.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaDao {
    /**
     * 根据主键删除数据 sys_area
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据 sys_area
     *
     * @param record
     * @return int
     */
    int insert(Area record);

    /**
     * 插入数据，动态字段 sys_area
     *
     * @param record
     * @return int
     */
    int insertSelective(Area record);

    /**
     * 根据主键查询数据 sys_area
     *
     * @param id
     * @return Area
     */
    Area selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段 sys_area
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * 根据主键更新数据 sys_area
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Area record);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询行政区域列表
     *
     * @return List<Area>
     */
    List<Area> listArea();

    /**
     * 根据id查询区域
     *
     * @param id
     * @return Area
     */
    Area getAreaById(Integer id);

    /**
     * 查询指定父级节点下最大排序号
     *
     * @param level
     * @param parentId
     * @return Integer
     */
    Integer getMaxSort(@Param("level") Integer level, @Param("parentId") Integer parentId);

    /*
     * 根据机构编码查询机构id
     *
     * @param code
     * @return java.lang.Integer
     */
    Integer getAreaIdByCode(String code);
}
