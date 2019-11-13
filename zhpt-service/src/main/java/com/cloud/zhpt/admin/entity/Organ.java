package com.cloud.zhpt.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构 sys_organ
 *
 * @author
 * @date 2017-05-03 19:20:08
 */
public class Organ implements Serializable {

    private static final long serialVersionUID = -7285756068073479099L;

    /**
     * ID
     * sys_organ.id
     */
    private Integer id;

    /**
     * 机构名称
     * sys_organ.name
     */
    private String name;

    /**
     * 机构编码
     * sys_organ.code
     */
    private String code;

    /**
     * 机构类型
     * sys_organ.type
     */
    private String type;

    /**
     * 分管领导ID
     * sys_organ.main_director_id
     */
    private Integer mainDirectorId;

    /**
     * 机构负责人
     * sys_organ.manager_id
     */
    private Integer managerId;

    /**
     * 机构联络员
     * sys_organ.liaison_id
     */
    private Integer liaisonId;

    /**
     * 负责人
     * sys_organ.director
     */
    private String director;

    /**
     * 负责人电话
     * sys_organ.director_phone
     */
    private String directorPhone;

    /**
     * 备注说明
     * sys_organ.remark
     */
    private String remark;

    /**
     * 排序
     * sys_organ.sort
     */
    private Integer sort;

    /**
     * 拼音首字母
     * sys_organ.spell_first
     */
    private String spellFirst;

    /**
     * 拼音全拼
     * sys_organ.spell_full
     */
    private String spellFull;

    /**
     * 是否可用
     * sys_organ.useable
     */
    private Integer useable;

    /**
     * 是否纳入廉政教育
     * sys_organ.educable
     */
    private Integer educable;

    /**
     * 创建时间
     * sys_organ.create_time
     */
    private Date createTime;

    /**
     * 最后修改时间
     * sys_organ.modify_time
     */
    private Date modifyTime;

    /**
     * 区域ID
     * sys_organ.area_id
     */
    private Integer areaId;

    /**
     * 父级ID
     * sys_organ.parent_id
     */
    private Integer parentId;

    /**
     * 是否已删除
     * sys_organ.deleted
     */
    private Integer deleted;

    /**
     * hr系统编码
     * sys_organ.hr_no
     */
    private String hrNo;
    /*********************** 以下是自己添加字段 start ****************************/

    /**
     * 机构层级
     */
    private Integer organLevel;

    /**
     * 是否是叶子节点
     */
    private Integer leaf;

    /**
     * 机构路径全称
     */
    private String pathName;

    /**
     * 机构所在根节点id
     */
    private Integer rootId;

    /**
     * 机构所在根节点名称
     */
    private String rootName;

    /**
     * 父级机构名称
     */
    private String parentName;

    /**
     * 所属区域名
     */
    private String areaName;

    /**
     * 分管领导名称
     */
    private String mainDirectorName;

    /**
     * 机构负责人名称
     */
    private String managerName;

    /**
     * 机构联络员名称
     */
    private String liaisonName;

    /**
     * 机构联络员登录账号
     */
    private String liaisonLoginName;

    /**
     * 部门总人数
     */
    private Integer personTotalCount;

    /**
     * 纳入廉政教育人数
     */
    private Integer personEduScopeCount;

    /*********************** 以上是自己添加字段 end ****************************/

    /**
     * ID
     * sys_organ.id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * sys_organ.id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 机构名称
     * sys_organ.name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称
     * sys_organ.name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 机构编码
     * sys_organ.code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 机构编码
     * sys_organ.code
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 机构类型
     * sys_organ.type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 机构类型
     * sys_organ.type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 分管领导ID
     * sys_organ.main_director_id
     *
     * @return mainDirectorId
     */
    public Integer getMainDirectorId() {
        return mainDirectorId;
    }

    /**
     * 分管领导ID
     * sys_organ.main_director_id
     *
     * @param mainDirectorId
     */
    public void setMainDirectorId(Integer mainDirectorId) {
        this.mainDirectorId = mainDirectorId;
    }

    /**
     * 机构负责人
     * sys_organ.manager_id
     *
     * @return managerId
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * 机构负责人
     * sys_organ.manager_id
     *
     * @param managerId
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * 机构联络员
     * sys_organ.liaison_id
     *
     * @return liaisonId
     */
    public Integer getLiaisonId() {
        return liaisonId;
    }

    /**
     * 机构联络员
     * sys_organ.liaison_id
     *
     * @param liaisonId
     */
    public void setLiaisonId(Integer liaisonId) {
        this.liaisonId = liaisonId;
    }

    /**
     * 负责人
     * sys_organ.director
     *
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 负责人
     * sys_organ.director
     *
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 负责人电话
     * sys_organ.director_phone
     *
     * @return directorPhone
     */
    public String getDirectorPhone() {
        return directorPhone;
    }

