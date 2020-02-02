package com.test.kafka.consumer;

import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class EventConsumer {

	private static final String BOOTSTRAP_SERVERS = System.getenv("BOOTSTRAP_SERVERS") != null
			? System.getenv("BOOTSTRAP_SERVERS")
			: "localhost:9092";
	private static Consumer<Long, String> consumer;

	static {
		loadConsumerProperties();
	}


	private static void loadConsumerProperties() {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "KafkaClientConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
		consumer = new KafkaConsumer<>(props);
	}


	public static Consumer<Long, String> getConsumer() {
		return consumer;
	}
}
