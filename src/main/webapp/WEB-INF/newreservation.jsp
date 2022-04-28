<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="navbar.jsp"></jsp:include>
<html>
<head>
<title>New Reservation</title>

<style>
body {
	background-color: #ecf5fe;
}

.login-form {
	width: 400px;
	height: 375px;
	background-color: #6ec6ca;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}

.btn-res {
	color: #fff;
	background-color: #055b5c;
}

.btn-res:hover {
	color: #fff;
	background-color: #033030;
}
</style>

</head>

<body>

	<div class="login-form">
		<c:if test="${not empty errorMsg}">
			<div class="alert alert-danger" role="alert">${errorMsg}</div>
		</c:if>
		<c:if test="${not empty successMsg }">
			<div class="alert alert-success" role="alert">${successMsg}</div>
		</c:if>
		<div class="container-fluid">
			<form:form method="post" action="/${id}/createreservation"
				modelAttribute="reservation">
	    User Id : ${id}
	        <div class="mt-3">
					<h6>Check In Date</h6>
					<form:input type="date" class="form-control" path="checkInDate" />
				</div>
				<div class="mt-3">
					<h6>Check Out Date</h6>
					<form:input type="date" class="form-control" path="checkOutDate" />
				</div>
				<div class="mt-3">
					<h6>Room Type</h6>
					<form:input type="text" class="form-control" path="roomType"
						placeholder="Standard/Delux" />
				</div>

				<div class="mt-3">
					<form:button type="submit" class="btn btn-res btn-block mt-4">Make Reservation</form:button>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>