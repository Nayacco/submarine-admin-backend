package org.javahub.submarine.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.javahub.submarine.common.base.BaseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Permission extends BaseEntity {

    /**
     * 名称（中文）
     */
    private String name;


    /**
     * 权限值
     */
    private String value;

    /**
     * 父级id
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long pid;

    /**
     * 父级ids
     */
    private String pids;

    /**
     * 子节点
     */
    @TableField(exist=false)
    private List<Permission> children;

}
