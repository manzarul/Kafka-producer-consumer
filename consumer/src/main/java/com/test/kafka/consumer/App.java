package com.test.kafka.consumer;

import java.util.Collections;
import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

/**
 * Main class to register consumer with topic test.topic
 *
 */
public class App 
{
	public static void main(String[] args) {
		EventConsumer.getConsumer().subscribe(Collections.singletonList("test.topic"));
		while (true) {
			ConsumerRecords<Long, String> records = EventConsumer.getConsumer().poll(100);
			if (!records.isEmpty()) {
				Iterator<ConsumerRecord<Long, String>> itr = records.iterator();
				while (itr.hasNext()) {
					ConsumerRecord<Long, String> tmp = itr.next();
					System.out.println("Key = " + tmp.key() + " value== " + tmp.value());
				}
			}

		}

	}

}
    
    

