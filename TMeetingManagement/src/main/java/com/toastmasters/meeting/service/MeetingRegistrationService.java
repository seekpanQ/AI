package com.toastmasters.meeting.service;

import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.CancelRegistrationDTO;
import com.toastmasters.meeting.dto.MeetingApplyDTO;
import com.toastmasters.meeting.dto.MyRegistrationQueryDTO;
import com.toastmasters.meeting.dto.MyRegistrationVO;
import com.toastmasters.meeting.dto.RegistrationDetailQueryDTO;
import com.toastmasters.meeting.dto.RegistrationDetailVO;
import java.util.List;
import com.toastmasters.meeting.entity.MeetingRegistration;
import com.toastmasters.meeting.common.RestResult;

/**
 * <p>
 *   会议报名服务接口
 * </p>
 * @author seekpan
 */
public interface MeetingRegistrationService {

    /**
     * 提交会议报名
     *
     * @param dto 提交会议报名请求参数
     * @return RestResult 结果
     */
    com.toastmasters.meeting.common.RestResult<String> applyForMeeting(MeetingApplyDTO dto);

    /**
     * 取消会议报名
     *
     * @param dto 取消会议报名请求参数
     * @return RestResult 结果
     */
    com.toastmasters.meeting.common.RestResult<String> cancelRegistration(CancelRegistrationDTO dto);

    /**
     * 查询我的报名状态
     *
     * @param dto 查询我的报名状态请求参数
     * @return RestResult 结果
     */
    com.toastmasters.meeting.common.RestResult<MyRegistrationVO> getMyRegistrationStatus(MyRegistrationQueryDTO dto);

    /**
     * 获取会议报名详情
     *
     * @param dto 获取会议报名详情请求参数
     * @return RestResult 结果
     */
    com.toastmasters.meeting.common.RestResult<RegistrationDetailVO> getRegistrationDetail(RegistrationDetailQueryDTO dto);

    /**
     * 获取待审核报名列表
     *
     * @param query 查询参数对象
     * @return RestResult 结果集
     */
    RestResult<List<MeetingRegistration>> getPendingRegistrations(RegistrationQueryDTO query);

    /**
     * 单条审核通过
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    RestResult<String> approveSingle(RegistrationAuditDTO audit);

    /**
     * 单条审核拒绝
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    RestResult<String> rejectSingle(RegistrationAuditDTO audit);

    /**
     * 批量审核通过
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    RestResult<String> approveBatch(RegistrationAuditDTO audit);

    /**
     * 批量审核拒绝
     *
     * @param audit 审核参数对象
     * @return RestResult 结果集
     */
    RestResult<String> rejectBatch(RegistrationAuditDTO audit);
}
