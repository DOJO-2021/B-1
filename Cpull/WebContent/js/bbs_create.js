'use strict';

//作成ボタンが押された時に確認のダイアログ
function /* onSubmit="return 〇〇()"の〇〇 */ () {
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
function /* onSubmit="return 〇〇()"の〇〇 */ () {
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
