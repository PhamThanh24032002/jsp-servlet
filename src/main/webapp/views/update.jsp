<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa sinh viên | ${detail.name}</title>
</head>
<body>
	<h1 style="text-align: center;"></h1>
	<span style="color: red">${err}</span>
	<span style="color: green">${success}</span>
	<form method="post">	
		<input type="hidden" name="id" value="${detail.id}">Id
		<br>
		<input type="text" name="name" value="${detail.name}">Name
		<br>
		<input type="text" name="address" value="${detail.address}">Address
		<br>
		<input type="text" name="email" value="${detail.email}">Email
		<br>
		<input type="text" name="phone" value="${detail.phone}">Phone
		<br>
		<h1>Iput status</h1>
		<input type="radio" name="status" value="true" ${detail.status==true?'checked':''} >Nam
		<br>
		<input type="radio" name="status" value="false" ${detail.status==false?'checked':''}>Nữ
		<br>
		<button type="submit">Submit</button>
		<button type="reset">Reset</button>
	</form>
	<a href="view_all">Back to list</a>
</body>
</html>