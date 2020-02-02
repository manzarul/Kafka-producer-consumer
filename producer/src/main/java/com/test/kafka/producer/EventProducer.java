package com.test.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class EventProducer {

	private static final String BOOTSTRAP_SERVERS = System.getenv("BOOTSTRAP_SERVERS") != null
			? System.getenv("BOOTSTRAP_SERVERS")
			: "localhost:9092";
	private static Producer<Long, String> producer;

	static {
		loadProducerProperties();
	}

	private static void loadProducerProperties() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaClientProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.LINGER_MS_CONFIG, 5);
		producer = new KafkaProducer<Long, String>(props);
	}


	public static Producer<Long, String> getProducer() {
		return producer;
	}


	public static void send(String event, String topic) throws Exception {
			final Producer<Long, String> producer = getProducer();
			ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(topic, event);
			producer.send(record);
	}

}
