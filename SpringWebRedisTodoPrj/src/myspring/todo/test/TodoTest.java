package myspring.todo.test;

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

import myspring.todo.service.TodoService;
import myspring.todo.vo.TodoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/myspring/todo/config/beans.xml")
public class TodoTest {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private TodoService todoService;

	@Test
	public void connectTest() {
		RedisTemplate<String, Object> redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);
		RedisConnection con = redisTemplate.getConnectionFactory().getConnection();
		System.out.println(con);
	}

	@Test
	@Ignore
	public void insertTest() {
		TodoVO todo = new TodoVO("0", "Test", "test todo", "10");
		todoService.insertTodo(todo);
		List<TodoVO> todoList = todoService.getTodoList();
		for (TodoVO elem : todoList) {
			System.out.println(elem);
		}
	}

	@Test
	@Ignore
	public void readTest() {
		TodoVO todo = todoService.getTodo("0");
		System.out.println(todo);
	}

	@Test
	@Ignore
	public void updateTest() {
		TodoVO todo = new TodoVO("0", "Test", "test todo contents", "100");
		todoService.updateTodo(todo);
		List<TodoVO> todoList = todoService.getTodoList();
		for (TodoVO elem : todoList) {
			System.out.println(elem);
		}	
	}

	@Test
	@Ignore
	public void deleteTest() {
		todoService.deleteTodo("0");
		List<TodoVO> todoList = todoService.getTodoList();
		for (TodoVO elem : todoList) {
			System.out.println(elem);
		}	
	}
}
