package com.toastmasters.meeting.notification.repository;

import com.toastmasters.meeting.notification.entity.NotificationDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *   通知信息数据访问层接口
 * </p>
 * @author seekpan
 */
public interface NotificationRepository extends JpaRepository<NotificationDO, Long> {
}