<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
 <head>
 	<title>Loan Page</title>
 </head>
 <body>
 	<nav>
 		<a href="/home">Home Page</a>
 	</nav>
 	
 	<form method="POST">
 		<label>How much did you borrow? </label><br/>
 		<input type="text" name="principal" /> <br />
 		<label>At what rate did you borrow? </label><br/>
 		<input type="text" name="roi" /> <br />
 		<label>How many years you may pay back by? </label><br/>
 		<input type="text" name="timePeriod" /> <br />
 		<button>OK</button>
 	</form>
 
 	<!--  <h4>Simple Interest is ${si }</h4>  -->
 	
 	<c:if test="${loan!=null }">
 		<table>
 			<tr><td><strong>Loan Amount</strong></td><td>${loan.principal }</td></tr>
 			<tr><td><strong>ROI</strong></td><td>${loan.roi }</td></tr>
 			<tr><td><strong>Time Period</strong></td><td>${loan.timePeriod }</td></tr>
 			<tr><td><strong>Simple Interest</strong></td><td>${loan.simpleInterest }</td></tr>
 		</table>
 	</c:if>
 </body>
</html>