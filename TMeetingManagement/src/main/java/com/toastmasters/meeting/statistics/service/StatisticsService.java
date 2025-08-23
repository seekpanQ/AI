package com.toastmasters.meeting.statistics.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.statistics.dto.MeetingStatisticsDTO;
import com.toastmasters.meeting.statistics.dto.MeetingTypeDistributionDTO;
import com.toastmasters.meeting.statistics.dto.RegistrationAnalysisDTO;
import com.toastmasters.meeting.statistics.dto.StatisticsQuery;

/**
 * <p>
 *   数据统计服务接口
 * </p>
 * @author seekpan
 */
public interface StatisticsService {

    /**
     * 会议数据统计
     *
     * @param query 查询条件
     * @return 统计结果
     */
    RestResult<MeetingStatisticsDTO> getMeetingStatistics(StatisticsQuery query);

    /**
     * 报名情况分析
     *
     * @param query 查询条件
     * @return 分析结果
     */
    RestResult<RegistrationAnalysisDTO> analyzeRegistrations(StatisticsQuery query);

    /**
     * 会议类型分布统计
     *
     * @param query 查询条件
     * @return 统计结果
     */
    RestResult<MeetingTypeDistributionDTO> getMeetingTypeDistribution(StatisticsQuery query);
}