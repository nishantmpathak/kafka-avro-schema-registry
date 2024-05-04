package com.example.javatechie.controller;

import com.example.javatechie.model.Employee;
import com.example.javatechie.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaAvroProducer kafkaAvroProducer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee){
        kafkaAvroProducer.send(employee);
        return "message published";
    }
}
