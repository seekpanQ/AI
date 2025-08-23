package com.toastmasters.meeting.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.request.*;
import com.toastmasters.meeting.dto.response.RoleResponse;
import com.toastmasters.meeting.service.RoleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *   角色控制器
 * </p>
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    /**
     * 新增角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/add")
    public RestResult<?> addRole(@Valid @RequestBody AddRoleRequest request) {
        log.info("新增角色请求接收");
        return roleService.addRole(request);
    }
    
    /**
     * 删除角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/delete")
    public RestResult<?> deleteRole(@Valid @RequestBody DeleteRoleRequest request) {
        log.info("删除角色请求接收");
        return roleService.deleteRole(request);
    }
    
    /**
     * 修改角色信息
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/update")
    public RestResult<?> updateRole(@Valid @RequestBody UpdateRoleRequest request) {
        log.info("修改角色信息请求接收");
        return roleService.updateRole(request);
    }
    
    /**
     * 查询角色列表
     *
     * @return RestResult
     */
    @GetMapping("/list")
    public RestResult<List<RoleResponse>> getRoleList() {
        log.info("查询角色列表请求接收");
        return roleService.getRoleList();
    }
    
    /**
     * 分配角色给用户
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/assign-to-user")
    public RestResult<?> assignRolesToUser(@Valid @RequestBody AssignRolesToUserRequest request) {
        log.info("分配角色给用户请求接收");
        return roleService.assignRolesToUser(request);
    }
    
    /**
     * 查询用户的角色
     *
     * @param request 请求参数
     * @return RestResult
     */
    @PostMapping("/get-user-roles")
    public RestResult<List<RoleResponse>> getUserRoles(@Valid @RequestBody GetUserRoleRequest request) {
        log.info("查询用户的角色请求接收");
        return roleService.getUserRoles(request);
    }
}