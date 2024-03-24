package com.utilities.notification.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MailRequestBody {
    private String to;
    private String cc;
    private String subject;
    private String body;
}
