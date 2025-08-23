package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 *   新增角色请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class AddRoleRequest {
    
    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;
    
    /**
     * 角色描述
     */
    private String description;
}