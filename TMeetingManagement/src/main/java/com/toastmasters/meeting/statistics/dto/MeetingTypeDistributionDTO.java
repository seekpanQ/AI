package com.toastmasters.meeting.statistics.dto;

import com.toastmasters.meeting.statistics.dto.MeetingTypeRatio;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * <p>
 *   会议类型分布统计数据传输对象
 * </p>
 * @author seekpan
 */
@Data
public class MeetingTypeDistributionDTO {

    /**
     * 会议类型及其对应的数量
     */
    private Map<String, Long> typeCountMap;

    /**
     * 各类型占比
     */
    private List<MeetingTypeRatio> ratios;
}