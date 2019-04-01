package com.zfax.scaffold.service.bo;

import java.util.Date;
import lombok.Data;

/**
 * @Autohor: scorpio
 * @Description:
 * @Date: Created in 2018/6/23 0023 下午 17:18
 * @Modified By:
 */
@Data
public class AdminBO {

    private Long id;
    /**
     * 密码
     */

    private String password;
    /**
     * 密码上次更新时间
     */

    private Date passwordUpdateAt;
    /**
     * 名字
     */

    private String name;
    /**
     * 企业邮箱
     */

    private String email;
    /**
     * 联系方式
     */

    private String phone;
    /**
     * 修改时间
     */

    private Date updateAt;
    /**
     * 创建时间
     */

    private Date createAt;
    /**
     * 创建者
     */

    private Long createBy;
    /**
     * 修改者
     */

    private Long updateBy;
    /**
     * 状态，locked，normal，useless
     */

    private String status;

    /**
     * 登录失败次数
     */

    private Date loginFailedTimes;

    private String description;
}
