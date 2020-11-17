package com.example.miniproject.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic1",groupId = "group_id_1")
    void consumeMsg(String msg){
        System.out.println(msg);
    }
}
