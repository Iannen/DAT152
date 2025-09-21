<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Author</title>
</head>
<body>
	<div>
		<a href="/library-l2a">Home</a>
		<p>
		<form action="addauthor" method="post">
			<table>
                <tr>
                    <td>First name:</td>
                    <td><input name="firstname" /></td>
                </tr>
                                <tr>
                    <td>Last name:</td>
                    <td><input name="lastname" /></td>
                </tr>
			</table>
			<br>
			<div>
				<input type="submit" value="Submit" name="submit">
			</div>
		</form>		
	</div>
</body>
</html>