package kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class CustomerProducer2 {

    public static void main(String[] args) {
        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.75.128:9092");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"eureka1:9092");
        properties.put(ProducerConfig.ACKS_CONFIG,"1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 3; i++)
            producer.send(new ProducerRecord<String, String>("second", Integer.toString(i), Integer.toString(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e != null){
                        e.printStackTrace();
                    }else {
                        System.out.println(recordMetadata.topic()+" "+recordMetadata.offset()+" "+recordMetadata.partition());
                    }

                }
            });
        System.out.println("end");
        Long start = System.currentTimeMillis();
        producer.close();
        System.out.println(System.currentTimeMillis() - start);
    }
}
