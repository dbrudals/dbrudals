<!DOCTYPE html>
<html>
<head>
<style>
* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 15px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: left;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>

	<div class="container">
		<!--<form action="/action_page.php">-->
		<form action="http://localhost:4567/submit" method="post">

			<div class="row">
				<h2>일정등록</h2>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 3px;">
					<label for="user">사용자명</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" value= id="user" name="user" placeholder="사용자명 계정">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="content">일정 이름</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" id="content" name="content" placeholder="일정 이름">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="date">날짜, 시간</label>
				</div>
				<div style="width: 10%; float: left; margin-top: 1px;">
					<input type="date" id="date" name="date">
				</div>
				<div style="width: 30%; margin-top: 1px;">
					<input type="time" id="time" name="time">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="subject">기타 내용</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" id="subject" name="subject" placeholder="부가 내용">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label>알림 형식</label>
				</div>

				<div style="width: 10%; float: left; margin-top: 1px;">
					<label for="checkbox">TTS 포함 여부</label>
				</div>
				<div style="width: 5%; float: left; margin-top: 19px;">
					<input type="checkbox" id="checkbox" name="checkbox">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>

</body>
</html>