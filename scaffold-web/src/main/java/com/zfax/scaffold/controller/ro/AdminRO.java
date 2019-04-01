package com.zfax.scaffold.controller.ro;

import com.zfax.starter.web.validation.ChineseName;
import com.zfax.starter.web.validation.Email;
import com.zfax.starter.web.validation.Mobile;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 17:18
 * @Modified By:
 */
@Data
public class AdminRO {

    private Long id;
    @NotNull
    private String password;
    @NotNull
    @ChineseName
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Mobile
    private String phone;
    @Size(max = 250, message = "组织名长度范围【250】")
    private String description;
    private String status;


}
