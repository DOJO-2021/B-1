'use strict';

function ShowHideDiv() {
	var worry = document.getElementById("worry");
	var question = document.getElementById("question");
	var worryPass = document.getElementById("worryPass");
	var questionPass = document.getElementById("questionPass");
	worryPass.style.display = worry.checked ? "block" : "none";
	questionPass.style.display = question.checked ? "block" : "none";
}