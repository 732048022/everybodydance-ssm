package cn.everybodydance.twt.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.code.kaptcha.Constants;

import cn.everybodydance.twt.consts.ArbdR;
import cn.everybodydance.twt.dao.LoginCheckDao;
import cn.everybodydance.twt.service.AllCheckService;
import cn.everybodydance.twt.util.AESUtil;

/**
 * 页面元素校验的实现类
 * 
 * @author tanwentao
 *
 */
@Service
public class AllCheckServiceImpl implements AllCheckService {

	/**
	 * 日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 注入SQL查询用户名密码
	 */
	@Autowired
	private LoginCheckDao loginCheckDao;
	
	/**
	 * 后管session生命周期
	 */
	@Value("${arbd.session.livetime}")
	private String sessionLiveTime;
	
	/**
	 * 注入AES工具类
	 */
//	@Autowired
//	private AESUtil aesUtil;

	@Override
	public Map<String, Object> allCheckService(String kaptchaCode, String loginName, String password,
			HttpServletRequest request) {
		String truePassword = loginCheckDao.selectPasswordByLoginName(loginName);
		Map<String, Object> result = new HashMap<>();
		String encryptPassword=AESUtil.encrypt(password);
		String decryptPassword=AESUtil.decrypt(truePassword);
		logger.info("前端获取的密码为:{}", password);
		logger.info("数据库AES解密:{}",decryptPassword);
		logger.info("前端密码AES加密:{}",encryptPassword);
		logger.info("数据库获取的密码为:{}", truePassword);
		// 判断账号密码是否匹配
		if (!StringUtils.isEmpty(encryptPassword) && encryptPassword.equals(truePassword)) {
			logger.info("后台密码校验成功!");
			result.put("passwordIsOk", "true");
		} else {
			logger.info("后台密码校验失败!");
			result.put("passwordIsOk", "false");
		}

		// 自定义错误信息
		String errorMessage = null;
		HttpSession session = request.getSession();
		// 从sesson中获取已经生成的验证码
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (logger.isDebugEnabled()) {
			logger.info("图片验证码保存值-KAPTCHA_SESSION_VALUE:" + code + ". 输入值-INPUT kaptchaCode:" + kaptchaCode);
		}
		if (!StringUtils.hasText(kaptchaCode)) {
			errorMessage = "请输入图片验证码!";
			logger.info("errorMessage");
			result.put("verifyCodeIsOk", "false");
			result.put("errorMessage", errorMessage);
		} else if (!StringUtils.hasText(code)) {
			errorMessage = "图片验证码已过期，请刷新图片验证码!";
			logger.info(errorMessage);
			result.put("verifyCodeIsOk", "false");
			result.put("errorMessage", errorMessage);
		} else if (!kaptchaCode.equalsIgnoreCase(code)) {
			errorMessage = "输入图片验证码错误，请重新输入!";
			logger.info(errorMessage);
			result.put("verifyCodeIsOk", "false");
			result.put("errorMessage", errorMessage);
		} else {
			// 清空已验证的验证码，防止重复验证此验证码
			session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
			//将后管用户名存入session
			session.setAttribute(ArbdR.SESS_LOGIN_NAME, loginName);
			//将后管登录状态存入session
			session.setAttribute(ArbdR.SESS_LOGIN_STATUS, 1);
			//设置session存在最长时间
			session.setMaxInactiveInterval(Integer.valueOf(sessionLiveTime));
			logger.info("图片验证码验证通过");
			result.put("verifyCodeIsOk", "true");
		}

		return result;
	}

}
