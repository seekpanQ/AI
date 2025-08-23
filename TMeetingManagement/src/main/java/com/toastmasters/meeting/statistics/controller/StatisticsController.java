package com.toastmasters.meeting.statistics.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.statistics.dto.MeetingStatisticsDTO;
import com.toastmasters.meeting.statistics.dto.MeetingTypeDistributionDTO;
import com.toastmasters.meeting.statistics.dto.RegistrationAnalysisDTO;
import com.toastmasters.meeting.statistics.dto.StatisticsQuery;
import com.toastmasters.meeting.statistics.service.StatisticsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   数据统计控制器
 * </p>
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    /**
     * 会议数据统计
     *
     * @param query 查询条件
     * @return 统计结果
     */
    @PostMapping("/meeting-statistics")
    public RestResult<MeetingStatisticsDTO> getMeetingStatistics(@RequestBody @Valid StatisticsQuery query) {
        return statisticsService.getMeetingStatistics(query);
    }

    /**
     * 报名情况分析
     *
     * @param query 查询条件
     * @return 分析结果
     */
    @PostMapping("/registration-analysis")
    public RestResult<RegistrationAnalysisDTO> analyzeRegistrations(@RequestBody @Valid StatisticsQuery query) {
        return statisticsService.analyzeRegistrations(query);
    }

    /**
     * 会议类型分布统计
     *
     * @param query 查询条件
     * @return 统计结果
     */
    @PostMapping("/meeting-type-distribution")
    public RestResult<MeetingTypeDistributionDTO> getMeetingTypeDistribution(@RequestBody @Valid StatisticsQuery query) {
        return statisticsService.getMeetingTypeDistribution(query);
    }
}