package com.zrkc.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zrkc.crm.dao.RoleDao;
import com.zrkc.crm.model.DataModel;
import com.zrkc.crm.model.Pager;
import com.zrkc.crm.model.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;
	/**
	 * 获得角色列表的相关数据
	 */
	@Override
	public DataModel<Role> getRoleList(Pager pager) {
		//1.创建DataModel类型对象
		DataModel<Role> data =new DataModel<Role>();
		//2.查数据
		//(1)分页查询角色列表
		List<Role> list=roleDao.findRole(pager);
		//(2)获得角色总数
		int totalNum=roleDao.countRole();
		//3.把数据放入DataModel类型对象
		data.setRows(list);
		pager.setTotalRecord(totalNum);
		data.setPager(pager);
		return data;
	}
	/**
	 * 新建角色
	 */
	@Override
	public boolean addRole(Role role) {
		try {
			roleDao.addRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 根据roleId获得角色信息
	 */
	@Override
	public Role findRoleById(Integer roleId) {
		return roleDao.findRoleById(roleId);
	}
	/**
	 * 修改角色
	 */
	@Override
	public boolean updateRole(Role role) {
		try {
			roleDao.updateRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据搜索条件获得角色列表的相关数据
	 */
	@Override
	public DataModel<Role> getRoleList(Pager pager, Role role) {
		//1.创建DataModel类型对象
		DataModel<Role> data =new DataModel<Role>();
		//2.查数据
		//(1)根据搜索条件分页查询角色列表
		List<Role> list=roleDao.findRole2(pager,role);
		//(2)根据搜索条件获得符合条件角色数目
		int totalNum=roleDao.countRole2(role);
		//3.把数据放入DataModel类型对象
		data.setRows(list);
		pager.setTotalRecord(totalNum);
		data.setPager(pager);
		return data;
	}

}
