package springbootkafka.springbootkafka.kafkaConfig;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import springbootkafka.springbootkafka.model.User;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {


    @Bean
    ProducerFactory<String,User> producerFactory(){
        Map<String, Object> configObj = new HashMap<>();
        configObj.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.17.0.2:9092");
        configObj.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configObj.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configObj);
    }

    @Bean
    KafkaTemplate<String, User> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


}
