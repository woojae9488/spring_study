package myspring.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.kafka.dao.UserDao;
import myspring.kafka.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void send(UserVO user) {
		userDao.write(user);
	}

	@Override
	public void sendFinish() {
		userDao.finishWrite();
	}

	@Override
	public List<UserVO> receive() {
		return userDao.read();
	}

}
