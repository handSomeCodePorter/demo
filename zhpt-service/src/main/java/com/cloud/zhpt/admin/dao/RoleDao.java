package com.cloud.zhpt.admin.dao;

import com.cloud.zhpt.admin.entity.Role;
import com.cloud.zhpt.admin.entity.RoleMenu;

import java.util.List;

public interface RoleDao {
    /**
     * 根据主键删除数据 sys_role
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据 sys_role
     *
     * @param record
     * @return int
     */
    int insert(Role record);

    /**
     * 插入数据，动态字段 sys_role
     *
     * @param record
     * @return int
     */
    int insertSelective(Role record);

    /**
     * 根据主键查询数据 sys_role
     *
     * @param id
     * @return Role
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据，动态字段 sys_role
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 根据主键更新数据 sys_role
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Role record);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询角色列表
     *
     * @return List<Role>
     */
    List<Role> listRole();

    /**
     * 添加角色菜单关系
     *
     * @param roleMenu
     */
    void insertRoleMenu(RoleMenu roleMenu);

    /**
     * 根据角色id删除角色菜单关系
     *
     * @param roleId
     */
    void deleteRoleMenuByRoleId(Integer roleId);

    /**
     * 根据角色id删除角色用户关系
     *
     * @param roleId
     */
    void deleteUserRoleByRoleId(Integer roleId);

    /**
     * 根据角色id批量删除角色用户关系
     *
     * @param roleIds
     */
    void deleteRoleMenuBatchByRoleId(Integer[] roleIds);

    /**
     * 根据角色id批量删除人员角色关系
     *
     * @param roleIds
     */
    void deleteUserRoleBatchByRoleId(Integer[] roleIds);

    /**
     * 批量删除角色
     *
     * @param ids
     */
    void deleteRoleBatch(Integer[] ids);

    /**
     * 查询可用角色列表，如果userId具有该角色则予以标记
     *
     * @param userId
     * @return List<Role>
     */
    List<Role> listUseableRoleForChoose(Integer userId);

    /**
     * 查询可用角色列表
     *
     * @return List<Role>
     */
    List<Role> listUseableRole();

    /**
     * 根据角色标识查询角色信息
     *
     * @param identify
     * @return Role
     */
    Role getRoleByIdentify(String identify);

    /**
     * 通过用户ID查询角色标识列表
     *
     * @param userId
     * @return List<String>
     */
    List<String> listDentifyByUserId(Integer userId);

}
