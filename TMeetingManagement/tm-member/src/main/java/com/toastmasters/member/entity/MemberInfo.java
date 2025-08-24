package com.toastmasters.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 * 会员信息实体类
 * </p>
 *
 * @author seekpan
 */
@NoArgsConstructor
@Entity
@Table(name = "member_info")
@AllArgsConstructor
@Data
public class MemberInfo {

    /**
     * 会员ID
     */
    @Id
    private String memberId;

    /**
     * 中文用户名
     */
    @Column(name = "cnName", nullable = false)
    private String cnName;
    /**
     * 英文用户名
     */
    @Column(name = "enName", nullable = false)
    private String enName;

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
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * 创建人ID
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
