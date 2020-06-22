package springbootkafka.springbootkafka.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootkafka.springbootkafka.model.User;

@RestController
@RequestMapping("/kafka")
public class UserController {

    // we need to autowire kafka template
    @Autowired
//  KafkaTemplate<String, User> kafkaTemplate;
    KafkaTemplate<String, String> kafkaTemplate;
    // we create a kafka topic
    private static  final String TOPIC_ONE = "topic-one";

    @GetMapping("/{message}")
    public String getCalls(@PathVariable("message") String message){
//    kafkaTemplate.send(TOPIC_ONE, new User("bill", "COP", "1000"));
        kafkaTemplate.send(TOPIC_ONE, "hello word ");
        return "hello world " + message;
    }

}
