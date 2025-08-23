package com.toastmasters.meeting.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/**
 * <p>
 *   分配角色给用户请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class AssignRolesToUserRequest {
    
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    
    /**
     * 角色ID集合
     */
    @NotEmpty(message = "角色ID列表不能为空")
    private List<Long> roleIds;
}