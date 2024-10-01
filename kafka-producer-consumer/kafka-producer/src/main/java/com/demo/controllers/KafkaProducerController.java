package com.demo.controllers;
import com.demo.services.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publish")
public class KafkaProducerController {
    private final ProducerService producerService;

    public KafkaProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/alert"
    )
    public ResponseEntity<String> sendMessageToKafka(@RequestBody String message) {
        producerService.sendMessage("AlertTopic", message);
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/log"
    )
    public ResponseEntity<String> sendLogsToKafka(@RequestBody String message) {
        producerService.sendMessage("LogTopic", message);
        return ResponseEntity.ok("OK");
    }
}
