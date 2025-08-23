package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   用户信息仓储接口
 * </p>
 * @author seekpan
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return Optional<UserInfo>
     */
    Optional<UserInfo> findByUsername(String username);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    Boolean existsByUsername(String username);
}
