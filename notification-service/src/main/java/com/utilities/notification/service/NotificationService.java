package com.utilities.notification.service;

import com.utilities.notification.dto.MailRequestBody;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public String sendNotification(MailRequestBody mailRequestBody) {
        return "DUMMY";
    }
}
