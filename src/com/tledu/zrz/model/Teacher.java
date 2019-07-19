package com.tledu.zrz.model;

import java.util.Date;

public class Teacher {
	private int id;
	private String teacher_name;
	private String sex;
	private String phone;
	private String email;
	/**
	 * 所属部门
	 */
	private Department dept;
	/**
	 * 薪水
	 */
	private int salary;
	/**
	 * 入职时间
	 */
	private Date come_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

	public Teacher(int id, String teacher_name, String sex, String phone,
			String email, Department dept, int salary, Date come_time) {
		super();
		this.id = id;
		this.teacher_name = teacher_name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.dept = dept;
		this.salary = salary;
		this.come_time = come_time;
	}

	public Teacher() {
		super();
	}

}
