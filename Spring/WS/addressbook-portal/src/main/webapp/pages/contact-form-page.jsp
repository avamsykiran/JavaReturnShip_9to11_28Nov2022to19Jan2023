<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<title>AddressBook - Contact Form</title>
	</head>
	<body>
		<h3>Contact Page</h3> <hr />
		<a href="/list">Home</a>
		<hr />
		
		<form:form method="POST" modelAttribute="contact" style="width:30%;margin:auto;border:1px solid black;padding:5px">
			<div>
				<form:errors path="*" />
			</div>
			<div>
				<form:label path="contactId">ContactId</form:label><br />
				<form:input path="contactId" />
			</div>
			<div>
				<form:label path="firstName">First Name</form:label><br />
				<form:input path="firstName" />
			</div>
			<div>
				<form:label path="lastName">Last Name</form:label><br />
				<form:input path="lastName" />
			</div>
			<div>
				<form:label path="mobile">Mobile</form:label><br />
				<form:input path="mobile" />
			</div>
			<div>
				<form:label path="mailId">Mail Id</form:label><br />
				<form:input path="mailId" />
			</div>
			<div>
				<form:label path="dateOfBirth">Date of birth</form:label><br />
				<form:input path="dateOfBirth" type="date" />
			</div>
			<div style="text-align:center">
				<button>SAVE</button>
			</div>
		</form:form>
	</body>
</html>