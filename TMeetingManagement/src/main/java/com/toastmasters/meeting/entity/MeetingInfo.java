package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   会议信息实体类
 * </p>
 * @author seekpan
 */
@NoArgsConstructor
@Entity
@Table(name = "meeting_info")
@AllArgsConstructor
@Data
public class MeetingInfo {

    /**
     * 会议唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    /**
     * 会议标题
     */
    private String title;

    /**
     * 会议内容描述
     */
    private String content;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 会议地点
     */
    private String location;

    /**
     * 组织者
     */
    private String organizer;

    /**
     * 会议状态：1-草稿，2-已发布，3-已结束，4-已取消
     */
    private Integer status;

    /**
     * 最大参会人数
     */
    private Integer maxAttendees;

    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
