package com.example.kafka_demo.config.kafka.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.topics.demo-topic")
@Getter
@Setter
public class KafkaProperties {
    private String topicName;
    private int partitionCount;
    private short replicationFactor;
    private String retentionInMs;
    private String consumerGroup;
}

