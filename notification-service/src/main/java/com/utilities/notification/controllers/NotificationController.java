package com.utilities.notification.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/notify")
public class NotificationController {

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String sendNotification() {
        return "Dummy Response";
    }
}
