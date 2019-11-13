package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.Organ;
import com.cloud.zhpt.admin.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganDao {
    /**
     * 根据主键删除数据 sys_organ
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据 sys_organ
     *
     * @param record
     * @return int
     */
    int insert(Organ record);

    /**
     * 插入数据，动态字段 sys_organ
     *
     * @param record
     * @return int
     */
    int insertSelective(Organ record);

    /**
     * 根据主键查询数据 sys_organ
     *
     * @param id
     * @return Organ
     */
    Organ selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段 sys_organ
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Organ record);

    /**
     * 根据主键更新数据 sys_organ
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Organ record);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询机构列表
     *
     * @return List<Organ>
     */
    List<Organ> listOrgan();

    /**
     * 根据id查询机构信息
     *
     * @param id
     * @return Organ
     */
    Organ getOrganById(Integer id);

    /**
     * 根据用户登录账号查询其机构信息
     *
     * @param loginName
     * @return Organ
     */
    Organ getOrganByUserLoginName(String loginName);

    /**
     * 批量查询所有子机构
     *
     * @param parentId
     * @return List<Organ>
     */
    List<Organ> listOrganByParentId(Integer parentId);

    /**
     * 批量修改可用状态
     *
     * @param ids
     * @param useable
     */
    void updateUseableBatch(@Param("ids") Integer[] ids, @Param("useable") Integer useable);

    /**
     * 查询指定父节点下机构排序最大值
     *
     * @param level
     * @param parentId
     * @return Integer
     */
    Integer getMaxSort(@Param("level") Integer level, @Param("parentId") Integer parentId);

    /**
     * 查询可用的机构列表
     *
     * @return List<Organ>
     */
    List<Organ> listUseableOrgan();

    /**
     * 查询可用的机构列表（查询指定机构ID下面的机构）
     *
     * @param rootOrganId
     * @return List<Organ>
     */
    List<Organ> listUseableOrganByRootId(Integer rootOrganId);

    /**
     * 查询可用的机构列表
     *
     * @return List<Organ>
     */
    List<Organ> listUseableRootOrgan();

    /**
     * 获取机构分管领导
     *
     * @param organId
     * @return User
     */
    User getMainDirectorUser(Integer organId);

    /**
     * 获取机构负责人
     *
     * @param organId
     * @return User
     */
    User getManagerUser(Integer organId);

    /**
     * 根据id查询机构类别
     *
     * @param id
     * @return String
     */
    String getOrganTypeById(Integer id);

    /**
     * 查询纳入廉政教育的机构（一级部门单位）
     *
     * @return List<Organ>
     */
    List<Organ> listOrganInEdu();

    /**
     * 查询纳入廉政教育的机构（一级部门单位排除集团领导、外部单位）
     *
     * @return List<Organ>
     */
    List<Organ> listOrganInEduFiltrate();

    /**
     * 查询纳入廉政教育的机构（分公司子部门）
     *
     * @return List<Organ>
     */
    List<Organ> listSubOrganInEdu();

    /**
     * 根据用户id查询负责部门
     *
     * @param userId
     * @return List<Organ>
     */
    List<Organ> listManagerOrganByUserId(Integer userId);

    /**
     * 根据用户id查询分管部门列表
     *
     * @param userId
     * @return List<Organ>
     */
    List<Organ> listAppointedOrganByUserId(Integer userId);

    /**
     * 查询一级部门列表
     *
     * @return List<Organ>
     */
    List<Organ> listRootOrgan();

    /**
     * 根据机构id查询直属子机构集合
     *
     * @param organId
     * @return List<Organ>
     */
    List<Organ> listChildOrganByOrganId(Integer organId);

    /**
     * 根据机构id查询直属子机构集合（参与廉政教育的子机构）
     *
     * @param organId
     * @return List<Organ>
     */
    List<Organ> listChildOrganInEduByOrganId(Integer organId);

    /**
     * 根据机构名称和父级机构名称查询机构信息（用于导入用户）
     *
     * @param name
     * @param parentName
     * @return Organ
     */
    Organ getOrganByNameAndParentName(@Param("name") String name, @Param("parentName") String parentName);

    /**
     * 根据机构名称查询一级部门机构id（用于导入用户）
     *
     * @param name
     * @return Integer
     */
    Integer getOrganIdByOrganName(String name);

    /**
     * 删除用户时，根据用户id清空用户所负责部门的部门负责人
     *
     * @param userId
     */
    void updateOrganManager(Integer userId);

    /**
     * 删除用户时，根据用户id清空用户所分管部门的分管领导
     *
     * @param userId
     */
    void updateOrganMainDirector(Integer userId);

    /**
     * 删除用户时，根据用户id清空用户所属机构的联络员
     *
     * @param userId
     */
    void updateOrganLiaison(Integer userId);

    /**
     * 根据部门名称递归查找部门列表
     *
     * @param organName
     * @return List<Organ>
     */
    List<Organ> listOrganByName(String organName);

    /**
     * 修改指定机构的删除状态
     *
     * @param id
     * @param deleted
     */
    void updateOrganDeletedById(@Param("id") Integer id, @Param("deleted") Integer deleted);

    /**
     * 根据分管领导ID查询部门ID列表
     *
     * @param mainDirectorId
     * @return List<Integer>
     */
    List<Integer> listOrganIdByMainDirectorId(Integer mainDirectorId);

    /**
     * 根据机构编码查询机构
     *
     * @param code
     * @return
     */
    Organ getOrganByCode(String code);

    /*
     * 根据hr系统中的公司（部门）编码查询机构信息
     *
     * @param hrNo
     * @return com.cloud.zhpt.admin.entity.Organ
     */
    Organ getOrganByHrNo(String hrNo);

    /*
     * 禁用所有机构
     *
     * @return void
     */
    void disableAllOrgan();
}
