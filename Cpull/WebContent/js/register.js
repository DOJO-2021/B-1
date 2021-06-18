'use strict';

// 未完成ファイル ID、PW、氏名、よみがな、会社名必須入力チェック

// 新規登録画面用JavaScriptファイル
// submitボタンが押されたら「クリックされました」というメッセージを表示
document.getElementById('form').onsubmit = function(event) {
// もしも、IDかPWが未入力なら、デフォルトの動作を行わず、「IDとPWを入力してください」と表示する
  const wordID = document.getElementById('form').ID.value;
  const wordPW = document.getElementById('form').PW.value;
  if(wordID == null || wordPW == null) {
  event.preventDefault();
  document.getElementById('output').textContent = `IDまたはPWが未入力です`;
  }
};