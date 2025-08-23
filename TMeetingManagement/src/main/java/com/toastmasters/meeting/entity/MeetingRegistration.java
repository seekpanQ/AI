package com.toastmasters.meeting.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *   会议报名实体类
 * </p>
 * @author seekpan
 */
@NoArgsConstructor
@Entity
@Table(name = "meeting_registration")
@AllArgsConstructor
@Data
public class MeetingRegistration {

    /**
     * 报名记录唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    /**
     * 会议ID
     */
    @Column(name = "meeting_id")
    private Long meetingId;

    /**
     * 报名用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 报名状态：1-待审核，2-已通过，3-已拒绝，4-已取消
     */
    private Integer status;

    /**
     * 报名理由
     */
    private String applyReason;

    /**
     * 附件路径
     */
    @Column(name = "attachment_path")
    private String attachmentPath;

    /**
     * 创建人ID
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    @Column(name = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
