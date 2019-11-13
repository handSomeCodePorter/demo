package com.cloud.zhpt.admin.Service;

import com.cloud.zhpt.Const.DeletedState;
import com.cloud.zhpt.Utils.PinyinToolkit;
import com.cloud.zhpt.admin.dao.OrganDao;
import com.cloud.zhpt.admin.entity.Organ;
import com.cloud.zhpt.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 机构 Service
 *
 * @author sw
 * @ClassName: OrganService
 * @Description: 机构 Service
 */
@Service
public class OrganService {

    @Autowired
    OrganDao organDao;

    /**
     * 查询机构列表
     *
     * @return List<Organ>
     */
    public List<Organ> listOrgan() {
        return organDao.listOrgan();
    }

    /**
     * 根据id查询机构信息
     *
     * @param id
     * @return Organ
     */
    public Organ getOrganById(Integer id) {
        return organDao.getOrganById(id);
    }

    /**
     * 根据用户登录账号查询其机构信息
     *
     * @param loginName
     * @return Organ
     */
    public Organ getOrganByUserLoginName(String loginName) {
        return organDao.getOrganByUserLoginName(loginName);
    }

    /**
     * 批量查询所有子机构（包括本身机构）
     *
     * @param organId
     * @return List<Organ>
     */
    public List<Organ> listOrganByParentId(Integer organId) {
        return organDao.listOrganByParentId(organId);
    }

    /**
     * 添加机构信息
     *
     * @param organ
     */
    @CacheEvict(value = "organCache", allEntries = true)
    public void insertOrgan(Organ organ) {
        // 设置全拼
        organ.setSpellFull(PinyinToolkit.cn2Spell(organ.getName()));
        // 设置首字母
        organ.setSpellFirst(PinyinToolkit.cn2FirstSpell(organ.getName()));
        organDao.insertSelective(organ);
    }

    /**
     * 修改机构信息
     *
     * @param organ
     */
    @CacheEvict(value = "organCache", allEntries = true)
    public void updateOrgan(Organ organ) {
        // 设置全拼
        organ.setSpellFull(PinyinToolkit.cn2Spell(organ.getName()));
        // 设置首字母
        organ.setSpellFirst(PinyinToolkit.cn2FirstSpell(organ.getName()));
        organDao.updateByPrimaryKeySelective(organ);
        // 设置下级机构的可用状态
        List<Organ> listChildrenOrgan = organDao.listOrganByParentId(organ.getId());
        if (listChildrenOrgan != null && listChildrenOrgan.size() > 0) {
            Integer[] ids = new Integer[listChildrenOrgan.size()];
            for (int i = 0; i < listChildrenOrgan.size(); i++) {
                ids[i] = listChildrenOrgan.get(i).getId();
            }
            organDao.updateUseableBatch(ids, organ.getUseable());
        }
    }

    /**
     * 根据id删除机构
     *
     * @param id
     */
/*    @CacheEvict(value = "organCache", allEntries = true)
    public void deleteOrgan(Integer id) {
        organDao.deleteByPrimaryKey(id);
    }*/

    /**
     * 根据id删除机构
     *
     * @param id
     */
    @CacheEvict(value = "organCache", allEntries = true)
    public void deleteOrgan(Integer id) {
        organDao.updateOrganDeletedById(id, DeletedState.DELETED);
    }

    /**
     * 查询指定父节点下机构排序最大值
     *
     * @param level
     * @param parentId
     * @return Integer
     */
    public Integer getMaxSort(Integer level, Integer parentId) {
        return organDao.getMaxSort(level, parentId);
    }

    /**
     * 查询可用的机构列表
     *
     * @return List<Organ>
     */
    @Cacheable(value = "organCache", key = "'list_useable_organ'")
    public List<Organ> listUseableOrgan() {
        return organDao.listUseableOrgan();
    }

    /**
     * 查询可用的机构列表（查询指定机构ID下面的机构）
     *
     * @param rootOrganId
     * @return List<Organ>
     */
    @Cacheable(value = "organCache", key = "'list_useable_organ_by_root_id'")
    public List<Organ> listUseableOrganByRootId(Integer rootOrganId) {
        return organDao.listUseableOrganByRootId(rootOrganId);
    }

    /**
     * 查询可用的父级机构列表
     *
     * @return List<Organ>
     */
    @Cacheable(value = "organCache", key = "'list_useable_root_organ'")
    public List<Organ> listUseableRootOrgan() {
        return organDao.listUseableRootOrgan();
    }

    /**
     * 获取机构分管领导
     *
     * @param organId
     * @return User
     */
    public User getMainDirectorUser(Integer organId) {
        return organDao.getMainDirectorUser(organId);
    }

    /**
     * 获取机构负责人
     *
     * @param organRootId
     * @return User
     */
    public User getManagerUser(Integer organRootId) {
        return organDao.getManagerUser(organRootId);
    }

