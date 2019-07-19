package com.tledu.zrz.model;

public class TreeModel {
	/**
	 * 树的id
	 */
	private int id;
	/**
	 * 用于展示的内容
	 */
	private String name;
	/**
	 * 父ID
	 */
	private int pid;
	/**
	 * 是否打开
	 */
	private boolean open;
	/**
	 * 是否是父类,主要是解决是父类但是没有子模块的时候,以文件夹形式展示
	 */
	private boolean isParent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public TreeModel(int id, String name, int pid, boolean open,
			boolean isParent) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.open = open;
		this.isParent = isParent;
	}

	public TreeModel() {
		super();
	}

}
