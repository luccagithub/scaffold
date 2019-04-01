package com.zfax.scaffold.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfax.scaffold.dao.mapper.AdminMapper;
import com.zfax.scaffold.dao.model.Admin;
import com.zfax.starter.mybatis.dao.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * @description:
 * @author: Born
 * @create: 2018-06-21 18:21
 **/
@Repository
public class AdminDao extends BaseDao<AdminMapper, Admin> {

    public List<Admin> selectByOrganizationIds(List<Long> organizationIds, Page page) {
        return baseMapper.selectByOrganizationIds(organizationIds, page);
    }

    /**
     * 通过id查询用户
     */
    public Admin selectById(Long id) {
        return baseMapper.selectById(id);
    }

    public Integer deleteById(Long id) {
        return baseMapper.deleteById(id);
    }

    /**
     * 通过名字查询用户
     */
    public List<Admin> selectByName(String name) {
        return baseMapper.selectList(new QueryWrapper<>(new Admin().setName(name)));
    }

    public List<Admin> selectByPhone(String phone) {
        return baseMapper.selectList(new QueryWrapper<>(new Admin().setPhone(phone)));
    }

    public List<Admin> selectByEmail(String email) {
        return baseMapper.selectList(new QueryWrapper<>(new Admin().setEmail(email)));
    }

    public IPage<Admin> selectAll(Page page) {
        return baseMapper.selectPage(page, new QueryWrapper<Admin>().orderByDesc(Admin.CREATE_AT));
    }

    public List<Admin> selectByAdminIds(List<Long> ids) {
        return baseMapper.selectList(new QueryWrapper<Admin>().in(Admin.ID, ids));
    }

    public Admin selectByUsername(String username) {
        List<Admin> admins = baseMapper.selectList(new QueryWrapper<Admin>().eq(Admin.PHONE, username).or()
                .eq(Admin.EMAIL, username));
        if (CollectionUtils.isEmpty(admins)) {
            return null;
        }
        return admins.get(0);
    }

    public List<Admin> selectByNames(List<String> names) {
        return baseMapper.selectList(new QueryWrapper<Admin>().in(Admin.NAME, names));
    }

    public List<Admin> selectByAdmin(Admin admin) {
        return baseMapper.selectList(new QueryWrapper<>(admin));
    }
}
