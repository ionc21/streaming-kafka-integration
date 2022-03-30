package com.icsoft.service;

import lombok.RequiredArgsConstructor;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class ProduceConsumeService {

    private final SquareRoot squareRoot;

    public void executeJob() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");

        DataStream<String> dataStream = env
                .addSource(new FlinkKafkaConsumer<>("numbers", new SimpleStringSchema(), properties));

        DataStream<String> result = dataStream.map(squareRoot);

        result.addSink(new FlinkKafkaProducer<>("square-roots", new SimpleStringSchema(), properties));

        env.execute();
    }
}
