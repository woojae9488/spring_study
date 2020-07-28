package myspring.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "myspring.todo.dao")
public class SpringRedisConfig {
	@Value("${redis.hostname}")
	private String hostName;
	@Value("${redis.port}")
	private int port;

	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName(hostName);
		redisConfig.setPort(port);
		return new JedisConnectionFactory(redisConfig);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(connectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
