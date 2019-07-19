package com.tledu.zrz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zrz.dao.ITeacherDao;
import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.model.TreeModel;
import com.tledu.zrz.service.ITeacherService;

@Service("teacherService")
public class TeacherService implements ITeacherService {
	@Autowired
	private ITeacherDao teacherDao;

	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	// --------------------------
	@Override
	public Teacher load(int id) {
		return teacherDao.load(id);
	}

	@Override
	public List<Teacher> list() {
		return teacherDao.list();
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
	}

	@Override
	public void delete(int id) {
		teacherDao.delete(id);
	}

	@Override
	public void add(Teacher teacher) {
		teacherDao.add(teacher);
	}

	@Override
	public List<Teacher> listByDeptId(int deptId) {
		return teacherDao.listByDeptId(deptId);
	}

	@Override
	public List<TreeModel> generateTree() {
		return teacherDao.generateTree();
	}
}
