package com.zrkc.crm.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2874850144173242778L;
	private Integer id;
	private String name;
	private String code;
	private Date createTime;
	
	public Product() {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void setCreateTime2(String createTime) throws ParseException {
		if(createTime!=null && !"".equals(createTime)){
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			this.createTime=dateFormat.parse(createTime);
		}
	}

}
