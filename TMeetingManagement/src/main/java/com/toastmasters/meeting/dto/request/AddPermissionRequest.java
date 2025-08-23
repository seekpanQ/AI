package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 *   新增权限请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class AddPermissionRequest {
    
    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不能为空")
    private String permissionName;
    
    /**
     * 权限编码
     */
    @NotBlank(message = "权限编码不能为空")
    private String permissionCode;
    
    /**
     * 权限描述
     */
    private String description;
}