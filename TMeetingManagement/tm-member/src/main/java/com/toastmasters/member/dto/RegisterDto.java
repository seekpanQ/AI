package com.toastmasters.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * <p>
 * 会员注册请求参数
 * </p>
 *
 * @author seekpan
 */
@Data
@Schema(description = "会员注册请求参数对象")
public class RegisterDto {
    /**
     * 会员ID
     */
    @NotBlank(message = "会员ID不能为空")
    @Size(min = 3, max = 3, message = "会员ID长度必须是3")
    @Schema(description = "会员ID（必填）", example = "001", required = true)
    private String memberId;

    /**
     * 中文用户名
     */
    @NotBlank(message = "中文用户名不能为空")
    @Size(min = 2, max = 50, message = "中文用户名长度应在2到50之间")
    @Schema(description = "中文用户名（必填）", example = "张三", required = true)
    private String cnName;
    /**
     * 英文用户名
     */
    @NotBlank(message = "英文用户名不能为空")
    @Size(min = 2, max = 50, message = "英文用户名长度应在2到50之间")
    @Schema(description = "英文用户名（必填）", example = "Tom", required = true)
    private String enName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 50, message = "密码长度应在6到50之间")
    @Schema(description = "密码（必填）", example = "111111", required = true)
    private String password;

    /**
     * 邮箱
     */
    @Email
    @Size(min = 6, max = 100, message = "邮箱长度应在6到100之间")
    @Schema(description = "邮箱", example = "zhangsan@163.com")
    private String email;

    /**
     * 手机号码
     */
    @Size(min = 11, max = 11, message = "手机号码长度必须是11")
    @Schema(description = "手机号码", example = "18588889999")
    private String phone;

    /**
     * 真实姓名
     */
    @Size(max = 50, message = "真实姓名最大长度50")
    @Schema(description = "真实姓名", example = "张三")
    private String realName;
    /**
     * 头像地址
     */
    @Size(max = 255, message = "头像地址最大长度255")
    @Schema(description = "头像地址", example = "https://toastmasters.com/myselfie.png")
    private String avatarUrl;
}