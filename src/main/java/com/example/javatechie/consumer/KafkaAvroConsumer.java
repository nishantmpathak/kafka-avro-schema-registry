package com.example.javatechie.consumer;

import com.example.javatechie.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Employee> consumerRecord){
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        System.out.println("Avro message is received for key "+key+" value "+employee.toString());

    }
}
