package com.tledu.zrz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zrz.dao.IStudentDao;
import com.tledu.zrz.model.Student;
import com.tledu.zrz.service.IStudentService;

@Service("studentService")
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDao studentDao;

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	// ----------------

	@Override
	public Student load(int id) {
		return studentDao.load(id);
	}

	@Override
	public List<Student> list(String searchTitle, Integer classesId,
			Integer teacherId) {
		return studentDao.list(searchTitle, classesId, teacherId);
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);
	}

	@Override
	public void add(Student student) {
		studentDao.add(student);
	}

	@Override
	public List<Student> ListByClassId(int classId) {
		return studentDao.ListByClassId(classId);
	}

}