    /**
     * 负责人电话
     * sys_organ.director_phone
     *
     * @param directorPhone
     */
    public void setDirectorPhone(String directorPhone) {
        this.directorPhone = directorPhone;
    }

    /**
     * 备注说明
     * sys_organ.remark
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注说明
     * sys_organ.remark
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 排序
     * sys_organ.sort
     *
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * sys_organ.sort
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 拼音首字母
     * sys_organ.spell_first
     *
     * @return spellFirst
     */
    public String getSpellFirst() {
        return spellFirst;
    }

    /**
     * 拼音首字母
     * sys_organ.spell_first
     *
     * @param spellFirst
     */
    public void setSpellFirst(String spellFirst) {
        this.spellFirst = spellFirst;
    }

    /**
     * 拼音全拼
     * sys_organ.spell_full
     *
     * @return spellFull
     */
    public String getSpellFull() {
        return spellFull;
    }

    /**
     * 拼音全拼
     * sys_organ.spell_full
     *
     * @param spellFull
     */
    public void setSpellFull(String spellFull) {
        this.spellFull = spellFull;
    }

    /**
     * 是否可用
     * sys_organ.useable
     *
     * @return useable
     */
    public Integer getUseable() {
        return useable;
    }

    /**
     * 是否可用
     * sys_organ.useable
     *
     * @param useable
     */
    public void setUseable(Integer useable) {
        this.useable = useable;
    }

    /**
     * 是否纳入廉政教育
     * sys_organ.educable
     *
     * @return educable
     */
    public Integer getEducable() {
        return educable;
    }

    /**
     * 是否纳入廉政教育
     * sys_organ.educable
     *
     * @param educable
     */
    public void setEducable(Integer educable) {
        this.educable = educable;
    }

    /**
     * 创建时间
     * sys_organ.create_time
     *
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * sys_organ.create_time
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * sys_organ.modify_time
     *
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 最后修改时间
     * sys_organ.modify_time
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 区域ID
     * sys_organ.area_id
     *
     * @return areaId
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 区域ID
     * sys_organ.area_id
     *
     * @param areaId
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 父级ID
     * sys_organ.parent_id
     *
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级ID
     * sys_organ.parent_id
     *
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 是否已删除
     * sys_organ.deleted
     *
     * @return deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 是否已删除
     * sys_organ.deleted
     *
     * @param deleted
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * hr系统编码
     * sys_organ.hr_no
     *
     * @return hrNo
     */
    public String getHrNo() {
        return hrNo;
    }

    /**
     * hr系统编码
     * sys_organ.hr_no
     *
     * @param hrNo
     */
    public void setHrNo(String hrNo) {
        this.hrNo = hrNo;
    }

    public Integer getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(Integer organLevel) {
        this.organLevel = organLevel;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getMainDirectorName() {
        return mainDirectorName;
    }

    public void setMainDirectorName(String mainDirectorName) {
        this.mainDirectorName = mainDirectorName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLiaisonName() {
        return liaisonName;
    }

    public void setLiaisonName(String liaisonName) {
        this.liaisonName = liaisonName;
    }

    public String getLiaisonLoginName() {
        return liaisonLoginName;
    }

    public void setLiaisonLoginName(String liaisonLoginName) {
        this.liaisonLoginName = liaisonLoginName;
    }

    public Integer getPersonTotalCount() {
        return personTotalCount;
    }

    public void setPersonTotalCount(Integer personTotalCount) {
        this.personTotalCount = personTotalCount;
    }

    public Integer getPersonEduScopeCount() {
        return personEduScopeCount;
    }

    public void setPersonEduScopeCount(Integer personEduScopeCount) {
        this.personEduScopeCount = personEduScopeCount;
    }

    @Override
    public String toString() {
        return "Organ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", mainDirectorId=" + mainDirectorId +
                ", managerId=" + managerId +
                ", liaisonId=" + liaisonId +
                ", director='" + director + '\'' +
                ", directorPhone='" + directorPhone + '\'' +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                ", spellFirst='" + spellFirst + '\'' +
                ", spellFull='" + spellFull + '\'' +
                ", useable=" + useable +
                ", educable=" + educable +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", areaId=" + areaId +
                ", parentId=" + parentId +
                ", deleted=" + deleted +
                ", hrNo='" + hrNo + '\'' +
                ", organLevel=" + organLevel +
                ", leaf=" + leaf +
                ", pathName='" + pathName + '\'' +
                ", rootId=" + rootId +
                ", rootName='" + rootName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", mainDirectorName='" + mainDirectorName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", liaisonName='" + liaisonName + '\'' +
                ", liaisonLoginName='" + liaisonLoginName + '\'' +
                ", personTotalCount=" + personTotalCount +
                ", personEduScopeCount=" + personEduScopeCount +
                '}';
    }
}
