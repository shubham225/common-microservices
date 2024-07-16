package com.utilities.notification.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnabledChannels {
    private boolean email;
    private boolean sms;
    private boolean inApp;
}
