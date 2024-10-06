package com.example.kafka_demo.config.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class DemoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(GenericMessage<Object> message) {

        final CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(message);
        future.whenComplete((result, ex)->{
            if (ex != null) {
                log.error(ex.getMessage());
            }else {
                log.info(String.valueOf(result.getRecordMetadata().offset()));
            }
        });

    }
}
