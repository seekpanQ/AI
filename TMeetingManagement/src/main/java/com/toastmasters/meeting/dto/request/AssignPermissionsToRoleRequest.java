package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/**
 * <p>
 *   为角色分配权限请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class AssignPermissionsToRoleRequest {
    
    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
    
    /**
     * 权限ID集合
     */
    @NotEmpty(message = "权限ID列表不能为空")
    private List<Long> permissionIds;
}