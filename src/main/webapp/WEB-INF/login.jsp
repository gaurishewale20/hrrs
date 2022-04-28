<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<style>
	
	body{
	background-image: url("${pageContext.request.contextPath}/images/hotel1.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size:cover;
	}
	
	.login-form {
		width: 400px;
		height: 350px;
		background-color: #055b5c;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-right: -50%;
		transform: translate(-50%, -50%);
		border-radius: 3px;
	}
	
	.log{background-color: #6ec6ca;}
	.log:hover{background-color: #08979d;
	color:#fff;}
	
	
	
</style>

</head>

<body>

<div> <h2 class="mt-5 pt-3 text-center text-white">Hotel Room Reservation System</h2> </div>
	<div class="d-flex justify-content-center">   
	<c:set var = "errorMsg" value = "${errMsg}"  />
    <c:if test="${fn:length(errorMsg) > 0}">
	   <div class="alert alert-danger alert-dismissible fade show" role="alert">
	 	<small>${errMsg}</small>
	 		 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	   		 <span aria-hidden="true">&times;</span>
	  		</button>
		</div>
	</c:if>
	</div>
   <div class="login-form">
   <div class="container">
    <form method="post" action="login">
        <div class="mt-5 pt-4">
        	<input type="text" class="form-control" name="userId" placeholder="User ID">
        </div>
        <div class="mt-3">
        <input type="password" class="form-control" name = "password" placeholder=" Password"/>
        </div>
       <%-- <button type="submit" class="form-control btn btn-dark btn-block mt-3 log">Login</button>
        <div class="mt-3">
       		<a href="/register" class="btn btn-success btn-block mt-3 reg">Register</a> 
        </div> --%> 
        
           <button type="submit" class="form-control btn btn-block mt-3 log">Login</button>
        <div class="mt-3">
       		<a href="/register" class="text-white text-center">Don't have an account? Click here to Register</a> 
        </div>
    </form>
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>