package myspring.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myspring.todo.service.TodoService;
import myspring.todo.vo.TodoVO;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/todos", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public Map<String, Object> insertTodo(@RequestBody TodoVO todo) {
		if (todo != null)
			todoService.insertTodo(todo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTodoList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TodoVO> todoList = todoService.getTodoList();
		result.put("result", Boolean.TRUE);
		result.put("data", todoList);
		return result;
	}

	@RequestMapping(value = "/todos/{createTime}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTodo(@PathVariable String createTime) {
		Map<String, Object> result = new HashMap<String, Object>();
		TodoVO todo = todoService.getTodo(createTime);
		result.put("result", Boolean.TRUE);
		result.put("data", todo);
		return result;
	}

	@RequestMapping(value = "/todos", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	@ResponseBody
	public Map<String, Object> updateTodo(@RequestBody TodoVO todo) {
		if (todo != null)
			todoService.updateTodo(todo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}

	@RequestMapping(value = "/todos/{createTime}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteTodo(@PathVariable String createTime) {
		Map<String, Object> result = new HashMap<String, Object>();
		todoService.deleteTodo(createTime);
		result.put("result", Boolean.TRUE);
		return result;
	}
}
