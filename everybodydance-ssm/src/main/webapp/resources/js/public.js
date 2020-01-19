/**
 * 艾瑞巴蒂公共JS库
 */

/*
 * 正则表达式匹配跳转页面路径
 */
window.basePath=(function(){
	var runPath=location.href.match(/[a-zA-Z0-9:._/\-]*\/html\//)[0];
	return runPath.replace("/html/","");
})();