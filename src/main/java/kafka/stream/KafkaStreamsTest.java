package kafka.stream;


import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.TopologyBuilder;

import java.util.Properties;

public class KafkaStreamsTest {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.75.128:9092");
        properties.put("application.id","kafkaStream");
        //kafka流式数据清洗，将topic(seven)中的数据经过清洗写入topic(eight)
        builder.addSource("SOURCE","seven")
            .addProcessor("PROCESSOR", new ProcessorSupplier() {
                @Override
                public Processor get() {
                    return new LogProcessor();
                }
            }, "SOURCE")
            .addSink("SINK","eight","PROCESSOR");

        KafkaStreams kafkaStreams = new KafkaStreams(builder, properties);
        kafkaStreams.start();
    }
}
