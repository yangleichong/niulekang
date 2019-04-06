package com.zrkc.crm.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.zrkc.crm.model.MenuModel;
import com.zrkc.crm.model.UserSession;
import com.zrkc.crm.service.LoginService;
import com.zrkc.util.ModelAndViewUtil;
//import com.zrkc.utils.RandomValidateCode;
import com.zrkc.util.SessionUtil;
/**
 * 登录，登出等
 * @author dz
 *
 */
@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	/**
	 * 登录处理
	 * @param loginName
	 * @param password
	 * @param validateCode
	 * @param session
	 * @return
	 */
	@RequestMapping("/logon")
	public String logon(HttpSession session, Model model, @RequestParam(value="loginName", required=false) String loginName, @RequestParam(value="password", required=false) String upwd, @RequestParam(value="validateCode", required=false) String validateCode) {
		String errorMsg = "";
		if (SessionUtil.checkValidateCode(validateCode, session)) {//比较验证码
			//根据帐号密码查找用户
			UserSession userSession = loginService.getUserSession(loginName, upwd);
			if (userSession != null) {
				if("启用".equals(userSession.getStatus())){
					//允许登录->登录处理
					//1.获得此用户对应角色的菜单(功能)
					List<MenuModel>  menus=loginService.getMenu(userSession);
					//2.获得用户的所有权限id
					Set<Integer> functionIds=loginService.getFunctionIdsByRoleId(userSession.getRoleId());
					
					userSession.setMenus(menus);
					userSession.setFunctionIds(functionIds);
					SessionUtil.saveUserSession(session, userSession);
				
					//获得此用户对应的欢迎页面
					return "redirect:/toMain";
					//return "/jsp/main/main.jsp";
				}else{
					errorMsg = "用户已经被停用";
				}
			} else {
				errorMsg = "用户名或密码错误";
			}
		} else {
			errorMsg = "验证码错误";
		}
		model.addAttribute("errorMsg", errorMsg);
		
		return "/jsp/login/login.jsp";
	}

	/**
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping("/toMain")
	public ModelAndView toMain(){
		return new ModelAndView("/jsp/main/main.jsp");
	} 

	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		SessionUtil.logout(session);
		return "/jsp/login/login.jsp";
	}

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public ModelAndView login() {
		return ModelAndViewUtil.view("/jsp/login/login.jsp");
	}
	/**
	 * 判断用户是否登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/isLogin")
	public ModelAndView isLogin(HttpSession session) {
		UserSession userSession = SessionUtil.getUserFromSession(session);
		if (userSession != null) {//登录
			return ModelAndViewUtil.Json_ok();
		}else{//未登录
			return ModelAndViewUtil.Json_error();
		}
	}
	
	
}
