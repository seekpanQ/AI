package com.toastmasters.meeting.file.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.file.dto.FileDeleteDTO;
import com.toastmasters.meeting.file.dto.FileDownloadDTO;
import com.toastmasters.meeting.file.dto.FileUploadDTO;

/**
 * <p>
 *   文件服务接口
 * </p>
 * @author seekpan
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param fileUploadDTO 文件上传信息
     * @return 统一响应结果
     */
    RestResult<?> uploadFile(FileUploadDTO fileUploadDTO);

    /**
     * 下载文件
     *
     * @param fileDownloadDTO 文件下载信息
     * @return 统一响应结果
     */
    RestResult<?> downloadFile(FileDownloadDTO fileDownloadDTO);

    /**
     * 删除文件
     *
     * @param fileDeleteDTO 文件删除信息
     * @return 统一响应结果
     */
    RestResult<?> deleteFile(FileDeleteDTO fileDeleteDTO);
}