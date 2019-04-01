package com.zfax.scaffold.dao.model.po;

import com.zfax.scaffold.dao.model.Admin;
import com.zfax.scaffold.dao.model.Role;
import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: Born
 * @Create: 2018-09-14 09:46
 **/
@Data
public class AdminRolePO {

    private Admin admin;

    private List<Role> roles;

}
