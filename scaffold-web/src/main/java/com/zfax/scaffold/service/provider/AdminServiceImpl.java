package com.zfax.scaffold.service.provider;

import com.zfax.core.exception.BusinessException;
import com.zfax.scaffold.api.dto.AdminDTO;
import com.zfax.scaffold.api.service.AdminService;
import com.zfax.scaffold.dao.AdminDao;
import com.zfax.scaffold.dao.model.Admin;
import com.zfax.scaffold.transfer.AdminTransfer;
import com.zfax.starter.dubbo.annotation.Provider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Born
 * @create: 2018/6/13
 **/
@Provider
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public AdminDTO selectById(Long id) {
        // 业务异常处理,比如用户重复
        if (id.longValue() == 1) {
            throw new BusinessException("messages.error", "hello");
        }
        Admin admin = adminDao.selectById(id);
        AdminDTO adminDTO = AdminTransfer.INSTANCE.mapModelToDTO(admin);
        return adminDTO;
    }

    @Override
    @Transactional
    public long insert(AdminDTO adminDTO) {
        Admin admin = AdminTransfer.INSTANCE.mapDTOToModel(adminDTO);
        adminDao.insert(admin);
        return admin.getId();
    }

    @Transactional
    @Override
    public List<AdminDTO> selectByNames(List<String> names) {
        List<Admin> admins = adminDao.selectByNames(names);
        return AdminTransfer.INSTANCE.mapModelToDTO(admins);
    }

    @Override
    public List<AdminDTO> selectByAdmin(AdminDTO adminDTO) {
        List<Admin> admins = adminDao.selectByAdmin(AdminTransfer.INSTANCE.mapDTOToModel(adminDTO));
        return AdminTransfer.INSTANCE.mapModelToDTO(admins);
    }
}
