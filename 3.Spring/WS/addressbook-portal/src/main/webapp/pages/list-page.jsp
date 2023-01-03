<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>AddressBook - Home</title>
	</head>
	<body>
		<h3>Address Book</h3>
		<hr />
			<a href="/addContact">New Contact</a>
		<hr />
		
		<c:choose>
			<c:when test="${contacts==null }">
				<strong>Unable to read the address book.</strong>
			</c:when>
			<c:when test="${contacts.isEmpty() }">
				<strong>The address book has no contacts. Be the first to add.</strong>
			</c:when>
			<c:otherwise>
				<table style="width:80%;border:1px solid black;margin:auto; padding:5px">
					<thead>
						<tr>
							<th>Contact#</th>
							<th>Name</th>
							<th>Mobile</th>
							<th>Mail</th>
							<th>DoB</th>
							<th>Age</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${contacts }">
							<tr>
								<td>${c.contactId }</td>
								<td>${c.firstName } ${c.lastName }</td>
								<td>${c.mobile }</td>
								<td>${c.mailId }</td>
								<td>${c.dateOfBirth }</td>
								<td>${c.age } years </td>
								<td>
									<a href="/editContact?cid=${c.contactId }">EDIT</a> <span>|</span>
									<a href="/delContact?cid=${c.contactId }">DELETE</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>