package io.github.jroovers.kafkaesque.producer;

import io.github.jroovers.kafkaesque.producer.service.MqPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.Executors;

@SpringBootApplication
public class KafkaesqueProducer implements CommandLineRunner {

    @Autowired
    MqPublisher mqPublisher;

    @Value("${producer.threads}")
    Integer threads = 1;

    @Value("${producer.messages}")
    Long totalMessages = 100000L;

    public static void main(String[] args) {
        SpringApplication.run(KafkaesqueProducer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendMessages();
    }

    public void sendMessages() {
        String uuid = UUID.randomUUID().toString();
        int threads = this.threads;
        long messageCount = totalMessages;

        if (threads < 1 || threads > 128) {
            throw new Error("too few or too many thread specified");
        }

        var pool = Executors.newFixedThreadPool(threads);
        final long messagesPerThread = messageCount / threads;
        for (int i = 0; i < 4; i++) {
            int finalI = i + 1;
            pool.submit(() -> {
                for (int j = 0; j < messagesPerThread; j++) {
                    if (j % 100000 == 0)
                        System.out.println(LocalDateTime.now() + "::" + j + "::thread" + finalI);
                    mqPublisher.sendMessage("Process:" + uuid + " thread:" + finalI + "-m:" + j + " Hello world!");
                }
                System.out.println(LocalDateTime.now() + "::thread" + finalI + " finished.");
            });
        }
    }
}
