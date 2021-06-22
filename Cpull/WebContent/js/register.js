'use strict';

// 目のアイコンをクリックでパスワード表示非表示切り替え
function pushHideButton() {
        var txtPass = document.getElementById("textPassword");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
      }
// 新規登録画面用JavaScriptファイル
document.getElementById('form').onsubmit = function(event) {
// もしも、IDかPWが未入力なら、デフォルトの動作を行わず、「IDとPWを入力してください」と表示する
  const ID = document.getElementById('form').USER_ID.value;
  const PW = document.getElementById('form').USER_PW.value;
  const check = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,15}$/;
  if(ID === "" || PW === "") {
    event.preventDefault();
    document.getElementById('output').textContent = 'IDまたはPWが未入力です';
  } else if (check.PW === false) {
    event.preventDefault();
    document.getElementById('output').textContent = 'PWは8文字以上16文字未満かつアルファベットと数字をどちらも含むものでなくてはなりません。';
  }
};