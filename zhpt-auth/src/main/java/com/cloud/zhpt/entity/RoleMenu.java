/*
*
* RoleMenu.java
* @date 2019-09-09
*/
package com.cloud.zhpt.entity;

public class RoleMenu {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单权限ID
     */
    private Integer menuId;

    /**
     * 角色ID
     * @return ROLE_ID 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 菜单权限ID
     * @return MENU_ID 菜单权限ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 菜单权限ID
     * @param menuId 菜单权限ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}