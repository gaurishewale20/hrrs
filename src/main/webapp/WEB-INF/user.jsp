<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>
<html>
<head>
<title>Welcome User!</title>

<style>
body {
	background-color: #ECF5FE;
}

.logout-btn {
	color: #fff;
	background-color: #5f0a87;
}

.logout-btn:hover {
	color: #fff;
	background-color: #2F004F;
}

.bt {
	background-color: #08979d;
	color: #fff;
}

.bt:hover {
	color: #fff;
	background-color: #055b5c;
}
</style>
</head>
<body>
	<div class="p-5 m-5">
		<h2 class="text-center mb-5">Welcome to the Site,
			${user_details.getName()}!</h2>

		<div class="d-flex justify-content-around p-2">
			<c:set var="id" value="${user_details.getId()}" />
			<%-- <button class="btn btn-outline-success p-3 my-2"><a href="/${id}/createreservation">Create Reservation</a></button>
		<button class="btn btn-outline-grey p-3 my-2"><a href="/${id}/pastreservations">View Past Reservation</a></button>
		<button class="btn btn-outline-info p-3 my-2"><a href="/${id}/details">Details</a></button>--%>

			<button class="btn bt p-3 my-2"
				onclick="location.href='/${id}/createreservation'" type="button">Create
				Reservation</button>
			<button class="btn bt p-3 my-2"
				onclick="location.href='/${id}/pastreservations'" type="button">View
				Past Reservations</button>
			<button class="btn bt p-3 my-2"
				onclick="location.href='/${id}/details'" type="button">Details</button>
			<button class="btn logout-btn p-3 my-2"
				onclick="location.href='/logout'" type="button">Logout</button>
		</div>

	</div>



</body>
</html>