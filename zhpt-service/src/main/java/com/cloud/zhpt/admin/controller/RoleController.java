package com.cloud.zhpt.admin.controller;

import com.cloud.zhpt.common.controller.BaseController;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.Service.RoleService;
import com.cloud.zhpt.admin.entity.Role;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统角色 Controller
 *
 * @author sw
 * @ClassName:RoleController
 * @Description: 系统角色 Controller
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;

    /**
     * 查找角色列表
     */
    @PostMapping("/listRole")
    public HttpResult listRole() {
        List<Role> list = roleService.listRole();

        return new HttpResult(HttpResult.SUCCESS, list);
    }

    /**
     * 添加角色
     *
     * @param role         角色
     *                     角色菜单关系中的菜单id集合
     * @param redirectPage
     * @return HttpResult
     */
    /*  @RequiresPermissions("admin:role:manage")*/
    @PostMapping(value = "/insertRole")
    public HttpResult insertRole(Role role, String redirectPage) {
        roleService.insertRole(role, role.getMenuIds());
        return new HttpResult(HttpResult.SUCCESS, "新增成功");
    }

    /**
     * 根据id删除角色
     *
     * @param id
     * @return HttpResult
     */
    @RequiresPermissions("admin:role:manage")
    @PostMapping("/deleteRole")
    public HttpResult deleteRole(Integer id) {
        roleService.deleteRole(id);
        return new HttpResult(HttpResult.SUCCESS, "删除成功");
    }

    /**
     * 批量删除角色
     *
     * @param ids
     * @return HttpResult
     */
    @RequiresPermissions("admin:role:manage")
    @PostMapping("/deleteRoleBatch")
    public HttpResult deleteRoleBatch(Integer[] ids) {
        roleService.deleteRoleBatch(ids);
        return new HttpResult(HttpResult.SUCCESS, "删除成功");
    }


    /**
     * 修改角色
     *
     * @param role 角色
     *             角色菜单关系中的菜单id集合
     * @return HttpResult
     */
    /*@RequiresPermissions("admin:role:manage")*/
    @PostMapping(value = "updateRole")
    public HttpResult updateRole(Role role) {
        roleService.updateRole(role, role.getMenuIds());
        return new HttpResult(HttpResult.SUCCESS, "修改成功");
    }


}
