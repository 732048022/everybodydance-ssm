package cn.everybodydance.twt.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.everybodydance.twt.consts.ArbdR;
import cn.everybodydance.twt.service.LoginCheckService;

/**
 * 
 * @author tanwentao
 *
 */
@Service
public class LoginCheckServiceImpl implements LoginCheckService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Map<String, Object> loginCheckService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> result = new HashMap<>();
		String loginStatus, loginName;
		try {
			loginStatus = session.getAttribute(ArbdR.SESS_LOGIN_STATUS).toString();
			logger.info("登录页面SESSION中存在登录状态信息,SESS_LOGIN_STATUS:{}", loginStatus);
		} catch (NullPointerException e) {
			logger.info("登录页面SESSION中无登录状态信息......");
			loginStatus = "";
		}
		result.put("loginStatus", loginStatus);
		if (!loginStatus.isEmpty()) {
			try {
				loginName = session.getAttribute(ArbdR.SESS_LOGIN_NAME).toString();
				logger.info("登录页面SESSION中存在登录用户名信息,SESS_LOGIN_NAME:{}", loginName);
			} catch (NullPointerException e) {
				logger.info("登录页面SESSION中无登录用户名信息......");
				loginName = "";
			}
			result.put("loginName", loginName);
			return result;
		}
		return result;
	}

}
