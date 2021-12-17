<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>PMT Application</h1>
<table border=1>
<tr>
 <th>Id</th>
 <th>User Name</th>
 <th>Url</th>
 <th>Password</th>
</tr>


<tr>
 <td> <c:out value="${user.getAccountId()}" ></c:out> </td>
 <td> <c:out value="${user.getAccountName()}" ></c:out> </td>
 <td> <c:out value="${user.getAccountUrl()}" ></c:out> </td>
 <td> <c:out value="${user.getAccountPassword()}" ></c:out> </td>
</tr>

</table>
<a href="sucess.jsp"> Home Page</h2>
</center>

</body>
</html>