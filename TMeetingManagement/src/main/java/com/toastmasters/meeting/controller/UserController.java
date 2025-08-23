package com.toastmasters.meeting.controller;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.LoginDto;
import com.toastmasters.meeting.dto.ModifyProfileDto;
import com.toastmasters.meeting.dto.ModifyStatusDto;
import com.toastmasters.meeting.dto.QueryUserDto;
import com.toastmasters.meeting.dto.RegisterDto;
import com.toastmasters.meeting.dto.ResetPasswordDto;
import com.toastmasters.meeting.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *   用户控制器
 * </p>
 * @author seekpan
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 用户注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    @PostMapping("/register")
    public RestResult<?> register(@Valid @RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    /**
     * 用户登录
     *
     * @param loginDto 登录参数
     * @return RestResult
     */
    @PostMapping("/login")
    public RestResult<?> login(@Valid @RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    /**
     * 修改个人信息
     *
     * @param modifyProfileDto 修改个人资料参数
     * @return RestResult
     */
    @PutMapping("/profile")
    public RestResult<?> modifyProfile(@Valid @RequestBody ModifyProfileDto modifyProfileDto) {
        return userService.modifyProfile(modifyProfileDto);
    }

    /**
     * 修改用户状态
     *
     * @param modifyStatusDto 修改用户状态参数
     * @return RestResult
     */
    @PutMapping("/status")
    public RestResult<?> modifyStatus(@Valid @RequestBody ModifyStatusDto modifyStatusDto) {
        return userService.modifyStatus(modifyStatusDto);
    }

    /**
     * 重置密码
     *
     * @param resetPasswordDto 重置密码参数
     * @return RestResult
     */
    @PutMapping("/password/reset")
    public RestResult<?> resetPassword(@Valid @RequestBody ResetPasswordDto resetPasswordDto) {
        return userService.resetPassword(resetPasswordDto);
    }

    /**
     * 查询用户详情
     *
     * @param queryUserDto 查询用户参数
     * @return RestResult
     */
    @GetMapping("/detail")
    public RestResult<?> getUserDetail(@Valid QueryUserDto queryUserDto) {
        return userService.getUserDetail(queryUserDto);
    }
}