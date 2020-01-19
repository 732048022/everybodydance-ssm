//欢迎页面提示用户信息
var welcomeName;
$(function() {
	checkLogin();
});

//登录校验
function validateLogin() {
	var loginName = $("#username").val();
	var password = $("#password").val();
	// 对输入值进行编码，避免验证码收尾输入空格，提交到后台自动消失
	var kaptchaCode = encodeURI($("#kaptchaCode").val().trim());
	if ((loginName == "") || (loginName == "请输入用户名")) {
		alert("请输入用户名!");
		return false;
	}

	if ((password == "") || (password == "请输入密码")) {
		alert("请输入密码!");
		return false;
	}
	if ((kaptchaCode == "") || (kaptchaCode == "请输入验证码")) {
		alert("请输入验证码!");
		return false;
	}

	var json = {
		"loginName" : loginName,
		"password" : password,
		"kaptchaCode" : kaptchaCode
	}
	if (kaptchaCode != "") {
		$.ajax({
			type : "POST",
			url : "code/allCheck",
			data : json,
			dataType : "json",
			async:false,
			success : function(data) {
				if (data.passwordIsOk == "true"
						&& data.verifyCodeIsOk == "true") {
					sessionStorage.setItem("welcomeName",loginName);
					window.location.href=window.basePath+"/html/backcontrol.html";
				} else if (data.passwordIsOk == "false") {
					alert("很抱歉！密码输入有误!");
				} else if (data.verifyCodeIsOk == "false") {
					alert(data.errorMessage);
				}
			}
		})
	}
}

//会话检查，如果SESSION没失效自动跳转
function checkLogin() {
	var json = {}
	$.ajax({
		type : "POST",
		url : "login/loginCheck",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.loginStatus == "1" && data.loginName != "") {
				window.location.href=window.basePath+"/html/backcontrol.html";
			}
		}
	})
}

