package com.toastmasters.meeting.notification.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.notification.service.NotificationService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * 删除通知
     *
     * @param noticeId 通知ID
     * @return RestResult 对象
     */
    @PostMapping("/delete")
    public RestResult<Void> deleteNotification(@NotNull Long noticeId) {
        return notificationService.deleteNotification(noticeId);
    }
}