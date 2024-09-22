package com.demo.services.impl;

import com.demo.services.ProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<String, Object> template;

    public ProducerServiceImpl(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    public void sendMessage(String topic, String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send(topic, message);

        future.whenComplete((result, ex) -> {
            if(ex == null)
                System.out.println("Success : " + result);
            else
                System.out.println("Error : " + ex.getMessage());
        });
    }
}
