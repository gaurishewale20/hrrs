<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
.login-form {
	width: 400px;
	height: 425px;
	background-color: #055b5c;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}

.reg {
	background-color: #ecf5fe;
}

.reg:hover {
	background-color: #6ec6ca;
	color: #fff;
}

.reg-form-heading {
	color: #055b5c;
}
</style>

</head>

<body>
	<h4 class="mt-5 pt-4 text-center reg-form-heading">Registration Form</h4>
	<div class="login-form">
		<c:if test="${not empty errorMsg}">
			<div class="alert alert-danger" role="alert">${errorMsg}</div>
		</c:if>
		<c:if test="${not empty successMsg }">
			<div class="alert alert-success" role="alert">${successMsg}</div>
		</c:if>
		<div class="container-fluid">

			<form:form method="post" action="register" modelAttribute="user">
				<div class="mt-3">
					<form:input type="text" class="form-control" path="userId"
						placeholder="User name" />
				</div>
				<div class="mt-3">
					<form:input type="password" class="form-control" path="password"
						placeholder=" Password" />
				</div>
				<div class="mt-3">
					<form:input type="text" class="form-control" path="name"
						placeholder="Name" />
				</div>
				<div class="mt-3">
					<form:input type="email" class="form-control" path="email"
						placeholder="Email" />
				</div>
				<div class="mt-3">
					<form:input type="number" class="form-control" path="phone"
						placeholder=" Phone" />
				</div>
				<div class="mt-3">
					<form:input type="text" class="form-control" path="gender"
						placeholder="M/F" />
				</div>



				<div class="mt-3">
					<form:button type="submit" class="btn btn-block mt-3 reg">Register</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>