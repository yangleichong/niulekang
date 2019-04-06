package com.zrkc.crm.service;

import com.zrkc.crm.model.DataModel;
import com.zrkc.crm.model.Pager;
import com.zrkc.crm.model.Role;

public interface RoleService {

	DataModel<Role> getRoleList(Pager pager);

	boolean addRole(Role role);

	Role findRoleById(Integer roleId);

	boolean updateRole(Role role);

	DataModel<Role> getRoleList(Pager pager, Role role);

}
