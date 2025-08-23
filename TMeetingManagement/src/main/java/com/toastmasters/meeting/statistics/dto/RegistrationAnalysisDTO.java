package com.toastmasters.meeting.statistics.dto;

import java.util.Map;
import lombok.Data;

/**
 * <p>
 *   报名情况分析数据传输对象
 * </p>
 * @author seekpan
 */
@Data
public class RegistrationAnalysisDTO {

    /**
     * 按状态分类的报名数量
     */
    private Map<String, Long> registrationStatusCounts;

    /**
     * 总报名数
     */
    private Long totalRegistrations;
}