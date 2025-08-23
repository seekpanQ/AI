package com.toastmasters.meeting.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.request.*;
import com.toastmasters.meeting.dto.request.AddPermissionRequest;
import com.toastmasters.meeting.dto.request.AssignPermissionsToRoleRequest;
import com.toastmasters.meeting.dto.request.DeletePermissionRequest;
import com.toastmasters.meeting.dto.request.GetRolePermissionRequest;
import com.toastmasters.meeting.dto.request.UpdatePermissionRequest;
import com.toastmasters.meeting.dto.response.PermissionResponse;
import com.toastmasters.meeting.service.PermissionService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   权限控制器
 * </p>
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {
    
    @Autowired
    private PermissionService permissionService;
    
    /**
     * 新增权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/add")
    public RestResult<?> addPermission(@Valid @RequestBody AddPermissionRequest request) {
        log.info("新增权限请求接收");
        return permissionService.addPermission(request);
    }
    
    /**
     * 删除权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/delete")
    public RestResult<?> deletePermission(@Valid @RequestBody DeletePermissionRequest request) {
        log.info("删除权限请求接收");
        return permissionService.deletePermission(request);
    }
    
    /**
     * 修改权限信息
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/update")
    public RestResult<?> updatePermission(@Valid @RequestBody UpdatePermissionRequest request) {
        log.info("修改权限信息请求接收");
        return permissionService.updatePermission(request);
    }
    
    /**
     * 查询权限列表
     *
     * @return RestResult
     */
    @GetMapping("/list")
    public RestResult<List<PermissionResponse>> getPermissionList() {
        log.info("查询权限列表请求接收");
        return permissionService.getPermissionList();
    }
    
    /**
     * 为角色分配权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/assign-to-role")
    public RestResult<?> assignPermissionsToRole(@Valid @RequestBody AssignPermissionsToRoleRequest request) {
        log.info("为角色分配权限请求接收");
        return permissionService.assignPermissionsToRole(request);
    }
    
    /**
     * 查询角色的权限
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/get-role-permissions")
    public RestResult<List<PermissionResponse>> getRolePermissions(@Valid @RequestBody GetRolePermissionRequest request) {
        log.info("查询角色的权限请求接收");
        return permissionService.getRolePermissions(request);
    }
}