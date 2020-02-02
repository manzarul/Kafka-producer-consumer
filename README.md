# Kafka-producer-consumer
This project will demostrate kafka producer and consumer basic setup.
------Pre-Request----
* Kafka need to be installed
* create a topic with name "test.topic"
* Command to create topic:
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test.topic

Kafka ref:
https://www.oreilly.com/library/view/kafka-the-definitive/9781491936153/ch04.html#co_kafka_consumers__reading_data_from_kafka_CO2-4
