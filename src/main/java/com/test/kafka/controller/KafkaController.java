package com.test.kafka.controller;

import com.test.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/v1")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("send/{message}")
    public ResponseEntity getMessage(@PathVariable("message") String message) {
        kafkaService.sendMessage(message);
        return ResponseEntity.ok().build();
    }

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

}
