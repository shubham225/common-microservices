package com.utilities.notification.services;

import com.utilities.notification.dtos.MailRequestBody;
import com.utilities.notification.services.utilities.EmailService;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public String sendNotification(MailRequestBody mailRequestBody) {
        emailService.sendMail(mailRequestBody.getTo(),
                              mailRequestBody.getCc(),
                              mailRequestBody.getSubject(),
                              mailRequestBody.getBody()
                            );
        return "DUMMY";
    }
}
