// Đảm bảo rằng bạn đã bao quanh mã của mình trong một hàm hoặc blok {} để tránh xung đột biến toàn cục
(function () {
// Khai báo ứng dụng AngularJS
var app = angular.module("myapp", ['ngSanitize']);
<<<<<<< HEAD
app.controller("myctrl", function ($scope, $http) {
=======
app.controller("myctrl", function ($scope) {
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
// Gán dữ liệu người dùng cho $scope

var selectedTende = localStorage.getItem('selectetende');



$scope.currentPage = selectedTende;




if (usersData) {
$scope.users = usersData;
// Các đoạn mã khác của bạn
} else {
console.error("usersData is not defined or null");
}



// Khởi tạo các biến và hàm điều khiển khác nếu cần
$scope.showExplanation = false;
$scope.showExplanationnd = false;
$scope.submitButtonVisible = false;

angular.forEach($scope.users, function (sv, index) {
sv.questionNumber = index + 1; // Số thứ tự bắt đầu từ 1
});
/* console.log(questionNumber)*/









$scope.check = function () {
var count = 0;
angular.forEach($scope.users, function (sv) {
if (sv.selectedAnswer === sv.kq) {
count++;
} else {
sv.isWrong = true;
}
$scope.showExplanation = true;
$scope.showExplanationnd = true;
sv.isUserAnswer = sv.selectedAnswer;
$scope.submitButtonVisible = true;
});

alert("You got " + count + " marks");
angular.forEach($scope.users, function (sv) {
angular.forEach(sv.Answers, function (ans) {
if (ans.value === sv.kq) {
ans.isCorrect = true;
}
});
});
};

$scope.exit = function (){
const localhostAddress = "http://localhost:1602/index"; // Thay thế 3000 bằng số cổng bạn đang sử dụng
window.location.href = localhostAddress;
}


<<<<<<< HEAD
$scope.captureScreenshot = async function () {
const canvas = await html2canvas(document.getElementById('quiz-form'));
const imageData = canvas.toDataURL();

try {
const response = await $http.post('/api/screenshots', imageData, {
headers: { 'Content-Type': 'text/plain' }
});

const imagePath = response.data;
if (response.status === 200) {
displayLink(imagePath);
} else {
console.error('Failed to upload screenshot');
}
} catch (error) {
console.error('Error uploading screenshot:', error);
}
};

function displayLink(imagePath) {
$scope.imagePath = imagePath;
}
=======

$scope.captureScreenshot = function () {
html2canvas(document.getElementById('quiz-form')).then(function (canvas) {
// Chuyển đổi canvas thành URL dữ liệu
var imageDataUrl = canvas.toDataURL();

// Tạo một cửa sổ hoặc tab mới để hiển thị ảnh
var newWindow = window.open();
newWindow.document.write('<img src="' + imageDataUrl + '" alt="Quiz Screenshot">');
});
};


>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051



/*var easyQuestions = usersData.filter(function(question) {
return question.cb === 2;
});

var hardQuestions = usersData.filter(function(question) {
return question.cb === 1;
});

// Lấy ngẫu nhiên 1 câu hỏi dễ và 4 câu hỏi khó
var randomEasyQuestion = easyQuestions[Math.floor(Math.random() * easyQuestions.length)];
var randomHardQuestions = [];
while (randomHardQuestions.length < 10) { var randomHardQuestion=hardQuestions[Math.floor(Math.random() *
    hardQuestions.length)]; if (!randomHardQuestions.includes(randomHardQuestion)) {
    randomHardQuestions.push(randomHardQuestion); } } // Gộp câu hỏi dễ và câu hỏi khó để hiển thị trên trang web
    $scope.filteredQuestions=[randomEasyQuestion, ...randomHardQuestions];*/ }); })();