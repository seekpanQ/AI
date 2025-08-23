package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.RolePermissionRelation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   角色权限关联关系数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface RolePermissionRelationRepository extends JpaRepository<RolePermissionRelation, Long> {
    
    /**
     * 删除指定角色的所有权限关联关系
     *
     * @param roleId 角色ID
     * @return 影响行数
     */
    @Modifying
    @Query("DELETE FROM RolePermissionRelation r WHERE r.roleId = ?1")
    int deleteByRoleId(Long roleId);

    /**
     * 查询指定角色拥有的所有权限ID
     *
     * @param roleId 角色ID
     * @return List<Long>
     */
    @Query(value = "SELECT permission_id FROM role_permission_relation WHERE role_id = ?1", nativeQuery = true)
    List<Long> findPermissionIdsByRoleId(Long roleId);
}