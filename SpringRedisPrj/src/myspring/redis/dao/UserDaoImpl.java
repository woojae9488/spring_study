package myspring.redis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import myspring.redis.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private Map<String, Object> toMap(UserVO user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		map.put("gender", user.getGender());
		map.put("city", user.getCity());
		return map;
	}

	private UserVO toUserVO(Map<Object, Object> map) {
		UserVO user = new UserVO();
		user.setId(map.get("id").toString());
		user.setName(map.get("name").toString());
		user.setGender(map.get("gender").toString());
		user.setCity(map.get("city").toString());
		return user;
	}

	@Override
	public void insert(UserVO user) {
		String key = "UserVO." + user.getId();
		Map<String, Object> value = toMap(user);
		redisTemplate.opsForHash().putAll(key, value);
	}

	@Override
	public UserVO read(String id) {
		String key = "UserVO." + id;
		Map<Object, Object> value = redisTemplate.opsForHash().entries(key);
		UserVO user = toUserVO(value);
		return user;
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		Set<String> set = redisTemplate.keys("UserVO.*");
		for (String key : set) {
			Map<Object, Object> value = redisTemplate.opsForHash().entries(key);
			list.add(toUserVO(value));
		}
		return list;
	}

	@Override
	public void update(UserVO user) {
		String key = "UserVO." + user.getId();
		Map<String, Object> value = toMap(user);
		redisTemplate.opsForHash().putAll(key, value);
	}

	@Override
	public void delete(String id) {
		String key = "UserVO." + id;
		redisTemplate.delete(key);
	}

}
