package com.tledu.zrz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.zrz.dao.IStudentDao;
import com.tledu.zrz.model.Student;

@Repository("studentDao")
public class StudentDao extends SqlSessionDaoSupport implements IStudentDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// -------------------------

	@Override
	public Student load(int id) {
		return getSqlSession().getMapper(IStudentDao.class).load(id);

	}

	@Override
	public List<Student> list(String searchTitle, Integer classesId,
			Integer teacherId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (searchTitle != null && !searchTitle.trim().equals("")) {
			params.put("searchTitle", "%" + searchTitle + "%");
		}
		if (classesId != null && classesId > 0) {
			params.put("classesId", classesId);
		}
		if (teacherId != null && teacherId > 0) {
			params.put("teacherId", teacherId);
		}
		return getSqlSession().selectList("com.tledu.zrz.dao.IStudentDao.list",
				params);
	}

	@Override
	public void update(Student student) {
		getSqlSession().getMapper(IStudentDao.class).update(student);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IStudentDao.class).delete(id);
	}

	@Override
	public void add(Student student) {
		getSqlSession().getMapper(IStudentDao.class).add(student);
	}

	@Override
	public List<Student> ListByClassId(int classId) {
		return getSqlSession().getMapper(IStudentDao.class).ListByClassId(
				classId);

	}
}
