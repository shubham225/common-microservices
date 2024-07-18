package com.utilities.notification.models;

import com.utilities.notification.enums.NotificationType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Preferences {
    private UUID                userId;
    private NotificationType    notificationType;
    private boolean             email;
    private boolean             sms;
    private boolean             inApp;
}
