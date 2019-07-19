package com.tledu.zrz.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.zrz.dao.IDepartmentDao;
import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.TreeModel;

@Repository("departmentDao")
public class DepartmentDao extends SqlSessionDaoSupport implements
		IDepartmentDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// -------------------------

	@Override
	public Department load(int id) {
		return getSqlSession().getMapper(IDepartmentDao.class).load(id);

	}

	@Override
	public List<Department> list() {
		return getSqlSession().getMapper(IDepartmentDao.class).list();

	}

	@Override
	public void update(Department dept) {
		getSqlSession().getMapper(IDepartmentDao.class).update(dept);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IDepartmentDao.class).delete(id);
	}

	@Override
	public void add(Department dept) {
		getSqlSession().getMapper(IDepartmentDao.class).add(dept);
	}

	@Override
	public List<TreeModel> generateTree() {
		List<TreeModel> treeModels = getSqlSession().getMapper(
				IDepartmentDao.class).generateTree();
		treeModels.add(0, new TreeModel(0, "天亮教育", -1, true, true));
		return treeModels;
	}
}
