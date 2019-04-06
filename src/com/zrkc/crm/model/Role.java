package com.zrkc.crm.model;

import java.io.Serializable;
/**
 * 角色
 * @author dz
 *
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3057852238268677943L;
	private Integer id;
	private String name;
	
	public Role() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
