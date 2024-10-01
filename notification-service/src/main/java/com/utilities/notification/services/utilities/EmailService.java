package com.utilities.notification.services.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${sender.email}")
    private String fromMailId;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to,
                         String cc,
                         String subject,
                         String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMailId);
        message.setTo(to);
        message.setCc(cc);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }
}
