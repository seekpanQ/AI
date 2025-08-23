package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   取消会议报名请求参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class CancelRegistrationDTO {

    /**
     * 报名记录ID
     */
    @NotNull(message = "报名记录ID不能为空")
    private Long registrationId;
}