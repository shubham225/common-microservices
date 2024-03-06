package com.utilities.notification.controller;

import com.utilities.notification.dto.MailRequestBody;
import com.utilities.notification.service.NotificationService;
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
    public String sendNotification(@RequestBody MailRequestBody mailRequestBody) {
        return notificationService.sendNotification(mailRequestBody);
    }

}
