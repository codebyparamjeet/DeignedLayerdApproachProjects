<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${status eq 'success'}">
			<h1 style="color:green; text-align:center;">Record Successfully deleted</h1>
		</c:when>
		<c:when test="${status eq 'failed' }">
			<h1 style="color:red; text-align:center;">Record Deletion failed to happpen</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color:red; text-align:center;">Record not found in DB</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>