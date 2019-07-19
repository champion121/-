package com.tledu.zrz.dao;

import com.tledu.zrz.model.User;

import java.util.List;

public interface IUserDao {
	public User login(User user);

	public List<User> list();
}
