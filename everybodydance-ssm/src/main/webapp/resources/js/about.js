		var companyIntroducationDiv = document
				.getElementById("companyIntroducation");
		var honorDiv = document.getElementById("honor");
		var teacherAbilityDiv = document.getElementById("teacherAbility");
		var daohanglan = document.getElementById("daohanglan");
		$(function() {

		})
		function showCompanyIntruducation() {
			/* 点击公司简介触发事件 */
			document.getElementById("gsjj").className = "now";
			document.getElementById("ryzs").className = "";
			document.getElementById("szll").className = "";
			honorDiv.style.display = "none";
			teacherAbilityDiv.style.display = "none";
			companyIntroducationDiv.style.display = "block";
			daohanglan.innerHTML = "公司简介";
		}
		/* 点击明星导师触发事件 */
		function showTeacherAbility() {
			document.getElementById("gsjj").className = "";
			document.getElementById("ryzs").className = "";
			document.getElementById("szll").className = "now";
			companyIntroducationDiv.style.display = "none";
			teacherAbilityDiv.style.display = "block";
			honorDiv.style.display = "none";
			daohanglan.innerHTML = "明星导师";
		}
		/* 点击荣誉证书触发事件 */
		function showHonor() {
			document.getElementById("gsjj").className = "";
			document.getElementById("ryzs").className = "now";
			document.getElementById("szll").className = "";
			companyIntroducationDiv.style.display = "none";
			teacherAbilityDiv.style.display = "none";
			honorDiv.style.display = "block";
			daohanglan.innerHTML = "荣誉证书";
		}