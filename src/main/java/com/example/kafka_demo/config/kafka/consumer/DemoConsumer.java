package com.example.kafka_demo.config.kafka.consumer;

import com.example.kafka_demo.model.DemoMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoConsumer {

    @KafkaListener(topics = "${kafka.topics.demo-topic.topicName}",
            groupId = "${kafka.topics.demo-topic.consumerGroup}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload DemoMessage message, @Headers ConsumerRecord<String, Object> consumerRecord) {
            log.info("msg: {}, offset: {}", message.getMessage(), consumerRecord.offset());
    }
}
