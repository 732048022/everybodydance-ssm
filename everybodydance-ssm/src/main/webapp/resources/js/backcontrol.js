var welcomeName;
var group1, group2, group3,group4;
$(function() {
	sessionCheck();
	if (welcomeName == null) {
		window.location.href = window.basePath + "/html/login.html";

	} else {
		document.getElementById("welcomeName").innerHTML = welcomeName;
	}
});
/**
 * 同步校验SESSION是否存在
 * 
 * @returns
 */
function sessionCheck() {
	var json = {};
	$.ajax({
		type : "POST",
		url : "login/sessionCheck",
		data : "json",
		async : false,
		success : function(data) {
			if (data.welcomeName != "") {
				welcomeName = data.welcomeName;
			}
		}
	});
}
/**
 * 用户管理
 * 
 * @returns
 */
function userManage() {
	document.getElementById("userManage").style.display = "block";
	document.getElementById("pageManage").style.display = "none";
}
/**
 * 页面管理
 * 
 * @returns
 */
function pageManage() {
	document.getElementById("userManage").style.display = "none";
	document.getElementById("pageManage").style.display = "block";
}
/**
 * 修改密码
 * 
 * @returns
 */
function updatePwd() {
	var newPwd = $("#newPwd").val();
	if (newPwd == null || newPwd == "") {
		alert("请输入新密码！");
	}
	var json = {
		"welcomeName" : welcomeName,
		"newPwd" : newPwd
	}
	$.ajax({
		type : "POST",
		url : "user/updateUser",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.success == "true") {
				alert("新密码更改成功!");
			} else {
				alert("新密码更改失败！" + data.errorMessage);
			}
		}
	});
}
/**
 * 新增用户
 * 
 * @returns
 */
function insertUser() {
	var newLoginName = $("#newLoginName").val();
	var newPassword = $("#newPassword").val();
	if (newLoginName == null || newLoginName == "") {
		alert("请输入新的管理员账号！");
	}
	if (newPassword == null || newPassword == "") {
		alert("请输入新的管理员密码！");
	}
	var json = {
		"loginName" : newLoginName,
		"password" : newPassword
	}
	$.ajax({
		type : "POST",
		url : "user/insertUser",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.success == "true") {
				alert("新管理员" + newLoginName + "创建成功!");
			} else {
				alert("新管理员创建失败！" + data.errorMessage);
			}
		}
	});
}
/**
 * 删除用户
 * 
 * @returns
 */
function deleteUser() {
	var delUserName = $("#delUserName").val();
	if (delUserName == null || delUserName == "") {
		alert("请输入需要删除的管理员账号！");
	}
	var json = {
		"delUserName" : delUserName
	}
	$.ajax({
		type : "POST",
		url : "user/deleteUser",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.success == "true") {
				alert("管理员" + delUserName + "删除成功!");
			} else {
				alert("管理员删除失败！" + data.errorMessage);
			}
		}
	});
}

/**
 * 获取分组内容
 * 
 * @returns
 */
function getGroup1() {
	group1 = $("#group1 option:selected").val();
}

/**
 * 获取分组内容
 * 
 * @returns
 */
function getGroup2() {
	group2 = $("#group2 option:selected").val();
}

/**
 * 获取分组内容
 * 
 * @returns
 */
function getGroup3() {
	group3 = $("#group3 option:selected").val();
}

/**
 * 获取分组内容
 * 
 * @returns
 */
function getGroup4() {
	group4 = $("#group4 option:selected").val();
}

/**
 * 根据ID查询标题
 * 
 * @returns
 */
function selectIdByTitle() {
	var title1 = $("#title1").val();
	if (title1 == null || title1 == "") {
		alert("请输入标题！");
		return;
	}
	if (group1 == null || group1 == "") {
		alert("请选择班级分组!");
		return;
	}
	var json = {
		"title" : title1,
		"group" : group1
	}
	$.ajax({
		type : "POST",
		url : "page/selectIdByTitle",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.success == "true") {
				alert("该视频排序为：" + data.index);
			} else {
				alert("查询异常：" + data.errorMessage);
			}
		}
	});
}

/**
 * 修改视频名称
 * 
 * @returns
 */
function updateVideo() {
	var newTitle = $("#newTitle").val();
	var index2 = $("#index2").val();
	if (newTitle == null || newTitle == "") {
		alert("请输入标题！");
		return;
	}
	if (index2 == null || index2 == "") {
		alert("请输入视频排序！");
		return;
	}
	if (group2 == null || group2 == "") {
		alert("请选择班级分组!");
		return;
	}
	var json = {
		"newtitle" : newTitle,
		"group" : group2,
		"index" : index2
	}
	$.ajax({
		type : "POST",
		url : "page/updateVideo",
		data : json,
		dataType : "json",
		success : function(data) {
			if (data.success == "true") {
				alert("该视频名字修改成功！");
			} else {
				alert("名字修改异常：" + data.errorMessage);
			}
		}
	});
}

/**
 * 新增视频
 * 
 * @returns
 */
function insertVideo() {
	var title2 = $("#title2").val();
	var index3 = $("#index3").val();
	if (title2 == null || title2 == "") {
		alert("请输入标题！");
		return;
	}
	if (index3 == null || index3 == "") {
		alert("请输入视频排序！");
		return;
	}
	if (group3 == null || group3 == "") {
		alert("请选择班级分组!");
		return;
	}
	var formData = new FormData();
	formData.append("files", $("#file")[0].files[0]);
	$.ajax({
		type : "POST",
		url : "page/insertVideo1",
		data : formData,
		contentType : false,
		processData : false,// 这个很有必要，不然不行
		dataType : "json",
		mimeType : "multipart/form-data",
		success : function(data) {
			alert(JSON.stringify(data));
			if (data.success == "true") {
				alert("该视频创建成功！");
				var path = data.videopath;
				$.ajax({
					type : "POST",
					url : "page/insertVideo2",
					data : {
						"path" : path,
						"title" : title2,
						"index" : index3,
						"group" : group3
					},
					dataType : "json",
					success : function(data) {
						if (data.success == "true") {
							alert("该视频数据入库成功！");
						} else {
							alert("该视频数据入库失败！" + data.errorMessage);
						}
					}
				})
			} else {
				alert("创建视频异常：" + data.errorMessage);
			}
		}
	});
}

function deleteVideo(){
	var index4 = $("#index4").val();
	if (index4 == null || index4 == "") {
		alert("请输入需要删除的视频下标！");
		return;
	}
	if (group4 == null || group4 == "") {
		alert("请选择班级分组!");
		return;
	}
	var json = {
			"group" : group4,
			"index" : index4
		}
		$.ajax({
			type : "POST",
			url : "page/deleteVideo",
			data : json,
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					alert("该视频删除成功！");
				} else {
					alert("删除视频异常：" + data.errorMessage);
				}
			}
		});
}