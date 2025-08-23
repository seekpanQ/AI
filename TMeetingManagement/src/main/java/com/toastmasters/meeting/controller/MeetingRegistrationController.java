package com.toastmasters.meeting.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.CancelRegistrationDTO;
import com.toastmasters.meeting.dto.MeetingApplyDTO;
import com.toastmasters.meeting.dto.MyRegistrationQueryDTO;
import com.toastmasters.meeting.dto.MyRegistrationVO;
import com.toastmasters.meeting.dto.RegistrationDetailQueryDTO;
import com.toastmasters.meeting.dto.RegistrationDetailVO;
import com.toastmasters.meeting.service.MeetingRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import com.toastmasters.meeting.entity.MeetingRegistration;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *   会议报名控制层
 * </p>
 * @author seekpan
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/registration")
public class MeetingRegistrationController {

    @Autowired
    private MeetingRegistrationService registrationService;

    private final MeetingRegistrationService meetingRegistrationService;

    /**
     * 提交会议报名
     *
     * @param dto 提交会议报名请求参数
     * @return RestResult 结果
     */
    @PostMapping("/apply")
    public RestResult<String> applyForMeeting(@Valid @RequestBody MeetingApplyDTO dto) {
        return meetingRegistrationService.applyForMeeting(dto);
    }

    /**
     * 取消会议报名
     *
     * @param dto 取消会议报名请求参数
     * @return RestResult 结果
     */
    @PostMapping("/cancel")
    public RestResult<String> cancelRegistration(@Valid @RequestBody CancelRegistrationDTO dto) {
        return meetingRegistrationService.cancelRegistration(dto);
    }

    /**
     * 查询我的报名状态
     *
     * @param dto 查询我的报名状态请求参数
     * @return RestResult 结果
     */
    @PostMapping("/my-status")
    public RestResult<MyRegistrationVO> getMyRegistrationStatus(@Valid @RequestBody MyRegistrationQueryDTO dto) {
        return meetingRegistrationService.getMyRegistrationStatus(dto);
    }

    /**
     * 获取会议报名详情
     *
     * @param dto 获取会议报名详情请求参数
     * @return RestResult 结果
     */
    @PostMapping("/detail")
    public RestResult<RegistrationDetailVO> getRegistrationDetail(@Valid @RequestBody RegistrationDetailQueryDTO dto) {
        return meetingRegistrationService.getRegistrationDetail(dto);
    }

    /**
     * 获取待审核报名列表
     *
     * @param query 查询参数对象
     * @return RestResult 结果集
     */
    @PostMapping("/pending/list")
    public RestResult<List<MeetingRegistration>> getPendingRegistrations(@Valid @RequestBody RegistrationQueryDTO query) {
        log.info("请求获取待审核报名列表");
        return registrationService.getPendingRegistrations(query);
    }

    /**
     * 单条审核通过
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    @PutMapping("/approve/single")
    public RestResult<String> approveSingle(@Valid @RequestBody RegistrationAuditDTO audit) {
        log.info("请求单条审核通过");
        return registrationService.approveSingle(audit);
    }

    /**
     * 单条审核拒绝
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    @PutMapping("/reject/single")
    public RestResult<String> rejectSingle(@Valid @RequestBody RegistrationAuditDTO audit) {
        log.info("请求单条审核拒绝");
        return registrationService.rejectSingle(audit);
    }

    /**
     * 批量审核通过
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    @PutMapping("/approve/batch")
    public RestResult<String> approveBatch(@Valid @RequestBody RegistrationAuditDTO audit) {
        log.info("请求批量审核通过");
        return registrationService.approveBatch(audit);
    }

    /**
     * 批量审核拒绝
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    @PutMapping("/reject/batch")
    public RestResult<String> rejectBatch(@Valid @RequestBody RegistrationAuditDTO audit) {
        log.info("请求批量审核拒绝");
        return registrationService.rejectBatch(audit);
    }
}
