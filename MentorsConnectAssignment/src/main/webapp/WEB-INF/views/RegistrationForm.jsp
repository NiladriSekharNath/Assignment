<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form:form action="saveEmployee" method="post" modelAttribute="employee">
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th>Company Name</th>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<th>Contact No.</th>
				<td><form:input path="contactNo" type="Number" /></td>
			</tr>
			<tr>
				<th>Gender
			</tr>
			<td><form:radiobutton path="gender" value="M" label="Male" /> <form:radiobutton
					path="gender" value="F" label="Female" /></td>
			</tr>
			<tr>
				<th>Address</th>
				<td>
				<form:select path="address" >
				<form:option path="address.country" value="NONE" label="country" />
				<form:options items="${countryList}" />
				<form:option path="address.state" value="NONE" label="state" />
				<form:options items="${stateList}" />
				<form:option path="address.city" value="NONE" label="city" />
				<form:options items="${cityList}" />
				 </form:select>   	
               </td>
			</tr>



			<td><button type="submit">Save Employee</button></td>

			</tr>
		</table>

	</form:form>
	<p style="color: red">${Message}</p>
</body>
</html>