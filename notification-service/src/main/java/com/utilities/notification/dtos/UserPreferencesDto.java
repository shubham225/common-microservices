package com.utilities.notification.dtos;

import com.utilities.notification.models.Preferences;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class UserPreferencesDto {
    private UUID                userId;
    private List<Preferences>   preferences;
}
