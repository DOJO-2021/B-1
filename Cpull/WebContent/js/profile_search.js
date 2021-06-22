'use strict';

 //テスト window.alert('こんにちは');

function sort(num) {
	if (num == 0){
		document.getElementById("prof_name").style.display = "none";
		document.getElementById("prof_birthday").style.display = "none";
	}
	else if (num ==1){
		document.getElementById("prof_regist").style.display = "none";
		document.getElementById("prof_birthday").style.display = "none";
	}
	else {
		document.getElementById("prof_regist").style.display = "none";
		document.getElementById("prof_name").style.display = "none";

	}

}