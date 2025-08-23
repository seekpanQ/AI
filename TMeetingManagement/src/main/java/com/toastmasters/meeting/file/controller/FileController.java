package com.toastmasters.meeting.file.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.file.dto.FileDeleteDTO;
import com.toastmasters.meeting.file.dto.FileDownloadDTO;
import com.toastmasters.meeting.file.dto.FileUploadDTO;
import com.toastmasters.meeting.file.service.FileService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   文件控制器
 * </p>
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传文件接口
     *
     * @param fileUploadDTO 文件上传信息
     * @return 统一响应结果
     */
    @PostMapping("/upload")
    public RestResult<?> uploadFile(@Valid @RequestBody FileUploadDTO fileUploadDTO) {
        log.info("收到上传文件请求");
        return fileService.uploadFile(fileUploadDTO);
    }

    /**
     * 下载文件接口
     *
     * @param fileDownloadDTO 文件下载信息
     * @return 统一响应结果
     */
    @GetMapping("/download")
    public RestResult<?> downloadFile(@Valid FileDownloadDTO fileDownloadDTO) {
        log.info("收到下载文件请求");
        return fileService.downloadFile(fileDownloadDTO);
    }

    /**
     * 删除文件接口
     *
     * @param fileDeleteDTO 文件删除信息
     * @return 统一响应结果
     */
    @DeleteMapping("/delete")
    public RestResult<?> deleteFile(@Valid @RequestBody FileDeleteDTO fileDeleteDTO) {
        log.info("收到删除文件请求");
        return fileService.deleteFile(fileDeleteDTO);
    }
}