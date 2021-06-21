'use strict';

// テスト window.alert('こんにちは');

/* もしも、IDかPWが未入力なら、デフォルトの動作を行わず、警告ダイアログに「IDとPWを入力してください」と表示する*/
document.getElementById('form').onsubmit = function(event) {
	const id = document.getElementById('form').ID.value;
	const pw = document.getElementById('form').PW.value;
	if (id === "" || pw === ""){
			event.preventDefault();
			document.getElementById('output').textContent = 'IDとPWを入力してください!';
	}
}