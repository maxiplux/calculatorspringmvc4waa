<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>
<div id="global">
 
    <h4>The product has been saved.</h4>
    
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
    
         <form action="product" method="get">
           <input id="submit" type="submit"  
                value="Add Product">
	</form>

    
</div>
</body>
</html>