package com.toastmasters.meeting.dto.response;

import lombok.Data;

/**
 * <p>
 *   权限响应数据对象
 * </p>
 * @author seekpan
 */
@Data
public class PermissionResponse {
    
    /**
     * 权限ID
     */
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