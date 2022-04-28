<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>
<html>
<head>
<title>Welcome Admin!</title>

<style>
body {
	background-color: #ecf5fe;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="container mt-5 pt-5">

		<h3 class="mb-4">List of Past Reservations</h3>
		<table class="table table-stripped">
			<thead>
				<tr>
					<th scope="col">R_Id</th>
					<th scope="col">Booking Date</th>
					<th scope="col">Check In Date</th>
					<th scope="col">Check Out Date</th>
					<th scope="col">Room Type</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resList}" var="res">
					<tr>
						<td><c:out value="${res.reservationId}" /></td>
						<td><c:out value="${res.bookingDate}" /></td>
						<td><c:out value="${res.checkInDate}" /></td>
						<td><c:out value="${res.checkOutDate}" /></td>
						<td><c:out value="${res.roomType}" /></td>
						<c:set var="rid" value="${res.reservationId}" />
						<c:set var="id" value="${res.userId}" />
						<td><a href="/${id}/pastreservations/${rid}/delete"><button
									class="btn btn-block btn-danger text-white">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>