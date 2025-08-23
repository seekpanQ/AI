package com.toastmasters.meeting.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   通知信息数据传输对象
 * </p>
 * @author seekpan
 */
@Data
public class NotificationDTO {

    /**
     * 通知标题
     */
    @NotBlank(message = "通知标题不能为空")
    private String title;

    /**
     * 通知内容
     */
    @NotBlank(message = "通知内容不能为空")
    private String content;

    /**
     * 通知类型
     */
    @NotNull(message = "通知类型不能为空")
    private Integer noticeType;

    /**
     * 目标用户列表（JSON格式）
     */
    @NotBlank(message = "目标用户列表不能为空")
    private String targetUserIds;
}