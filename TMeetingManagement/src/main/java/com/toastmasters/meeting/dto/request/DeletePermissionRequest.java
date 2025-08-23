package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   删除权限请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class DeletePermissionRequest {
    
    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空")
    private Long permissionId;
}