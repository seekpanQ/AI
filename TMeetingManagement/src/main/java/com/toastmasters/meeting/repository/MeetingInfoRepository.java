package com.toastmasters.meeting.repository;

import com.toastmasters.meeting.entity.MeetingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   会议信息数据访问接口
 * </p>
 * @author seekpan
 */
@Repository
public interface MeetingInfoRepository extends JpaRepository<MeetingInfo, Long> {

    /**
     * 根据会议ID和状态查询会议信息
     *
     * @param meetingId 会议ID
     * @param status 状态
     * @return MeetingInfo 对象
     */
    MeetingInfo findByMeetingIdAndStatus(Long meetingId, Integer status);
}
