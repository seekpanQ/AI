package com.toastmasters.meeting.notification.service.impl;

import com.toastmasters.meeting.common.RestResult;
import com.toastmasters.meeting.notification.dto.NotificationDTO;
import com.toastmasters.meeting.notification.entity.NotificationDO;
import com.toastmasters.meeting.notification.repository.NotificationRepository;
import com.toastmasters.meeting.notification.service.NotificationService;
import com.toastmasters.meeting.notification.vo.NotificationVO;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *   通知服务实现类
 * </p>
 * @author seekpan
 */
@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void addNotification(NotificationDTO notificationDTO) {
        NotificationDO notificationDO = new NotificationDO();
        BeanUtils.copyProperties(notificationDTO, notificationDO);
        notificationRepository.save(notificationDO);
    }

    @Override
    public RestResult<Void> sendNotification(Long noticeId) {
        Optional<NotificationDO> optionalNotificationDO = notificationRepository.findById(noticeId);
        if (!optionalNotificationDO.isPresent()) {
            log.error("通知ID不存在: {}", noticeId);
            return RestResult.error("000001", "通知不存在");
        }

        NotificationDO notificationDO = optionalNotificationDO.get();
        if (notificationDO.getSendStatus() == 1) {
            log.error("通知已发送: {}", noticeId);
            return RestResult.error("000001", "通知已发送");
        }

        notificationDO.setSendStatus(1);
        notificationDO.setSendTime(new java.util.Date());
        notificationRepository.save(notificationDO);
        return RestResult.success(null);
    }

    @Override
    public RestResult<List<NotificationVO>> getNotificationList(int pageIndex, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        Page<NotificationDO> page = notificationRepository.findAll(pageRequest);
        List<NotificationVO> notificationVOList = page.getContent().stream()
                .map(notificationDO -> {
                    NotificationVO notificationVO = new NotificationVO();
                    BeanUtils.copyProperties(notificationDO, notificationVO);
                    return notificationVO;
                })
                .collect(Collectors.toList());
        return RestResult.success(notificationVOList);
    }

    @Override
    @Transactional
    public RestResult<Void> deleteNotification(Long noticeId) {
        Optional<NotificationDO> optionalNotificationDO = notificationRepository.findById(noticeId);
        if (!optionalNotificationDO.isPresent()) {
            log.error("通知ID不存在: {}", noticeId);
            return RestResult.error("000001", "通知不存在");
        }

        notificationRepository.deleteById(noticeId);
        return RestResult.success(null);
    }
}