package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 *   用户登录请求参数
 * </p>
 * @author seekpan
 */
@Data
public class LoginDto {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}