'use strict';

//送信ボタンが押された時に確認のダイアログ
function linkCheck(btn) {
	if (btn == 1) {
		href = "/Cpull/InquiryServlet";
	}

	ret = confirm('この内容で送信してよろしいですか？');
	if (ret == true) {
		location.href = href;
	}
}
