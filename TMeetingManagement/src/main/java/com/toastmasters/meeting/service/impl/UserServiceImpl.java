package com.toastmasters.meeting.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.dto.*;
import com.toastmasters.meeting.dto.LoginDto;
import com.toastmasters.meeting.dto.ModifyProfileDto;
import com.toastmasters.meeting.dto.ModifyStatusDto;
import com.toastmasters.meeting.dto.QueryUserDto;
import com.toastmasters.meeting.dto.RegisterDto;
import com.toastmasters.meeting.dto.ResetPasswordDto;
import com.toastmasters.meeting.entity.UserInfo;
import com.toastmasters.meeting.repository.UserInfoRepository;
import com.toastmasters.meeting.service.UserService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   用户服务实现类
 * </p>
 * @author seekpan
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;

    /**
     * 用户注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    @Override
    public RestResult<?> register(RegisterDto registerDto) {
        log.info("开始用户注册，用户名={}", registerDto.getUsername());

        // 检查用户名是否已存在
        if (userInfoRepository.existsByUsername(registerDto.getUsername())) {
            return RestResult.error("000001", "用户名已存在");
        }

        try {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(registerDto, userInfo);
            userInfo.setStatus(1); // 默认启用账户
            userInfo.setCreateTime(LocalDateTime.now());
            userInfo.setUpdateTime(LocalDateTime.now());

            // TODO: 加密密码
            userInfo.setPassword(registerDto.getPassword()); // 此处仅为演示，实际应进行加密处理

            userInfoRepository.save(userInfo);
            log.info("用户注册成功，userId={}", userInfo.getUserId());
            return RestResult.success(userInfo);
        } catch (Exception e) {
            log.error("用户注册失败，用户名={}", registerDto.getUsername(), e);
            return RestResult.error("999999", "系统异常");
        }
    }

    /**
     * 用户登录
     *
     * @param loginDto 登录参数
     * @return RestResult
     */
    @Override
    public RestResult<?> login(LoginDto loginDto) {
        log.info("开始用户登录，用户名={}", loginDto.getUsername());

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByUsername(loginDto.getUsername());
        if (!optionalUserInfo.isPresent()) {
            return RestResult.error("000001", "用户不存在");
        }

        UserInfo userInfo = optionalUserInfo.get();

        // TODO: 密码校验需使用加密算法比对
        if (!loginDto.getPassword().equals(userInfo.getPassword())) {
            return RestResult.error("000001", "密码错误");
        }

        log.info("用户登录成功，userId={}", userInfo.getUserId());
        return RestResult.success(userInfo);
    }

    /**
     * 修改个人信息
     *
     * @param modifyProfileDto 修改个人资料参数
     * @return RestResult
     */
    @Override
    public RestResult<?> modifyProfile(ModifyProfileDto modifyProfileDto) {
        log.info("开始修改用户信息，userId={}", modifyProfileDto.getUserId());

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(modifyProfileDto.getUserId());
        if (!optionalUserInfo.isPresent()) {
            return RestResult.error("000001", "用户信息不存在");
        }

        UserInfo userInfo = optionalUserInfo.get();
        BeanUtils.copyProperties(modifyProfileDto, userInfo);
        userInfo.setUpdateTime(LocalDateTime.now());

        try {
            userInfoRepository.save(userInfo);
            log.info("修改用户信息成功，userId={}", userInfo.getUserId());
            return RestResult.success(userInfo);
        } catch (Exception e) {
            log.error("修改用户信息失败，userId={}", userInfo.getUserId(), e);
            return RestResult.error("999999", "系统异常");
        }
    }

    /**
     * 修改用户状态
     *
     * @param modifyStatusDto 修改用户状态参数
     * @return RestResult
     */
    @Override
    public RestResult<?> modifyStatus(ModifyStatusDto modifyStatusDto) {
        log.info("开始修改用户状态，userId={}, status={}", modifyStatusDto.getUserId(), modifyStatusDto.getStatus());

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(modifyStatusDto.getUserId());
        if (!optionalUserInfo.isPresent()) {
            return RestResult.error("000001", "用户信息不存在");
        }

        UserInfo userInfo = optionalUserInfo.get();
        userInfo.setStatus(modifyStatusDto.getStatus());
        userInfo.setUpdateTime(LocalDateTime.now());

        try {
            userInfoRepository.save(userInfo);
            log.info("修改用户状态成功，userId={}", userInfo.getUserId());
            return RestResult.success(userInfo);
        } catch (Exception e) {
            log.error("修改用户状态失败，userId={}", userInfo.getUserId(), e);
            return RestResult.error("999999", "系统异常");
        }
    }

    /**
     * 重置密码
     *
     * @param resetPasswordDto 重置密码参数
     * @return RestResult
     */
    @Override
    public RestResult<?> resetPassword(ResetPasswordDto resetPasswordDto) {
        log.info("开始重置用户密码，userId={}", resetPasswordDto.getUserId());

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(resetPasswordDto.getUserId());
        if (!optionalUserInfo.isPresent()) {
            return RestResult.error("000001", "用户信息不存在");
        }

        UserInfo userInfo = optionalUserInfo.get();

        // TODO: 密码校验需使用加密算法比对
        if (!resetPasswordDto.getOldPassword().equals(userInfo.getPassword())) {
            return RestResult.error("000001", "原密码不正确");
        }

        // TODO: 新密码需要加密后再保存
        userInfo.setPassword(resetPasswordDto.getNewPassword());
        userInfo.setUpdateTime(LocalDateTime.now());

        try {
            userInfoRepository.save(userInfo);
            log.info("重置用户密码成功，userId={}", userInfo.getUserId());
            return RestResult.success(userInfo);
        } catch (Exception e) {
            log.error("重置用户密码失败，userId={}", userInfo.getUserId(), e);
            return RestResult.error("999999", "系统异常");
        }
    }

    /**
     * 查询用户详情
     *
     * @param queryUserDto 查询用户参数
     * @return RestResult
     */
    @Override
    public RestResult<?> getUserDetail(QueryUserDto queryUserDto) {
        log.info("开始查询用户详情，userId={}", queryUserDto.getUserId());

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(queryUserDto.getUserId());
        if (!optionalUserInfo.isPresent()) {
            return RestResult.error("000001", "用户信息不存在");
        }

        log.info("查询用户详情成功，userId={}", queryUserDto.getUserId());
        return RestResult.success(optionalUserInfo.get());
    }
}