<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới sinh viên</title>
</head>
<body>
	<h1 style="text-align: center;"></h1>
	<span style="color: red">${err}</span>
	<span style="color: green">${success}</span>
	<form method="post">	
		<input type="text" name="name">Name
		<br>
		<input type="text" name="address">Address
		<br>
		<input type="text" name="email">Email
		<br>
		<input type="text" name="phone">Phone
		<br>
		<h1>Iput status</h1>
		<input type="radio" name="status" value="true" checked="checked">Nam
		<br>
		<input type="radio" name="status" value="false">Nữ
		<br>
		<button type="submit">Submit</button>
		<button type="reset">Reset</button>
	</form>
	<a href="view_all">Back to list</a>
</body>
</html>