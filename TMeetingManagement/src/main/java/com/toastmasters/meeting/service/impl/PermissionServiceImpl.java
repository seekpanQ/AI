package com.toastmasters.meeting.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.request.*;
import com.toastmasters.meeting.dto.request.AddPermissionRequest;
import com.toastmasters.meeting.dto.request.AssignPermissionsToRoleRequest;
import com.toastmasters.meeting.dto.request.DeletePermissionRequest;
import com.toastmasters.meeting.dto.request.GetRolePermissionRequest;
import com.toastmasters.meeting.dto.request.UpdatePermissionRequest;
import com.toastmasters.meeting.dto.response.PermissionResponse;
import com.toastmasters.meeting.entity.PermissionInfo;
import com.toastmasters.meeting.entity.RolePermissionRelation;
import com.toastmasters.meeting.exception.BusinessException;
import com.toastmasters.meeting.repository.PermissionInfoRepository;
import com.toastmasters.meeting.repository.RolePermissionRelationRepository;
import com.toastmasters.meeting.service.PermissionService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *   权限服务实现类
 * </p>
 * @author seekpan
 */
@Slf4j
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    
    @Autowired
    private PermissionInfoRepository permissionInfoRepository;
    
    @Autowired
    private RolePermissionRelationRepository rolePermissionRelationRepository;
    
    @Override
    public RestResult<?> addPermission(AddPermissionRequest request) {
        log.info("新增权限 - 请求参数: {}", request);
        
        // 判断权限编码是否已存在
        if (permissionInfoRepository.findByPermissionCode(request.getPermissionCode()).isPresent()) {
            return RestResult.error("000001", "权限编码已存在");
        }
        
        try {
            PermissionInfo permissionInfo = new PermissionInfo();
            BeanUtils.copyProperties(request, permissionInfo);
            
            // 设置默认值
            permissionInfo.setCreateTime(java.time.LocalDateTime.now());
            permissionInfo.setUpdateTime(java.time.LocalDateTime.now());
            
            permissionInfoRepository.save(permissionInfo);
            log.info("新增权限成功 - 权限ID: {}", permissionInfo.getPermissionId());
            return RestResult.success(null);
        } catch (Exception e) {
            log.error("新增权限失败", e);
            throw new BusinessException("新增权限失败");
        }
    }
    
    @Override
    public RestResult<?> deletePermission(DeletePermissionRequest request) {
        log.info("删除权限 - 请求参数: {}", request);
        
        // 判断权限是否存在
        if (!permissionInfoRepository.existsById(request.getPermissionId())) {
            return RestResult.error("000001", "权限不存在");
        }
        
        try {
            // 删除权限相关的角色关联关系
            // 注意这里需要调用 repository 的方法来删除相关记录
            // 此处省略具体实现细节
            
            // 删除权限信息
            permissionInfoRepository.deleteById(request.getPermissionId());
            log.info("删除权限成功 - 权限ID: {}", request.getPermissionId());
            return RestResult.success(null);
        } catch (Exception e) {
            log.error("删除权限失败", e);
            throw new BusinessException("删除权限失败");
        }
    }
    
    @Override
    public RestResult<?> updatePermission(UpdatePermissionRequest request) {
        log.info("修改权限信息 - 请求参数: {}", request);
        
        // 判断权限是否存在
        if (!permissionInfoRepository.existsById(request.getPermissionId())) {
            return RestResult.error("000001", "权限不存在");
        }
        
        try {
            PermissionInfo permissionInfo = permissionInfoRepository.findById(request.getPermissionId())
                    .orElseThrow(() -> new BusinessException("权限不存在"));
            
            if (request.getPermissionName() != null && !request.getPermissionName().isEmpty()) {
                permissionInfo.setPermissionName(request.getPermissionName());
            }
            
            if (request.getPermissionCode() != null && !request.getPermissionCode().isEmpty()) {
                permissionInfo.setPermissionCode(request.getPermissionCode());
            }
            
            if (request.getDescription() != null) {
                permissionInfo.setDescription(request.getDescription());
            }
            
            permissionInfo.setUpdateTime(java.time.LocalDateTime.now());
            permissionInfoRepository.save(permissionInfo);
            
            log.info("修改权限信息成功 - 权限ID: {}", request.getPermissionId());
            return RestResult.success(null);
        } catch (Exception e) {
            log.error("修改权限信息失败", e);
            throw new BusinessException("修改权限信息失败");
        }
    }
    
    @Override
    public RestResult<List<PermissionResponse>> getPermissionList() {
        log.info("查询权限列表");
        
        try {
            List<PermissionInfo> permissions = permissionInfoRepository.findAll();
            List<PermissionResponse> responseList = permissions.stream()
                    .map(permission -> {
                        PermissionResponse response = new PermissionResponse();
                        BeanUtils.copyProperties(permission, response);
                        return response;
                    })
                    .collect(Collectors.toList());
            
            log.info("查询权限列表成功 - 总数量: {}", responseList.size());
            return RestResult.success(responseList);
        } catch (Exception e) {
            log.error("查询权限列表失败", e);
            throw new BusinessException("查询权限列表失败");
        }
    }
    
    @Override
    public RestResult<?> assignPermissionsToRole(AssignPermissionsToRoleRequest request) {
        log.info("为角色分配权限 - 请求参数: {}", request);
        
        // 判断角色是否存在
        // 注意此处需要验证角色是否存在
        
        // 判断权限是否存在
        // 注意此处需要验证所有权限都存在
        
        try {
            // 清除原有的角色权限关联关系
            rolePermissionRelationRepository.deleteByRoleId(request.getRoleId());
            
            // 建立新的角色权限关联关系
            for (Long permissionId : request.getPermissionIds()) {
                RolePermissionRelation relation = new RolePermissionRelation();
                relation.setRoleId(request.getRoleId());
                relation.setPermissionId(permissionId);
                relation.setCreateTime(java.time.LocalDateTime.now());
                // 这里应该保存到数据库
                rolePermissionRelationRepository.save(relation);
            }
            
            log.info("为角色分配权限成功 - 角色ID: {}, 权限数量: {}", request.getRoleId(), request.getPermissionIds().size());
            return RestResult.success(null);
        } catch (Exception e) {
            log.error("为角色分配权限失败", e);
            throw new BusinessException("为角色分配权限失败");
        }
    }
    
    @Override
    public RestResult<List<PermissionResponse>> getRolePermissions(GetRolePermissionRequest request) {
        log.info("查询角色的权限 - 请求参数: {}", request);
        
        // 判断角色是否存在
        // 注意此处需要验证角色是否存在
        
        try {
            List<Long> permissionIds = rolePermissionRelationRepository.findPermissionIdsByRoleId(request.getRoleId());
            List<PermissionInfo> permissions = permissionInfoRepository.findAllById(permissionIds);
            
            List<PermissionResponse> responseList = permissions.stream()
                    .map(permission -> {
                        PermissionResponse response = new PermissionResponse();
                        BeanUtils.copyProperties(permission, response);
                        return response;
                    })
                    .collect(Collectors.toList());
            
            log.info("查询角色的权限成功 - 角色ID: {}, 权限数量: {}", request.getRoleId(), responseList.size());
            return RestResult.success(responseList);
        } catch (Exception e) {
            log.error("查询角色的权限失败", e);
            throw new BusinessException("查询角色的权限失败");
        }
    }
}