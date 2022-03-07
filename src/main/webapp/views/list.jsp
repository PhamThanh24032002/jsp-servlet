<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tất cả sinh viên</title>
</head>
<body>
	<h1 style="text-align: center;"></h1>
	<a href="create">Thêm mới</a>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<p:forEach items="${list_student}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
				<td>${student.email}</td>
				<td>${student.phone}</td>
				<td>${student.status==true?'Nam':'Nữ'}</td>
				<td>
					<a href="update?id=${student.id}">Sửa</a>
					<a href="delete?id=${student.id}">Xóa</a>
				</td>
			</tr>
		</p:forEach>
	</table>
	<a href="/demo_test_one">Back to home</a>
</body>
</html>