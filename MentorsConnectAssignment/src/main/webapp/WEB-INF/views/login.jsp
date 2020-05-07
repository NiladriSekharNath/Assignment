<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Validation App</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	
	<h2>User Input From</h2>
	
	<hr />
	<form:form action="saveUser" method="post" modelAttribute="user">
		<table>
			<tr>
				<th>UserName</th>
				<td><form:input path="userName" /> <form:errors path="userName"
						cssClass="error" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><form:input path="password" type="password" /> <form:errors path="password"
						cssClass="error" /></td>
			
			
				<td><button type="submit">Login</button></td>
				
			</tr>
		</table>
		
	</form:form>
	<p style="color:red">
	${Message}
	</p>
</body>
</html>