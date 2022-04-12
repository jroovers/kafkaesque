# kafkaesque

Quick hands-on project for java/spring-boot + kafka

## Apache Kafka development setup example

> taken from https://hub.docker.com/r/bitnami/kafka

To deploy it, run the following command in the directory where the docker-compose.yml file is located:

```sh
docker-compose up -d
```

## Running the producer (KafkaesqueProducer)

The producer sets up a topic with 4 partitions (allowing up to 4 consumers).

It then sens plain text messages to the kafka topic 'demo'. the number of thread and iterations are configurable for this (application.properties)

For every 100k messages sent a timestamp is logged to the output.

## Running the listener (KafkaesqueConsumer)

The listener starts up and once connected to ZK/kafka starts listening to messages.

For every 100k messages a string is logged to the output.
