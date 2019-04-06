package com.zrkc.util;

import javax.servlet.http.HttpSession;

import com.zrkc.crm.model.UserSession;
/**
 * 
 * @author dz
 *
 */
public class SessionUtil {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//放到session中的验证码key
	
	public static final String USER = "userSession";// 登录人
	
	/**
	 * 设置用户到session
	 * @param session
	 * @param user
	 */
	public static void saveUserSession(HttpSession session, UserSession userSession) {
		session.setAttribute(USER, userSession);
	}
	/**
	 * 从Session获取当前用户信息
	 * @param session
	 * @return
	 */
	public static UserSession getUserFromSession(HttpSession session) {
		Object attribute = session.getAttribute(USER);
		return attribute == null ? null : (UserSession) attribute;
	}

	/**
	 * 退出
	 * @param session
	 */
	public static void logout(HttpSession session) {
		session.removeAttribute(USER);
	}
	/**
	 * 比较验证码
	 * @param inputCode
	 * @param session
	 * @return
	 */
	public static boolean checkValidateCode(String inputCode,
			HttpSession session) {
		String valid = (String)session.getAttribute(SessionUtil.RANDOMCODEKEY);
    	if (inputCode != null && !inputCode.equals("") && inputCode.toUpperCase().equals(valid)) {
    		return true;
    	}
    	return false;
	} 


}
