package cn.everybodydance.twt.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 校验页面元素
 * 
 * @author tanwentao
 *
 */
public interface AllCheckService {
	/**
	 * 校验页面元素
	 * 
	 * @param kaptchaCode 前端传入的验证码
	 * @param loginName   前端传入的用户名
	 * @param password    前端传入的密码
	 * @param request     request
	 * @return
	 */
	public Map<String, Object> allCheckService(String kaptchaCode, String loginName, String password,
			HttpServletRequest request);
}
