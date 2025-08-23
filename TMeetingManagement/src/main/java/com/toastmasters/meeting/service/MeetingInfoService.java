package com.toastmasters.meeting.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.CreateMeetingRequest;
import com.toastmasters.meeting.dto.DeleteMeetingRequest;
import com.toastmasters.meeting.dto.EditMeetingRequest;
import com.toastmasters.meeting.dto.GetMeetingDetailRequest;
import com.toastmasters.meeting.dto.UpdateMeetingStatusRequest;

/**
 * <p>
 *   会议信息服务接口
 * </p>
 * @author seekpan
 */
public interface MeetingInfoService {

    /**
     * 创建会议
     * @param request 创建会议请求参数
     * @return 统一响应结果
     */
    RestResult<Object> createMeeting(CreateMeetingRequest request);

    /**
     * 编辑会议
     * @param request 编辑会议请求参数
     * @return 统一响应结果
     */
    RestResult<Object> editMeeting(EditMeetingRequest request);

    /**
     * 删除会议
     * @param request 删除会议请求参数
     * @return 统一响应结果
     */
    RestResult<Object> deleteMeeting(DeleteMeetingRequest request);

    /**
     * 更新会议状态
     * @param request 更新会议状态请求参数
     * @return 统一响应结果
     */
    RestResult<Object> updateMeetingStatus(UpdateMeetingStatusRequest request);

    /**
     * 获取会议详情
     * @param request 获取会议详情请求参数
     * @return 统一响应结果
     */
    RestResult<Object> getMeetingDetail(GetMeetingDetailRequest request);
}