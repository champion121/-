package com.tledu.zrz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zrz.dao.IDepartmentDao;
import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.TreeModel;
import com.tledu.zrz.service.IDepartmentService;

@Service("departmentService")
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentDao deptDao;

	public IDepartmentDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(IDepartmentDao deptDao) {
		this.deptDao = deptDao;
	}

	// ------------------------------

	@Override
	public Department load(int id) {
		return deptDao.load(id);
	}

	@Override
	public List<Department> list() {
		return deptDao.list();
	}

	@Override
	public void update(Department dept) {
		deptDao.update(dept);
	}

	@Override
	public void delete(int id) {
		deptDao.delete(id);
	}

	@Override
	public void add(Department dept) {
		deptDao.add(dept);
	}

	@Override
	public List<TreeModel> generateTree() {
		return deptDao.generateTree();
	}
}
