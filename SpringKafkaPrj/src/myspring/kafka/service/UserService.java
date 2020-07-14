package myspring.kafka.service;

import java.util.List;

import myspring.kafka.vo.UserVO;

public interface UserService {
	public void send(UserVO user);

	public void sendFinish();
	
	public List<UserVO> receive();	
}
