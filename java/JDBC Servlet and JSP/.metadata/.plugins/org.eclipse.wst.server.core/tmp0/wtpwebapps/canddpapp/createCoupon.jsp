<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
</head>
<body>
	<h1>Create Coupon</h1>
	<form action="coupons" method="post">
		CouponCode: <input type="text" name="couponCode" /><br>
		Discount: <input type="text" name="discount" /><br>
		Expiry Date: <input type="text" name="expiryDate" /><br>
		<input type="hidden" name="action" value="create"/>
		<input type="submit" value="Save" />
	</form>
</body>
</html>