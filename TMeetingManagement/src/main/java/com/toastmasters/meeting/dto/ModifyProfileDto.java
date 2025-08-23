package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   修改个人信息请求参数
 * </p>
 * @author seekpan
 */
@Data
public class ModifyProfileDto {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像地址
     */
    private String avatarUrl;
}