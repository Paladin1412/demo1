package kafka.comsumer;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class CustomerConsumer {
    //  https://www.cnblogs.com/sodawoods-blogs/p/8969774.html

    public static void main(String[] args) {

//        new KafkaConsumer<>()
//        ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.75.128:9092");
        props.setProperty("group.id", "mygroup");
        //设置自动提交offset  //提交延时。过一秒提交offset  容易造成数据的重复消费，使用低级api进行管理
//        props.setProperty("enable.auto.commit", "true");
//        props.setProperty("auto.commit.interval.ms", "1000");
        props.put("enable.auto.commit","false");    //每一次消费消息都需要手动提交
        props.put("auto.offset.reset","latest");//earliest  latest

        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("eight"));   //订阅topic

//        List<TopicPartition> list = new ArrayList<>();
//        list.add(new TopicPartition("eight",1));
//        consumer.assign(list);     ==>   consumer.assign(Collections.singletonList(new TopicPartition("",0)));

//        consumer.seek(new TopicPartition("eight",0),2);

        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.topic()+"--"+record.partition()+"--"+record.offset()+"--"+record.value());

            }
            consumer.commitSync();  //当 "enable.auto.commit"："false"需要手动提交
        }
    }
}
