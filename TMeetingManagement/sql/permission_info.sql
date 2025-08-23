
CREATE TABLE permission_info (
    permission_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '权限唯一标识',
    permission_name VARCHAR(100) NOT NULL UNIQUE COMMENT '权限名称',
    permission_code VARCHAR(100) NOT NULL UNIQUE COMMENT '权限编码',
    description TEXT COMMENT '权限描述',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by BIGINT COMMENT '修改人ID',
    update_time DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='权限信息表';