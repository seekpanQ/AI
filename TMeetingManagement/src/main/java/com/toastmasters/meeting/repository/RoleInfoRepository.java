package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.RoleInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   角色信息数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {
    
    /**
     * 根据角色名称查找角色
     *
     * @param roleName 角色名称
     * @return Optional<RoleInfo>
     */
    Optional<RoleInfo> findByRoleName(String roleName);
}