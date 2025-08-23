package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   权限信息实体类
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission_info")
public class PermissionInfo {

    /**
     * 权限唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    /**
     * 权限名称
     */
    @Column(name = "permission_name", nullable = false, unique = true)
    private String permissionName;

    /**
     * 权限编码
     */
    @Column(name = "permission_code", nullable = false, unique = true)
    private String permissionCode;

    /**
     * 权限描述
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

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

    /**
     * 修改人ID
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private java.time.LocalDateTime updateTime;
}