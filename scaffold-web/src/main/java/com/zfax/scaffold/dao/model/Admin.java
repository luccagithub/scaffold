package com.zfax.scaffold.dao.model;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p> 用户表 </p>
 *
 * @author Bron
 * @since 2018-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 密码上次更新时间
     */
    @TableField("password_update_at")
    private Date passwordUpdateAt;
    /**
     * 名字
     */
    @TableField(value="name",strategy = FieldStrategy.NOT_EMPTY)
    private String name;
    /**
     * 企业邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 联系方式
     */
    @TableField("phone")
    private String phone;
    /**
     * 修改时间
     */
    @TableField("update_at")
    private Date updateAt;
    /**
     * 创建时间
     */
    @TableField("create_at")
    private Date createAt;
    /**
     * 创建者
     */
    @TableField("create_by")
    private Long createBy;
    /**
     * 修改者
     */
    @TableField("update_by")
    private Long updateBy;
    /**
     * 状态，locked，normal，useless
     */
    @TableField("status")
    private String status;
    /**
     * 登录失败次数
     */
    @TableField("login_failed_times")
    private Date loginFailedTimes;
    /**
     * 描述信息
     */
    @TableField("desription")
    private String desription;


    public static final String ID = "id";

    public static final String PASSWORD = "password";

    public static final String PASSWORD_UPDATE_AT = "password_update_at";

    public static final String NAME = "name";

    public static final String EMAIL = "email";

    public static final String PHONE = "phone";

    public static final String UPDATE_AT = "update_at";

    public static final String CREATE_AT = "create_at";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_BY = "update_by";

    public static final String STATUS = "status";

    public static final String LOGIN_FAILED_TIMES = "login_failed_times";

    public static final String DESRIPTION = "desription";

}
