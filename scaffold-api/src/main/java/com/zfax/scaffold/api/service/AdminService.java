
package com.zfax.scaffold.api.service;


import com.zfax.scaffold.api.dto.AdminDTO;
import java.util.List;

/**
 * 用户查询接口
 */
public interface AdminService {

    /**
     * 通过用户Id查询用户信息
     */
    AdminDTO selectById(Long id);

    /**
     * 保存用户信息接口
     */
    long insert(AdminDTO userDTO);

    /**
     * 通过用户名查询用户信息
     */
    List<AdminDTO> selectByNames(List<String> names);

    List<AdminDTO> selectByAdmin(AdminDTO adminDTO);
}
