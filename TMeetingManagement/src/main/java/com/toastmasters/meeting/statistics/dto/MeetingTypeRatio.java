package com.toastmasters.meeting.statistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   会议类型比例对象
 * </p>
 * @author seekpan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingTypeRatio {

    /**
     * 会议类型名称
     */
    private String typeName;

    /**
     * 占比百分比
     */
    private Double ratioPercentage;
}