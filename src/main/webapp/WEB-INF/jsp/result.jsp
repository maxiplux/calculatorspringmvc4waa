<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/mystyle.css">
<meta charset="ISO-8859-1">
<title>Calculator Results</title>
</head>
<body>
	<div id="global">
	<h4>Calculator Results</h4>
	<form >
		<input name="add1" type="text" size="4" class="textBox" readonly  value="${calculator.add1}" />+
		<input name="add2" type="text" size="4" class="textBox" readonly value=<c:out value="${calculator.add2}" />>=
	    <input name="sum" type="text" size="8" class="textBoxBlue" readonly value=<c:out value="${calculator.sum}"/>>
	    
		<br> 	
		<input name="mult1" type="text" size="4" class="textBox" readonly value=<c:out value="${calculator.mult1}"/>>*
		<input name="mult2" type="text" size="4" class="textBox" readonly value=<c:out value="${calculator.mult2}"/>>=
		<input name="product" type="text" size="8" class="textBoxBlue" readonly value=<c:out value="${calculator.product}"/>>
		<br>
 		</form>
 		 <a href="calc" class="button">Try Again</a>

	</div>	
</body>
</html>