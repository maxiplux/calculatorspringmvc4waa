<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/mystyle.css">
	<meta charset="ISO-8859-1">
	<title>Welcome to my Upgraded Calculator</title>
</head>
<body>

	<div id="global">
	<h4>Input the numbers: </h4>
		<c:if test="${errors != null}">
			<p id="errors">Error(s)!
			<ul>
				<c:forEach var="error" items="${errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="/result/" method="post">
			<fieldset>
				<legend>Input the number</legend>
					<input type="text" size="4" id="add1" name="add1" value="${calculator.add1}" /> + 
					<input type="text" size="4" id="add2" name="add2" value="${calculator.add2}" /> =
					<input type="text" size="8" id="sum" name="sum" value="${calculator.sum}" readonly> <br>
					
					<input type="text" size="4" id="mult1" name="mult1" value="${calculator.mult1}" /> *
					<input type="text" size="4" id="mult2" name="mult2" value="${calculator.mult2}" /> =
					<input type="text" size="8" id="product" name="product" value="${calculator.product}" readonly> <br>
					
				<p id="buttons">
					<input id="submit" type="submit" value="Submit">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>
