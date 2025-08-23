package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   查询用户详情请求参数
 * </p>
 * @author seekpan
 */
@Data
public class QueryUserDto {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;
}