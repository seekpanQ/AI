package com.toastmasters.meeting.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.service.MeetingInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会议信息控制器
 * </p>
 *
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/meeting")
@Tag(name = "会议信息管理接口", description = "提供会议信息的增删改查操作")
public class MeetingInfoController {
    @Autowired
    private MeetingInfoService meetingInfoService;

    /**
     * 创建会议
     *
     * @param request 创建会议请求参数
     * @return 统一响应结果
     */
    @PostMapping("/create")
    @Operation(summary = "创建会议", description = "根据传入的会议信息创建新的会议")
    public RestResult<Object> createMeeting(
            @Parameter(description = "创建会议请求参数", required = true)
            @RequestBody @Valid CreateMeetingRequest request) {
        log.info("创建会议请求: {}", request);
        return meetingInfoService.createMeeting(request);
    }

    /**
     * 编辑会议
     *
     * @param request 编辑会议请求参数
     * @return 统一响应结果
     */
    @PostMapping("/edit")
    @Operation(summary = "编辑会议", description = "根据传入的会议信息编辑现有会议")
    public RestResult<Object> editMeeting(
            @Parameter(description = "编辑会议请求参数", required = true)
            @RequestBody @Valid EditMeetingRequest request) {
        log.info("编辑会议请求: {}", request);
        return meetingInfoService.editMeeting(request);
    }

    /**
     * 删除会议
     *
     * @param request 删除会议请求参数
     * @return 统一响应结果
     */
    @PostMapping("/delete")
    @Operation(summary = "删除会议", description = "根据传入的会议ID删除指定会议")
    public RestResult<Object> deleteMeeting(
            @Parameter(description = "删除会议请求参数", required = true)
            @RequestBody @Valid DeleteMeetingRequest request) {
        log.info("删除会议请求: {}", request);
        return meetingInfoService.deleteMeeting(request);
    }

    /**
     * 更新会议状态
     *
     * @param request 更新会议状态请求参数
     * @return 统一响应结果
     */
    @PostMapping("/updateStatus")
    @Operation(summary = "更新会议状态", description = "根据传入的会议ID和状态更新会议状态")
    public RestResult<Object> updateMeetingStatus(
            @Parameter(description = "更新会议状态请求参数", required = true)
            @RequestBody @Valid UpdateMeetingStatusRequest request) {
        log.info("更新会议状态请求: {}", request);
        return meetingInfoService.updateMeetingStatus(request);
    }

    /**
     * 获取会议详情
     *
     * @param request 获取会议详情请求参数
     * @return 统一响应结果
     */
    @PostMapping("/detail")
    @Operation(summary = "获取会议详情", description = "根据传入的会议ID获取会议详细信息")
    public RestResult<Object> getMeetingDetail(
            @Parameter(description = "获取会议详情请求参数", required = true)
            @RequestBody @Valid GetMeetingDetailRequest request) {
        log.info("获取会议详情请求: {}", request);
        return meetingInfoService.getMeetingDetail(request);
    }
}
