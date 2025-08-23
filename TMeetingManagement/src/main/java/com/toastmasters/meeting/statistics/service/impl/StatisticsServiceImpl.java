package com.toastmasters.meeting.statistics.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.statistics.dto.*;
import com.toastmasters.meeting.statistics.dto.MeetingStatisticsDTO;
import com.toastmasters.meeting.statistics.dto.MeetingTypeDistributionDTO;
import com.toastmasters.meeting.statistics.dto.MeetingTypeRatio;
import com.toastmasters.meeting.statistics.dto.RegistrationAnalysisDTO;
import com.toastmasters.meeting.statistics.dto.StatisticsQuery;
import com.toastmasters.meeting.statistics.service.StatisticsService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.Specification.where;

/**
 * <p>
 *   数据统计服务实现类
 * </p>
 * @author seekpan
 */
@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RestResult<MeetingStatisticsDTO> getMeetingStatistics(StatisticsQuery query) {
        try {
            // 构建查询条件
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<?> meetingRoot = cq.from(com.toastmasters.meeting.entity.MeetingInfo.class);
            Root<?> registrationRoot = cq.from(com.toastmasters.meeting.entity.MeetingRegistration.class);

            Predicate predicate = buildMeetingPredicate(cb, meetingRoot, query);
//            cq.select(new Integer()[]{
//                    cb.count(meetingRoot),
//                    cb.sumAsLong(registrationRoot.get("registrationId")),
//                    cb.sumAsLong(cb.<Integer>selectCase()
//                            .when(cb.equal(registrationRoot.get("status"), 2), 1)
//                            .otherwise(0)),
//                    cb.sumAsLong(cb.<Integer>selectCase()
//                            .when(cb.equal(registrationRoot.get("status"), 3), 1)
//                            .otherwise(0))
//            }).where(predicate);

            TypedQuery<Object[]> typedQuery = entityManager.createQuery(cq);
            List<Object[]> results = typedQuery.getResultList();

            if (results.isEmpty()) {
                return RestResult.success(null);
            }

            Object[] row = results.get(0);
            MeetingStatisticsDTO dto = new MeetingStatisticsDTO();
            dto.setTotalMeetings((Long) row[0]);
            dto.setTotalRegistrations(((Number) row[1]).longValue());
            dto.setApprovedCount(((Number) row[2]).longValue());
            dto.setRejectedCount(((Number) row[3]).longValue());

            // 计算平均报名人数
            if (dto.getTotalMeetings() != null && dto.getTotalMeetings() > 0) {
                BigDecimal avg = new BigDecimal(dto.getTotalRegistrations())
                        .divide(new BigDecimal(dto.getTotalMeetings()), 2, RoundingMode.HALF_UP);
                dto.setAvgRegistrationsPerMeeting(avg);
            } else {
                dto.setAvgRegistrationsPerMeeting(BigDecimal.ZERO);
            }

            return RestResult.success(dto);
        } catch (Exception e) {
            log.error("获取会议统计数据失败", e);
            return RestResult.error("999999", "系统错误");
        }
    }

    @Override
    public RestResult<RegistrationAnalysisDTO> analyzeRegistrations(StatisticsQuery query) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<?> registrationRoot = cq.from(com.toastmasters.meeting.entity.MeetingRegistration.class);

            Predicate predicate = buildRegistrationPredicate(cb, registrationRoot, query);
            cq.multiselect(
                    registrationRoot.get("status"),
                    cb.count(registrationRoot)
            ).groupBy(registrationRoot.get("status")).where(predicate);

            TypedQuery<Object[]> typedQuery = entityManager.createQuery(cq);
            List<Object[]> results = typedQuery.getResultList();

            RegistrationAnalysisDTO dto = new RegistrationAnalysisDTO();
            Map<String, Long> statusMap = new HashMap<>();
            long totalCount = 0;

            for (Object[] row : results) {
                Integer status = (Integer) row[0];
                Long count = ((Number) row[1]).longValue();
                statusMap.put(getStatusName(status), count);
                totalCount += count;
            }

            dto.setRegistrationStatusCounts(statusMap);
            dto.setTotalRegistrations(totalCount);

            return RestResult.success(dto);
        } catch (Exception e) {
            log.error("报名情况分析失败", e);
            return RestResult.error("999999", "系统错误");
        }
    }

    @Override
    public RestResult<MeetingTypeDistributionDTO> getMeetingTypeDistribution(StatisticsQuery query) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<?> meetingRoot = cq.from(com.toastmasters.meeting.entity.MeetingInfo.class);

            Predicate predicate = buildMeetingPredicate(cb, meetingRoot, query);
            cq.multiselect(
                    meetingRoot.get("title").alias("type"),
                    cb.count(meetingRoot).alias("count")
            ).groupBy(meetingRoot.get("title")).where(predicate);

            TypedQuery<Object[]> typedQuery = entityManager.createQuery(cq);
            List<Object[]> results = typedQuery.getResultList();

            MeetingTypeDistributionDTO dto = new MeetingTypeDistributionDTO();
            Map<String, Long> typeCountMap = new LinkedHashMap<>();

            long totalTypes = 0;
            for (Object[] row : results) {
                String type = (String) row[0];
                Long count = ((Number) row[1]).longValue();
                typeCountMap.put(type == null ? "未知类型" : type, count);
                totalTypes += count;
            }

            dto.setTypeCountMap(typeCountMap);

            // 计算占比
            List<MeetingTypeRatio> ratios = new ArrayList<>();
            if (totalTypes > 0) {
                for (Map.Entry<String, Long> entry : typeCountMap.entrySet()) {
                    double percentage = (double) entry.getValue() / totalTypes * 100;
                    ratios.add(new MeetingTypeRatio(entry.getKey(), Math.round(percentage * 100.0) / 100.0));
                }
            }
            dto.setRatios(ratios);

            return RestResult.success(dto);
        } catch (Exception e) {
            log.error("会议类型分布统计失败", e);
            return RestResult.error("999999", "系统错误");
        }
    }

    /**
     * 构建会议查询谓词
     */
    private Predicate buildMeetingPredicate(CriteriaBuilder cb, Root<?> meetingRoot, StatisticsQuery query) {
        List<Predicate> predicates = new ArrayList<>();

        if (query.getStartDate() != null || query.getEndDate() != null) {
            LocalDateTime startDateTime = query.getStartDate() != null ?
                    query.getStartDate().atStartOfDay() : LocalDateTime.MIN;
            LocalDateTime endDateTime = query.getEndDate() != null ?
                    query.getEndDate().plusDays(1).atStartOfDay() : LocalDateTime.MAX;

            predicates.add(cb.between(meetingRoot.get("createTime"), startDateTime, endDateTime));
        }

        if (query.getMeetingType() != null && !query.getMeetingType().isEmpty()) {
            predicates.add(cb.equal(meetingRoot.get("title"), query.getMeetingType()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }

    /**
     * 构建报名查询谓词
     */
    private Predicate buildRegistrationPredicate(CriteriaBuilder cb, Root<?> registrationRoot, StatisticsQuery query) {
        List<Predicate> predicates = new ArrayList<>();

        if (query.getStartDate() != null || query.getEndDate() != null) {
            LocalDateTime startDateTime = query.getStartDate() != null ?
                    query.getStartDate().atStartOfDay() : LocalDateTime.MIN;
            LocalDateTime endDateTime = query.getEndDate() != null ?
                    query.getEndDate().plusDays(1).atStartOfDay() : LocalDateTime.MAX;

            predicates.add(cb.between(registrationRoot.get("createTime"), startDateTime, endDateTime));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }

    /**
     * 获取状态名称
     */
    private String getStatusName(Integer status) {
        switch (status) {
            case 1: return "待审核";
            case 2: return "已通过";
            case 3: return "已拒绝";
            case 4: return "已取消";
            default: return "未知状态";
        }
    }
}