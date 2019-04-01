package com.zfax.scaffold.transfer;

import com.zfax.scaffold.controller.ro.RoleRO;
import com.zfax.scaffold.controller.vo.RoleVO;
import com.zfax.scaffold.dao.model.Role;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 15:55
 * @Modified By:
 */
@Mapper
public interface RoleTransfer {

    RoleTransfer INSTANCE = Mappers.getMapper(RoleTransfer.class);

    Role mapROToModel(RoleRO RoleRO);

    List<RoleVO> mapModelToVO(List<Role> Roles);

    RoleVO mapModelToVO(Role role);

}
