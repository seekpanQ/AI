package com.toastmasters.meeting.notification.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * <p>
 *   通知信息实体对象
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification_info")
public class NotificationDO {

    /**
     * 通知唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    /**
     * 通知标题
     */
    @Column(nullable = false)
    private String title;

    /**
     * 通知内容
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 通知类型：1-系统消息，2-会议提醒，3-重要通知
     */
    @Column(nullable = false)
    private Integer noticeType;

    /**
     * 目标用户列表（JSON格式）
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String targetUserIds;

    /**
     * 发送状态：0-未发送，1-已发送
     */
    private Integer sendStatus;

    /**
     * 发送时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;

    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateTime;
}