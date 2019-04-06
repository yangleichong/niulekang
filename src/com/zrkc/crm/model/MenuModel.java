package com.zrkc.crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 左侧下拉菜单节点
 * @author dz
 *
 */
public class MenuModel implements Serializable{
	private static final long serialVersionUID = 5982331684816959974L;
	private Integer id; //唯一标识
	private String name; // 名称
	private String url; // 超链接
	private String qitp; // 解释说明
	private Integer parentId; // 父 菜单
	private String img; // 图片地址
	private Integer exist; // 状态
	private List<MenuModel> childMenus=new ArrayList<MenuModel>();//子菜单
	
	private boolean flag;//标识是否拥有此权限
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getQitp() {
		return qitp;
	}
	public void setQitp(String qitp) {
		this.qitp = qitp;
	}
	public Integer getExist() {
		return exist;
	}
	public void setExist(Integer exist) {
		this.exist = exist;
	}
	public List<MenuModel> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<MenuModel> childMenus) {
		this.childMenus = childMenus;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}	
