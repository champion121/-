package com.tledu.zrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tledu.zrz.dto.TeacherDto;
import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.model.TreeModel;
import com.tledu.zrz.service.IDepartmentService;
import com.tledu.zrz.service.ITeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends InitDateController {
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IDepartmentService departmentService;

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	// ---------------------

	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<Teacher> teachers = teacherService.list();
		map.put("teachers", teachers);
		return "teacher/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "teacher/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TeacherDto teacherDto) {
		teacherService.add(teacherDto.getTeacher());
		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int id, ModelMap map) {

		Teacher teacher = teacherService.load(id);
		map.put("teacherDto", TeacherDto.getTeacherDto(teacher));
		return "teacher/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TeacherDto teacherDto) {
		teacherService.update(teacherDto.getTeacher());
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		teacherService.delete(id);
		return "redirect:list";
	}

	@RequestMapping("/show")
	public String show(int id, ModelMap map) {
		Teacher teacher = teacherService.load(id);
		TeacherDto teacherDto = TeacherDto.getTeacherDto(teacher);
		teacherDto.setDept_id(teacher.getDept().getId());

		map.put("teacherDto", teacherDto);
		return "teacher/show";
	}

	@RequestMapping("/treeDept")
	@ResponseBody
	public List<TreeModel> treeDept() {

		return departmentService.generateTree();
	}
}
