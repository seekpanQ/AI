package com.toastmasters.meeting.statistics.dto;

import java.time.LocalDate;
import lombok.Data;

/**
 * <p>
 *   统计查询参数对象
 * </p>
 * @author seekpan
 */
@Data
public class StatisticsQuery {

    /**
     * 开始日期
     */
    private LocalDate startDate;

    /**
     * 结束日期
     */
    private LocalDate endDate;

    /**
     * 会议类型（可选）
     */
    private String meetingType;
}