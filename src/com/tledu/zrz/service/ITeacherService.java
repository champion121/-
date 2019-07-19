package com.tledu.zrz.service;

import java.util.List;

import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.model.TreeModel;

public interface ITeacherService {
	/**
	 * 根据部门ID 查询部门下所有讲师
	 */
	public List<Teacher> listByDeptId(int deptId);
	
	/**
	 * 根据ID 查询一个对象
	 */
	public Teacher load(int id);

	public List<Teacher> list();

	public void update(Teacher teacher);

	public void delete(int id);

	public void add(Teacher teacher);
	/**
	 * 获取所有部门并生成树
	 * @return
	 */
	public List<TreeModel> generateTree();
}
