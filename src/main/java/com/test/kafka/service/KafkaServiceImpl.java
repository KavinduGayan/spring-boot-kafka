package com.test.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("test-topic",message);
    }
}
