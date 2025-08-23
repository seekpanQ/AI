package com.toastmasters.meeting.notification.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.notification.dto.NotificationDTO;
import com.toastmasters.meeting.notification.vo.NotificationVO;
import java.util.List;

/**
 * <p>
 *   通知服务接口
 * </p>
 * @author seekpan
 */
public interface NotificationService {

    /**
     * 新增通知
     *
     * @param notificationDTO 通知信息DTO
     */
    void addNotification(NotificationDTO notificationDTO);

    /**
     * 发送通知
     *
     * @param noticeId 通知ID
     * @return 处理结果
     */
    RestResult<Void> sendNotification(Long noticeId);

    /**
     * 查询通知列表
     *
     * @param pageIndex 页码
     * @param pageSize 每页大小
     * @return 通知列表
     */
    RestResult<List<NotificationVO>> getNotificationList(int pageIndex, int pageSize);

    /**
     * 删除通知
     *
     * @param noticeId 通知ID
     * @return 处理结果
     */
    RestResult<Void> deleteNotification(Long noticeId);
}