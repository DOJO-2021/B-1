'use strict';

function ShowHideDiv() {
	var chkYes = document.getElementById("chkYes");
	var chkNo = document.getElementById("chkNo");
	var dvPassport = document.getElementById("dvPassport");
	dvPassport.style.display = chkYes.checked ? "block" : "none";
	dvPassport.style.display = chkNo.checked ? "block" : "none";
}