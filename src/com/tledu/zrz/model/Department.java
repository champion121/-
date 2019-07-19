package com.tledu.zrz.model;

import java.util.Date;

public class Department {
	private int id;
	private String type;
	/**
	 * 创建时间
	 */
	private Date come_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCome_time() {
		return come_time;
	}

	public void setCome_time(Date come_time) {
		this.come_time = come_time;
	}

	public Department(int id, String type, Date come_time) {
		super();
		this.id = id;
		this.type = type;
		this.come_time = come_time;
	}

	public Department() {
		super();
	}
}
