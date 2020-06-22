package springbootkafka.springbootkafka.kafkaConfig;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import springbootkafka.springbootkafka.model.User;

import java.util.HashMap;
import java.util.Map;

//@EnableKafka
@Configuration
public class KafkaConfiguration {

 //this is for the kafka producer
    @Bean
   public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> configObj = new HashMap<>();
        configObj.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configObj.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configObj.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configObj);
    }

    @Bean
    KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


 ////////////////////////////////////////////////////////////////////////////////////////////////
// this for the kafka  consumer ===================================================================
//    @Bean
//    public ConsumerFactory<String,String> consumerFactory(){
//        Map<String, Object> configObj = new HashMap<>();
//        configObj.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.17.0.2:9092");
//        configObj.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//        configObj.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configObj.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(configObj);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKLF= new ConcurrentKafkaListenerContainerFactory<>();
//        concurrentKLF .setConsumerFactory(consumerFactory());
//        return concurrentKLF ;
//    }
// ============================================================================================================













}
