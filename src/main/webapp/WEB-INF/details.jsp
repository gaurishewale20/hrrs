<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>
<html>
<head>
<title>Welcome User!</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	background-color: #ecf5fe
}
</style>
</head>
<body>
	<div class="p-3 m-5">
		<h2 class="text-center m-5">Here's your info,
			${user_details.getName()}!</h2>

		<div class="details">
			<h4 class="mb-3">Details</h4>
			<table class="table">

				<tr>
					<td>Name :</td>
					<td>${user_details.getName()}</td>
				</tr>
				<tr>
					<td>User Id :</td>
					<td>${user_details.getUserId()}</td>
				</tr>
				<tr>
					<td>Phone :</td>
					<td>${user_details.getPhone()}</td>
				</tr>
				<tr>
					<td>Email :</td>
					<td>${user_details.getEmail()}</td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>${user_details.getGender()}</td>
				</tr>

			</table>
		</div>

	</div>


</body>
</html>
