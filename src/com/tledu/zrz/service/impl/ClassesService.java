package com.tledu.zrz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.zrz.dao.IClassesDao;
import com.tledu.zrz.model.Classes;
import com.tledu.zrz.model.TreeModel;
import com.tledu.zrz.service.IClassesService;

@Service("classesService")
public class ClassesService implements IClassesService {

	@Autowired
	private IClassesDao classesDao;

	public IClassesDao getClassesDao() {
		return classesDao;
	}

	public void setClassesDao(IClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	// --------------

	@Override
	public Classes load(int id) {
		return classesDao.load(id);
	}

	@Override
	public List<Classes> list() {
		return classesDao.list();
	}

	@Override
	public void update(Classes classes) {
		classesDao.update(classes);
	}

	@Override
	public void delete(int id) {
		classesDao.delete(id);
	}

	@Override
	public void add(Classes classes) {
		classesDao.add(classes);
	}

	@Override
	public List<TreeModel> generateTree() {
		return classesDao.generateTree();
	}
}
