package com.cloud.zhpt.admin.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户查询对象
 *
 * @author houxiaohong
 * @ClassName: UserQuery
 * @Description: TODO 用户查询对象
 */
public class UserQuery implements Serializable {

    private static final long serialVersionUID = -8658895598588763512L;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户所属机构id
     */
    private Integer organId;

    /**
     * 用户所属机构名称
     */
    private String organName;

    /**
     * 用户角色
     */
    private Integer roleId;

    /**
     * 是否纳入廉政教育
     */
    private Integer eduScope;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 机构查找范围列表
     */
    private Integer[] organIds;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getEduScope() {
        return eduScope;
    }

    public void setEduScope(Integer eduScope) {
        this.eduScope = eduScope;
    }

    public Integer[] getOrganIds() {
        return organIds;
    }

    public void setOrganIds(Integer[] organIds) {
        this.organIds = organIds;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "UserQuery [userName=" + userName + ", organId=" + organId + ", organName=" + organName + ", roleId="
                + roleId + ", eduScope=" + eduScope + ", organIds=" + Arrays.toString(organIds) + ",loginName=" + loginName + "]";
    }


}
