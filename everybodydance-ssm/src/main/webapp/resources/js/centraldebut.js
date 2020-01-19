	var womanClassDiv=document.getElementById("womanClass");
	var girlClassDiv=document.getElementById("girlClass");
	var childClassDiv=document.getElementById("childClass");
	var geniusClassDiv=document.getElementById("geniusClass");
	var daohanglan=document.getElementById("daohanglan");
	$(function() {

	})
	
	/*点击女神班触发事件*/
	function showWomanClass(){
		document.getElementById("nsb").className="now";
		document.getElementById("nwb").className="";
		document.getElementById("ynb").className="";
		document.getElementById("tfb").className="";
		womanClassDiv.style.display="block";
		girlClassDiv.style.display="none";
		childClassDiv.style.display="none";
		geniusClassDiv.style.display="none";
		daohanglan.innerHTML="女神班";
	}
	
	/*点击女王班触发事件*/
	function showWomanClass(){
		document.getElementById("nsb").className="";
		document.getElementById("nwb").className="now";
		document.getElementById("ynb").className="";
		document.getElementById("tfb").className="";
		womanClassDiv.style.display="none";
		girlClassDiv.style.display="block";
		childClassDiv.style.display="none";
		geniusClassDiv.style.display="none";
		daohanglan.innerHTML="女王班";
	}
	
	/*点击艺能班触发事件*/
	function showWomanClass(){
		document.getElementById("nsb").className="";
		document.getElementById("nwb").className="";
		document.getElementById("ynb").className="now";
		document.getElementById("tfb").className="";
		womanClassDiv.style.display="none";
		girlClassDiv.style.display="none";
		childClassDiv.style.display="block";
		geniusClassDiv.style.display="none";
		daohanglan.innerHTML="艺能班";
	}
	
	/*点击天赋班触发事件*/
	function showWomanClass(){
		document.getElementById("nsb").className="";
		document.getElementById("nwb").className="";
		document.getElementById("ynb").className="";
		document.getElementById("tfb").className="now";
		womanClassDiv.style.display="none";
		girlClassDiv.style.display="none";
		childClassDiv.style.display="none";
		geniusClassDiv.style.display="block";
		daohanglan.innerHTML="天赋班";
	}