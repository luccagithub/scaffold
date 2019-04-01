package com.zfax.scaffold.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfax.scaffold.dao.model.Admin;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> 用户表 Mapper 接口 </p>
 *
 * @author Bron
 * @since 2018-06-22
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> selectByOrganizationIds(List<Long> organizationIds, Page page);
}
