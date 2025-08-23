package com.toastmasters.meeting.dto;

import lombok.Data;

/**
 * <p>
 *   我的报名状态视图对象
 * </p>
 * @author seekpan
 */
@Data
public class MyRegistrationVO {

    /**
     * 是否已报名（0-未报名，1-已报名）
     */
    private Integer status;

    /**
     * 报名理由
     */
    private String applyReason;
}