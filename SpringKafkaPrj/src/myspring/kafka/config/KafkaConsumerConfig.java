package myspring.kafka.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Value("${kafka.group.bootstrap-server}")
	private String groupBootStrapAddr;
	@Value("${kafka.group.id}")
	private String groupId;

	@Value("${kafka.topic.old}")
	private String topicTitle;

//	@Value("${kafka.single.bootstrap-server1}")
//	private String singleBootStrapAddr1;
//	@Value("${kafka.single.bootstrap-server2}")
//	private String singleBootStrapAddr2;
//	@Value("${kafka.single.bootstrap-server3}")
//	private String singleBootStrapAddr3;

	@Bean
	public Map<String, Object> consumerConfig() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, groupBootStrapAddr);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		return config;
	}

	@Bean
	public KafkaConsumer<String, String> kafkaConsumer() {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(consumerConfig());
		consumer.subscribe(Arrays.asList(topicTitle));
		return consumer;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<String, String>(consumerConfig());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
