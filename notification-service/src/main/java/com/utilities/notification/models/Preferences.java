package com.utilities.notification.models;

import com.utilities.notification.enums.NotificationType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Preferences {
    private NotificationType notificationType;
    private EnabledChannels enabledChannels;
}
