package com.zfax.scaffold.transfer;

import com.zfax.scaffold.api.dto.AdminDTO;
import com.zfax.scaffold.controller.ro.AdminRO;
import com.zfax.scaffold.controller.vo.AdminVO;
import com.zfax.scaffold.dao.model.Admin;
import com.zfax.scaffold.service.bo.AdminBO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 17:17
 * @Modified By:
 */
@Mapper
public interface AdminTransfer {

    AdminTransfer INSTANCE = Mappers.getMapper(AdminTransfer.class);

    Admin mapROToModel(AdminRO AdminRO);

    List<AdminVO> mapModelToVO(List<Admin> Admins);

    AdminBO mapROToBO(AdminRO adminRO);

    Admin mapBOToModel(AdminBO admin);

    AdminBO mapModelToBO(Admin admin);

    AdminDTO mapModelToDTO(Admin admin);

    Admin mapDTOToModel(AdminDTO adminDTO);

    List<AdminDTO> mapModelToDTO(List<Admin> admins);

    AdminVO mapDTOToVO(AdminDTO adminDTO);

    AdminDTO mapROToDTO(AdminRO adminRO);

    List<AdminVO> mapDTOToVO(List<AdminDTO> adminDTOs);
}
