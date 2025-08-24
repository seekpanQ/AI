package com.toastmasters.member.controller;


import com.toastmasters.member.common.RestResult;
import com.toastmasters.member.dto.RegisterDto;
import com.toastmasters.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员控制器
 * </p>
 *
 * @author seekpan
 */
@Slf4j
@RestController
@RequestMapping("/member")
@Tag(name = "会员信息管理接口", description = "提供会员信息的增删改查操作")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 会员注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    @PostMapping("/register")
    @Operation(summary = "会员注册", description = "根据传入的注册参数注册新会员")
    public RestResult<?> register(
            @Parameter(description = "注册会员请求参数", required = true)
            @Valid @RequestBody RegisterDto registerDto) {
        log.info("会员注册请求: {}", registerDto);
        return memberService.register(registerDto);
    }

//    /**
//     * 用户登录
//     *
//     * @param loginDto 登录参数
//     * @return RestResult
//     */
//    @PostMapping("/login")
//    public RestResult<?> login(@Valid @RequestBody LoginDto loginDto) {
//        return userService.login(loginDto);
//    }
//
//    /**
//     * 修改个人信息
//     *
//     * @param modifyProfileDto 修改个人资料参数
//     * @return RestResult
//     */
//    @PutMapping("/profile")
//    public RestResult<?> modifyProfile(@Valid @RequestBody ModifyProfileDto modifyProfileDto) {
//        return userService.modifyProfile(modifyProfileDto);
//    }
//
//    /**
//     * 修改用户状态
//     *
//     * @param modifyStatusDto 修改用户状态参数
//     * @return RestResult
//     */
//    @PutMapping("/status")
//    public RestResult<?> modifyStatus(@Valid @RequestBody ModifyStatusDto modifyStatusDto) {
//        return userService.modifyStatus(modifyStatusDto);
//    }
//
//    /**
//     * 重置密码
//     *
//     * @param resetPasswordDto 重置密码参数
//     * @return RestResult
//     */
//    @PutMapping("/password/reset")
//    public RestResult<?> resetPassword(@Valid @RequestBody ResetPasswordDto resetPasswordDto) {
//        return userService.resetPassword(resetPasswordDto);
//    }
//
//    /**
//     * 查询用户详情
//     *
//     * @param queryUserDto 查询用户参数
//     * @return RestResult
//     */
//    @GetMapping("/detail")
//    public RestResult<?> getUserDetail(@Valid QueryUserDto queryUserDto) {
//        return userService.getUserDetail(queryUserDto);
//    }
}