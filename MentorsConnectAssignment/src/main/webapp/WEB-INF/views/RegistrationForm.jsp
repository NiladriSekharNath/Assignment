<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Validation App</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var country=$("#country").val()	;
		$('#comboboxCountry').on('change',function(){
		
		console.debug(country);
		$.ajax({
			type:'GET',
			url: 'loadStatesByCountry/'+country,
			success:function(result){
				var result=JSON.parse(result);
				
				var s='';
				for(var i=0;i<result.length;i++){
					t='';
					s+='<option value="' + result[i]+  '"> '+ result[i]+ '</option>';
				}
				$('#comboboxState').html(s);
				
			}
			
		});
		
		});
		var state=$("#state").val();
		$('#comboxState').on('change',function(){
			
			
			$.ajax({
				type:'GET',
				url: 'loadCitiesByCountryAndState/'+country+'/'+state,
				success:function(result){
					var result=JSON.parse(result);
					var s='';
					for(var i=0;i<result.length;i++){
						s+='<option value="'+result[i]+'">'+ result[i]+'</option>';
					}
					$('#comboboxCity').html(s);
				}
				
			});
			
			
		});
		
		
		});

</script>
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
			<tr>
			<td><form:radiobutton path="gender" value="M" label="Male" /> <form:radiobutton
					path="gender" value="F" label="Female" /></td>
			</tr>
			<tr>
				<th>Address</th>
				
				<td>
				<td>Country</td>
				<td>
				<form:select path="address.country" id="comboboxCountry" style="width:200px" >
						<c:forEach var="country" items="${countryList }">
							<option value="country" >${country}</option>
						</c:forEach>
					</form:select>
				 	
               </td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<form:select path="address.state" id="comboboxState" style="width:200px" label="Select a country then select a state"></form:select>
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td>
					<form:select path="address.city" id="comboboxCity" style="width:200px" label="Select a state then select a city"></form:select>
				</td>



			<td><button type="submit">Save Employee</button></td>

			</tr>
		</table>

	</form:form>
	
</body>
</html>