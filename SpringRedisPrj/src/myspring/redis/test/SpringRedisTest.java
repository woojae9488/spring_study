package myspring.redis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.redis.service.UserService;
import myspring.redis.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/myspring/redis/config/beans.xml")
public class SpringRedisTest {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private UserService userService;

	@Test
	@Ignore
	public void connectTest() {
		RedisTemplate<String, Object> redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
		RedisConnection con = redisTemplate.getConnectionFactory().getConnection();
		System.out.println(con);
		assertNotNull(con);
	}

	@Test
	@Ignore
	public void insertTest() {
		UserVO user = new UserVO("dooly", "dooly", "female", "seoul");
		userService.insertUser(user);
		List<UserVO> list = userService.getUserList();
		for (UserVO userVO : list) {
			System.out.println(userVO);
			assertNotNull(userVO);
		}
	}

	@Test
	@Ignore
	public void readTest() {
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
		assertEquals("honggildong", user.getName());
	}

	@Test
	@Ignore
	public void updateTest() {
		UserVO user = new UserVO("dooly", "godooly", "male", "seoul");
		userService.updateUser(user);
		List<UserVO> list = userService.getUserList();
		for (UserVO userVO : list) {
			System.out.println(userVO);
			assertNotNull(userVO);
		}
	}

	@Test
	@Ignore
	public void deleteTest() {
		userService.deleteUser("dooly");
		List<UserVO> list = userService.getUserList();
		for (UserVO userVO : list) {
			System.out.println(userVO);
			assertNotNull(userVO);
		}
	}
}
