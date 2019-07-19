package com.tledu.zrz.dao;

import java.util.List;

import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.TreeModel;

public interface IClassesDao {
	/**
	 * 根据ID 查询一个对象
	 */
	public Classes load(int id);

	public List<Classes> list();

	public void update(Classes classes);
	public void delete(int id);
	public void add(Classes classes);

	/**
	 * 获取所有部门并生成树
	 * @return
	 */
	public List<TreeModel> generateTree();
}