    /**
     * 根据id查询机构类别
     *
     * @param id
     * @return String
     */
    public String getOrganTypeById(Integer id) {
        return organDao.getOrganTypeById(id);
    }

    /**
     * 查询纳入廉政教育的机构（一级部门单位）
     *
     * @return List<Organ>
     */
    public List<Organ> listOrganInEdu() {
        return organDao.listOrganInEdu();
    }

    /**
     * 查询纳入廉政教育的机构（一级部门单位排除集团领导、外部单位）
     *
     * @return List<Organ>
     */
    public List<Organ> listOrganInEduFiltrate() {
        return organDao.listOrganInEduFiltrate();
    }

    /**
     * 查询纳入廉政教育的机构（分公司子部门）
     *
     * @return List<Organ>
     */
    public List<Organ> listSubOrganInEdu() {
        return organDao.listSubOrganInEdu();
    }

    /**
     * 根据用户id查询负责部门
     *
     * @param userId
     * @return List<Organ>
     */
    public List<Organ> listManagerOrganByUserId(Integer userId) {
        return organDao.listManagerOrganByUserId(userId);
    }

    /**
     * 根据用户id查询分管部门列表
     *
     * @param userId
     * @return List<Organ>
     */
    public List<Organ> listAppointedOrganByUserId(Integer userId) {
        return organDao.listAppointedOrganByUserId(userId);
    }

    /**
     * 查询一级部门列表
     *
     * @return List<Organ>
     */
    public List<Organ> listRootOrgan() {
        return organDao.listRootOrgan();
    }

    /**
     * 根据机构id查询直属子机构集合
     *
     * @param organId
     * @return List<Organ>
     */
    public List<Organ> listChildOrganByOrganId(Integer organId) {
        return organDao.listChildOrganByOrganId(organId);
    }

    /**
     * 根据机构id查询直属子机构集合（参与廉政教育的子机构）
     *
     * @param organId
     * @return List<Organ>
     */
    public List<Organ> listChildOrganInEduByOrganId(Integer organId) {
        return organDao.listChildOrganInEduByOrganId(organId);
    }

    /**
     * 根据机构名称和父级机构名称查询机构信息（用于导入用户）
     *
     * @param name
     * @param parentName
     * @return Organ
     */
    public Organ getOrganByNameAndParentName(String name, String parentName) {
        return organDao.getOrganByNameAndParentName(name, parentName);
    }

    /**
     * 根据机构名称查询一级部门机构id（用于导入用户）
     *
     * @param name
     * @return Integer
     */
    public Integer getOrganIdByOrganName(String name) {
        return organDao.getOrganIdByOrganName(name);
    }

    /**
     * 删除用户时，根据用户id清空用户所负责部门的部门负责人
     *
     * @param userId
     */
    public void updateOrganManager(Integer userId) {
        organDao.updateOrganManager(userId);
    }

    /**
     * 删除用户时，根据用户id清空用户所分管部门的分管领导
     *
     * @param userId
     */
    public void updateOrganMainDirector(Integer userId) {
        organDao.updateOrganMainDirector(userId);
    }

    /**
     * 删除用户时，根据用户id清空用户所属机构的联络员
     *
     * @param userId
     */
    public void updateOrganLiaison(Integer userId) {
        organDao.updateOrganLiaison(userId);
    }

    /**
     * 根据部门名称递归查找部门列表
     *
     * @param organName
     * @return List<Organ>
     */
    public List<Organ> listOrganByName(String organName) {
        return organDao.listOrganByName(organName);
    }

    /**
     * 根据分管领导ID查询部门ID列表
     *
     * @param mainDirectorId
     * @return List<Integer>
     */
    public List<Integer> listOrganIdByMainDirectorId(Integer mainDirectorId) {
        return organDao.listOrganIdByMainDirectorId(mainDirectorId);
    }

    /**
     * 根据机构编码查询机构
     *
     * @param code
     * @return
     */
    public Organ getOrganByCode(String code) {
        return organDao.getOrganByCode(code);
    }

    /*
     * 根据主键id动态修改部门信息
     *
     * @param organ
     * @return Integer
     */
    public Integer updateByPrimaryKeySelective(Organ organ) {
        return organDao.updateByPrimaryKeySelective(organ);
    }

    /*
     * 根据hr系统中的公司（部门）编码查询机构信息
     *
     * @param hrNo
     * @return com.westar.dzjc.admin.entity.Organ
     */
    public Organ getOrganByHrNo(String hrNo) {
        return organDao.getOrganByHrNo(hrNo);
    }

    /*
     * 动态添加部门数据
     *
     * @param organ
     * @return Integer
     */
    public Integer insertSelective(Organ organ) {
        return organDao.insertSelective(organ);
    }

    /*
     * 禁用所有机构
     *
     * @return void
     */
    public void disableAllOrgan() {
        organDao.disableAllOrgan();
    }
}
