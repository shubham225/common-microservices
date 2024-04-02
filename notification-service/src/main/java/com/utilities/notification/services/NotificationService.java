package com.utilities.notification.services;

import com.utilities.notification.dtos.MailRequestDto;
import com.utilities.notification.dtos.MailResponseDto;
import com.utilities.notification.services.utilities.EmailService;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public MailResponseDto sendNotification(MailRequestDto mailRequestDto) {
        emailService.sendMail(mailRequestDto.getTo(),
                              mailRequestDto.getCc(),
                              mailRequestDto.getSubject(),
                              mailRequestDto.getBody()
                            );
        MailResponseDto mailResponseDto = new MailResponseDto();
        mailResponseDto.setStatus("MAIL_SENT");
        return mailResponseDto;
    }
}
