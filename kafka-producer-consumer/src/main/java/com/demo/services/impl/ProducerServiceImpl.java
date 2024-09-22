package com.demo.services.impl;

import com.demo.services.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<String, Object> template;

    public ProducerServiceImpl(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    public void sendMessage(String topic, String message) {
        for(int i = 0; i < 10000; i++) {
            CompletableFuture<SendResult<String, Object>> future = template.send(topic, message + " - " + Integer.toString(i));

            future.whenComplete((result, ex) -> {
                if (ex != null)
                    log.error("Error : {}", ex.getMessage());
            });
        }
    }
}
