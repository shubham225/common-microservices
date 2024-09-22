package com.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(
            topics = "LogTopic",
            groupId = "my-cons-group-1"
    )
    public void consumeLogs(String message) {
        log.info("ConsumerLog-1 Received Log message : {}", message);
    }

    @KafkaListener(
            topics = "LogTopic",
            groupId = "my-cons-group-1"
    )
    public void consumeLogs2(String message) {
        log.info("ConsumerLog-2 Received Log message : {}", message);
    }

    @KafkaListener(
            topics = "AlertTopic",
            groupId = "my-cons-group-1"
    )
    public void consumeAlerts(String message) {
        log.info("ConsumerAlert-1 Received Alert message : {}", message);
    }

    @KafkaListener(
            topics = "AlertTopic",
            groupId = "my-cons-group-1"
    )
    public void consumeAlerts2(String message) {
        log.info("ConsumerAlert-2 Received Alert message : {}", message);
    }

    @KafkaListener(
            topics = "AlertTopic",
            groupId = "my-cons-group-1"
    )
    public void consumeAlerts3(String message) {
        log.info("ConsumerAlert-3 Received Alert message : {}", message);
    }
}
