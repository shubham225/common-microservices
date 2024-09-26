package com.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface ProducerService {
    public void sendMessage(String topic, String message);
}
