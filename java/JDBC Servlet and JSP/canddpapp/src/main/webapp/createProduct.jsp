<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>
	<h1>Create Product</h1>
	<form action="products" method="post">
		Name: <input type="text" name="name" /><br>
		Discription: <input type="text" name="discription" /><br>
		Price: <input type="text" name="price" /><br>
		Coupon Code: <input type="text" name="couponCode" /><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>