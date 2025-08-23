
CREATE TABLE role_permission_relation (
    relation_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '关联关系唯一标识',
    role_id BIGINT NOT NULL COMMENT '角色ID',
    permission_id BIGINT NOT NULL COMMENT '权限ID',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='角色权限关联表';