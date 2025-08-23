
CREATE TABLE file_resource (
    file_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '文件唯一标识',
    original_name VARCHAR(255) NOT NULL COMMENT '原始文件名',
    storage_path VARCHAR(500) NOT NULL COMMENT '存储路径',
    file_size BIGINT COMMENT '文件大小（字节）',
    file_type VARCHAR(50) COMMENT '文件类型',
    upload_user_id BIGINT COMMENT '上传用户ID',
    related_meeting_id BIGINT COMMENT '关联会议ID',
    related_registration_id BIGINT COMMENT '关联报名记录ID',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='文件资源表';