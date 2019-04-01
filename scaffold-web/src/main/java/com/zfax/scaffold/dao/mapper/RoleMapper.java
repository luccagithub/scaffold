package com.zfax.scaffold.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfax.scaffold.dao.model.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p> 角色表 Mapper 接口 </p>
 *
 * @author Bron
 * @since 2018-06-22
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectBySystemIdAndAdminId(Page page, @Param("systemId") Long systemId,
            @Param("opAdminId") Long opAdminId);
}
