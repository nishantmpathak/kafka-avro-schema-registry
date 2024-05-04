package com.example.javatechie.producer;

import com.example.javatechie.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaAvroProducer {

    @Autowired
    KafkaTemplate<String, Employee> template;

    @Value("${topic.name}")
    private String topicName;

    public void send(Employee employee){
        var future = template.send(topicName, UUID.randomUUID().toString(), employee);
        future.whenComplete((result, ex) -> {
            if(ex == null){
                System.out.println("sent a message ["+employee.toString()+"] with offset = ["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unable to sent a message ["+employee.toString()+"] due to :"+ex.getMessage());
            }
        });
    }
}
