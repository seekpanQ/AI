package com.toastmasters.meeting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 数据统计实体类
 * </p>
 *
 * @author seekpan
 */
@NoArgsConstructor
@Entity
@Table(name = "statistics_data")
@AllArgsConstructor
@Data
public class StatisticsData {
    /**
     * 统计数据唯一标识
     */
    @Id
    @Column(name = "stat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statId;
    /**
     * 统计日期
     */
    @Column(name = "stat_date")
    private Date statDate;
    /**
     * 会议数量
     */
    @Column(name = "meeting_count")
    private Integer meetingCount;
    /**
     * 报名总数
     */
    @Column(name = "registration_count")
    private Integer registrationCount;
    /**
     * 审核通过数
     */
    @Column(name = "approved_count")
    private Integer approvedCount;
    /**
     * 审核拒绝数
     */
    @Column(name = "rejected_count")
    private Integer rejectedCount;
    /**
     * 创建人ID
     */
    @Column(name = "create_by")
    private Long createBy;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;
}
