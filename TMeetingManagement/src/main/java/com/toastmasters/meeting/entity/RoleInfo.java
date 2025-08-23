package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   角色信息实体类
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role_info")
public class RoleInfo {

    /**
     * 角色唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    /**
     * 角色描述
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