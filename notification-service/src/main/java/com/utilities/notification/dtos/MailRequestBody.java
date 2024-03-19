package com.utilities.notification.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MailRequestBody {
    private String receiver;
    private String cc;
    private String body;
}
