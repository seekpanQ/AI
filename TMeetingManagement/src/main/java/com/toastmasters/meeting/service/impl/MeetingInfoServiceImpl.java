package com.toastmasters.meeting.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.CreateMeetingRequest;
import com.toastmasters.meeting.dto.DeleteMeetingRequest;
import com.toastmasters.meeting.dto.EditMeetingRequest;
import com.toastmasters.meeting.dto.GetMeetingDetailRequest;
import com.toastmasters.meeting.dto.UpdateMeetingStatusRequest;
import com.toastmasters.meeting.entity.MeetingInfo;
import com.toastmasters.meeting.repository.MeetingInfoRepository;
import com.toastmasters.meeting.service.MeetingInfoService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *   会议信息服务实现类
 * </p>
 * @author seekpan
 */
@Slf4j
@Service
@Transactional
public class MeetingInfoServiceImpl implements MeetingInfoService {

    @Autowired
    private MeetingInfoRepository meetingInfoRepository;

    /**
     * 创建会议
     * @param request 创建会议请求参数
     * @return 统一响应结果
     */
    @Override
    public RestResult<Object> createMeeting(@Valid CreateMeetingRequest request) {
        // 校验会议标题是否为空
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            return RestResult.error("000001", "会议标题不能为空");
        }

        // 构建会议实体对象
        MeetingInfo meetingInfo = new MeetingInfo();
        BeanUtils.copyProperties(request, meetingInfo);
        meetingInfo.setCreateTime(LocalDateTime.now());
        meetingInfo.setUpdateTime(LocalDateTime.now());

        // 保存到数据库
        meetingInfo = meetingInfoRepository.save(meetingInfo);

        return RestResult.success(meetingInfo);
    }

    /**
     * 编辑会议
     * @param request 编辑会议请求参数
     * @return 统一响应结果
     */
    @Override
    public RestResult<Object> editMeeting(@Valid EditMeetingRequest request) {
        // 判断会议是否存在
        MeetingInfo meetingInfo = meetingInfoRepository.findById(request.getMeetingId()).orElse(null);
        if (meetingInfo == null) {
            return RestResult.error("000001", "会议不存在");
        }

        // 更新会议信息
        BeanUtils.copyProperties(request, meetingInfo);
        meetingInfo.setUpdateTime(LocalDateTime.now());
        
        // 保存更新后的记录
        meetingInfo = meetingInfoRepository.save(meetingInfo);

        return RestResult.success(meetingInfo);
    }

    /**
     * 删除会议
     * @param request 删除会议请求参数
     * @return 统一响应结果
     */
    @Override
    public RestResult<Object> deleteMeeting(@Valid DeleteMeetingRequest request) {
        // 判断会议是否存在
        MeetingInfo meetingInfo = meetingInfoRepository.findById(request.getMeetingId()).orElse(null);
        if (meetingInfo == null) {
            return RestResult.error("000001", "会议不存在");
        }

        // 删除会议记录
        meetingInfoRepository.deleteById(request.getMeetingId());

        return RestResult.success(null);
    }

    /**
     * 更新会议状态
     * @param request 更新会议状态请求参数
     * @return 统一响应结果
     */
    @Override
    public RestResult<Object> updateMeetingStatus(@Valid UpdateMeetingStatusRequest request) {
        // 判断会议是否存在
        MeetingInfo meetingInfo = meetingInfoRepository.findById(request.getMeetingId()).orElse(null);
        if (meetingInfo == null) {
            return RestResult.error("000001", "会议不存在");
        }

        // 更新会议状态字段
        meetingInfo.setStatus(request.getStatus());
        meetingInfo.setUpdateTime(LocalDateTime.now());

        // 保存更新后的记录
        meetingInfo = meetingInfoRepository.save(meetingInfo);

        return RestResult.success(meetingInfo);
    }

    /**
     * 获取会议详情
     * @param request 获取会议详情请求参数
     * @return 统一响应结果
     */
    @Override
    public RestResult<Object> getMeetingDetail(@Valid GetMeetingDetailRequest request) {
        // 判断会议是否存在
        MeetingInfo meetingInfo = meetingInfoRepository.findById(request.getMeetingId()).orElse(null);
        if (meetingInfo == null) {
            return RestResult.error("000001", "会议不存在");
        }

        return RestResult.success(meetingInfo);
    }
}