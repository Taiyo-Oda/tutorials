<!-- JSPページ内でJavaBeanを使用する -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Ditails</title>
</head>
<body>
	<!-- Product.javaをBeanとして使用する。 -->
	<jsp:useBean id="product" class="com.bharath.trainings.jsp.Product">
		<jsp:setProperty name="product" property="*" />
	</jsp:useBean>
	
	<!-- Beanにセットした値を取得して、出力を行う -->
	Product Ditails
	<br />Id:<jsp:getProperty property="id" name="product"/>
	<br />Name:<jsp:getProperty property="name" name="product"/>
	<br />Description:<jsp:getProperty property="description" name="product"/>
	<br />Price:<jsp:getProperty property="price" name="product"/>

</body>
</html>