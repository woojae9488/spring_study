package myspring.kafka.dao;

import java.util.List;

import myspring.kafka.vo.UserVO;

public interface UserDao {
	public void write(UserVO user);

	public void finishWrite();

	public List<UserVO> read();
}
