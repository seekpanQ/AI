
CREATE TABLE user_role_relation (
    relation_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '关联关系唯一标识',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    role_id BIGINT NOT NULL COMMENT '角色ID',
    create_by BIGINT COMMENT '创建人ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='用户角色关联表';