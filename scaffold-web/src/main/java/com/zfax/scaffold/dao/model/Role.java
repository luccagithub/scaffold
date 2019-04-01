package com.zfax.scaffold.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p> 角色表 </p>
 *
 * @author Bron
 * @since 2018-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    /**
     * 角色名称
     */
    @TableField("name")
    private String name;
    /**
     * 描述
     */
    @TableField("description")
    private String description;
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
     * 状态，locked，normal，useless
     */
    @TableField("status")
    private String status;
    @TableField("system_id")
    private Long systemId;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String CREATE_AT = "create_at";

    public static final String CREATE_BY = "create_by";

    public static final String STATUS = "status";

    public static final String SYSTEM_ID = "system_id";

}
