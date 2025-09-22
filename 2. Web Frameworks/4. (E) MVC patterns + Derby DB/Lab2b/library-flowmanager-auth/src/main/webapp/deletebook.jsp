<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
</head>
<body>
	<a href="/library-l2a">Home</a>
		<p>
		<form action="deletebook?isbn=${book.isbn}" method="post">
			<table>
				<tr>
					<td>ISBN:${book.isbn}</td>
				</tr>
				<tr>
					<td>Title:${book.title}</td>
				</tr>
				<tr>
					<td>Author:${author.firstname} ${author.lastname}</td>
				</tr>
			</table>
			<br>
			<div>
				<input type="submit" value="Delete" name="submit">
			</div>
		</form>		
</body>
</html>