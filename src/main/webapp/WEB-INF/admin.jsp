<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
	<title>Welcome Admin!</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     
     <style>
     
     a{text-decoration:none;}
     
     a:hover{
     border-bottom:0.5px solid #fff;
     }
     
     .logout-btn{
     color:#fff;
     background-color:#5f0a87;
     }
     
     .logout-btn:hover{
     color:#fff;
     background-color:#2F004F;
     }
     
     .ad-heading{
     color:#2F004F;
     }
     </style>

</head>
<body>
	<div class="m-5 px-5 text-center">
	<div class="d-flex justify-content-between">	
	<h2 class="ad-heading">Welcome to the Site, Admin!</h2>

	<button class="btn logout-btn p-3 my-2" onclick="location.href='/logout'" type="button">Logout</button>
	</div>
	
	
	<h3 class="pb-3">List of Users</h3>
	<table class ="table table-stripped mt-2">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Phone</th>
				<th scope="col">Email</th>
				<th scope="col">Gender</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items = "${userList}" var="user">
			<tr>
				<td><c:out value="${user.userId}"/></td>
				<td><c:out value="${user.name}"/></td>
				<td><c:out value="${user.phone}"/></td>
				<td><c:out value="${user.email}"/></td>
				<td><c:out value="${user.gender}"/></td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br><br>
	<h3 class="pb-3">List of Reservations</h3>
	<table class ="table table-stripped mt-2">
		<thead>
			<tr>
				<th scope="col">R_Id</th>
				<th scope="col">User_Id</th>
				<th scope="col">Booking Date</th>
				<th scope="col">Check In Date</th>
				<th scope="col">Check Out Date</th>
				<th scope="col">Room Type</th>		
				<th></th>	
			</tr>
		</thead>
		<tbody>
		<c:forEach items = "${resList}" var="res">
			<tr>
				<td><c:out value="${res.reservationId}"/></td>
				<td><c:out value="${res.userId}"/></td>
				<td><c:out value="${res.bookingDate}"/></td>
				<td><c:out value="${res.checkInDate}"/></td>
				<td><c:out value="${res.checkOutDate}"/></td>
				<td><c:out value="${res.roomType}"/></td>
				<c:set var = "rid" value = "${res.reservationId}"  />	
				<td><button class="btn btn-block btn-danger text-white" onclick="location.href='/${id}/pastreservations/${rid}/delete'" type="button">Delete</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</body>
</html>