/*
*
* Menu.java
* @date 2019-09-08
*/
package com.cloud.zhpt.entity;

import java.util.Date;
import java.util.List;

public class Menu {
    /**
     * ID
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 链接地址
     */
    private String href;

    /**
     * 打开目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限标识
     */
    private String permissions;

    /**
     * SHIRO权限标识
     */
    private String shiroPermissions;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否设置快捷方式
     */
    private Integer shortcut;

    /**
     * 快捷方式图标
     */
    private String shortcutIcon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /**
     * 父级ID
     */
    private Integer parentId;

    /*********************** 以下是自己添加字段 strat ****************************/

    /**
     * 菜单层级
     */
    private Integer menuLevel;

    /**
     * 是否是叶子节点
     */
    private Integer leaf;

    /**
     * 菜单路径全称
     */
    private String pathName;

    /**
     * 菜单ID全称
     */
    private String pathId;

    /**
     * 菜单所在根节点Id
     */
    private Integer rootId;

    /**
     * 菜单所在根节点名称
     */
    private String rootName;

    /**
     * 父级菜单名称
     */
    private String parentName;

    /**
     * 子菜单
     */
    private List<Menu> children;

    /**
     * 在树结构上是否默认勾选 1是 0否
     */
    private Integer treeMenuChecked;

    /**
     * 顶级菜单下第一个叶子菜单
     */
    private Menu firstLeafMenu;

    /*********************** 以上是自己添加字段 end ****************************/


    /**
     * ID
     * @return ID ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 菜单名称
     * @return NAME 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 链接地址
     * @return HREF 链接地址
     */
    public String getHref() {
        return href;
    }

    /**
     * 链接地址
     * @param href 链接地址
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 打开目标
     * @return TARGET 打开目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 打开目标
     * @param target 打开目标
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 图标
     * @return ICON 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 权限标识
     * @return PERMISSIONS 权限标识
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * 权限标识
     * @param permissions 权限标识
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * SHIRO权限标识
     * @return SHIRO_PERMISSIONS SHIRO权限标识
     */
    public String getShiroPermissions() {
        return shiroPermissions;
    }

    /**
     * SHIRO权限标识
     * @param shiroPermissions SHIRO权限标识
     */
    public void setShiroPermissions(String shiroPermissions) {
        this.shiroPermissions = shiroPermissions;
    }

    /**
     * 是否显示
     * @return IS_SHOW 是否显示
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 是否显示
     * @param isShow 是否显示
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * 排序
     * @return SORT 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 是否设置快捷方式
     * @return SHORTCUT 是否设置快捷方式
     */
    public Integer getShortcut() {
        return shortcut;
    }

    /**
     * 是否设置快捷方式
     * @param shortcut 是否设置快捷方式
     */
    public void setShortcut(Integer shortcut) {
        this.shortcut = shortcut;
    }

    /**
     * 快捷方式图标
     * @return SHORTCUT_ICON 快捷方式图标
     */
    public String getShortcutIcon() {
        return shortcutIcon;
    }

    /**
     * 快捷方式图标
     * @param shortcutIcon 快捷方式图标
     */
    public void setShortcutIcon(String shortcutIcon) {
        this.shortcutIcon = shortcutIcon;
    }

    /**
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }




    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * @return MODIFY_TIME 最后修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     * @param modifyTime 最后修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 父级ID
     * @return PARENT_ID 父级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级ID
     * @param parentId 父级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getTreeMenuChecked() {
        return treeMenuChecked;
    }

    public void setTreeMenuChecked(Integer treeMenuChecked) {
        this.treeMenuChecked = treeMenuChecked;
    }

    public Menu getFirstLeafMenu() {
        return firstLeafMenu;
    }

    public void setFirstLeafMenu(Menu firstLeafMenu) {
        this.firstLeafMenu = firstLeafMenu;
    }
}