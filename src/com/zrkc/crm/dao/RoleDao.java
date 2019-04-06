package com.zrkc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zrkc.crm.model.Pager;
import com.zrkc.crm.model.Role;

public interface RoleDao {
	/**
	 * 分页查询角色列表
	 * @param pager
	 * @return
	 */
	List<Role> findRole(@Param("pager")Pager pager);
	/**
	 * 获得角色总数
	 * @return
	 */
	int countRole();
	/**
	 * 新建角色
	 * @param role
	 */
	void addRole(@Param("role")Role role);
	/**
	 * 根据roleId获得角色信息
	 * @param roleId
	 * @return
	 */
	Role findRoleById(@Param("roleId")Integer roleId);
	/**
	 * 修改角色
	 * @param role
	 */
	void updateRole(@Param("role")Role role);
	/**
	 * 根据搜索条件分页查询角色列表
	 * @param pager
	 * @param role
	 * @return
	 */
	List<Role> findRole2(@Param("pager")Pager pager, @Param("role")Role role);
	/**
	 * 根据搜索条件获得符合条件角色数目
	 * @param role
	 * @return
	 */
	int countRole2(@Param("role")Role role);

}
