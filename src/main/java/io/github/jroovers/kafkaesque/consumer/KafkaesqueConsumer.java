package io.github.jroovers.kafkaesque.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaesqueConsumer {

    int count = 0;

    public static void main(String[] args) {
        SpringApplication.run(KafkaesqueConsumer.class, args);
    }

    @KafkaListener(topics = "demo", groupId = "kafkaesqueGrp1")
    public void listenGroupFoo1(String message) {
        count++;
        if (count % 100000 == 0) {
            System.out.println("Received " + count + "th Message in group kafkaesqueGrp1: " + message);
        }
    }

}
