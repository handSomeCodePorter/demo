/*
*
* MenuDao.java
* @date 2019-09-08
*/
package com.cloud.zhpt.Dao;

import com.cloud.zhpt.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    /**
     *
     * @mbg.generated 2019-09-08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated 2019-09-08
     */
    int updateByPrimaryKey(Menu record);


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询菜单列表
     *
     * @return List<Menu>
     */
    List<Menu> listMenu();

    /**
     * 通过id查询菜单
     *
     * @param id
     * @return Menu
     */
    Menu getMenuById(Integer id);

    /**
     * 根据父id查询子菜单
     *
     * @param parentId
     * @return List<Menu>
     */
    List<Menu> listMenuByParentId(Integer parentId);

    /**
     * 根据父id和userId查询具有权限的子菜单
     *
     * @param parentId
     * @param userId
     * @return List<Menu>
     */
    List<Menu> listMenuByParentIdAndUserId(@Param("parentId") Integer parentId, @Param("userId") Integer userId);

    /**
     * 根据父id查询所有子级菜单
     *
     * @param parentId
     * @return List<Menu>
     */
    List<Menu> listTreeMenuByParentId(Integer parentId);

    /**
     * 批量设置菜单是否显示
     *
     * @param
     * @param show
     */
    void updateShowBatch(@Param("ids") Integer[] ids, @Param("show") Integer show);

    /**
     * 查询指定父级节点下最大排序号
     *
     * @param level
     * @param parentId
     * @return Integer
     */
    Integer getMaxSort(@Param("level") Integer level, @Param("parentId") Integer parentId);

    /**
     * 查询菜单如果属于该角色下的菜单则予以标记
     *
     * @param roleId
     * @return List<Menu>
     */
    List<Menu> listTreeMenuByRoleId(Integer roleId);

    /**
     * 根据用户ID查询该用户具有操作权限的顶层菜单
     *
     * @param userId
     * @return List<Menu>
     */
    List<Menu> listMenuTopLevelByUserId(Integer userId);

    /**
     * 根据菜单id删除角色菜单关系
     *
     * @param menuId
     */
    void deleteRoleMenuByMenuId(Integer menuId);

    /**
     * 根据rootId以及userId获取叶子节点
     *
     * @param rootId
     * @param userId
     * @return Menu
     */
    Menu getLeafMenuByRootIdAndUserId(@Param("rootId") Integer rootId, @Param("userId") Integer userId);

    /**
     * 根据用户登录账号获取用户操作菜单
     * @param loginName
     * @return List<Menu>
     */
    List<Menu> listLeafMenuByLoginName(String loginName);

    /**
     * 根据用户id获取快捷方式菜单
     *
     * @param userId
     * @return List<Menu>
     */
    List<Menu> listShortcutMenuByUserId(Integer userId);

    /**
     * 根据用户id获取用户菜单列表
     *
     * @param userId
     * @return List<Menu>
     */
    List<Menu> listMenuByUserId(Integer userId);
}