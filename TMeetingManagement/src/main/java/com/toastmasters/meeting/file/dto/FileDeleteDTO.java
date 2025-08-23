package com.toastmasters.meeting.file.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>
 *   文件删除请求参数对象
 * </p>
 * @author seekpan
 */
@Data
public class FileDeleteDTO {

    /**
     * 文件ID
     */
    @NotNull(message = "文件ID不能为空")
    private Long fileId;
}