package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   提交会议报名请求参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class MeetingApplyDTO {

    /**
     * 会议ID
     */
    @NotNull(message = "会议ID不能为空")
    private Long meetingId;

    /**
     * 报名理由
     */
    private String applyReason;

    /**
     * 附件路径
     */
    private String attachmentPath;
}