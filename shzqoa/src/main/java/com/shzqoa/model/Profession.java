package com.shzqoa.model;

import java.io.Serializable;

public class Profession implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** id */
	private String id;
	/** 技术方向名称 */
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}