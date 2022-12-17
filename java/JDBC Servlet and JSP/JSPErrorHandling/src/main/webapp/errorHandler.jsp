<!-- isErrorPage：これをtureにすることで、このJSPページに例外を引き渡すことができるようにする -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<P>Sorry,an error has occurd</P>
	<%= exception.getMessage() %>
</body>
</html>