package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.UserRoleRelation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   用户角色关联关系数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {
    
    /**
     * 删除指定用户的全部角色关联关系
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    @Modifying
    @Query("DELETE FROM UserRoleRelation u WHERE u.userId = ?1")
    int deleteByUserId(Long userId);

    /**
     * 查询指定用户拥有的所有角色ID
     *
     * @param userId 用户ID
     * @return List<Long>
     */
    @Query(value = "SELECT role_id FROM user_role_relation WHERE user_id = ?1", nativeQuery = true)
    List<Long> findRoleIdsByUserId(Long userId);
}