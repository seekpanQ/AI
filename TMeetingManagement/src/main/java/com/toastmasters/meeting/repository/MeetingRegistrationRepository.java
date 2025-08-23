package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.MeetingRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;

/**
 * <p>
 *   会议报名数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface MeetingRegistrationRepository extends JpaRepository<MeetingRegistration, Long> {

    /**
     * 根据会议ID和用户ID查询报名记录
     *
     * @param meetingId 会议ID
     * @param userId 用户ID
     * @return MeetingRegistration 对象
     */
    MeetingRegistration findByMeetingIdAndUserId(Long meetingId, Long userId);

    /**
     * 查询指定会议的报名总数（排除已取消状态）
     *
     * @param meetingId 会议ID
     * @return 报名数量
     */
    @Query("SELECT COUNT(mr) FROM MeetingRegistration mr WHERE mr.meetingId = :meetingId AND mr.status != 4")
    Long countByMeetingId(@Param("meetingId") Long meetingId);

    /**
     * 根据报名记录ID和用户ID查询报名记录
     *
     * @param registrationId 报名记录ID
     * @param userId 用户ID
     * @return MeetingRegistration 对象
     */
    MeetingRegistration findByRegistrationIdAndUserId(Long registrationId, Long userId);

    /**
     * 根据会议ID查询该会议下的所有待审核报名记录
     *
     * @param meetingId 会议ID
     * @param status 待审核状态
     * @return 符合条件的报名记录列表
     */
    List<MeetingRegistration> findByMeetingIdAndStatus(Long meetingId, Integer status);

    /**
     * 根据ID更新报名状态
     *
     * @param id 报名记录ID
     * @param status 新的状态值
     * @return 影响行数
     */
    @Modifying
    @Query("UPDATE MeetingRegistration mr SET mr.status = :status WHERE mr.registrationId = :id")
    int updateStatusById(@Param("id") Long id, @Param("status") Integer status);

    /**
     * 批量更新报名状态
     *
     * @param ids 报名记录ID集合
     * @param status 新的状态值
     * @return 影响行数
     */
    @Modifying
    @Query("UPDATE MeetingRegistration mr SET mr.status = :status WHERE mr.registrationId IN (:ids)")
    int batchUpdateStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);

    /**
     * 检查指定ID的报名记录是否为待审核状态
     *
     * @param id 报名记录ID
     * @return 是否是待审核状态
     */
    @Query("SELECT CASE WHEN COUNT(mr) > 0 THEN TRUE ELSE FALSE END FROM MeetingRegistration mr WHERE mr.registrationId = :id AND mr.status = 1")
    boolean isPendingReview(@Param("id") Long id);
}
