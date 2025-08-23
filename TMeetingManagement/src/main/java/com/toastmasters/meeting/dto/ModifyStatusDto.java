package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   修改用户状态请求参数
 * </p>
 * @author seekpan
 */
@Data
public class ModifyStatusDto {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 账户状态：1-正常，0-禁用
     */
    @NotNull(message = "账户状态不能为空")
    private Integer status;
}