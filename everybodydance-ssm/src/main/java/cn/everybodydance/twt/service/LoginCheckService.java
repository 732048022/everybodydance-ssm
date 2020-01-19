package cn.everybodydance.twt.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断页面是否已经登录
 * 
 * @author tanwentao
 *
 */
public interface LoginCheckService {
	/**
	 * 从session取用户登录的状态值
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> loginCheckService(HttpServletRequest request);
}
