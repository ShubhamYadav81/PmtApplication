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
 <th>Group Id </th>
 <th>Group Name</th>
 <th>Account Name</th>
 <th>Password</th>
 <th>Account Url</th>
</tr>

 <c:forEach items="${groups}" var="group">


 <c:if test="${group.getAccount().size() != 0}">
        <c:forEach items="${group.getAccount()}" var="account">
            <tr class="table-info">
                <td><c:out value="${group.getGroupId()}"></c:out></td>
                <td><c:out value="${group.getGroupName()}"></c:out></td>
                <td><c:out value="${account.getAccountName()}"></c:out></td>
                <td><c:out value="${account.getAccountPassword()}"></c:out></td>
                <td><c:out value="${account.getAccountUrl()}"></c:out></td>
            </tr>
        </c:forEach>
    </c:if>

	
	
</c:forEach>

</table>
<a href="sucess.jsp"> Home Page</h2>
</center>

</body>
</html>
