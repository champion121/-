package com.tledu.zrz.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.zrz.dao.IClassesDao;
import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.TreeModel;

@Repository("classesDao")
public class ClassesDao extends SqlSessionDaoSupport implements IClassesDao {
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// -------------------------

	@Override
	public Classes load(int id) {
		return getSqlSession().getMapper(IClassesDao.class).load(id);

	}

	@Override
	public List<Classes> list() {
		return getSqlSession().getMapper(IClassesDao.class).list();

	}

	@Override
	public void update(Classes classes) {
		getSqlSession().getMapper(IClassesDao.class).update(classes);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IClassesDao.class).delete(id);
	}

	@Override
	public void add(Classes classes) {
		getSqlSession().getMapper(IClassesDao.class).add(classes);
	}

	@Override
	public List<TreeModel> generateTree() {
		List<TreeModel> treeModels = getSqlSession().getMapper(
				IClassesDao.class).generateTree();
		treeModels.add(0, new TreeModel(0, "天亮教育", -1, true, true));
		return treeModels;
	}
}
