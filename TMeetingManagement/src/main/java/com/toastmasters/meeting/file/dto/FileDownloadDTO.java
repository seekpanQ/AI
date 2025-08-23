package com.toastmasters.meeting.file.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   文件下载请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class FileDownloadDTO {

    /**
     * 文件ID
     */
    @NotNull(message = "文件ID不能为空")
    private Long fileId;
}