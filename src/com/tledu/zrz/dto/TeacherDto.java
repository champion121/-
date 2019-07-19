package com.tledu.zrz.dto;

import java.util.Date;

import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.Teacher;

public class TeacherDto {
	/**
	 * 部门 ID
	 * 
	 * 由于 已经有了部门ID变量了,所以不需要部门对象,别的属性和Teacher中一样
	 */
	private int dept_id;
	private String dept_type;

	public String getDept_type() {
		return dept_type;
	}

	public void setDept_type(String dept_type) {
		this.dept_type = dept_type;
	}

	private int id;
	private String teacher_name;
	private String sex;
	private String phone;
	private String email;

	/**
	 * 薪水
	 */
	private int salary;
	/**
	 * 入职时间
	 */
	private Date come_time;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

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

	public TeacherDto(int dept_id, int id, String teacher_name, String sex,
			String phone, String email, int salary, Date come_time) {
		super();
		this.dept_id = dept_id;
		this.id = id;
		this.teacher_name = teacher_name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
		this.come_time = come_time;
	}

	public TeacherDto() {
		super();
	}

	public Teacher getTeacher() {
		Teacher teacher = new Teacher();
		teacher.setId(this.id);
		teacher.setTeacher_name(this.teacher_name);
		teacher.setSex(this.sex);
		teacher.setPhone(this.phone);
		teacher.setEmail(this.email);
		teacher.setSalary(this.salary);
		teacher.setCome_time(this.come_time);

		Department department = new Department();
		department.setId(this.dept_id);
		department.setType(this.dept_type);

		teacher.setDept(department);
		return teacher;
	}

	public static TeacherDto getTeacherDto(Teacher teacher) {
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(teacher.getId());
		teacherDto.setTeacher_name(teacher.getTeacher_name());
		teacherDto.setSex(teacher.getSex());
		teacherDto.setPhone(teacher.getPhone());
		teacherDto.setEmail(teacher.getEmail());
		teacherDto.setSalary(teacher.getSalary());
		teacherDto.setCome_time(teacher.getCome_time());
		teacherDto.setDept_id(teacher.getDept().getId());
		teacherDto.setDept_type(teacher.getDept().getType());
		return teacherDto;
	}
}
