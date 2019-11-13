package com.cloud.zhpt.admin.Service;


import com.cloud.zhpt.admin.dao.RoleDao;

import com.cloud.zhpt.admin.entity.Role;
import com.cloud.zhpt.admin.entity.RoleMenu;
import com.cloud.zhpt.config.Shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统角色 Service
 *
 * @author huangyongjun
 * @ClassName:RoleService
 * @Description: TODO 系统角色 Service
 */
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    /**
     * 查询角色列表
     *
     * @return List<Role>
     */
    public List<Role> listRole() {
        return roleDao.listRole();
    }

    /**
     * 添加角色
     *
     * @param role    角色
     * @param menuIds 角色菜单关系中的菜单id集合
     */
    public void insertRole(Role role, Integer[] menuIds) {
        roleDao.insertSelective(role);
        if (menuIds != null && menuIds.length > 0) {
            for (Integer menuId : menuIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getId());
                roleMenu.setMenuId(menuId);
                roleDao.insertRoleMenu(roleMenu);
            }
        }
    }

    /**
     * 根据id删除角色
     *
     * @param id
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void deleteRole(Integer id) {
        // 删除角色与菜单关系表
        roleDao.deleteRoleMenuByRoleId(id);
        // 删除角色与用户表
        roleDao.deleteUserRoleByRoleId(id);
        // 删除角色
        roleDao.deleteByPrimaryKey(id);
        // 更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm userRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCachedAuthorizationInfo();
    }

    /**
     * 批量删除角色
     *
     * @param ids
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void deleteRoleBatch(Integer[] ids) {
        // 批量删除角色与菜单关系
        roleDao.deleteRoleMenuBatchByRoleId(ids);
        // 批量删除角色与用户关系
        roleDao.deleteUserRoleBatchByRoleId(ids);
        // 最后批量删除角色
        roleDao.deleteRoleBatch(ids);
        // 更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm userRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCachedAuthorizationInfo();
    }

    /**
     * 根据id查询角色
     *
     * @param id
     * @return Role
     */
    public Role getRoleById(Integer id) {
        return roleDao.selectByPrimaryKey(id);
    }

    /**
     * 修改角色
     *
     * @param role    角色
     * @param menuIds 角色菜单关系中的菜单id集合
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void updateRole(Role role, Integer[] menuIds) {
        // 先删除之前的角色菜单关系
        roleDao.deleteRoleMenuByRoleId(role.getId());
        // 然后重新添加角色菜单关系
        if (menuIds != null && menuIds.length > 0) {
            for (Integer menuId : menuIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getId());
                roleMenu.setMenuId(menuId);
                roleDao.insertRoleMenu(roleMenu);
            }
        }
        roleDao.updateByPrimaryKeySelective(role);
        // 更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm userRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCachedAuthorizationInfo();
    }

    /**
     * 查询可用角色列表，如果userId具有该角色则予以标记
     *
     * @param userId
     * @return List<Role>
     */
    public List<Role> listUseableRoleForChoose(Integer userId) {
        return roleDao.listUseableRoleForChoose(userId);
    }

    /**
     * 查询可用角色列表
     *
     * @return List<Role>
     */
    public List<Role> listUseableRole() {
        return roleDao.listUseableRole();
    }

    /**
     * 根据角色标识查询角色信息
     *
     * @param identify
     * @return Role
     */
    public Role getRoleByIdentify(String identify) {
        return roleDao.getRoleByIdentify(identify);
    }

    /**
     * 通过用户ID查询角色标识列表
     *
     * @param userId
     * @return List<String>
     */
    public List<String> listDentifyByUserId(Integer userId) {
        return roleDao.listDentifyByUserId(userId);
    }
}
