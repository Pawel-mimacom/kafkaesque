package cz.wasowi.example.kafka.sbkafkashareconsumer;

import io.confluent.monitoring.clients.interceptor.MonitoringConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.ShareKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultShareConsumerFactory;
import org.springframework.kafka.core.ShareConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    // Creating a Listener share.acknowledgement.mode
    public ConcurrentKafkaListenerContainerFactory
    concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<
                String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
      //  factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    @Bean
    public ShareConsumerFactory<String, String> shareConsumerFactory() {
        //   config.put(
        //                ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG,
        //                MonitoringConsumerInterceptor.class);
        kafkaProperties.buildConsumerProperties().forEach((a, b) -> System.out.println(a + "-:-" + b));
// Caused by: org.apache.kafka.common.config.ConfigException: isolation.level cannot be set when using a share group.
        return new DefaultShareConsumerFactory<>(
                kafkaProperties.buildConsumerProperties().
                        entrySet().stream().filter(e -> !e.getKey().equals("isolation.level"))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        );

    }

    @Bean
    public ShareKafkaListenerContainerFactory<String, String> shareKafkaListenerContainerFactory(
            ShareConsumerFactory<String, String> shareConsumerFactory) {
        return new ShareKafkaListenerContainerFactory<>(shareConsumerFactory);
    }
}
