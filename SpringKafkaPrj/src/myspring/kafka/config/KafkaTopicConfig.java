package myspring.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
	@Value("${kafka.group.bootstrap-server}")
	private String bootStrapAddr;
	@Value("${kafka.topic.new}")
	private String newTopicTitle;

//	@Bean
	public KafkaAdmin kafkaSingleAdmin() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapAddr);
		return new KafkaAdmin(config);
	}

//	@Bean
	public NewTopic testTopic() {
		return new NewTopic(newTopicTitle, 3, (short) 1);
	}
}