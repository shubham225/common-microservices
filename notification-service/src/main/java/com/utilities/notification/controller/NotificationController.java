package com.utilities.notification.controller;

import com.utilities.notification.dto.MailRequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/notify")
public class NotificationController {

    @RequestMapping(
            method = RequestMethod.POST
    )
    public String sendNotification(@RequestBody MailRequestBody mailRequestBody) {
        return "Dummy Response";
    }

}
