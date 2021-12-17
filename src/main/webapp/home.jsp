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
	<table>
	     <form name="login" action="masterLogin" method="post">
			<tr>
			   <td>	Master username:</td>
			   <td> <input type="text" name="userName"> </td>
			 </tr>
			 <tr>  
			   <td>Password : </td>
			  <td> <input type="password" name="password"> </td>
			</tr>
			<tr colspan=2>
			 <td><input type="submit" value="login"></td>
			</tr>
		</form>
	</table>
</center>

</body>
</html>