package kafka.comsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 根据指定的topic、partition、offset获取数据
 */
public class CustomerConsumer2 {


    public static void main(String[] args) {
        String topic = "four";
        int partition = 0;
        int port = 9092;
        ArrayList<String> brokers = new ArrayList<>();
        brokers.add("eureka1");

        Long offset = 2L;


    }

    public String findLeader(List<String> brokers, int port,String topic,int partition) {

        return null;
    }

    private void getData() {

    }
}
