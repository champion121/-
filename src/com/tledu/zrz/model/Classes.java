package com.tledu.zrz.model;

import java.util.Date;

public class Classes {

	private int id;
	private String className;
	/**
	 * 开班日期
	 */
	private Date come_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Classes(int id, String className, Date come_time) {
		super();
		this.id = id;
		this.className = className;
		this.come_time = come_time;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

	public Classes() {
		super();
	}

}
