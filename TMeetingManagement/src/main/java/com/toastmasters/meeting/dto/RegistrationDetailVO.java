package com.toastmasters.meeting.dto;

import lombok.Data;

/**
 * <p>
 *   会议报名详情视图对象
 * </p>
 * @author seekpan
 */
@Data
public class RegistrationDetailVO {

    /**
     * 会议标题
     */
    private String meetingTitle;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 报名状态
     */
    private Integer status;

    /**
     * 报名理由
     */
    private String applyReason;

    /**
     * 附件路径
     */
    private String attachmentPath;
}