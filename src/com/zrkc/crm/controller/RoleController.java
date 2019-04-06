package com.zrkc.crm.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrkc.crm.model.DataModel;
import com.zrkc.crm.model.Pager;
import com.zrkc.crm.model.Role;
import com.zrkc.crm.service.RoleService;

/**
 * 角色
 * @author dz
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource(name="roleService")
	private RoleService roleService;
	
//	@RequestMapping("")
//	public ModelAndView getRoleList(Pager pager){
//		//获得角色列表的相关数据
//		DataModel<Role> data=roleService.getRoleList(pager);
//		//创建ModelAndView对象
//		ModelAndView mav=new ModelAndView("/jsp/role/roleList.jsp");
//		//把数据放入ModelAndView
//		mav.addObject("roleList", data.getRows());
//		mav.addObject("pager", data.getPager());
//		return mav;
//	}
	
	/**
	 * 角色列表(支持搜索)
	 * @param pager
	 * @param role
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView getRoleList(Pager pager,Role role){
		//根据搜索条件获得角色列表的相关数据
		DataModel<Role> data=roleService.getRoleList(pager,role);
		//创建ModelAndView对象
		ModelAndView mav=new ModelAndView("/jsp/role/roleList.jsp");
		//把数据放入ModelAndView
		mav.addObject("roleList", data.getRows());
		mav.addObject("pager", data.getPager());
		mav.addObject("role", role);
		return mav;
	}
	/**
	 * 跳转到新建角色页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAddRole(){
		return new ModelAndView("/jsp/role/roleAdd.jsp");
	}
	/**
	 * 新建角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView addRole(Role role){
		//调service新建角色
		boolean flag=roleService.addRole(role);
		//创建ModelAndView对象
		ModelAndView mav=new ModelAndView("/jsp/role/roleAdd.jsp");
		mav.addObject("mess", flag?"新建成功":"新建失败");
		
		return mav;
	}
	/**
	 * 跳转到修改角色页面
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdateRole(Integer roleId){
		//1.根据roleId获得角色信息
		Role role=roleService.findRoleById(roleId);
		//2.创建ModelAndView对象
		ModelAndView mav=new ModelAndView("/jsp/role/roleAdd.jsp");
		//3.把角色信息放入mav
		mav.addObject("role", role);
		return mav;
	}
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView updateRole(Role role){
		//1.修改角色
		boolean flag=roleService.updateRole(role);
		//2.创建ModelAndView对象
		ModelAndView mav=new ModelAndView("toUpdate?roleId="+role.getId());
		//3.添加提示
		mav.addObject("mess", flag?"修改成功":"修改失败");
		
		return mav;
		
	}
	

}
