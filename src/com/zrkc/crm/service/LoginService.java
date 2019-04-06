package com.zrkc.crm.service;

import java.util.List;
import java.util.Set;

import com.zrkc.crm.model.MenuModel;
import com.zrkc.crm.model.UserSession;

/**
 * 
 * @author dz
 *
 */
public interface LoginService {

	public UserSession getUserSession(String loginName, String upwd);

	public List<MenuModel> getMenu(UserSession userSession);

	public void updatePwd(UserSession userSession, String newPwd);

	public Set<Integer> getFunctionIdsByRoleId(Integer roleId);

}
