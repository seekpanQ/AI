package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   修改权限请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class UpdatePermissionRequest {
    
    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空")
    private Long permissionId;
    
    /**
     * 权限名称
     */
    private String permissionName;
    
    /**
     * 权限编码
     */
    private String permissionCode;
    
    /**
     * 权限描述
     */
    private String description;
}