package io.github.jroovers.kafkaesque.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisherKafkaImpl implements MqPublisher {

    @Autowired
    @Qualifier("avro")
    private KafkaTemplate<String, Object> avroKafkaTemplate;

    @Autowired
    @Qualifier("text")
    private KafkaTemplate<String, String> textKafkaTemplate;

    public void sendMessage(String topic, String message) {
        textKafkaTemplate.send(topic, message);
    }

    public void sendMessage(String message) {
        textKafkaTemplate.send("demo", message);
    }

    @Override
    public void sendMessage(String topic, Object message) {
        avroKafkaTemplate.send("demo", message);
    }

}
