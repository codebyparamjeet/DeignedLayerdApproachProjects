<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">

	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="green; text-align:center;">
				Record Inserted...
			</h1>
		</c:when>
		<c:when test="${status eq 'failure' }">
			<h1 style="green; text-align:center;">
				Record Inserted Fail...
			</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color:red; text-align:center;">
				Record Insertion Failed...
			</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>