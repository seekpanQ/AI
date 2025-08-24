package com.toastmasters.member.service;


import com.toastmasters.member.common.RestResult;
import com.toastmasters.member.dto.RegisterDto;

/**
 * <p>
 * 会员服务接口
 * </p>
 *
 * @author seekpan
 */
public interface MemberService {

    /**
     * 会员注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    RestResult<?> register(RegisterDto registerDto);

}