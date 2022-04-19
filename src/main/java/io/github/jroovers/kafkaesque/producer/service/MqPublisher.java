package io.github.jroovers.kafkaesque.producer.service;

public interface MqPublisher {

    /**
     * Send a test message on channel demo
     *
     * @param message message
     */
    void sendMessage(String message);

    /**
     * Send a text message on specified topic
     *
     * @param topic   topic
     * @param message message
     */
    void sendMessage(String topic, String message);

    /**
     * Send a avro message on specified topic
     *
     * @param topic   topic
     * @param message message
     */
    void sendMessage(String topic, Object message);
}
