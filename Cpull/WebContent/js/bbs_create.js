'use strict';

//作成ボタンが押された時に確認のダイアログ
document.getElementById("push").onclick =
function push() {
	//確認ダイアログを表示
	if(window.confirm('この内容で作成してよろしいですか？')){
		//「OK」時は送信実行
		return true;
	}
	//「キャンセル」時
	else {
		window.alert('キャンセルされました。');
		//送信中止
		return false;
	}
}


//下書きボタンが押された時に確認のダイアログ
document.getElementById("save").onclick =
function save() {
	//確認ダイアログを表示
	if(window.confirm('この内容で保存してよろしいですか？')){
		//「OK」時は送信実行
		return true;
	}
	//「キャンセル」時
	else {
		window.alert('キャンセルされました。');
		//送信中止
		return false;
	}
}

function ShowHideDiv() {
	var worry = document.getElementById("worry");
	var question = document.getElementById("question");
	var worryPass = document.getElementById("worryPass");
	var questionPass = document.getElementById("questionPass");
	worryPass.style.display = worry.checked ? "block" : "none";
	questionPass.style.display = question.checked ? "block" : "none";
}