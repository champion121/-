package com.tledu.zrz.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.zrz.dao.IUserDao;
import com.tledu.zrz.model.User;

@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport implements IUserDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public User login(User user) {
		return getSqlSession().selectOne("com.tledu.zrz.dao.IUserDao.login", user);
	}

	@Override
	public List<User> list() {
		return getSqlSession().getMapper(IUserDao.class).list();
	}

}
