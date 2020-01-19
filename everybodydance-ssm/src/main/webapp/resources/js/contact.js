			var dhwxmkDiv = document.getElementById("dhwxmk");
			var txydzmkDiv = document.getElementById("txydzmk");
			var daohanglan = document.getElementById("daohanglan");
			$(function() {

			})
			function telandav() {
				document.getElementById("dhwx").className = "now";
				document.getElementById("txydz").className = "";
				dhwxmkDiv.style.display = "block";
				txydzmkDiv.style.display = "none";
				daohanglan.innerHTML = "电话&微信";
			}

			function address() {
				document.getElementById("dhwx").className = "";
				document.getElementById("txydz").className = "now";
				dhwxmkDiv.style.display = "none";
				txydzmkDiv.style.display = "block";
				daohanglan.innerHTML = "特训营地址";
			}