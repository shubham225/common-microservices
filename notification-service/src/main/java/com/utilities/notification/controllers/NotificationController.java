package com.utilities.notification.controllers;

import com.utilities.notification.dtos.MailRequestDto;
import com.utilities.notification.dtos.MailResponseDto;
import com.utilities.notification.services.NotificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/notify")
public class NotificationController {
    final private NotificationService notificationService;

    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public MailResponseDto sendNotification(@RequestBody MailRequestDto mailRequestDto) {
        return notificationService.sendNotification(mailRequestDto);
    }

}
