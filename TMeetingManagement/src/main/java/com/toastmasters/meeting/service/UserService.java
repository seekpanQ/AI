package com.toastmasters.meeting.service;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.LoginDto;
import com.toastmasters.meeting.dto.ModifyProfileDto;
import com.toastmasters.meeting.dto.ModifyStatusDto;
import com.toastmasters.meeting.dto.QueryUserDto;
import com.toastmasters.meeting.dto.RegisterDto;
import com.toastmasters.meeting.dto.ResetPasswordDto;

/**
 * <p>
 *   用户服务接口
 * </p>
 * @author seekpan
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    RestResult<?> register(RegisterDto registerDto);

    /**
     * 用户登录
     *
     * @param loginDto 登录参数
     * @return RestResult
     */
    RestResult<?> login(LoginDto loginDto);

    /**
     * 修改个人信息
     *
     * @param modifyProfileDto 修改个人资料参数
     * @return RestResult
     */
    RestResult<?> modifyProfile(ModifyProfileDto modifyProfileDto);

    /**
     * 修改用户状态
     *
     * @param modifyStatusDto 修改用户状态参数
     * @return RestResult
     */
    RestResult<?> modifyStatus(ModifyStatusDto modifyStatusDto);

    /**
     * 重置密码
     *
     * @param resetPasswordDto 重置密码参数
     * @return RestResult
     */
    RestResult<?> resetPassword(ResetPasswordDto resetPasswordDto);

    /**
     * 查询用户详情
     *
     * @param queryUserDto 查询用户参数
     * @return RestResult
     */
    RestResult<?> getUserDetail(QueryUserDto queryUserDto);
}