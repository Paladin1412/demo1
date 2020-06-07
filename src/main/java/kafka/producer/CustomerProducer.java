package kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerProducer {


    public static void main(String[] args) {
        //        ProducerConfig

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.75.128:9092");
//        props.put("bootstrap.servers", "eureka1:9092");
        props.put("acks", "all");
        //重试次数
        props.put("retries", 0);
        //批量大小
        props.put("batch.size", 16384);
        //提交延时
        props.put("linger.ms", 1);
        //缓存
        props.put("buffer.memory", 33554432);
        //K V序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"kafka.producer.CuntomerPartitioner");
        List<String> list = new ArrayList<>();
        list.add("kafka.intercepter.TimeIntercept");
        list.add("kafka.intercepter.CountIntercept");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, list);

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

//        producer.send(new ProducerRecord<>("second", ">>>ProducerRecord"), new Callback() {
//            @Override
//            public void onCompletion(RecordMetadata metadata, Exception exception) {
//                System.out.println(metadata.topic());
//            }
//        });


        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("seven", Integer.toString(i), "message" + i));
        }
        producer.close();

    }
}
