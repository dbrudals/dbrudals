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
		<form action="http://${ip}:4567/submit" method="post">

			<div class="row">
				<h2>일정등록</h2>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 3px;">
					<label for="usern">사용자명</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" value="${username}" id="usern" name="usern" readonly>
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="name">일정 이름</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" id="name" name="name" placeholder="일정 이름">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="date_time">날짜, 시간</label>
				</div>
				<div style="width: 10%; float: left; margin-top: 1px;">
					<input type="datetime-local" value="${date_time}" min="${min_dt}" id="date_time" name="date_time">
				</div>
			</div>

			<div class="row">
				<div style="width: 15%; margin-top: 6px;">
					<label for="content">기타 내용</label>
				</div>
				<div style="width: 75%; margin-top: 1px;">
					<input type="text" id="content" name="content" placeholder="부가 내용">
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