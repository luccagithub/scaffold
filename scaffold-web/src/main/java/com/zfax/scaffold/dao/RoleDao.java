package com.zfax.scaffold.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfax.scaffold.dao.mapper.RoleMapper;
import com.zfax.scaffold.dao.model.Role;
import com.zfax.starter.mybatis.dao.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 15:44
 * @Modified By:
 */
@Repository
public class RoleDao extends BaseDao<RoleMapper, Role> {

    public List<Role> selectAll(Page page, Long systemId, Long opAdminId) {
        return baseMapper.selectBySystemIdAndAdminId(page, systemId, opAdminId);
    }

    public Role selectRoleById(Long id) {
        return baseMapper.selectById(id);
    }

    public Integer deleteById(Long id) {
        return baseMapper.deleteById(id);
    }

    public List<Role> selectByName(String name) {
        return baseMapper.selectList(new QueryWrapper<>(new Role().setName(name)));
    }

}
