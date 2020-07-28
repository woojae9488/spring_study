package myspring.todo.service;

import java.util.List;

import myspring.todo.vo.TodoVO;

public interface TodoService {
	public void insertTodo(TodoVO todo);

	public List<TodoVO> getTodoList();

	public TodoVO getTodo(String createTime);

	public void updateTodo(TodoVO todo);

	public void deleteTodo(String createTime);
}
