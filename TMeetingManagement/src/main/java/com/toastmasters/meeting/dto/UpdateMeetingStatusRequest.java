package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   更新会议状态请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class UpdateMeetingStatusRequest {

    /**
     * 会议ID（必填）
     */
    @NotNull(message = "会议ID不能为空")
    private Long meetingId;

    /**
     * 会议状态（必填）
     */
    @NotNull(message = "会议状态不能为空")
    private Integer status;
}