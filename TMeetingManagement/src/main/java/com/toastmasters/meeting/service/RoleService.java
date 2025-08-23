package com.toastmasters.meeting.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.request.*;
import com.toastmasters.meeting.dto.request.AddRoleRequest;
import com.toastmasters.meeting.dto.request.AssignRolesToUserRequest;
import com.toastmasters.meeting.dto.request.DeleteRoleRequest;
import com.toastmasters.meeting.dto.request.GetUserRoleRequest;
import com.toastmasters.meeting.dto.request.UpdateRoleRequest;
import com.toastmasters.meeting.dto.response.RoleResponse;
import java.util.List;

/**
 * <p>
 *   角色服务接口
 * </p>
 * @author seekpan
 */
public interface RoleService {
    
    /**
     * 新增角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> addRole(AddRoleRequest request);
    
    /**
     * 删除角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> deleteRole(DeleteRoleRequest request);
    
    /**
     * 修改角色信息
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> updateRole(UpdateRoleRequest request);
    
    /**
     * 查询角色列表
     *
     * @return RestResult
     */
    RestResult<List<RoleResponse>> getRoleList();
    
    /**
     * 分配角色给用户
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> assignRolesToUser(AssignRolesToUserRequest request);
    
    /**
     * 查询用户的角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<List<RoleResponse>> getUserRoles(GetUserRoleRequest request);
}