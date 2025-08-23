
CREATE TABLE role_info (
    role_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '角色唯一标识',
    role_name VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
    description TEXT COMMENT '角色描述',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by BIGINT COMMENT '修改人ID',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='角色信息表';