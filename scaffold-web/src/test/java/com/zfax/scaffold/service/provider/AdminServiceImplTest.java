package com.zfax.scaffold.service.provider;

import com.alibaba.fastjson.JSON;
import com.zfax.scaffold.ApplicationContextTest;
import com.zfax.scaffold.api.dto.AdminDTO;
import com.zfax.scaffold.api.service.AdminService;
import com.zfax.scaffold.service.ScaffoldService;
import com.zfax.scaffold.service.bo.AdminBO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class AdminServiceImplTest  extends ApplicationContextTest{

    @Autowired
    private AdminService adminService;
    @Autowired
    private ScaffoldService scaffoldService;

    //@Test
    public void selectById() {
        //AdminBO adminBO = scaffoldService.selectByAdminId(1L);
        //System.out.println(JSON.toJSONString(adminBO));
    }
}
