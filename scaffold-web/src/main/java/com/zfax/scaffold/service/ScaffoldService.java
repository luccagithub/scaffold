package com.zfax.scaffold.service;

import com.zfax.scaffold.dao.AdminDao;
import com.zfax.scaffold.dao.model.Admin;
import com.zfax.scaffold.service.bo.AdminBO;
import com.zfax.scaffold.transfer.AdminTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Born
 * @create: 2018/6/13
 **/
@Service
public class ScaffoldService {

    @Autowired
    private AdminDao adminDao;

    /**
     * 查询user信息
     */
    @Transactional
    public AdminBO selectByAdminId(Long id) {
        Admin admin = adminDao.selectById(id);
        return AdminTransfer.INSTANCE.mapModelToBO(admin);
    }

    /**
     * 查询user信息
     */
    @Transactional
    public AdminBO selectByName(String name) {
        Admin admins = adminDao.selectByUsername(name);
        return AdminTransfer.INSTANCE.mapModelToBO(admins);
    }


}
