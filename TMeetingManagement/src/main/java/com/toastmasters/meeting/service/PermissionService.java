package com.toastmasters.meeting.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.request.*;
import com.toastmasters.meeting.dto.request.AddPermissionRequest;
import com.toastmasters.meeting.dto.request.AssignPermissionsToRoleRequest;
import com.toastmasters.meeting.dto.request.DeletePermissionRequest;
import com.toastmasters.meeting.dto.request.GetRolePermissionRequest;
import com.toastmasters.meeting.dto.request.UpdatePermissionRequest;
import com.toastmasters.meeting.dto.response.PermissionResponse;
import java.util.List;

/**
 * <p>
 *   权限服务接口
 * </p>
 * @author seekpan
 */
public interface PermissionService {
    
    /**
     * 新增权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> addPermission(AddPermissionRequest request);
    
    /**
     * 删除权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> deletePermission(DeletePermissionRequest request);
    
    /**
     * 修改权限信息
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> updatePermission(UpdatePermissionRequest request);
    
    /**
     * 查询权限列表
     *
     * @return RestResult
     */
    RestResult<List<com.toastmasters.meeting.dto.response.PermissionResponse>> getPermissionList();
    
    /**
     * 为角色分配权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<?> assignPermissionsToRole(AssignPermissionsToRoleRequest request);
    
    /**
     * 查询角色的权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    RestResult<List<com.toastmasters.meeting.dto.response.PermissionResponse>> getRolePermissions(GetRolePermissionRequest request);
}