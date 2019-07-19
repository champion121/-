package com.tledu.zrz.model;

import java.util.Date;

public class Student {
	private int id;
	private String stu_name;
	/**
	 * 年级,大一,大二,大三...
	 */
	private String grades;
	private String sex;
	private String phone;
	private String qq;
	private String email;
	/**
	 * 学校,在哪个大学上学
	 */
	private String school;
	/**
	 * 专业,大学专业
	 */
	private String major;
	/**
	 * 所在班级(公司)
	 */
	private Classes classes;
	/**
	 * 任课老师(公司)
	 */
	private Teacher teacher;
	/**
	 * 入学时间(公司)
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

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

	public Student(int id, String stu_name, String grades, String sex,
			String phone, String qq, String email, String school, String major,
			Classes classes, Teacher teacher, Date come_time) {
		super();
		this.id = id;
		this.stu_name = stu_name;
		this.grades = grades;
		this.sex = sex;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.school = school;
		this.major = major;
		this.classes = classes;
		this.teacher = teacher;
		this.come_time = come_time;
	}

	public Student() {
		super();
	}

}
