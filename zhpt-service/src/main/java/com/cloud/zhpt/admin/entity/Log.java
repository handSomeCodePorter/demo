package com.cloud.zhpt.admin.entity;

import org.springframework.data.annotation.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.util.HtmlUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志 sys_log
 *
 * @author
 * @date 2017-05-03 19:20:08
 */
/*@Document(collection = "sys_log")*/
public class Log implements Serializable {

    private static final long serialVersionUID = 7893556180590497327L;

    /**
     * ID sys_log.id
     */
    @Id
    private Integer id;

    /**
     * 操作描述 sys_log.description
     */
    private String description;

    /**
     * 操作用户 sys_log.user_name
     */
    private String userName;

    /**
     * 用户机构 sys_log.user_organ
     */
    private String userOrgan;

    /**
     * 操作时间 sys_log.operation_time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date operationTime;

    /**
     * 耗时（单位毫秒） sys_log.time_consuming
     */
    private Long timeConsuming;

    /**
     * URI sys_log.request_uri
     */
    private String requestUri;

    /**
     * 请求类型 sys_log.method
     */
    private String method;

    /**
     * 请求参数 sys_log.params
     */
    private String params;

    /**
     * IP地址 sys_log.remote_addr
     */
    private String remoteAddr;

    /**
     * 用户代理 sys_log.user_agent
     */
    private String userAgent;

    /**
     * 异常信息 sys_log.exception
     */
    private String exception;

    /**
     * 用户ID sys_log.user_id
     */
    private Integer userId;

    /**
     * 用户部门ID sys_log.user_organ_id
     */
    private Integer userOrganId;

    /**
     * 是否来自APP sys_log.from_app
     */
    private Integer fromApp;

    /**
     * 访客标识 sys_log.uvid
     */
    private String uvid;

    /**
     * 操作系统
     * sys_log.os_name
     */
    private String osName;

    /**
     * 浏览器
     * sys_log.browser_name
     */
    private String browserName;

    /**
     * 浏览器版本
     * sys_log.browser_version
     */
    private String browserVersion;

    /**
     * 操作日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    /**
     * ID sys_log.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID sys_log.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 操作描述 sys_log.description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 操作描述 sys_log.description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 操作用户 sys_log.user_name
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 操作用户 sys_log.user_name
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户机构 sys_log.user_organ
     *
     * @return userOrgan
     */
    public String getUserOrgan() {
        return userOrgan;
    }

    /**
     * 用户机构 sys_log.user_organ
     *
     * @param userOrgan
     */
    public void setUserOrgan(String userOrgan) {
        this.userOrgan = userOrgan;
    }

    /**
     * 操作时间 sys_log.operation_time
     *
     * @return operationTime
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 操作时间 sys_log.operation_time
     *
     * @param operationTime
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 耗时（单位毫秒） sys_log.time_consuming
     *
     * @return timeConsuming
     */
    public Long getTimeConsuming() {
        return timeConsuming;
    }

    /**
     * 耗时（单位毫秒） sys_log.time_consuming
     *
     * @param timeConsuming
     */
    public void setTimeConsuming(Long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    /**
     * URI sys_log.request_uri
     *
     * @return requestUri
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * URI sys_log.request_uri
     *
     * @param requestUri
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * 请求类型 sys_log.method
     *
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 请求类型 sys_log.method
     *
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 请求参数 sys_log.params
     *
     * @return params
     */
    public String getParams() {
        return params;
    }

    /**
     * 请求参数 sys_log.params
     *
     * @param params
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * IP地址 sys_log.remote_addr
     *
     * @return remoteAddr
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * IP地址 sys_log.remote_addr
     *
     * @param remoteAddr
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /**
     * 用户代理 sys_log.user_agent
     *
     * @return userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 用户代理 sys_log.user_agent
     *
     * @param userAgent
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * 异常信息 sys_log.exception
     *
     * @return exception
     */
    public String getException() {
        return HtmlUtils.htmlEscape(exception);
    }

    /**
     * 异常信息 sys_log.exception
     *
     * @param exception
     */
    public void setException(String exception) {
        this.exception = exception;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserOrganId() {
        return userOrganId;
    }

    public void setUserOrganId(Integer userOrganId) {
        this.userOrganId = userOrganId;
    }

    public Integer getFromApp() {
        return fromApp;
    }

    public void setFromApp(Integer fromApp) {
        this.fromApp = fromApp;
    }

    public String getUvid() {
        return uvid;
    }

    public void setUvid(String uvid) {
        this.uvid = uvid;
    }

    /**
     * 操作系统
     * sys_log.os_name
     *
     * @return osName
     */
    public String getOsName() {
        return osName;
    }

    /**
     * 操作系统
     * sys_log.os_name
     *
     * @param osName
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * 浏览器
     * sys_log.browser_name
     *
     * @return browserName
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * 浏览器
     * sys_log.browser_name
     *
     * @param browserName
     */
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    /**
     * 浏览器版本
     * sys_log.browser_version
     *
     * @return browserVersion
     */
    public String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * 浏览器版本
     * sys_log.browser_version
     *
     * @param browserVersion
     */
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", description=" + description + ", userName=" + userName + ", userOrgan=" + userOrgan
                + ", operationTime=" + operationTime + ", timeConsuming=" + timeConsuming + ", requestUri=" + requestUri
                + ", method=" + method + ", params=" + params + ", remoteAddr=" + remoteAddr + ", userAgent="
                + userAgent + ", exception=" + exception + ", userId=" + userId + ", userOrganId=" + userOrganId
                + ", fromApp=" + fromApp + ", uvid=" + uvid + ", osName=" + osName + ", browserName=" + browserName
                + ", browserVersion=" + browserVersion + ", date=" + date + "]";
    }
}
