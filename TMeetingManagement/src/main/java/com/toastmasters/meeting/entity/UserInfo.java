package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   用户信息实体类
 * </p>
 * @author seekpan
 */
@NoArgsConstructor
@Entity
@Table(name = "user_info")
@AllArgsConstructor
@Data
public class UserInfo {

    /**
     * 用户唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * 用户密码（加密后）
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 账户状态：1-正常，0-禁用
     */
    @Column(name = "status", columnDefinition = "TINYINT DEFAULT 1")
    private Integer status;

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
