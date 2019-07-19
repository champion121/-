package com.tledu.zrz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tledu.zrz.dao.ITeacherDao;
import com.tledu.zrz.model.Department;
import com.tledu.zrz.model.Teacher;
import com.tledu.zrz.model.TreeModel;

@Repository("teacherDao")
public class TeacherDao extends SqlSessionDaoSupport implements ITeacherDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// -------------------------

	@Override
	public Teacher load(int id) {
		return getSqlSession().getMapper(ITeacherDao.class).load(id);
	}

	@Override
	public List<Teacher> list() {
		return getSqlSession().getMapper(ITeacherDao.class).list();

	}

	@Override
	public void update(Teacher teacher) {
		getSqlSession().getMapper(ITeacherDao.class).update(teacher);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(ITeacherDao.class).delete(id);
	}

	@Override
	public void add(Teacher teacher) {
		getSqlSession().getMapper(ITeacherDao.class).add(teacher);
	}

	@Override
	public List<Teacher> listByDeptId(int deptId) {
		return getSqlSession().getMapper(ITeacherDao.class)
				.listByDeptId(deptId);

	}

	@Override
	public List<TreeModel> generateTree() {

		List<TreeModel> deptTree = getSqlSession().selectList(
				"com.tledu.zrz.dao.ITeacherDao.generateTreeDept");
		for (TreeModel treeModel : deptTree) {
			// 设置默认打开
			treeModel.setOpen(true);
			// 设置是文件夹
			treeModel.setIsParent(true);
			// ID+10000
			treeModel.setId(treeModel.getId() + 10000);
		}
		List<TreeModel> teacherTree = getSqlSession().selectList(
				"com.tledu.zrz.dao.ITeacherDao.generateTreeTeacher");
		for (TreeModel treeModel : teacherTree) {
			int pid = treeModel.getPid() + 10000;
			treeModel.setPid(pid);
		}

		deptTree.addAll(deptTree.size(), teacherTree);
		deptTree.add(0, new TreeModel(0, "天亮教育", -1, true, true));
		return deptTree;
	}
}
