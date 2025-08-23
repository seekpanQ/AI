package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   获取会议详情请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class GetMeetingDetailRequest {

    /**
     * 会议ID（必填）
     */
    @NotNull(message = "会议ID不能为空")
    private Long meetingId;
}