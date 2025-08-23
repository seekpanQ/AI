package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   查询角色的权限请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class GetRolePermissionRequest {
    
    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
}