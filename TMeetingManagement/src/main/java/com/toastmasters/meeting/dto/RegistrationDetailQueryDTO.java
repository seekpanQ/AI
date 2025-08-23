package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   获取会议报名详情请求参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class RegistrationDetailQueryDTO {

    /**
     * 报名记录ID
     */
    @NotNull(message = "报名记录ID不能为空")
    private Long registrationId;
}