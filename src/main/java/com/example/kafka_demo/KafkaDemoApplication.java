package com.example.kafka_demo;

import com.example.kafka_demo.config.kafka.configuration.KafkaProperties;
import com.example.kafka_demo.config.kafka.producer.DemoProducer;
import com.example.kafka_demo.model.DemoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.kafka.support.KafkaHeaders.KEY;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemoApplication implements CommandLineRunner {

	private final DemoProducer kafkaProducer;
	private final KafkaProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Map<String, Object> headers = new HashMap<>();
		headers.put(TOPIC, properties.getTopicName());
		headers.put(KEY, "key3");
		kafkaProducer.send(new GenericMessage(new DemoMessage("hello", properties.getTopicName()), headers));
	}
}
