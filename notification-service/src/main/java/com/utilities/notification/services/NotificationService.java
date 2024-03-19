package com.utilities.notification.services;

import com.utilities.notification.dtos.MailRequestBody;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public String sendNotification(MailRequestBody mailRequestBody) {
        return "DUMMY";
    }
}
