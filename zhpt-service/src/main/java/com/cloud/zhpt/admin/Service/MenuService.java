package com.cloud.zhpt.admin.Service;

import com.cloud.zhpt.admin.dao.MenuDao;

import com.cloud.zhpt.config.Shiro.CustomRealm;
import com.cloud.zhpt.admin.entity.Menu;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 菜单权限 Service
 *
 * @ClassName: MenuService
 * @Description:  菜单权限 Service
 * @author sw
 */
@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    /**
     * 查询菜单列表
     *
     * @return List<Menu>
     */
    public List<Menu> listMenu() {
        return menuDao.listMenu();
    }

    /**
     * 根据id查询菜单
     *
     * @param id
     * @return Menu
     */
    public Menu getMenuById(Integer id) {
        return menuDao.getMenuById(id);
    }

    /**
     * 添加菜单
     *
     * @param menu
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void insertMenu(Menu menu) {
        menuDao.insertSelective(menu);
    }

    /**
     * 修改菜单
     *
     * @param menu
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void updateMenu(Menu menu) {
        menuDao.updateByPrimaryKeySelective(menu);
        // 同步设置子菜单是否显示
        List<Menu> listChildrenMenu = listTreeMenuByParentId(menu.getId());
        if (listChildrenMenu != null) {
            Integer[] ids = new Integer[listChildrenMenu.size()];
            for (int i = 0; i < listChildrenMenu.size(); i++) {
                ids[i] = listChildrenMenu.get(i).getId();
            }
            menuDao.updateShowBatch(ids, menu.getIsShow());
        }
        //更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm customRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        customRealm.clearAllCachedAuthorizationInfo();
    }

    /**
     * 删除菜单
     *
     * @param id
     */
    @CacheEvict(value = "menuCache", allEntries = true)
    public void deleteMenu(Integer id) {
        // 先删除菜单的角色菜单关系
        menuDao.deleteRoleMenuByMenuId(id);
        // 再删除菜单
        menuDao.deleteByPrimaryKey(id);
        //更新用户权限缓存
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        CustomRealm CustomRealm = (CustomRealm) securityManager.getRealms().iterator().next();
        CustomRealm.clearAllCachedAuthorizationInfo();
    }

    /**
     * 查询指定父级节点下最大排序号
     *
     * @param level
     * @param parentId
     * @return Integer
     */
    public Integer getMaxSort(Integer level, Integer parentId) {
        return menuDao.getMaxSort(level, parentId);
    }

    /**
     * 根据父id查询子菜单
     *
     * @param parentId
     * @return List<Menu>
     */
    public List<Menu> listMenuByParentId(Integer parentId) {
        return menuDao.listMenuByParentId(parentId);
    }

    /**
     * 查询菜单如果属于该角色下的菜单则予以标记
     *
     * @param roleId
     * @return List<Menu>
     */
    public List<Menu> listTreeMenuByRoleId(Integer roleId) {
        return menuDao.listTreeMenuByRoleId(roleId);
    }

    /**
     * 根据父id和userId查询具有权限的子菜单
     *
     * @param parentId
     * @param userId
     * @return List<Menu>
     */
    public List<Menu> listMenuByParentIdAndUserId(Integer parentId, Integer userId) {
        return menuDao.listMenuByParentIdAndUserId(parentId, userId);
    }

    /**
     * 根据父id查询子级菜单（递归查询）
     *
     * @param parentId
     * @return List<Menu>
     */
    public List<Menu> listTreeMenuByParentId(Integer parentId) {
        return menuDao.listTreeMenuByParentId(parentId);
    }

    /**
     * 根据用户ID查询该用户具有操作权限的顶层菜单
     *
     * @param userId
     * @return List<Menu>
     */
    @Cacheable(value = "menuCache", key = "'list_menu_top_level_'+#userId")
    public List<Menu> listMenuTopLevelByUserId(Integer userId) {
        return menuDao.listMenuTopLevelByUserId(userId);
    }

    /**
     * 查询树形结构菜单
     *
     * @param rootId
     * @param userId
     * @return Menu
     */
    @Cacheable(value = "menuCache", key = "'menu_tree_'+#rootId+'_'+#userId")
    public Menu getTreeMenuByRootIdAndUserId(Integer rootId, Integer userId) {
        Menu rootMenu = getMenuById(rootId);
        recursiveLoadMenu(rootMenu, userId);
        return rootMenu;
    }

    /**
     * 递归载入具有权限的子菜单
     *
     * @param menu
     * @param userId
     */
    private void recursiveLoadMenu(Menu menu, Integer userId) {
        if (menu.getLeaf().intValue() == 1) {
            return;
        }
        List<Menu> listMenu = listMenuByParentIdAndUserId(menu.getId(), userId);
        if (listMenu == null || listMenu.size() == 0) {
            return;
        }
        for (Menu m : listMenu) {
            recursiveLoadMenu(m, userId);
        }
        menu.setChildren(listMenu);
    }

    /**
     * 根据rootId以及userId获取叶子节点
     *
     * @param rootId
     * @param userId
     * @return Menu
     */
    @Cacheable(value = "menuCache", key = "'menu_leaf_'+#rootId+'_'+#userId")
    public Menu getLeafMenuByRootIdAndUserId(Integer rootId, Integer userId) {
        return menuDao.getLeafMenuByRootIdAndUserId(rootId, userId);
    }

    /**
     * 根据用户id获取快捷方式菜单
     *
     * @param userId
     * @return List<Menu>
     */
    public List<Menu> listShortcutMenuByUserId(Integer userId) {
        return menuDao.listShortcutMenuByUserId(userId);
    }

    /**
     * 根据用户id获取用户菜单列表
     *
     * @param userId
     * @return List<Menu>
     */
    public List<Menu> listMenuByUserId(Integer userId) {
        return menuDao.listMenuByUserId(userId);
    }

    /**
     * 根据用户登录账号获取用户操作菜单
     *
     * @param loginName
     * @return List<Menu>
     */
    public List<Menu> listLeafMenuByLoginName(String loginName) {
        return menuDao.listLeafMenuByLoginName(loginName);
    }

    /**
     * 根据登录名查询权限标识
     * @param loginName
     * @return Set<String>
     */
    @SuppressWarnings("unchecked")
    public Set<String> findPermissions(String loginName) {
        List<Menu> list = listLeafMenuByLoginName(loginName);
        if (list == null) {
            return Collections.EMPTY_SET;
        } else {
            Set<String> permissions = new HashSet<>();
            for (Menu menu : list) {
                if (StringUtils.isNotEmpty(menu.getShiroPermissions())) {
                    String[] ar = menu.getShiroPermissions().split(",");
                    for (String permission : ar) {
                        if(StringUtils.isNotEmpty(permission)){
                            permissions.add(permission);
                        }
                    }
                }
            }
            return permissions;
        }
    }
}
