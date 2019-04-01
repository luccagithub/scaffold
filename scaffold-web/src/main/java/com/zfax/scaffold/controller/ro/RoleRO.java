package com.zfax.scaffold.controller.ro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 15:52
 * @Modified By:
 */
@Data
public class RoleRO {

    private Long id;
    @NotBlank(message = "name参数不能为空!")
    @Size(min = 2, max = 30, message = "组织名长度范围【2,30】")
    private String name;
    @Size(max = 250, message = "组织名长度范围【250】")
    private String description;
    @NotBlank(message = "status参数不能为空!")
    private String status;

}
