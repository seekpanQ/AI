package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *   编辑会议请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class EditMeetingRequest {

    /**
     * 会议ID（必填）
     */
    @NotNull(message = "会议ID不能为空")
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
     * 最大参会人数
     */
    private Integer maxAttendees;
}