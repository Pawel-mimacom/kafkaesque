package cz.wasowi.example.kafka.sbkafkashareconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "test-topic",
            // groupId = "group_id",
            containerFactory = "shareKafkaListenerContainerFactory",
            groupId = "my-share-group")

    // Method
    public void
    consume(String message)
    {
        // Print statement
       try {
        System.out.println("message2 = " + message);
           // Thread.sleep(1000);
        } catch (Exception e) {
           e.printStackTrace();
        }


    }
}
