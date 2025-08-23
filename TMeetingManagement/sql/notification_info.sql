
CREATE TABLE notification_info (
    notice_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '通知唯一标识',
    title VARCHAR(200) NOT NULL COMMENT '通知标题',
    content TEXT NOT NULL COMMENT '通知内容',
    notice_type TINYINT COMMENT '通知类型：1-系统消息，2-会议提醒，3-重要通知',
    target_user_ids TEXT COMMENT '目标用户列表（JSON格式）',
    send_status TINYINT DEFAULT 0 COMMENT '发送状态：0-未发送，1-已发送',
    send_time DATETIME COMMENT '发送时间',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='通知信息表';