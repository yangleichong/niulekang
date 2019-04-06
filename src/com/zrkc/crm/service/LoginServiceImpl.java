package com.zrkc.crm.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.zrkc.crm.dao.LoginDao;
import com.zrkc.crm.model.MenuModel;
import com.zrkc.crm.model.UserSession;
import com.zrkc.util.MD5Util;
/**
 * 
 * @author dz
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginDao loginDao;
	/**
	 * 根据帐号，密码获得用户相关信息
	 */
	@Override
	public UserSession getUserSession(String loginName, String loginPwd) {
		if(loginName != null && loginPwd != null){
			String passwordMd5 = MD5Util.getStringMD5(loginPwd);
			return loginDao.getUserSession(loginName,passwordMd5);
		}
		return null;
	}
	/**
	 * 获得此用户对应角色的菜单(功能)
	 */
	@Override
	public List<MenuModel> getMenu(UserSession userSession) {
		List<MenuModel>  menus = loginDao.findParentMenuByRoleId(userSession.getRoleId());
		for (int i = 0; i < menus.size(); i++) {
			MenuModel menu=menus.get(i);
			List<MenuModel>  childMenus = loginDao.findChildMenuRoleIdAndMenuId(userSession.getRoleId(),menu.getId());
			menu.setChildMenus(childMenus);
		}
		return menus;
	}
	/**
	 * 修改密码
	 */
	@Override
	public void updatePwd(UserSession userSession, String newPwd) {
		String newPwdMd5 = MD5Util.getStringMD5(newPwd);
		loginDao.updatePwdByLoginName(userSession.getLoginName(),newPwdMd5);
		userSession.setLoginPwd(newPwdMd5);
	}
	/**
	 * 获得用户的所有权限id
	 */
	@Override
	public Set<Integer> getFunctionIdsByRoleId(Integer roleId) {
		List<Integer> list=loginDao.getFunctionIdsByRoleId(roleId);
		Set<Integer> set=new HashSet<Integer>(list);
		return set;
	}

}
