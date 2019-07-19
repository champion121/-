package com.tledu.zrz.service;

import java.util.List;

import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.TreeModel;

public interface IDepartmentService {
	/**
	 * 根据ID 查询一个对象
	 */
	public Department load(int id);

	public List<Department> list();

	public void update(Department dept);
	public void delete(int id);
	public void add(Department dept);
	
	/**
	 * 获取所有部门并生成树
	 * @return
	 */
	public List<TreeModel> generateTree();
}
