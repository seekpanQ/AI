CREATE TABLE member_info (
     member_id CHAR(3) PRIMARY KEY COMMENT '会员ID',
     cn_name VARCHAR(50) NOT NULL UNIQUE COMMENT '中文用户名',
     en_name VARCHAR(50) NOT NULL UNIQUE COMMENT '英文用户名',
     password VARCHAR(50) NOT NULL COMMENT '用户密码（加密后）',
     email VARCHAR(100) COMMENT '用户邮箱',
     phone VARCHAR(20) COMMENT '手机号码',
     real_name VARCHAR(50) COMMENT '真实姓名',
     avatar_url VARCHAR(255) COMMENT '头像地址',
     status char(1) DEFAULT '1' COMMENT '账户状态：1-正常，0-失效',
     create_by CHAR(3) COMMENT '创建人ID',
     create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     update_by CHAR(3) COMMENT '修改人ID',
     update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='会员信息表';