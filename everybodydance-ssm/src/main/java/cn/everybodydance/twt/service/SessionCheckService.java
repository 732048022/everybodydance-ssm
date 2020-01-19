package cn.everybodydance.twt.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * SESSION校验服务（登录backcontrol.html控制）
 * 
 * @author tanwentao
 *
 */
public interface SessionCheckService {

	/**
	 * 获取session中的loginName
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> sessionCheckService(HttpServletRequest request);

}
