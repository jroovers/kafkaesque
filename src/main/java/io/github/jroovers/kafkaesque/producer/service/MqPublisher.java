package io.github.jroovers.kafkaesque.producer.service;

public interface MqPublisher {

    /**
     * Send a test message on channel demo
     *
     * @param message message
     */
    void sendMessage(String message);

    /**
     * Send a message on specified topic
     *
     * @param topic   topic
     * @param message message
     */
    void sendMessage(String topic, String message);
}
