package com.zrkc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.zrkc.crm.model.MenuModel;
import com.zrkc.crm.model.UserSession;

/**
 * 
 * @author dz
 *
 */
public interface LoginDao {
	/**
	 * 根据帐号，密码获得用户相关信息
	 * @param loginName
	 * @param upwd
	 * @return
	 */
	public UserSession getUserSession(@Param("loginName")String loginName, @Param("upwd")String upwd);
	/**
	 * 获得此角色对应的第一级菜单
	 * @param roleId
	 * @return
	 */
	public List<MenuModel> findParentMenuByRoleId(@Param("roleId")Integer roleId);
	/**
	 * 获得此角色父菜单下的子菜单
	 * @param roleId
	 * @param functionId
	 * @return
	 */
	public List<MenuModel> findChildMenuRoleIdAndMenuId(@Param("roleId")Integer roleId,@Param("functionId")Integer functionId);
	/**
	 * 修改密码
	 * @param loginName
	 * @param newPwd
	 */
	@Update("update comp_user set login_pwd=#{newPwd} where login_name = #{loginName}")
	public void updatePwdByLoginName(@Param("loginName")String loginName, @Param("newPwd")String newPwd);
	/**
	 * 获得用户的所有权限id
	 * @param roleId
	 * @return
	 */
	public List<Integer> getFunctionIdsByRoleId(@Param("roleId")Integer roleId);

}
