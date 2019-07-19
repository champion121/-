package com.tledu.zrz.service;

import java.util.List;

import com.tledu.zrz.model.User;
import com.tledu.zrz.model.UserException;

public interface IUserService {
	public User login(User user) throws UserException;
	public List<User> list();
}
