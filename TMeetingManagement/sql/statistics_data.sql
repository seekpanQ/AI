
CREATE TABLE statistics_data (
    stat_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '统计数据唯一标识',
    stat_date DATE COMMENT '统计日期',
    meeting_count INT DEFAULT 0 COMMENT '会议数量',
    registration_count INT DEFAULT 0 COMMENT '报名总数',
    approved_count INT DEFAULT 0 COMMENT '审核通过数',
    rejected_count INT DEFAULT 0 COMMENT '审核拒绝数',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='数据统计表';