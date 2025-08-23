package com.toastmasters.meeting.notification.vo;

import java.util.Date;
import lombok.*;

/**
 * <p>
 *   通知信息视图展示对象
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationVO {

    /**
     * 通知唯一标识
     */
    private Long noticeId;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 通知类型：1-系统消息，2-会议提醒，3-重要通知
     */
    private Integer noticeType;

    /**
     * 目标用户列表（JSON格式）
     */
    private String targetUserIds;

    /**
     * 发送状态：0-未发送，1-已发送
     */
    private Integer sendStatus;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
}