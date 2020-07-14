package myspring.kafka.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.kafka.service.UserService;
import myspring.kafka.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/myspring/kafka/config/beans.xml")
public class SpringKafkaTest {
	@Autowired
	private UserService userService;

	@Test
	public void producerTest() {
		Scanner scn = new Scanner(System.in);
		while (true) {
			UserVO user = new UserVO();
			System.out.print("Input id > ");
			user.setId(scn.next());
			System.out.print("Input name > ");
			user.setName(scn.next());
			System.out.print("Input gender > ");
			user.setGender(scn.next());
			System.out.print("Input city > ");
			user.setCity(scn.next());
			userService.send(user);
			System.out.println("[SEND]: " + user);
			System.out.print("\nExit? > ");
			String choice = scn.next();
			if (choice.equals("exit"))
				break;
		}
		System.err.println("[[ FINISH ]]");
	}

	@Test
	@Ignore
	public void consumerTest() {
		boolean finish = false;
		while (!finish) {
			List<UserVO> list = userService.receive();
			for (UserVO user : list) {
				if (user == null) {
					finish = true;
					break;
				}
				System.out.println("[RECEIVE]: " + user);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.println("[[ FINISH ]]");
	}
}
