package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   角色权限关联关系实体类
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role_permission_relation")
public class RolePermissionRelation {

    /**
     * 关联关系唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;

    /**
     * 角色ID
     */
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    /**
     * 权限ID
     */
    @Column(name = "permission_id", nullable = false)
    private Long permissionId;

    /**
     * 创建人ID
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private java.time.LocalDateTime createTime;
}