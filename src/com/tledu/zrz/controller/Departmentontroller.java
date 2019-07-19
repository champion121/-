package com.tledu.zrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.service.IDepartmentService;
import com.tledu.zrz.service.ITeacherService;

@Controller
@RequestMapping("/dept")
public class Departmentontroller extends InitDateController {
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private ITeacherService teacherService;
	

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// --------------------

	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<Department> depts = departmentService.list();
		map.put("depts", depts);
		return "dept/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "dept/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Department dept) {
		departmentService.add(dept);
		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int id, ModelMap map) {

		Department dept = departmentService.load(id);
		map.put("dept", dept);
		return "dept/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Department dept) {
		departmentService.update(dept);
		return "redirect:list";
	}

	@RequestMapping(value = "/show")
	public String show(int id, ModelMap map) {
		Department dept = departmentService.load(id);
		List<Teacher> teachers = teacherService.listByDeptId(id);
		map.put("dept", dept);
		map.put("teachers", teachers);
		return "dept/show";
	}

	@RequestMapping(value = "/delete")
	public String delete(int id) {
		departmentService.delete(id);
		return "redirect:list";
	}
}
