
CREATE TABLE meeting_registration (
    registration_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '报名记录唯一标识',
    meeting_id BIGINT NOT NULL COMMENT '会议ID',
    user_id BIGINT NOT NULL COMMENT '报名用户ID',
    status TINYINT DEFAULT 1 COMMENT '报名状态：1-待审核，2-已通过，3-已拒绝，4-已取消',
    apply_reason TEXT COMMENT '报名理由',
    attachment_path VARCHAR(255) COMMENT '附件路径',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by BIGINT COMMENT '修改人ID',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='会议报名表';