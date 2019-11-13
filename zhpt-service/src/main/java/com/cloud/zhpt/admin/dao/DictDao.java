package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.dto.DictQuery;


import com.cloud.zhpt.admin.entity.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictDao {
    /**
     * 根据主键删除数据 sys_dict
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据 sys_dict
     *
     * @param record
     * @return int
     */
    int insert(Dict record);

    /**
     * 插入数据，动态字段 sys_dict
     *
     * @param record
     * @return int
     */
    int insertSelective(Dict record);

    /**
     * 根据主键查询数据 sys_dict
     *
     * @param id
     * @return Dict
     */
    Dict selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段 sys_dict
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Dict record);

    /**
     * 根据主键更新数据 sys_dict
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Dict record);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询字典列表
     *
     * @param dictQuery 查询条件
     * @return List<Dict>
     */
    List<Dict> listDict(DictQuery dictQuery);

    /**
     * 批量删除字典
     *
     * @param ids
     */
    void deleteDictBatch(Integer[] ids);

    /**
     * 查询字典类型列表
     *
     * @return List<String>
     */
    List<String> listDictType();

    /**
     * 根据类型查询字典列表
     *
     * @param type 字典类型
     * @return List<Dict>
     */
    List<Dict> listDictByType(String type);

    /**
     * 获取数据字典
     *
     * @param type
     * @param value
     * @return Dict
     */
    Dict getDictByTypeAndValue(@Param("type") String type, @Param("value") String value);

    /**
     * 获取字典标签
     *
     * @param type
     * @param value
     * @return String
     */
    String getDictLabel(@Param("type") String type, @Param("value") String value);

    /**
     * 获取字典value值
     *
     * @param type
     * @param value
     * @return String
     */
    String getDictValue(@Param("type") String type, @Param("label") String label);

    /**
     * 获取指定类型字典表最大值
     *
     * @param type
     * @return Integer
     */
    Integer getMaxDictValue(String type);

    /**
     * 获取指定类型、值的字典表列表
     *
     * @param type
     * @param value
     * @return List<Dict>
     */
    List<Dict> listDictByTypeAndValue(@Param("type") String type, @Param("value") String value);

    /**
     * 验证字典是否已存在
     *
     * @param type
     * @param value
     * @return Boolean
     */
    boolean validDictUnique(@Param("type") String type, @Param("value") String value);
}
