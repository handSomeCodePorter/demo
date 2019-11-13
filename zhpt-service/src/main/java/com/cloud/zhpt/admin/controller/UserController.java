package com.cloud.zhpt.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloud.zhpt.common.controller.BaseController;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.Service.RoleService;
import com.cloud.zhpt.admin.Service.UserService;
import com.cloud.zhpt.admin.entity.Role;
import com.cloud.zhpt.admin.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author SW
 * @Date 2019/10/26 14:26
 **/
@RequestMapping("/admin/user")
@RestController
public class UserController extends BaseController {


    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    /**
     * 新增user
     *
     * @param user
     * @param
     * @return
     */
    @PostMapping("/insertUser")
    public HttpResult insertUser(User user) {
        userService.insertUser(user, user.getRoleIds());
        return new HttpResult(HttpResult.SUCCESS);
    }

    /**
     * 修改user
     *
     * @param user
     * @param roleIds
     * @return
     */
    @PostMapping("/updateUser")
    public HttpResult updateUser(User user, Integer[] roleIds) {
        userService.updateUser(user, roleIds);
        return new HttpResult(HttpResult.SUCCESS);
    }

    /**
     * 分页查询用户列表
     *
     * @param paraMap
     * @param pageNum
     * @param pageSize
     */
    @RequestMapping("/listPagedUser")
    public HttpResult listPagedUser(Map paraMap, Integer pageNum, Integer pageSize) {

        PageInfo<User> page = userService.listPagedUser(paraMap, pageNum, pageSize);
        // 查询可用角色列表
        List<Role> listUseableRole = roleService.listUseableRole();
        Map retMap = new HashMap();
        retMap.put("page", page);
        retMap.put("listUseableRole", listUseableRole);

        return new HttpResult(HttpResult.SUCCESS, retMap);
    }


}
