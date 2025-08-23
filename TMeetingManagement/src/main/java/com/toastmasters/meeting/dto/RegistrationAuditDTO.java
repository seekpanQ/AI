package com.toastmasters.meeting.dto;

import java.util.List;
import lombok.Data;

/**
 * <p>
 *   会议报名审核参数封装类
 * </p>
 * @author seekpan
 */
@Data
public class RegistrationAuditDTO {

    /**
     * 报名记录ID（单条审核时使用）
     */
    private Long registrationId;

    /**
     * 报名记录ID集合（批量审核时使用）
     */
    private List<Long> registrationIds;

    /**
     * 拒绝原因（选填）
     */
    private String rejectReason;
}