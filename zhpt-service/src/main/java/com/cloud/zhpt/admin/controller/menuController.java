package com.cloud.zhpt.admin.controller;

import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.Service.MenuService;
import com.cloud.zhpt.admin.entity.Menu;
import com.cloud.zhpt.admin.entity.User;
import com.cloud.zhpt.config.Shiro.RedisSessionDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName menuController
 * @Description
 * @Author SW
 * @Date 2019/9/29 18:21
 **/
@RequestMapping("/admin/menu")
@RestController
public class menuController {

    @Autowired
    MenuService menuService;

    @Autowired
    RedisSessionDao redisSessionDao;

    /**
     * 查询菜单列表
     *
     * @return
     */
    @RequestMapping("/listMenu")
    public HttpResult listMenu() {
        List<Menu> list = menuService.listMenu();
        return new HttpResult(HttpResult.SUCCESS, list);
    }


    //@RequiresPermissions("admin:menu:list")
    @PostMapping("/listTopMenu")
    public HttpResult listTopMenu(User user) {
        // 查询顶级菜单
        List<Menu> listTopMenu = menuService.listMenuTopLevelByUserId(user.getId());
        return new HttpResult(HttpResult.SUCCESS, listTopMenu);
    }


    @PostMapping("/insertMenu")
    public HttpResult insertMenu(Menu menu) {
        menuService.insertMenu(menu);
        return new HttpResult(HttpResult.SUCCESS, "新增成功");
    }

    /* @RequiresPermissions("admin:menu:manage")*/
    @PostMapping("/updateMenu")
    public HttpResult updateMenu(Menu menu) {
        // menuService.updateMenu(menu);
        return new HttpResult(HttpResult.SUCCESS, "修改成功");
    }

    /**
     * u
     * 删除菜单
     *
     * @param id
     * @return ModelAndView
     */
//    @RequiresPermissions("admin:menu:manage")
    @RequestMapping("/deleteMenu")
    public HttpResult deleteMenu(Integer id) {
        menuService.deleteMenu(id);
        return new HttpResult(HttpResult.SUCCESS, "删除成功");
    }

    @PostMapping("/getMenuByRootIdAndUser")
    public HttpResult getMenuByRootIdAndUser(Integer rootId, Integer userId) {
        Menu menu = menuService.getTreeMenuByRootIdAndUserId(rootId, userId);
        return new HttpResult(HttpResult.SUCCESS,menu);
    }
}
