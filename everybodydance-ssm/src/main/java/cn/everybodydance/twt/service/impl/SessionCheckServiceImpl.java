package cn.everybodydance.twt.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.everybodydance.twt.consts.ArbdR;
import cn.everybodydance.twt.service.SessionCheckService;

@Service
public class SessionCheckServiceImpl implements SessionCheckService {
	/**
	 * 日志类
	 */
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Map<String, Object> sessionCheckService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> result = new HashMap<>();
		String welcomeName;
		try {
			String loginName = session.getAttribute(ArbdR.SESS_LOGIN_NAME).toString();
			logger.info("后管页面SESSION中存在登录用户名信息,SESS_LOGIN_NAME:{},即将跳转至后管页面......", loginName);
			welcomeName = loginName;
		} catch (NullPointerException e) {
			logger.info("后管页面SESSION中无用户登录信息，即将跳转至登录页面......");
			welcomeName = "";
		}
		result.put("welcomeName", welcomeName);
		return result;
	}

}
