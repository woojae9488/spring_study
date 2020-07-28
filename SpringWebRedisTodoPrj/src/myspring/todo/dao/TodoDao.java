package myspring.todo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myspring.todo.vo.TodoVO;

@Repository
public interface TodoDao extends CrudRepository<TodoVO, String> {
}
