package com.hz.source;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.List;
import java.util.Properties;

public class KafkaSource {

    public KafkaSource() {

    }

    public FlinkKafkaConsumer010 getConsumer(String topicName, String groupId, String bootstrapServer ) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServer);
        properties.setProperty("group.id", groupId);
        FlinkKafkaConsumer010 flinkKafkaConsumer010 = new FlinkKafkaConsumer010(
                topicName,
                new SimpleStringSchema(),
                properties
        );
        return flinkKafkaConsumer010;
    }

    public FlinkKafkaConsumer010 getConsumerList(List<String> topics, String groupId,String bootstrapServer) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServer);
        properties.setProperty("group.id", groupId);
        FlinkKafkaConsumer010 flinkKafkaConsumer010 = new FlinkKafkaConsumer010(
                topics,
                new SimpleStringSchema(),
                properties
        );
        return flinkKafkaConsumer010;
    }
}
