package com.toastmasters.meeting.statistics.repository;

import com.toastmasters.meeting.entity.StatisticsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   数据统计实体访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsData, Long> {
}