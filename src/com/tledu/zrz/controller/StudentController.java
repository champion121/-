package com.tledu.zrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tledu.zrz.dto.StudentDto;
import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.Student;
import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.model.TreeModel;
import com.tledu.zrz.service.IClassesService;
import com.tledu.zrz.service.IStudentService;
import com.tledu.zrz.service.ITeacherService;

@Controller
@RequestMapping("/student")
public class StudentController extends InitDateController {

	@Autowired
	private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IClassesService classesService;

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public IClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(IClassesService classesService) {
		this.classesService = classesService;
	}

	public IStudentService getStudentService() {

		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	// ------------------------

	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<Student> students = studentService.list(null, 0, 0);
		List<Classes> classess = classesService.list();
		List<Teacher> teachers = teacherService.list();
		map.put("students", students);
		map.put("classess", classess);
		map.put("teachers", teachers);
		return "student/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(StudentDto studentDto) {
		Student student = studentDto.getStudent();

		studentService.add(student);
		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int id, ModelMap map) {
		// 更新跳转到页面之前,先把原来的内容传递到页面
		Student student = studentService.load(id);

		StudentDto studentDto = StudentDto.getStudentDto(student);
		map.put("studentDto", studentDto);
		return "student/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(StudentDto studentDto) {

		Student student = studentDto.getStudent();

		studentService.update(student);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		studentService.delete(id);
		return "redirect:list";
	}

	@RequestMapping("/show")
	public String show(int id, ModelMap map) {
		Student student = studentService.load(id);
		StudentDto studentDto = StudentDto.getStudentDto(student);

		map.put("studentDto", studentDto);
		return "student/show";
	}

	@RequestMapping("/search/{searchTitle}/{classesId}/{teacherId}")
	public String search(ModelMap map,
			@PathVariable("searchTitle") String searchTitle,
			@PathVariable("classesId") int classesId,
			@PathVariable("teacherId") int teacherId) {
		if (searchTitle.trim().equals("")) {
			searchTitle = "";
		}
		List<Student> students = studentService.list(searchTitle, classesId,
				teacherId);
		List<Classes> classess = classesService.list();
		List<Teacher> teachers = teacherService.list();
			map.put("students", students);
			map.put("classess", classess);
			map.put("teachers", teachers);
			map.put("searchTitle", searchTitle);
		return "student/list";
	}
	@RequestMapping("/treeClasses")
	public @ResponseBody List<TreeModel> treeClasses(){
		return  classesService.generateTree();
	}
	@RequestMapping("/treeTeacher")
	public @ResponseBody List<TreeModel> treeTeacher(){
		return  teacherService.generateTree();
	}
}
