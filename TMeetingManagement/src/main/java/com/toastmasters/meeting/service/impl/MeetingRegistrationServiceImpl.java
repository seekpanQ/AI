package com.toastmasters.meeting.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.CancelRegistrationDTO;
import com.toastmasters.meeting.dto.MeetingApplyDTO;
import com.toastmasters.meeting.dto.MyRegistrationQueryDTO;
import com.toastmasters.meeting.dto.MyRegistrationVO;
import com.toastmasters.meeting.dto.RegistrationDetailQueryDTO;
import com.toastmasters.meeting.dto.RegistrationDetailVO;
import com.toastmasters.meeting.entity.MeetingInfo;
import com.toastmasters.meeting.entity.MeetingRegistration;
import com.toastmasters.meeting.repository.MeetingInfoRepository;
import com.toastmasters.meeting.repository.MeetingRegistrationRepository;
import com.toastmasters.meeting.service.MeetingRegistrationService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

/**
 * <p>
 *   会议报名服务实现类
 * </p>
 * @author seekpan
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class MeetingRegistrationServiceImpl implements MeetingRegistrationService {

    private final MeetingInfoRepository meetingInfoRepository;

    @Autowired
    private MeetingRegistrationRepository registrationRepository;

    private final MeetingRegistrationRepository meetingRegistrationRepository;

    @Override
    @Transactional
    public RestResult<String> applyForMeeting(MeetingApplyDTO dto) {
        // 检查用户是否已报名该会议
        MeetingRegistration existingRegistration = meetingRegistrationRepository.findByMeetingIdAndUserId(dto.getMeetingId(), getCurrentUserId());
        if (existingRegistration != null) {
            return RestResult.error("000001", "您已经报名了该会议");
        }
        // 验证会议是否存在且状态为已发布
        // 已发布的会议状态码为2
        MeetingInfo meetingInfo = meetingInfoRepository.findByMeetingIdAndStatus(dto.getMeetingId(), 2);
        if (meetingInfo == null) {
            return RestResult.error("000001", "会议不存在或未发布");
        }
        // 判断会议是否已满员
        Long currentRegistrations = meetingRegistrationRepository.countByMeetingId(dto.getMeetingId());
        if (currentRegistrations >= meetingInfo.getMaxAttendees()) {
            return RestResult.error("000001", "会议人数已达上限");
        }
        // 将报名信息保存到数据库
        MeetingRegistration registration = new MeetingRegistration();
        registration.setMeetingId(dto.getMeetingId());
        registration.setUserId(getCurrentUserId());
        // 默认待审核状态
        registration.setStatus(1);
        registration.setApplyReason(dto.getApplyReason());
        registration.setAttachmentPath(dto.getAttachmentPath());
        registration.setCreateBy(getCurrentUserId());
        registration.setCreateTime(LocalDateTime.now());
        registration.setUpdateBy(getCurrentUserId());
        registration.setUpdateTime(LocalDateTime.now());
        meetingRegistrationRepository.save(registration);
        return RestResult.success("报名成功");
    }

    @Override
    @Transactional
    public RestResult<String> cancelRegistration(CancelRegistrationDTO dto) {
        // 根据报名记录ID查询报名信息
        MeetingRegistration registration = meetingRegistrationRepository.findByRegistrationIdAndUserId(dto.getRegistrationId(), getCurrentUserId());
        if (registration == null) {
            return RestResult.error("000001", "报名记录不存在");
        }
        // 校验当前报名状态是否可以取消
        if (registration.getStatus() != 1 && registration.getStatus() != 2) {
            // 待审核或已通过才可取消
            return RestResult.error("000001", "当前报名状态不可取消");
        }
        // 更新报名状态为已取消
        // 已取消状态码为4
        registration.setStatus(4);
        registration.setUpdateBy(getCurrentUserId());
        registration.setUpdateTime(LocalDateTime.now());
        meetingRegistrationRepository.save(registration);
        return RestResult.success("取消报名成功");
    }

    @Override
    public RestResult<MyRegistrationVO> getMyRegistrationStatus(MyRegistrationQueryDTO dto) {
        // 根据用户和会议ID查询报名记录
        MeetingRegistration registration = meetingRegistrationRepository.findByMeetingIdAndUserId(dto.getMeetingId(), getCurrentUserId());
        MyRegistrationVO vo = new MyRegistrationVO();
        if (registration == null) {
            // 如果没有找到报名记录，则返回无报名信息
            // 未报名
            vo.setStatus(0);
        } else {
            // 返回报名信息
            // 已报名
            vo.setStatus(1);
            vo.setApplyReason(registration.getApplyReason());
        }
        return RestResult.success(vo);
    }

    @Override
    public RestResult<RegistrationDetailVO> getRegistrationDetail(RegistrationDetailQueryDTO dto) {
        // 根据报名记录ID查找报名详情
        MeetingRegistration registration = meetingRegistrationRepository.findById(dto.getRegistrationId()).orElse(null);
        if (registration == null) {
            return RestResult.error("000001", "报名记录不存在");
        }
        // 组装并返回报名详情信息
        RegistrationDetailVO detailVO = new RegistrationDetailVO();
        // 这里需要关联查询会议标题等信息，但为了简化示例暂时只填充部分字段
        detailVO.setStatus(registration.getStatus());
        detailVO.setApplyReason(registration.getApplyReason());
        detailVO.setAttachmentPath(registration.getAttachmentPath());
        return RestResult.success(detailVO);
    }

    /**
     * 获取当前登录用户ID（此处模拟）
     * 实际项目中应从SecurityContext或其他认证机制获取
     */
    private Long getCurrentUserId() {
        // 此处仅为演示，默认返回固定值
        return 1L;
    }

    @Override
    public RestResult<List<MeetingRegistration>> getPendingRegistrations(RegistrationQueryDTO query) {
        log.info("获取待审核报名列表，会议ID: {}, 页码: {}, 每页大小: {}", query.getMeetingId(), query.getPageIndex(), query.getPageSize());
        // 查询符合条件的待审核报名记录
        List<MeetingRegistration> registrations = registrationRepository.findByMeetingIdAndStatus(query.getMeetingId(), // 状态1表示待审核
        1);
        if (registrations == null || registrations.isEmpty()) {
            return RestResult.error("000001", "无待审核报名记录");
        }
        return RestResult.success(registrations);
    }

    @Override
    public RestResult<String> approveSingle(RegistrationAuditDTO audit) {
        log.info("单条审核通过，报名记录ID: {}", audit.getRegistrationId());
        // 查找报名记录是否存在
        MeetingRegistration registration = registrationRepository.findById(audit.getRegistrationId()).orElse(null);
        if (registration == null) {
            return RestResult.error("000001", "报名记录不存在");
        }
        // 判断当前报名状态是否为待审核
        if (registration.getStatus() != 1) {
            return RestResult.error("000001", "当前报名状态不可审核");
        }
        // 更新报名状态为已通过
        // 状态2表示已通过
        registration.setStatus(2);
        registrationRepository.save(registration);
        // TODO: 这里应该生成通知消息，例如插入notification_info表等操作
        return RestResult.success("审核通过");
    }

    @Override
    public RestResult<String> rejectSingle(RegistrationAuditDTO audit) {
        log.info("单条审核拒绝，报名记录ID: {}", audit.getRegistrationId());
        // 查找报名记录是否存在
        MeetingRegistration registration = registrationRepository.findById(audit.getRegistrationId()).orElse(null);
        if (registration == null) {
            return RestResult.error("000001", "报名记录不存在");
        }
        // 判断当前报名状态是否为待审核
        if (registration.getStatus() != 1) {
            return RestResult.error("000001", "当前报名状态不可审核");
        }
        // 更新报名状态为已拒绝
        // 状态3表示已拒绝
        registration.setStatus(3);
        registrationRepository.save(registration);
        // TODO: 这里应该生成通知消息，例如插入notification_info表等操作
        return RestResult.success("审核拒绝");
    }

    @Override
    public RestResult<String> approveBatch(RegistrationAuditDTO audit) {
        log.info("批量审核通过，报名记录IDs: {}", audit.getRegistrationIds());
        if (audit.getRegistrationIds() == null || audit.getRegistrationIds().isEmpty()) {
            return RestResult.error("000001", "部分报名记录无法审核");
        }
        // 检查所有报名记录都处于待审核状态
        List<Long> invalidIds = new ArrayList<>();
        for (Long id : audit.getRegistrationIds()) {
            if (!registrationRepository.isPendingReview(id)) {
                invalidIds.add(id);
            }
        }
        if (!invalidIds.isEmpty()) {
            return RestResult.error("000001", "部分报名记录无法审核");
        }
        // 将符合条件的报名记录全部更新为已通过状态
        // 状态2表示已通过
        registrationRepository.batchUpdateStatus(audit.getRegistrationIds(), 2);
        return RestResult.success("批量审核通过完成");
    }

    @Override
    public RestResult<String> rejectBatch(RegistrationAuditDTO audit) {
        log.info("批量审核拒绝，报名记录IDs: {}", audit.getRegistrationIds());
        if (audit.getRegistrationIds() == null || audit.getRegistrationIds().isEmpty()) {
            return RestResult.error("000001", "部分报名记录无法审核");
        }
        // 检查所有报名记录都处于待审核状态
        List<Long> invalidIds = new ArrayList<>();
        for (Long id : audit.getRegistrationIds()) {
            if (!registrationRepository.isPendingReview(id)) {
                invalidIds.add(id);
            }
        }
        if (!invalidIds.isEmpty()) {
            return RestResult.error("000001", "部分报名记录无法审核");
        }
        // 将符合条件的报名记录全部更新为已拒绝状态
        // 状态3表示已拒绝
        registrationRepository.batchUpdateStatus(audit.getRegistrationIds(), 3);
        return RestResult.success("批量审核拒绝完成");
    }
}
