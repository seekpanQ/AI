package com.toastmasters.meeting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *   创建会议请求参数对象
 * </p>
 * @author seekpan
 */
@Data
@Schema(description = "创建会议请求参数对象")
public class CreateMeetingRequest {

    /**
     * 会议标题（必填）
     */
    @NotBlank(message = "会议标题不能为空")
    @Schema(description = "会议标题（必填）", example = "Toastmasters会议", required = true)
    private String title;

    /**
     * 会议内容描述
     */
    @Schema(description = "会议内容描述", example = "本次会议将讨论演讲技巧和领导力培养")
    private String content;

    /**
     * 开始时间
     */
    @Schema(description = "开始时间", example = "2023-12-01T09:00:00")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @Schema(description = "结束时间", example = "2023-12-01T11:00:00")
    private LocalDateTime endTime;

    /**
     * 会议地点
     */
    @Schema(description = "会议地点", example = "会议室A")
    private String location;

    /**
     * 组织者
     */
    @Schema(description = "组织者", example = "张三")
    private String organizer;

    /**
     * 最大参会人数
     */
    @Schema(description = "最大参会人数", example = "50")
    private Integer maxAttendees;
}
