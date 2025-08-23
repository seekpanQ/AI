package com.toastmasters.meeting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   会议报名查询参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class RegistrationQueryDTO {

    /**
     * 会议ID（必填）
     */
    @NotNull(message = "会议ID不能为空")
    private Long meetingId;

    /**
     * 页码（必填）
     */
    @NotNull(message = "页码不能为空")
    private Integer pageIndex;

    /**
     * 每页大小（必填）
     */
    @NotNull(message = "每页大小不能为空")
    private Integer pageSize;
}