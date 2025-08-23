package com.toastmasters.meeting.file.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   文件上传请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class FileUploadDTO {

    /**
     * 原始文件名
     */
    @NotBlank(message = "原始文件名不能为空")
    private String originalName;

    /**
     * 文件类型
     */
    @NotBlank(message = "文件类型不能为空")
    private String fileType;

    /**
     * 文件大小（字节）
     */
    @NotNull(message = "文件大小不能为空")
    private Long fileSize;

    /**
     * 上传用户ID
     */
    @NotNull(message = "上传用户ID不能为空")
    private Long uploadUserId;

    /**
     * 关联会议ID（可选）
     */
    private Long relatedMeetingId;

    /**
     * 关联报名记录ID（可选）
     */
    private Long relatedRegistrationId;
}