package com.tledu.zrz.dao;

import java.util.List;

import com.tledu.zrz.model.Student;

public interface IStudentDao {
	/**
	 * 根据 班级ID 获取班级下所有的学生
	 */
	public List<Student> ListByClassId(int classId);

	/**
	 * 根据ID 查询一个对象
	 */
	public Student load(int id);

	public List<Student> list(String searchTitle , Integer classesId , Integer teacherId);

	public void update(Student student);

	public void delete(int id);

	public void add(Student student);

}
