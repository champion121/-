package com.tledu.zrz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zrz.dao.IUserDao;
import com.tledu.zrz.model.User;
import com.tledu.zrz.model.UserException;
import com.tledu.zrz.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	// ----------------

	@Override
	public User login(User user) throws UserException {
		User loginUser = userDao.login(user);
		if (loginUser == null) {
			throw new UserException("用户名不正确");
		}
		// 到这里说明用户名存在,就判断密码
		if (!loginUser.getPassword().trim().equals(user.getPassword().trim())) {
			throw new UserException("密码不正确");
		}

		return loginUser;
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

}
