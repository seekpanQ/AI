package com.toastmasters.meeting.file.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *   文件资源实体类
 * </p>
 * @author seekpan
 */
@Entity
@Table(name = "file_resource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResource {

    /**
     * 文件唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    /**
     * 原始文件名
     */
    private String originalName;

    /**
     * 存储路径
     */
    private String storagePath;

    /**
     * 文件大小（字节）
     */
    private Long fileSize;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 上传用户ID
     */
    private Long uploadUserId;

    /**
     * 关联会议ID
     */
    private Long relatedMeetingId;

    /**
     * 关联报名记录ID
     */
    private Long relatedRegistrationId;

    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}