
CREATE TABLE meeting_info (
      meeting_id BIGINT PRIMARY KEY COMMENT '会议号',
      language CHAR(1) DEFAULT '1' COMMENT '会议语种：1-中文，0-英文',
      club_id CHAR(8) NOT NULL COMMENT '俱乐部NO.',
      title VARCHAR(200) NOT NULL COMMENT '会议标题',
      word_of_day VARCHAR(200) NOT NULL COMMENT '每日一词',
      content TEXT COMMENT '会议内容描述',
      start_time DATETIME COMMENT '开始时间',
      end_time DATETIME COMMENT '结束时间',
      location VARCHAR(255) COMMENT '会议地点',
      organizer CHAR(3) COMMENT '组织者ID',
      status TINYINT DEFAULT 1 COMMENT '会议状态：1-草稿，2-已发布，3-已结束，4-已取消',
      max_attendees INT COMMENT '最大参会人数',
      create_by CHAR(3) COMMENT '创建人ID',
      create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      update_by CHAR(3) COMMENT '修改人ID',
      update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='会议信息表';
