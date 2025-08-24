package com.toastmasters.member.service.impl;

import com.toastmasters.member.common.RestResult;
import com.toastmasters.member.dto.RegisterDto;
import com.toastmasters.member.entity.MemberInfo;
import com.toastmasters.member.repository.MemberInfoRepository;
import com.toastmasters.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 会员服务实现类
 * </p>
 *
 * @author seekpan
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberInfoRepository memberInfoRepository;

    /**
     * 用户注册
     *
     * @param registerDto 注册参数
     * @return RestResult
     */
    @Override
    public RestResult<?> register(RegisterDto registerDto) {
        log.info("开始用户注册，会员ID={}，中文用户名={}，英文用户名={}", registerDto.getMemberId(),
                registerDto.getCnName(), registerDto.getEnName());

        // 检查用户名是否已存在
        if (memberInfoRepository.findById(registerDto.getMemberId()).isPresent()) {
            return RestResult.error("000001", "会员已存在");
        }

        try {
            MemberInfo memberInfo = new MemberInfo();
            BeanUtils.copyProperties(registerDto, memberInfo);
            memberInfo.setStatus("1"); // 默认启用账户
            memberInfo.setCreateTime(LocalDateTime.now());
            memberInfo.setUpdateTime(LocalDateTime.now());
            memberInfo.setCreateBy("001");
            memberInfo.setUpdateBy("001");
            memberInfoRepository.save(memberInfo);
            log.info("用户注册成功，memberId={}", memberInfo.getMemberId());
            return RestResult.success(memberInfo);
        } catch (Exception e) {
            log.error("用户注册失败，memberId={}", registerDto.getMemberId(), e);
            return RestResult.error("999999", "系统异常");
        }
    }

}