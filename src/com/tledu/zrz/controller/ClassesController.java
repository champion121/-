package com.tledu.zrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.Student;
import com.tledu.zrz.service.IClassesService;
import com.tledu.zrz.service.IStudentService;

@Controller
@RequestMapping("/classes")
public class ClassesController extends InitDateController {

	@Autowired
	private IClassesService classesService;
	@Autowired
	private IStudentService studentService;

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public IClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(IClassesService classesService) {
		this.classesService = classesService;
	}

	// -------------

	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<Classes> classess = classesService.list();
		map.put("classess", classess);
		return "classes/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "classes/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Classes classes) {
		System.out.println("===========");
		classesService.add(classes);
		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int id, ModelMap map) {

		Classes classes = classesService.load(id);
		map.put("classes", classes);
		return "classes/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Classes classes) {
		classesService.update(classes);
		return "redirect:list";
	}

	@RequestMapping(value = "/show")
	public String show(int id, ModelMap map) {
		Classes classes = classesService.load(id);
		List<Student> students = studentService.ListByClassId(id);
		map.put("classes", classes);
		map.put("students", students);

		return "classes/show";
	}

	@RequestMapping(value = "/delete")
	public String show(int id) {
		classesService.delete(id);
		return "redirect:list";
	}
}
