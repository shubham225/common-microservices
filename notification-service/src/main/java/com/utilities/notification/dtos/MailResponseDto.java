package com.utilities.notification.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailResponseDto {
    private String status;
    public MailResponseDto() {}
    public MailResponseDto(String status) {
        this.status = status;
    }
}
