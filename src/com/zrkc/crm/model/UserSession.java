package com.zrkc.crm.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
/**
 * 存于session中的部分用户信息
 * @author dz
 *
 */
public class UserSession implements Serializable{
	private static final long serialVersionUID = 9126610409505965130L;
	private Integer id;//主键
	private String loginName ;//登录名（账号）
	private String loginPwd ;//密码
	private String name;//用户姓名
	private Integer roleId; //角色Id
	private String status; //启用状态
	private Integer departmentId;//部门Id
	private Integer jobId;//职位ID
	private String jobName;//职位名称
	private Integer areaId;//地区ID
	
	private List<MenuModel>   menus; //菜单
	private Set<Integer> functionIds;//所有功能(权限)id的集合
	
	public UserSession() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuModel> menus) {
		this.menus = menus;
	}

	public Set<Integer> getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(Set<Integer> functionIds) {
		this.functionIds = functionIds;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
}
