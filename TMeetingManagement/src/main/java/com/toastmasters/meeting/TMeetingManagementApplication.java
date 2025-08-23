package com.toastmasters.meeting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author seekpan
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "头马会议管理系统", description = "对会议相关信息进行管理", version = "1.0.0"))
public class TMeetingManagementApplication {

    /**
     * 启动方法
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(TMeetingManagementApplication.class, args);
    }
}