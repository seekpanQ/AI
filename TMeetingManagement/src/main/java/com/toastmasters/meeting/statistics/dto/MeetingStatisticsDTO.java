package com.toastmasters.meeting.statistics.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * <p>
 *   会议统计数据传输对象
 * </p>
 * @author seekpan
 */
@Data
public class MeetingStatisticsDTO {

    /**
     * 会议总数
     */
    private Long totalMeetings;

    /**
     * 报名总人数
     */
    private Long totalRegistrations;

    /**
     * 审核通过人数
     */
    private Long approvedCount;

    /**
     * 审核拒绝人数
     */
    private Long rejectedCount;

    /**
     * 平均报名人数
     */
    private BigDecimal avgRegistrationsPerMeeting;
}