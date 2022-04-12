package io.github.jroovers.kafkaesque.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class KafkaesqueConsumer {

    int count = 0;

    public static void main(String[] args) {
        SpringApplication.run(KafkaesqueConsumer.class, args);
    }

    @KafkaListener(topics = "demo", groupId = "kafkaesqueGrp1", concurrency = "${consumer.threads}")
    public void listenGroupFoo1(String message) {
        count++;
        if (count % 100000 == 0) {
            log.info("{}th Message in group kafkaesqueGrp1: {}", count, message);
        }
    }

}
