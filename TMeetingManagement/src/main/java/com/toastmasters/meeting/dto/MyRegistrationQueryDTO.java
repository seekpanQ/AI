package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   查询我的报名状态请求参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class MyRegistrationQueryDTO {

    /**
     * 会议ID
     */
    @NotNull(message = "会议ID不能为空")
    private Long meetingId;
}