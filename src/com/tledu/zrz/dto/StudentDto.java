package com.tledu.zrz.dto;

import java.util.Date;

import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.Student;
import com.tledu.zrz.model.Teacher;

public class StudentDto {
	private int teacher_id;
	private int classes_id;
	private String classes_name;
	private String teacher_name;

	public String getClasses_name() {
		return classes_name;
	}

	public void setClasses_name(String classes_name) {
		this.classes_name = classes_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	/**
	 * ID 主键,唯一性
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String stu_name;
	/**
	 * 年级
	 */
	private String grades;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 专业
	 */
	private String major;

	/**
	 * 学生入学时间
	 */
	private Date come_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getClasses_id() {
		return classes_id;
	}

	public void setClasses_id(int classes_id) {
		this.classes_id = classes_id;
	}

	/**
	 * Dto转Student
	 */
	public Student getStudent() {
		Student student = new Student();
		student.setId(this.id);
		student.setCome_time(this.come_time);
		student.setEmail(this.email);
		student.setGrades(this.grades);
		student.setMajor(this.major);
		student.setPhone(this.phone);
		student.setQq(this.qq);
		student.setSex(this.sex);
		student.setSchool(this.school);
		student.setStu_name(this.stu_name);
		// 把班级ID和老师ID 设置进去
		Classes classes = new Classes();
		classes.setId(this.classes_id);
		classes.setClassName(this.classes_name);

		Teacher teacher = new Teacher();
		teacher.setId(this.teacher_id);
		teacher.setTeacher_name(this.teacher_name);

		student.setClasses(classes);
		student.setTeacher(teacher);
		return student;
	}

	/**
	 * Student 转 Dto
	 */
	public static StudentDto getStudentDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setCome_time(student.getCome_time());
		studentDto.setEmail(student.getEmail());
		studentDto.setGrades(student.getGrades());
		studentDto.setMajor(student.getMajor());
		studentDto.setPhone(student.getPhone());
		studentDto.setQq(student.getQq());
		studentDto.setSchool(student.getSchool());
		studentDto.setSex(student.getSex());
		studentDto.setStu_name(student.getStu_name());
		// 把 班级和讲师ID设置进去
		studentDto.setClasses_id(student.getClasses().getId());
		studentDto.setClasses_name(student.getClasses().getClassName());
		studentDto.setTeacher_id(student.getTeacher().getId());
		studentDto.setTeacher_name(student.getTeacher().getTeacher_name());
		return studentDto;
	}
}
