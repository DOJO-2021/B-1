'use strict';

//送信ボタンが押された時に確認のダイアログ
function check() {
	//確認ダイアログを表示
	if(window.confirm('この内容で送信してよろしいですか？')){
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