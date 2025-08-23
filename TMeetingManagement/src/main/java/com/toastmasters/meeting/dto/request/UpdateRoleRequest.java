package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   修改角色请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class UpdateRoleRequest {
    
    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
    
    /**
     * 角色名称
     */
    private String roleName;
    
    /**
     * 角色描述
     */
    private String description;
}