<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>PMT Application</h1>
<h2>Add user</h2>
	<table>
		<form name="addAccount" action="addUser" method="post">
		     <tr>
		         <td>Account name:</td>
		         <td><input type="text" name="accountName"></td>
		     </tr>
		     <tr>
		         <td>Password:</td>
		         <td><input type="password" name="accountPassword"></td>
		     </tr>
		     <tr>
		         <td>Account url:</td>
		         <td><input type="text" name="accountUrl"></td>
		     </tr>
		     <tr>
		         <td>Group name:</td>
		         <td><input type="text" name="groupName"></td>
		     </tr>
		     <tr>
		      <td><input type="submit" value="submit"></td>
		     </tr>
		</form>
	</table>
</center>

</body>
</html>