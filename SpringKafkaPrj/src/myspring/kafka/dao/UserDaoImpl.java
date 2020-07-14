package myspring.kafka.dao;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import myspring.kafka.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private KafkaConsumer<String, String> kafkaConsumer;
	@Autowired
	private ObjectMapper mapper;

	@Value("${kafka.topic.old}")
	private String kafkaTopic;

	private static final String END_OF_STREAM = "EOS";

	private Map<String, Object> userToMap(UserVO user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		map.put("gender", user.getGender());
		map.put("city", user.getCity());
		return map;
	}

	private UserVO mapToUser(Map<String, Object> map) {
		UserVO user = new UserVO();
		user.setId(map.get("id").toString());
		user.setName(map.get("name").toString());
		user.setGender(map.get("gender").toString());
		user.setCity(map.get("city").toString());
		return user;
	}

	@Override
	public void write(UserVO user) {
		try {
			Map<String, Object> map = userToMap(user);
			String jsonString = mapper.writeValueAsString(map);
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopic, jsonString);
			kafkaTemplate.send(record);
		} catch (IOException e) {
			System.err.println("Fail to serialize UserVO to JSON");
		}
	}

	@Override
	public void finishWrite() {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopic, END_OF_STREAM);
		kafkaTemplate.send(record);
	}

	@Override
	public List<UserVO> read() {
		List<UserVO> list = new ArrayList<UserVO>();
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};

		ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100000));
		for (ConsumerRecord<String, String> record : records) {
			String json = record.value();
			if (json.equals(END_OF_STREAM)) {
				list.add(null);
				break;
			}
			try {
				Map<String, Object> map = mapper.readValue(json, typeRef);
				UserVO user = mapToUser(map);
				list.add(user);
			} catch (IOException e) {
				System.err.println("Fail to deserialize JSON to UserVO");
			}
		}
		return list;
	}
}
