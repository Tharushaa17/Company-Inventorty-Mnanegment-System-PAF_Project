<%@page import="com.Buyers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Registration</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.js"></script>
<script src="Components/Buyer.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<div class="container"><div class="row"><div class="col-6">
	
		<h1>Buyer Management</h1>
		
				<form id="formBuyer" name="formBuyer">
				
						Frist Name:
						<input id="FristName" name="FristName" type="text" class="form-control form-control-sm">
						
						<br>Last Name:
						<input id=">LastName" name=">LastName" type="text" class="form-control form-control-sm">
						
						<br>Username:
						<input id="Username" name="Username" type="text" class="form-control form-control-sm">
						
						<br>Mobile Nu:
						<input id="MobileNu" name="MobileNu" type="text" class="form-control form-control-sm">
						
						<br>Email:
						<input id="Email" name="Email" type="text" class="form-control form-control-sm">
						
						<br>Address:
						<input id="Address" name="Address" type="text" class="form-control form-control-sm">
						
						<br>Password:
						<input id="Password" name="Password" type="Password" class="form-control form-control-sm">
						<br>
						
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
					
				</form>
				
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			<br>
		<div id="divBuyersGrid">
			<%
			Buyers BuyerObj = new Buyers();
			out.print(BuyerObj.readBuyers());
			%>
</div>
</div> </div> </div>
</body>
</html>