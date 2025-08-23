package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.PermissionInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   权限信息数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface PermissionInfoRepository extends JpaRepository<PermissionInfo, Long> {
    
    /**
     * 根据权限编码查找权限
     *
     * @param permissionCode 权限编码
     * @return Optional<PermissionInfo>
     */
    Optional<PermissionInfo> findByPermissionCode(String permissionCode);
}