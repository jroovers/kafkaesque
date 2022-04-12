# kafkaesque

Quick hands-on project for java/spring-boot + kafka

## Apache Kafka development setup example

> taken from https://hub.docker.com/r/bitnami/kafka

To deploy it, run the following command in the directory where the docker-compose.yml file is located:

```sh
docker-compose up -d
```

To clean up a running instance run:

```sh
docker-compose down
```

> This wipes all data

## Running the producer (KafkaesqueProducer)

The producer sets up a topic with 4 partitions (allowing up to 4 consumers).

It then sens plain text messages to the kafka topic 'demo'. the number of thread and iterations are configurable for
this (application.properties)

For every 100k messages sent a timestamp is logged to the output.

## Running the listener (KafkaesqueConsumer)

The listener starts up and once connected to ZK/kafka starts listening to messages.

For every 100k messages a string is logged to the output.

## Some observations about performance

Using simple strings, throughput reached about 400k messages/second on a 2020 i7 laptop processor using 4 cores.

Reading 4 partitions with a single listener on 4 threads gave me about 380k messages/second.
