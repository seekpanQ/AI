package com.toastmasters.meeting.dto.response;

import lombok.Data;

/**
 * <p>
 *   角色响应数据对象
 * </p>
 * @author seekpan
 */
@Data
public class RoleResponse {
    
    /**
     * 角色ID
     */
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