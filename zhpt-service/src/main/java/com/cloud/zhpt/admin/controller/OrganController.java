package com.cloud.zhpt.admin.controller;

import com.cloud.zhpt.common.controller.BaseController;
import com.cloud.zhpt.HttpResult;
import com.cloud.zhpt.admin.Service.OrganService;
import com.cloud.zhpt.admin.Service.UserService;
import com.cloud.zhpt.admin.entity.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机构 Controller
 *
 * @author sw
 * @ClassName: OrganController
 * @Description: 机构 Controller
 */
@RestController
@RequestMapping("/admin/organ")
public class OrganController extends BaseController {

    @Autowired
    OrganService organService;

    @Autowired
    UserService userService;

    /**
     * 查询机构列表
     */
    /* @RequiresPermissions("admin:organ:manage")*/
    @PostMapping("/listOrgan")
    public HttpResult listOrgan() {
        List<Organ> listOrgan = organService.listOrgan();
        return new HttpResult(HttpResult.SUCCESS, listOrgan);
    }


    /**
     * 添加机构
     *
     * @param organ
     * @return HttpResult
     */

    /* @RequiresPermissions("admin:organ:manage")*/
    @PostMapping(value = "/insertOrgan")
    public HttpResult insertOrgan(Organ organ) {
        organService.insertOrgan(organ);
        return new HttpResult(HttpResult.SUCCESS, "添加成功");
    }


    /**
     * 修改机构信息
     *
     * @param organ
     * @return HttpResult
     */

    /*  @RequiresPermissions("admin:organ:manage")*/
    @PostMapping(value = "/updateOrgan")
    public HttpResult updateOrgan(Organ organ) {
        organService.updateOrgan(organ);
        return new HttpResult(HttpResult.SUCCESS, "修改成功");
    }

    /**
     * 根据id删除机构
     *
     * @param id
     * @return HttpResult
     */
    @PostMapping("/deleteOrgan")
    public HttpResult deleteOrgan(Integer id) {
        Integer userCount = userService.getUserCountByOrganId(id);
        if (userCount.intValue() > 0) {
            return new HttpResult(HttpResult.FAILED, "该机构下存在人员，删除失败！");
        } else {
            organService.deleteOrgan(id);
            return new HttpResult(HttpResult.SUCCESS, "删除成功");
        }
    }

}
