package myspring.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.todo.dao.TodoDao;
import myspring.todo.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoDao todoDao;

	@Override
	public void insertTodo(TodoVO todo) {
		todoDao.save(todo);
	}

	@Override
	public List<TodoVO> getTodoList() {
		Iterable<TodoVO> todoIterable = todoDao.findAll();
		List<TodoVO> todoList = new ArrayList<TodoVO>();
		for (TodoVO todo : todoIterable) {
			todoList.add(todo);
		}
		return todoList;
	}

	@Override
	public TodoVO getTodo(String createTime) {
		Optional<TodoVO> todoOptional = todoDao.findById(createTime);
		return todoOptional.get();
	}

	@Override
	public void updateTodo(TodoVO todo) {
		todoDao.save(todo);
	}

	@Override
	public void deleteTodo(String createTime) {
		todoDao.deleteById(createTime);
	}
}
