package myspring.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;

	@Test
	public void daoTest() {
		UserDao dao = context.getBean("userDao", UserDao.class);

//		dao.insert(new UserVO("younghee", "이영희", "여", "부산"));
//		dao.update(new UserVO("younghee", "김영희", "여", "부산"));
//		dao.delete("dooly");
		
		List<UserVO> list = dao.readAll();
		for (UserVO vo : list) {
			System.out.println(vo);
		}
	}

	@Test
	@Ignore
	public void configTest() {
		SqlSession session = context.getBean("sqlSession", SqlSession.class);
		System.out.println(session.getClass().getName());

		UserVO vo = session.selectOne("userNS.selectUserById", "gildong");
		System.out.println(vo);
	}

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = context.getBean("dataSource", DataSource.class);
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void getUserTest() {
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		assertEquals("홍길동", user.getName());
	}

	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("dooly", "둘리", "남", "경기"));

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

	@Test
	@Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("gildong", "홍길동", "남2", "서울2"));

		UserVO user = service.getUser("gildong");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void deleteUserTest() {
		service.deleteUser("dooly");

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
}
