$(function() {
	document.getElementById("indexbody").style.display = "block"
})

/**
 * 显示indexBody逻辑控制
 * @returns
 */
function showIndexBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="now";
	document.getElementById("gywm").className="";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="block";
	document.getElementById("aboutbody").style.display="none";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示aboutBody逻辑控制
 * @returns
 */
function showAboutBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="now";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="block";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示honorBody逻辑控制
 * @returns
 */
function showHonorBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="now";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="block";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示teacherBody逻辑控制
 * @returns
 */
function showTeacherBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="now";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="block";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示centraldebutBody逻辑控制
 * @returns
 */
function showCentraldebutBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="";
	document.getElementById("cwcd").className="now";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="none";
	document.getElementById("centraldebutbody").style.display="block";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示newctivityBody逻辑控制
 * @returns
 */
function showNewactivityBody(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="now";
	document.getElementById("lxwm").className="";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="none";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="block";
	document.getElementById("contactbody").style.display="none";
}

/**
 * 显示contactBody逻辑控制
 * @returns
 */
function showContact(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="now";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="none";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="block";
}

/**
 * 显示addressBody逻辑控制
 * @returns
 */
function showAddress(){
    /*标签修改逻辑*/
	document.getElementById("sy").className="";
	document.getElementById("gywm").className="";
	document.getElementById("cwcd").className="";
	document.getElementById("zxhd").className="";
	document.getElementById("lxwm").className="now";
	/*iframe控制逻辑*/
	document.getElementById("indexbody").style.display="none";
	document.getElementById("aboutbody").style.display="none";
	document.getElementById("centraldebutbody").style.display="none";
	document.getElementById("newactivitybody").style.display="none";
	document.getElementById("contactbody").style.display="block";
}