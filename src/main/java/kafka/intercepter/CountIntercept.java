package kafka.intercepter;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CountIntercept implements ProducerInterceptor {
    private int successCount = 0;
    private int errorCount = 0;
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e==null){
            successCount++;
        }else {
            errorCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("成功发送："+successCount);
        System.out.println("失败发送："+errorCount);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
