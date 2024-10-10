<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>User Registration Form</title>
<style>
.wrapper {
	margin: auto;
	width: 60%;
	margin-top: 100px;
	border-radius: 10px;
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1), -3px -3px 3px
		rgba(0, 0, 0, 0.1), 3px -3px 3px rgba(0, 0, 0, 0.1), -3px 3px 3px
		rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="wrapper border p-2">
		<h2 align="center">User Registration Form</h2>
		<h4 align="center">
			<a href="${pageContext.request.contextPath}/users">List All Users</a>
		</h4>
		<!-- form -->
		<form action="users?action=insert" class="mt-5" method="post">
			<div class="row">
				<div class="col-sm-6">
					<input type="text" name="firstName" class="form-control"
						placeholder="First Name">
				</div>
				<div class="col-sm-6">
					<input type="text" name="lastName" class="form-control"
						placeholder="Last Name">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-sm-12">
					<input type="email" name="email" class="form-control"
						placeholder="Your Email">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-sm-12">
					<input type="email" name="re-email" class="form-control"
						placeholder="Re-enter Email">
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-sm-12">
					<input type="password" name="password" class="form-control"
						placeholder="New Password">
				</div>
			</div>
			<div class="row mt-2">
				<label class="text-secondary m-1">BirthDay</label>
				<div class="col-sm-2">
					<select name="day" class="form-control">
						<option value="0">Day</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>
				</div>
				<div class="col-sm-2">
					<select name="month" class="form-control">
						<option value="0">Month</option>
						<option value="01">Tháng 1</option>
						<option value="02">Tháng 2</option>
						<option value="03">Tháng 3</option>
						<option value="04">Tháng 4</option>
						<option value="05">Tháng 5</option>
						<option value="06">Tháng 6</option>
						<option value="07">Tháng 7</option>
						<option value="08">Tháng 8</option>
						<option value="09">Tháng 9</option>
						<option value="10">Tháng 10</option>
						<option value="11">Tháng 11</option>
						<option value="12">Tháng 12</option>
					</select>
				</div>
				<div class="col-sm-2">
					<select name="year" class="form-control">
						<option value="0">Year</option>
						<option value="2024">2024</option>
						<option value="2023">2023</option>
						<option value="2022">2022</option>
						<option value="2021">2021</option>
						<option value="2020">2020</option>
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
						<option value="2007">2007</option>
						<option value="2006">2006</option>
						<option value="2005">2005</option>
						<option value="2004">2004</option>
						<option value="2003">2003</option>
						<option value="2002">2002</option>
						<option value="2001">2001</option>
						<option value="2000">2000</option>
					</select>

				</div>
			</div>

			<div class="row mt-2">
				<div class="col-sm-3 d-flex">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="female" value="female" checked="checked"> <label
							class="form-check-label" for="female">Female</label>
					</div>
					<div class="form-check mx-4">
						<input class="form-check-input" type="radio" name="gender"
							id="male" value="male"> <label class="form-check-label"
							for="male">Male</label>
					</div>
				</div>
			</div>

			<div class="row mt-2">
				<div class="col-sm-12">
					<button class="btn btn-primary form-control" type="submit"
						value="Save">Sign Up</button>
				</div>
			</div>
		</form>
		<!-- form -->
	</div>
</body>
</html>