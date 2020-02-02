package com.test.kafka.producer;

import java.util.Date;


/**
 * App class will generate dummy event and send to kafka topic {test.topic}
 *
 */
public class App 
{
	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			Event event = new Event(i, "some test data_" + i, "test", new Date());
			try {
				EventProducer.send(event.toString(), "test.topic");
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	static class Event {
		int id;
		String data;
		String type;
		Date date;

		public Event() {
			super();
		}

		public Event(int id, String data, String type, Date date) {
			super();
			this.id = id;
			this.data = data;
			this.type = type;
			this.date = date;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Event [id=" + id + ", data=" + data + ", type=" + type + ", date=" + date + "]";
		}
	}

}
